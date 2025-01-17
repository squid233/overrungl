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

public final class GLARBBaseInstance {
    public static final MethodHandle MH_glDrawArraysInstancedBaseInstance = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glDrawArraysInstancedBaseInstance;
    public static final MethodHandle MH_glDrawElementsInstancedBaseInstance = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glDrawElementsInstancedBaseInstance;
    public static final MethodHandle MH_glDrawElementsInstancedBaseVertexBaseInstance = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glDrawElementsInstancedBaseVertexBaseInstance;

    public GLARBBaseInstance(overrungl.opengl.GLLoadFunc func) {
        PFN_glDrawArraysInstancedBaseInstance = func.invoke("glDrawArraysInstancedBaseInstance");
        PFN_glDrawElementsInstancedBaseInstance = func.invoke("glDrawElementsInstancedBaseInstance");
        PFN_glDrawElementsInstancedBaseVertexBaseInstance = func.invoke("glDrawElementsInstancedBaseVertexBaseInstance");
    }

    public void DrawArraysInstancedBaseInstance(@CType("GLenum") int mode, @CType("GLint") int first, @CType("GLsizei") int count, @CType("GLsizei") int instancecount, @CType("GLuint") int baseinstance) {
        if (!Unmarshal.isNullPointer(PFN_glDrawArraysInstancedBaseInstance)) { try {
            MH_glDrawArraysInstancedBaseInstance.invokeExact(PFN_glDrawArraysInstancedBaseInstance, mode, first, count, instancecount, baseinstance);
        } catch (Throwable e) { throw new RuntimeException("error in glDrawArraysInstancedBaseInstance", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDrawArraysInstancedBaseInstance"); }
    }

    public void DrawElementsInstancedBaseInstance(@CType("GLenum") int mode, @CType("GLsizei") int count, @CType("GLenum") int type, @CType("const void *") java.lang.foreign.MemorySegment indices, @CType("GLsizei") int instancecount, @CType("GLuint") int baseinstance) {
        if (!Unmarshal.isNullPointer(PFN_glDrawElementsInstancedBaseInstance)) { try {
            MH_glDrawElementsInstancedBaseInstance.invokeExact(PFN_glDrawElementsInstancedBaseInstance, mode, count, type, indices, instancecount, baseinstance);
        } catch (Throwable e) { throw new RuntimeException("error in glDrawElementsInstancedBaseInstance", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDrawElementsInstancedBaseInstance"); }
    }

    public void DrawElementsInstancedBaseVertexBaseInstance(@CType("GLenum") int mode, @CType("GLsizei") int count, @CType("GLenum") int type, @CType("const void *") java.lang.foreign.MemorySegment indices, @CType("GLsizei") int instancecount, @CType("GLint") int basevertex, @CType("GLuint") int baseinstance) {
        if (!Unmarshal.isNullPointer(PFN_glDrawElementsInstancedBaseVertexBaseInstance)) { try {
            MH_glDrawElementsInstancedBaseVertexBaseInstance.invokeExact(PFN_glDrawElementsInstancedBaseVertexBaseInstance, mode, count, type, indices, instancecount, basevertex, baseinstance);
        } catch (Throwable e) { throw new RuntimeException("error in glDrawElementsInstancedBaseVertexBaseInstance", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDrawElementsInstancedBaseVertexBaseInstance"); }
    }

}
