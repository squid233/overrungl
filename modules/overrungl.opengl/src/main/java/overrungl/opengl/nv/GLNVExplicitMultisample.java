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

public final class GLNVExplicitMultisample {
    public static final int GL_SAMPLE_POSITION_NV = 0x8E50;
    public static final int GL_SAMPLE_MASK_NV = 0x8E51;
    public static final int GL_SAMPLE_MASK_VALUE_NV = 0x8E52;
    public static final int GL_TEXTURE_BINDING_RENDERBUFFER_NV = 0x8E53;
    public static final int GL_TEXTURE_RENDERBUFFER_DATA_STORE_BINDING_NV = 0x8E54;
    public static final int GL_TEXTURE_RENDERBUFFER_NV = 0x8E55;
    public static final int GL_SAMPLER_RENDERBUFFER_NV = 0x8E56;
    public static final int GL_INT_SAMPLER_RENDERBUFFER_NV = 0x8E57;
    public static final int GL_UNSIGNED_INT_SAMPLER_RENDERBUFFER_NV = 0x8E58;
    public static final int GL_MAX_SAMPLE_MASK_WORDS_NV = 0x8E59;
    public static final MethodHandle MH_glGetMultisamplefvNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetMultisamplefvNV;
    public static final MethodHandle MH_glSampleMaskIndexedNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glSampleMaskIndexedNV;
    public static final MethodHandle MH_glTexRenderbufferNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glTexRenderbufferNV;

    public GLNVExplicitMultisample(overrungl.opengl.GLLoadFunc func) {
        PFN_glGetMultisamplefvNV = func.invoke("glGetMultisamplefvNV", "glGetMultisamplefv");
        PFN_glSampleMaskIndexedNV = func.invoke("glSampleMaskIndexedNV");
        PFN_glTexRenderbufferNV = func.invoke("glTexRenderbufferNV");
    }

    public void GetMultisamplefvNV(@CType("GLenum") int pname, @CType("GLuint") int index, @CType("GLfloat *") java.lang.foreign.MemorySegment val) {
        if (!Unmarshal.isNullPointer(PFN_glGetMultisamplefvNV)) { try {
            MH_glGetMultisamplefvNV.invokeExact(PFN_glGetMultisamplefvNV, pname, index, val);
        } catch (Throwable e) { throw new RuntimeException("error in glGetMultisamplefvNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetMultisamplefvNV"); }
    }

    public void SampleMaskIndexedNV(@CType("GLuint") int index, @CType("GLbitfield") int mask) {
        if (!Unmarshal.isNullPointer(PFN_glSampleMaskIndexedNV)) { try {
            MH_glSampleMaskIndexedNV.invokeExact(PFN_glSampleMaskIndexedNV, index, mask);
        } catch (Throwable e) { throw new RuntimeException("error in glSampleMaskIndexedNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glSampleMaskIndexedNV"); }
    }

    public void TexRenderbufferNV(@CType("GLenum") int target, @CType("GLuint") int renderbuffer) {
        if (!Unmarshal.isNullPointer(PFN_glTexRenderbufferNV)) { try {
            MH_glTexRenderbufferNV.invokeExact(PFN_glTexRenderbufferNV, target, renderbuffer);
        } catch (Throwable e) { throw new RuntimeException("error in glTexRenderbufferNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glTexRenderbufferNV"); }
    }

}
