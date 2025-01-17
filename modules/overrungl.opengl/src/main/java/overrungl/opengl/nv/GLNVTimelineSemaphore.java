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
package overrungl.opengl.nv;

import java.lang.foreign.*;
import java.lang.invoke.*;
import overrungl.annotation.*;
import overrungl.internal.RuntimeHelper;
import overrungl.util.*;

public final class GLNVTimelineSemaphore {
    public static final int GL_TIMELINE_SEMAPHORE_VALUE_NV = 0x9595;
    public static final int GL_SEMAPHORE_TYPE_NV = 0x95B3;
    public static final int GL_SEMAPHORE_TYPE_BINARY_NV = 0x95B4;
    public static final int GL_SEMAPHORE_TYPE_TIMELINE_NV = 0x95B5;
    public static final int GL_MAX_TIMELINE_SEMAPHORE_VALUE_DIFFERENCE_NV = 0x95B6;
    public static final MethodHandle MH_glCreateSemaphoresNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glCreateSemaphoresNV;
    public static final MethodHandle MH_glSemaphoreParameterivNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glSemaphoreParameterivNV;
    public static final MethodHandle MH_glGetSemaphoreParameterivNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetSemaphoreParameterivNV;

    public GLNVTimelineSemaphore(overrungl.opengl.GLLoadFunc func) {
        PFN_glCreateSemaphoresNV = func.invoke("glCreateSemaphoresNV");
        PFN_glSemaphoreParameterivNV = func.invoke("glSemaphoreParameterivNV");
        PFN_glGetSemaphoreParameterivNV = func.invoke("glGetSemaphoreParameterivNV");
    }

    public void CreateSemaphoresNV(@CType("GLsizei") int n, @CType("GLuint *") java.lang.foreign.MemorySegment semaphores) {
        if (!Unmarshal.isNullPointer(PFN_glCreateSemaphoresNV)) { try {
            MH_glCreateSemaphoresNV.invokeExact(PFN_glCreateSemaphoresNV, n, semaphores);
        } catch (Throwable e) { throw new RuntimeException("error in glCreateSemaphoresNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glCreateSemaphoresNV"); }
    }

    public void SemaphoreParameterivNV(@CType("GLuint") int semaphore, @CType("GLenum") int pname, @CType("const GLint *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glSemaphoreParameterivNV)) { try {
            MH_glSemaphoreParameterivNV.invokeExact(PFN_glSemaphoreParameterivNV, semaphore, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glSemaphoreParameterivNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glSemaphoreParameterivNV"); }
    }

    public void GetSemaphoreParameterivNV(@CType("GLuint") int semaphore, @CType("GLenum") int pname, @CType("GLint *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetSemaphoreParameterivNV)) { try {
            MH_glGetSemaphoreParameterivNV.invokeExact(PFN_glGetSemaphoreParameterivNV, semaphore, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetSemaphoreParameterivNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetSemaphoreParameterivNV"); }
    }

}
