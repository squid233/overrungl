/*
 * MIT License
 *
 * Copyright (c) 2024-2025 Overrun Organization
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 */

package overrungl.gen

import com.palantir.javapoet.TypeName

enum class AllocatorRequirement {
    NO,
    STACK,
    BY_VALUE_SEGMENT_ALLOCATOR,
    SEGMENT_ALLOCATOR,
    ARENA;

    fun stricter(other: AllocatorRequirement): AllocatorRequirement {
        return if (other > this) other else this
    }
}

data class DowncallMethod(
    val returnType: CustomTypeSpec,
    val name: String,
    val parameters: List<DowncallParameter>,
    val entrypoint: String?,
    val code: String?,
    val overload: Boolean,
    val optional: Boolean,
) {
    val allocatorRequirement: AllocatorRequirement by lazy {
        parameters.map { p ->
            p.type.allocatorRequirement
        }.reduceOrNull(AllocatorRequirement::stricter) ?: AllocatorRequirement.NO
    }
    val functionDescriptor: String by lazy {
        buildString {
            append("FunctionDescriptor.of")
            if (returnType.carrier == TypeName.VOID) {
                append("Void")
            }
            append("(")
            if (returnType.carrier != TypeName.VOID) {
                append(returnType.layout)
                if (parameters.isNotEmpty()) {
                    append(", ")
                }
            }
            append(parameters.filter { it.type.layout != null }.joinToString { it.type.layout!! })
            append(")")
        }
    }

    fun overload(
        name: String = this.name,
        parameters: List<DowncallParameter> = this.parameters,
    ): DowncallMethod = copy(
        name = name,
        parameters = parameters,
        overload = true,
    )

    private fun <T> List<T>.insertFirst(t: T): List<T> {
        return toMutableList().also { it.addFirst(t) }
    }

    fun insertArena(): DowncallMethod {
        return let { it.overload(parameters = it.parameters.insertFirst(DowncallParameter(arena, "arena"))) }
    }
}

data class DowncallParameter(
    val type: CustomTypeSpec,
    val name: String,
    val ref: Boolean = false
) {
    fun ref(): DowncallParameter = copy(ref = true)

    fun marshalRef(overload: Boolean): Boolean = ref && type.selectTypeName(overload) != MemorySegment_

    fun toString(typeName: TypeName): String {
        return buildString {
            if (ref) {
                append("@Out ")
            }
            append(type.typeNameWithC(typeName))
            append(" ")
            append(name)
        }
    }
}
