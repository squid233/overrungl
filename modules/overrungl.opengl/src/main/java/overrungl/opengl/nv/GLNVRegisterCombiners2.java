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

public final class GLNVRegisterCombiners2 {
    public static final int GL_PER_STAGE_CONSTANTS_NV = 0x8535;
    public static final MethodHandle MH_glCombinerStageParameterfvNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glCombinerStageParameterfvNV;
    public static final MethodHandle MH_glGetCombinerStageParameterfvNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetCombinerStageParameterfvNV;

    public GLNVRegisterCombiners2(overrungl.opengl.GLLoadFunc func) {
        PFN_glCombinerStageParameterfvNV = func.invoke("glCombinerStageParameterfvNV");
        PFN_glGetCombinerStageParameterfvNV = func.invoke("glGetCombinerStageParameterfvNV");
    }

    public void CombinerStageParameterfvNV(@CType("GLenum") int stage, @CType("GLenum") int pname, @CType("const GLfloat *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glCombinerStageParameterfvNV)) { try {
            MH_glCombinerStageParameterfvNV.invokeExact(PFN_glCombinerStageParameterfvNV, stage, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glCombinerStageParameterfvNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glCombinerStageParameterfvNV"); }
    }

    public void GetCombinerStageParameterfvNV(@CType("GLenum") int stage, @CType("GLenum") int pname, @CType("GLfloat *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetCombinerStageParameterfvNV)) { try {
            MH_glGetCombinerStageParameterfvNV.invokeExact(PFN_glGetCombinerStageParameterfvNV, stage, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetCombinerStageParameterfvNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetCombinerStageParameterfvNV"); }
    }

}
