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

public final class GLARBSampleLocations {
    public static final int GL_SAMPLE_LOCATION_SUBPIXEL_BITS_ARB = 0x933D;
    public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_WIDTH_ARB = 0x933E;
    public static final int GL_SAMPLE_LOCATION_PIXEL_GRID_HEIGHT_ARB = 0x933F;
    public static final int GL_PROGRAMMABLE_SAMPLE_LOCATION_TABLE_SIZE_ARB = 0x9340;
    public static final int GL_SAMPLE_LOCATION_ARB = 0x8E50;
    public static final int GL_PROGRAMMABLE_SAMPLE_LOCATION_ARB = 0x9341;
    public static final int GL_FRAMEBUFFER_PROGRAMMABLE_SAMPLE_LOCATIONS_ARB = 0x9342;
    public static final int GL_FRAMEBUFFER_SAMPLE_LOCATION_PIXEL_GRID_ARB = 0x9343;
    public static final MethodHandle MH_glFramebufferSampleLocationsfvARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glFramebufferSampleLocationsfvARB;
    public static final MethodHandle MH_glNamedFramebufferSampleLocationsfvARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glNamedFramebufferSampleLocationsfvARB;
    public static final MethodHandle MH_glEvaluateDepthValuesARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid());
    public final MemorySegment PFN_glEvaluateDepthValuesARB;

    public GLARBSampleLocations(overrungl.opengl.GLLoadFunc func) {
        PFN_glFramebufferSampleLocationsfvARB = func.invoke("glFramebufferSampleLocationsfvARB");
        PFN_glNamedFramebufferSampleLocationsfvARB = func.invoke("glNamedFramebufferSampleLocationsfvARB");
        PFN_glEvaluateDepthValuesARB = func.invoke("glEvaluateDepthValuesARB");
    }

    public void FramebufferSampleLocationsfvARB(@CType("GLenum") int target, @CType("GLuint") int start, @CType("GLsizei") int count, @CType("const GLfloat *") java.lang.foreign.MemorySegment v) {
        if (!Unmarshal.isNullPointer(PFN_glFramebufferSampleLocationsfvARB)) { try {
            MH_glFramebufferSampleLocationsfvARB.invokeExact(PFN_glFramebufferSampleLocationsfvARB, target, start, count, v);
        } catch (Throwable e) { throw new RuntimeException("error in glFramebufferSampleLocationsfvARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glFramebufferSampleLocationsfvARB"); }
    }

    public void NamedFramebufferSampleLocationsfvARB(@CType("GLuint") int framebuffer, @CType("GLuint") int start, @CType("GLsizei") int count, @CType("const GLfloat *") java.lang.foreign.MemorySegment v) {
        if (!Unmarshal.isNullPointer(PFN_glNamedFramebufferSampleLocationsfvARB)) { try {
            MH_glNamedFramebufferSampleLocationsfvARB.invokeExact(PFN_glNamedFramebufferSampleLocationsfvARB, framebuffer, start, count, v);
        } catch (Throwable e) { throw new RuntimeException("error in glNamedFramebufferSampleLocationsfvARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glNamedFramebufferSampleLocationsfvARB"); }
    }

    public void EvaluateDepthValuesARB() {
        if (!Unmarshal.isNullPointer(PFN_glEvaluateDepthValuesARB)) { try {
            MH_glEvaluateDepthValuesARB.invokeExact(PFN_glEvaluateDepthValuesARB);
        } catch (Throwable e) { throw new RuntimeException("error in glEvaluateDepthValuesARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glEvaluateDepthValuesARB"); }
    }

}
