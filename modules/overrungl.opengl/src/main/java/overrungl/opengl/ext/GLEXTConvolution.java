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

public final class GLEXTConvolution {
    public static final int GL_CONVOLUTION_1D_EXT = 0x8010;
    public static final int GL_CONVOLUTION_2D_EXT = 0x8011;
    public static final int GL_SEPARABLE_2D_EXT = 0x8012;
    public static final int GL_CONVOLUTION_BORDER_MODE_EXT = 0x8013;
    public static final int GL_CONVOLUTION_FILTER_SCALE_EXT = 0x8014;
    public static final int GL_CONVOLUTION_FILTER_BIAS_EXT = 0x8015;
    public static final int GL_REDUCE_EXT = 0x8016;
    public static final int GL_CONVOLUTION_FORMAT_EXT = 0x8017;
    public static final int GL_CONVOLUTION_WIDTH_EXT = 0x8018;
    public static final int GL_CONVOLUTION_HEIGHT_EXT = 0x8019;
    public static final int GL_MAX_CONVOLUTION_WIDTH_EXT = 0x801A;
    public static final int GL_MAX_CONVOLUTION_HEIGHT_EXT = 0x801B;
    public static final int GL_POST_CONVOLUTION_RED_SCALE_EXT = 0x801C;
    public static final int GL_POST_CONVOLUTION_GREEN_SCALE_EXT = 0x801D;
    public static final int GL_POST_CONVOLUTION_BLUE_SCALE_EXT = 0x801E;
    public static final int GL_POST_CONVOLUTION_ALPHA_SCALE_EXT = 0x801F;
    public static final int GL_POST_CONVOLUTION_RED_BIAS_EXT = 0x8020;
    public static final int GL_POST_CONVOLUTION_GREEN_BIAS_EXT = 0x8021;
    public static final int GL_POST_CONVOLUTION_BLUE_BIAS_EXT = 0x8022;
    public static final int GL_POST_CONVOLUTION_ALPHA_BIAS_EXT = 0x8023;
    public static final MethodHandle MH_glConvolutionFilter1DEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glConvolutionFilter1DEXT;
    public static final MethodHandle MH_glConvolutionFilter2DEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glConvolutionFilter2DEXT;
    public static final MethodHandle MH_glConvolutionParameterfEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_FLOAT));
    public final MemorySegment PFN_glConvolutionParameterfEXT;
    public static final MethodHandle MH_glConvolutionParameterfvEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glConvolutionParameterfvEXT;
    public static final MethodHandle MH_glConvolutionParameteriEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glConvolutionParameteriEXT;
    public static final MethodHandle MH_glConvolutionParameterivEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glConvolutionParameterivEXT;
    public static final MethodHandle MH_glCopyConvolutionFilter1DEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glCopyConvolutionFilter1DEXT;
    public static final MethodHandle MH_glCopyConvolutionFilter2DEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glCopyConvolutionFilter2DEXT;
    public static final MethodHandle MH_glGetConvolutionFilterEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetConvolutionFilterEXT;
    public static final MethodHandle MH_glGetConvolutionParameterfvEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetConvolutionParameterfvEXT;
    public static final MethodHandle MH_glGetConvolutionParameterivEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetConvolutionParameterivEXT;
    public static final MethodHandle MH_glGetSeparableFilterEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetSeparableFilterEXT;
    public static final MethodHandle MH_glSeparableFilter2DEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glSeparableFilter2DEXT;

    public GLEXTConvolution(overrungl.opengl.GLLoadFunc func) {
        PFN_glConvolutionFilter1DEXT = func.invoke("glConvolutionFilter1DEXT", "glConvolutionFilter1D");
        PFN_glConvolutionFilter2DEXT = func.invoke("glConvolutionFilter2DEXT", "glConvolutionFilter2D");
        PFN_glConvolutionParameterfEXT = func.invoke("glConvolutionParameterfEXT", "glConvolutionParameterf");
        PFN_glConvolutionParameterfvEXT = func.invoke("glConvolutionParameterfvEXT", "glConvolutionParameterfv");
        PFN_glConvolutionParameteriEXT = func.invoke("glConvolutionParameteriEXT", "glConvolutionParameteri");
        PFN_glConvolutionParameterivEXT = func.invoke("glConvolutionParameterivEXT", "glConvolutionParameteriv");
        PFN_glCopyConvolutionFilter1DEXT = func.invoke("glCopyConvolutionFilter1DEXT", "glCopyConvolutionFilter1D");
        PFN_glCopyConvolutionFilter2DEXT = func.invoke("glCopyConvolutionFilter2DEXT", "glCopyConvolutionFilter2D");
        PFN_glGetConvolutionFilterEXT = func.invoke("glGetConvolutionFilterEXT");
        PFN_glGetConvolutionParameterfvEXT = func.invoke("glGetConvolutionParameterfvEXT");
        PFN_glGetConvolutionParameterivEXT = func.invoke("glGetConvolutionParameterivEXT");
        PFN_glGetSeparableFilterEXT = func.invoke("glGetSeparableFilterEXT");
        PFN_glSeparableFilter2DEXT = func.invoke("glSeparableFilter2DEXT", "glSeparableFilter2D");
    }

    public void ConvolutionFilter1DEXT(@CType("GLenum") int target, @CType("GLenum") int internalformat, @CType("GLsizei") int width, @CType("GLenum") int format, @CType("GLenum") int type, @CType("const void *") java.lang.foreign.MemorySegment image) {
        if (!Unmarshal.isNullPointer(PFN_glConvolutionFilter1DEXT)) { try {
            MH_glConvolutionFilter1DEXT.invokeExact(PFN_glConvolutionFilter1DEXT, target, internalformat, width, format, type, image);
        } catch (Throwable e) { throw new RuntimeException("error in glConvolutionFilter1DEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glConvolutionFilter1DEXT"); }
    }

    public void ConvolutionFilter2DEXT(@CType("GLenum") int target, @CType("GLenum") int internalformat, @CType("GLsizei") int width, @CType("GLsizei") int height, @CType("GLenum") int format, @CType("GLenum") int type, @CType("const void *") java.lang.foreign.MemorySegment image) {
        if (!Unmarshal.isNullPointer(PFN_glConvolutionFilter2DEXT)) { try {
            MH_glConvolutionFilter2DEXT.invokeExact(PFN_glConvolutionFilter2DEXT, target, internalformat, width, height, format, type, image);
        } catch (Throwable e) { throw new RuntimeException("error in glConvolutionFilter2DEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glConvolutionFilter2DEXT"); }
    }

    public void ConvolutionParameterfEXT(@CType("GLenum") int target, @CType("GLenum") int pname, @CType("GLfloat") float params) {
        if (!Unmarshal.isNullPointer(PFN_glConvolutionParameterfEXT)) { try {
            MH_glConvolutionParameterfEXT.invokeExact(PFN_glConvolutionParameterfEXT, target, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glConvolutionParameterfEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glConvolutionParameterfEXT"); }
    }

    public void ConvolutionParameterfvEXT(@CType("GLenum") int target, @CType("GLenum") int pname, @CType("const GLfloat *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glConvolutionParameterfvEXT)) { try {
            MH_glConvolutionParameterfvEXT.invokeExact(PFN_glConvolutionParameterfvEXT, target, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glConvolutionParameterfvEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glConvolutionParameterfvEXT"); }
    }

    public void ConvolutionParameteriEXT(@CType("GLenum") int target, @CType("GLenum") int pname, @CType("GLint") int params) {
        if (!Unmarshal.isNullPointer(PFN_glConvolutionParameteriEXT)) { try {
            MH_glConvolutionParameteriEXT.invokeExact(PFN_glConvolutionParameteriEXT, target, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glConvolutionParameteriEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glConvolutionParameteriEXT"); }
    }

    public void ConvolutionParameterivEXT(@CType("GLenum") int target, @CType("GLenum") int pname, @CType("const GLint *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glConvolutionParameterivEXT)) { try {
            MH_glConvolutionParameterivEXT.invokeExact(PFN_glConvolutionParameterivEXT, target, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glConvolutionParameterivEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glConvolutionParameterivEXT"); }
    }

    public void CopyConvolutionFilter1DEXT(@CType("GLenum") int target, @CType("GLenum") int internalformat, @CType("GLint") int x, @CType("GLint") int y, @CType("GLsizei") int width) {
        if (!Unmarshal.isNullPointer(PFN_glCopyConvolutionFilter1DEXT)) { try {
            MH_glCopyConvolutionFilter1DEXT.invokeExact(PFN_glCopyConvolutionFilter1DEXT, target, internalformat, x, y, width);
        } catch (Throwable e) { throw new RuntimeException("error in glCopyConvolutionFilter1DEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glCopyConvolutionFilter1DEXT"); }
    }

    public void CopyConvolutionFilter2DEXT(@CType("GLenum") int target, @CType("GLenum") int internalformat, @CType("GLint") int x, @CType("GLint") int y, @CType("GLsizei") int width, @CType("GLsizei") int height) {
        if (!Unmarshal.isNullPointer(PFN_glCopyConvolutionFilter2DEXT)) { try {
            MH_glCopyConvolutionFilter2DEXT.invokeExact(PFN_glCopyConvolutionFilter2DEXT, target, internalformat, x, y, width, height);
        } catch (Throwable e) { throw new RuntimeException("error in glCopyConvolutionFilter2DEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glCopyConvolutionFilter2DEXT"); }
    }

    public void GetConvolutionFilterEXT(@CType("GLenum") int target, @CType("GLenum") int format, @CType("GLenum") int type, @CType("void*") java.lang.foreign.MemorySegment image) {
        if (!Unmarshal.isNullPointer(PFN_glGetConvolutionFilterEXT)) { try {
            MH_glGetConvolutionFilterEXT.invokeExact(PFN_glGetConvolutionFilterEXT, target, format, type, image);
        } catch (Throwable e) { throw new RuntimeException("error in glGetConvolutionFilterEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetConvolutionFilterEXT"); }
    }

    public void GetConvolutionParameterfvEXT(@CType("GLenum") int target, @CType("GLenum") int pname, @CType("GLfloat *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetConvolutionParameterfvEXT)) { try {
            MH_glGetConvolutionParameterfvEXT.invokeExact(PFN_glGetConvolutionParameterfvEXT, target, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetConvolutionParameterfvEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetConvolutionParameterfvEXT"); }
    }

    public void GetConvolutionParameterivEXT(@CType("GLenum") int target, @CType("GLenum") int pname, @CType("GLint *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetConvolutionParameterivEXT)) { try {
            MH_glGetConvolutionParameterivEXT.invokeExact(PFN_glGetConvolutionParameterivEXT, target, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetConvolutionParameterivEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetConvolutionParameterivEXT"); }
    }

    public void GetSeparableFilterEXT(@CType("GLenum") int target, @CType("GLenum") int format, @CType("GLenum") int type, @CType("void*") java.lang.foreign.MemorySegment row, @CType("void*") java.lang.foreign.MemorySegment column, @CType("void*") java.lang.foreign.MemorySegment span) {
        if (!Unmarshal.isNullPointer(PFN_glGetSeparableFilterEXT)) { try {
            MH_glGetSeparableFilterEXT.invokeExact(PFN_glGetSeparableFilterEXT, target, format, type, row, column, span);
        } catch (Throwable e) { throw new RuntimeException("error in glGetSeparableFilterEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetSeparableFilterEXT"); }
    }

    public void SeparableFilter2DEXT(@CType("GLenum") int target, @CType("GLenum") int internalformat, @CType("GLsizei") int width, @CType("GLsizei") int height, @CType("GLenum") int format, @CType("GLenum") int type, @CType("const void *") java.lang.foreign.MemorySegment row, @CType("const void *") java.lang.foreign.MemorySegment column) {
        if (!Unmarshal.isNullPointer(PFN_glSeparableFilter2DEXT)) { try {
            MH_glSeparableFilter2DEXT.invokeExact(PFN_glSeparableFilter2DEXT, target, internalformat, width, height, format, type, row, column);
        } catch (Throwable e) { throw new RuntimeException("error in glSeparableFilter2DEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glSeparableFilter2DEXT"); }
    }

}
