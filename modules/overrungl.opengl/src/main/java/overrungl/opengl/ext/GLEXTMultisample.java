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
package overrungl.opengl.ext;

import java.lang.foreign.*;
import java.lang.invoke.*;
import overrungl.annotation.*;
import overrungl.internal.RuntimeHelper;
import overrungl.util.*;

public final class GLEXTMultisample {
    public static final int GL_MULTISAMPLE_EXT = 0x809D;
    public static final int GL_SAMPLE_ALPHA_TO_MASK_EXT = 0x809E;
    public static final int GL_SAMPLE_ALPHA_TO_ONE_EXT = 0x809F;
    public static final int GL_SAMPLE_MASK_EXT = 0x80A0;
    public static final int GL_1PASS_EXT = 0x80A1;
    public static final int GL_2PASS_0_EXT = 0x80A2;
    public static final int GL_2PASS_1_EXT = 0x80A3;
    public static final int GL_4PASS_0_EXT = 0x80A4;
    public static final int GL_4PASS_1_EXT = 0x80A5;
    public static final int GL_4PASS_2_EXT = 0x80A6;
    public static final int GL_4PASS_3_EXT = 0x80A7;
    public static final int GL_SAMPLE_BUFFERS_EXT = 0x80A8;
    public static final int GL_SAMPLES_EXT = 0x80A9;
    public static final int GL_SAMPLE_MASK_VALUE_EXT = 0x80AA;
    public static final int GL_SAMPLE_MASK_INVERT_EXT = 0x80AB;
    public static final int GL_SAMPLE_PATTERN_EXT = 0x80AC;
    public static final int GL_MULTISAMPLE_BIT_EXT = 0x20000000;
    public static final MethodHandle MH_glSampleMaskEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_BOOLEAN));
    public final MemorySegment PFN_glSampleMaskEXT;
    public static final MethodHandle MH_glSamplePatternEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glSamplePatternEXT;

    public GLEXTMultisample(overrungl.opengl.GLLoadFunc func) {
        PFN_glSampleMaskEXT = func.invoke("glSampleMaskEXT");
        PFN_glSamplePatternEXT = func.invoke("glSamplePatternEXT");
    }

    public void SampleMaskEXT(@CType("GLclampf") float value, @CType("GLboolean") boolean invert) {
        if (!Unmarshal.isNullPointer(PFN_glSampleMaskEXT)) { try {
            MH_glSampleMaskEXT.invokeExact(PFN_glSampleMaskEXT, value, invert);
        } catch (Throwable e) { throw new RuntimeException("error in glSampleMaskEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glSampleMaskEXT"); }
    }

    public void SamplePatternEXT(@CType("GLenum") int pattern) {
        if (!Unmarshal.isNullPointer(PFN_glSamplePatternEXT)) { try {
            MH_glSamplePatternEXT.invokeExact(PFN_glSamplePatternEXT, pattern);
        } catch (Throwable e) { throw new RuntimeException("error in glSamplePatternEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glSamplePatternEXT"); }
    }

}
