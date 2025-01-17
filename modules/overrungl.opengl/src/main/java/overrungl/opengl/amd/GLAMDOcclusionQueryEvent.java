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
package overrungl.opengl.amd;

import java.lang.foreign.*;
import java.lang.invoke.*;
import overrungl.annotation.*;
import overrungl.internal.RuntimeHelper;
import overrungl.util.*;

public final class GLAMDOcclusionQueryEvent {
    public static final int GL_OCCLUSION_QUERY_EVENT_MASK_AMD = 0x874F;
    public static final int GL_QUERY_DEPTH_PASS_EVENT_BIT_AMD = 0x00000001;
    public static final int GL_QUERY_DEPTH_FAIL_EVENT_BIT_AMD = 0x00000002;
    public static final int GL_QUERY_STENCIL_FAIL_EVENT_BIT_AMD = 0x00000004;
    public static final int GL_QUERY_DEPTH_BOUNDS_FAIL_EVENT_BIT_AMD = 0x00000008;
    public static final int GL_QUERY_ALL_EVENT_BITS_AMD = 0xFFFFFFFF;
    public static final MethodHandle MH_glQueryObjectParameteruiAMD = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glQueryObjectParameteruiAMD;

    public GLAMDOcclusionQueryEvent(overrungl.opengl.GLLoadFunc func) {
        PFN_glQueryObjectParameteruiAMD = func.invoke("glQueryObjectParameteruiAMD");
    }

    public void QueryObjectParameteruiAMD(@CType("GLenum") int target, @CType("GLuint") int id, @CType("GLenum") int pname, @CType("GLuint") int param) {
        if (!Unmarshal.isNullPointer(PFN_glQueryObjectParameteruiAMD)) { try {
            MH_glQueryObjectParameteruiAMD.invokeExact(PFN_glQueryObjectParameteruiAMD, target, id, pname, param);
        } catch (Throwable e) { throw new RuntimeException("error in glQueryObjectParameteruiAMD", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glQueryObjectParameteruiAMD"); }
    }

}
