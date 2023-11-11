/*
 * MIT License
 *
 * Copyright (c) 2023 Overrun Organization
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

/* note: adding a new extension
 * you need to add the extension in glExtCaps::caps
 */

package overrungl.opengl

import overrungl.opengl.OpenGLExt.*
import java.nio.file.Files
import kotlin.io.path.Path

enum class OpenGLExt(val dir: String, val packageName: String, val extName: String) {
    CORE("", "", ""),
    ARB("ext/arb/", ".ext.arb", "ARB"),
    KHR("ext/khr/", ".ext.khr", "KHR"),
    OES("ext/oes/", ".ext.oes", "OES"),
    `3DFX`("ext/", ".ext", "3DFX"),
    AMD("ext/amd/", ".ext.amd", "AMD"),
    APPLE("ext/apple/", ".ext.apple", "APPLE"),
    ATI("ext/ati/", ".ext.ati", "ATI"),
    EXT("ext/ext/", ".ext.ext", "EXT"),
    GREMEDY("ext/", ".ext", "GREMEDY"),
    HP("ext/", ".ext", "HP"),
    IBM("ext/ibm/", ".ext.ibm", "IBM"),
    INGR("ext/", ".ext", "INGR"),
    INTEL("ext/intel/", ".ext.intel", "INTEL"),
    MESAX("ext/mesa/", ".ext.mesa", "MESAX"),
    MESA("ext/mesa/", ".ext.mesa", "MESA"),
    NVX("ext/nv/", ".ext.nv", "NVX"),
    NV("ext/nv/", ".ext.nv", "NV"),
    OML("ext/", ".ext", "OML"),
    OVR("ext/", ".ext", "OVR"),
    PGI("ext/", ".ext", "PGI"),
    REND("ext/", ".ext", "REND"),
    S3("ext/", ".ext", "S3"),
    SGIS("ext/sgi/", ".ext.sgi", "SGIS"),
    SGIX("ext/sgi/", ".ext.sgi", "SGIX"),
    SGI("ext/sgi/", ".ext.sgi", "SGI"),
    SUNX("ext/sun/", ".ext.sun", "SUNX"),
    SUN("ext/sun/", ".ext.sun", "SUN"),
    WIN("ext/", ".ext", "WIN")
}

data class Type(val name: String, val layout: String?) {
    operator fun invoke(name: String, nativeType: String? = null): Parameter = Parameter(this, name, nativeType)
    override fun toString(): String = name
}

const val fileHeader = """/*
 * MIT License
 *
 * Copyright (c) 2022-present Overrun Organization
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

// This file is auto-generated. DO NOT EDIT!"""

private val generatedFunctions = ArrayList<Function>()
private val generatedExtFunctions = ArrayList<Function>()
private val generatedClasses = ArrayList<OpenGLFile>()
private val generatedExtClasses = ArrayList<OpenGLFile>()

val void = Type("void", null)
val boolean = Type("boolean", "JAVA_BYTE")
val byte = Type("byte", "JAVA_BYTE")
val short = Type("short", "JAVA_SHORT")
val int = Type("int", "JAVA_INT")
val long = Type("long", "JAVA_LONG")
val float = Type("float", "JAVA_FLOAT")
val double = Type("double", "JAVA_DOUBLE")
val address = Type("MemorySegment", "ADDRESS")

val arena = Type("Arena", null)

val GLboolean = boolean
val GLbyte = byte
val GLubyte = byte
val GLshort = short
val GLushort = short
val GLint = int
val GLuint = int
val GLfixed = int
val GLsizei = int
val GLenum = int
val GLintptr = long
val GLsizeiptr = long
val GLbitfield = int
val GLfloat = float
val GLclampf = float
val GLdouble = double
val GLclampd = double
val GLchar = byte
val GLint64 = long
val GLuint64 = long

val GLsizeiptrARB = long
val GLintptrARB = long
val GLhandleARB = int // Don't know how to handle on APPLE
val GLcharARB = byte
val GLint64EXT = long
val GLuint64EXT = long

data class Parameter(
    val type: Type,
    val name: String,
    val nativeType: String?
)

data class Function(
    val name: String,
    val returnType: Type = void,
    val nativeType: String?,
    val params: List<Parameter>,
    val content: String? = null
) {
    private val _overloads = ArrayList<Function>()
    val overloads: List<Function>
        get() = _overloads

    operator fun invoke(action: Function.() -> Unit) {
        action()
    }

    operator fun String.invoke(returnType: Type, content: String, vararg params: Parameter, nativeType: String? = null) {
        _overloads.add(Function(this, returnType, nativeType, params.toList(), content))
    }
}

class OpenGLFile(
    val name: String,
    val ext: OpenGLExt,
    private val extName: String
) {
    private val constants = LinkedHashMap<String, String>()
    private val functions = ArrayList<Function>()
    val hasFunction: Boolean
        get() = functions.isNotEmpty()

    operator fun String.invoke(value: String) {
        constants[this] = value
    }

    operator fun String.invoke(returnType: Type, vararg params: Parameter, nativeType: String? = null): Function =
        Function(this, returnType, nativeType, params.toList()).also {
            functions.add(it)
            when (ext) {
                CORE -> generatedFunctions.add(it)
                else -> generatedExtFunctions.add(it)
            }
        }

    internal fun generate() {
        Files.writeString(Path("${ext.dir}GL${ext.extName}$name.java"), buildString {
            // file-header
            appendLine(
                """
                ${fileHeader.prependIndent("|")}
                |package overrungl.opengl${ext.packageName};

                |import overrungl.*;
                |import overrungl.opengl.*;
                |import java.lang.foreign.*;
                |import static java.lang.foreign.FunctionDescriptor.*;
                |import static java.lang.foreign.ValueLayout.*;
                |import static overrungl.opengl.GLLoader.*;

                |/**
                | * {@code $extName}
                | */
                |public final class GL${ext.extName}$name {
            """.trimMargin()
            )
            // constants
            constants.forEach { (name, value) ->
                appendLine("    public static final int $name = $value;")
            }
            if (functions.isNotEmpty()) {
                // loader
                appendLine("    public static void load(GLExtCaps ext, GLLoadFunc load) {")
                appendLine("        if (!ext.$extName) return;")
                functions.forEach { f ->
                    append("        ext.${f.name} = load.invoke(\"${f.name}\", ${if (f.returnType == void) "ofVoid" else "of"}(")
                    if (f.returnType != void)
                        append(f.returnType.layout)
                    f.params.forEachIndexed { index, it ->
                        if (index != 0 || f.returnType != void) append(", ")
                        append(it.type.layout)
                    }
                    appendLine("));")
                }
                appendLine("    }")
                appendLine()
                // functions
                fun appendFuncHeader(f: Function) {
                    append("    public static ")
                    if (f.nativeType != null)
                        append("@NativeType(\"${f.nativeType}\") ")
                    append("${f.returnType} ${f.name}(")
                    f.params.forEachIndexed { index, it ->
                        if (index != 0) append(", ")
                        if (it.nativeType != null)
                            append("@NativeType(\"${it.nativeType}\") ")
                        append("${it.type} ${it.name}")
                    }
                    appendLine(") {")
                }
                functions.forEach { f ->
                    appendFuncHeader(f)
                    appendLine("        final var ext = getExtCapabilities();")
                    appendLine("        try {")
                    if (f.returnType != void)
                        appendLine("            return (${f.returnType})")
                    append("            check(ext.${f.name}).invokeExact(")
                    f.params.forEachIndexed { index, it ->
                        if (index != 0) append(", ")
                        append(it.name)
                    }
                    appendLine(
                        """);
                    |        } catch (Throwable e) { throw new AssertionError("should not reach here", e); }
                    |    }
                """.trimMargin()
                    )
                    appendLine()

                    // overloads
                    if (f.overloads.isNotEmpty()) {
                        f.overloads.forEach { overload ->
                            appendFuncHeader(overload)
                            appendLine(overload.content!!.prependIndent("        "))
                            appendLine("    }\n")
                        }
                    }
                }
            }
            appendLine("}")
        })
    }
}

fun file(
    name: String,
    ext: OpenGLExt = CORE,
    extName: String = "GL",
    block: OpenGLFile.() -> Unit
) {
    OpenGLFile(name, ext, extName).also {
        block(it)
        when (ext) {
            CORE -> generatedClasses.add(it)
            else -> generatedExtClasses.add(it)
        }
    }.generate()
}

fun file(
    name: String,
    ext: OpenGLExt = CORE,
    extName: String = "GL",
    vararg const: Pair<String, String>
) {
    file(name, ext, extName) {
        const.forEach { (name, value) -> name(value) }
    }
}

fun arb() {
    file("ES32Compatibility", ARB, "GL_ARB_ES3_2_compatibility") {
        "GL_PRIMITIVE_BOUNDING_BOX_ARB"("0x92BE")
        "GL_MULTISAMPLE_LINE_WIDTH_RANGE_ARB"("0x9381")
        "GL_MULTISAMPLE_LINE_WIDTH_GRANULARITY_ARB"("0x9382")
        "glPrimitiveBoundingBoxARB"(
            void,
            GLfloat("minX"),
            GLfloat("minY"),
            GLfloat("minZ"),
            GLfloat("minW"),
            GLfloat("maxX"),
            GLfloat("maxY"),
            GLfloat("maxZ"),
            GLfloat("maxW")
        )
    }
    file("BindlessTexture", ARB, "GL_ARB_bindless_texture") {
        "GL_UNSIGNED_INT64_ARB"("0x140F")
        "glGetTextureHandleARB"(GLuint64, GLuint("texture"))
        "glGetTextureSamplerHandleARB"(GLuint64, GLuint("texture"), GLuint("sampler"))
        "glMakeTextureHandleResidentARB"(void, GLuint64("handle"))
        "glMakeTextureHandleNonResidentARB"(void, GLuint64("handle"))
        "glGetImageHandleARB"(
            GLuint64,
            GLuint("texture"),
            GLint("level"),
            GLboolean("layered"),
            GLint("layer"),
            GLenum("format")
        )
        "glMakeImageHandleResidentARB"(void, GLuint64("handle"), GLenum("access"))
        "glMakeImageHandleNonResidentARB"(void, GLuint64("handle"))
        "glUniformHandleui64ARB"(void, GLint("location"), GLuint64("value"))
        "glUniformHandleui64vARB"(void, GLint("location"), GLsizei("count"), address("value", "const GLuint64 *"))
        "glProgramUniformHandleui64ARB"(void, GLuint("program"), GLint("location"), GLuint64("value"))
        "glProgramUniformHandleui64vARB"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("values", "const GLuint64 *")
        )
        "glIsTextureHandleResidentARB"(GLboolean, GLuint64("handle"))
        "glIsImageHandleResidentARB"(GLboolean, GLuint64("handle"))
        "glVertexAttribL1ui64ARB"(void, GLuint("index"), GLuint64EXT("x"))
        "glVertexAttribL1ui64vARB"(void, GLuint("index"), address("v", "const GLuint64EXT *"))
        "glGetVertexAttribLui64vARB"(void, GLuint("index"), GLenum("pname"), address("params", "GLuint64EXT *"))
    }
    file("CLEvent", ARB, "GL_ARB_cl_event") {
        "GL_SYNC_CL_EVENT_ARB"("0x8240")
        "GL_SYNC_CL_EVENT_COMPLETE_ARB"("0x8241")
        "glCreateSyncFromCLeventARB"(
            address,
            address("context", "struct _cl_context *"),
            address("event", "struct _cl_event *"),
            GLbitfield("flags"),
            nativeType = "GLsync"
        )
    }
    file("ColorBufferFloat", ARB, "GL_ARB_color_buffer_float") {
        "GL_RGBA_FLOAT_MODE_ARB"("0x8820")
        "GL_CLAMP_VERTEX_COLOR_ARB"("0x891A")
        "GL_CLAMP_FRAGMENT_COLOR_ARB"("0x891B")
        "GL_CLAMP_READ_COLOR_ARB"("0x891C")
        "GL_FIXED_ONLY_ARB"("0x891D")
        "glClampColorARB"(void, GLenum("target"), GLenum("clamp"))
    }
    file("ComputeVariableGroupSize", ARB, "GL_ARB_compute_variable_group_size") {
        "GL_MAX_COMPUTE_VARIABLE_GROUP_INVOCATIONS_ARB"("0x9344")
        "GL_MAX_COMPUTE_FIXED_GROUP_INVOCATIONS_ARB"("0x90EB")
        "GL_MAX_COMPUTE_VARIABLE_GROUP_SIZE_ARB"("0x9345")
        "GL_MAX_COMPUTE_FIXED_GROUP_SIZE_ARB"("0x91BF")
        "glDispatchComputeGroupSizeARB"(
            void,
            GLuint("num_groups_x"),
            GLuint("num_groups_y"),
            GLuint("num_groups_z"),
            GLuint("group_size_x"),
            GLuint("group_size_y"),
            GLuint("group_size_z")
        )
    }
    file("DebugOutput", ARB, "GL_ARB_debug_output") {
        "GL_DEBUG_OUTPUT_SYNCHRONOUS_ARB"("0x8242")
        "GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH_ARB"("0x8243")
        "GL_DEBUG_CALLBACK_FUNCTION_ARB"("0x8244")
        "GL_DEBUG_CALLBACK_USER_PARAM_ARB"("0x8245")
        "GL_DEBUG_SOURCE_API_ARB"("0x8246")
        "GL_DEBUG_SOURCE_WINDOW_SYSTEM_ARB"("0x8247")
        "GL_DEBUG_SOURCE_SHADER_COMPILER_ARB"("0x8248")
        "GL_DEBUG_SOURCE_THIRD_PARTY_ARB"("0x8249")
        "GL_DEBUG_SOURCE_APPLICATION_ARB"("0x824A")
        "GL_DEBUG_SOURCE_OTHER_ARB"("0x824B")
        "GL_DEBUG_TYPE_ERROR_ARB"("0x824C")
        "GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR_ARB"("0x824D")
        "GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR_ARB"("0x824E")
        "GL_DEBUG_TYPE_PORTABILITY_ARB"("0x824F")
        "GL_DEBUG_TYPE_PERFORMANCE_ARB"("0x8250")
        "GL_DEBUG_TYPE_OTHER_ARB"("0x8251")
        "GL_MAX_DEBUG_MESSAGE_LENGTH_ARB"("0x9143")
        "GL_MAX_DEBUG_LOGGED_MESSAGES_ARB"("0x9144")
        "GL_DEBUG_LOGGED_MESSAGES_ARB"("0x9145")
        "GL_DEBUG_SEVERITY_HIGH_ARB"("0x9146")
        "GL_DEBUG_SEVERITY_MEDIUM_ARB"("0x9147")
        "GL_DEBUG_SEVERITY_LOW_ARB"("0x9148")
        "glDebugMessageControlARB"(
            void,
            GLenum("source"),
            GLenum("type"),
            GLenum("severity"),
            GLsizei("count"),
            address("ids", "const GLuint *"),
            GLboolean("enabled")
        )
        "glDebugMessageInsertARB"(
            void,
            GLenum("source"),
            GLenum("type"),
            GLuint("id"),
            GLenum("severity"),
            GLsizei("length"),
            address("buf", "const GLchar *")
        )
        ("glDebugMessageCallbackARB"(
            void,
            address("callback", "GLDEBUGPROCARB"),
            address("userParam", "const void *")
        )) {
            "glDebugMessageCallbackARB"(
                void,
                "glDebugMessageCallbackARB(callback.address(arena), userParam);",
                arena("arena"),
                Type("GLDebugProc", null)("callback"),
                address("userParam", "const void *")
            )
        }
        "glGetDebugMessageLogARB"(
            GLuint,
            GLuint("count"),
            GLsizei("bufSize"),
            address("sources", "GLenum *"),
            address("types", "GLenum *"),
            address("ids", "GLuint *"),
            address("severities", "GLenum *"),
            address("lengths", "GLsizei *"),
            address("messageLog", "GLchar *")
        )
    }
    file(
        "DepthTexture", ARB, "GL_ARB_depth_texture",
        "GL_DEPTH_COMPONENT16_ARB" to "0x81A5",
        "GL_DEPTH_COMPONENT24_ARB" to "0x81A6",
        "GL_DEPTH_COMPONENT32_ARB" to "0x81A7",
        "GL_TEXTURE_DEPTH_SIZE_ARB" to "0x884A",
        "GL_DEPTH_TEXTURE_MODE_ARB" to "0x884B"
    )
    file("DrawBuffers", ARB, "GL_ARB_draw_buffers") {
        "GL_MAX_DRAW_BUFFERS_ARB"("0x8824")
        "GL_DRAW_BUFFER0_ARB"("0x8825")
        "GL_DRAW_BUFFER1_ARB"("0x8826")
        "GL_DRAW_BUFFER2_ARB"("0x8827")
        "GL_DRAW_BUFFER3_ARB"("0x8828")
        "GL_DRAW_BUFFER4_ARB"("0x8829")
        "GL_DRAW_BUFFER5_ARB"("0x882A")
        "GL_DRAW_BUFFER6_ARB"("0x882B")
        "GL_DRAW_BUFFER7_ARB"("0x882C")
        "GL_DRAW_BUFFER8_ARB"("0x882D")
        "GL_DRAW_BUFFER9_ARB"("0x882E")
        "GL_DRAW_BUFFER10_ARB"("0x882F")
        "GL_DRAW_BUFFER11_ARB"("0x8830")
        "GL_DRAW_BUFFER12_ARB"("0x8831")
        "GL_DRAW_BUFFER13_ARB"("0x8832")
        "GL_DRAW_BUFFER14_ARB"("0x8833")
        "GL_DRAW_BUFFER15_ARB"("0x8834")
        "glDrawBuffersARB"(void, GLsizei("n"), address("bufs", "const GLenum *"))
    }
    file("DrawBuffersBlend", ARB, "GL_ARB_draw_buffers_blend") {
        "glBlendEquationiARB"(void, GLuint("buf"), GLenum("mode"))
        "glBlendEquationSeparateiARB"(void, GLuint("buf"), GLenum("modeRGB"), GLenum("modeAlpha"))
        "glBlendFunciARB"(void, GLuint("buf"), GLenum("src"), GLenum("dst"))
        "glBlendFuncSeparateiARB"(
            void,
            GLuint("buf"),
            GLenum("srcRGB"),
            GLenum("dstRGB"),
            GLenum("srcAlpha"),
            GLenum("dstAlpha")
        )
    }
    file("DrawInstanced", ARB, "GL_ARB_draw_instanced") {
        "glDrawArraysInstancedARB"(void, GLenum("mode"), GLint("first"), GLsizei("count"), GLsizei("primcount"))
        "glDrawElementsInstancedARB"(
            void,
            GLenum("mode"),
            GLsizei("count"),
            GLenum("type"),
            address("indices", "const void *"),
            GLsizei("primcount")
        )
    }
    file("FragmentProgram", ARB, "GL_ARB_fragment_program") {
        "GL_FRAGMENT_PROGRAM_ARB"("0x8804")
        "GL_PROGRAM_FORMAT_ASCII_ARB"("0x8875")
        "GL_PROGRAM_LENGTH_ARB"("0x8627")
        "GL_PROGRAM_FORMAT_ARB"("0x8876")
        "GL_PROGRAM_BINDING_ARB"("0x8677")
        "GL_PROGRAM_INSTRUCTIONS_ARB"("0x88A0")
        "GL_MAX_PROGRAM_INSTRUCTIONS_ARB"("0x88A1")
        "GL_PROGRAM_NATIVE_INSTRUCTIONS_ARB"("0x88A2")
        "GL_MAX_PROGRAM_NATIVE_INSTRUCTIONS_ARB"("0x88A3")
        "GL_PROGRAM_TEMPORARIES_ARB"("0x88A4")
        "GL_MAX_PROGRAM_TEMPORARIES_ARB"("0x88A5")
        "GL_PROGRAM_NATIVE_TEMPORARIES_ARB"("0x88A6")
        "GL_MAX_PROGRAM_NATIVE_TEMPORARIES_ARB"("0x88A7")
        "GL_PROGRAM_PARAMETERS_ARB"("0x88A8")
        "GL_MAX_PROGRAM_PARAMETERS_ARB"("0x88A9")
        "GL_PROGRAM_NATIVE_PARAMETERS_ARB"("0x88AA")
        "GL_MAX_PROGRAM_NATIVE_PARAMETERS_ARB"("0x88AB")
        "GL_PROGRAM_ATTRIBS_ARB"("0x88AC")
        "GL_MAX_PROGRAM_ATTRIBS_ARB"("0x88AD")
        "GL_PROGRAM_NATIVE_ATTRIBS_ARB"("0x88AE")
        "GL_MAX_PROGRAM_NATIVE_ATTRIBS_ARB"("0x88AF")
        "GL_MAX_PROGRAM_LOCAL_PARAMETERS_ARB"("0x88B4")
        "GL_MAX_PROGRAM_ENV_PARAMETERS_ARB"("0x88B5")
        "GL_PROGRAM_UNDER_NATIVE_LIMITS_ARB"("0x88B6")
        "GL_PROGRAM_ALU_INSTRUCTIONS_ARB"("0x8805")
        "GL_PROGRAM_TEX_INSTRUCTIONS_ARB"("0x8806")
        "GL_PROGRAM_TEX_INDIRECTIONS_ARB"("0x8807")
        "GL_PROGRAM_NATIVE_ALU_INSTRUCTIONS_ARB"("0x8808")
        "GL_PROGRAM_NATIVE_TEX_INSTRUCTIONS_ARB"("0x8809")
        "GL_PROGRAM_NATIVE_TEX_INDIRECTIONS_ARB"("0x880A")
        "GL_MAX_PROGRAM_ALU_INSTRUCTIONS_ARB"("0x880B")
        "GL_MAX_PROGRAM_TEX_INSTRUCTIONS_ARB"("0x880C")
        "GL_MAX_PROGRAM_TEX_INDIRECTIONS_ARB"("0x880D")
        "GL_MAX_PROGRAM_NATIVE_ALU_INSTRUCTIONS_ARB"("0x880E")
        "GL_MAX_PROGRAM_NATIVE_TEX_INSTRUCTIONS_ARB"("0x880F")
        "GL_MAX_PROGRAM_NATIVE_TEX_INDIRECTIONS_ARB"("0x8810")
        "GL_PROGRAM_STRING_ARB"("0x8628")
        "GL_PROGRAM_ERROR_POSITION_ARB"("0x864B")
        "GL_CURRENT_MATRIX_ARB"("0x8641")
        "GL_TRANSPOSE_CURRENT_MATRIX_ARB"("0x88B7")
        "GL_CURRENT_MATRIX_STACK_DEPTH_ARB"("0x8640")
        "GL_MAX_PROGRAM_MATRICES_ARB"("0x862F")
        "GL_MAX_PROGRAM_MATRIX_STACK_DEPTH_ARB"("0x862E")
        "GL_MAX_TEXTURE_COORDS_ARB"("0x8871")
        "GL_MAX_TEXTURE_IMAGE_UNITS_ARB"("0x8872")
        "GL_PROGRAM_ERROR_STRING_ARB"("0x8874")
        "GL_MATRIX0_ARB"("0x88C0")
        "GL_MATRIX1_ARB"("0x88C1")
        "GL_MATRIX2_ARB"("0x88C2")
        "GL_MATRIX3_ARB"("0x88C3")
        "GL_MATRIX4_ARB"("0x88C4")
        "GL_MATRIX5_ARB"("0x88C5")
        "GL_MATRIX6_ARB"("0x88C6")
        "GL_MATRIX7_ARB"("0x88C7")
        "GL_MATRIX8_ARB"("0x88C8")
        "GL_MATRIX9_ARB"("0x88C9")
        "GL_MATRIX10_ARB"("0x88CA")
        "GL_MATRIX11_ARB"("0x88CB")
        "GL_MATRIX12_ARB"("0x88CC")
        "GL_MATRIX13_ARB"("0x88CD")
        "GL_MATRIX14_ARB"("0x88CE")
        "GL_MATRIX15_ARB"("0x88CF")
        "GL_MATRIX16_ARB"("0x88D0")
        "GL_MATRIX17_ARB"("0x88D1")
        "GL_MATRIX18_ARB"("0x88D2")
        "GL_MATRIX19_ARB"("0x88D3")
        "GL_MATRIX20_ARB"("0x88D4")
        "GL_MATRIX21_ARB"("0x88D5")
        "GL_MATRIX22_ARB"("0x88D6")
        "GL_MATRIX23_ARB"("0x88D7")
        "GL_MATRIX24_ARB"("0x88D8")
        "GL_MATRIX25_ARB"("0x88D9")
        "GL_MATRIX26_ARB"("0x88DA")
        "GL_MATRIX27_ARB"("0x88DB")
        "GL_MATRIX28_ARB"("0x88DC")
        "GL_MATRIX29_ARB"("0x88DD")
        "GL_MATRIX30_ARB"("0x88DE")
        "GL_MATRIX31_ARB"("0x88DF")
        "glProgramStringARB"(
            void,
            GLenum("target"),
            GLenum("format"),
            GLsizei("len"),
            address("string", "const void *")
        )
        "glBindProgramARB"(void, GLenum("target"), GLuint("program"))
        "glDeleteProgramsARB"(void, GLsizei("n"), address("programs", "const GLuint *"))
        "glGenProgramsARB"(void, GLsizei("n"), address("programs", "GLuint *"))
        "glProgramEnvParameter4dARB"(
            void,
            GLenum("target"),
            GLuint("index"),
            GLdouble("x"),
            GLdouble("y"),
            GLdouble("z"),
            GLdouble("w")
        )
        "glProgramEnvParameter4dvARB"(void, GLenum("target"), GLuint("index"), address("params", "const GLdouble *"))
        "glProgramEnvParameter4fARB"(
            void,
            GLenum("target"),
            GLuint("index"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z"),
            GLfloat("w")
        )
        "glProgramEnvParameter4fvARB"(void, GLenum("target"), GLuint("index"), address("params", "const GLfloat *"))
        "glProgramLocalParameter4dARB"(
            void,
            GLenum("target"),
            GLuint("index"),
            GLdouble("x"),
            GLdouble("y"),
            GLdouble("z"),
            GLdouble("w")
        )
        "glProgramLocalParameter4dvARB"(void, GLenum("target"), GLuint("index"), address("params", "const GLdouble *"))
        "glProgramLocalParameter4fARB"(
            void,
            GLenum("target"),
            GLuint("index"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z"),
            GLfloat("w")
        )
        "glProgramLocalParameter4fvARB"(void, GLenum("target"), GLuint("index"), address("params", "const GLfloat *"))
        "glGetProgramEnvParameterdvARB"(void, GLenum("target"), GLuint("index"), address("params", "GLdouble *"))
        "glGetProgramEnvParameterfvARB"(void, GLenum("target"), GLuint("index"), address("params", "GLfloat *"))
        "glGetProgramLocalParameterdvARB"(void, GLenum("target"), GLuint("index"), address("params", "GLdouble *"))
        "glGetProgramLocalParameterfvARB"(void, GLenum("target"), GLuint("index"), address("params", "GLfloat *"))
        "glGetProgramivARB"(void, GLenum("target"), GLenum("pname"), address("params", "GLint *"))
        "glGetProgramStringARB"(void, GLenum("target"), GLenum("pname"), address("string", "void *"))
        "glIsProgramARB"(GLboolean, GLuint("program"))
    }
    file(
        "FragmentShader", ARB, "GL_ARB_fragment_shader",
        "GL_FRAGMENT_SHADER_ARB" to "0x8B30",
        "GL_MAX_FRAGMENT_UNIFORM_COMPONENTS_ARB" to "0x8B49",
        "GL_FRAGMENT_SHADER_DERIVATIVE_HINT_ARB" to "0x8B8B"
    )
    file("GeometryShader4", ARB, "GL_ARB_geometry_shader4") {
        "GL_LINES_ADJACENCY_ARB"("0x000A")
        "GL_LINE_STRIP_ADJACENCY_ARB"("0x000B")
        "GL_TRIANGLES_ADJACENCY_ARB"("0x000C")
        "GL_TRIANGLE_STRIP_ADJACENCY_ARB"("0x000D")
        "GL_PROGRAM_POINT_SIZE_ARB"("0x8642")
        "GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS_ARB"("0x8C29")
        "GL_FRAMEBUFFER_ATTACHMENT_LAYERED_ARB"("0x8DA7")
        "GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS_ARB"("0x8DA8")
        "GL_FRAMEBUFFER_INCOMPLETE_LAYER_COUNT_ARB"("0x8DA9")
        "GL_GEOMETRY_SHADER_ARB"("0x8DD9")
        "GL_GEOMETRY_VERTICES_OUT_ARB"("0x8DDA")
        "GL_GEOMETRY_INPUT_TYPE_ARB"("0x8DDB")
        "GL_GEOMETRY_OUTPUT_TYPE_ARB"("0x8DDC")
        "GL_MAX_GEOMETRY_VARYING_COMPONENTS_ARB"("0x8DDD")
        "GL_MAX_VERTEX_VARYING_COMPONENTS_ARB"("0x8DDE")
        "GL_MAX_GEOMETRY_UNIFORM_COMPONENTS_ARB"("0x8DDF")
        "GL_MAX_GEOMETRY_OUTPUT_VERTICES_ARB"("0x8DE0")
        "GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS_ARB"("0x8DE1")
        "glProgramParameteriARB"(void, GLuint("program"), GLenum("pname"), GLint("value"))
        "glFramebufferTextureARB"(void, GLenum("target"), GLenum("attachment"), GLuint("texture"), GLint("level"))
        "glFramebufferTextureLayerARB"(
            void,
            GLenum("target"),
            GLenum("attachment"),
            GLuint("texture"),
            GLint("level"),
            GLint("layer")
        )
        "glFramebufferTextureFaceARB"(
            void,
            GLenum("target"),
            GLenum("attachment"),
            GLuint("texture"),
            GLint("level"),
            GLenum("face")
        )
    }
    file("GLSpirv", ARB, "GL_ARB_gl_spirv") {
        "GL_SHADER_BINARY_FORMAT_SPIR_V_ARB"("0x9551")
        "GL_SPIR_V_BINARY_ARB"("0x9552")
        "glSpecializeShaderARB"(
            void,
            GLuint("shader"),
            address("pEntryPoint", "const GLchar *"),
            GLuint("numSpecializationConstants"),
            address("pConstantIndex", "const GLuint *"),
            address("pConstantValue", "const GLuint *")
        )
    }
    file("GpuShaderInt64", ARB, "GL_ARB_gpu_shader_int64") {
        "GL_INT64_ARB"("0x140E")
        "GL_INT64_VEC2_ARB"("0x8FE9")
        "GL_INT64_VEC3_ARB"("0x8FEA")
        "GL_INT64_VEC4_ARB"("0x8FEB")
        "GL_UNSIGNED_INT64_VEC2_ARB"("0x8FF5")
        "GL_UNSIGNED_INT64_VEC3_ARB"("0x8FF6")
        "GL_UNSIGNED_INT64_VEC4_ARB"("0x8FF7")
        "glUniform1i64ARB"(void, GLint("location"), GLint64("x"))
        "glUniform2i64ARB"(void, GLint("location"), GLint64("x"), GLint64("y"))
        "glUniform3i64ARB"(void, GLint("location"), GLint64("x"), GLint64("y"), GLint64("z"))
        "glUniform4i64ARB"(void, GLint("location"), GLint64("x"), GLint64("y"), GLint64("z"), GLint64("w"))
        "glUniform1i64vARB"(void, GLint("location"), GLsizei("count"), address("value", "const GLint64 *"))
        "glUniform2i64vARB"(void, GLint("location"), GLsizei("count"), address("value", "const GLint64 *"))
        "glUniform3i64vARB"(void, GLint("location"), GLsizei("count"), address("value", "const GLint64 *"))
        "glUniform4i64vARB"(void, GLint("location"), GLsizei("count"), address("value", "const GLint64 *"))
        "glUniform1ui64ARB"(void, GLint("location"), GLuint64("x"))
        "glUniform2ui64ARB"(void, GLint("location"), GLuint64("x"), GLuint64("y"))
        "glUniform3ui64ARB"(void, GLint("location"), GLuint64("x"), GLuint64("y"), GLuint64("z"))
        "glUniform4ui64ARB"(void, GLint("location"), GLuint64("x"), GLuint64("y"), GLuint64("z"), GLuint64("w"))
        "glUniform1ui64vARB"(void, GLint("location"), GLsizei("count"), address("value", "const GLuint64 *"))
        "glUniform2ui64vARB"(void, GLint("location"), GLsizei("count"), address("value", "const GLuint64 *"))
        "glUniform3ui64vARB"(void, GLint("location"), GLsizei("count"), address("value", "const GLuint64 *"))
        "glUniform4ui64vARB"(void, GLint("location"), GLsizei("count"), address("value", "const GLuint64 *"))
        "glGetUniformi64vARB"(void, GLuint("program"), GLint("location"), address("params", "GLint64 *"))
        "glGetUniformui64vARB"(void, GLuint("program"), GLint("location"), address("params", "GLuint64 *"))
        "glGetnUniformi64vARB"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("bufSize"),
            address("params", "GLint64 *")
        )
        "glGetnUniformui64vARB"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("bufSize"),
            address("params", "GLuint64 *")
        )
        "glProgramUniform1i64ARB"(void, GLuint("program"), GLint("location"), GLint64("x"))
        "glProgramUniform2i64ARB"(void, GLuint("program"), GLint("location"), GLint64("x"), GLint64("y"))
        "glProgramUniform3i64ARB"(void, GLuint("program"), GLint("location"), GLint64("x"), GLint64("y"), GLint64("z"))
        "glProgramUniform4i64ARB"(
            void,
            GLuint("program"),
            GLint("location"),
            GLint64("x"),
            GLint64("y"),
            GLint64("z"),
            GLint64("w")
        )
        "glProgramUniform1i64vARB"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("value", "const GLint64 *")
        )
        "glProgramUniform2i64vARB"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("value", "const GLint64 *")
        )
        "glProgramUniform3i64vARB"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("value", "const GLint64 *")
        )
        "glProgramUniform4i64vARB"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("value", "const GLint64 *")
        )
        "glProgramUniform1ui64ARB"(void, GLuint("program"), GLint("location"), GLuint64("x"))
        "glProgramUniform2ui64ARB"(void, GLuint("program"), GLint("location"), GLuint64("x"), GLuint64("y"))
        "glProgramUniform3ui64ARB"(
            void,
            GLuint("program"),
            GLint("location"),
            GLuint64("x"),
            GLuint64("y"),
            GLuint64("z")
        )
        "glProgramUniform4ui64ARB"(
            void,
            GLuint("program"),
            GLint("location"),
            GLuint64("x"),
            GLuint64("y"),
            GLuint64("z"),
            GLuint64("w")
        )
        "glProgramUniform1ui64vARB"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("value", "const GLuint64 *")
        )
        "glProgramUniform2ui64vARB"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("value", "const GLuint64 *")
        )
        "glProgramUniform3ui64vARB"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("value", "const GLuint64 *")
        )
        "glProgramUniform4ui64vARB"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("value", "const GLuint64 *")
        )
    }
    file("HalfFloatPixel", ARB, "GL_ARB_half_float_pixel", "GL_HALF_FLOAT_ARB" to "0x140B")
    file("Imaging", ARB, "GL_ARB_imaging") {
        "GL_CONVOLUTION_BORDER_MODE"("0x8013")
        "GL_CONVOLUTION_FILTER_SCALE"("0x8014")
        "GL_CONVOLUTION_FILTER_BIAS"("0x8015")
        "GL_REDUCE"("0x8016")
        "GL_CONVOLUTION_FORMAT"("0x8017")
        "GL_CONVOLUTION_WIDTH"("0x8018")
        "GL_CONVOLUTION_HEIGHT"("0x8019")
        "GL_MAX_CONVOLUTION_WIDTH"("0x801A")
        "GL_MAX_CONVOLUTION_HEIGHT"("0x801B")
        "GL_POST_CONVOLUTION_RED_SCALE"("0x801C")
        "GL_POST_CONVOLUTION_GREEN_SCALE"("0x801D")
        "GL_POST_CONVOLUTION_BLUE_SCALE"("0x801E")
        "GL_POST_CONVOLUTION_ALPHA_SCALE"("0x801F")
        "GL_POST_CONVOLUTION_RED_BIAS"("0x8020")
        "GL_POST_CONVOLUTION_GREEN_BIAS"("0x8021")
        "GL_POST_CONVOLUTION_BLUE_BIAS"("0x8022")
        "GL_POST_CONVOLUTION_ALPHA_BIAS"("0x8023")
        "GL_HISTOGRAM_WIDTH"("0x8026")
        "GL_HISTOGRAM_FORMAT"("0x8027")
        "GL_HISTOGRAM_RED_SIZE"("0x8028")
        "GL_HISTOGRAM_GREEN_SIZE"("0x8029")
        "GL_HISTOGRAM_BLUE_SIZE"("0x802A")
        "GL_HISTOGRAM_ALPHA_SIZE"("0x802B")
        "GL_HISTOGRAM_LUMINANCE_SIZE"("0x802C")
        "GL_HISTOGRAM_SINK"("0x802D")
        "GL_MINMAX_FORMAT"("0x802F")
        "GL_MINMAX_SINK"("0x8030")
        "GL_TABLE_TOO_LARGE"("0x8031")
        "GL_COLOR_MATRIX"("0x80B1")
        "GL_COLOR_MATRIX_STACK_DEPTH"("0x80B2")
        "GL_MAX_COLOR_MATRIX_STACK_DEPTH"("0x80B3")
        "GL_POST_COLOR_MATRIX_RED_SCALE"("0x80B4")
        "GL_POST_COLOR_MATRIX_GREEN_SCALE"("0x80B5")
        "GL_POST_COLOR_MATRIX_BLUE_SCALE"("0x80B6")
        "GL_POST_COLOR_MATRIX_ALPHA_SCALE"("0x80B7")
        "GL_POST_COLOR_MATRIX_RED_BIAS"("0x80B8")
        "GL_POST_COLOR_MATRIX_GREEN_BIAS"("0x80B9")
        "GL_POST_COLOR_MATRIX_BLUE_BIAS"("0x80BA")
        "GL_POST_COLOR_MATRIX_ALPHA_BIAS"("0x80BB")
        "GL_COLOR_TABLE_SCALE"("0x80D6")
        "GL_COLOR_TABLE_BIAS"("0x80D7")
        "GL_COLOR_TABLE_FORMAT"("0x80D8")
        "GL_COLOR_TABLE_WIDTH"("0x80D9")
        "GL_COLOR_TABLE_RED_SIZE"("0x80DA")
        "GL_COLOR_TABLE_GREEN_SIZE"("0x80DB")
        "GL_COLOR_TABLE_BLUE_SIZE"("0x80DC")
        "GL_COLOR_TABLE_ALPHA_SIZE"("0x80DD")
        "GL_COLOR_TABLE_LUMINANCE_SIZE"("0x80DE")
        "GL_COLOR_TABLE_INTENSITY_SIZE"("0x80DF")
        "GL_CONSTANT_BORDER"("0x8151")
        "GL_REPLICATE_BORDER"("0x8153")
        "GL_CONVOLUTION_BORDER_COLOR"("0x8154")
        "glColorTable"(
            void,
            GLenum("target"),
            GLenum("internalformat"),
            GLsizei("width"),
            GLenum("format"),
            GLenum("type"),
            address("table", "const void *")
        )
        "glColorTableParameterfv"(void, GLenum("target"), GLenum("pname"), address("params", "const GLfloat *"))
        "glColorTableParameteriv"(void, GLenum("target"), GLenum("pname"), address("params", "const GLint *"))
        "glCopyColorTable"(void, GLenum("target"), GLenum("internalformat"), GLint("x"), GLint("y"), GLsizei("width"))
        "glGetColorTable"(void, GLenum("target"), GLenum("format"), GLenum("type"), address("table", "void *"))
        "glGetColorTableParameterfv"(void, GLenum("target"), GLenum("pname"), address("params", "GLfloat *"))
        "glGetColorTableParameteriv"(void, GLenum("target"), GLenum("pname"), address("params", "GLint *"))
        "glColorSubTable"(
            void,
            GLenum("target"),
            GLsizei("start"),
            GLsizei("count"),
            GLenum("format"),
            GLenum("type"),
            address("data", "const void *")
        )
        "glCopyColorSubTable"(void, GLenum("target"), GLsizei("start"), GLint("x"), GLint("y"), GLsizei("width"))
        "glConvolutionFilter1D"(
            void,
            GLenum("target"),
            GLenum("internalformat"),
            GLsizei("width"),
            GLenum("format"),
            GLenum("type"),
            address("image", "const void *")
        )
        "glConvolutionFilter2D"(
            void,
            GLenum("target"),
            GLenum("internalformat"),
            GLsizei("width"),
            GLsizei("height"),
            GLenum("format"),
            GLenum("type"),
            address("image", "const void *")
        )
        "glConvolutionParameterf"(void, GLenum("target"), GLenum("pname"), GLfloat("params"))
        "glConvolutionParameterfv"(void, GLenum("target"), GLenum("pname"), address("params", "const GLfloat *"))
        "glConvolutionParameteri"(void, GLenum("target"), GLenum("pname"), GLint("params"))
        "glConvolutionParameteriv"(void, GLenum("target"), GLenum("pname"), address("params", "const GLint *"))
        "glCopyConvolutionFilter1D"(
            void,
            GLenum("target"),
            GLenum("internalformat"),
            GLint("x"),
            GLint("y"),
            GLsizei("width")
        )
        "glCopyConvolutionFilter2D"(
            void,
            GLenum("target"),
            GLenum("internalformat"),
            GLint("x"),
            GLint("y"),
            GLsizei("width"),
            GLsizei("height")
        )
        "glGetConvolutionFilter"(void, GLenum("target"), GLenum("format"), GLenum("type"), address("image", "void *"))
        "glGetConvolutionParameterfv"(void, GLenum("target"), GLenum("pname"), address("params", "GLfloat *"))
        "glGetConvolutionParameteriv"(void, GLenum("target"), GLenum("pname"), address("params", "GLint *"))
        "glGetSeparableFilter"(
            void,
            GLenum("target"),
            GLenum("format"),
            GLenum("type"),
            address("row", "void *"),
            address("column", "void *"),
            address("span", "void *")
        )
        "glSeparableFilter2D"(
            void,
            GLenum("target"),
            GLenum("internalformat"),
            GLsizei("width"),
            GLsizei("height"),
            GLenum("format"),
            GLenum("type"),
            address("row", "const void *"),
            address("column", "const void *")
        )
        "glGetHistogram"(
            void,
            GLenum("target"),
            GLboolean("reset"),
            GLenum("format"),
            GLenum("type"),
            address("values", "void *")
        )
        "glGetHistogramParameterfv"(void, GLenum("target"), GLenum("pname"), address("params", "GLfloat *"))
        "glGetHistogramParameteriv"(void, GLenum("target"), GLenum("pname"), address("params", "GLint *"))
        "glGetMinmax"(
            void,
            GLenum("target"),
            GLboolean("reset"),
            GLenum("format"),
            GLenum("type"),
            address("values", "void *")
        )
        "glGetMinmaxParameterfv"(void, GLenum("target"), GLenum("pname"), address("params", "GLfloat *"))
        "glGetMinmaxParameteriv"(void, GLenum("target"), GLenum("pname"), address("params", "GLint *"))
        "glHistogram"(void, GLenum("target"), GLsizei("width"), GLenum("internalformat"), GLboolean("sink"))
        "glMinmax"(void, GLenum("target"), GLenum("internalformat"), GLboolean("sink"))
        "glResetHistogram"(void, GLenum("target"))
        "glResetMinmax"(void, GLenum("target"))
    }
    file("IndirectParameters", ARB, "GL_ARB_indirect_parameters") {
        "GL_PARAMETER_BUFFER_ARB"("0x80EE")
        "GL_PARAMETER_BUFFER_BINDING_ARB"("0x80EF")
        "glMultiDrawArraysIndirectCountARB"(
            void,
            GLenum("mode"),
            address("indirect", "const void *"),
            GLintptr("drawcount"),
            GLsizei("maxdrawcount"),
            GLsizei("stride")
        )
        "glMultiDrawElementsIndirectCountARB"(
            void,
            GLenum("mode"),
            GLenum("type"),
            address("indirect", "const void *"),
            GLintptr("drawcount"),
            GLsizei("maxdrawcount"),
            GLsizei("stride")
        )
    }
    file("InstancedArrays", ARB, "GL_ARB_instanced_arrays") {
        "GL_VERTEX_ATTRIB_ARRAY_DIVISOR_ARB"("0x88FE")
        "glVertexAttribDivisorARB"(void, GLuint("index"), GLuint("divisor"))
    }
    file(
        "InternalformatQuery2", ARB, "GL_ARB_internalformat_query2",
        "GL_SRGB_DECODE_ARB" to "0x8299",
        "GL_VIEW_CLASS_EAC_R11" to "0x9383",
        "GL_VIEW_CLASS_EAC_RG11" to "0x9384",
        "GL_VIEW_CLASS_ETC2_RGB" to "0x9385",
        "GL_VIEW_CLASS_ETC2_RGBA" to "0x9386",
        "GL_VIEW_CLASS_ETC2_EAC_RGBA" to "0x9387",
        "GL_VIEW_CLASS_ASTC_4x4_RGBA" to "0x9388",
        "GL_VIEW_CLASS_ASTC_5x4_RGBA" to "0x9389",
        "GL_VIEW_CLASS_ASTC_5x5_RGBA" to "0x938A",
        "GL_VIEW_CLASS_ASTC_6x5_RGBA" to "0x938B",
        "GL_VIEW_CLASS_ASTC_6x6_RGBA" to "0x938C",
        "GL_VIEW_CLASS_ASTC_8x5_RGBA" to "0x938D",
        "GL_VIEW_CLASS_ASTC_8x6_RGBA" to "0x938E",
        "GL_VIEW_CLASS_ASTC_8x8_RGBA" to "0x938F",
        "GL_VIEW_CLASS_ASTC_10x5_RGBA" to "0x9390",
        "GL_VIEW_CLASS_ASTC_10x6_RGBA" to "0x9391",
        "GL_VIEW_CLASS_ASTC_10x8_RGBA" to "0x9392",
        "GL_VIEW_CLASS_ASTC_10x10_RGBA" to "0x9393",
        "GL_VIEW_CLASS_ASTC_12x10_RGBA" to "0x9394",
        "GL_VIEW_CLASS_ASTC_12x12_RGBA" to "0x9395"
    )
    file("MatrixPalette", ARB, "GL_ARB_matrix_palette") {
        "GL_MATRIX_PALETTE_ARB"("0x8840")
        "GL_MAX_MATRIX_PALETTE_STACK_DEPTH_ARB"("0x8841")
        "GL_MAX_PALETTE_MATRICES_ARB"("0x8842")
        "GL_CURRENT_PALETTE_MATRIX_ARB"("0x8843")
        "GL_MATRIX_INDEX_ARRAY_ARB"("0x8844")
        "GL_CURRENT_MATRIX_INDEX_ARB"("0x8845")
        "GL_MATRIX_INDEX_ARRAY_SIZE_ARB"("0x8846")
        "GL_MATRIX_INDEX_ARRAY_TYPE_ARB"("0x8847")
        "GL_MATRIX_INDEX_ARRAY_STRIDE_ARB"("0x8848")
        "GL_MATRIX_INDEX_ARRAY_POINTER_ARB"("0x8849")
        "glCurrentPaletteMatrixARB"(void, GLint("index"))
        "glMatrixIndexubvARB"(void, GLint("size"), address("indices", "const GLubyte *"))
        "glMatrixIndexusvARB"(void, GLint("size"), address("indices", "const GLushort *"))
        "glMatrixIndexuivARB"(void, GLint("size"), address("indices", "const GLuint *"))
        "glMatrixIndexPointerARB"(
            void,
            GLint("size"),
            GLenum("type"),
            GLsizei("stride"),
            address("pointer", "const void *")
        )
    }
    file("Multisample", ARB, "GL_ARB_multisample") {
        "GL_MULTISAMPLE_ARB"("0x809D")
        "GL_SAMPLE_ALPHA_TO_COVERAGE_ARB"("0x809E")
        "GL_SAMPLE_ALPHA_TO_ONE_ARB"("0x809F")
        "GL_SAMPLE_COVERAGE_ARB"("0x80A0")
        "GL_SAMPLE_BUFFERS_ARB"("0x80A8")
        "GL_SAMPLES_ARB"("0x80A9")
        "GL_SAMPLE_COVERAGE_VALUE_ARB"("0x80AA")
        "GL_SAMPLE_COVERAGE_INVERT_ARB"("0x80AB")
        "GL_MULTISAMPLE_BIT_ARB"("0x20000000")
        "glSampleCoverageARB"(void, GLfloat("value"), GLboolean("invert"))
    }
    file("Multitexture", ARB, "GL_ARB_multitexture") {
        "GL_TEXTURE0_ARB"("0x84C0")
        "GL_TEXTURE1_ARB"("0x84C1")
        "GL_TEXTURE2_ARB"("0x84C2")
        "GL_TEXTURE3_ARB"("0x84C3")
        "GL_TEXTURE4_ARB"("0x84C4")
        "GL_TEXTURE5_ARB"("0x84C5")
        "GL_TEXTURE6_ARB"("0x84C6")
        "GL_TEXTURE7_ARB"("0x84C7")
        "GL_TEXTURE8_ARB"("0x84C8")
        "GL_TEXTURE9_ARB"("0x84C9")
        "GL_TEXTURE10_ARB"("0x84CA")
        "GL_TEXTURE11_ARB"("0x84CB")
        "GL_TEXTURE12_ARB"("0x84CC")
        "GL_TEXTURE13_ARB"("0x84CD")
        "GL_TEXTURE14_ARB"("0x84CE")
        "GL_TEXTURE15_ARB"("0x84CF")
        "GL_TEXTURE16_ARB"("0x84D0")
        "GL_TEXTURE17_ARB"("0x84D1")
        "GL_TEXTURE18_ARB"("0x84D2")
        "GL_TEXTURE19_ARB"("0x84D3")
        "GL_TEXTURE20_ARB"("0x84D4")
        "GL_TEXTURE21_ARB"("0x84D5")
        "GL_TEXTURE22_ARB"("0x84D6")
        "GL_TEXTURE23_ARB"("0x84D7")
        "GL_TEXTURE24_ARB"("0x84D8")
        "GL_TEXTURE25_ARB"("0x84D9")
        "GL_TEXTURE26_ARB"("0x84DA")
        "GL_TEXTURE27_ARB"("0x84DB")
        "GL_TEXTURE28_ARB"("0x84DC")
        "GL_TEXTURE29_ARB"("0x84DD")
        "GL_TEXTURE30_ARB"("0x84DE")
        "GL_TEXTURE31_ARB"("0x84DF")
        "GL_ACTIVE_TEXTURE_ARB"("0x84E0")
        "GL_CLIENT_ACTIVE_TEXTURE_ARB"("0x84E1")
        "GL_MAX_TEXTURE_UNITS_ARB"("0x84E2")
        "glActiveTextureARB"(void, GLenum("texture"))
        "glClientActiveTextureARB"(void, GLenum("texture"))
        "glMultiTexCoord1dARB"(void, GLenum("target"), GLdouble("s"))
        "glMultiTexCoord1dvARB"(void, GLenum("target"), address("v", "const GLdouble *"))
        "glMultiTexCoord1fARB"(void, GLenum("target"), GLfloat("s"))
        "glMultiTexCoord1fvARB"(void, GLenum("target"), address("v", "const GLfloat *"))
        "glMultiTexCoord1iARB"(void, GLenum("target"), GLint("s"))
        "glMultiTexCoord1ivARB"(void, GLenum("target"), address("v", "const GLint *"))
        "glMultiTexCoord1sARB"(void, GLenum("target"), GLshort("s"))
        "glMultiTexCoord1svARB"(void, GLenum("target"), address("v", "const GLshort *"))
        "glMultiTexCoord2dARB"(void, GLenum("target"), GLdouble("s"), GLdouble("t"))
        "glMultiTexCoord2dvARB"(void, GLenum("target"), address("v", "const GLdouble *"))
        "glMultiTexCoord2fARB"(void, GLenum("target"), GLfloat("s"), GLfloat("t"))
        "glMultiTexCoord2fvARB"(void, GLenum("target"), address("v", "const GLfloat *"))
        "glMultiTexCoord2iARB"(void, GLenum("target"), GLint("s"), GLint("t"))
        "glMultiTexCoord2ivARB"(void, GLenum("target"), address("v", "const GLint *"))
        "glMultiTexCoord2sARB"(void, GLenum("target"), GLshort("s"), GLshort("t"))
        "glMultiTexCoord2svARB"(void, GLenum("target"), address("v", "const GLshort *"))
        "glMultiTexCoord3dARB"(void, GLenum("target"), GLdouble("s"), GLdouble("t"), GLdouble("r"))
        "glMultiTexCoord3dvARB"(void, GLenum("target"), address("v", "const GLdouble *"))
        "glMultiTexCoord3fARB"(void, GLenum("target"), GLfloat("s"), GLfloat("t"), GLfloat("r"))
        "glMultiTexCoord3fvARB"(void, GLenum("target"), address("v", "const GLfloat *"))
        "glMultiTexCoord3iARB"(void, GLenum("target"), GLint("s"), GLint("t"), GLint("r"))
        "glMultiTexCoord3ivARB"(void, GLenum("target"), address("v", "const GLint *"))
        "glMultiTexCoord3sARB"(void, GLenum("target"), GLshort("s"), GLshort("t"), GLshort("r"))
        "glMultiTexCoord3svARB"(void, GLenum("target"), address("v", "const GLshort *"))
        "glMultiTexCoord4dARB"(void, GLenum("target"), GLdouble("s"), GLdouble("t"), GLdouble("r"), GLdouble("q"))
        "glMultiTexCoord4dvARB"(void, GLenum("target"), address("v", "const GLdouble *"))
        "glMultiTexCoord4fARB"(void, GLenum("target"), GLfloat("s"), GLfloat("t"), GLfloat("r"), GLfloat("q"))
        "glMultiTexCoord4fvARB"(void, GLenum("target"), address("v", "const GLfloat *"))
        "glMultiTexCoord4iARB"(void, GLenum("target"), GLint("s"), GLint("t"), GLint("r"), GLint("q"))
        "glMultiTexCoord4ivARB"(void, GLenum("target"), address("v", "const GLint *"))
        "glMultiTexCoord4sARB"(void, GLenum("target"), GLshort("s"), GLshort("t"), GLshort("r"), GLshort("q"))
        "glMultiTexCoord4svARB"(void, GLenum("target"), address("v", "const GLshort *"))
    }
    file("OcclusionQuery", ARB, "GL_ARB_occlusion_query") {
        "GL_QUERY_COUNTER_BITS_ARB"("0x8864")
        "GL_CURRENT_QUERY_ARB"("0x8865")
        "GL_QUERY_RESULT_ARB"("0x8866")
        "GL_QUERY_RESULT_AVAILABLE_ARB"("0x8867")
        "GL_SAMPLES_PASSED_ARB"("0x8914")
        "glGenQueriesARB"(void, GLsizei("n"), address("ids", "GLuint *"))
        "glDeleteQueriesARB"(void, GLsizei("n"), address("ids", "const GLuint *"))
        "glIsQueryARB"(GLboolean, GLuint("id"))
        "glBeginQueryARB"(void, GLenum("target"), GLuint("id"))
        "glEndQueryARB"(void, GLenum("target"))
        "glGetQueryivARB"(void, GLenum("target"), GLenum("pname"), address("params", "GLint *"))
        "glGetQueryObjectivARB"(void, GLuint("id"), GLenum("pname"), address("params", "GLint *"))
        "glGetQueryObjectuivARB"(void, GLuint("id"), GLenum("pname"), address("params", "GLuint *"))
    }
    file("ParallelShaderCompile", ARB, "GL_ARB_parallel_shader_compile") {
        "GL_MAX_SHADER_COMPILER_THREADS_ARB"("0x91B0")
        "GL_COMPLETION_STATUS_ARB"("0x91B1")
        "glMaxShaderCompilerThreadsARB"(void, GLuint("count"))
    }
    file(
        "PipelineStatisticsQuery", ARB, "GL_ARB_pipeline_statistics_query",
        "GL_VERTICES_SUBMITTED_ARB" to "0x82EE",
        "GL_PRIMITIVES_SUBMITTED_ARB" to "0x82EF",
        "GL_VERTEX_SHADER_INVOCATIONS_ARB" to "0x82F0",
        "GL_TESS_CONTROL_SHADER_PATCHES_ARB" to "0x82F1",
        "GL_TESS_EVALUATION_SHADER_INVOCATIONS_ARB" to "0x82F2",
        "GL_GEOMETRY_SHADER_PRIMITIVES_EMITTED_ARB" to "0x82F3",
        "GL_FRAGMENT_SHADER_INVOCATIONS_ARB" to "0x82F4",
        "GL_COMPUTE_SHADER_INVOCATIONS_ARB" to "0x82F5",
        "GL_CLIPPING_INPUT_PRIMITIVES_ARB" to "0x82F6",
        "GL_CLIPPING_OUTPUT_PRIMITIVES_ARB" to "0x82F7"
    )
    file(
        "PixelBufferObject", ARB, "GL_ARB_pixel_buffer_object",
        "GL_PIXEL_PACK_BUFFER_ARB" to "0x88EB",
        "GL_PIXEL_UNPACK_BUFFER_ARB" to "0x88EC",
        "GL_PIXEL_PACK_BUFFER_BINDING_ARB" to "0x88ED",
        "GL_PIXEL_UNPACK_BUFFER_BINDING_ARB" to "0x88EF"
    )
    file("PointParameters", ARB, "GL_ARB_point_parameters") {
        "GL_POINT_SIZE_MIN_ARB"("0x8126")
        "GL_POINT_SIZE_MAX_ARB"("0x8127")
        "GL_POINT_FADE_THRESHOLD_SIZE_ARB"("0x8128")
        "GL_POINT_DISTANCE_ATTENUATION_ARB"("0x8129")
        "glPointParameterfARB"(void, GLenum("pname"), GLfloat("param"))
        "glPointParameterfvARB"(void, GLenum("pname"), address("params", "const GLfloat *"))
    }
    file(
        "PointSprite", ARB, "GL_ARB_point_sprite",
        "GL_POINT_SPRITE_ARB" to "0x8861",
        "GL_COORD_REPLACE_ARB" to "0x8862"
    )
    file("Robustness", ARB, "GL_ARB_robustness") {
        "GL_NO_RESET_NOTIFICATION_ARB"("0x8261")
        "GL_RESET_NOTIFICATION_STRATEGY_ARB"("0x8256")
        "GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT_ARB"("0x00000004")
        "GL_UNKNOWN_CONTEXT_RESET_ARB"("0x8255")
        "GL_LOSE_CONTEXT_ON_RESET_ARB"("0x8252")
        "GL_INNOCENT_CONTEXT_RESET_ARB"("0x8254")
        "GL_GUILTY_CONTEXT_RESET_ARB"("0x8253")
        "glGetGraphicsResetStatusARB"(int)
        "glGetnCompressedTexImageARB"(void, int("target"), int("lod"), int("bufSize"), address("img", "void*"))
        "glGetnTexImageARB"(
            void,
            int("target"),
            int("level"),
            int("format"),
            int("type"),
            int("bufSize"),
            address("img", "void*")
        )
        "glGetnUniformdvARB"(void, int("program"), int("location"), int("bufSize"), address("params", "GLdouble*"))
        "glGetnUniformfvARB"(void, int("program"), int("location"), int("bufSize"), address("params", "GLfloat*"))
        "glGetnUniformivARB"(void, int("program"), int("location"), int("bufSize"), address("params", "GLint*"))
        "glGetnUniformuivARB"(void, int("program"), int("location"), int("bufSize"), address("params", "GLuint*"))
        "glReadnPixelsARB"(
            void,
            int("x"),
            int("y"),
            int("width"),
            int("height"),
            int("format"),
            int("type"),
            int("bufSize"),
            address("data", "void*")
        )
    }
    file("SampleLocations", ARB, "GL_ARB_sample_locations") {
        "GL_SAMPLE_LOCATION_SUBPIXEL_BITS_ARB"("0x933D")
        "GL_SAMPLE_LOCATION_PIXEL_GRID_WIDTH_ARB"("0x933E")
        "GL_SAMPLE_LOCATION_PIXEL_GRID_HEIGHT_ARB"("0x933F")
        "GL_PROGRAMMABLE_SAMPLE_LOCATION_TABLE_SIZE_ARB"("0x9340")
        "GL_SAMPLE_LOCATION_ARB"("0x8E50")
        "GL_PROGRAMMABLE_SAMPLE_LOCATION_ARB"("0x9341")
        "GL_FRAMEBUFFER_PROGRAMMABLE_SAMPLE_LOCATIONS_ARB"("0x9342")
        "GL_FRAMEBUFFER_SAMPLE_LOCATION_PIXEL_GRID_ARB"("0x9343")
        "glEvaluateDepthValuesARB"(void)
        "glFramebufferSampleLocationsfvARB"(
            void,
            int("target"),
            int("start"),
            int("count"),
            address("v", "const GLfloat *v")
        )
        "glNamedFramebufferSampleLocationsfvARB"(
            void,
            int("framebuffer"),
            int("start"),
            int("count"),
            address("v", "const GLfloat *v")
        )
    }
    file("SampleShading", ARB, "GL_ARB_sample_shading") {
        "GL_SAMPLE_SHADING_ARB"("0x8C36")
        "GL_MIN_SAMPLE_SHADING_VALUE_ARB"("0x8C37")
        "glMinSampleShadingARB"(void, float("value"))
    }
    file("ShaderObjects", ARB, "GL_ARB_shader_objects") {
        "GL_PROGRAM_OBJECT_ARB"("0x8B40")
        "GL_SHADER_OBJECT_ARB"("0x8B48")
        "GL_OBJECT_TYPE_ARB"("0x8B4E")
        "GL_OBJECT_SUBTYPE_ARB"("0x8B4F")
        "GL_FLOAT_VEC2_ARB"("0x8B50")
        "GL_FLOAT_VEC3_ARB"("0x8B51")
        "GL_FLOAT_VEC4_ARB"("0x8B52")
        "GL_INT_VEC2_ARB"("0x8B53")
        "GL_INT_VEC3_ARB"("0x8B54")
        "GL_INT_VEC4_ARB"("0x8B55")
        "GL_BOOL_ARB"("0x8B56")
        "GL_BOOL_VEC2_ARB"("0x8B57")
        "GL_BOOL_VEC3_ARB"("0x8B58")
        "GL_BOOL_VEC4_ARB"("0x8B59")
        "GL_FLOAT_MAT2_ARB"("0x8B5A")
        "GL_FLOAT_MAT3_ARB"("0x8B5B")
        "GL_FLOAT_MAT4_ARB"("0x8B5C")
        "GL_SAMPLER_1D_ARB"("0x8B5D")
        "GL_SAMPLER_2D_ARB"("0x8B5E")
        "GL_SAMPLER_3D_ARB"("0x8B5F")
        "GL_SAMPLER_CUBE_ARB"("0x8B60")
        "GL_SAMPLER_1D_SHADOW_ARB"("0x8B61")
        "GL_SAMPLER_2D_SHADOW_ARB"("0x8B62")
        "GL_SAMPLER_2D_RECT_ARB"("0x8B63")
        "GL_SAMPLER_2D_RECT_SHADOW_ARB"("0x8B64")
        "GL_OBJECT_DELETE_STATUS_ARB"("0x8B80")
        "GL_OBJECT_COMPILE_STATUS_ARB"("0x8B81")
        "GL_OBJECT_LINK_STATUS_ARB"("0x8B82")
        "GL_OBJECT_VALIDATE_STATUS_ARB"("0x8B83")
        "GL_OBJECT_INFO_LOG_LENGTH_ARB"("0x8B84")
        "GL_OBJECT_ATTACHED_OBJECTS_ARB"("0x8B85")
        "GL_OBJECT_ACTIVE_UNIFORMS_ARB"("0x8B86")
        "GL_OBJECT_ACTIVE_UNIFORM_MAX_LENGTH_ARB"("0x8B87")
        "GL_OBJECT_SHADER_SOURCE_LENGTH_ARB"("0x8B88")
        "glDeleteObjectARB"(void, int("obj"))
        "glGetHandleARB"(int, int("pname"))
        "glDetachObjectARB"(void, int("containerObj"), int("attachedObj"))
        "glCreateShaderObjectARB"(int, int("shaderType"))
        "glShaderSourceARB"(
            void,
            int("shaderObj"),
            int("count"),
            address("string", "const GLcharARB**"),
            address("length", "const GLint*")
        )
        "glCompileShaderARB"(void, int("shaderObj"))
        "glCreateProgramObjectARB"(int)
        "glAttachObjectARB"(void, int("containerObj"), int("obj"))
        "glLinkProgramARB"(void, int("programObj"))
        "glUseProgramObjectARB"(void, int("programObj"))
        "glValidateProgramARB"(void, int("programObj"))
        "glUniform1fARB"(void, int("location"), float("v0"))
        "glUniform2fARB"(void, int("location"), float("v0"), float("v1"))
        "glUniform3fARB"(void, int("location"), float("v0"), float("v1"), float("v2"))
        "glUniform4fARB"(void, int("location"), float("v0"), float("v1"), float("v2"), float("v3"))
        "glUniform1iARB"(void, int("location"), int("v0"))
        "glUniform2iARB"(void, int("location"), int("v0"), int("v1"))
        "glUniform3iARB"(void, int("location"), int("v0"), int("v1"), int("v2"))
        "glUniform4iARB"(void, int("location"), int("v0"), int("v1"), int("v2"), int("v3"))
        "glUniform1fvARB"(void, int("location"), int("count"), address("value", "const GLfloat*"))
        "glUniform2fvARB"(void, int("location"), int("count"), address("value", "const GLfloat*"))
        "glUniform3fvARB"(void, int("location"), int("count"), address("value", "const GLfloat*"))
        "glUniform4fvARB"(void, int("location"), int("count"), address("value", "const GLfloat*"))
        "glUniform1ivARB"(void, int("location"), int("count"), address("value", "const GLint*"))
        "glUniform2ivARB"(void, int("location"), int("count"), address("value", "const GLint*"))
        "glUniform3ivARB"(void, int("location"), int("count"), address("value", "const GLint*"))
        "glUniform4ivARB"(void, int("location"), int("count"), address("value", "const GLint*"))
        "glUniformMatrix2fvARB"(
            void,
            int("location"),
            int("count"),
            boolean("transpose"),
            address("value", "const GLfloat*")
        )
        "glUniformMatrix3fvARB"(
            void,
            int("location"),
            int("count"),
            boolean("transpose"),
            address("value", "const GLfloat*")
        )
        "glUniformMatrix4fvARB"(
            void,
            int("location"),
            int("count"),
            boolean("transpose"),
            address("value", "const GLfloat*")
        )
        "glGetObjectParameterfvARB"(void, int("obj"), int("pname"), address("params", "GLfloat*"))
        "glGetObjectParameterivARB"(void, int("obj"), int("pname"), address("params", "GLint*"))
        "glGetInfoLogARB"(
            void,
            int("obj"),
            int("maxLength"),
            address("length", "GLsizei*"),
            address("infoLog", "GLcharARB*")
        )
        "glGetAttachedObjectsARB"(
            void,
            int("containerObj"),
            int("maxCount"),
            address("count", "GLsizei*"),
            address("obj", "GLhandleARB*")
        )
        "glGetUniformLocationARB"(int, int("programObj"), address("name", "const GLcharARB*"))
        "glGetActiveUniformARB"(
            void,
            int("programObj"),
            int("index"),
            int("maxLength"),
            address("length", "GLsizei*"),
            address("size", "GLint*"),
            address("type", "GLenum*"),
            address("name", "GLcharARB*")
        )
        "glGetUniformfvARB"(void, int("programObj"), int("location"), address("params", "GLfloat*"))
        "glGetUniformivARB"(void, int("programObj"), int("location"), address("params", "GLint*"))
        "glGetShaderSourceARB"(
            void,
            int("obj"),
            int("maxLength"),
            address("length", "GLsizei*"),
            address("source", "GLcharARB*")
        )
    }
    file("ShadingLanguageInclude", ARB, "GL_ARB_shading_language_include") {
        "GL_SHADER_INCLUDE_ARB"("0x8DAE")
        "GL_NAMED_STRING_LENGTH_ARB"("0x8DE9")
        "GL_NAMED_STRING_TYPE_ARB"("0x8DEA")
        "glNamedStringARB"(
            void,
            int("type"),
            int("nameLen"),
            address("name", "const GLchar*"),
            int("stringLen"),
            address("string", "const GLchar*")
        )
        "glDeleteNamedStringARB"(void, int("nameLen"), address("name", "const GLchar*"))
        "glCompileShaderIncludeARB"(
            void,
            int("shader"),
            int("count"),
            address("path", "const GLchar *const*"),
            address("length", "const GLint*")
        )
        "glIsNamedStringARB"(boolean, int("nameLen"), address("name", "const GLchar*"))
        "glGetNamedStringARB"(
            void,
            int("nameLen"),
            address("name", "const GLchar*"),
            int("bufSize"),
            address("stringLen", "GLint*"),
            address("string", "GLchar*")
        )
        "glGetNamedStringivARB"(
            void,
            int("nameLen"),
            address("name", "const GLchar*"),
            int("pname"),
            address("params", "GLint*")
        )
    }
    file(
        "Shadow", ARB, "GL_ARB_shadow",
        "GL_TEXTURE_COMPARE_MODE_ARB" to "0x884C",
        "GL_TEXTURE_COMPARE_FUNC_ARB" to "0x884D",
        "GL_COMPARE_R_TO_TEXTURE_ARB" to "0x884E"
    )
    file(
        "ShadowAmbient", ARB, "GL_ARB_shadow_ambient",
        "GL_TEXTURE_COMPARE_FAIL_VALUE_ARB" to "0x80BF"
    )
    file("SparseBuffer", ARB, "GL_ARB_sparse_buffer") {
        "GL_SPARSE_STORAGE_BIT_ARB"("0x0400")
        "GL_SPARSE_BUFFER_PAGE_SIZE_ARB"("0x82F8")
        "glBufferPageCommitmentARB"(void, int("target"), long("offset"), long("size"), boolean("commit"))
        "glNamedBufferPageCommitmentEXT"(void, int("buffer"), long("offset"), long("size"), boolean("commit"))
        "glNamedBufferPageCommitmentARB"(void, int("buffer"), long("offset"), long("size"), boolean("commit"))
    }
    file("SparseTexture", ARB, "GL_ARB_sparse_texture") {
        "GL_TEXTURE_SPARSE_ARB"("0x91A6")
        "GL_VIRTUAL_PAGE_SIZE_INDEX_ARB"("0x91A7")
        "GL_NUM_SPARSE_LEVELS_ARB"("0x91AA")
        "GL_NUM_VIRTUAL_PAGE_SIZES_ARB"("0x91A8")
        "GL_VIRTUAL_PAGE_SIZE_X_ARB"("0x9195")
        "GL_VIRTUAL_PAGE_SIZE_Y_ARB"("0x9196")
        "GL_VIRTUAL_PAGE_SIZE_Z_ARB"("0x9197")
        "GL_MAX_SPARSE_TEXTURE_SIZE_ARB"("0x9198")
        "GL_MAX_SPARSE_3D_TEXTURE_SIZE_ARB"("0x9199")
        "GL_MAX_SPARSE_ARRAY_TEXTURE_LAYERS_ARB"("0x919A")
        "GL_SPARSE_TEXTURE_FULL_ARRAY_CUBE_MIPMAPS_ARB"("0x91A9")
        "glTexPageCommitmentARB"(
            void,
            int("target"),
            int("level"),
            int("xoffset"),
            int("yoffset"),
            int("zoffset"),
            int("width"),
            int("height"),
            int("depth"),
            boolean("commit")
        )
    }
    file(
        "TextureBorderClamp", ARB, "GL_ARB_texture_border_clamp",
        "GL_CLAMP_TO_BORDER_ARB" to "0x812D"
    )
    file("TextureBufferObject", ARB, "GL_ARB_texture_buffer_object") {
        "GL_TEXTURE_BUFFER_ARB"("0x8C2A")
        "GL_MAX_TEXTURE_BUFFER_SIZE_ARB"("0x8C2B")
        "GL_TEXTURE_BINDING_BUFFER_ARB"("0x8C2C")
        "GL_TEXTURE_BUFFER_DATA_STORE_BINDING_ARB"("0x8C2D")
        "GL_TEXTURE_BUFFER_FORMAT_ARB"("0x8C2E")
        "glTexBufferARB"(void, int("target"), int("internalFormat"), int("buffer"))
    }
    file("TextureCompression", ARB, "GL_ARB_texture_compression") {
        "GL_COMPRESSED_ALPHA_ARB"("0x84E9")
        "GL_COMPRESSED_LUMINANCE_ARB"("0x84EA")
        "GL_COMPRESSED_LUMINANCE_ALPHA_ARB"("0x84EB")
        "GL_COMPRESSED_INTENSITY_ARB"("0x84EC")
        "GL_COMPRESSED_RGB_ARB"("0x84ED")
        "GL_COMPRESSED_RGBA_ARB"("0x84EE")
        "GL_TEXTURE_COMPRESSION_HINT_ARB"("0x84EF")
        "GL_TEXTURE_COMPRESSED_IMAGE_SIZE_ARB"("0x86A0")
        "GL_TEXTURE_COMPRESSED_ARB"("0x86A1")
        "GL_NUM_COMPRESSED_TEXTURE_FORMATS_ARB"("0x86A2")
        "GL_COMPRESSED_TEXTURE_FORMATS_ARB"("0x86A3")
        "glCompressedTexImage3DARB"(
            void,
            int("target"),
            int("level"),
            int("internalFormat"),
            int("width"),
            int("height"),
            int("depth"),
            int("border"),
            int("imageSize"),
            address("data", "const void*")
        )
        "glCompressedTexImage2DARB"(
            void,
            int("target"),
            int("level"),
            int("internalFormat"),
            int("width"),
            int("height"),
            int("border"),
            int("imageSize"),
            address("data", "const void*")
        )
        "glCompressedTexImage1DARB"(
            void,
            int("target"),
            int("level"),
            int("internalFormat"),
            int("width"),
            int("border"),
            int("imageSize"),
            address("data", "const void*")
        )
        "glCompressedTexSubImage3DARB"(
            void,
            int("target"),
            int("level"),
            int("xoffset"),
            int("yoffset"),
            int("zoffset"),
            int("width"),
            int("height"),
            int("depth"),
            int("format"),
            int("imageSize"),
            address("data", "const void*")
        )
        "glCompressedTexSubImage2DARB"(
            void,
            int("target"),
            int("level"),
            int("xoffset"),
            int("yoffset"),
            int("width"),
            int("height"),
            int("format"),
            int("imageSize"),
            address("data", "const void*")
        )
        "glCompressedTexSubImage1DARB"(
            void,
            int("target"),
            int("level"),
            int("xoffset"),
            int("width"),
            int("format"),
            int("imageSize"),
            address("data", "const void*")
        )
        "glGetCompressedTexImageARB"(void, int("target"), int("level"), address("img", "void*"))
    }
    file(
        "TextureCompressionBptc", ARB, "GL_ARB_texture_compression_bptc",
        "GL_COMPRESSED_RGBA_BPTC_UNORM_ARB" to "0x8E8C",
        "GL_COMPRESSED_SRGB_ALPHA_BPTC_UNORM_ARB" to "0x8E8D",
        "GL_COMPRESSED_RGB_BPTC_SIGNED_FLOAT_ARB" to "0x8E8E",
        "GL_COMPRESSED_RGB_BPTC_UNSIGNED_FLOAT_ARB" to "0x8E8F"
    )
    file(
        "TextureCubeMap", ARB, "GL_ARB_texture_cube_map",
        "GL_NORMAL_MAP_ARB" to "0x8511",
        "GL_REFLECTION_MAP_ARB" to "0x8512",
        "GL_TEXTURE_CUBE_MAP_ARB" to "0x8513",
        "GL_TEXTURE_BINDING_CUBE_MAP_ARB" to "0x8514",
        "GL_TEXTURE_CUBE_MAP_POSITIVE_X_ARB" to "0x8515",
        "GL_TEXTURE_CUBE_MAP_NEGATIVE_X_ARB" to "0x8516",
        "GL_TEXTURE_CUBE_MAP_POSITIVE_Y_ARB" to "0x8517",
        "GL_TEXTURE_CUBE_MAP_NEGATIVE_Y_ARB" to "0x8518",
        "GL_TEXTURE_CUBE_MAP_POSITIVE_Z_ARB" to "0x8519",
        "GL_TEXTURE_CUBE_MAP_NEGATIVE_Z_ARB" to "0x851A",
        "GL_PROXY_TEXTURE_CUBE_MAP_ARB" to "0x851B",
        "GL_MAX_CUBE_MAP_TEXTURE_SIZE_ARB" to "0x851C"
    )
    file(
        "TextureCubeMapArray", ARB, "GL_ARB_texture_cube_map_array",
        "GL_TEXTURE_CUBE_MAP_ARRAY_ARB" to "0x9009",
        "GL_TEXTURE_BINDING_CUBE_MAP_ARRAY_ARB" to "0x900A",
        "GL_PROXY_TEXTURE_CUBE_MAP_ARRAY_ARB" to "0x900B",
        "GL_SAMPLER_CUBE_MAP_ARRAY_ARB" to "0x900C",
        "GL_SAMPLER_CUBE_MAP_ARRAY_SHADOW_ARB" to "0x900D",
        "GL_INT_SAMPLER_CUBE_MAP_ARRAY_ARB" to "0x900E",
        "GL_UNSIGNED_INT_SAMPLER_CUBE_MAP_ARRAY_ARB" to "0x900F"
    )
    file(
        "TextureEnvCombine", ARB, "GL_ARB_texture_env_combine",
        "GL_COMBINE_ARB" to "0x8570",
        "GL_COMBINE_RGB_ARB" to "0x8571",
        "GL_COMBINE_ALPHA_ARB" to "0x8572",
        "GL_SOURCE0_RGB_ARB" to "0x8580",
        "GL_SOURCE1_RGB_ARB" to "0x8581",
        "GL_SOURCE2_RGB_ARB" to "0x8582",
        "GL_SOURCE0_ALPHA_ARB" to "0x8588",
        "GL_SOURCE1_ALPHA_ARB" to "0x8589",
        "GL_SOURCE2_ALPHA_ARB" to "0x858A",
        "GL_OPERAND0_RGB_ARB" to "0x8590",
        "GL_OPERAND1_RGB_ARB" to "0x8591",
        "GL_OPERAND2_RGB_ARB" to "0x8592",
        "GL_OPERAND0_ALPHA_ARB" to "0x8598",
        "GL_OPERAND1_ALPHA_ARB" to "0x8599",
        "GL_OPERAND2_ALPHA_ARB" to "0x859A",
        "GL_RGB_SCALE_ARB" to "0x8573",
        "GL_ADD_SIGNED_ARB" to "0x8574",
        "GL_INTERPOLATE_ARB" to "0x8575",
        "GL_SUBTRACT_ARB" to "0x84E7",
        "GL_CONSTANT_ARB" to "0x8576",
        "GL_PRIMARY_COLOR_ARB" to "0x8577",
        "GL_PREVIOUS_ARB" to "0x8578"
    )
    file(
        "TextureEnvDot3", ARB, "GL_ARB_texture_env_dot3",
        "GL_DOT3_RGB_ARB" to "0x86AE",
        "GL_DOT3_RGBA_ARB" to "0x86AF"
    )
    file(
        "TextureFilterMinmax", ARB, "GL_ARB_texture_filter_minmax",
        "GL_TEXTURE_REDUCTION_MODE_ARB" to "0x9366",
        "GL_WEIGHTED_AVERAGE_ARB" to "0x9367"
    )
    file(
        "TextureFloat", ARB, "GL_ARB_texture_float",
        "GL_TEXTURE_RED_TYPE_ARB" to "0x8C10",
        "GL_TEXTURE_GREEN_TYPE_ARB" to "0x8C11",
        "GL_TEXTURE_BLUE_TYPE_ARB" to "0x8C12",
        "GL_TEXTURE_ALPHA_TYPE_ARB" to "0x8C13",
        "GL_TEXTURE_LUMINANCE_TYPE_ARB" to "0x8C14",
        "GL_TEXTURE_INTENSITY_TYPE_ARB" to "0x8C15",
        "GL_TEXTURE_DEPTH_TYPE_ARB" to "0x8C16",
        "GL_UNSIGNED_NORMALIZED_ARB" to "0x8C17",
        "GL_RGBA32F_ARB" to "0x8814",
        "GL_RGB32F_ARB" to "0x8815",
        "GL_ALPHA32F_ARB" to "0x8816",
        "GL_INTENSITY32F_ARB" to "0x8817",
        "GL_LUMINANCE32F_ARB" to "0x8818",
        "GL_LUMINANCE_ALPHA32F_ARB" to "0x8819",
        "GL_RGBA16F_ARB" to "0x881A",
        "GL_RGB16F_ARB" to "0x881B",
        "GL_ALPHA16F_ARB" to "0x881C",
        "GL_INTENSITY16F_ARB" to "0x881D",
        "GL_LUMINANCE16F_ARB" to "0x881E",
        "GL_LUMINANCE_ALPHA16F_ARB" to "0x881F"
    )
    file(
        "TextureGather", ARB, "GL_ARB_texture_gather",
        "GL_MIN_PROGRAM_TEXTURE_GATHER_OFFSET_ARB" to "0x8E5E",
        "GL_MAX_PROGRAM_TEXTURE_GATHER_OFFSET_ARB" to "0x8E5F",
        "GL_MAX_PROGRAM_TEXTURE_GATHER_COMPONENTS_ARB" to "0x8F9F"
    )
    file(
        "TextureMirroredRepeat", ARB, "GL_ARB_texture_mirrored_repeat",
        "GL_MIRRORED_REPEAT_ARB" to "0x8370"
    )
    file(
        "TextureRectangle", ARB, "GL_ARB_texture_rectangle",
        "GL_TEXTURE_RECTANGLE_ARB" to "0x84F5",
        "GL_TEXTURE_BINDING_RECTANGLE_ARB" to "0x84F6",
        "GL_PROXY_TEXTURE_RECTANGLE_ARB" to "0x84F7",
        "GL_MAX_RECTANGLE_TEXTURE_SIZE_ARB" to "0x84F8"
    )
    file(
        "TransformFeedbackOverflowQuery", ARB, "GL_ARB_transform_feedback_overflow_query",
        "GL_TRANSFORM_FEEDBACK_OVERFLOW_ARB" to "0x82EC",
        "GL_TRANSFORM_FEEDBACK_STREAM_OVERFLOW_ARB" to "0x82ED"
    )
    file("TransposeMatrix", ARB, "GL_ARB_transpose_matrix") {
        "GL_TRANSPOSE_MODELVIEW_MATRIX_ARB"("0x84E3")
        "GL_TRANSPOSE_PROJECTION_MATRIX_ARB"("0x84E4")
        "GL_TRANSPOSE_TEXTURE_MATRIX_ARB"("0x84E5")
        "GL_TRANSPOSE_COLOR_MATRIX_ARB"("0x84E6")
        "glLoadTransposeMatrixfARB"(void, address("m", "const GLfloat*"))
        "glLoadTransposeMatrixdARB"(void, address("m", "const GLdouble*"))
        "glMultTransposeMatrixfARB"(void, address("m", "const GLfloat*"))
        "glMultTransposeMatrixdARB"(void, address("m", "const GLdouble*"))
    }
    file("VertexBlend", ARB, "GL_ARB_vertex_blend") {
        "GL_MAX_VERTEX_UNITS_ARB"("0x86A4")
        "GL_ACTIVE_VERTEX_UNITS_ARB"("0x86A5")
        "GL_WEIGHT_SUM_UNITY_ARB"("0x86A6")
        "GL_VERTEX_BLEND_ARB"("0x86A7")
        "GL_CURRENT_WEIGHT_ARB"("0x86A8")
        "GL_WEIGHT_ARRAY_TYPE_ARB"("0x86A9")
        "GL_WEIGHT_ARRAY_STRIDE_ARB"("0x86AA")
        "GL_WEIGHT_ARRAY_SIZE_ARB"("0x86AB")
        "GL_WEIGHT_ARRAY_POINTER_ARB"("0x86AC")
        "GL_WEIGHT_ARRAY_ARB"("0x86AD")
        "GL_MODELVIEW0_ARB"("0x1700")
        "GL_MODELVIEW1_ARB"("0x850A")
        "GL_MODELVIEW2_ARB"("0x8722")
        "GL_MODELVIEW3_ARB"("0x8723")
        "GL_MODELVIEW4_ARB"("0x8724")
        "GL_MODELVIEW5_ARB"("0x8725")
        "GL_MODELVIEW6_ARB"("0x8726")
        "GL_MODELVIEW7_ARB"("0x8727")
        "GL_MODELVIEW8_ARB"("0x8728")
        "GL_MODELVIEW9_ARB"("0x8729")
        "GL_MODELVIEW10_ARB"("0x872A")
        "GL_MODELVIEW11_ARB"("0x872B")
        "GL_MODELVIEW12_ARB"("0x872C")
        "GL_MODELVIEW13_ARB"("0x872D")
        "GL_MODELVIEW14_ARB"("0x872E")
        "GL_MODELVIEW15_ARB"("0x872F")
        "GL_MODELVIEW16_ARB"("0x8730")
        "GL_MODELVIEW17_ARB"("0x8731")
        "GL_MODELVIEW18_ARB"("0x8732")
        "GL_MODELVIEW19_ARB"("0x8733")
        "GL_MODELVIEW20_ARB"("0x8734")
        "GL_MODELVIEW21_ARB"("0x8735")
        "GL_MODELVIEW22_ARB"("0x8736")
        "GL_MODELVIEW23_ARB"("0x8737")
        "GL_MODELVIEW24_ARB"("0x8738")
        "GL_MODELVIEW25_ARB"("0x8739")
        "GL_MODELVIEW26_ARB"("0x873A")
        "GL_MODELVIEW27_ARB"("0x873B")
        "GL_MODELVIEW28_ARB"("0x873C")
        "GL_MODELVIEW29_ARB"("0x873D")
        "GL_MODELVIEW30_ARB"("0x873E")
        "GL_MODELVIEW31_ARB"("0x873F")
        "glWeightbvARB"(void, GLint("size"), address("weights", "const GLbyte*"))
        "glWeightsvARB"(void, GLint("size"), address("weights", "const GLshort*"))
        "glWeightivARB"(void, GLint("size"), address("weights", "const GLint*"))
        "glWeightfvARB"(void, GLint("size"), address("weights", "const GLfloat*"))
        "glWeightdvARB"(void, GLint("size"), address("weights", "const GLdouble*"))
        "glWeightubvARB"(void, GLint("size"), address("weights", "const GLubyte*"))
        "glWeightusvARB"(void, GLint("size"), address("weights", "const GLushort*"))
        "glWeightuivARB"(void, GLint("size"), address("weights", "const GLuint*"))
        "glWeightPointerARB"(void, GLint("size"), GLenum("type"), GLsizei("stride"), address("pointer", "const void*"))
        "glVertexBlendARB"(void, GLint("count"))
    }
    file("VertexBufferObject", ARB, "GL_ARB_vertex_buffer_object") {
        "GL_BUFFER_SIZE_ARB"("0x8764")
        "GL_BUFFER_USAGE_ARB"("0x8765")
        "GL_ARRAY_BUFFER_ARB"("0x8892")
        "GL_ELEMENT_ARRAY_BUFFER_ARB"("0x8893")
        "GL_ARRAY_BUFFER_BINDING_ARB"("0x8894")
        "GL_ELEMENT_ARRAY_BUFFER_BINDING_ARB"("0x8895")
        "GL_VERTEX_ARRAY_BUFFER_BINDING_ARB"("0x8896")
        "GL_NORMAL_ARRAY_BUFFER_BINDING_ARB"("0x8897")
        "GL_COLOR_ARRAY_BUFFER_BINDING_ARB"("0x8898")
        "GL_INDEX_ARRAY_BUFFER_BINDING_ARB"("0x8899")
        "GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING_ARB"("0x889A")
        "GL_EDGE_FLAG_ARRAY_BUFFER_BINDING_ARB"("0x889B")
        "GL_SECONDARY_COLOR_ARRAY_BUFFER_BINDING_ARB"("0x889C")
        "GL_FOG_COORDINATE_ARRAY_BUFFER_BINDING_ARB"("0x889D")
        "GL_WEIGHT_ARRAY_BUFFER_BINDING_ARB"("0x889E")
        "GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING_ARB"("0x889F")
        "GL_READ_ONLY_ARB"("0x88B8")
        "GL_WRITE_ONLY_ARB"("0x88B9")
        "GL_READ_WRITE_ARB"("0x88BA")
        "GL_BUFFER_ACCESS_ARB"("0x88BB")
        "GL_BUFFER_MAPPED_ARB"("0x88BC")
        "GL_BUFFER_MAP_POINTER_ARB"("0x88BD")
        "GL_STREAM_DRAW_ARB"("0x88E0")
        "GL_STREAM_READ_ARB"("0x88E1")
        "GL_STREAM_COPY_ARB"("0x88E2")
        "GL_STATIC_DRAW_ARB"("0x88E4")
        "GL_STATIC_READ_ARB"("0x88E5")
        "GL_STATIC_COPY_ARB"("0x88E6")
        "GL_DYNAMIC_DRAW_ARB"("0x88E8")
        "GL_DYNAMIC_READ_ARB"("0x88E9")
        "GL_DYNAMIC_COPY_ARB"("0x88EA")
        "glBindBufferARB"(void, GLenum("target"), GLuint("buffer"))
        "glDeleteBuffersARB"(void, GLsizei("n"), address("buffers", "const GLuint*"))
        "glGenBuffersARB"(void, GLsizei("n"), address("buffers", "GLuint*"))
        "glIsBufferARB"(boolean, GLuint("buffer"))
        "glBufferDataARB"(
            void,
            GLenum("target"),
            GLsizeiptrARB("size"),
            address("data", "const void*"),
            GLenum("usage")
        )
        "glBufferSubDataARB"(
            void,
            GLenum("target"),
            GLintptrARB("offset"),
            GLsizeiptrARB("size"),
            address("data", "const void*")
        )
        "glGetBufferSubDataARB"(
            void,
            GLenum("target"),
            GLintptrARB("offset"),
            GLsizeiptrARB("size"),
            address("data", "void*")
        )
        "glMapBufferARB"(address, GLenum("target"), GLenum("access"), nativeType = "void*")
        "glUnmapBufferARB"(boolean, GLenum("target"))
        "glGetBufferParameterivARB"(void, GLenum("target"), GLenum("pname"), address("params", "GLint*"))
        "glGetBufferPointervARB"(void, GLenum("target"), GLenum("pname"), address("params", "void**"))
    }
    file("VertexProgram", ARB, "GL_ARB_vertex_program") {
        "GL_COLOR_SUM_ARB"("0x8458")
        "GL_VERTEX_PROGRAM_ARB"("0x8620")
        "GL_VERTEX_ATTRIB_ARRAY_ENABLED_ARB"("0x8622")
        "GL_VERTEX_ATTRIB_ARRAY_SIZE_ARB"("0x8623")
        "GL_VERTEX_ATTRIB_ARRAY_STRIDE_ARB"("0x8624")
        "GL_VERTEX_ATTRIB_ARRAY_TYPE_ARB"("0x8625")
        "GL_CURRENT_VERTEX_ATTRIB_ARB"("0x8626")
        "GL_VERTEX_PROGRAM_POINT_SIZE_ARB"("0x8642")
        "GL_VERTEX_PROGRAM_TWO_SIDE_ARB"("0x8643")
        "GL_VERTEX_ATTRIB_ARRAY_POINTER_ARB"("0x8645")
        "GL_MAX_VERTEX_ATTRIBS_ARB"("0x8869")
        "GL_VERTEX_ATTRIB_ARRAY_NORMALIZED_ARB"("0x886A")
        "GL_PROGRAM_ADDRESS_REGISTERS_ARB"("0x88B0")
        "GL_MAX_PROGRAM_ADDRESS_REGISTERS_ARB"("0x88B1")
        "GL_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB"("0x88B2")
        "GL_MAX_PROGRAM_NATIVE_ADDRESS_REGISTERS_ARB"("0x88B3")
        "glVertexAttrib1dARB"(void, GLuint("index"), GLdouble("x"))
        "glVertexAttrib1dvARB"(void, GLuint("index"), address("v", "const GLdouble *"))
        "glVertexAttrib1fARB"(void, GLuint("index"), GLfloat("x"))
        "glVertexAttrib1fvARB"(void, GLuint("index"), address("v", "const GLfloat *"))
        "glVertexAttrib1sARB"(void, GLuint("index"), GLshort("x"))
        "glVertexAttrib1svARB"(void, GLuint("index"), address("v", "const GLshort *"))
        "glVertexAttrib2dARB"(void, GLuint("index"), GLdouble("x"), GLdouble("y"))
        "glVertexAttrib2dvARB"(void, GLuint("index"), address("v", "const GLdouble *"))
        "glVertexAttrib2fARB"(void, GLuint("index"), GLfloat("x"), GLfloat("y"))
        "glVertexAttrib2fvARB"(void, GLuint("index"), address("v", "const GLfloat *"))
        "glVertexAttrib2sARB"(void, GLuint("index"), GLshort("x"), GLshort("y"))
        "glVertexAttrib2svARB"(void, GLuint("index"), address("v", "const GLshort *"))
        "glVertexAttrib3dARB"(void, GLuint("index"), GLdouble("x"), GLdouble("y"), GLdouble("z"))
        "glVertexAttrib3dvARB"(void, GLuint("index"), address("v", "const GLdouble *"))
        "glVertexAttrib3fARB"(void, GLuint("index"), GLfloat("x"), GLfloat("y"), GLfloat("z"))
        "glVertexAttrib3fvARB"(void, GLuint("index"), address("v", "const GLfloat *"))
        "glVertexAttrib3sARB"(void, GLuint("index"), GLshort("x"), GLshort("y"), GLshort("z"))
        "glVertexAttrib3svARB"(void, GLuint("index"), address("v", "const GLshort *"))
        "glVertexAttrib4NbvARB"(void, GLuint("index"), address("v", "const GLbyte *"))
        "glVertexAttrib4NivARB"(void, GLuint("index"), address("v", "const GLint *"))
        "glVertexAttrib4NsvARB"(void, GLuint("index"), address("v", "const GLshort *"))
        "glVertexAttrib4NubARB"(void, GLuint("index"), GLubyte("x"), GLubyte("y"), GLubyte("z"), GLubyte("w"))
        "glVertexAttrib4NubvARB"(void, GLuint("index"), address("v", "const GLubyte *"))
        "glVertexAttrib4NuivARB"(void, GLuint("index"), address("v", "const GLuint *"))
        "glVertexAttrib4NusvARB"(void, GLuint("index"), address("v", "const GLushort *"))
        "glVertexAttrib4bvARB"(void, GLuint("index"), address("v", "const GLbyte *"))
        "glVertexAttrib4dARB"(void, GLuint("index"), GLdouble("x"), GLdouble("y"), GLdouble("z"), GLdouble("w"))
        "glVertexAttrib4dvARB"(void, GLuint("index"), address("v", "const GLdouble *"))
        "glVertexAttrib4fARB"(void, GLuint("index"), GLfloat("x"), GLfloat("y"), GLfloat("z"), GLfloat("w"))
        "glVertexAttrib4fvARB"(void, GLuint("index"), address("v", "const GLfloat *"))
        "glVertexAttrib4ivARB"(void, GLuint("index"), address("v", "const GLint *"))
        "glVertexAttrib4sARB"(void, GLuint("index"), GLshort("x"), GLshort("y"), GLshort("z"), GLshort("w"))
        "glVertexAttrib4svARB"(void, GLuint("index"), address("v", "const GLshort *"))
        "glVertexAttrib4ubvARB"(void, GLuint("index"), address("v", "const GLubyte *"))
        "glVertexAttrib4uivARB"(void, GLuint("index"), address("v", "const GLuint *"))
        "glVertexAttrib4usvARB"(void, GLuint("index"), address("v", "const GLushort *"))
        "glVertexAttribPointerARB"(
            void,
            GLuint("index"),
            GLint("size"),
            GLenum("type"),
            GLboolean("normalized"),
            GLsizei("stride"),
            address("pointer", "const void *")
        )
        "glEnableVertexAttribArrayARB"(void, GLuint("index"))
        "glDisableVertexAttribArrayARB"(void, GLuint("index"))
        "glGetVertexAttribdvARB"(void, GLuint("index"), GLenum("pname"), address("params", "GLdouble *"))
        "glGetVertexAttribfvARB"(void, GLuint("index"), GLenum("pname"), address("params", "GLfloat *"))
        "glGetVertexAttribivARB"(void, GLuint("index"), GLenum("pname"), address("params", "GLint *"))
        "glGetVertexAttribPointervARB"(void, GLuint("index"), GLenum("pname"), address("pointer", "void **"))
    }
    file("VertexShader", ARB, "GL_ARB_vertex_shader") {
        "GL_VERTEX_SHADER_ARB"("0x8B31")
        "GL_MAX_VERTEX_UNIFORM_COMPONENTS_ARB"("0x8B4A")
        "GL_MAX_VARYING_FLOATS_ARB"("0x8B4B")
        "GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS_ARB"("0x8B4C")
        "GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS_ARB"("0x8B4D")
        "GL_OBJECT_ACTIVE_ATTRIBUTES_ARB"("0x8B89")
        "GL_OBJECT_ACTIVE_ATTRIBUTE_MAX_LENGTH_ARB"("0x8B8A")
        "glBindAttribLocationARB"(
            void,
            GLhandleARB("programObj"),
            GLuint("index"),
            address("name", "const GLcharARB *")
        )
        "glGetActiveAttribARB"(
            void,
            GLhandleARB("programObj"),
            GLuint("index"),
            GLsizei("maxLength"),
            address("length", "GLsizei *"),
            address("size", "GLint *"),
            address("type", "GLenum *"),
            address("name", "GLcharARB *")
        )
        "glGetAttribLocationARB"(GLint, GLhandleARB("programObj"), address("name", "const GLcharARB *"))
    }
    file("ViewportArray", ARB, "GL_ARB_viewport_array") {
        "glDepthRangeArraydvNV"(void, GLuint("first"), GLsizei("count"), address("v", "const GLdouble *"))
        "glDepthRangeIndexeddNV"(void, GLuint("index"), GLdouble("n"), GLdouble("f"))
    }
    file("WindowPos", ARB, "GL_ARB_window_pos") {
        "glWindowPos2dARB"(void, GLdouble("x"), GLdouble("y"))
        "glWindowPos2dvARB"(void, address("v", "const GLdouble *"))
        "glWindowPos2fARB"(void, GLfloat("x"), GLfloat("y"))
        "glWindowPos2fvARB"(void, address("v", "const GLfloat *"))
        "glWindowPos2iARB"(void, GLint("x"), GLint("y"))
        "glWindowPos2ivARB"(void, address("v", "const GLint *"))
        "glWindowPos2sARB"(void, GLshort("x"), GLshort("y"))
        "glWindowPos2svARB"(void, address("v", "const GLshort *"))
        "glWindowPos3dARB"(void, GLdouble("x"), GLdouble("y"), GLdouble("z"))
        "glWindowPos3dvARB"(void, address("v", "const GLdouble *"))
        "glWindowPos3fARB"(void, GLfloat("x"), GLfloat("y"), GLfloat("z"))
        "glWindowPos3fvARB"(void, address("v", "const GLfloat *"))
        "glWindowPos3iARB"(void, GLint("x"), GLint("y"), GLint("z"))
        "glWindowPos3ivARB"(void, address("v", "const GLint *"))
        "glWindowPos3sARB"(void, GLshort("x"), GLshort("y"), GLshort("z"))
        "glWindowPos3svARB"(void, address("v", "const GLshort *"))
    }
}

fun khr() {
    file("BlendEquationAdvanced", KHR, "GL_KHR_blend_equation_advanced") {
        "GL_MULTIPLY_KHR"("0x9294")
        "GL_SCREEN_KHR"("0x9295")
        "GL_OVERLAY_KHR"("0x9296")
        "GL_DARKEN_KHR"("0x9297")
        "GL_LIGHTEN_KHR"("0x9298")
        "GL_COLORDODGE_KHR"("0x9299")
        "GL_COLORBURN_KHR"("0x929A")
        "GL_HARDLIGHT_KHR"("0x929B")
        "GL_SOFTLIGHT_KHR"("0x929C")
        "GL_DIFFERENCE_KHR"("0x929E")
        "GL_EXCLUSION_KHR"("0x92A0")
        "GL_HSL_HUE_KHR"("0x92AD")
        "GL_HSL_SATURATION_KHR"("0x92AE")
        "GL_HSL_COLOR_KHR"("0x92AF")
        "GL_HSL_LUMINOSITY_KHR"("0x92B0")
        "glBlendBarrierKHR"(void)
    }
    file(
        "BlendEquationAdvancedCoherent", KHR, "GL_KHR_blend_equation_advanced_coherent",
        "GL_BLEND_ADVANCED_COHERENT_KHR" to "0x9285"
    )
    file(
        "NoError", KHR, "GL_KHR_no_error",
        "GL_CONTEXT_FLAG_NO_ERROR_BIT_KHR" to "0x00000008"
    )
    file("ParallelShaderCompile", KHR, "GL_KHR_parallel_shader_compile") {
        "GL_MAX_SHADER_COMPILER_THREADS_KHR"("0x91B0")
        "GL_COMPLETION_STATUS_KHR"("0x91B1")
        "glMaxShaderCompilerThreadsKHR"(void, GLuint("count"))
    }
    file(
        "Robustness", KHR, "GL_KHR_robustness",
        "GL_CONTEXT_ROBUST_ACCESS" to "0x90F3"
    )
    file(
        "ShaderSubgroup", KHR, "GL_KHR_shader_subgroup",
        "GL_SUBGROUP_SIZE_KHR" to "0x9532",
        "GL_SUBGROUP_SUPPORTED_STAGES_KHR" to "0x9533",
        "GL_SUBGROUP_SUPPORTED_FEATURES_KHR" to "0x9534",
        "GL_SUBGROUP_QUAD_ALL_STAGES_KHR" to "0x9535",
        "GL_SUBGROUP_FEATURE_BASIC_BIT_KHR" to "0x00000001",
        "GL_SUBGROUP_FEATURE_VOTE_BIT_KHR" to "0x00000002",
        "GL_SUBGROUP_FEATURE_ARITHMETIC_BIT_KHR" to "0x00000004",
        "GL_SUBGROUP_FEATURE_BALLOT_BIT_KHR" to "0x00000008",
        "GL_SUBGROUP_FEATURE_SHUFFLE_BIT_KHR" to "0x00000010",
        "GL_SUBGROUP_FEATURE_SHUFFLE_RELATIVE_BIT_KHR" to "0x00000020",
        "GL_SUBGROUP_FEATURE_CLUSTERED_BIT_KHR" to "0x00000040",
        "GL_SUBGROUP_FEATURE_QUAD_BIT_KHR" to "0x00000080"
    )
    file(
        "TextureCompressionAstcHdr", KHR, "GL_KHR_texture_compression_astc_hdr",
        "GL_COMPRESSED_RGBA_ASTC_4x4_KHR" to "0x93B0",
        "GL_COMPRESSED_RGBA_ASTC_5x4_KHR" to "0x93B1",
        "GL_COMPRESSED_RGBA_ASTC_5x5_KHR" to "0x93B2",
        "GL_COMPRESSED_RGBA_ASTC_6x5_KHR" to "0x93B3",
        "GL_COMPRESSED_RGBA_ASTC_6x6_KHR" to "0x93B4",
        "GL_COMPRESSED_RGBA_ASTC_8x5_KHR" to "0x93B5",
        "GL_COMPRESSED_RGBA_ASTC_8x6_KHR" to "0x93B6",
        "GL_COMPRESSED_RGBA_ASTC_8x8_KHR" to "0x93B7",
        "GL_COMPRESSED_RGBA_ASTC_10x5_KHR" to "0x93B8",
        "GL_COMPRESSED_RGBA_ASTC_10x6_KHR" to "0x93B9",
        "GL_COMPRESSED_RGBA_ASTC_10x8_KHR" to "0x93BA",
        "GL_COMPRESSED_RGBA_ASTC_10x10_KHR" to "0x93BB",
        "GL_COMPRESSED_RGBA_ASTC_12x10_KHR" to "0x93BC",
        "GL_COMPRESSED_RGBA_ASTC_12x12_KHR" to "0x93BD",
        "GL_COMPRESSED_SRGB8_ALPHA8_ASTC_4x4_KHR" to "0x93D0",
        "GL_COMPRESSED_SRGB8_ALPHA8_ASTC_5x4_KHR" to "0x93D1",
        "GL_COMPRESSED_SRGB8_ALPHA8_ASTC_5x5_KHR" to "0x93D2",
        "GL_COMPRESSED_SRGB8_ALPHA8_ASTC_6x5_KHR" to "0x93D3",
        "GL_COMPRESSED_SRGB8_ALPHA8_ASTC_6x6_KHR" to "0x93D4",
        "GL_COMPRESSED_SRGB8_ALPHA8_ASTC_8x5_KHR" to "0x93D5",
        "GL_COMPRESSED_SRGB8_ALPHA8_ASTC_8x6_KHR" to "0x93D6",
        "GL_COMPRESSED_SRGB8_ALPHA8_ASTC_8x8_KHR" to "0x93D7",
        "GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x5_KHR" to "0x93D8",
        "GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x6_KHR" to "0x93D9",
        "GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x8_KHR" to "0x93DA",
        "GL_COMPRESSED_SRGB8_ALPHA8_ASTC_10x10_KHR" to "0x93DB",
        "GL_COMPRESSED_SRGB8_ALPHA8_ASTC_12x10_KHR" to "0x93DC",
        "GL_COMPRESSED_SRGB8_ALPHA8_ASTC_12x12_KHR" to "0x93DD"
    )
}

fun oes() {
    file("ByteCoordinates", OES, "GL_OES_byte_coordinates") {
        "glMultiTexCoord1bOES"(void, GLenum("texture"), GLbyte("s"))
        "glMultiTexCoord1bvOES"(void, GLenum("texture"), address("coords", "const GLbyte *"))
        "glMultiTexCoord2bOES"(void, GLenum("texture"), GLbyte("s"), GLbyte("t"))
        "glMultiTexCoord2bvOES"(void, GLenum("texture"), address("coords", "const GLbyte *"))
        "glMultiTexCoord3bOES"(void, GLenum("texture"), GLbyte("s"), GLbyte("t"), GLbyte("r"))
        "glMultiTexCoord3bvOES"(void, GLenum("texture"), address("coords", "const GLbyte *"))
        "glMultiTexCoord4bOES"(void, GLenum("texture"), GLbyte("s"), GLbyte("t"), GLbyte("r"), GLbyte("q"))
        "glMultiTexCoord4bvOES"(void, GLenum("texture"), address("coords", "const GLbyte *"))
        "glTexCoord1bOES"(void, GLbyte("s"))
        "glTexCoord1bvOES"(void, address("coords", "const GLbyte *"))
        "glTexCoord2bOES"(void, GLbyte("s"), GLbyte("t"))
        "glTexCoord2bvOES"(void, address("coords", "const GLbyte *"))
        "glTexCoord3bOES"(void, GLbyte("s"), GLbyte("t"), GLbyte("r"))
        "glTexCoord3bvOES"(void, address("coords", "const GLbyte *"))
        "glTexCoord4bOES"(void, GLbyte("s"), GLbyte("t"), GLbyte("r"), GLbyte("q"))
        "glTexCoord4bvOES"(void, address("coords", "const GLbyte *"))
        "glVertex2bOES"(void, GLbyte("x"), GLbyte("y"))
        "glVertex2bvOES"(void, address("coords", "const GLbyte *"))
        "glVertex3bOES"(void, GLbyte("x"), GLbyte("y"), GLbyte("z"))
        "glVertex3bvOES"(void, address("coords", "const GLbyte *"))
        "glVertex4bOES"(void, GLbyte("x"), GLbyte("y"), GLbyte("z"), GLbyte("w"))
        "glVertex4bvOES"(void, address("coords", "const GLbyte *"))
    }
    file(
        "CompressedPalettedTexture", OES, "GL_OES_compressed_paletted_texture",
        "GL_PALETTE4_RGB8_OES" to "0x8B90",
        "GL_PALETTE4_RGBA8_OES" to "0x8B91",
        "GL_PALETTE4_R5_G6_B5_OES" to "0x8B92",
        "GL_PALETTE4_RGBA4_OES" to "0x8B93",
        "GL_PALETTE4_RGB5_A1_OES" to "0x8B94",
        "GL_PALETTE8_RGB8_OES" to "0x8B95",
        "GL_PALETTE8_RGBA8_OES" to "0x8B96",
        "GL_PALETTE8_R5_G6_B5_OES" to "0x8B97",
        "GL_PALETTE8_RGBA4_OES" to "0x8B98",
        "GL_PALETTE8_RGB5_A1_OES" to "0x8B99"
    )
    file("FixedPoint", OES, "GL_OES_fixed_point") {
        "GL_FIXED_OES"("0x140C")
        "glAlphaFuncxOES"(void, GLenum("func"), GLfixed("ref"))
        "glClearColorxOES"(void, GLfixed("red"), GLfixed("green"), GLfixed("blue"), GLfixed("alpha"))
        "glClearDepthxOES"(void, GLfixed("depth"))
        "glClipPlanexOES"(void, GLenum("plane"), address("equation", "const GLfixed *"))
        "glColor4xOES"(void, GLfixed("red"), GLfixed("green"), GLfixed("blue"), GLfixed("alpha"))
        "glDepthRangexOES"(void, GLfixed("n"), GLfixed("f"))
        "glFogxOES"(void, GLenum("pname"), GLfixed("param"))
        "glFogxvOES"(void, GLenum("pname"), address("param", "const GLfixed *"))
        "glFrustumxOES"(void, GLfixed("l"), GLfixed("r"), GLfixed("b"), GLfixed("t"), GLfixed("n"), GLfixed("f"))
        "glGetClipPlanexOES"(void, GLenum("plane"), address("equation", "GLfixed *"))
        "glGetFixedvOES"(void, GLenum("pname"), address("params", "GLfixed *"))
        "glGetTexEnvxvOES"(void, GLenum("target"), GLenum("pname"), address("params", "GLfixed *"))
        "glGetTexParameterxvOES"(void, GLenum("target"), GLenum("pname"), address("params", "GLfixed *"))
        "glLightModelxOES"(void, GLenum("pname"), GLfixed("param"))
        "glLightModelxvOES"(void, GLenum("pname"), address("param", "const GLfixed *"))
        "glLightxOES"(void, GLenum("light"), GLenum("pname"), GLfixed("param"))
        "glLightxvOES"(void, GLenum("light"), GLenum("pname"), address("params", "const GLfixed *"))
        "glLineWidthxOES"(void, GLfixed("width"))
        "glLoadMatrixxOES"(void, address("m", "const GLfixed *"))
        "glMaterialxOES"(void, GLenum("face"), GLenum("pname"), GLfixed("param"))
        "glMaterialxvOES"(void, GLenum("face"), GLenum("pname"), address("param", "const GLfixed *"))
        "glMultMatrixxOES"(void, address("m", "const GLfixed *"))
        "glMultiTexCoord4xOES"(void, GLenum("texture"), GLfixed("s"), GLfixed("t"), GLfixed("r"), GLfixed("q"))
        "glNormal3xOES"(void, GLfixed("nx"), GLfixed("ny"), GLfixed("nz"))
        "glOrthoxOES"(void, GLfixed("l"), GLfixed("r"), GLfixed("b"), GLfixed("t"), GLfixed("n"), GLfixed("f"))
        "glPointParameterxvOES"(void, GLenum("pname"), address("params", "const GLfixed *"))
        "glPointSizexOES"(void, GLfixed("size"))
        "glPolygonOffsetxOES"(void, GLfixed("factor"), GLfixed("units"))
        "glRotatexOES"(void, GLfixed("angle"), GLfixed("x"), GLfixed("y"), GLfixed("z"))
        "glScalexOES"(void, GLfixed("x"), GLfixed("y"), GLfixed("z"))
        "glTexEnvxOES"(void, GLenum("target"), GLenum("pname"), GLfixed("param"))
        "glTexEnvxvOES"(void, GLenum("target"), GLenum("pname"), address("params", "const GLfixed *"))
        "glTexParameterxOES"(void, GLenum("target"), GLenum("pname"), GLfixed("param"))
        "glTexParameterxvOES"(void, GLenum("target"), GLenum("pname"), address("params", "const GLfixed *"))
        "glTranslatexOES"(void, GLfixed("x"), GLfixed("y"), GLfixed("z"))
        "glAccumxOES"(void, GLenum("op"), GLfixed("value"))
        "glBitmapxOES"(
            void,
            GLsizei("width"),
            GLsizei("height"),
            GLfixed("xorig"),
            GLfixed("yorig"),
            GLfixed("xmove"),
            GLfixed("ymove"),
            address("bitmap", "const GLubyte *")
        )
        "glBlendColorxOES"(void, GLfixed("red"), GLfixed("green"), GLfixed("blue"), GLfixed("alpha"))
        "glClearAccumxOES"(void, GLfixed("red"), GLfixed("green"), GLfixed("blue"), GLfixed("alpha"))
        "glColor3xOES"(void, GLfixed("red"), GLfixed("green"), GLfixed("blue"))
        "glColor3xvOES"(void, address("components", "const GLfixed *"))
        "glColor4xvOES"(void, address("components", "const GLfixed *"))
        "glConvolutionParameterxOES"(void, GLenum("target"), GLenum("pname"), GLfixed("param"))
        "glConvolutionParameterxvOES"(void, GLenum("target"), GLenum("pname"), address("params", "const GLfixed *"))
        "glEvalCoord1xOES"(void, GLfixed("u"))
        "glEvalCoord1xvOES"(void, address("coords", "const GLfixed *"))
        "glEvalCoord2xOES"(void, GLfixed("u"), GLfixed("v"))
        "glEvalCoord2xvOES"(void, address("coords", "const GLfixed *"))
        "glFeedbackBufferxOES"(void, GLsizei("n"), GLenum("type"), address("buffer", "const GLfixed *"))
        "glGetConvolutionParameterxvOES"(void, GLenum("target"), GLenum("pname"), address("params", "GLfixed *"))
        "glGetHistogramParameterxvOES"(void, GLenum("target"), GLenum("pname"), address("params", "GLfixed *"))
        "glGetLightxOES"(void, GLenum("light"), GLenum("pname"), address("params", "GLfixed *"))
        "glGetMapxvOES"(void, GLenum("target"), GLenum("query"), address("v", "GLfixed *"))
        "glGetMaterialxOES"(void, GLenum("face"), GLenum("pname"), GLfixed("param"))
        "glGetPixelMapxv"(void, GLenum("map"), GLint("size"), address("values", "GLfixed *"))
        "glGetTexGenxvOES"(void, GLenum("coord"), GLenum("pname"), address("params", "GLfixed *"))
        "glGetTexLevelParameterxvOES"(
            void,
            GLenum("target"),
            GLint("level"),
            GLenum("pname"),
            address("params", "GLfixed *")
        )
        "glIndexxOES"(void, GLfixed("component"))
        "glIndexxvOES"(void, address("component", "const GLfixed *"))
        "glLoadTransposeMatrixxOES"(void, address("m", "const GLfixed *"))
        "glMap1xOES"(
            void,
            GLenum("target"),
            GLfixed("u1"),
            GLfixed("u2"),
            GLint("stride"),
            GLint("order"),
            GLfixed("points")
        )
        "glMap2xOES"(
            void,
            GLenum("target"),
            GLfixed("u1"),
            GLfixed("u2"),
            GLint("ustride"),
            GLint("uorder"),
            GLfixed("v1"),
            GLfixed("v2"),
            GLint("vstride"),
            GLint("vorder"),
            GLfixed("points")
        )
        "glMapGrid1xOES"(void, GLint("n"), GLfixed("u1"), GLfixed("u2"))
        "glMapGrid2xOES"(void, GLint("n"), GLfixed("u1"), GLfixed("u2"), GLfixed("v1"), GLfixed("v2"))
        "glMultTransposeMatrixxOES"(void, address("m", "const GLfixed *"))
        "glMultiTexCoord1xOES"(void, GLenum("texture"), GLfixed("s"))
        "glMultiTexCoord1xvOES"(void, GLenum("texture"), address("coords", "const GLfixed *"))
        "glMultiTexCoord2xOES"(void, GLenum("texture"), GLfixed("s"), GLfixed("t"))
        "glMultiTexCoord2xvOES"(void, GLenum("texture"), address("coords", "const GLfixed *"))
        "glMultiTexCoord3xOES"(void, GLenum("texture"), GLfixed("s"), GLfixed("t"), GLfixed("r"))
        "glMultiTexCoord3xvOES"(void, GLenum("texture"), address("coords", "const GLfixed *"))
        "glMultiTexCoord4xvOES"(void, GLenum("texture"), address("coords", "const GLfixed *"))
        "glNormal3xvOES"(void, address("coords", "const GLfixed *"))
        "glPassThroughxOES"(void, GLfixed("token"))
        "glPixelMapx"(void, GLenum("map"), GLint("size"), address("values", "const GLfixed *"))
        "glPixelStorex"(void, GLenum("pname"), GLfixed("param"))
        "glPixelTransferxOES"(void, GLenum("pname"), GLfixed("param"))
        "glPixelZoomxOES"(void, GLfixed("xfactor"), GLfixed("yfactor"))
        "glPrioritizeTexturesxOES"(
            void,
            GLsizei("n"),
            address("textures", "const GLuint *"),
            address("priorities", "const GLfixed *")
        )
        "glRasterPos2xOES"(void, GLfixed("x"), GLfixed("y"))
        "glRasterPos2xvOES"(void, address("coords", "const GLfixed *"))
        "glRasterPos3xOES"(void, GLfixed("x"), GLfixed("y"), GLfixed("z"))
        "glRasterPos3xvOES"(void, address("coords", "const GLfixed *"))
        "glRasterPos4xOES"(void, GLfixed("x"), GLfixed("y"), GLfixed("z"), GLfixed("w"))
        "glRasterPos4xvOES"(void, address("coords", "const GLfixed *"))
        "glRectxOES"(void, GLfixed("x1"), GLfixed("y1"), GLfixed("x2"), GLfixed("y2"))
        "glRectxvOES"(void, address("v1", "const GLfixed *"), address("v2", "const GLfixed *"))
        "glTexCoord1xOES"(void, GLfixed("s"))
        "glTexCoord1xvOES"(void, address("coords", "const GLfixed *"))
        "glTexCoord2xOES"(void, GLfixed("s"), GLfixed("t"))
        "glTexCoord2xvOES"(void, address("coords", "const GLfixed *"))
        "glTexCoord3xOES"(void, GLfixed("s"), GLfixed("t"), GLfixed("r"))
        "glTexCoord3xvOES"(void, address("coords", "const GLfixed *"))
        "glTexCoord4xOES"(void, GLfixed("s"), GLfixed("t"), GLfixed("r"), GLfixed("q"))
        "glTexCoord4xvOES"(void, address("coords", "const GLfixed *"))
        "glTexGenxOES"(void, GLenum("coord"), GLenum("pname"), GLfixed("param"))
        "glTexGenxvOES"(void, GLenum("coord"), GLenum("pname"), address("params", "const GLfixed *"))
        "glVertex2xOES"(void, GLfixed("x"))
        "glVertex2xvOES"(void, address("coords", "const GLfixed *"))
        "glVertex3xOES"(void, GLfixed("x"), GLfixed("y"))
        "glVertex3xvOES"(void, address("coords", "const GLfixed *"))
        "glVertex4xOES"(void, GLfixed("x"), GLfixed("y"), GLfixed("z"))
        "glVertex4xvOES"(void, address("coords", "const GLfixed *"))
    }
    file("QueryMatrix", OES, "GL_OES_query_matrix") {
        "glQueryMatrixxOES"(GLbitfield, address("mantissa", "GLfixed *"), address("exponent", "GLint *"))
    }
    file(
        "ReadFormat", OES, "GL_OES_read_format",
        "GL_IMPLEMENTATION_COLOR_READ_TYPE_OES" to "0x8B9A",
        "GL_IMPLEMENTATION_COLOR_READ_FORMAT_OES" to "0x8B9B"
    )
    file("SinglePrecision", OES, "GL_OES_single_precision") {
        "glClearDepthfOES"(void, GLclampf("depth"))
        "glClipPlanefOES"(void, GLenum("plane"), address("equation", "const GLfloat *"))
        "glDepthRangefOES"(void, GLclampf("n"), GLclampf("f"))
        "glFrustumfOES"(void, GLfloat("l"), GLfloat("r"), GLfloat("b"), GLfloat("t"), GLfloat("n"), GLfloat("f"))
        "glGetClipPlanefOES"(void, GLenum("plane"), address("equation", "GLfloat *"))
        "glOrthofOES"(void, GLfloat("l"), GLfloat("r"), GLfloat("b"), GLfloat("t"), GLfloat("n"), GLfloat("f"))
    }
}

fun `3dfx`() {
    file(
        "Multisample", `3DFX`, "GL_3DFX_multisample",
        "GL_MULTISAMPLE_3DFX" to "0x86B2",
        "GL_SAMPLE_BUFFERS_3DFX" to "0x86B3",
        "GL_SAMPLES_3DFX" to "0x86B4",
        "GL_MULTISAMPLE_BIT_3DFX" to "0x20000000"
    )
    file("Tbuffer", `3DFX`, "GL_3DFX_tbuffer") {
        "glTbufferMask3DFX"(void, GLuint("mask"))
    }
    file(
        "TextureCompressionFXT1", `3DFX`, "GL_3DFX_texture_compression_FXT1",
        "GL_COMPRESSED_RGB_FXT1_3DFX" to "0x86B0",
        "GL_COMPRESSED_RGBA_FXT1_3DFX" to "0x86B1"
    )
}

fun amd() {
    file(
        "BlendMinmaxFactor", AMD, "GL_AMD_blend_minmax_factor",
        "GL_FACTOR_MIN_AMD" to "0x901C",
        "GL_FACTOR_MAX_AMD" to "0x901D"
    )
    file("DebugOutput", AMD, "GL_AMD_debug_output") {
        "GL_MAX_DEBUG_MESSAGE_LENGTH_AMD"("0x9143")
        "GL_MAX_DEBUG_LOGGED_MESSAGES_AMD"("0x9144")
        "GL_DEBUG_LOGGED_MESSAGES_AMD"("0x9145")
        "GL_DEBUG_SEVERITY_HIGH_AMD"("0x9146")
        "GL_DEBUG_SEVERITY_MEDIUM_AMD"("0x9147")
        "GL_DEBUG_SEVERITY_LOW_AMD"("0x9148")
        "GL_DEBUG_CATEGORY_API_ERROR_AMD"("0x9149")
        "GL_DEBUG_CATEGORY_WINDOW_SYSTEM_AMD"("0x914A")
        "GL_DEBUG_CATEGORY_DEPRECATION_AMD"("0x914B")
        "GL_DEBUG_CATEGORY_UNDEFINED_BEHAVIOR_AMD"("0x914C")
        "GL_DEBUG_CATEGORY_PERFORMANCE_AMD"("0x914D")
        "GL_DEBUG_CATEGORY_SHADER_COMPILER_AMD"("0x914E")
        "GL_DEBUG_CATEGORY_APPLICATION_AMD"("0x914F")
        "GL_DEBUG_CATEGORY_OTHER_AMD"("0x9150")
        "glDebugMessageEnableAMD"(
            void,
            GLenum("category"),
            GLenum("severity"),
            GLsizei("count"),
            address("ids", "const GLuint *"),
            GLboolean("enabled")
        )
        "glDebugMessageInsertAMD"(
            void,
            GLenum("category"),
            GLenum("severity"),
            GLuint("id"),
            GLsizei("length"),
            address("buf", "const GLchar *")
        )
        ("glDebugMessageCallbackAMD"(void, address("callback", "GLDEBUGPROCAMD"), address("userParam", "void *"))) {
            "glDebugMessageCallbackAMD"(
                void,
                "glDebugMessageCallbackAMD(callback.address(arena), userParam);",
                arena("arena"),
                Type("GLDebugProcAMD", null)("callback"),
                address("userParam", "void *")
            )
        }
        "glGetDebugMessageLogAMD"(
            GLuint,
            GLuint("count"),
            GLsizei("bufSize"),
            address("categories", "GLenum *"),
            address("severities", "GLenum *"),
            address("ids", "GLuint *"),
            address("lengths", "GLsizei *"),
            address("message", "GLchar *")
        )
    }
    file(
        "DepthClampSeparate", AMD, "GL_AMD_depth_clamp_separate",
        "GL_DEPTH_CLAMP_NEAR_AMD" to "0x901E",
        "GL_DEPTH_CLAMP_FAR_AMD" to "0x901F"
    )
    file("DrawBuffersBlend", AMD, "GL_AMD_draw_buffers_blend") {
        "glBlendFuncIndexedAMD"(void, GLuint("buf"), GLenum("src"), GLenum("dst"))
        "glBlendFuncSeparateIndexedAMD"(
            void,
            GLuint("buf"),
            GLenum("srcRGB"),
            GLenum("dstRGB"),
            GLenum("srcAlpha"),
            GLenum("dstAlpha")
        )
        "glBlendEquationIndexedAMD"(void, GLuint("buf"), GLenum("mode"))
        "glBlendEquationSeparateIndexedAMD"(void, GLuint("buf"), GLenum("modeRGB"), GLenum("modeAlpha"))
    }
    file("FramebufferMultisampleAdvanced", AMD, "GL_AMD_framebuffer_multisample_advanced") {
        "GL_RENDERBUFFER_STORAGE_SAMPLES_AMD"("0x91B2")
        "GL_MAX_COLOR_FRAMEBUFFER_SAMPLES_AMD"("0x91B3")
        "GL_MAX_COLOR_FRAMEBUFFER_STORAGE_SAMPLES_AMD"("0x91B4")
        "GL_MAX_DEPTH_STENCIL_FRAMEBUFFER_SAMPLES_AMD"("0x91B5")
        "GL_NUM_SUPPORTED_MULTISAMPLE_MODES_AMD"("0x91B6")
        "GL_SUPPORTED_MULTISAMPLE_MODES_AMD"("0x91B7")
        "glRenderbufferStorageMultisampleAdvancedAMD"(
            void,
            GLenum("target"),
            GLsizei("samples"),
            GLsizei("storageSamples"),
            GLenum("internalformat"),
            GLsizei("width"),
            GLsizei("height")
        )
        "glNamedRenderbufferStorageMultisampleAdvancedAMD"(
            void,
            GLuint("renderbuffer"),
            GLsizei("samples"),
            GLsizei("storageSamples"),
            GLenum("internalformat"),
            GLsizei("width"),
            GLsizei("height")
        )
    }
    file("FramebufferSamplePositions", AMD, "GL_AMD_framebuffer_sample_positions") {
        "GL_SUBSAMPLE_DISTANCE_AMD"("0x883F")
        "GL_PIXELS_PER_SAMPLE_PATTERN_X_AMD"("0x91AE")
        "GL_PIXELS_PER_SAMPLE_PATTERN_Y_AMD"("0x91AF")
        "GL_ALL_PIXELS_AMD"("0xFFFFFFFF")
        "glFramebufferSamplePositionsfvAMD"(
            void,
            GLenum("target"),
            GLuint("numsamples"),
            GLuint("pixelindex"),
            address("values", "const GLfloat *")
        )
        "glNamedFramebufferSamplePositionsfvAMD"(
            void,
            GLuint("framebuffer"),
            GLuint("numsamples"),
            GLuint("pixelindex"),
            address("values", "const GLfloat *")
        )
        "glGetFramebufferParameterfvAMD"(
            void,
            GLenum("target"),
            GLenum("pname"),
            GLuint("numsamples"),
            GLuint("pixelindex"),
            GLsizei("size"),
            address("values", "GLfloat *")
        )
        "glGetNamedFramebufferParameterfvAMD"(
            void,
            GLuint("framebuffer"),
            GLenum("pname"),
            GLuint("numsamples"),
            GLuint("pixelindex"),
            GLsizei("size"),
            address("values", "GLfloat *")
        )
    }
    file(
        "GpuShaderHalfFloat", AMD, "GL_AMD_gpu_shader_half_float",
        "GL_FLOAT16_NV" to "0x8FF8",
        "GL_FLOAT16_VEC2_NV" to "0x8FF9",
        "GL_FLOAT16_VEC3_NV" to "0x8FFA",
        "GL_FLOAT16_VEC4_NV" to "0x8FFB",
        "GL_FLOAT16_MAT2_AMD" to "0x91C5",
        "GL_FLOAT16_MAT3_AMD" to "0x91C6",
        "GL_FLOAT16_MAT4_AMD" to "0x91C7",
        "GL_FLOAT16_MAT2x3_AMD" to "0x91C8",
        "GL_FLOAT16_MAT2x4_AMD" to "0x91C9",
        "GL_FLOAT16_MAT3x2_AMD" to "0x91CA",
        "GL_FLOAT16_MAT3x4_AMD" to "0x91CB",
        "GL_FLOAT16_MAT4x2_AMD" to "0x91CC",
        "GL_FLOAT16_MAT4x3_AMD" to "0x91CD"
    )
    file("GpuShaderInt64", AMD, "GL_AMD_gpu_shader_int64") {
        "GL_INT64_NV"("0x140E")
        "GL_UNSIGNED_INT64_NV"("0x140F")
        "GL_INT8_NV"("0x8FE0")
        "GL_INT8_VEC2_NV"("0x8FE1")
        "GL_INT8_VEC3_NV"("0x8FE2")
        "GL_INT8_VEC4_NV"("0x8FE3")
        "GL_INT16_NV"("0x8FE4")
        "GL_INT16_VEC2_NV"("0x8FE5")
        "GL_INT16_VEC3_NV"("0x8FE6")
        "GL_INT16_VEC4_NV"("0x8FE7")
        "GL_INT64_VEC2_NV"("0x8FE9")
        "GL_INT64_VEC3_NV"("0x8FEA")
        "GL_INT64_VEC4_NV"("0x8FEB")
        "GL_UNSIGNED_INT8_NV"("0x8FEC")
        "GL_UNSIGNED_INT8_VEC2_NV"("0x8FED")
        "GL_UNSIGNED_INT8_VEC3_NV"("0x8FEE")
        "GL_UNSIGNED_INT8_VEC4_NV"("0x8FEF")
        "GL_UNSIGNED_INT16_NV"("0x8FF0")
        "GL_UNSIGNED_INT16_VEC2_NV"("0x8FF1")
        "GL_UNSIGNED_INT16_VEC3_NV"("0x8FF2")
        "GL_UNSIGNED_INT16_VEC4_NV"("0x8FF3")
        "GL_UNSIGNED_INT64_VEC2_NV"("0x8FF5")
        "GL_UNSIGNED_INT64_VEC3_NV"("0x8FF6")
        "GL_UNSIGNED_INT64_VEC4_NV"("0x8FF7")
        "glUniform1i64NV"(void, GLint("location"), GLint64EXT("x"))
        "glUniform2i64NV"(void, GLint("location"), GLint64EXT("x"), GLint64EXT("y"))
        "glUniform3i64NV"(void, GLint("location"), GLint64EXT("x"), GLint64EXT("y"), GLint64EXT("z"))
        "glUniform4i64NV"(void, GLint("location"), GLint64EXT("x"), GLint64EXT("y"), GLint64EXT("z"), GLint64EXT("w"))
        "glUniform1i64vNV"(void, GLint("location"), GLsizei("count"), address("value", "const GLint64EXT *"))
        "glUniform2i64vNV"(void, GLint("location"), GLsizei("count"), address("value", "const GLint64EXT *"))
        "glUniform3i64vNV"(void, GLint("location"), GLsizei("count"), address("value", "const GLint64EXT *"))
        "glUniform4i64vNV"(void, GLint("location"), GLsizei("count"), address("value", "const GLint64EXT *"))
        "glUniform1ui64NV"(void, GLint("location"), GLuint64EXT("x"))
        "glUniform2ui64NV"(void, GLint("location"), GLuint64EXT("x"), GLuint64EXT("y"))
        "glUniform3ui64NV"(void, GLint("location"), GLuint64EXT("x"), GLuint64EXT("y"), GLuint64EXT("z"))
        "glUniform4ui64NV"(
            void,
            GLint("location"),
            GLuint64EXT("x"),
            GLuint64EXT("y"),
            GLuint64EXT("z"),
            GLuint64EXT("w")
        )
        "glUniform1ui64vNV"(void, GLint("location"), GLsizei("count"), address("value", "const GLuint64EXT *"))
        "glUniform2ui64vNV"(void, GLint("location"), GLsizei("count"), address("value", "const GLuint64EXT *"))
        "glUniform3ui64vNV"(void, GLint("location"), GLsizei("count"), address("value", "const GLuint64EXT *"))
        "glUniform4ui64vNV"(void, GLint("location"), GLsizei("count"), address("value", "const GLuint64EXT *"))
        "glGetUniformi64vNV"(void, GLuint("program"), GLint("location"), address("params", "GLint64EXT *"))
        "glGetUniformui64vNV"(void, GLuint("program"), GLint("location"), address("params", "GLuint64EXT *"))
        "glProgramUniform1i64NV"(void, GLuint("program"), GLint("location"), GLint64EXT("x"))
        "glProgramUniform2i64NV"(void, GLuint("program"), GLint("location"), GLint64EXT("x"), GLint64EXT("y"))
        "glProgramUniform3i64NV"(
            void,
            GLuint("program"),
            GLint("location"),
            GLint64EXT("x"),
            GLint64EXT("y"),
            GLint64EXT("z")
        )
        "glProgramUniform4i64NV"(
            void,
            GLuint("program"),
            GLint("location"),
            GLint64EXT("x"),
            GLint64EXT("y"),
            GLint64EXT("z"),
            GLint64EXT("w")
        )
        "glProgramUniform1i64vNV"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("value", "const GLint64EXT *")
        )
        "glProgramUniform2i64vNV"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("value", "const GLint64EXT *")
        )
        "glProgramUniform3i64vNV"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("value", "const GLint64EXT *")
        )
        "glProgramUniform4i64vNV"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("value", "const GLint64EXT *")
        )
        "glProgramUniform1ui64NV"(void, GLuint("program"), GLint("location"), GLuint64EXT("x"))
        "glProgramUniform2ui64NV"(void, GLuint("program"), GLint("location"), GLuint64EXT("x"), GLuint64EXT("y"))
        "glProgramUniform3ui64NV"(
            void,
            GLuint("program"),
            GLint("location"),
            GLuint64EXT("x"),
            GLuint64EXT("y"),
            GLuint64EXT("z")
        )
        "glProgramUniform4ui64NV"(
            void,
            GLuint("program"),
            GLint("location"),
            GLuint64EXT("x"),
            GLuint64EXT("y"),
            GLuint64EXT("z"),
            GLuint64EXT("w")
        )
        "glProgramUniform1ui64vNV"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("value", "const GLuint64EXT *")
        )
        "glProgramUniform2ui64vNV"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("value", "const GLuint64EXT *")
        )
        "glProgramUniform3ui64vNV"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("value", "const GLuint64EXT *")
        )
        "glProgramUniform4ui64vNV"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("value", "const GLuint64EXT *")
        )
    }
    file("InterleavedElements", AMD, "GL_AMD_interleaved_elements") {
        "GL_VERTEX_ELEMENT_SWIZZLE_AMD"("0x91A4")
        "GL_VERTEX_ID_SWIZZLE_AMD"("0x91A5")
        "glVertexAttribParameteriAMD"(void, GLuint("index"), GLenum("pname"), GLint("param"))
    }
    file("MultiDrawIndirect", AMD, "GL_AMD_multi_draw_indirect") {
        "glMultiDrawArraysIndirectAMD"(
            void,
            GLenum("mode"),
            address("indirect", "const void *"),
            GLsizei("primcount"),
            GLsizei("stride")
        )
        "glMultiDrawElementsIndirectAMD"(
            void,
            GLenum("mode"),
            GLenum("type"),
            address("indirect", "const void *"),
            GLsizei("primcount"),
            GLsizei("stride")
        )
    }
    file("NameGenDelete", AMD, "GL_AMD_name_gen_delete") {
        "GL_DATA_BUFFER_AMD"("0x9151")
        "GL_PERFORMANCE_MONITOR_AMD"("0x9152")
        "GL_QUERY_OBJECT_AMD"("0x9153")
        "GL_VERTEX_ARRAY_OBJECT_AMD"("0x9154")
        "GL_SAMPLER_OBJECT_AMD"("0x9155")
        "glGenNamesAMD"(void, GLenum("identifier"), GLuint("num"), address("names", "GLuint *"))
        "glDeleteNamesAMD"(void, GLenum("identifier"), GLuint("num"), address("names", "const GLuint *"))
        "glIsNameAMD"(GLboolean, GLenum("identifier"), GLuint("name"))
    }
    file("OcclusionQueryEvent", AMD, "GL_AMD_occlusion_query_event") {
        "GL_OCCLUSION_QUERY_EVENT_MASK_AMD"("0x874F")
        "GL_QUERY_DEPTH_PASS_EVENT_BIT_AMD"("0x00000001")
        "GL_QUERY_DEPTH_FAIL_EVENT_BIT_AMD"("0x00000002")
        "GL_QUERY_STENCIL_FAIL_EVENT_BIT_AMD"("0x00000004")
        "GL_QUERY_DEPTH_BOUNDS_FAIL_EVENT_BIT_AMD"("0x00000008")
        "GL_QUERY_ALL_EVENT_BITS_AMD"("0xFFFFFFFF")
        "glQueryObjectParameteruiAMD"(void, GLenum("target"), GLuint("id"), GLenum("pname"), GLuint("param"))
    }
    file("PerformanceMonitor", AMD, "GL_AMD_performance_monitor") {
        "GL_COUNTER_TYPE_AMD"("0x8BC0")
        "GL_COUNTER_RANGE_AMD"("0x8BC1")
        "GL_UNSIGNED_INT64_AMD"("0x8BC2")
        "GL_PERCENTAGE_AMD"("0x8BC3")
        "GL_PERFMON_RESULT_AVAILABLE_AMD"("0x8BC4")
        "GL_PERFMON_RESULT_SIZE_AMD"("0x8BC5")
        "GL_PERFMON_RESULT_AMD"("0x8BC6")
        "glGetPerfMonitorGroupsAMD"(
            void,
            address("numGroups", "GLint *"),
            GLsizei("groupsSize"),
            address("groups", "GLuint *")
        )
        "glGetPerfMonitorCountersAMD"(
            void,
            GLuint("group"),
            address("numCounters", "GLint *"),
            address("maxActiveCounters", "GLint *"),
            GLsizei("counterSize"),
            address("counters", "GLuint *")
        )
        "glGetPerfMonitorGroupStringAMD"(
            void,
            GLuint("group"),
            GLsizei("bufSize"),
            address("length", "GLsizei *"),
            address("groupString", "GLchar *")
        )
        "glGetPerfMonitorCounterStringAMD"(
            void,
            GLuint("group"),
            GLuint("counter"),
            GLsizei("bufSize"),
            address("length", "GLsizei *"),
            address("counterString", "GLchar *")
        )
        "glGetPerfMonitorCounterInfoAMD"(
            void,
            GLuint("group"),
            GLuint("counter"),
            GLenum("pname"),
            address("data", "void *")
        )
        "glGenPerfMonitorsAMD"(void, GLsizei("n"), address("monitors", "GLuint *"))
        "glDeletePerfMonitorsAMD"(void, GLsizei("n"), address("monitors", "GLuint *"))
        "glSelectPerfMonitorCountersAMD"(
            void,
            GLuint("monitor"),
            GLboolean("enable"),
            GLuint("group"),
            GLint("numCounters"),
            address("counterList", "GLuint *")
        )
        "glBeginPerfMonitorAMD"(void, GLuint("monitor"))
        "glEndPerfMonitorAMD"(void, GLuint("monitor"))
        "glGetPerfMonitorCounterDataAMD"(
            void,
            GLuint("monitor"),
            GLenum("pname"),
            GLsizei("dataSize"),
            address("data", "GLuint *"),
            address("bytesWritten", "GLint *")
        )
    }
    file("PinnedMemory", AMD, "GL_AMD_pinned_memory", "GL_EXTERNAL_VIRTUAL_MEMORY_BUFFER_AMD" to "0x9160")
    file(
        "QueryBufferObject", AMD, "GL_AMD_query_buffer_object",
        "GL_QUERY_BUFFER_AMD" to "0x9192",
        "GL_QUERY_BUFFER_BINDING_AMD" to "0x9193",
        "GL_QUERY_RESULT_NO_WAIT_AMD" to "0x9194"
    )
    file("SamplePositions", AMD, "GL_AMD_sample_positions") {
        "glSetMultisamplefvAMD"(void, GLenum("pname"), GLuint("index"), address("val", "const GLfloat *"))
    }
    file("SparseTexture", AMD, "GL_AMD_sparse_texture") {
        "GL_VIRTUAL_PAGE_SIZE_X_AMD"("0x9195")
        "GL_VIRTUAL_PAGE_SIZE_Y_AMD"("0x9196")
        "GL_VIRTUAL_PAGE_SIZE_Z_AMD"("0x9197")
        "GL_MAX_SPARSE_TEXTURE_SIZE_AMD"("0x9198")
        "GL_MAX_SPARSE_3D_TEXTURE_SIZE_AMD"("0x9199")
        "GL_MAX_SPARSE_ARRAY_TEXTURE_LAYERS"("0x919A")
        "GL_MIN_SPARSE_LEVEL_AMD"("0x919B")
        "GL_MIN_LOD_WARNING_AMD"("0x919C")
        "GL_TEXTURE_STORAGE_SPARSE_BIT_AMD"("0x00000001")
        "glTexStorageSparseAMD"(
            void,
            GLenum("target"),
            GLenum("internalFormat"),
            GLsizei("width"),
            GLsizei("height"),
            GLsizei("depth"),
            GLsizei("layers"),
            GLbitfield("flags")
        )
        "glTextureStorageSparseAMD"(
            void,
            GLuint("texture"),
            GLenum("target"),
            GLenum("internalFormat"),
            GLsizei("width"),
            GLsizei("height"),
            GLsizei("depth"),
            GLsizei("layers"),
            GLbitfield("flags")
        )
    }
    file("StencilOperationExtended", AMD, "GL_AMD_stencil_operation_extended") {
        "GL_SET_AMD"("0x874A")
        "GL_REPLACE_VALUE_AMD"("0x874B")
        "GL_STENCIL_OP_VALUE_AMD"("0x874C")
        "GL_STENCIL_BACK_OP_VALUE_AMD"("0x874D")
        "glStencilOpValueAMD"(void, GLenum("face"), GLuint("value"))
    }
    file("TransformFeedback4", AMD, "GL_AMD_transform_feedback4", "GL_STREAM_RASTERIZATION_AMD" to "0x91A0")
    file("VertexShaderTessellator", AMD, "GL_AMD_vertex_shader_tessellator") {
        "GL_SAMPLER_BUFFER_AMD"("0x9001")
        "GL_INT_SAMPLER_BUFFER_AMD"("0x9002")
        "GL_UNSIGNED_INT_SAMPLER_BUFFER_AMD"("0x9003")
        "GL_TESSELLATION_MODE_AMD"("0x9004")
        "GL_TESSELLATION_FACTOR_AMD"("0x9005")
        "GL_DISCRETE_AMD"("0x9006")
        "GL_CONTINUOUS_AMD"("0x9007")
        "glTessellationFactorAMD"(void, GLfloat("factor"))
        "glTessellationModeAMD"(void, GLenum("mode"))
    }
}

fun apple() {
    file("AuxDepthStencil", APPLE, "GL_APPLE_aux_depth_stencil", "GL_AUX_DEPTH_STENCIL_APPLE" to "0x8A14")
    file("ClientStorage", APPLE, "GL_APPLE_client_storage", "GL_UNPACK_CLIENT_STORAGE_APPLE" to "0x85B2")
    file("ElementArray", APPLE, "GL_APPLE_element_array") {
        "GL_ELEMENT_ARRAY_APPLE"("0x8A0C")
        "GL_ELEMENT_ARRAY_TYPE_APPLE"("0x8A0D")
        "GL_ELEMENT_ARRAY_POINTER_APPLE"("0x8A0E")
        "glElementPointerAPPLE"(void, GLenum("type"), address("pointer", "const void *"))
        "glDrawElementArrayAPPLE"(void, GLenum("mode"), GLint("first"), GLsizei("count"))
        "glDrawRangeElementArrayAPPLE"(
            void,
            GLenum("mode"),
            GLuint("start"),
            GLuint("end"),
            GLint("first"),
            GLsizei("count")
        )
        "glMultiDrawElementArrayAPPLE"(
            void,
            GLenum("mode"),
            address("first", "const GLint *"),
            address("count", "const GLsizei *"),
            GLsizei("primcount")
        )
        "glMultiDrawRangeElementArrayAPPLE"(
            void,
            GLenum("mode"),
            GLuint("start"),
            GLuint("end"),
            address("first", "const GLint *"),
            address("count", "const GLsizei *"),
            GLsizei("primcount")
        )
    }
    file("Fence", APPLE, "GL_APPLE_fence") {
        "GL_DRAW_PIXELS_APPLE"("0x8A0A")
        "GL_FENCE_APPLE"("0x8A0B")
        "glGenFencesAPPLE"(void, GLsizei("n"), address("fences", "GLuint *"))
        "glDeleteFencesAPPLE"(void, GLsizei("n"), address("fences", "const GLuint *"))
        "glSetFenceAPPLE"(void, GLuint("fence"))
        "glIsFenceAPPLE"(GLboolean, GLuint("fence"))
        "glTestFenceAPPLE"(GLboolean, GLuint("fence"))
        "glFinishFenceAPPLE"(void, GLuint("fence"))
        "glTestObjectAPPLE"(GLboolean, GLenum("object"), GLuint("name"))
        "glFinishObjectAPPLE"(void, GLenum("object"), GLint("name"))
    }
    file(
        "FloatPixels", APPLE, "GL_APPLE_float_pixels",
        "GL_HALF_APPLE" to "0x140B",
        "GL_RGBA_FLOAT32_APPLE" to "0x8814",
        "GL_RGB_FLOAT32_APPLE" to "0x8815",
        "GL_ALPHA_FLOAT32_APPLE" to "0x8816",
        "GL_INTENSITY_FLOAT32_APPLE" to "0x8817",
        "GL_LUMINANCE_FLOAT32_APPLE" to "0x8818",
        "GL_LUMINANCE_ALPHA_FLOAT32_APPLE" to "0x8819",
        "GL_RGBA_FLOAT16_APPLE" to "0x881A",
        "GL_RGB_FLOAT16_APPLE" to "0x881B",
        "GL_ALPHA_FLOAT16_APPLE" to "0x881C",
        "GL_INTENSITY_FLOAT16_APPLE" to "0x881D",
        "GL_LUMINANCE_FLOAT16_APPLE" to "0x881E",
        "GL_LUMINANCE_ALPHA_FLOAT16_APPLE" to "0x881F",
        "GL_COLOR_FLOAT_APPLE" to "0x8A0F"
    )
    file("FlushBufferRange", APPLE, "GL_APPLE_flush_buffer_range") {
        "GL_BUFFER_SERIALIZED_MODIFY_APPLE"("0x8A12")
        "GL_BUFFER_FLUSHING_UNMAP_APPLE"("0x8A13")
        "glBufferParameteriAPPLE"(void, GLenum("target"), GLenum("pname"), GLint("param"))
        "glFlushMappedBufferRangeAPPLE"(void, GLenum("target"), GLintptr("offset"), GLsizeiptr("size"))
    }
    file("ObjectPurgeable", APPLE, "GL_APPLE_object_purgeable") {
        "GL_BUFFER_OBJECT_APPLE"("0x85B3")
        "GL_RELEASED_APPLE"("0x8A19")
        "GL_VOLATILE_APPLE"("0x8A1A")
        "GL_RETAINED_APPLE"("0x8A1B")
        "GL_UNDEFINED_APPLE"("0x8A1C")
        "GL_PURGEABLE_APPLE"("0x8A1D")
        "glObjectPurgeableAPPLE"(GLenum, GLenum("objectType"), GLuint("name"), GLenum("option"))
        "glObjectUnpurgeableAPPLE"(GLenum, GLenum("objectType"), GLuint("name"), GLenum("option"))
        "glGetObjectParameterivAPPLE"(
            void,
            GLenum("objectType"),
            GLuint("name"),
            GLenum("pname"),
            address("params", "GLint *")
        )
    }
    file(
        "Rgb422", APPLE, "GL_APPLE_rgb_422",
        "GL_RGB_422_APPLE" to "0x8A1F",
        "GL_UNSIGNED_SHORT_8_8_APPLE" to "0x85BA",
        "GL_UNSIGNED_SHORT_8_8_REV_APPLE" to "0x85BB",
        "GL_RGB_RAW_422_APPLE" to "0x8A51"
    )
    file(
        "RowBytes", APPLE, "GL_APPLE_row_bytes",
        "GL_PACK_ROW_BYTES_APPLE" to "0x8A15",
        "GL_UNPACK_ROW_BYTES_APPLE" to "0x8A16"
    )
    file("SpecularVector", APPLE, "GL_APPLE_specular_vector", "GL_LIGHT_MODEL_SPECULAR_VECTOR_APPLE" to "0x85B0")
    file("TextureRange", APPLE, "GL_APPLE_texture_range") {
        "GL_TEXTURE_RANGE_LENGTH_APPLE"("0x85B7")
        "GL_TEXTURE_RANGE_POINTER_APPLE"("0x85B8")
        "GL_TEXTURE_STORAGE_HINT_APPLE"("0x85BC")
        "GL_STORAGE_PRIVATE_APPLE"("0x85BD")
        "GL_STORAGE_CACHED_APPLE"("0x85BE")
        "GL_STORAGE_SHARED_APPLE"("0x85BF")
        "glTextureRangeAPPLE"(void, GLenum("target"), GLsizei("length"), address("pointer", "const void *"))
        "glGetTexParameterPointervAPPLE"(void, GLenum("target"), GLenum("pname"), address("params", "void **"))
    }
    file("TransformHint", APPLE, "GL_APPLE_transform_hint", "GL_TRANSFORM_HINT_APPLE" to "0x85B1")
    file("VertexArrayObject", APPLE, "GL_APPLE_vertex_array_object") {
        "GL_VERTEX_ARRAY_BINDING_APPLE"("0x85B5")
        "glBindVertexArrayAPPLE"(void, GLuint("array"))
        "glDeleteVertexArraysAPPLE"(void, GLsizei("n"), address("arrays", "const GLuint *"))
        "glGenVertexArraysAPPLE"(void, GLsizei("n"), address("arrays", "GLuint *"))
        "glIsVertexArrayAPPLE"(GLboolean, GLuint("array"))
    }
    file("VertexArrayRange", APPLE, "GL_APPLE_vertex_array_range") {
        "GL_VERTEX_ARRAY_RANGE_APPLE"("0x851D")
        "GL_VERTEX_ARRAY_RANGE_LENGTH_APPLE"("0x851E")
        "GL_VERTEX_ARRAY_STORAGE_HINT_APPLE"("0x851F")
        "GL_VERTEX_ARRAY_RANGE_POINTER_APPLE"("0x8521")
        "GL_STORAGE_CLIENT_APPLE"("0x85B4")
        "glVertexArrayRangeAPPLE"(void, GLsizei("length"), address("pointer", "void *"))
        "glFlushVertexArrayRangeAPPLE"(void, GLsizei("length"), address("pointer", "void *"))
        "glVertexArrayParameteriAPPLE"(void, GLenum("pname"), GLint("param"))
    }
    file("VertexProgramEvaluators", APPLE, "GL_APPLE_vertex_program_evaluators") {
        "GL_VERTEX_ATTRIB_MAP1_APPLE"("0x8A00")
        "GL_VERTEX_ATTRIB_MAP2_APPLE"("0x8A01")
        "GL_VERTEX_ATTRIB_MAP1_SIZE_APPLE"("0x8A02")
        "GL_VERTEX_ATTRIB_MAP1_COEFF_APPLE"("0x8A03")
        "GL_VERTEX_ATTRIB_MAP1_ORDER_APPLE"("0x8A04")
        "GL_VERTEX_ATTRIB_MAP1_DOMAIN_APPLE"("0x8A05")
        "GL_VERTEX_ATTRIB_MAP2_SIZE_APPLE"("0x8A06")
        "GL_VERTEX_ATTRIB_MAP2_COEFF_APPLE"("0x8A07")
        "GL_VERTEX_ATTRIB_MAP2_ORDER_APPLE"("0x8A08")
        "GL_VERTEX_ATTRIB_MAP2_DOMAIN_APPLE"("0x8A09")
        "glEnableVertexAttribAPPLE"(void, GLuint("index"), GLenum("pname"))
        "glDisableVertexAttribAPPLE"(void, GLuint("index"), GLenum("pname"))
        "glIsVertexAttribEnabledAPPLE"(GLboolean, GLuint("index"), GLenum("pname"))
        "glMapVertexAttrib1dAPPLE"(
            void,
            GLuint("index"),
            GLuint("size"),
            GLdouble("u1"),
            GLdouble("u2"),
            GLint("stride"),
            GLint("order"),
            address("points", "const GLdouble *")
        )
        "glMapVertexAttrib1fAPPLE"(
            void,
            GLuint("index"),
            GLuint("size"),
            GLfloat("u1"),
            GLfloat("u2"),
            GLint("stride"),
            GLint("order"),
            address("points", "const GLfloat *")
        )
        "glMapVertexAttrib2dAPPLE"(
            void,
            GLuint("index"),
            GLuint("size"),
            GLdouble("u1"),
            GLdouble("u2"),
            GLint("ustride"),
            GLint("uorder"),
            GLdouble("v1"),
            GLdouble("v2"),
            GLint("vstride"),
            GLint("vorder"),
            address("points", "const GLdouble *")
        )
        "glMapVertexAttrib2fAPPLE"(
            void,
            GLuint("index"),
            GLuint("size"),
            GLfloat("u1"),
            GLfloat("u2"),
            GLint("ustride"),
            GLint("uorder"),
            GLfloat("v1"),
            GLfloat("v2"),
            GLint("vstride"),
            GLint("vorder"),
            address("points", "const GLfloat *")
        )
    }
    file("Ycbcr422", APPLE, "GL_APPLE_ycbcr_422", "GL_YCBCR_422_APPLE" to "0x85B9")
}

fun ati() {
    file("DrawBuffers", ATI, "GL_ATI_draw_buffers") {
        "GL_MAX_DRAW_BUFFERS_ATI"("0x8824")
        "GL_DRAW_BUFFER0_ATI"("0x8825")
        "GL_DRAW_BUFFER1_ATI"("0x8826")
        "GL_DRAW_BUFFER2_ATI"("0x8827")
        "GL_DRAW_BUFFER3_ATI"("0x8828")
        "GL_DRAW_BUFFER4_ATI"("0x8829")
        "GL_DRAW_BUFFER5_ATI"("0x882A")
        "GL_DRAW_BUFFER6_ATI"("0x882B")
        "GL_DRAW_BUFFER7_ATI"("0x882C")
        "GL_DRAW_BUFFER8_ATI"("0x882D")
        "GL_DRAW_BUFFER9_ATI"("0x882E")
        "GL_DRAW_BUFFER10_ATI"("0x882F")
        "GL_DRAW_BUFFER11_ATI"("0x8830")
        "GL_DRAW_BUFFER12_ATI"("0x8831")
        "GL_DRAW_BUFFER13_ATI"("0x8832")
        "GL_DRAW_BUFFER14_ATI"("0x8833")
        "GL_DRAW_BUFFER15_ATI"("0x8834")
        "glDrawBuffersATI"(void, GLsizei("n"), address("bufs", "const GLenum *"))
    }
    file("ElementArray", ATI, "GL_ATI_element_array") {
        "GL_ELEMENT_ARRAY_ATI"("0x8768")
        "GL_ELEMENT_ARRAY_TYPE_ATI"("0x8769")
        "GL_ELEMENT_ARRAY_POINTER_ATI"("0x876A")
        "glElementPointerATI"(void, GLenum("type"), address("pointer", "const void *"))
        "glDrawElementArrayATI"(void, GLenum("mode"), GLsizei("count"))
        "glDrawRangeElementArrayATI"(void, GLenum("mode"), GLuint("start"), GLuint("end"), GLsizei("count"))
    }
    file("EnvmapBumpmap", ATI, "GL_ATI_envmap_bumpmap") {
        "GL_BUMP_ROT_MATRIX_ATI"("0x8775")
        "GL_BUMP_ROT_MATRIX_SIZE_ATI"("0x8776")
        "GL_BUMP_NUM_TEX_UNITS_ATI"("0x8777")
        "GL_BUMP_TEX_UNITS_ATI"("0x8778")
        "GL_DUDV_ATI"("0x8779")
        "GL_DU8DV8_ATI"("0x877A")
        "GL_BUMP_ENVMAP_ATI"("0x877B")
        "GL_BUMP_TARGET_ATI"("0x877C")
        "glTexBumpParameterivATI"(void, GLenum("pname"), address("param", "const GLint *"))
        "glTexBumpParameterfvATI"(void, GLenum("pname"), address("param", "const GLfloat *"))
        "glGetTexBumpParameterivATI"(void, GLenum("pname"), address("param", "GLint *"))
        "glGetTexBumpParameterfvATI"(void, GLenum("pname"), address("param", "GLfloat *"))
    }
    file("FragmentShader", ATI, "GL_ATI_fragment_shader") {
        "GL_FRAGMENT_SHADER_ATI"("0x8920")
        "GL_REG_0_ATI"("0x8921")
        "GL_REG_1_ATI"("0x8922")
        "GL_REG_2_ATI"("0x8923")
        "GL_REG_3_ATI"("0x8924")
        "GL_REG_4_ATI"("0x8925")
        "GL_REG_5_ATI"("0x8926")
        "GL_REG_6_ATI"("0x8927")
        "GL_REG_7_ATI"("0x8928")
        "GL_REG_8_ATI"("0x8929")
        "GL_REG_9_ATI"("0x892A")
        "GL_REG_10_ATI"("0x892B")
        "GL_REG_11_ATI"("0x892C")
        "GL_REG_12_ATI"("0x892D")
        "GL_REG_13_ATI"("0x892E")
        "GL_REG_14_ATI"("0x892F")
        "GL_REG_15_ATI"("0x8930")
        "GL_REG_16_ATI"("0x8931")
        "GL_REG_17_ATI"("0x8932")
        "GL_REG_18_ATI"("0x8933")
        "GL_REG_19_ATI"("0x8934")
        "GL_REG_20_ATI"("0x8935")
        "GL_REG_21_ATI"("0x8936")
        "GL_REG_22_ATI"("0x8937")
        "GL_REG_23_ATI"("0x8938")
        "GL_REG_24_ATI"("0x8939")
        "GL_REG_25_ATI"("0x893A")
        "GL_REG_26_ATI"("0x893B")
        "GL_REG_27_ATI"("0x893C")
        "GL_REG_28_ATI"("0x893D")
        "GL_REG_29_ATI"("0x893E")
        "GL_REG_30_ATI"("0x893F")
        "GL_REG_31_ATI"("0x8940")
        "GL_CON_0_ATI"("0x8941")
        "GL_CON_1_ATI"("0x8942")
        "GL_CON_2_ATI"("0x8943")
        "GL_CON_3_ATI"("0x8944")
        "GL_CON_4_ATI"("0x8945")
        "GL_CON_5_ATI"("0x8946")
        "GL_CON_6_ATI"("0x8947")
        "GL_CON_7_ATI"("0x8948")
        "GL_CON_8_ATI"("0x8949")
        "GL_CON_9_ATI"("0x894A")
        "GL_CON_10_ATI"("0x894B")
        "GL_CON_11_ATI"("0x894C")
        "GL_CON_12_ATI"("0x894D")
        "GL_CON_13_ATI"("0x894E")
        "GL_CON_14_ATI"("0x894F")
        "GL_CON_15_ATI"("0x8950")
        "GL_CON_16_ATI"("0x8951")
        "GL_CON_17_ATI"("0x8952")
        "GL_CON_18_ATI"("0x8953")
        "GL_CON_19_ATI"("0x8954")
        "GL_CON_20_ATI"("0x8955")
        "GL_CON_21_ATI"("0x8956")
        "GL_CON_22_ATI"("0x8957")
        "GL_CON_23_ATI"("0x8958")
        "GL_CON_24_ATI"("0x8959")
        "GL_CON_25_ATI"("0x895A")
        "GL_CON_26_ATI"("0x895B")
        "GL_CON_27_ATI"("0x895C")
        "GL_CON_28_ATI"("0x895D")
        "GL_CON_29_ATI"("0x895E")
        "GL_CON_30_ATI"("0x895F")
        "GL_CON_31_ATI"("0x8960")
        "GL_MOV_ATI"("0x8961")
        "GL_ADD_ATI"("0x8963")
        "GL_MUL_ATI"("0x8964")
        "GL_SUB_ATI"("0x8965")
        "GL_DOT3_ATI"("0x8966")
        "GL_DOT4_ATI"("0x8967")
        "GL_MAD_ATI"("0x8968")
        "GL_LERP_ATI"("0x8969")
        "GL_CND_ATI"("0x896A")
        "GL_CND0_ATI"("0x896B")
        "GL_DOT2_ADD_ATI"("0x896C")
        "GL_SECONDARY_INTERPOLATOR_ATI"("0x896D")
        "GL_NUM_FRAGMENT_REGISTERS_ATI"("0x896E")
        "GL_NUM_FRAGMENT_CONSTANTS_ATI"("0x896F")
        "GL_NUM_PASSES_ATI"("0x8970")
        "GL_NUM_INSTRUCTIONS_PER_PASS_ATI"("0x8971")
        "GL_NUM_INSTRUCTIONS_TOTAL_ATI"("0x8972")
        "GL_NUM_INPUT_INTERPOLATOR_COMPONENTS_ATI"("0x8973")
        "GL_NUM_LOOPBACK_COMPONENTS_ATI"("0x8974")
        "GL_COLOR_ALPHA_PAIRING_ATI"("0x8975")
        "GL_SWIZZLE_STR_ATI"("0x8976")
        "GL_SWIZZLE_STQ_ATI"("0x8977")
        "GL_SWIZZLE_STR_DR_ATI"("0x8978")
        "GL_SWIZZLE_STQ_DQ_ATI"("0x8979")
        "GL_SWIZZLE_STRQ_ATI"("0x897A")
        "GL_SWIZZLE_STRQ_DQ_ATI"("0x897B")
        "GL_RED_BIT_ATI"("0x00000001")
        "GL_GREEN_BIT_ATI"("0x00000002")
        "GL_BLUE_BIT_ATI"("0x00000004")
        "GL_2X_BIT_ATI"("0x00000001")
        "GL_4X_BIT_ATI"("0x00000002")
        "GL_8X_BIT_ATI"("0x00000004")
        "GL_HALF_BIT_ATI"("0x00000008")
        "GL_QUARTER_BIT_ATI"("0x00000010")
        "GL_EIGHTH_BIT_ATI"("0x00000020")
        "GL_SATURATE_BIT_ATI"("0x00000040")
        "GL_COMP_BIT_ATI"("0x00000002")
        "GL_NEGATE_BIT_ATI"("0x00000004")
        "GL_BIAS_BIT_ATI"("0x00000008")
        "glGenFragmentShadersATI"(GLuint, GLuint("range"))
        "glBindFragmentShaderATI"(void, GLuint("id"))
        "glDeleteFragmentShaderATI"(void, GLuint("id"))
        "glBeginFragmentShaderATI"(void)
        "glEndFragmentShaderATI"(void)
        "glPassTexCoordATI"(void, GLuint("dst"), GLuint("coord"), GLenum("swizzle"))
        "glSampleMapATI"(void, GLuint("dst"), GLuint("interp"), GLenum("swizzle"))
        "glColorFragmentOp1ATI"(
            void,
            GLenum("op"),
            GLuint("dst"),
            GLuint("dstMask"),
            GLuint("dstMod"),
            GLuint("arg1"),
            GLuint("arg1Rep"),
            GLuint("arg1Mod")
        )
        "glColorFragmentOp2ATI"(
            void,
            GLenum("op"),
            GLuint("dst"),
            GLuint("dstMask"),
            GLuint("dstMod"),
            GLuint("arg1"),
            GLuint("arg1Rep"),
            GLuint("arg1Mod"),
            GLuint("arg2"),
            GLuint("arg2Rep"),
            GLuint("arg2Mod")
        )
        "glColorFragmentOp3ATI"(
            void,
            GLenum("op"),
            GLuint("dst"),
            GLuint("dstMask"),
            GLuint("dstMod"),
            GLuint("arg1"),
            GLuint("arg1Rep"),
            GLuint("arg1Mod"),
            GLuint("arg2"),
            GLuint("arg2Rep"),
            GLuint("arg2Mod"),
            GLuint("arg3"),
            GLuint("arg3Rep"),
            GLuint("arg3Mod")
        )
        "glAlphaFragmentOp1ATI"(
            void,
            GLenum("op"),
            GLuint("dst"),
            GLuint("dstMod"),
            GLuint("arg1"),
            GLuint("arg1Rep"),
            GLuint("arg1Mod")
        )
        "glAlphaFragmentOp2ATI"(
            void,
            GLenum("op"),
            GLuint("dst"),
            GLuint("dstMod"),
            GLuint("arg1"),
            GLuint("arg1Rep"),
            GLuint("arg1Mod"),
            GLuint("arg2"),
            GLuint("arg2Rep"),
            GLuint("arg2Mod")
        )
        "glAlphaFragmentOp3ATI"(
            void,
            GLenum("op"),
            GLuint("dst"),
            GLuint("dstMod"),
            GLuint("arg1"),
            GLuint("arg1Rep"),
            GLuint("arg1Mod"),
            GLuint("arg2"),
            GLuint("arg2Rep"),
            GLuint("arg2Mod"),
            GLuint("arg3"),
            GLuint("arg3Rep"),
            GLuint("arg3Mod")
        )
        "glSetFragmentShaderConstantATI"(void, GLuint("dst"), address("value", "const GLfloat *"))
    }
    file("MapObjectBuffer", ATI, "GL_ATI_map_object_buffer") {
        "glMapObjectBufferATI"(address, GLuint("buffer"), nativeType = "void*")
        "glUnmapObjectBufferATI"(void, GLuint("buffer"))
    }
    file(
        "Meminfo", ATI, "GL_ATI_meminfo",
        "GL_VBO_FREE_MEMORY_ATI" to "0x87FB",
        "GL_TEXTURE_FREE_MEMORY_ATI" to "0x87FC",
        "GL_RENDERBUFFER_FREE_MEMORY_ATI" to "0x87FD"
    )
    file(
        "PixelFormatFloat", ATI, "GL_ATI_pixel_format_float",
        "GL_RGBA_FLOAT_MODE_ATI" to "0x8820",
        "GL_COLOR_CLEAR_UNCLAMPED_VALUE_ATI" to "0x8835"
    )
    file("PnTriangles", ATI, "GL_ATI_pn_triangles") {
        "GL_PN_TRIANGLES_ATI"("0x87F0")
        "GL_MAX_PN_TRIANGLES_TESSELATION_LEVEL_ATI"("0x87F1")
        "GL_PN_TRIANGLES_POINT_MODE_ATI"("0x87F2")
        "GL_PN_TRIANGLES_NORMAL_MODE_ATI"("0x87F3")
        "GL_PN_TRIANGLES_TESSELATION_LEVEL_ATI"("0x87F4")
        "GL_PN_TRIANGLES_POINT_MODE_LINEAR_ATI"("0x87F5")
        "GL_PN_TRIANGLES_POINT_MODE_CUBIC_ATI"("0x87F6")
        "GL_PN_TRIANGLES_NORMAL_MODE_LINEAR_ATI"("0x87F7")
        "GL_PN_TRIANGLES_NORMAL_MODE_QUADRATIC_ATI"("0x87F8")
        "glPNTrianglesiATI"(void, GLenum("pname"), GLint("param"))
        "glPNTrianglesfATI"(void, GLenum("pname"), GLfloat("param"))
    }
    file("SeparateStencil", ATI, "GL_ATI_separate_stencil") {
        "GL_STENCIL_BACK_FUNC_ATI"("0x8800")
        "GL_STENCIL_BACK_FAIL_ATI"("0x8801")
        "GL_STENCIL_BACK_PASS_DEPTH_FAIL_ATI"("0x8802")
        "GL_STENCIL_BACK_PASS_DEPTH_PASS_ATI"("0x8803")
        "glStencilOpSeparateATI"(void, GLenum("face"), GLenum("sfail"), GLenum("dpfail"), GLenum("dppass"))
        "glStencilFuncSeparateATI"(void, GLenum("frontfunc"), GLenum("backfunc"), GLint("ref"), GLuint("mask"))
    }
    file("TextFragmentShader", ATI, "GL_ATI_text_fragment_shader", "GL_TEXT_FRAGMENT_SHADER_ATI" to "0x8200")
    file(
        "TextureEnvCombine3", ATI, "GL_ATI_texture_env_combine3",
        "GL_MODULATE_ADD_ATI" to "0x8744",
        "GL_MODULATE_SIGNED_ADD_ATI" to "0x8745",
        "GL_MODULATE_SUBTRACT_ATI" to "0x8746"
    )
    file(
        "TextureFloat", ATI, "GL_ATI_texture_float",
        "GL_RGBA_FLOAT32_ATI" to "0x8814",
        "GL_RGB_FLOAT32_ATI" to "0x8815",
        "GL_ALPHA_FLOAT32_ATI" to "0x8816",
        "GL_INTENSITY_FLOAT32_ATI" to "0x8817",
        "GL_LUMINANCE_FLOAT32_ATI" to "0x8818",
        "GL_LUMINANCE_ALPHA_FLOAT32_ATI" to "0x8819",
        "GL_RGBA_FLOAT16_ATI" to "0x881A",
        "GL_RGB_FLOAT16_ATI" to "0x881B",
        "GL_ALPHA_FLOAT16_ATI" to "0x881C",
        "GL_INTENSITY_FLOAT16_ATI" to "0x881D",
        "GL_LUMINANCE_FLOAT16_ATI" to "0x881E",
        "GL_LUMINANCE_ALPHA_FLOAT16_ATI" to "0x881F"
    )
    file(
        "TextureMirrorOnce", ATI, "GL_ATI_texture_mirror_once",
        "GL_MIRROR_CLAMP_ATI" to "0x8742",
        "GL_MIRROR_CLAMP_TO_EDGE_ATI" to "0x8743"
    )
    file("VertexArrayObject", ATI, "GL_ATI_vertex_array_object") {
        "GL_STATIC_ATI"("0x8760")
        "GL_DYNAMIC_ATI"("0x8761")
        "GL_PRESERVE_ATI"("0x8762")
        "GL_DISCARD_ATI"("0x8763")
        "GL_OBJECT_BUFFER_SIZE_ATI"("0x8764")
        "GL_OBJECT_BUFFER_USAGE_ATI"("0x8765")
        "GL_ARRAY_OBJECT_BUFFER_ATI"("0x8766")
        "GL_ARRAY_OBJECT_OFFSET_ATI"("0x8767")
        "glNewObjectBufferATI"(GLuint, GLsizei("size"), address("pointer", "const void *"), GLenum("usage"))
        "glIsObjectBufferATI"(GLboolean, GLuint("buffer"))
        "glUpdateObjectBufferATI"(
            void,
            GLuint("buffer"),
            GLuint("offset"),
            GLsizei("size"),
            address("pointer", "const void *"),
            GLenum("preserve")
        )
        "glGetObjectBufferfvATI"(void, GLuint("buffer"), GLenum("pname"), address("params", "GLfloat *"))
        "glGetObjectBufferivATI"(void, GLuint("buffer"), GLenum("pname"), address("params", "GLint *"))
        "glFreeObjectBufferATI"(void, GLuint("buffer"))
        "glArrayObjectATI"(
            void,
            GLenum("array"),
            GLint("size"),
            GLenum("type"),
            GLsizei("stride"),
            GLuint("buffer"),
            GLuint("offset")
        )
        "glGetArrayObjectfvATI"(void, GLenum("array"), GLenum("pname"), address("params", "GLfloat *"))
        "glGetArrayObjectivATI"(void, GLenum("array"), GLenum("pname"), address("params", "GLint *"))
        "glVariantArrayObjectATI"(
            void,
            GLuint("id"),
            GLenum("type"),
            GLsizei("stride"),
            GLuint("buffer"),
            GLuint("offset")
        )
        "glGetVariantArrayObjectfvATI"(void, GLuint("id"), GLenum("pname"), address("params", "GLfloat *"))
        "glGetVariantArrayObjectivATI"(void, GLuint("id"), GLenum("pname"), address("params", "GLint *"))
    }
    file("VertexAttribArrayObject", ATI, "GL_ATI_vertex_attrib_array_object") {
        "glVertexAttribArrayObjectATI"(
            void,
            GLuint("index"),
            GLint("size"),
            GLenum("type"),
            GLboolean("normalized"),
            GLsizei("stride"),
            GLuint("buffer"),
            GLuint("offset")
        )
        "glGetVertexAttribArrayObjectfvATI"(void, GLuint("index"), GLenum("pname"), address("params", "GLfloat *"))
        "glGetVertexAttribArrayObjectivATI"(void, GLuint("index"), GLenum("pname"), address("params", "GLint *"))
    }
    file("VertexStreams", ATI, "GL_ATI_vertex_streams") {
        "GL_MAX_VERTEX_STREAMS_ATI"("0x876B")
        "GL_VERTEX_STREAM0_ATI"("0x876C")
        "GL_VERTEX_STREAM1_ATI"("0x876D")
        "GL_VERTEX_STREAM2_ATI"("0x876E")
        "GL_VERTEX_STREAM3_ATI"("0x876F")
        "GL_VERTEX_STREAM4_ATI"("0x8770")
        "GL_VERTEX_STREAM5_ATI"("0x8771")
        "GL_VERTEX_STREAM6_ATI"("0x8772")
        "GL_VERTEX_STREAM7_ATI"("0x8773")
        "GL_VERTEX_SOURCE_ATI"("0x8774")
        "glVertexStream1sATI"(void, GLenum("stream"), GLshort("x"))
        "glVertexStream1svATI"(void, GLenum("stream"), address("coords", "const GLshort *"))
        "glVertexStream1iATI"(void, GLenum("stream"), GLint("x"))
        "glVertexStream1ivATI"(void, GLenum("stream"), address("coords", "const GLint *"))
        "glVertexStream1fATI"(void, GLenum("stream"), GLfloat("x"))
        "glVertexStream1fvATI"(void, GLenum("stream"), address("coords", "const GLfloat *"))
        "glVertexStream1dATI"(void, GLenum("stream"), GLdouble("x"))
        "glVertexStream1dvATI"(void, GLenum("stream"), address("coords", "const GLdouble *"))
        "glVertexStream2sATI"(void, GLenum("stream"), GLshort("x"), GLshort("y"))
        "glVertexStream2svATI"(void, GLenum("stream"), address("coords", "const GLshort *"))
        "glVertexStream2iATI"(void, GLenum("stream"), GLint("x"), GLint("y"))
        "glVertexStream2ivATI"(void, GLenum("stream"), address("coords", "const GLint *"))
        "glVertexStream2fATI"(void, GLenum("stream"), GLfloat("x"), GLfloat("y"))
        "glVertexStream2fvATI"(void, GLenum("stream"), address("coords", "const GLfloat *"))
        "glVertexStream2dATI"(void, GLenum("stream"), GLdouble("x"), GLdouble("y"))
        "glVertexStream2dvATI"(void, GLenum("stream"), address("coords", "const GLdouble *"))
        "glVertexStream3sATI"(void, GLenum("stream"), GLshort("x"), GLshort("y"), GLshort("z"))
        "glVertexStream3svATI"(void, GLenum("stream"), address("coords", "const GLshort *"))
        "glVertexStream3iATI"(void, GLenum("stream"), GLint("x"), GLint("y"), GLint("z"))
        "glVertexStream3ivATI"(void, GLenum("stream"), address("coords", "const GLint *"))
        "glVertexStream3fATI"(void, GLenum("stream"), GLfloat("x"), GLfloat("y"), GLfloat("z"))
        "glVertexStream3fvATI"(void, GLenum("stream"), address("coords", "const GLfloat *"))
        "glVertexStream3dATI"(void, GLenum("stream"), GLdouble("x"), GLdouble("y"), GLdouble("z"))
        "glVertexStream3dvATI"(void, GLenum("stream"), address("coords", "const GLdouble *"))
        "glVertexStream4sATI"(void, GLenum("stream"), GLshort("x"), GLshort("y"), GLshort("z"), GLshort("w"))
        "glVertexStream4svATI"(void, GLenum("stream"), address("coords", "const GLshort *"))
        "glVertexStream4iATI"(void, GLenum("stream"), GLint("x"), GLint("y"), GLint("z"), GLint("w"))
        "glVertexStream4ivATI"(void, GLenum("stream"), address("coords", "const GLint *"))
        "glVertexStream4fATI"(void, GLenum("stream"), GLfloat("x"), GLfloat("y"), GLfloat("z"), GLfloat("w"))
        "glVertexStream4fvATI"(void, GLenum("stream"), address("coords", "const GLfloat *"))
        "glVertexStream4dATI"(void, GLenum("stream"), GLdouble("x"), GLdouble("y"), GLdouble("z"), GLdouble("w"))
        "glVertexStream4dvATI"(void, GLenum("stream"), address("coords", "const GLdouble *"))
        "glNormalStream3bATI"(void, GLenum("stream"), GLbyte("nx"), GLbyte("ny"), GLbyte("nz"))
        "glNormalStream3bvATI"(void, GLenum("stream"), address("coords", "const GLbyte *"))
        "glNormalStream3sATI"(void, GLenum("stream"), GLshort("nx"), GLshort("ny"), GLshort("nz"))
        "glNormalStream3svATI"(void, GLenum("stream"), address("coords", "const GLshort *"))
        "glNormalStream3iATI"(void, GLenum("stream"), GLint("nx"), GLint("ny"), GLint("nz"))
        "glNormalStream3ivATI"(void, GLenum("stream"), address("coords", "const GLint *"))
        "glNormalStream3fATI"(void, GLenum("stream"), GLfloat("nx"), GLfloat("ny"), GLfloat("nz"))
        "glNormalStream3fvATI"(void, GLenum("stream"), address("coords", "const GLfloat *"))
        "glNormalStream3dATI"(void, GLenum("stream"), GLdouble("nx"), GLdouble("ny"), GLdouble("nz"))
        "glNormalStream3dvATI"(void, GLenum("stream"), address("coords", "const GLdouble *"))
        "glClientActiveVertexStreamATI"(void, GLenum("stream"))
        "glVertexBlendEnviATI"(void, GLenum("pname"), GLint("param"))
        "glVertexBlendEnvfATI"(void, GLenum("pname"), GLfloat("param"))
    }
}

fun ext() {
    file(
        "422Pixels", EXT, "GL_EXT_422_pixels",
        "GL_422_EXT" to "0x80CC",
        "GL_422_REV_EXT" to "0x80CD",
        "GL_422_AVERAGE_EXT" to "0x80CE",
        "GL_422_REV_AVERAGE_EXT" to "0x80CF"
    )
}

fun gremedy() {
    file("FrameTerminator", GREMEDY, "GL_GREMEDY_frame_terminator") {
        "glFrameTerminatorGREMEDY"(void)
    }
    file("StringMarker", GREMEDY, "GL_GREMEDY_string_marker") {
        "glStringMarkerGREMEDY"(void, GLsizei("len"), address("string", "const void *"))
    }
}

fun hp() {
    file(
        "ConvolutionBorderModes", HP, "GL_HP_convolution_border_modes",
        "GL_IGNORE_BORDER_HP" to "0x8150",
        "GL_CONSTANT_BORDER_HP" to "0x8151",
        "GL_REPLICATE_BORDER_HP" to "0x8153",
        "GL_CONVOLUTION_BORDER_COLOR_HP" to "0x8154"
    )
    file("ImageTransform", HP, "GL_HP_image_transform") {
        "GL_IMAGE_SCALE_X_HP"("0x8155")
        "GL_IMAGE_SCALE_Y_HP"("0x8156")
        "GL_IMAGE_TRANSLATE_X_HP"("0x8157")
        "GL_IMAGE_TRANSLATE_Y_HP"("0x8158")
        "GL_IMAGE_ROTATE_ANGLE_HP"("0x8159")
        "GL_IMAGE_ROTATE_ORIGIN_X_HP"("0x815A")
        "GL_IMAGE_ROTATE_ORIGIN_Y_HP"("0x815B")
        "GL_IMAGE_MAG_FILTER_HP"("0x815C")
        "GL_IMAGE_MIN_FILTER_HP"("0x815D")
        "GL_IMAGE_CUBIC_WEIGHT_HP"("0x815E")
        "GL_CUBIC_HP"("0x815F")
        "GL_AVERAGE_HP"("0x8160")
        "GL_IMAGE_TRANSFORM_2D_HP"("0x8161")
        "GL_POST_IMAGE_TRANSFORM_COLOR_TABLE_HP"("0x8162")
        "GL_PROXY_POST_IMAGE_TRANSFORM_COLOR_TABLE_HP"("0x8163")
        "glImageTransformParameteriHP"(void, GLenum("target"), GLenum("pname"), GLint("param"))
        "glImageTransformParameterfHP"(void, GLenum("target"), GLenum("pname"), GLfloat("param"))
        "glImageTransformParameterivHP"(void, GLenum("target"), GLenum("pname"), address("params", "const GLint *"))
        "glImageTransformParameterfvHP"(void, GLenum("target"), GLenum("pname"), address("params", "const GLfloat *"))
        "glGetImageTransformParameterivHP"(void, GLenum("target"), GLenum("pname"), address("params", "GLint *"))
        "glGetImageTransformParameterfvHP"(void, GLenum("target"), GLenum("pname"), address("params", "GLfloat *"))
    }
    file(
        "OcclusionTest", HP, "GL_HP_occlusion_test",
        "GL_OCCLUSION_TEST_HP" to "0x8165",
        "GL_OCCLUSION_TEST_RESULT_HP" to "0x8166"
    )
    file(
        "TextureLighting", HP, "GL_HP_texture_lighting",
        "GL_TEXTURE_LIGHTING_MODE_HP" to "0x8167",
        "GL_TEXTURE_POST_SPECULAR_HP" to "0x8168",
        "GL_TEXTURE_PRE_SPECULAR_HP" to "0x8169"
    )
}

fun ibm() {
    file("CullVertex", IBM, "GL_IBM_cull_vertex", "GL_CULL_VERTEX_IBM" to "103050")
    file("MultimodeDrawArrays", IBM, "GL_IBM_multimode_draw_arrays") {
        "glMultiModeDrawArraysIBM"(
            void,
            address("mode", "const GLenum *"),
            address("first", "const GLint *"),
            address("count", "const GLsizei *"),
            GLsizei("primcount"),
            GLint("modestride")
        )
        "glMultiModeDrawElementsIBM"(
            void,
            address("mode", "const GLenum *"),
            address("count", "const GLsizei *"),
            GLenum("type"),
            address("indices", "const void *const*"),
            GLsizei("primcount"),
            GLint("modestride")
        )
    }
    file("RasterposClip", IBM, "GL_IBM_rasterpos_clip", "GL_RASTER_POSITION_UNCLIPPED_IBM" to "0x19262")
    file("StaticData", IBM, "GL_IBM_static_data") {
        "GL_ALL_STATIC_DATA_IBM"("103060")
        "GL_STATIC_VERTEX_ARRAY_IBM"("103061")
        "glFlushStaticDataIBM"(void, GLenum("target"))
    }
    file("TextureMirroredRepeat", IBM, "GL_IBM_texture_mirrored_repeat", "GL_MIRRORED_REPEAT_IBM" to "0x8370")
    file("VertexArrayLists", IBM, "GL_IBM_vertex_array_lists") {
        "GL_VERTEX_ARRAY_LIST_IBM"("103070")
        "GL_NORMAL_ARRAY_LIST_IBM"("103071")
        "GL_COLOR_ARRAY_LIST_IBM"("103072")
        "GL_INDEX_ARRAY_LIST_IBM"("103073")
        "GL_TEXTURE_COORD_ARRAY_LIST_IBM"("103074")
        "GL_EDGE_FLAG_ARRAY_LIST_IBM"("103075")
        "GL_FOG_COORDINATE_ARRAY_LIST_IBM"("103076")
        "GL_SECONDARY_COLOR_ARRAY_LIST_IBM"("103077")
        "GL_VERTEX_ARRAY_LIST_STRIDE_IBM"("103080")
        "GL_NORMAL_ARRAY_LIST_STRIDE_IBM"("103081")
        "GL_COLOR_ARRAY_LIST_STRIDE_IBM"("103082")
        "GL_INDEX_ARRAY_LIST_STRIDE_IBM"("103083")
        "GL_TEXTURE_COORD_ARRAY_LIST_STRIDE_IBM"("103084")
        "GL_EDGE_FLAG_ARRAY_LIST_STRIDE_IBM"("103085")
        "GL_FOG_COORDINATE_ARRAY_LIST_STRIDE_IBM"("103086")
        "GL_SECONDARY_COLOR_ARRAY_LIST_STRIDE_IBM"("103087")
        "glColorPointerListIBM"(
            void,
            GLint("size"),
            GLenum("type"),
            GLint("stride"),
            address("pointer", "const void **"),
            GLint("ptrstride")
        )
        "glSecondaryColorPointerListIBM"(
            void,
            GLint("size"),
            GLenum("type"),
            GLint("stride"),
            address("pointer", "const void **"),
            GLint("ptrstride")
        )
        "glEdgeFlagPointerListIBM"(void, GLint("stride"), address("pointer", "const GLboolean **"), GLint("ptrstride"))
        "glFogCoordPointerListIBM"(
            void,
            GLenum("type"),
            GLint("stride"),
            address("pointer", "const void **"),
            GLint("ptrstride")
        )
        "glIndexPointerListIBM"(
            void,
            GLenum("type"),
            GLint("stride"),
            address("pointer", "const void **"),
            GLint("ptrstride")
        )
        "glNormalPointerListIBM"(
            void,
            GLenum("type"),
            GLint("stride"),
            address("pointer", "const void **"),
            GLint("ptrstride")
        )
        "glTexCoordPointerListIBM"(
            void,
            GLint("size"),
            GLenum("type"),
            GLint("stride"),
            address("pointer", "const void **"),
            GLint("ptrstride")
        )
        "glVertexPointerListIBM"(
            void,
            GLint("size"),
            GLenum("type"),
            GLint("stride"),
            address("pointer", "const void **"),
            GLint("ptrstride")
        )
    }
}

fun ingr() {
    file("BlendFuncSeparate", INGR, "GL_INGR_blend_func_separate") {
        "glBlendFuncSeparateINGR"(
            void,
            GLenum("sfactorRGB"),
            GLenum("dfactorRGB"),
            GLenum("sfactorAlpha"),
            GLenum("dfactorAlpha")
        )
    }
    file(
        "ColorClamp", INGR, "GL_INGR_color_clamp",
        "GL_RED_MIN_CLAMP_INGR" to "0x8560",
        "GL_GREEN_MIN_CLAMP_INGR" to "0x8561",
        "GL_BLUE_MIN_CLAMP_INGR" to "0x8562",
        "GL_ALPHA_MIN_CLAMP_INGR" to "0x8563",
        "GL_RED_MAX_CLAMP_INGR" to "0x8564",
        "GL_GREEN_MAX_CLAMP_INGR" to "0x8565",
        "GL_BLUE_MAX_CLAMP_INGR" to "0x8566",
        "GL_ALPHA_MAX_CLAMP_INGR" to "0x8567"
    )
    file("InterlaceRead", INGR, "GL_INGR_interlace_read", "GL_INTERLACE_READ_INGR" to "0x8568")
}

fun intel() {
    file("BlackholeRender", INTEL, "GL_INTEL_blackhole_render", "GL_BLACKHOLE_RENDER_INTEL" to "0x83FC")
    file("ConservativeRasterization", INTEL, "GL_INTEL_conservative_rasterization", "GL_CONSERVATIVE_RASTERIZATION_INTEL" to "0x83FE")
    file("FramebufferCMAA", INTEL, "GL_INTEL_framebuffer_CMAA") {
        "glApplyFramebufferAttachmentCMAAINTEL"(void)
    }
    file("MapTexture", INTEL, "GL_INTEL_map_texture") {
        "GL_TEXTURE_MEMORY_LAYOUT_INTEL"("0x83FF")
        "GL_LAYOUT_DEFAULT_INTEL"("0")
        "GL_LAYOUT_LINEAR_INTEL"("1")
        "GL_LAYOUT_LINEAR_CPU_CACHED_INTEL"("2")
        "glSyncTextureINTEL"(void, GLuint("texture"))
        "glUnmapTexture2DINTEL"(void, GLuint("texture"), GLint("level"))
        "glMapTexture2DINTEL"(
            address,
            GLuint("texture"),
            GLint("level"),
            GLbitfield("access"),
            address("stride", "GLint *"),
            address("layout", "GLenum *"),
            nativeType = "void*"
        )
    }
    file("ParallelArrays", INTEL, "GL_INTEL_parallel_arrays") {
        "GL_PARALLEL_ARRAYS_INTEL"("0x83F4")
        "GL_VERTEX_ARRAY_PARALLEL_POINTERS_INTEL"("0x83F5")
        "GL_NORMAL_ARRAY_PARALLEL_POINTERS_INTEL"("0x83F6")
        "GL_COLOR_ARRAY_PARALLEL_POINTERS_INTEL"("0x83F7")
        "GL_TEXTURE_COORD_ARRAY_PARALLEL_POINTERS_INTEL"("0x83F8")
        "glVertexPointervINTEL"(void, GLint("size"), GLenum("type"), address("pointer", "const void **"))
        "glNormalPointervINTEL"(void, GLenum("type"), address("pointer", "const void **"))
        "glColorPointervINTEL"(void, GLint("size"), GLenum("type"), address("pointer", "const void **"))
        "glTexCoordPointervINTEL"(void, GLint("size"), GLenum("type"), address("pointer", "const void **"))
    }
    file("PerformanceQuery", INTEL, "GL_INTEL_performance_query") {
        "GL_PERFQUERY_SINGLE_CONTEXT_INTEL"("0x00000000")
        "GL_PERFQUERY_GLOBAL_CONTEXT_INTEL"("0x00000001")
        "GL_PERFQUERY_WAIT_INTEL"("0x83FB")
        "GL_PERFQUERY_FLUSH_INTEL"("0x83FA")
        "GL_PERFQUERY_DONOT_FLUSH_INTEL"("0x83F9")
        "GL_PERFQUERY_COUNTER_EVENT_INTEL"("0x94F0")
        "GL_PERFQUERY_COUNTER_DURATION_NORM_INTEL"("0x94F1")
        "GL_PERFQUERY_COUNTER_DURATION_RAW_INTEL"("0x94F2")
        "GL_PERFQUERY_COUNTER_THROUGHPUT_INTEL"("0x94F3")
        "GL_PERFQUERY_COUNTER_RAW_INTEL"("0x94F4")
        "GL_PERFQUERY_COUNTER_TIMESTAMP_INTEL"("0x94F5")
        "GL_PERFQUERY_COUNTER_DATA_UINT32_INTEL"("0x94F8")
        "GL_PERFQUERY_COUNTER_DATA_UINT64_INTEL"("0x94F9")
        "GL_PERFQUERY_COUNTER_DATA_FLOAT_INTEL"("0x94FA")
        "GL_PERFQUERY_COUNTER_DATA_DOUBLE_INTEL"("0x94FB")
        "GL_PERFQUERY_COUNTER_DATA_BOOL32_INTEL"("0x94FC")
        "GL_PERFQUERY_QUERY_NAME_LENGTH_MAX_INTEL"("0x94FD")
        "GL_PERFQUERY_COUNTER_NAME_LENGTH_MAX_INTEL"("0x94FE")
        "GL_PERFQUERY_COUNTER_DESC_LENGTH_MAX_INTEL"("0x94FF")
        "GL_PERFQUERY_GPA_EXTENDED_COUNTERS_INTEL"("0x9500")
        "glBeginPerfQueryINTEL"(void, GLuint("queryHandle"))
        "glCreatePerfQueryINTEL"(void, GLuint("queryId"), address("queryHandle", "GLuint *"))
        "glDeletePerfQueryINTEL"(void, GLuint("queryHandle"))
        "glEndPerfQueryINTEL"(void, GLuint("queryHandle"))
        "glGetFirstPerfQueryIdINTEL"(void, address("queryId", "GLuint *"))
        "glGetNextPerfQueryIdINTEL"(void, GLuint("queryId"), address("nextQueryId", "GLuint *"))
        "glGetPerfCounterInfoINTEL"(
            void,
            GLuint("queryId"),
            GLuint("counterId"),
            GLuint("counterNameLength"),
            address("counterName", "GLchar *"),
            GLuint("counterDescLength"),
            address("counterDesc", "GLchar *"),
            address("counterOffset", "GLuint *"),
            address("counterDataSize", "GLuint *"),
            address("counterTypeEnum", "GLuint *"),
            address("counterDataTypeEnum", "GLuint *"),
            address("rawCounterMaxValue", "GLuint64 *")
        )
        "glGetPerfQueryDataINTEL"(
            void,
            GLuint("queryHandle"),
            GLuint("flags"),
            GLsizei("dataSize"),
            address("data", "void *"),
            address("bytesWritten", "GLuint *")
        )
        "glGetPerfQueryIdByNameINTEL"(void, address("queryName", "GLchar *"), address("queryId", "GLuint *"))
        "glGetPerfQueryInfoINTEL"(
            void,
            GLuint("queryId"),
            GLuint("queryNameLength"),
            address("queryName", "GLchar *"),
            address("dataSize", "GLuint *"),
            address("noCounters", "GLuint *"),
            address("noInstances", "GLuint *"),
            address("capsMask", "GLuint *")
        )
    }
}

fun mesa() {
    file(
        "TextureStack", MESAX, "GL_MESAX_texture_stack",
        "GL_TEXTURE_1D_STACK_MESAX" to "0x8759",
        "GL_TEXTURE_2D_STACK_MESAX" to "0x875A",
        "GL_PROXY_TEXTURE_1D_STACK_MESAX" to "0x875B",
        "GL_PROXY_TEXTURE_2D_STACK_MESAX" to "0x875C",
        "GL_TEXTURE_1D_STACK_BINDING_MESAX" to "0x875D",
        "GL_TEXTURE_2D_STACK_BINDING_MESAX" to "0x875E"
    )
    file("FramebufferFlipX", MESA, "GL_MESA_framebuffer_flip_x", "GL_FRAMEBUFFER_FLIP_X_MESA" to "0x8BBC")
    file("FramebufferFlipY", MESA, "GL_MESA_framebuffer_flip_y") {
        "GL_FRAMEBUFFER_FLIP_Y_MESA"("0x8BBB")
        "glFramebufferParameteriMESA"(void, GLenum("target"), GLenum("pname"), GLint("param"))
        "glGetFramebufferParameterivMESA"(void, GLenum("target"), GLenum("pname"), address("params", "GLint *"))
    }
    file("FramebufferSwapXY", MESA, "GL_MESA_framebuffer_swap_xy", "GL_FRAMEBUFFER_SWAP_XY_MESA" to "0x8BBD")
    file("PackInvert", MESA, "GL_MESA_pack_invert", "GL_PACK_INVERT_MESA" to "0x8758")
    file("ProgramBinaryFormats", MESA, "GL_MESA_program_binary_formats", "GL_PROGRAM_BINARY_FORMAT_MESA" to "0x875F")
    file("ResizeBuffers", MESA, "GL_MESA_resize_buffers") {
        "glResizeBuffersMESA"(void)
    }
    file(
        "TileRasterOrder", MESA, "GL_MESA_tile_raster_order",
        "GL_TILE_RASTER_ORDER_FIXED_MESA" to "0x8BB8",
        "GL_TILE_RASTER_ORDER_INCREASING_X_MESA" to "0x8BB9",
        "GL_TILE_RASTER_ORDER_INCREASING_Y_MESA" to "0x8BBA"
    )
    file("WindowPos", MESA, "GL_MESA_window_pos") {
        "glWindowPos2dMESA"(void, GLdouble("x"), GLdouble("y"))
        "glWindowPos2dvMESA"(void, address("v", "const GLdouble *"))
        "glWindowPos2fMESA"(void, GLfloat("x"), GLfloat("y"))
        "glWindowPos2fvMESA"(void, address("v", "const GLfloat *"))
        "glWindowPos2iMESA"(void, GLint("x"), GLint("y"))
        "glWindowPos2ivMESA"(void, address("v", "const GLint *"))
        "glWindowPos2sMESA"(void, GLshort("x"), GLshort("y"))
        "glWindowPos2svMESA"(void, address("v", "const GLshort *"))
        "glWindowPos3dMESA"(void, GLdouble("x"), GLdouble("y"), GLdouble("z"))
        "glWindowPos3dvMESA"(void, address("v", "const GLdouble *"))
        "glWindowPos3fMESA"(void, GLfloat("x"), GLfloat("y"), GLfloat("z"))
        "glWindowPos3fvMESA"(void, address("v", "const GLfloat *"))
        "glWindowPos3iMESA"(void, GLint("x"), GLint("y"), GLint("z"))
        "glWindowPos3ivMESA"(void, address("v", "const GLint *"))
        "glWindowPos3sMESA"(void, GLshort("x"), GLshort("y"), GLshort("z"))
        "glWindowPos3svMESA"(void, address("v", "const GLshort *"))
        "glWindowPos4dMESA"(void, GLdouble("x"), GLdouble("y"), GLdouble("z"), GLdouble("w"))
        "glWindowPos4dvMESA"(void, address("v", "const GLdouble *"))
        "glWindowPos4fMESA"(void, GLfloat("x"), GLfloat("y"), GLfloat("z"), GLfloat("w"))
        "glWindowPos4fvMESA"(void, address("v", "const GLfloat *"))
        "glWindowPos4iMESA"(void, GLint("x"), GLint("y"), GLint("z"), GLint("w"))
        "glWindowPos4ivMESA"(void, address("v", "const GLint *"))
        "glWindowPos4sMESA"(void, GLshort("x"), GLshort("y"), GLshort("z"), GLshort("w"))
        "glWindowPos4svMESA"(void, address("v", "const GLshort *"))
    }
    file(
        "YcbcrTexture", MESA, "GL_MESA_ycbcr_texture",
        "GL_UNSIGNED_SHORT_8_8_MESA" to "0x85BA",
        "GL_UNSIGNED_SHORT_8_8_REV_MESA" to "0x85BB",
        "GL_YCBCR_MESA" to "0x8757"
    )
}

fun nv() {
    file("ConditionalRender", NVX, "GL_NVX_conditional_render") {
        "glBeginConditionalRenderNVX"(void, GLuint("id"))
        "glEndConditionalRenderNVX"(void)
    }
    file(
        "GpuMemoryInfo", NVX, "GL_NVX_gpu_memory_info",
        "GL_GPU_MEMORY_INFO_DEDICATED_VIDMEM_NVX" to "0x9047",
        "GL_GPU_MEMORY_INFO_TOTAL_AVAILABLE_MEMORY_NVX" to "0x9048",
        "GL_GPU_MEMORY_INFO_CURRENT_AVAILABLE_VIDMEM_NVX" to "0x9049",
        "GL_GPU_MEMORY_INFO_EVICTION_COUNT_NVX" to "0x904A",
        "GL_GPU_MEMORY_INFO_EVICTED_MEMORY_NVX" to "0x904B"
    )
    file("GpuMulticast2", NVX, "GL_NVX_gpu_multicast2") {
        "GL_UPLOAD_GPU_MASK_NVX"("0x954A")
        "glUploadGpuMaskNVX"(void, GLbitfield("mask"))
        "glMulticastViewportArrayvNVX"(
            void,
            GLuint("gpu"),
            GLuint("first"),
            GLsizei("count"),
            address("v", "const GLfloat *")
        )
        "glMulticastViewportPositionWScaleNVX"(
            void,
            GLuint("gpu"),
            GLuint("index"),
            GLfloat("xcoeff"),
            GLfloat("ycoeff")
        )
        "glMulticastScissorArrayvNVX"(
            void,
            GLuint("gpu"),
            GLuint("first"),
            GLsizei("count"),
            address("v", "const GLint *")
        )
        "glAsyncCopyBufferSubDataNVX"(
            GLuint,
            GLsizei("waitSemaphoreCount"),
            address("waitSemaphoreArray", "const GLuint *"),
            address("fenceValueArray", "const GLuint64 *"),
            GLuint("readGpu"),
            GLbitfield("writeGpuMask"),
            GLuint("readBuffer"),
            GLuint("writeBuffer"),
            GLintptr("readOffset"),
            GLintptr("writeOffset"),
            GLsizeiptr("size"),
            GLsizei("signalSemaphoreCount"),
            address("signalSemaphoreArray", "const GLuint *"),
            address("signalValueArray", "const GLuint64 *")
        )
        "glAsyncCopyImageSubDataNVX"(
            GLuint,
            GLsizei("waitSemaphoreCount"),
            address("waitSemaphoreArray", "const GLuint *"),
            address("waitValueArray", "const GLuint64 *"),
            GLuint("srcGpu"),
            GLbitfield("dstGpuMask"),
            GLuint("srcName"),
            GLenum("srcTarget"),
            GLint("srcLevel"),
            GLint("srcX"),
            GLint("srcY"),
            GLint("srcZ"),
            GLuint("dstName"),
            GLenum("dstTarget"),
            GLint("dstLevel"),
            GLint("dstX"),
            GLint("dstY"),
            GLint("dstZ"),
            GLsizei("srcWidth"),
            GLsizei("srcHeight"),
            GLsizei("srcDepth"),
            GLsizei("signalSemaphoreCount"),
            address("signalSemaphoreArray", "const GLuint *"),
            address("signalValueArray", "const GLuint64 *")
        )
    }
    file("LinkedGpuMulticast", NVX, "GL_NVX_linked_gpu_multicast") {
        "GL_LGPU_SEPARATE_STORAGE_BIT_NVX"("0x0800")
        "GL_MAX_LGPU_GPUS_NVX"("0x92BA")
        "glLGPUNamedBufferSubDataNVX"(
            void,
            GLbitfield("gpuMask"),
            GLuint("buffer"),
            GLintptr("offset"),
            GLsizeiptr("size"),
            address("data", "const void *")
        )
        "glLGPUCopyImageSubDataNVX"(
            void,
            GLuint("sourceGpu"),
            GLbitfield("destinationGpuMask"),
            GLuint("srcName"),
            GLenum("srcTarget"),
            GLint("srcLevel"),
            GLint("srcX"),
            GLint("srxY"),
            GLint("srcZ"),
            GLuint("dstName"),
            GLenum("dstTarget"),
            GLint("dstLevel"),
            GLint("dstX"),
            GLint("dstY"),
            GLint("dstZ"),
            GLsizei("width"),
            GLsizei("height"),
            GLsizei("depth")
        )
        "glLGPUInterlockNVX"(void)
    }
    file("ProgressFence", NVX, "GL_NVX_progress_fence") {
        "glCreateProgressFenceNVX"(void)
        "glSignalSemaphoreui64NVX"(
            void,
            GLuint("signalGpu"),
            GLsizei("fenceObjectCount"),
            address("semaphoreArray", "const GLuint *"),
            address("fenceValueArray", "const GLuint64 *")
        )
        "glWaitSemaphoreui64NVX"(
            void,
            GLuint("waitGpu"),
            GLsizei("fenceObjectCount"),
            address("semaphoreArray", "const GLuint *"),
            address("fenceValueArray", "const GLuint64 *")
        )
        "glClientWaitSemaphoreui64NVX"(
            void,
            GLsizei("fenceObjectCount"),
            address("semaphoreArray", "const GLuint *"),
            address("fenceValueArray", "const GLuint64 *")
        )
    }
    file("AlphaToCoverageDitherControl", NV, "GL_NV_alpha_to_coverage_dither_control") {
        "GL_ALPHA_TO_COVERAGE_DITHER_DEFAULT_NV"("0x934D")
        "GL_ALPHA_TO_COVERAGE_DITHER_ENABLE_NV"("0x934E")
        "GL_ALPHA_TO_COVERAGE_DITHER_DISABLE_NV"("0x934F")
        "GL_ALPHA_TO_COVERAGE_DITHER_MODE_NV"("0x92BF")
        "glAlphaToCoverageDitherControlNV"(void, GLenum("mode"))
    }
    file("BindlessMultiDrawIndirect", NV, "GL_NV_bindless_multi_draw_indirect") {
        "glMultiDrawArraysIndirectBindlessNV"(
            void,
            GLenum("mode"),
            address("indirect", "const void *"),
            GLsizei("drawCount"),
            GLsizei("stride"),
            GLint("vertexBufferCount")
        )
        "glMultiDrawElementsIndirectBindlessNV"(
            void,
            GLenum("mode"),
            GLenum("type"),
            address("indirect", "const void *"),
            GLsizei("drawCount"),
            GLsizei("stride"),
            GLint("vertexBufferCount")
        )
    }
    file("BindlessMultiDrawIndirectCount", NV, "GL_NV_bindless_multi_draw_indirect_count") {
        "glMultiDrawArraysIndirectBindlessCountNV"(
            void,
            GLenum("mode"),
            address("indirect", "const void *"),
            GLsizei("drawCount"),
            GLsizei("maxDrawCount"),
            GLsizei("stride"),
            GLint("vertexBufferCount")
        )
        "glMultiDrawElementsIndirectBindlessCountNV"(
            void,
            GLenum("mode"),
            GLenum("type"),
            address("indirect", "const void *"),
            GLsizei("drawCount"),
            GLsizei("maxDrawCount"),
            GLsizei("stride"),
            GLint("vertexBufferCount")
        )
    }
    file("BindlessTexture", NV, "GL_NV_bindless_texture") {
        "glGetTextureHandleNV"(GLuint64, GLuint("texture"))
        "glGetTextureSamplerHandleNV"(GLuint64, GLuint("texture"), GLuint("sampler"))
        "glMakeTextureHandleResidentNV"(void, GLuint64("handle"))
        "glMakeTextureHandleNonResidentNV"(void, GLuint64("handle"))
        "glGetImageHandleNV"(
            GLuint64,
            GLuint("texture"),
            GLint("level"),
            GLboolean("layered"),
            GLint("layer"),
            GLenum("format")
        )
        "glMakeImageHandleResidentNV"(void, GLuint64("handle"), GLenum("access"))
        "glMakeImageHandleNonResidentNV"(void, GLuint64("handle"))
        "glUniformHandleui64NV"(void, GLint("location"), GLuint64("value"))
        "glUniformHandleui64vNV"(void, GLint("location"), GLsizei("count"), address("value", "const GLuint64 *"))
        "glProgramUniformHandleui64NV"(void, GLuint("program"), GLint("location"), GLuint64("value"))
        "glProgramUniformHandleui64vNV"(
            void,
            GLuint("program"),
            GLint("location"),
            GLsizei("count"),
            address("values", "const GLuint64 *")
        )
        "glIsTextureHandleResidentNV"(GLboolean, GLuint64("handle"))
        "glIsImageHandleResidentNV"(GLboolean, GLuint64("handle"))
    }
    file("BlendEquationAdvanced", NV, "GL_NV_blend_equation_advanced") {
        "GL_BLEND_OVERLAP_NV"("0x9281")
        "GL_BLEND_PREMULTIPLIED_SRC_NV"("0x9280")
        "GL_BLUE_NV"("0x1905")
        "GL_COLORBURN_NV"("0x929A")
        "GL_COLORDODGE_NV"("0x9299")
        "GL_CONJOINT_NV"("0x9284")
        "GL_CONTRAST_NV"("0x92A1")
        "GL_DARKEN_NV"("0x9297")
        "GL_DIFFERENCE_NV"("0x929E")
        "GL_DISJOINT_NV"("0x9283")
        "GL_DST_ATOP_NV"("0x928F")
        "GL_DST_IN_NV"("0x928B")
        "GL_DST_NV"("0x9287")
        "GL_DST_OUT_NV"("0x928D")
        "GL_DST_OVER_NV"("0x9289")
        "GL_EXCLUSION_NV"("0x92A0")
        "GL_GREEN_NV"("0x1904")
        "GL_HARDLIGHT_NV"("0x929B")
        "GL_HARDMIX_NV"("0x92A9")
        "GL_HSL_COLOR_NV"("0x92AF")
        "GL_HSL_HUE_NV"("0x92AD")
        "GL_HSL_LUMINOSITY_NV"("0x92B0")
        "GL_HSL_SATURATION_NV"("0x92AE")
        "GL_INVERT_OVG_NV"("0x92B4")
        "GL_INVERT_RGB_NV"("0x92A3")
        "GL_LIGHTEN_NV"("0x9298")
        "GL_LINEARBURN_NV"("0x92A5")
        "GL_LINEARDODGE_NV"("0x92A4")
        "GL_LINEARLIGHT_NV"("0x92A7")
        "GL_MINUS_CLAMPED_NV"("0x92B3")
        "GL_MINUS_NV"("0x929F")
        "GL_MULTIPLY_NV"("0x9294")
        "GL_OVERLAY_NV"("0x9296")
        "GL_PINLIGHT_NV"("0x92A8")
        "GL_PLUS_CLAMPED_ALPHA_NV"("0x92B2")
        "GL_PLUS_CLAMPED_NV"("0x92B1")
        "GL_PLUS_DARKER_NV"("0x9292")
        "GL_PLUS_NV"("0x9291")
        "GL_RED_NV"("0x1903")
        "GL_SCREEN_NV"("0x9295")
        "GL_SOFTLIGHT_NV"("0x929C")
        "GL_SRC_ATOP_NV"("0x928E")
        "GL_SRC_IN_NV"("0x928A")
        "GL_SRC_NV"("0x9286")
        "GL_SRC_OUT_NV"("0x928C")
        "GL_SRC_OVER_NV"("0x9288")
        "GL_UNCORRELATED_NV"("0x9282")
        "GL_VIVIDLIGHT_NV"("0x92A6")
        "GL_XOR_NV"("0x1506")
        "glBlendParameteriNV"(void, GLenum("pname"), GLint("value"))
        "glBlendBarrierNV"(void)
    }
    file("BlendEquationAdvancedCoherent", NV, "GL_NV_blend_equation_advanced_coherent", "GL_BLEND_ADVANCED_COHERENT_NV" to "0x9285")
    file("ClipSpaceWScaling", NV, "GL_NV_clip_space_w_scaling") {
        "GL_VIEWPORT_POSITION_W_SCALE_NV"("0x937C")
        "GL_VIEWPORT_POSITION_W_SCALE_X_COEFF_NV"("0x937D")
        "GL_VIEWPORT_POSITION_W_SCALE_Y_COEFF_NV"("0x937E")
        "glViewportPositionWScaleNV"(void, GLuint("index"), GLfloat("xcoeff"), GLfloat("ycoeff"))
    }
    file("CommandList", NV, "GL_NV_command_list") {
        "GL_TERMINATE_SEQUENCE_COMMAND_NV"("0x0000")
        "GL_NOP_COMMAND_NV"("0x0001")
        "GL_DRAW_ELEMENTS_COMMAND_NV"("0x0002")
        "GL_DRAW_ARRAYS_COMMAND_NV"("0x0003")
        "GL_DRAW_ELEMENTS_STRIP_COMMAND_NV"("0x0004")
        "GL_DRAW_ARRAYS_STRIP_COMMAND_NV"("0x0005")
        "GL_DRAW_ELEMENTS_INSTANCED_COMMAND_NV"("0x0006")
        "GL_DRAW_ARRAYS_INSTANCED_COMMAND_NV"("0x0007")
        "GL_ELEMENT_ADDRESS_COMMAND_NV"("0x0008")
        "GL_ATTRIBUTE_ADDRESS_COMMAND_NV"("0x0009")
        "GL_UNIFORM_ADDRESS_COMMAND_NV"("0x000A")
        "GL_BLEND_COLOR_COMMAND_NV"("0x000B")
        "GL_STENCIL_REF_COMMAND_NV"("0x000C")
        "GL_LINE_WIDTH_COMMAND_NV"("0x000D")
        "GL_POLYGON_OFFSET_COMMAND_NV"("0x000E")
        "GL_ALPHA_REF_COMMAND_NV"("0x000F")
        "GL_VIEWPORT_COMMAND_NV"("0x0010")
        "GL_SCISSOR_COMMAND_NV"("0x0011")
        "GL_FRONT_FACE_COMMAND_NV"("0x0012")
        "glCreateStatesNV"(void, GLsizei("n"), address("states", "GLuint *"))
        "glDeleteStatesNV"(void, GLsizei("n"), address("states", "const GLuint *"))
        "glIsStateNV"(GLboolean, GLuint("state"))
        "glStateCaptureNV"(void, GLuint("state"), GLenum("mode"))
        "glGetCommandHeaderNV"(GLuint, GLenum("tokenID"), GLuint("size"))
        "glGetStageIndexNV"(GLushort, GLenum("shadertype"))
        "glDrawCommandsNV"(
            void,
            GLenum("primitiveMode"),
            GLuint("buffer"),
            address("indirects", "const GLintptr *"),
            address("sizes", "const GLsizei *"),
            GLuint("count")
        )
        "glDrawCommandsAddressNV"(
            void,
            GLenum("primitiveMode"),
            address("indirects", "const GLuint64 *"),
            address("sizes", "const GLsizei *"),
            GLuint("count")
        )
        "glDrawCommandsStatesNV"(
            void,
            GLuint("buffer"),
            address("indirects", "const GLintptr *"),
            address("sizes", "const GLsizei *"),
            address("states", "const GLuint *"),
            address("fbos", "const GLuint *"),
            GLuint("count")
        )
        "glDrawCommandsStatesAddressNV"(
            void,
            address("indirects", "const GLuint64 *"),
            address("sizes", "const GLsizei *"),
            address("states", "const GLuint *"),
            address("fbos", "const GLuint *"),
            GLuint("count")
        )
        "glCreateCommandListsNV"(void, GLsizei("n"), address("lists", "GLuint *"))
        "glDeleteCommandListsNV"(void, GLsizei("n"), address("lists", "const GLuint *"))
        "glIsCommandListNV"(GLboolean, GLuint("list"))
        "glListDrawCommandsStatesClientNV"(
            void,
            GLuint("list"),
            GLuint("segment"),
            address("indirects", "const void **"),
            address("sizes", "const GLsizei *"),
            address("states", "const GLuint *"),
            address("fbos", "const GLuint *"),
            GLuint("count")
        )
        "glCommandListSegmentsNV"(void, GLuint("list"), GLuint("segments"))
        "glCompileCommandListNV"(void, GLuint("list"))
        "glCallCommandListNV"(void, GLuint("list"))
    }
    file(
        "ComputeProgram5", NV, "GL_NV_compute_program5",
        "GL_COMPUTE_PROGRAM_NV" to "0x90FB",
        "GL_COMPUTE_PROGRAM_PARAMETER_BUFFER_NV" to "0x90FC"
    )
    file("ConditionalRender", NV, "GL_NV_conditional_render") {
        "GL_QUERY_WAIT_NV"("0x8E13")
        "GL_QUERY_NO_WAIT_NV"("0x8E14")
        "GL_QUERY_BY_REGION_WAIT_NV"("0x8E15")
        "GL_QUERY_BY_REGION_NO_WAIT_NV"("0x8E16")
        "glBeginConditionalRenderNV"(void, GLuint("id"), GLenum("mode"))
        "glEndConditionalRenderNV"(void)
    }
    file("ConservativeRaster", NV, "GL_NV_conservative_raster") {
        "GL_CONSERVATIVE_RASTERIZATION_NV"("0x9346")
        "GL_SUBPIXEL_PRECISION_BIAS_X_BITS_NV"("0x9347")
        "GL_SUBPIXEL_PRECISION_BIAS_Y_BITS_NV"("0x9348")
        "GL_MAX_SUBPIXEL_PRECISION_BIAS_BITS_NV"("0x9349")
        "glSubpixelPrecisionBiasNV"(void, GLuint("xbits"), GLuint("ybits"))
    }
    file("ConservativeRasterDilate", NV, "GL_NV_conservative_raster_dilate") {
        "GL_CONSERVATIVE_RASTER_DILATE_NV"  ("0x9379")
        "GL_CONSERVATIVE_RASTER_DILATE_RANGE_NV" ("0x937A")
        "GL_CONSERVATIVE_RASTER_DILATE_GRANULARITY_NV" ("0x937B")
        "glConservativeRasterParameterfNV" (void, GLenum ("pname"), GLfloat ("value"))
    }
    file("ConservativeRasterPreSnap", NV, "GL_NV_conservative_raster_pre_snap", "GL_CONSERVATIVE_RASTER_MODE_PRE_SNAP_NV" to "0x9550")
    file("ConservativeRasterPreSnapTriangles", NV, "GL_NV_conservative_raster_pre_snap_triangles") {
        "GL_CONSERVATIVE_RASTER_MODE_NV"("0x954D")
        "GL_CONSERVATIVE_RASTER_MODE_POST_SNAP_NV"("0x954E")
        "GL_CONSERVATIVE_RASTER_MODE_PRE_SNAP_TRIANGLES_NV"("0x954F")
        "glConservativeRasterParameteriNV"(void, GLenum("pname"), GLint("param"))
    }
    file(
        "CopyDepthToColor", NV, "GL_NV_copy_depth_to_color",
        "GL_DEPTH_STENCIL_TO_RGBA_NV" to "0x886E",
        "GL_DEPTH_STENCIL_TO_BGRA_NV" to "0x886F"
    )
    file("CopyImage", NV, "GL_NV_copy_image") {
        "glCopyImageSubDataNV"(
            void,
            GLuint("srcName"),
            GLenum("srcTarget"),
            GLint("srcLevel"),
            GLint("srcX"),
            GLint("srcY"),
            GLint("srcZ"),
            GLuint("dstName"),
            GLenum("dstTarget"),
            GLint("dstLevel"),
            GLint("dstX"),
            GLint("dstY"),
            GLint("dstZ"),
            GLsizei("width"),
            GLsizei("height"),
            GLsizei("depth")
        )
    }
    file(
        "DeepTexture3D", NV, "GL_NV_deep_texture3D",
        "GL_MAX_DEEP_3D_TEXTURE_WIDTH_HEIGHT_NV" to "0x90D0",
        "GL_MAX_DEEP_3D_TEXTURE_DEPTH_NV" to "0x90D1"
    )
    file("DepthBufferFloat", NV, "GL_NV_depth_buffer_float") {
        "GL_DEPTH_COMPONENT32F_NV"("0x8DAB")
        "GL_DEPTH32F_STENCIL8_NV"("0x8DAC")
        "GL_FLOAT_32_UNSIGNED_INT_24_8_REV_NV"("0x8DAD")
        "GL_DEPTH_BUFFER_FLOAT_MODE_NV"("0x8DAF")
        "glDepthRangedNV"(void, GLdouble("zNear"), GLdouble("zFar"))
        "glClearDepthdNV"(void, GLdouble("depth"))
        "glDepthBoundsdNV"(void, GLdouble("zmin"), GLdouble("zmax"))
    }
    file("DepthClamp", NV, "GL_NV_depth_clamp", "GL_DEPTH_CLAMP_NV" to "0x864F")
    file("DrawTexture", NV, "GL_NV_draw_texture") {
        "glDrawTextureNV"(
            void,
            GLuint("texture"),
            GLuint("sampler"),
            GLfloat("x0"),
            GLfloat("y0"),
            GLfloat("x1"),
            GLfloat("y1"),
            GLfloat("z"),
            GLfloat("s0"),
            GLfloat("t0"),
            GLfloat("s1"),
            GLfloat("t1")
        )
    }
    file("DrawVulkanImage", NV, "GL_NV_draw_vulkan_image") {
        "glDrawVkImageNV"(
            void,
            GLuint64("vkImage"),
            GLuint("sampler"),
            GLfloat("x0"),
            GLfloat("y0"),
            GLfloat("x1"),
            GLfloat("y1"),
            GLfloat("z"),
            GLfloat("s0"),
            GLfloat("t0"),
            GLfloat("s1"),
            GLfloat("t1")
        )
        "glGetVkProcAddrNV"(address, address("name", "const GLchar *"), nativeType = "GLVULKANPROCNV")
        "glWaitVkSemaphoreNV"(void, GLuint64("vkSemaphore"))
        "glSignalVkSemaphoreNV"(void, GLuint64("vkSemaphore"))
        "glSignalVkFenceNV"(void, GLuint64("vkFence"))
    }
    file("Evaluators", NV, "GL_NV_evaluators") {
        "GL_EVAL_2D_NV"("0x86C0")
        "GL_EVAL_TRIANGULAR_2D_NV"("0x86C1")
        "GL_MAP_TESSELLATION_NV"("0x86C2")
        "GL_MAP_ATTRIB_U_ORDER_NV"("0x86C3")
        "GL_MAP_ATTRIB_V_ORDER_NV"("0x86C4")
        "GL_EVAL_FRACTIONAL_TESSELLATION_NV"("0x86C5")
        "GL_EVAL_VERTEX_ATTRIB0_NV"("0x86C6")
        "GL_EVAL_VERTEX_ATTRIB1_NV"("0x86C7")
        "GL_EVAL_VERTEX_ATTRIB2_NV"("0x86C8")
        "GL_EVAL_VERTEX_ATTRIB3_NV"("0x86C9")
        "GL_EVAL_VERTEX_ATTRIB4_NV"("0x86CA")
        "GL_EVAL_VERTEX_ATTRIB5_NV"("0x86CB")
        "GL_EVAL_VERTEX_ATTRIB6_NV"("0x86CC")
        "GL_EVAL_VERTEX_ATTRIB7_NV"("0x86CD")
        "GL_EVAL_VERTEX_ATTRIB8_NV"("0x86CE")
        "GL_EVAL_VERTEX_ATTRIB9_NV"("0x86CF")
        "GL_EVAL_VERTEX_ATTRIB10_NV"("0x86D0")
        "GL_EVAL_VERTEX_ATTRIB11_NV"("0x86D1")
        "GL_EVAL_VERTEX_ATTRIB12_NV"("0x86D2")
        "GL_EVAL_VERTEX_ATTRIB13_NV"("0x86D3")
        "GL_EVAL_VERTEX_ATTRIB14_NV"("0x86D4")
        "GL_EVAL_VERTEX_ATTRIB15_NV"("0x86D5")
        "GL_MAX_MAP_TESSELLATION_NV"("0x86D6")
        "GL_MAX_RATIONAL_EVAL_ORDER_NV"("0x86D7")
        "glMapControlPointsNV"(
            void,
            GLenum("target"),
            GLuint("index"),
            GLenum("type"),
            GLsizei("ustride"),
            GLsizei("vstride"),
            GLint("uorder"),
            GLint("vorder"),
            GLboolean("packed"),
            address("points", "const void *")
        )
        "glMapParameterivNV"(void, GLenum("target"), GLenum("pname"), address("params", "const GLint *"))
        "glMapParameterfvNV"(void, GLenum("target"), GLenum("pname"), address("params", "const GLfloat *"))
        "glGetMapControlPointsNV"(
            void,
            GLenum("target"),
            GLuint("index"),
            GLenum("type"),
            GLsizei("ustride"),
            GLsizei("vstride"),
            GLboolean("packed"),
            address("points", "void *")
        )
        "glGetMapParameterivNV"(void, GLenum("target"), GLenum("pname"), address("params", "GLint *"))
        "glGetMapParameterfvNV"(void, GLenum("target"), GLenum("pname"), address("params", "GLfloat *"))
        "glGetMapAttribParameterivNV"(
            void,
            GLenum("target"),
            GLuint("index"),
            GLenum("pname"),
            address("params", "GLint *")
        )
        "glGetMapAttribParameterfvNV"(
            void,
            GLenum("target"),
            GLuint("index"),
            GLenum("pname"),
            address("params", "GLfloat *")
        )
        "glEvalMapsNV"(void, GLenum("target"), GLenum("mode"))
    }
    file("ExplicitMultisample", NV, "GL_NV_explicit_multisample") {
        "GL_SAMPLE_POSITION_NV"("0x8E50")
        "GL_SAMPLE_MASK_NV"("0x8E51")
        "GL_SAMPLE_MASK_VALUE_NV"("0x8E52")
        "GL_TEXTURE_BINDING_RENDERBUFFER_NV"("0x8E53")
        "GL_TEXTURE_RENDERBUFFER_DATA_STORE_BINDING_NV"("0x8E54")
        "GL_TEXTURE_RENDERBUFFER_NV"("0x8E55")
        "GL_SAMPLER_RENDERBUFFER_NV"("0x8E56")
        "GL_INT_SAMPLER_RENDERBUFFER_NV"("0x8E57")
        "GL_UNSIGNED_INT_SAMPLER_RENDERBUFFER_NV"("0x8E58")
        "GL_MAX_SAMPLE_MASK_WORDS_NV"("0x8E59")
        "glGetMultisamplefvNV"(void, GLenum("pname"), GLuint("index"), address("val", "GLfloat *"))
        "glSampleMaskIndexedNV"(void, GLuint("index"), GLbitfield("mask"))
        "glTexRenderbufferNV"(void, GLenum("target"), GLuint("renderbuffer"))
    }
}

fun oml() {
    file(
        "Interlace", OML, "GL_OML_interlace",
        "GL_INTERLACE_OML" to "0x8980",
        "GL_INTERLACE_READ_OML" to "0x8981"
    )
    file(
        "Resample", OML, "GL_OML_resample",
        "GL_PACK_RESAMPLE_OML" to "0x8984",
        "GL_UNPACK_RESAMPLE_OML" to "0x8985",
        "GL_RESAMPLE_REPLICATE_OML" to "0x8986",
        "GL_RESAMPLE_ZERO_FILL_OML" to "0x8987",
        "GL_RESAMPLE_AVERAGE_OML" to "0x8988",
        "GL_RESAMPLE_DECIMATE_OML" to "0x8989"
    )
    file(
        "Subsample", OML, "GL_OML_subsample",
        "GL_FORMAT_SUBSAMPLE_24_24_OML" to "0x8982",
        "GL_FORMAT_SUBSAMPLE_244_244_OML" to "0x8983"
    )
}

fun ovr() {
    file("Multiview", OVR, "GL_OVR_multiview") {
        "GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_NUM_VIEWS_OVR"("0x9630")
        "GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_BASE_VIEW_INDEX_OVR"("0x9632")
        "GL_MAX_VIEWS_OVR"("0x9631")
        "GL_FRAMEBUFFER_INCOMPLETE_VIEW_TARGETS_OVR"("0x9633")
        "glFramebufferTextureMultiviewOVR"(
            void,
            GLenum("target"),
            GLenum("attachment"),
            GLuint("texture"),
            GLint("level"),
            GLint("baseViewIndex"),
            GLsizei("numViews")
        )
    }
}

fun pgi() {
    file("MiscHints", PGI, "GL_PGI_misc_hints") {
        "GL_PREFER_DOUBLEBUFFER_HINT_PGI"("0x1A1F8")
        "GL_CONSERVE_MEMORY_HINT_PGI"("0x1A1FD")
        "GL_RECLAIM_MEMORY_HINT_PGI"("0x1A1FE")
        "GL_NATIVE_GRAPHICS_HANDLE_PGI"("0x1A202")
        "GL_NATIVE_GRAPHICS_BEGIN_HINT_PGI"("0x1A203")
        "GL_NATIVE_GRAPHICS_END_HINT_PGI"("0x1A204")
        "GL_ALWAYS_FAST_HINT_PGI"("0x1A20C")
        "GL_ALWAYS_SOFT_HINT_PGI"("0x1A20D")
        "GL_ALLOW_DRAW_OBJ_HINT_PGI"("0x1A20E")
        "GL_ALLOW_DRAW_WIN_HINT_PGI"("0x1A20F")
        "GL_ALLOW_DRAW_FRG_HINT_PGI"("0x1A210")
        "GL_ALLOW_DRAW_MEM_HINT_PGI"("0x1A211")
        "GL_STRICT_DEPTHFUNC_HINT_PGI"("0x1A216")
        "GL_STRICT_LIGHTING_HINT_PGI"("0x1A217")
        "GL_STRICT_SCISSOR_HINT_PGI"("0x1A218")
        "GL_FULL_STIPPLE_HINT_PGI"("0x1A219")
        "GL_CLIP_NEAR_HINT_PGI"("0x1A220")
        "GL_CLIP_FAR_HINT_PGI"("0x1A221")
        "GL_WIDE_LINE_HINT_PGI"("0x1A222")
        "GL_BACK_NORMALS_HINT_PGI"("0x1A223")
        "glHintPGI"(void, GLenum("target"), GLint("mode"))
    }
    file(
        "VertexHints", PGI, "GL_PGI_vertex_hints",
        "GL_VERTEX_DATA_HINT_PGI" to "0x1A22A",
        "GL_VERTEX_CONSISTENT_HINT_PGI" to "0x1A22B",
        "GL_MATERIAL_SIDE_HINT_PGI" to "0x1A22C",
        "GL_MAX_VERTEX_HINT_PGI" to "0x1A22D",
        "GL_COLOR3_BIT_PGI" to "0x00010000",
        "GL_COLOR4_BIT_PGI" to "0x00020000",
        "GL_EDGEFLAG_BIT_PGI" to "0x00040000",
        "GL_INDEX_BIT_PGI" to "0x00080000",
        "GL_MAT_AMBIENT_BIT_PGI" to "0x00100000",
        "GL_MAT_AMBIENT_AND_DIFFUSE_BIT_PGI" to "0x00200000",
        "GL_MAT_DIFFUSE_BIT_PGI" to "0x00400000",
        "GL_MAT_EMISSION_BIT_PGI" to "0x00800000",
        "GL_MAT_COLOR_INDEXES_BIT_PGI" to "0x01000000",
        "GL_MAT_SHININESS_BIT_PGI" to "0x02000000",
        "GL_MAT_SPECULAR_BIT_PGI" to "0x04000000",
        "GL_NORMAL_BIT_PGI" to "0x08000000",
        "GL_TEXCOORD1_BIT_PGI" to "0x10000000",
        "GL_TEXCOORD2_BIT_PGI" to "0x20000000",
        "GL_TEXCOORD3_BIT_PGI" to "0x40000000",
        "GL_TEXCOORD4_BIT_PGI" to "0x80000000",
        "GL_VERTEX23_BIT_PGI" to "0x00000004",
        "GL_VERTEX4_BIT_PGI" to "0x00000008"
    )
}

fun rend() {
    file(
        "ScreenCoordinates", REND, "GL_REND_screen_coordinates",
        "GL_SCREEN_COORDINATES_REND" to "0x8490",
        "GL_INVERTED_SCREEN_W_REND" to "0x8491"
    )
}

fun s3() {
    file(
        "S3tc", S3, "GL_S3_s3tc",
        "GL_RGB_S3TC" to "0x83A0",
        "GL_RGB4_S3TC" to "0x83A1",
        "GL_RGBA_S3TC" to "0x83A2",
        "GL_RGBA4_S3TC" to "0x83A3",
        "GL_RGBA_DXT5_S3TC" to "0x83A4",
        "GL_RGBA4_DXT5_S3TC" to "0x83A5"
    )
}

fun sgi() {
    file("DetailTexture", SGIS, "GL_SGIS_detail_texture") {
        "GL_DETAIL_TEXTURE_2D_SGIS"("0x8095")
        "GL_DETAIL_TEXTURE_2D_BINDING_SGIS"("0x8096")
        "GL_LINEAR_DETAIL_SGIS"("0x8097")
        "GL_LINEAR_DETAIL_ALPHA_SGIS"("0x8098")
        "GL_LINEAR_DETAIL_COLOR_SGIS"("0x8099")
        "GL_DETAIL_TEXTURE_LEVEL_SGIS"("0x809A")
        "GL_DETAIL_TEXTURE_MODE_SGIS"("0x809B")
        "GL_DETAIL_TEXTURE_FUNC_POINTS_SGIS"("0x809C")
        "glDetailTexFuncSGIS"(void, GLenum("target"), GLsizei("n"), address("points", "const GLfloat *"))
        "glGetDetailTexFuncSGIS"(void, GLenum("target"), address("points", "GLfloat *"))
    }
    file("FogFunction", SGIS, "GL_SGIS_fog_function") {
        "GL_FOG_FUNC_SGIS"("0x812A")
        "GL_FOG_FUNC_POINTS_SGIS"("0x812B")
        "GL_MAX_FOG_FUNC_POINTS_SGIS"("0x812C")
        "glFogFuncSGIS"(void, GLsizei("n"), address("points", "const GLfloat *"))
        "glGetFogFuncSGIS"(void, address("points", "GLfloat *"))
    }
    file(
        "GenerateMipmap", SGIS, "GL_SGIS_generate_mipmap",
        "GL_GENERATE_MIPMAP_SGIS" to "0x8191",
        "GL_GENERATE_MIPMAP_HINT_SGIS" to "0x8192"
    )
    file("Multisample", SGIS, "GL_SGIS_multisample") {
        "GL_MULTISAMPLE_SGIS"("0x809D")
        "GL_SAMPLE_ALPHA_TO_MASK_SGIS"("0x809E")
        "GL_SAMPLE_ALPHA_TO_ONE_SGIS"("0x809F")
        "GL_SAMPLE_MASK_SGIS"("0x80A0")
        "GL_1PASS_SGIS"("0x80A1")
        "GL_2PASS_0_SGIS"("0x80A2")
        "GL_2PASS_1_SGIS"("0x80A3")
        "GL_4PASS_0_SGIS"("0x80A4")
        "GL_4PASS_1_SGIS"("0x80A5")
        "GL_4PASS_2_SGIS"("0x80A6")
        "GL_4PASS_3_SGIS"("0x80A7")
        "GL_SAMPLE_BUFFERS_SGIS"("0x80A8")
        "GL_SAMPLES_SGIS"("0x80A9")
        "GL_SAMPLE_MASK_VALUE_SGIS"("0x80AA")
        "GL_SAMPLE_MASK_INVERT_SGIS"("0x80AB")
        "GL_SAMPLE_PATTERN_SGIS"("0x80AC")
        "glSampleMaskSGIS"(void, GLclampf("value"), GLboolean("invert"))
        "glSamplePatternSGIS"(void, GLenum("pattern"))
    }
    file("PixelTexture", SGIS, "GL_SGIS_pixel_texture") {
        "GL_PIXEL_TEXTURE_SGIS"("0x8353")
        "GL_PIXEL_FRAGMENT_RGB_SOURCE_SGIS"("0x8354")
        "GL_PIXEL_FRAGMENT_ALPHA_SOURCE_SGIS"("0x8355")
        "GL_PIXEL_GROUP_COLOR_SGIS"("0x8356")
        "glPixelTexGenParameteriSGIS"(void, GLenum("pname"), GLint("param"))
        "glPixelTexGenParameterivSGIS"(void, GLenum("pname"), address("params", "const GLint *"))
        "glPixelTexGenParameterfSGIS"(void, GLenum("pname"), GLfloat("param"))
        "glPixelTexGenParameterfvSGIS"(void, GLenum("pname"), address("params", "const GLfloat *"))
        "glGetPixelTexGenParameterivSGIS"(void, GLenum("pname"), address("params", "GLint *"))
        "glGetPixelTexGenParameterfvSGIS"(void, GLenum("pname"), address("params", "GLfloat *"))
    }
    file(
        "PointLineTexgen", SGIS, "GL_SGIS_point_line_texgen",
        "GL_EYE_DISTANCE_TO_POINT_SGIS" to "0x81F0",
        "GL_OBJECT_DISTANCE_TO_POINT_SGIS" to "0x81F1",
        "GL_EYE_DISTANCE_TO_LINE_SGIS" to "0x81F2",
        "GL_OBJECT_DISTANCE_TO_LINE_SGIS" to "0x81F3",
        "GL_EYE_POINT_SGIS" to "0x81F4",
        "GL_OBJECT_POINT_SGIS" to "0x81F5",
        "GL_EYE_LINE_SGIS" to "0x81F6",
        "GL_OBJECT_LINE_SGIS" to "0x81F7"
    )
    file("PointParameters", SGIS, "GL_SGIS_point_parameters") {
        "GL_POINT_SIZE_MIN_SGIS"("0x8126")
        "GL_POINT_SIZE_MAX_SGIS"("0x8127")
        "GL_POINT_FADE_THRESHOLD_SIZE_SGIS"("0x8128")
        "GL_DISTANCE_ATTENUATION_SGIS"("0x8129")
        "glPointParameterfSGIS"(void, GLenum("pname"), GLfloat("param"))
        "glPointParameterfvSGIS"(void, GLenum("pname"), address("params", "const GLfloat *"))
    }
    file("SharpenTexture", SGIS, "GL_SGIS_sharpen_texture") {
        "GL_LINEAR_SHARPEN_SGIS"("0x80AD")
        "GL_LINEAR_SHARPEN_ALPHA_SGIS"("0x80AE")
        "GL_LINEAR_SHARPEN_COLOR_SGIS"("0x80AF")
        "GL_SHARPEN_TEXTURE_FUNC_POINTS_SGIS"("0x80B0")
        "glSharpenTexFuncSGIS"(void, GLenum("target"), GLsizei("n"), address("points", "const GLfloat *"))
        "glGetSharpenTexFuncSGIS"(void, GLenum("target"), address("points", "GLfloat *"))
    }
    file("Texture4D", SGIS, "GL_SGIS_texture4D") {
        "GL_PACK_SKIP_VOLUMES_SGIS"("0x8130")
        "GL_PACK_IMAGE_DEPTH_SGIS"("0x8131")
        "GL_UNPACK_SKIP_VOLUMES_SGIS"("0x8132")
        "GL_UNPACK_IMAGE_DEPTH_SGIS"("0x8133")
        "GL_TEXTURE_4D_SGIS"("0x8134")
        "GL_PROXY_TEXTURE_4D_SGIS"("0x8135")
        "GL_TEXTURE_4DSIZE_SGIS"("0x8136")
        "GL_TEXTURE_WRAP_Q_SGIS"("0x8137")
        "GL_MAX_4D_TEXTURE_SIZE_SGIS"("0x8138")
        "GL_TEXTURE_4D_BINDING_SGIS"("0x814F")
        "glTexImage4DSGIS"(
            void,
            GLenum("target"),
            GLint("level"),
            GLenum("internalformat"),
            GLsizei("width"),
            GLsizei("height"),
            GLsizei("depth"),
            GLsizei("size4d"),
            GLint("border"),
            GLenum("format"),
            GLenum("type"),
            address("pixels", "const void *")
        )
        "glTexSubImage4DSGIS"(
            void,
            GLenum("target"),
            GLint("level"),
            GLint("xoffset"),
            GLint("yoffset"),
            GLint("zoffset"),
            GLint("woffset"),
            GLsizei("width"),
            GLsizei("height"),
            GLsizei("depth"),
            GLsizei("size4d"),
            GLenum("format"),
            GLenum("type"),
            address("pixels", "const void *")
        )
    }
    file("TextureBorderClamp", SGIS, "GL_SGIS_texture_border_clamp", "GL_CLAMP_TO_BORDER_SGIS" to "0x812D")
    file("TextureColorMask", SGIS, "GL_SGIS_texture_color_mask") {
        "GL_TEXTURE_COLOR_WRITEMASK_SGIS"("0x81EF")
        "glTextureColorMaskSGIS"(void, GLboolean("red"), GLboolean("green"), GLboolean("blue"), GLboolean("alpha"))
    }
    file("TextureEdgeClamp", SGIS, "GL_SGIS_texture_edge_clamp", "GL_CLAMP_TO_EDGE_SGIS" to "0x812F")
    file("TextureFilter4", SGIS, "GL_SGIS_texture_filter4") {
        "GL_FILTER4_SGIS"("0x8146")
        "GL_TEXTURE_FILTER4_SIZE_SGIS"("0x8147")
        "glGetTexFilterFuncSGIS"(void, GLenum("target"), GLenum("filter"), address("weights", "GLfloat *"))
        "glTexFilterFuncSGIS"(
            void,
            GLenum("target"),
            GLenum("filter"),
            GLsizei("n"),
            address("weights", "const GLfloat *")
        )
    }
    file(
        "TextureLod", SGIS, "GL_SGIS_texture_lod",
        "GL_TEXTURE_MIN_LOD_SGIS" to "0x813A",
        "GL_TEXTURE_MAX_LOD_SGIS" to "0x813B",
        "GL_TEXTURE_BASE_LEVEL_SGIS" to "0x813C",
        "GL_TEXTURE_MAX_LEVEL_SGIS" to "0x813D"
    )
    file(
        "TextureSelect", SGIS, "GL_SGIS_texture_select",
        "GL_DUAL_ALPHA4_SGIS" to "0x8110",
        "GL_DUAL_ALPHA8_SGIS" to "0x8111",
        "GL_DUAL_ALPHA12_SGIS" to "0x8112",
        "GL_DUAL_ALPHA16_SGIS" to "0x8113",
        "GL_DUAL_LUMINANCE4_SGIS" to "0x8114",
        "GL_DUAL_LUMINANCE8_SGIS" to "0x8115",
        "GL_DUAL_LUMINANCE12_SGIS" to "0x8116",
        "GL_DUAL_LUMINANCE16_SGIS" to "0x8117",
        "GL_DUAL_INTENSITY4_SGIS" to "0x8118",
        "GL_DUAL_INTENSITY8_SGIS" to "0x8119",
        "GL_DUAL_INTENSITY12_SGIS" to "0x811A",
        "GL_DUAL_INTENSITY16_SGIS" to "0x811B",
        "GL_DUAL_LUMINANCE_ALPHA4_SGIS" to "0x811C",
        "GL_DUAL_LUMINANCE_ALPHA8_SGIS" to "0x811D",
        "GL_QUAD_ALPHA4_SGIS" to "0x811E",
        "GL_QUAD_ALPHA8_SGIS" to "0x811F",
        "GL_QUAD_LUMINANCE4_SGIS" to "0x8120",
        "GL_QUAD_LUMINANCE8_SGIS" to "0x8121",
        "GL_QUAD_INTENSITY4_SGIS" to "0x8122",
        "GL_QUAD_INTENSITY8_SGIS" to "0x8123",
        "GL_DUAL_TEXTURE_SELECT_SGIS" to "0x8124",
        "GL_QUAD_TEXTURE_SELECT_SGIS" to "0x8125"
    )
    file("Async", SGIX, "GL_SGIX_async") {
        "GL_ASYNC_MARKER_SGIX"("0x8329")
        "glAsyncMarkerSGIX"(void, GLuint("marker"))
        "glFinishAsyncSGIX"(GLint, address("markerp", "GLuint *"))
        "glPollAsyncSGIX"(GLint, address("markerp", "GLuint *"))
        "glGenAsyncMarkersSGIX"(GLuint, GLsizei("range"))
        "glDeleteAsyncMarkersSGIX"(void, GLuint("marker"), GLsizei("range"))
        "glIsAsyncMarkerSGIX"(GLboolean, GLuint("marker"))
    }
    file(
        "AsyncHistogram", SGIX, "GL_SGIX_async_histogram",
        "GL_ASYNC_HISTOGRAM_SGIX" to "0x832C",
        "GL_MAX_ASYNC_HISTOGRAM_SGIX" to "0x832D"
    )
    file(
        "AsyncPixel", SGIX, "GL_SGIX_async_pixel",
        "GL_ASYNC_TEX_IMAGE_SGIX" to "0x835C",
        "GL_ASYNC_DRAW_PIXELS_SGIX" to "0x835D",
        "GL_ASYNC_READ_PIXELS_SGIX" to "0x835E",
        "GL_MAX_ASYNC_TEX_IMAGE_SGIX" to "0x835F",
        "GL_MAX_ASYNC_DRAW_PIXELS_SGIX" to "0x8360",
        "GL_MAX_ASYNC_READ_PIXELS_SGIX" to "0x8361"
    )
    file(
        "BlendAlphaMinmax", SGIX, "GL_SGIX_blend_alpha_minmax",
        "GL_ALPHA_MIN_SGIX" to "0x8320",
        "GL_ALPHA_MAX_SGIX" to "0x8321"
    )
    file("CalligraphicFragment", SGIX, "GL_SGIX_calligraphic_fragment", "GL_CALLIGRAPHIC_FRAGMENT_SGIX" to "0x8183")
    file(
        "Clipmap", SGIX, "GL_SGIX_clipmap",
        "GL_LINEAR_CLIPMAP_LINEAR_SGIX" to "0x8170",
        "GL_TEXTURE_CLIPMAP_CENTER_SGIX" to "0x8171",
        "GL_TEXTURE_CLIPMAP_FRAME_SGIX" to "0x8172",
        "GL_TEXTURE_CLIPMAP_OFFSET_SGIX" to "0x8173",
        "GL_TEXTURE_CLIPMAP_VIRTUAL_DEPTH_SGIX" to "0x8174",
        "GL_TEXTURE_CLIPMAP_LOD_OFFSET_SGIX" to "0x8175",
        "GL_TEXTURE_CLIPMAP_DEPTH_SGIX" to "0x8176",
        "GL_MAX_CLIPMAP_DEPTH_SGIX" to "0x8177",
        "GL_MAX_CLIPMAP_VIRTUAL_DEPTH_SGIX" to "0x8178",
        "GL_NEAREST_CLIPMAP_NEAREST_SGIX" to "0x844D",
        "GL_NEAREST_CLIPMAP_LINEAR_SGIX" to "0x844E",
        "GL_LINEAR_CLIPMAP_NEAREST_SGIX" to "0x844F"
    )
    file("ConvolutionAccuracy", SGIX, "GL_SGIX_convolution_accuracy", "GL_CONVOLUTION_HINT_SGIX" to "0x8316")
    file(
        "DepthTexture", SGIX, "GL_SGIX_depth_texture",
        "GL_DEPTH_COMPONENT16_SGIX" to "0x81A5",
        "GL_DEPTH_COMPONENT24_SGIX" to "0x81A6",
        "GL_DEPTH_COMPONENT32_SGIX" to "0x81A7"
    )
    file("FlushRaster", SGIX, "GL_SGIX_flush_raster") {
        "glFlushRasterSGIX"(void)
    }
    file(
        "FogOffset", SGIX, "GL_SGIX_fog_offset",
        "GL_FOG_OFFSET_SGIX" to "0x8198",
        "GL_FOG_OFFSET_VALUE_SGIX" to "0x8199"
    )
    file("FragmentLighting", SGIX, "GL_SGIX_fragment_lighting") {
        "GL_FRAGMENT_LIGHTING_SGIX"("0x8400")
        "GL_FRAGMENT_COLOR_MATERIAL_SGIX"("0x8401")
        "GL_FRAGMENT_COLOR_MATERIAL_FACE_SGIX"("0x8402")
        "GL_FRAGMENT_COLOR_MATERIAL_PARAMETER_SGIX"("0x8403")
        "GL_MAX_FRAGMENT_LIGHTS_SGIX"("0x8404")
        "GL_MAX_ACTIVE_LIGHTS_SGIX"("0x8405")
        "GL_CURRENT_RASTER_NORMAL_SGIX"("0x8406")
        "GL_LIGHT_ENV_MODE_SGIX"("0x8407")
        "GL_FRAGMENT_LIGHT_MODEL_LOCAL_VIEWER_SGIX"("0x8408")
        "GL_FRAGMENT_LIGHT_MODEL_TWO_SIDE_SGIX"("0x8409")
        "GL_FRAGMENT_LIGHT_MODEL_AMBIENT_SGIX"("0x840A")
        "GL_FRAGMENT_LIGHT_MODEL_NORMAL_INTERPOLATION_SGIX"("0x840B")
        "GL_FRAGMENT_LIGHT0_SGIX"("0x840C")
        "GL_FRAGMENT_LIGHT1_SGIX"("0x840D")
        "GL_FRAGMENT_LIGHT2_SGIX"("0x840E")
        "GL_FRAGMENT_LIGHT3_SGIX"("0x840F")
        "GL_FRAGMENT_LIGHT4_SGIX"("0x8410")
        "GL_FRAGMENT_LIGHT5_SGIX"("0x8411")
        "GL_FRAGMENT_LIGHT6_SGIX"("0x8412")
        "GL_FRAGMENT_LIGHT7_SGIX"("0x8413")
        "glFragmentColorMaterialSGIX"(void, GLenum("face"), GLenum("mode"))
        "glFragmentLightfSGIX"(void, GLenum("light"), GLenum("pname"), GLfloat("param"))
        "glFragmentLightfvSGIX"(void, GLenum("light"), GLenum("pname"), address("params", "const GLfloat *"))
        "glFragmentLightiSGIX"(void, GLenum("light"), GLenum("pname"), GLint("param"))
        "glFragmentLightivSGIX"(void, GLenum("light"), GLenum("pname"), address("params", "const GLint *"))
        "glFragmentLightModelfSGIX"(void, GLenum("pname"), GLfloat("param"))
        "glFragmentLightModelfvSGIX"(void, GLenum("pname"), address("params", "const GLfloat *"))
        "glFragmentLightModeliSGIX"(void, GLenum("pname"), GLint("param"))
        "glFragmentLightModelivSGIX"(void, GLenum("pname"), address("params", "const GLint *"))
        "glFragmentMaterialfSGIX"(void, GLenum("face"), GLenum("pname"), GLfloat("param"))
        "glFragmentMaterialfvSGIX"(void, GLenum("face"), GLenum("pname"), address("params", "const GLfloat *"))
        "glFragmentMaterialiSGIX"(void, GLenum("face"), GLenum("pname"), GLint("param"))
        "glFragmentMaterialivSGIX"(void, GLenum("face"), GLenum("pname"), address("params", "const GLint *"))
        "glGetFragmentLightfvSGIX"(void, GLenum("light"), GLenum("pname"), address("params", "GLfloat *"))
        "glGetFragmentLightivSGIX"(void, GLenum("light"), GLenum("pname"), address("params", "GLint *"))
        "glGetFragmentMaterialfvSGIX"(void, GLenum("face"), GLenum("pname"), address("params", "GLfloat *"))
        "glGetFragmentMaterialivSGIX"(void, GLenum("face"), GLenum("pname"), address("params", "GLint *"))
        "glLightEnviSGIX"(void, GLenum("pname"), GLint("param"))
    }
    file("Framezoom", SGIX, "GL_SGIX_framezoom") {
        "GL_FRAMEZOOM_SGIX"("0x818B")
        "GL_FRAMEZOOM_FACTOR_SGIX"("0x818C")
        "GL_MAX_FRAMEZOOM_FACTOR_SGIX"("0x818D")
        "glFrameZoomSGIX"(void, GLint("factor"))
    }
    file("IglooInterface", SGIX, "GL_SGIX_igloo_interface") {
        "glIglooInterfaceSGIX"(void, GLenum("pname"), address("params", "const void *"))
    }
    file("Instruments", SGIX, "GL_SGIX_instruments") {
        "GL_INSTRUMENT_BUFFER_POINTER_SGIX"("0x8180")
        "GL_INSTRUMENT_MEASUREMENTS_SGIX"("0x8181")
        "glGetInstrumentsSGIX"(GLint)
        "glInstrumentsBufferSGIX"(void, GLsizei("size"), address("buffer", "GLint *"))
        "glPollInstrumentsSGIX"(GLint, address("marker_p", "GLint *"))
        "glReadInstrumentsSGIX"(void, GLint("marker"))
        "glStartInstrumentsSGIX"(void)
        "glStopInstrumentsSGIX"(void, GLint("marker"))
    }
    file("Interlace", SGIX, "GL_SGIX_interlace", "GL_INTERLACE_SGIX" to "0x8094")
    file("IrInstrument1", SGIX, "GL_SGIX_ir_instrument1", "GL_IR_INSTRUMENT1_SGIX" to "0x817F")
    file("ListPriority", SGIX, "GL_SGIX_list_priority") {
        "GL_LIST_PRIORITY_SGIX"("0x8182")
        "glGetListParameterfvSGIX"(void, GLuint("list"), GLenum("pname"), address("params", "GLfloat *"))
        "glGetListParameterivSGIX"(void, GLuint("list"), GLenum("pname"), address("params", "GLint *"))
        "glListParameterfSGIX"(void, GLuint("list"), GLenum("pname"), GLfloat("param"))
        "glListParameterfvSGIX"(void, GLuint("list"), GLenum("pname"), address("params", "const GLfloat *"))
        "glListParameteriSGIX"(void, GLuint("list"), GLenum("pname"), GLint("param"))
        "glListParameterivSGIX"(void, GLuint("list"), GLenum("pname"), address("params", "const GLint *"))
    }
    file("PixelTexture", SGIX, "GL_SGIX_pixel_texture") {
        "GL_PIXEL_TEX_GEN_SGIX"("0x8139")
        "GL_PIXEL_TEX_GEN_MODE_SGIX"("0x832B")
        "glPixelTexGenSGIX"(void, GLenum("mode"))
    }
    file(
        "PixelTiles", SGIX, "GL_SGIX_pixel_tiles",
        "GL_PIXEL_TILE_BEST_ALIGNMENT_SGIX" to "0x813E",
        "GL_PIXEL_TILE_CACHE_INCREMENT_SGIX" to "0x813F",
        "GL_PIXEL_TILE_WIDTH_SGIX" to "0x8140",
        "GL_PIXEL_TILE_HEIGHT_SGIX" to "0x8141",
        "GL_PIXEL_TILE_GRID_WIDTH_SGIX" to "0x8142",
        "GL_PIXEL_TILE_GRID_HEIGHT_SGIX" to "0x8143",
        "GL_PIXEL_TILE_GRID_DEPTH_SGIX" to "0x8144",
        "GL_PIXEL_TILE_CACHE_SIZE_SGIX" to "0x8145"
    )
    file("PolynomialFFD", SGIX, "GL_SGIX_polynomial_ffd") {
        "GL_TEXTURE_DEFORMATION_BIT_SGIX"("0x00000001")
        "GL_GEOMETRY_DEFORMATION_BIT_SGIX"("0x00000002")
        "GL_GEOMETRY_DEFORMATION_SGIX"("0x8194")
        "GL_TEXTURE_DEFORMATION_SGIX"("0x8195")
        "GL_DEFORMATIONS_MASK_SGIX"("0x8196")
        "GL_MAX_DEFORMATION_ORDER_SGIX"("0x8197")
        "glDeformationMap3dSGIX"(
            void,
            GLenum("target"),
            GLdouble("u1"),
            GLdouble("u2"),
            GLint("ustride"),
            GLint("uorder"),
            GLdouble("v1"),
            GLdouble("v2"),
            GLint("vstride"),
            GLint("vorder"),
            GLdouble("w1"),
            GLdouble("w2"),
            GLint("wstride"),
            GLint("worder"),
            address("points", "const GLdouble *")
        )
        "glDeformationMap3fSGIX"(
            void,
            GLenum("target"),
            GLfloat("u1"),
            GLfloat("u2"),
            GLint("ustride"),
            GLint("uorder"),
            GLfloat("v1"),
            GLfloat("v2"),
            GLint("vstride"),
            GLint("vorder"),
            GLfloat("w1"),
            GLfloat("w2"),
            GLint("wstride"),
            GLint("worder"),
            address("points", "const GLfloat *")
        )
        "glDeformSGIX"(void, GLbitfield("mask"))
        "glLoadIdentityDeformationMapSGIX"(void, GLbitfield("mask"))
    }
    file("ReferencePlane", SGIX, "GL_SGIX_reference_plane") {
        "GL_REFERENCE_PLANE_SGIX"("0x817D")
        "GL_REFERENCE_PLANE_EQUATION_SGIX"("0x817E")
        "glReferencePlaneSGIX"(void, address("equation", "const GLdouble *"))
    }
    file(
        "Resample", SGIX, "GL_SGIX_resample",
        "GL_PACK_RESAMPLE_SGIX" to "0x842E",
        "GL_UNPACK_RESAMPLE_SGIX" to "0x842F",
        "GL_RESAMPLE_REPLICATE_SGIX" to "0x8433",
        "GL_RESAMPLE_ZERO_FILL_SGIX" to "0x8434",
        "GL_RESAMPLE_DECIMATE_SGIX" to "0x8430"
    )
    file("ScalebiasHint", SGIX, "GL_SGIX_scalebias_hint", "GL_SCALEBIAS_HINT_SGIX" to "0x8322")
    file(
        "Shadow", SGIX, "GL_SGIX_shadow",
        "GL_TEXTURE_COMPARE_SGIX" to "0x819A",
        "GL_TEXTURE_COMPARE_OPERATOR_SGIX" to "0x819B",
        "GL_TEXTURE_LEQUAL_R_SGIX" to "0x819C",
        "GL_TEXTURE_GEQUAL_R_SGIX" to "0x819D"
    )
    file("ShadowAmbient", SGIX, "GL_SGIX_shadow_ambient", "GL_SHADOW_AMBIENT_SGIX" to "0x80BF")
    file("Sprite", SGIX, "GL_SGIX_sprite") {
        "GL_SPRITE_SGIX"("0x8148")
        "GL_SPRITE_MODE_SGIX"("0x8149")
        "GL_SPRITE_AXIS_SGIX"("0x814A")
        "GL_SPRITE_TRANSLATION_SGIX"("0x814B")
        "GL_SPRITE_AXIAL_SGIX"("0x814C")
        "GL_SPRITE_OBJECT_ALIGNED_SGIX"("0x814D")
        "GL_SPRITE_EYE_ALIGNED_SGIX"("0x814E")
        "glSpriteParameterfSGIX"(void, GLenum("pname"), GLfloat("param"))
        "glSpriteParameterfvSGIX"(void, GLenum("pname"), address("params", "const GLfloat *"))
        "glSpriteParameteriSGIX"(void, GLenum("pname"), GLint("param"))
        "glSpriteParameterivSGIX"(void, GLenum("pname"), address("params", "const GLint *"))
    }
    file(
        "Subsample", SGIX, "GL_SGIX_subsample",
        "GL_PACK_SUBSAMPLE_RATE_SGIX" to "0x85A0",
        "GL_UNPACK_SUBSAMPLE_RATE_SGIX" to "0x85A1",
        "GL_PIXEL_SUBSAMPLE_4444_SGIX" to "0x85A2",
        "GL_PIXEL_SUBSAMPLE_2424_SGIX" to "0x85A3",
        "GL_PIXEL_SUBSAMPLE_4242_SGIX" to "0x85A4"
    )
    file("TagSampleBuffer", SGIX, "GL_SGIX_tag_sample_buffer") {
        "glTagSampleBufferSGIX"(void)
    }
    file("TextureAddEnv", SGIX, "GL_SGIX_texture_add_env", "GL_TEXTURE_ENV_BIAS_SGIX" to "0x80BE")
    file(
        "TextureCoordinateClamp", SGIX, "GL_SGIX_texture_coordinate_clamp",
        "GL_TEXTURE_MAX_CLAMP_S_SGIX" to "0x8369",
        "GL_TEXTURE_MAX_CLAMP_T_SGIX" to "0x836A",
        "GL_TEXTURE_MAX_CLAMP_R_SGIX" to "0x836B"
    )
    file(
        "TextureLodBias", SGIX, "GL_SGIX_texture_lod_bias",
        "GL_TEXTURE_LOD_BIAS_S_SGIX" to "0x818E",
        "GL_TEXTURE_LOD_BIAS_T_SGIX" to "0x818F",
        "GL_TEXTURE_LOD_BIAS_R_SGIX" to "0x8190"
    )
    file("TextureMultiBuffer", SGIX, "GL_SGIX_texture_multi_buffer", "GL_TEXTURE_MULTI_BUFFER_HINT_SGIX" to "0x812E")
    file(
        "TextureScaleBias", SGIX, "GL_SGIX_texture_scale_bias",
        "GL_POST_TEXTURE_FILTER_BIAS_SGIX" to "0x8179",
        "GL_POST_TEXTURE_FILTER_SCALE_SGIX" to "0x817A",
        "GL_POST_TEXTURE_FILTER_BIAS_RANGE_SGIX" to "0x817B",
        "GL_POST_TEXTURE_FILTER_SCALE_RANGE_SGIX" to "0x817C"
    )
    file(
        "VertexPreclip", SGIX, "GL_SGIX_vertex_preclip",
        "GL_VERTEX_PRECLIP_SGIX" to "0x83EE",
        "GL_VERTEX_PRECLIP_HINT_SGIX" to "0x83EF"
    )
    file(
        "Ycrcb", SGIX, "GL_SGIX_ycrcb",
        "GL_YCRCB_422_SGIX" to "0x81BB",
        "GL_YCRCB_444_SGIX" to "0x81BC"
    )
    file(
        "Ycrcba", SGIX, "GL_SGIX_ycrcba",
        "GL_YCRCB_SGIX" to "0x8318",
        "GL_YCRCBA_SGIX" to "0x8319"
    )
    file(
        "ColorMatrix", SGI, "GL_SGI_color_matrix",
        "GL_COLOR_MATRIX_SGI" to "0x80B1",
        "GL_COLOR_MATRIX_STACK_DEPTH_SGI" to "0x80B2",
        "GL_MAX_COLOR_MATRIX_STACK_DEPTH_SGI" to "0x80B3",
        "GL_POST_COLOR_MATRIX_RED_SCALE_SGI" to "0x80B4",
        "GL_POST_COLOR_MATRIX_GREEN_SCALE_SGI" to "0x80B5",
        "GL_POST_COLOR_MATRIX_BLUE_SCALE_SGI" to "0x80B6",
        "GL_POST_COLOR_MATRIX_ALPHA_SCALE_SGI" to "0x80B7",
        "GL_POST_COLOR_MATRIX_RED_BIAS_SGI" to "0x80B8",
        "GL_POST_COLOR_MATRIX_GREEN_BIAS_SGI" to "0x80B9",
        "GL_POST_COLOR_MATRIX_BLUE_BIAS_SGI" to "0x80BA",
        "GL_POST_COLOR_MATRIX_ALPHA_BIAS_SGI" to "0x80BB"
    )
    file("ColorTable", SGI, "GL_SGI_color_table") {
        "GL_COLOR_TABLE_SGI"("0x80D0")
        "GL_POST_CONVOLUTION_COLOR_TABLE_SGI"("0x80D1")
        "GL_POST_COLOR_MATRIX_COLOR_TABLE_SGI"("0x80D2")
        "GL_PROXY_COLOR_TABLE_SGI"("0x80D3")
        "GL_PROXY_POST_CONVOLUTION_COLOR_TABLE_SGI"("0x80D4")
        "GL_PROXY_POST_COLOR_MATRIX_COLOR_TABLE_SGI"("0x80D5")
        "GL_COLOR_TABLE_SCALE_SGI"("0x80D6")
        "GL_COLOR_TABLE_BIAS_SGI"("0x80D7")
        "GL_COLOR_TABLE_FORMAT_SGI"("0x80D8")
        "GL_COLOR_TABLE_WIDTH_SGI"("0x80D9")
        "GL_COLOR_TABLE_RED_SIZE_SGI"("0x80DA")
        "GL_COLOR_TABLE_GREEN_SIZE_SGI"("0x80DB")
        "GL_COLOR_TABLE_BLUE_SIZE_SGI"("0x80DC")
        "GL_COLOR_TABLE_ALPHA_SIZE_SGI"("0x80DD")
        "GL_COLOR_TABLE_LUMINANCE_SIZE_SGI"("0x80DE")
        "GL_COLOR_TABLE_INTENSITY_SIZE_SGI"("0x80DF")
        "glColorTableSGI"(
            void,
            GLenum("target"),
            GLenum("internalformat"),
            GLsizei("width"),
            GLenum("format"),
            GLenum("type"),
            address("table", "const void *")
        )
        "glColorTableParameterfvSGI"(void, GLenum("target"), GLenum("pname"), address("params", "const GLfloat *"))
        "glColorTableParameterivSGI"(void, GLenum("target"), GLenum("pname"), address("params", "const GLint *"))
        "glCopyColorTableSGI"(
            void,
            GLenum("target"),
            GLenum("internalformat"),
            GLint("x"),
            GLint("y"),
            GLsizei("width")
        )
        "glGetColorTableSGI"(void, GLenum("target"), GLenum("format"), GLenum("type"), address("table", "void *"))
        "glGetColorTableParameterfvSGI"(void, GLenum("target"), GLenum("pname"), address("params", "GLfloat *"))
        "glGetColorTableParameterivSGI"(void, GLenum("target"), GLenum("pname"), address("params", "GLint *"))
    }
    file(
        "TextureColorTable", SGI, "GL_SGI_texture_color_table",
        "GL_TEXTURE_COLOR_TABLE_SGI" to "0x80BC",
        "GL_PROXY_TEXTURE_COLOR_TABLE_SGI" to "0x80BD"
    )
}

fun sun() {
    file("ConstantData", SUNX, "GL_SUNX_constant_data") {
        "GL_UNPACK_CONSTANT_DATA_SUNX"("0x81D5")
        "GL_TEXTURE_CONSTANT_DATA_SUNX"("0x81D6")
        "glFinishTextureSUNX"(void)
    }
    file(
        "ConvolutionBorderModes", SUN, "GL_SUN_convolution_border_modes",
        "GL_WRAP_BORDER_SUN" to "0x81D4"
    )
    file("GlobalAlpha", SUN, "GL_SUN_global_alpha") {
        "GL_GLOBAL_ALPHA_SUN"("0x81D9")
        "GL_GLOBAL_ALPHA_FACTOR_SUN"("0x81DA")
        "glGlobalAlphaFactorbSUN"(void, GLbyte("factor"))
        "glGlobalAlphaFactorsSUN"(void, GLshort("factor"))
        "glGlobalAlphaFactoriSUN"(void, GLint("factor"))
        "glGlobalAlphaFactorfSUN"(void, GLfloat("factor"))
        "glGlobalAlphaFactordSUN"(void, GLdouble("factor"))
        "glGlobalAlphaFactorubSUN"(void, GLubyte("factor"))
        "glGlobalAlphaFactorusSUN"(void, GLushort("factor"))
        "glGlobalAlphaFactoruiSUN"(void, GLuint("factor"))
    }
    file("MeshArray", SUN, "GL_SUN_mesh_array") {
        "GL_QUAD_MESH_SUN"("0x8614")
        "GL_TRIANGLE_MESH_SUN"("0x8615")
        "glDrawMeshArraysSUN"(void, GLenum("mode"), GLint("first"), GLsizei("count"), GLsizei("width"))
    }
    file(
        "SliceAccum", SUN, "GL_SUN_slice_accum",
        "GL_SLICE_ACCUM_SUN" to "0x85CC"
    )
    file("TriangleList", SUN, "GL_SUN_triangle_list") {
        "GL_RESTART_SUN"("0x0001")
        "GL_REPLACE_MIDDLE_SUN"("0x0002")
        "GL_REPLACE_OLDEST_SUN"("0x0003")
        "GL_TRIANGLE_LIST_SUN"("0x81D7")
        "GL_REPLACEMENT_CODE_SUN"("0x81D8")
        "GL_REPLACEMENT_CODE_ARRAY_SUN"("0x85C0")
        "GL_REPLACEMENT_CODE_ARRAY_TYPE_SUN"("0x85C1")
        "GL_REPLACEMENT_CODE_ARRAY_STRIDE_SUN"("0x85C2")
        "GL_REPLACEMENT_CODE_ARRAY_POINTER_SUN"("0x85C3")
        "GL_R1UI_V3F_SUN"("0x85C4")
        "GL_R1UI_C4UB_V3F_SUN"("0x85C5")
        "GL_R1UI_C3F_V3F_SUN"("0x85C6")
        "GL_R1UI_N3F_V3F_SUN"("0x85C7")
        "GL_R1UI_C4F_N3F_V3F_SUN"("0x85C8")
        "GL_R1UI_T2F_V3F_SUN"("0x85C9")
        "GL_R1UI_T2F_N3F_V3F_SUN"("0x85CA")
        "GL_R1UI_T2F_C4F_N3F_V3F_SUN"("0x85CB")
        "glReplacementCodeuiSUN"(void, GLuint("code"))
        "glReplacementCodeusSUN"(void, GLushort("code"))
        "glReplacementCodeubSUN"(void, GLubyte("code"))
        "glReplacementCodeuivSUN"(void, address("code", "const GLuint *"))
        "glReplacementCodeusvSUN"(void, address("code", "const GLushort *"))
        "glReplacementCodeubvSUN"(void, address("code", "const GLubyte *"))
        "glReplacementCodePointerSUN"(void, GLenum("type"), GLsizei("stride"), address("pointer", "const void **"))
    }
    file("Vertex", SUN, "GL_SUN_vertex") {
        "glColor4ubVertex2fSUN"(
            void,
            GLubyte("r"),
            GLubyte("g"),
            GLubyte("b"),
            GLubyte("a"),
            GLfloat("x"),
            GLfloat("y")
        )
        "glColor4ubVertex2fvSUN"(void, address("c", "const GLubyte *"), address("v", "const GLfloat *"))
        "glColor4ubVertex3fSUN"(
            void,
            GLubyte("r"),
            GLubyte("g"),
            GLubyte("b"),
            GLubyte("a"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z")
        )
        "glColor4ubVertex3fvSUN"(void, address("c", "const GLubyte *"), address("v", "const GLfloat *"))
        "glColor3fVertex3fSUN"(void, GLfloat("r"), GLfloat("g"), GLfloat("b"), GLfloat("x"), GLfloat("y"), GLfloat("z"))
        "glColor3fVertex3fvSUN"(void, address("c", "const GLfloat *"), address("v", "const GLfloat *"))
        "glNormal3fVertex3fSUN"(
            void,
            GLfloat("nx"),
            GLfloat("ny"),
            GLfloat("nz"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z")
        )
        "glNormal3fVertex3fvSUN"(void, address("n", "const GLfloat *"), address("v", "const GLfloat *"))
        "glColor4fNormal3fVertex3fSUN"(
            void,
            GLfloat("r"),
            GLfloat("g"),
            GLfloat("b"),
            GLfloat("a"),
            GLfloat("nx"),
            GLfloat("ny"),
            GLfloat("nz"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z")
        )
        "glColor4fNormal3fVertex3fvSUN"(
            void,
            address("c", "const GLfloat *"),
            address("n", "const GLfloat *"),
            address("v", "const GLfloat *")
        )
        "glTexCoord2fVertex3fSUN"(void, GLfloat("s"), GLfloat("t"), GLfloat("x"), GLfloat("y"), GLfloat("z"))
        "glTexCoord2fVertex3fvSUN"(void, address("tc", "const GLfloat *"), address("v", "const GLfloat *"))
        "glTexCoord4fVertex4fSUN"(
            void,
            GLfloat("s"),
            GLfloat("t"),
            GLfloat("p"),
            GLfloat("q"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z"),
            GLfloat("w")
        )
        "glTexCoord4fVertex4fvSUN"(void, address("tc", "const GLfloat *"), address("v", "const GLfloat *"))
        "glTexCoord2fColor4ubVertex3fSUN"(
            void,
            GLfloat("s"),
            GLfloat("t"),
            GLubyte("r"),
            GLubyte("g"),
            GLubyte("b"),
            GLubyte("a"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z")
        )
        "glTexCoord2fColor4ubVertex3fvSUN"(
            void,
            address("tc", "const GLfloat *"),
            address("c", "const GLubyte *"),
            address("v", "const GLfloat *")
        )
        "glTexCoord2fColor3fVertex3fSUN"(
            void,
            GLfloat("s"),
            GLfloat("t"),
            GLfloat("r"),
            GLfloat("g"),
            GLfloat("b"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z")
        )
        "glTexCoord2fColor3fVertex3fvSUN"(
            void,
            address("tc", "const GLfloat *"),
            address("c", "const GLfloat *"),
            address("v", "const GLfloat *")
        )
        "glTexCoord2fNormal3fVertex3fSUN"(
            void,
            GLfloat("s"),
            GLfloat("t"),
            GLfloat("nx"),
            GLfloat("ny"),
            GLfloat("nz"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z")
        )
        "glTexCoord2fNormal3fVertex3fvSUN"(
            void,
            address("tc", "const GLfloat *"),
            address("n", "const GLfloat *"),
            address("v", "const GLfloat *")
        )
        "glTexCoord2fColor4fNormal3fVertex3fSUN"(
            void,
            GLfloat("s"),
            GLfloat("t"),
            GLfloat("r"),
            GLfloat("g"),
            GLfloat("b"),
            GLfloat("a"),
            GLfloat("nx"),
            GLfloat("ny"),
            GLfloat("nz"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z")
        )
        "glTexCoord2fColor4fNormal3fVertex3fvSUN"(
            void,
            address("tc", "const GLfloat *"),
            address("c", "const GLfloat *"),
            address("n", "const GLfloat *"),
            address("v", "const GLfloat *")
        )
        "glTexCoord4fColor4fNormal3fVertex4fSUN"(
            void,
            GLfloat("s"),
            GLfloat("t"),
            GLfloat("p"),
            GLfloat("q"),
            GLfloat("r"),
            GLfloat("g"),
            GLfloat("b"),
            GLfloat("a"),
            GLfloat("nx"),
            GLfloat("ny"),
            GLfloat("nz"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z"),
            GLfloat("w")
        )
        "glTexCoord4fColor4fNormal3fVertex4fvSUN"(
            void,
            address("tc", "const GLfloat *"),
            address("c", "const GLfloat *"),
            address("n", "const GLfloat *"),
            address("v", "const GLfloat *")
        )
        "glReplacementCodeuiVertex3fSUN"(void, GLuint("rc"), GLfloat("x"), GLfloat("y"), GLfloat("z"))
        "glReplacementCodeuiVertex3fvSUN"(void, address("rc", "const GLuint *"), address("v", "const GLfloat *"))
        "glReplacementCodeuiColor4ubVertex3fSUN"(
            void,
            GLuint("rc"),
            GLubyte("r"),
            GLubyte("g"),
            GLubyte("b"),
            GLubyte("a"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z")
        )
        "glReplacementCodeuiColor4ubVertex3fvSUN"(
            void,
            address("rc", "const GLuint *"),
            address("c", "const GLubyte *"),
            address("v", "const GLfloat *")
        )
        "glReplacementCodeuiColor3fVertex3fSUN"(
            void,
            GLuint("rc"),
            GLfloat("r"),
            GLfloat("g"),
            GLfloat("b"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z")
        )
        "glReplacementCodeuiColor3fVertex3fvSUN"(
            void,
            address("rc", "const GLuint *"),
            address("c", "const GLfloat *"),
            address("v", "const GLfloat *")
        )
        "glReplacementCodeuiNormal3fVertex3fSUN"(
            void,
            GLuint("rc"),
            GLfloat("nx"),
            GLfloat("ny"),
            GLfloat("nz"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z")
        )
        "glReplacementCodeuiNormal3fVertex3fvSUN"(
            void,
            address("rc", "const GLuint *"),
            address("n", "const GLfloat *"),
            address("v", "const GLfloat *")
        )
        "glReplacementCodeuiColor4fNormal3fVertex3fSUN"(
            void,
            GLuint("rc"),
            GLfloat("r"),
            GLfloat("g"),
            GLfloat("b"),
            GLfloat("a"),
            GLfloat("nx"),
            GLfloat("ny"),
            GLfloat("nz"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z")
        )
        "glReplacementCodeuiColor4fNormal3fVertex3fvSUN"(
            void,
            address("rc", "const GLuint *"),
            address("c", "const GLfloat *"),
            address("n", "const GLfloat *"),
            address("v", "const GLfloat *")
        )
        "glReplacementCodeuiTexCoord2fVertex3fSUN"(
            void,
            GLuint("rc"),
            GLfloat("s"),
            GLfloat("t"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z")
        )
        "glReplacementCodeuiTexCoord2fVertex3fvSUN"(
            void,
            address("rc", "const GLuint *"),
            address("tc", "const GLfloat *"),
            address("v", "const GLfloat *")
        )
        "glReplacementCodeuiTexCoord2fNormal3fVertex3fSUN"(
            void,
            GLuint("rc"),
            GLfloat("s"),
            GLfloat("t"),
            GLfloat("nx"),
            GLfloat("ny"),
            GLfloat("nz"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z")
        )
        "glReplacementCodeuiTexCoord2fNormal3fVertex3fvSUN"(
            void,
            address("rc", "const GLuint *"),
            address("tc", "const GLfloat *"),
            address("n", "const GLfloat *"),
            address("v", "const GLfloat *")
        )
        "glReplacementCodeuiTexCoord2fColor4fNormal3fVertex3fSUN"(
            void,
            GLuint("rc"),
            GLfloat("s"),
            GLfloat("t"),
            GLfloat("r"),
            GLfloat("g"),
            GLfloat("b"),
            GLfloat("a"),
            GLfloat("nx"),
            GLfloat("ny"),
            GLfloat("nz"),
            GLfloat("x"),
            GLfloat("y"),
            GLfloat("z")
        )
        "glReplacementCodeuiTexCoord2fColor4fNormal3fVertex3fvSUN"(
            void,
            address("rc", "const GLuint *"),
            address("tc", "const GLfloat *"),
            address("c", "const GLfloat *"),
            address("n", "const GLfloat *"),
            address("v", "const GLfloat *")
        )
    }
}

fun win() {
    file(
        "PhongShading", WIN, "GL_WIN_phong_shading",
        "GL_PHONG_WIN" to "0x80EA",
        "GL_PHONG_HINT_WIN" to "0x80EB"
    )
    file(
        "SpecularFog", WIN, "GL_WIN_specular_fog",
        "GL_FOG_SPECULAR_TEXTURE_WIN" to "0x80EC"
    )
}

fun glExtCaps() {
    val caps = arrayOf(
        "GL_ARB_ES2_compatibility",
        "GL_ARB_ES3_1_compatibility",
        "GL_ARB_ES3_2_compatibility",
        "GL_ARB_ES3_compatibility",
        "GL_ARB_arrays_of_arrays",
        "GL_ARB_base_instance",
        "GL_ARB_bindless_texture",
        "GL_ARB_blend_func_extended",
        "GL_ARB_buffer_storage",
        "GL_ARB_cl_event",
        "GL_ARB_clear_buffer_object",
        "GL_ARB_clear_texture",
        "GL_ARB_clip_control",
        "GL_ARB_color_buffer_float",
        "GL_ARB_compatibility",
        "GL_ARB_compressed_texture_pixel_storage",
        "GL_ARB_compute_shader",
        "GL_ARB_compute_variable_group_size",
        "GL_ARB_conditional_render_inverted",
        "GL_ARB_conservative_depth",
        "GL_ARB_copy_buffer",
        "GL_ARB_copy_image",
        "GL_ARB_cull_distance",
        "GL_ARB_debug_output",
        "GL_ARB_depth_buffer_float",
        "GL_ARB_depth_clamp",
        "GL_ARB_depth_texture",
        "GL_ARB_derivative_control",
        "GL_ARB_direct_state_access",
        "GL_ARB_draw_buffers",
        "GL_ARB_draw_buffers_blend",
        "GL_ARB_draw_elements_base_vertex",
        "GL_ARB_draw_indirect",
        "GL_ARB_draw_instanced",
        "GL_ARB_enhanced_layouts",
        "GL_ARB_explicit_attrib_location",
        "GL_ARB_explicit_uniform_location",
        "GL_ARB_fragment_coord_conventions",
        "GL_ARB_fragment_layer_viewport",
        "GL_ARB_fragment_program",
        "GL_ARB_fragment_program_shadow",
        "GL_ARB_fragment_shader",
        "GL_ARB_fragment_shader_interlock",
        "GL_ARB_framebuffer_no_attachments",
        "GL_ARB_framebuffer_object",
        "GL_ARB_framebuffer_sRGB",
        "GL_ARB_geometry_shader4",
        "GL_ARB_get_program_binary",
        "GL_ARB_get_texture_sub_image",
        "GL_ARB_gl_spirv",
        "GL_ARB_gpu_shader5",
        "GL_ARB_gpu_shader_fp64",
        "GL_ARB_gpu_shader_int64",
        "GL_ARB_half_float_pixel",
        "GL_ARB_half_float_vertex",
        "GL_ARB_imaging",
        "GL_ARB_indirect_parameters",
        "GL_ARB_instanced_arrays",
        "GL_ARB_internalformat_query",
        "GL_ARB_internalformat_query2",
        "GL_ARB_invalidate_subdata",
        "GL_ARB_map_buffer_alignment",
        "GL_ARB_map_buffer_range",
        "GL_ARB_matrix_palette",
        "GL_ARB_multi_bind",
        "GL_ARB_multi_draw_indirect",
        "GL_ARB_multisample",
        "GL_ARB_multitexture",
        "GL_ARB_occlusion_query",
        "GL_ARB_occlusion_query2",
        "GL_ARB_parallel_shader_compile",
        "GL_ARB_pipeline_statistics_query",
        "GL_ARB_pixel_buffer_object",
        "GL_ARB_point_parameters",
        "GL_ARB_point_sprite",
        "GL_ARB_polygon_offset_clamp",
        "GL_ARB_post_depth_coverage",
        "GL_ARB_program_interface_query",
        "GL_ARB_provoking_vertex",
        "GL_ARB_query_buffer_object",
        "GL_ARB_robust_buffer_access_behavior",
        "GL_ARB_robustness",
        "GL_ARB_robustness_isolation",
        "GL_ARB_sample_locations",
        "GL_ARB_sample_shading",
        "GL_ARB_sampler_objects",
        "GL_ARB_seamless_cube_map",
        "GL_ARB_seamless_cubemap_per_texture",
        "GL_ARB_separate_shader_objects",
        "GL_ARB_shader_atomic_counter_ops",
        "GL_ARB_shader_atomic_counters",
        "GL_ARB_shader_ballot",
        "GL_ARB_shader_bit_encoding",
        "GL_ARB_shader_clock",
        "GL_ARB_shader_draw_parameters",
        "GL_ARB_shader_group_vote",
        "GL_ARB_shader_image_load_store",
        "GL_ARB_shader_image_size",
        "GL_ARB_shader_objects",
        "GL_ARB_shader_precision",
        "GL_ARB_shader_stencil_export",
        "GL_ARB_shader_storage_buffer_object",
        "GL_ARB_shader_subroutine",
        "GL_ARB_shader_texture_image_samples",
        "GL_ARB_shader_texture_lod",
        "GL_ARB_shader_viewport_layer_array",
        "GL_ARB_shading_language_100",
        "GL_ARB_shading_language_420pack",
        "GL_ARB_shading_language_include",
        "GL_ARB_shading_language_packing",
        "GL_ARB_shadow",
        "GL_ARB_shadow_ambient",
        "GL_ARB_sparse_buffer",
        "GL_ARB_sparse_texture",
        "GL_ARB_sparse_texture2",
        "GL_ARB_sparse_texture_clamp",
        "GL_ARB_spirv_extensions",
        "GL_ARB_stencil_texturing",
        "GL_ARB_sync",
        "GL_ARB_tessellation_shader",
        "GL_ARB_texture_barrier",
        "GL_ARB_texture_border_clamp",
        "GL_ARB_texture_buffer_object",
        "GL_ARB_texture_buffer_object_rgb32",
        "GL_ARB_texture_buffer_range",
        "GL_ARB_texture_compression",
        "GL_ARB_texture_compression_bptc",
        "GL_ARB_texture_compression_rgtc",
        "GL_ARB_texture_cube_map",
        "GL_ARB_texture_cube_map_array",
        "GL_ARB_texture_env_add",
        "GL_ARB_texture_env_combine",
        "GL_ARB_texture_env_crossbar",
        "GL_ARB_texture_env_dot3",
        "GL_ARB_texture_filter_anisotropic",
        "GL_ARB_texture_filter_minmax",
        "GL_ARB_texture_float",
        "GL_ARB_texture_gather",
        "GL_ARB_texture_mirror_clamp_to_edge",
        "GL_ARB_texture_mirrored_repeat",
        "GL_ARB_texture_multisample",
        "GL_ARB_texture_non_power_of_two",
        "GL_ARB_texture_query_levels",
        "GL_ARB_texture_query_lod",
        "GL_ARB_texture_rectangle",
        "GL_ARB_texture_rg",
        "GL_ARB_texture_rgb10_a2ui",
        "GL_ARB_texture_stencil8",
        "GL_ARB_texture_storage",
        "GL_ARB_texture_storage_multisample",
        "GL_ARB_texture_swizzle",
        "GL_ARB_texture_view",
        "GL_ARB_timer_query",
        "GL_ARB_transform_feedback2",
        "GL_ARB_transform_feedback3",
        "GL_ARB_transform_feedback_instanced",
        "GL_ARB_transform_feedback_overflow_query",
        "GL_ARB_transpose_matrix",
        "GL_ARB_uniform_buffer_object",
        "GL_ARB_vertex_array_bgra",
        "GL_ARB_vertex_array_object",
        "GL_ARB_vertex_attrib_64bit",
        "GL_ARB_vertex_attrib_binding",
        "GL_ARB_vertex_blend",
        "GL_ARB_vertex_buffer_object",
        "GL_ARB_vertex_program",
        "GL_ARB_vertex_shader",
        "GL_ARB_vertex_type_10f_11f_11f_rev",
        "GL_ARB_vertex_type_2_10_10_10_rev",
        "GL_ARB_viewport_array",
        "GL_ARB_window_pos",
        "GL_KHR_blend_equation_advanced",
        "GL_KHR_blend_equation_advanced_coherent",
        "GL_KHR_context_flush_control",
        "GL_KHR_debug",
        "GL_KHR_no_error",
        "GL_KHR_parallel_shader_compile",
        "GL_KHR_robust_buffer_access_behavior",
        "GL_KHR_robustness",
        "GL_KHR_shader_subgroup",
        "GL_KHR_texture_compression_astc_hdr",
        "GL_KHR_texture_compression_astc_ldr",
        "GL_KHR_texture_compression_astc_sliced_3d",
        "GL_OES_byte_coordinates",
        "GL_OES_compressed_paletted_texture",
        "GL_OES_fixed_point",
        "GL_OES_query_matrix",
        "GL_OES_read_format",
        "GL_OES_single_precision",
        "GL_3DFX_multisample",
        "GL_3DFX_tbuffer",
        "GL_3DFX_texture_compression_FXT1",
        "GL_AMD_blend_minmax_factor",
        "GL_AMD_conservative_depth",
        "GL_AMD_debug_output",
        "GL_AMD_depth_clamp_separate",
        "GL_AMD_draw_buffers_blend",
        "GL_AMD_framebuffer_multisample_advanced",
        "GL_AMD_framebuffer_sample_positions",
        "GL_AMD_gcn_shader",
        "GL_AMD_gpu_shader_half_float",
        "GL_AMD_gpu_shader_int16",
        "GL_AMD_gpu_shader_int64",
        "GL_AMD_interleaved_elements",
        "GL_AMD_multi_draw_indirect",
        "GL_AMD_name_gen_delete",
        "GL_AMD_occlusion_query_event",
        "GL_AMD_performance_monitor",
        "GL_AMD_pinned_memory",
        "GL_AMD_query_buffer_object",
        "GL_AMD_sample_positions",
        "GL_AMD_seamless_cubemap_per_texture",
        "GL_AMD_shader_atomic_counter_ops",
        "GL_AMD_shader_ballot",
        "GL_AMD_shader_explicit_vertex_parameter",
        "GL_AMD_shader_gpu_shader_half_float_fetch",
        "GL_AMD_shader_image_load_store_lod",
        "GL_AMD_shader_stencil_export",
        "GL_AMD_shader_trinary_minmax",
        "GL_AMD_sparse_texture",
        "GL_AMD_stencil_operation_extended",
        "GL_AMD_texture_gather_bias_lod",
        "GL_AMD_texture_texture4",
        "GL_AMD_transform_feedback3_lines_triangles",
        "GL_AMD_transform_feedback4",
        "GL_AMD_vertex_shader_layer",
        "GL_AMD_vertex_shader_tessellator",
        "GL_AMD_vertex_shader_viewport_index",
        "GL_APPLE_aux_depth_stencil",
        "GL_APPLE_client_storage",
        "GL_APPLE_element_array",
        "GL_APPLE_fence",
        "GL_APPLE_float_pixels",
        "GL_APPLE_flush_buffer_range",
        "GL_APPLE_object_purgeable",
        "GL_APPLE_rgb_422",
        "GL_APPLE_row_bytes",
        "GL_APPLE_specular_vector",
        "GL_APPLE_texture_range",
        "GL_APPLE_transform_hint",
        "GL_APPLE_vertex_array_object",
        "GL_APPLE_vertex_array_range",
        "GL_APPLE_vertex_program_evaluators",
        "GL_APPLE_ycbcr_422",
        "GL_ATI_draw_buffers",
        "GL_ATI_element_array",
        "GL_ATI_envmap_bumpmap",
        "GL_ATI_fragment_shader",
        "GL_ATI_map_object_buffer",
        "GL_ATI_meminfo",
        "GL_ATI_pixel_format_float",
        "GL_ATI_pn_triangles",
        "GL_ATI_separate_stencil",
        "GL_ATI_text_fragment_shader",
        "GL_ATI_texture_env_combine3",
        "GL_ATI_texture_float",
        "GL_ATI_texture_mirror_once",
        "GL_ATI_vertex_array_object",
        "GL_ATI_vertex_attrib_array_object",
        "GL_ATI_vertex_streams",
        "GL_EXT_422_pixels",
        "GL_EXT_EGL_image_storage",
        "GL_EXT_EGL_sync",
        "GL_EXT_abgr",
        "GL_EXT_bgra",
        "GL_EXT_bindable_uniform",
        "GL_EXT_blend_color",
        "GL_EXT_blend_equation_separate",
        "GL_EXT_blend_func_separate",
        "GL_EXT_blend_logic_op",
        "GL_EXT_blend_minmax",
        "GL_EXT_blend_subtract",
        "GL_EXT_clip_volume_hint",
        "GL_EXT_cmyka",
        "GL_EXT_color_subtable",
        "GL_EXT_compiled_vertex_array",
        "GL_EXT_convolution",
        "GL_EXT_coordinate_frame",
        "GL_EXT_copy_texture",
        "GL_EXT_cull_vertex",
        "GL_EXT_debug_label",
        "GL_EXT_debug_marker",
        "GL_EXT_depth_bounds_test",
        "GL_EXT_direct_state_access",
        "GL_EXT_draw_buffers2",
        "GL_EXT_draw_instanced",
        "GL_EXT_draw_range_elements",
        "GL_EXT_external_buffer",
        "GL_EXT_fog_coord",
        "GL_EXT_framebuffer_blit",
        "GL_EXT_framebuffer_blit_layers",
        "GL_EXT_framebuffer_multisample",
        "GL_EXT_framebuffer_multisample_blit_scaled",
        "GL_EXT_framebuffer_object",
        "GL_EXT_framebuffer_sRGB",
        "GL_EXT_geometry_shader4",
        "GL_EXT_gpu_program_parameters",
        "GL_EXT_gpu_shader4",
        "GL_EXT_histogram",
        "GL_EXT_index_array_formats",
        "GL_EXT_index_func",
        "GL_EXT_index_material",
        "GL_EXT_index_texture",
        "GL_EXT_light_texture",
        "GL_EXT_memory_object",
        "GL_EXT_memory_object_fd",
        "GL_EXT_memory_object_win32",
        "GL_EXT_misc_attribute",
        "GL_EXT_multi_draw_arrays",
        "GL_EXT_multisample",
        "GL_EXT_multiview_tessellation_geometry_shader",
        "GL_EXT_multiview_texture_multisample",
        "GL_EXT_multiview_timer_query",
        "GL_EXT_packed_depth_stencil",
        "GL_EXT_packed_float",
        "GL_EXT_packed_pixels",
        "GL_EXT_paletted_texture",
        "GL_EXT_pixel_buffer_object",
        "GL_EXT_pixel_transform",
        "GL_EXT_pixel_transform_color_table",
        "GL_EXT_point_parameters",
        "GL_EXT_polygon_offset",
        "GL_EXT_polygon_offset_clamp",
        "GL_EXT_post_depth_coverage",
        "GL_EXT_provoking_vertex",
        "GL_EXT_raster_multisample",
        "GL_EXT_rescale_normal",
        "GL_EXT_secondary_color",
        "GL_EXT_semaphore",
        "GL_EXT_semaphore_fd",
        "GL_EXT_semaphore_win32",
        "GL_EXT_separate_shader_objects",
        "GL_EXT_separate_specular_color",
        "GL_EXT_shader_framebuffer_fetch",
        "GL_EXT_shader_framebuffer_fetch_non_coherent",
        "GL_EXT_shader_image_load_formatted",
        "GL_EXT_shader_image_load_store",
        "GL_EXT_shader_integer_mix",
        "GL_EXT_shader_samples_identical",
        "GL_EXT_shadow_funcs",
        "GL_EXT_shared_texture_palette",
        "GL_EXT_sparse_texture2",
        "GL_EXT_stencil_clear_tag",
        "GL_EXT_stencil_two_side",
        "GL_EXT_stencil_wrap",
        "GL_EXT_subtexture",
        "GL_EXT_texture",
        "GL_EXT_texture3D",
        "GL_EXT_texture_array",
        "GL_EXT_texture_buffer_object",
        "GL_EXT_texture_compression_latc",
        "GL_EXT_texture_compression_rgtc",
        "GL_EXT_texture_compression_s3tc",
        "GL_EXT_texture_cube_map",
        "GL_EXT_texture_env_add",
        "GL_EXT_texture_env_combine",
        "GL_EXT_texture_env_dot3",
        "GL_EXT_texture_filter_anisotropic",
        "GL_EXT_texture_filter_minmax",
        "GL_EXT_texture_integer",
        "GL_EXT_texture_lod_bias",
        "GL_EXT_texture_mirror_clamp",
        "GL_EXT_texture_object",
        "GL_EXT_texture_perturb_normal",
        "GL_EXT_texture_sRGB",
        "GL_EXT_texture_sRGB_R8",
        "GL_EXT_texture_sRGB_RG8",
        "GL_EXT_texture_sRGB_decode",
        "GL_EXT_texture_shadow_lod",
        "GL_EXT_texture_shared_exponent",
        "GL_EXT_texture_snorm",
        "GL_EXT_texture_storage",
        "GL_EXT_texture_swizzle",
        "GL_EXT_timer_query",
        "GL_EXT_transform_feedback",
        "GL_EXT_vertex_array",
        "GL_EXT_vertex_array_bgra",
        "GL_EXT_vertex_attrib_64bit",
        "GL_EXT_vertex_shader",
        "GL_EXT_vertex_weighting",
        "GL_EXT_win32_keyed_mutex",
        "GL_EXT_window_rectangles",
        "GL_EXT_x11_sync_object",
        "GL_GREMEDY_frame_terminator",
        "GL_GREMEDY_string_marker",
        "GL_HP_convolution_border_modes",
        "GL_HP_image_transform",
        "GL_HP_occlusion_test",
        "GL_HP_texture_lighting",
        "GL_IBM_cull_vertex",
        "GL_IBM_multimode_draw_arrays",
        "GL_IBM_rasterpos_clip",
        "GL_IBM_static_data",
        "GL_IBM_texture_mirrored_repeat",
        "GL_IBM_vertex_array_lists",
        "GL_INGR_blend_func_separate",
        "GL_INGR_color_clamp",
        "GL_INGR_interlace_read",
        "GL_INTEL_blackhole_render",
        "GL_INTEL_conservative_rasterization",
        "GL_INTEL_fragment_shader_ordering",
        "GL_INTEL_framebuffer_CMAA",
        "GL_INTEL_map_texture",
        "GL_INTEL_parallel_arrays",
        "GL_INTEL_performance_query",
        "GL_MESAX_texture_stack",
        "GL_MESA_framebuffer_flip_x",
        "GL_MESA_framebuffer_flip_y",
        "GL_MESA_framebuffer_swap_xy",
        "GL_MESA_pack_invert",
        "GL_MESA_program_binary_formats",
        "GL_MESA_resize_buffers",
        "GL_MESA_shader_integer_functions",
        "GL_MESA_tile_raster_order",
        "GL_MESA_window_pos",
        "GL_MESA_ycbcr_texture",
        "GL_NVX_blend_equation_advanced_multi_draw_buffers",
        "GL_NVX_conditional_render",
        "GL_NVX_gpu_memory_info",
        "GL_NVX_gpu_multicast2",
        "GL_NVX_linked_gpu_multicast",
        "GL_NVX_progress_fence",
        "GL_NV_alpha_to_coverage_dither_control",
        "GL_NV_bindless_multi_draw_indirect",
        "GL_NV_bindless_multi_draw_indirect_count",
        "GL_NV_bindless_texture",
        "GL_NV_blend_equation_advanced",
        "GL_NV_blend_equation_advanced_coherent",
        "GL_NV_blend_minmax_factor",
        "GL_NV_blend_square",
        "GL_NV_clip_space_w_scaling",
        "GL_NV_command_list",
        "GL_NV_compute_program5",
        "GL_NV_compute_shader_derivatives",
        "GL_NV_conditional_render",
        "GL_NV_conservative_raster",
        "GL_NV_conservative_raster_dilate",
        "GL_NV_conservative_raster_pre_snap",
        "GL_NV_conservative_raster_pre_snap_triangles",
        "GL_NV_conservative_raster_underestimation",
        "GL_NV_copy_depth_to_color",
        "GL_NV_copy_image",
        "GL_NV_deep_texture3D",
        "GL_NV_depth_buffer_float",
        "GL_NV_depth_clamp",
        "GL_NV_draw_texture",
        "GL_NV_draw_vulkan_image",
        "GL_NV_evaluators",
        "GL_NV_explicit_multisample",
        "GL_NV_fence",
        "GL_NV_fill_rectangle",
        "GL_NV_float_buffer",
        "GL_NV_fog_distance",
        "GL_NV_fragment_coverage_to_color",
        "GL_NV_fragment_program",
        "GL_NV_fragment_program2",
        "GL_NV_fragment_program4",
        "GL_NV_fragment_program_option",
        "GL_NV_fragment_shader_barycentric",
        "GL_NV_fragment_shader_interlock",
        "GL_NV_framebuffer_mixed_samples",
        "GL_NV_framebuffer_multisample_coverage",
        "GL_NV_geometry_program4",
        "GL_NV_geometry_shader4",
        "GL_NV_geometry_shader_passthrough",
        "GL_NV_gpu_multicast",
        "GL_NV_gpu_program4",
        "GL_NV_gpu_program5",
        "GL_NV_gpu_program5_mem_extended",
        "GL_NV_gpu_shader5",
        "GL_NV_half_float",
        "GL_NV_internalformat_sample_query",
        "GL_NV_light_max_exponent",
        "GL_NV_memory_attachment",
        "GL_NV_memory_object_sparse",
        "GL_NV_mesh_shader",
        "GL_NV_multisample_coverage",
        "GL_NV_multisample_filter_hint",
        "GL_NV_occlusion_query",
        "GL_NV_packed_depth_stencil",
        "GL_NV_parameter_buffer_object",
        "GL_NV_parameter_buffer_object2",
        "GL_NV_path_rendering",
        "GL_NV_path_rendering_shared_edge",
        "GL_NV_pixel_data_range",
        "GL_NV_point_sprite",
        "GL_NV_present_video",
        "GL_NV_primitive_restart",
        "GL_NV_primitive_shading_rate",
        "GL_NV_query_resource",
        "GL_NV_query_resource_tag",
        "GL_NV_register_combiners",
        "GL_NV_register_combiners2",
        "GL_NV_representative_fragment_test",
        "GL_NV_robustness_video_memory_purge",
        "GL_NV_sample_locations",
        "GL_NV_sample_mask_override_coverage",
        "GL_NV_scissor_exclusive",
        "GL_NV_shader_atomic_counters",
        "GL_NV_shader_atomic_float",
        "GL_NV_shader_atomic_float64",
        "GL_NV_shader_atomic_fp16_vector",
        "GL_NV_shader_atomic_int64",
        "GL_NV_shader_buffer_load",
        "GL_NV_shader_buffer_store",
        "GL_NV_shader_storage_buffer_object",
        "GL_NV_shader_subgroup_partitioned",
        "GL_NV_shader_texture_footprint",
        "GL_NV_shader_thread_group",
        "GL_NV_shader_thread_shuffle",
        "GL_NV_shading_rate_image",
        "GL_NV_stereo_view_rendering",
        "GL_NV_tessellation_program5",
        "GL_NV_texgen_emboss",
        "GL_NV_texgen_reflection",
        "GL_NV_texture_barrier",
        "GL_NV_texture_compression_vtc",
        "GL_NV_texture_env_combine4",
        "GL_NV_texture_expand_normal",
        "GL_NV_texture_multisample",
        "GL_NV_texture_rectangle",
        "GL_NV_texture_rectangle_compressed",
        "GL_NV_texture_shader",
        "GL_NV_texture_shader2",
        "GL_NV_texture_shader3",
        "GL_NV_timeline_semaphore",
        "GL_NV_transform_feedback",
        "GL_NV_transform_feedback2",
        "GL_NV_uniform_buffer_unified_memory",
        "GL_NV_vdpau_interop",
        "GL_NV_vdpau_interop2",
        "GL_NV_vertex_array_range",
        "GL_NV_vertex_array_range2",
        "GL_NV_vertex_attrib_integer_64bit",
        "GL_NV_vertex_buffer_unified_memory",
        "GL_NV_vertex_program",
        "GL_NV_vertex_program1_1",
        "GL_NV_vertex_program2",
        "GL_NV_vertex_program2_option",
        "GL_NV_vertex_program3",
        "GL_NV_vertex_program4",
        "GL_NV_video_capture",
        "GL_NV_viewport_array2",
        "GL_NV_viewport_swizzle",
        "GL_OML_interlace",
        "GL_OML_resample",
        "GL_OML_subsample",
        "GL_OVR_multiview",
        "GL_OVR_multiview2",
        "GL_PGI_misc_hints",
        "GL_PGI_vertex_hints",
        "GL_REND_screen_coordinates",
        "GL_S3_s3tc",
        "GL_SGIS_detail_texture",
        "GL_SGIS_fog_function",
        "GL_SGIS_generate_mipmap",
        "GL_SGIS_multisample",
        "GL_SGIS_pixel_texture",
        "GL_SGIS_point_line_texgen",
        "GL_SGIS_point_parameters",
        "GL_SGIS_sharpen_texture",
        "GL_SGIS_texture4D",
        "GL_SGIS_texture_border_clamp",
        "GL_SGIS_texture_color_mask",
        "GL_SGIS_texture_edge_clamp",
        "GL_SGIS_texture_filter4",
        "GL_SGIS_texture_lod",
        "GL_SGIS_texture_select",
        "GL_SGIX_async",
        "GL_SGIX_async_histogram",
        "GL_SGIX_async_pixel",
        "GL_SGIX_blend_alpha_minmax",
        "GL_SGIX_calligraphic_fragment",
        "GL_SGIX_clipmap",
        "GL_SGIX_convolution_accuracy",
        "GL_SGIX_depth_pass_instrument",
        "GL_SGIX_depth_texture",
        "GL_SGIX_flush_raster",
        "GL_SGIX_fog_offset",
        "GL_SGIX_fragment_lighting",
        "GL_SGIX_framezoom",
        "GL_SGIX_igloo_interface",
        "GL_SGIX_instruments",
        "GL_SGIX_interlace",
        "GL_SGIX_ir_instrument1",
        "GL_SGIX_list_priority",
        "GL_SGIX_pixel_texture",
        "GL_SGIX_pixel_tiles",
        "GL_SGIX_polynomial_ffd",
        "GL_SGIX_reference_plane",
        "GL_SGIX_resample",
        "GL_SGIX_scalebias_hint",
        "GL_SGIX_shadow",
        "GL_SGIX_shadow_ambient",
        "GL_SGIX_sprite",
        "GL_SGIX_subsample",
        "GL_SGIX_tag_sample_buffer",
        "GL_SGIX_texture_add_env",
        "GL_SGIX_texture_coordinate_clamp",
        "GL_SGIX_texture_lod_bias",
        "GL_SGIX_texture_multi_buffer",
        "GL_SGIX_texture_scale_bias",
        "GL_SGIX_vertex_preclip",
        "GL_SGIX_ycrcb",
        "GL_SGIX_ycrcb_subsample",
        "GL_SGIX_ycrcba",
        "GL_SGI_color_matrix",
        "GL_SGI_color_table",
        "GL_SGI_texture_color_table",
        "GL_SUNX_constant_data",
        "GL_SUN_convolution_border_modes",
        "GL_SUN_global_alpha",
        "GL_SUN_mesh_array",
        "GL_SUN_slice_accum",
        "GL_SUN_triangle_list",
        "GL_SUN_vertex",
        "GL_WIN_phong_shading",
        "GL_WIN_specular_fog"
    )
    Files.writeString(Path("GLExtCaps.java"), buildString {
        append(
            """
            ${fileHeader.prependIndent("|")}
            |package overrungl.opengl;
            |
            |import overrungl.opengl.ext.*;
            |import overrungl.opengl.ext.arb.*;
            |import overrungl.opengl.ext.khr.*;
            |import overrungl.opengl.ext.oes.*;
            |import overrungl.opengl.ext.amd.*;
            |import overrungl.opengl.ext.apple.*;
            |import overrungl.opengl.ext.ati.*;
            |import overrungl.opengl.ext.ext.*;
            |import overrungl.opengl.ext.ibm.*;
            |import overrungl.opengl.ext.intel.*;
            |import overrungl.opengl.ext.mesa.*;
            |import overrungl.opengl.ext.nv.*;
            |import overrungl.opengl.ext.sgi.*;
            |import overrungl.opengl.ext.sun.*;
            |
            |import java.lang.foreign.MemorySegment;
            |import java.lang.foreign.SegmentAllocator;
            |import java.lang.invoke.MethodHandle;
            |
            |import static java.lang.foreign.ValueLayout.*;
            |import static overrungl.opengl.GLExtFinder.*;
            |
            |/**
            | * The OpenGL extension capabilities.
            | *
            | * @since 0.1.0
            | */
            |public final class GLExtCaps {
            |    /** The OpenGL extension flags. */
            |    public boolean ${caps.joinToString()};
            |
            |    /** GLCapabilities */
            |    public final GLCapabilities caps;
            |
            |    /**
            |     * Construct <i>incomplete</i> OpenGL extension capabilities.
            |     *
            |     * @param caps The parent capabilities.
            |     */
            |    public GLExtCaps(GLCapabilities caps) {
            |        this.caps = caps;
            |    }
            |
            |    /** Method handles. */
            |    public MethodHandle
            """.trimMargin()
        )
        generatedExtFunctions.forEachIndexed { index, function ->
            if (index.rem(16) == 0) {
                if (index == 0) append("\n        ")
                else append(",\n        ")
            } else append(", ")
            append(function.name)
        }
        appendLine(";\n\n    void load(GLLoadFunc load) {")
        generatedExtClasses.forEach {
            if (it.hasFunction) appendLine("        GL${it.ext.extName}${it.name}.load(this, load);")
        }
        appendLine("    }\n")
        appendLine(
            """
            |    boolean findExtensionsGL(int version, SegmentAllocator allocator) {
            |        var pExts = allocator.allocate(ADDRESS);
            |        var pNumExtsI = allocator.allocate(JAVA_INT);
            |        var pExtsI = new MemorySegment[1];
            |        if (!getExtensions(allocator, version, pExts, pNumExtsI, pExtsI, caps)) return false;
            |
            |        String exts = pExts.getUtf8String(0);
            |        int numExtsI = pNumExtsI.get(JAVA_INT, 0);
            |        var extsI = pExtsI[0];
            |
            |        ${caps.joinToString(separator = "\n|        ") { "this.$it = hasExtension(version, exts, numExtsI, extsI, \"$it\");" }}
            |
            |        return true;
            |    }
        """.trimMargin()
        )
        appendLine("}")
    })
}

/**
 * @author squid233
 * @since 0.1.0
 */
fun main() {
    arb()
    khr()
    oes()
    `3dfx`()
    amd()
    apple()
    ati()
    ext()
    gremedy()
    hp()
    ibm()
    ingr()
    intel()
    mesa()
    nv()
    oml()
    ovr()
    pgi()
    rend()
    s3()
    sgi()
    sun()
    win()
    glExtCaps()
}
