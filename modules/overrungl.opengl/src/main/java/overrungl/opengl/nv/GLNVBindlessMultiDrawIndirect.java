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

public final class GLNVBindlessMultiDrawIndirect {
    public static final MethodHandle MH_glMultiDrawArraysIndirectBindlessNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glMultiDrawArraysIndirectBindlessNV;
    public static final MethodHandle MH_glMultiDrawElementsIndirectBindlessNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glMultiDrawElementsIndirectBindlessNV;

    public GLNVBindlessMultiDrawIndirect(overrungl.opengl.GLLoadFunc func) {
        PFN_glMultiDrawArraysIndirectBindlessNV = func.invoke("glMultiDrawArraysIndirectBindlessNV");
        PFN_glMultiDrawElementsIndirectBindlessNV = func.invoke("glMultiDrawElementsIndirectBindlessNV");
    }

    public void MultiDrawArraysIndirectBindlessNV(@CType("GLenum") int mode, @CType("const void *") java.lang.foreign.MemorySegment indirect, @CType("GLsizei") int drawCount, @CType("GLsizei") int stride, @CType("GLint") int vertexBufferCount) {
        if (!Unmarshal.isNullPointer(PFN_glMultiDrawArraysIndirectBindlessNV)) { try {
            MH_glMultiDrawArraysIndirectBindlessNV.invokeExact(PFN_glMultiDrawArraysIndirectBindlessNV, mode, indirect, drawCount, stride, vertexBufferCount);
        } catch (Throwable e) { throw new RuntimeException("error in glMultiDrawArraysIndirectBindlessNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glMultiDrawArraysIndirectBindlessNV"); }
    }

    public void MultiDrawElementsIndirectBindlessNV(@CType("GLenum") int mode, @CType("GLenum") int type, @CType("const void *") java.lang.foreign.MemorySegment indirect, @CType("GLsizei") int drawCount, @CType("GLsizei") int stride, @CType("GLint") int vertexBufferCount) {
        if (!Unmarshal.isNullPointer(PFN_glMultiDrawElementsIndirectBindlessNV)) { try {
            MH_glMultiDrawElementsIndirectBindlessNV.invokeExact(PFN_glMultiDrawElementsIndirectBindlessNV, mode, type, indirect, drawCount, stride, vertexBufferCount);
        } catch (Throwable e) { throw new RuntimeException("error in glMultiDrawElementsIndirectBindlessNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glMultiDrawElementsIndirectBindlessNV"); }
    }

}
