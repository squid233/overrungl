/*
 * MIT License
 *
 * Copyright (c) 2022-2025 Overrun Organization
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

// This file is auto-generated. DO NOT EDIT!
package overrungl.opengl.arb;

import java.lang.foreign.*;
import java.lang.invoke.*;
import overrungl.annotation.*;
import overrungl.internal.RuntimeHelper;
import overrungl.util.*;

public final class GLARBVertexArrayObject {
    public static final int GL_VERTEX_ARRAY_BINDING = 0x85B5;
    public static final MethodHandle MH_glBindVertexArray = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glBindVertexArray;
    public static final MethodHandle MH_glDeleteVertexArrays = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glDeleteVertexArrays;
    public static final MethodHandle MH_glGenVertexArrays = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGenVertexArrays;
    public static final MethodHandle MH_glIsVertexArray = RuntimeHelper.downcall(FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glIsVertexArray;

    public GLARBVertexArrayObject(overrungl.opengl.GLLoadFunc func) {
        PFN_glBindVertexArray = func.invoke("glBindVertexArray");
        PFN_glDeleteVertexArrays = func.invoke("glDeleteVertexArrays");
        PFN_glGenVertexArrays = func.invoke("glGenVertexArrays");
        PFN_glIsVertexArray = func.invoke("glIsVertexArray");
    }

    public void BindVertexArray(@CType("GLuint") int array) {
        if (!Unmarshal.isNullPointer(PFN_glBindVertexArray)) { try {
            MH_glBindVertexArray.invokeExact(PFN_glBindVertexArray, array);
        } catch (Throwable e) { throw new RuntimeException("error in glBindVertexArray", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glBindVertexArray"); }
    }

    public void DeleteVertexArrays(@CType("GLsizei") int n, @CType("const GLuint *") java.lang.foreign.MemorySegment arrays) {
        if (!Unmarshal.isNullPointer(PFN_glDeleteVertexArrays)) { try {
            MH_glDeleteVertexArrays.invokeExact(PFN_glDeleteVertexArrays, n, arrays);
        } catch (Throwable e) { throw new RuntimeException("error in glDeleteVertexArrays", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDeleteVertexArrays"); }
    }

    public void GenVertexArrays(@CType("GLsizei") int n, @CType("GLuint *") java.lang.foreign.MemorySegment arrays) {
        if (!Unmarshal.isNullPointer(PFN_glGenVertexArrays)) { try {
            MH_glGenVertexArrays.invokeExact(PFN_glGenVertexArrays, n, arrays);
        } catch (Throwable e) { throw new RuntimeException("error in glGenVertexArrays", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGenVertexArrays"); }
    }

    public @CType("GLboolean") boolean IsVertexArray(@CType("GLuint") int array) {
        if (!Unmarshal.isNullPointer(PFN_glIsVertexArray)) { try {
            return (boolean) MH_glIsVertexArray.invokeExact(PFN_glIsVertexArray, array);
        } catch (Throwable e) { throw new RuntimeException("error in glIsVertexArray", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glIsVertexArray"); }
    }

}
