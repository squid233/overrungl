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

public final class GLARBGpuShaderInt64 {
    public static final int GL_INT64_ARB = 0x140E;
    public static final int GL_UNSIGNED_INT64_ARB = 0x140F;
    public static final int GL_INT64_VEC2_ARB = 0x8FE9;
    public static final int GL_INT64_VEC3_ARB = 0x8FEA;
    public static final int GL_INT64_VEC4_ARB = 0x8FEB;
    public static final int GL_UNSIGNED_INT64_VEC2_ARB = 0x8FF5;
    public static final int GL_UNSIGNED_INT64_VEC3_ARB = 0x8FF6;
    public static final int GL_UNSIGNED_INT64_VEC4_ARB = 0x8FF7;
    public static final MethodHandle MH_glUniform1i64ARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glUniform1i64ARB;
    public static final MethodHandle MH_glUniform2i64ARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glUniform2i64ARB;
    public static final MethodHandle MH_glUniform3i64ARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glUniform3i64ARB;
    public static final MethodHandle MH_glUniform4i64ARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glUniform4i64ARB;
    public static final MethodHandle MH_glUniform1i64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glUniform1i64vARB;
    public static final MethodHandle MH_glUniform2i64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glUniform2i64vARB;
    public static final MethodHandle MH_glUniform3i64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glUniform3i64vARB;
    public static final MethodHandle MH_glUniform4i64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glUniform4i64vARB;
    public static final MethodHandle MH_glUniform1ui64ARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glUniform1ui64ARB;
    public static final MethodHandle MH_glUniform2ui64ARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glUniform2ui64ARB;
    public static final MethodHandle MH_glUniform3ui64ARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glUniform3ui64ARB;
    public static final MethodHandle MH_glUniform4ui64ARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glUniform4ui64ARB;
    public static final MethodHandle MH_glUniform1ui64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glUniform1ui64vARB;
    public static final MethodHandle MH_glUniform2ui64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glUniform2ui64vARB;
    public static final MethodHandle MH_glUniform3ui64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glUniform3ui64vARB;
    public static final MethodHandle MH_glUniform4ui64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glUniform4ui64vARB;
    public static final MethodHandle MH_glGetUniformi64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetUniformi64vARB;
    public static final MethodHandle MH_glGetUniformui64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetUniformui64vARB;
    public static final MethodHandle MH_glGetnUniformi64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetnUniformi64vARB;
    public static final MethodHandle MH_glGetnUniformui64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetnUniformui64vARB;
    public static final MethodHandle MH_glProgramUniform1i64ARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glProgramUniform1i64ARB;
    public static final MethodHandle MH_glProgramUniform2i64ARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glProgramUniform2i64ARB;
    public static final MethodHandle MH_glProgramUniform3i64ARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glProgramUniform3i64ARB;
    public static final MethodHandle MH_glProgramUniform4i64ARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glProgramUniform4i64ARB;
    public static final MethodHandle MH_glProgramUniform1i64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glProgramUniform1i64vARB;
    public static final MethodHandle MH_glProgramUniform2i64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glProgramUniform2i64vARB;
    public static final MethodHandle MH_glProgramUniform3i64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glProgramUniform3i64vARB;
    public static final MethodHandle MH_glProgramUniform4i64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glProgramUniform4i64vARB;
    public static final MethodHandle MH_glProgramUniform1ui64ARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glProgramUniform1ui64ARB;
    public static final MethodHandle MH_glProgramUniform2ui64ARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glProgramUniform2ui64ARB;
    public static final MethodHandle MH_glProgramUniform3ui64ARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glProgramUniform3ui64ARB;
    public static final MethodHandle MH_glProgramUniform4ui64ARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glProgramUniform4ui64ARB;
    public static final MethodHandle MH_glProgramUniform1ui64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glProgramUniform1ui64vARB;
    public static final MethodHandle MH_glProgramUniform2ui64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glProgramUniform2ui64vARB;
    public static final MethodHandle MH_glProgramUniform3ui64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glProgramUniform3ui64vARB;
    public static final MethodHandle MH_glProgramUniform4ui64vARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glProgramUniform4ui64vARB;

    public GLARBGpuShaderInt64(overrungl.opengl.GLLoadFunc func) {
        PFN_glUniform1i64ARB = func.invoke("glUniform1i64ARB");
        PFN_glUniform2i64ARB = func.invoke("glUniform2i64ARB");
        PFN_glUniform3i64ARB = func.invoke("glUniform3i64ARB");
        PFN_glUniform4i64ARB = func.invoke("glUniform4i64ARB");
        PFN_glUniform1i64vARB = func.invoke("glUniform1i64vARB");
        PFN_glUniform2i64vARB = func.invoke("glUniform2i64vARB");
        PFN_glUniform3i64vARB = func.invoke("glUniform3i64vARB");
        PFN_glUniform4i64vARB = func.invoke("glUniform4i64vARB");
        PFN_glUniform1ui64ARB = func.invoke("glUniform1ui64ARB");
        PFN_glUniform2ui64ARB = func.invoke("glUniform2ui64ARB");
        PFN_glUniform3ui64ARB = func.invoke("glUniform3ui64ARB");
        PFN_glUniform4ui64ARB = func.invoke("glUniform4ui64ARB");
        PFN_glUniform1ui64vARB = func.invoke("glUniform1ui64vARB");
        PFN_glUniform2ui64vARB = func.invoke("glUniform2ui64vARB");
        PFN_glUniform3ui64vARB = func.invoke("glUniform3ui64vARB");
        PFN_glUniform4ui64vARB = func.invoke("glUniform4ui64vARB");
        PFN_glGetUniformi64vARB = func.invoke("glGetUniformi64vARB");
        PFN_glGetUniformui64vARB = func.invoke("glGetUniformui64vARB");
        PFN_glGetnUniformi64vARB = func.invoke("glGetnUniformi64vARB");
        PFN_glGetnUniformui64vARB = func.invoke("glGetnUniformui64vARB");
        PFN_glProgramUniform1i64ARB = func.invoke("glProgramUniform1i64ARB");
        PFN_glProgramUniform2i64ARB = func.invoke("glProgramUniform2i64ARB");
        PFN_glProgramUniform3i64ARB = func.invoke("glProgramUniform3i64ARB");
        PFN_glProgramUniform4i64ARB = func.invoke("glProgramUniform4i64ARB");
        PFN_glProgramUniform1i64vARB = func.invoke("glProgramUniform1i64vARB");
        PFN_glProgramUniform2i64vARB = func.invoke("glProgramUniform2i64vARB");
        PFN_glProgramUniform3i64vARB = func.invoke("glProgramUniform3i64vARB");
        PFN_glProgramUniform4i64vARB = func.invoke("glProgramUniform4i64vARB");
        PFN_glProgramUniform1ui64ARB = func.invoke("glProgramUniform1ui64ARB");
        PFN_glProgramUniform2ui64ARB = func.invoke("glProgramUniform2ui64ARB");
        PFN_glProgramUniform3ui64ARB = func.invoke("glProgramUniform3ui64ARB");
        PFN_glProgramUniform4ui64ARB = func.invoke("glProgramUniform4ui64ARB");
        PFN_glProgramUniform1ui64vARB = func.invoke("glProgramUniform1ui64vARB");
        PFN_glProgramUniform2ui64vARB = func.invoke("glProgramUniform2ui64vARB");
        PFN_glProgramUniform3ui64vARB = func.invoke("glProgramUniform3ui64vARB");
        PFN_glProgramUniform4ui64vARB = func.invoke("glProgramUniform4ui64vARB");
    }

    public void Uniform1i64ARB(@CType("GLint") int location, @CType("GLint64") long x) {
        if (!Unmarshal.isNullPointer(PFN_glUniform1i64ARB)) { try {
            MH_glUniform1i64ARB.invokeExact(PFN_glUniform1i64ARB, location, x);
        } catch (Throwable e) { throw new RuntimeException("error in glUniform1i64ARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniform1i64ARB"); }
    }

    public void Uniform2i64ARB(@CType("GLint") int location, @CType("GLint64") long x, @CType("GLint64") long y) {
        if (!Unmarshal.isNullPointer(PFN_glUniform2i64ARB)) { try {
            MH_glUniform2i64ARB.invokeExact(PFN_glUniform2i64ARB, location, x, y);
        } catch (Throwable e) { throw new RuntimeException("error in glUniform2i64ARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniform2i64ARB"); }
    }

    public void Uniform3i64ARB(@CType("GLint") int location, @CType("GLint64") long x, @CType("GLint64") long y, @CType("GLint64") long z) {
        if (!Unmarshal.isNullPointer(PFN_glUniform3i64ARB)) { try {
            MH_glUniform3i64ARB.invokeExact(PFN_glUniform3i64ARB, location, x, y, z);
        } catch (Throwable e) { throw new RuntimeException("error in glUniform3i64ARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniform3i64ARB"); }
    }

    public void Uniform4i64ARB(@CType("GLint") int location, @CType("GLint64") long x, @CType("GLint64") long y, @CType("GLint64") long z, @CType("GLint64") long w) {
        if (!Unmarshal.isNullPointer(PFN_glUniform4i64ARB)) { try {
            MH_glUniform4i64ARB.invokeExact(PFN_glUniform4i64ARB, location, x, y, z, w);
        } catch (Throwable e) { throw new RuntimeException("error in glUniform4i64ARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniform4i64ARB"); }
    }

    public void Uniform1i64vARB(@CType("GLint") int location, @CType("GLsizei") int count, @CType("const GLint64 *") java.lang.foreign.MemorySegment value) {
        if (!Unmarshal.isNullPointer(PFN_glUniform1i64vARB)) { try {
            MH_glUniform1i64vARB.invokeExact(PFN_glUniform1i64vARB, location, count, value);
        } catch (Throwable e) { throw new RuntimeException("error in glUniform1i64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniform1i64vARB"); }
    }

    public void Uniform2i64vARB(@CType("GLint") int location, @CType("GLsizei") int count, @CType("const GLint64 *") java.lang.foreign.MemorySegment value) {
        if (!Unmarshal.isNullPointer(PFN_glUniform2i64vARB)) { try {
            MH_glUniform2i64vARB.invokeExact(PFN_glUniform2i64vARB, location, count, value);
        } catch (Throwable e) { throw new RuntimeException("error in glUniform2i64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniform2i64vARB"); }
    }

    public void Uniform3i64vARB(@CType("GLint") int location, @CType("GLsizei") int count, @CType("const GLint64 *") java.lang.foreign.MemorySegment value) {
        if (!Unmarshal.isNullPointer(PFN_glUniform3i64vARB)) { try {
            MH_glUniform3i64vARB.invokeExact(PFN_glUniform3i64vARB, location, count, value);
        } catch (Throwable e) { throw new RuntimeException("error in glUniform3i64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniform3i64vARB"); }
    }

    public void Uniform4i64vARB(@CType("GLint") int location, @CType("GLsizei") int count, @CType("const GLint64 *") java.lang.foreign.MemorySegment value) {
        if (!Unmarshal.isNullPointer(PFN_glUniform4i64vARB)) { try {
            MH_glUniform4i64vARB.invokeExact(PFN_glUniform4i64vARB, location, count, value);
        } catch (Throwable e) { throw new RuntimeException("error in glUniform4i64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniform4i64vARB"); }
    }

    public void Uniform1ui64ARB(@CType("GLint") int location, @CType("GLuint64") long x) {
        if (!Unmarshal.isNullPointer(PFN_glUniform1ui64ARB)) { try {
            MH_glUniform1ui64ARB.invokeExact(PFN_glUniform1ui64ARB, location, x);
        } catch (Throwable e) { throw new RuntimeException("error in glUniform1ui64ARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniform1ui64ARB"); }
    }

    public void Uniform2ui64ARB(@CType("GLint") int location, @CType("GLuint64") long x, @CType("GLuint64") long y) {
        if (!Unmarshal.isNullPointer(PFN_glUniform2ui64ARB)) { try {
            MH_glUniform2ui64ARB.invokeExact(PFN_glUniform2ui64ARB, location, x, y);
        } catch (Throwable e) { throw new RuntimeException("error in glUniform2ui64ARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniform2ui64ARB"); }
    }

    public void Uniform3ui64ARB(@CType("GLint") int location, @CType("GLuint64") long x, @CType("GLuint64") long y, @CType("GLuint64") long z) {
        if (!Unmarshal.isNullPointer(PFN_glUniform3ui64ARB)) { try {
            MH_glUniform3ui64ARB.invokeExact(PFN_glUniform3ui64ARB, location, x, y, z);
        } catch (Throwable e) { throw new RuntimeException("error in glUniform3ui64ARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniform3ui64ARB"); }
    }

    public void Uniform4ui64ARB(@CType("GLint") int location, @CType("GLuint64") long x, @CType("GLuint64") long y, @CType("GLuint64") long z, @CType("GLuint64") long w) {
        if (!Unmarshal.isNullPointer(PFN_glUniform4ui64ARB)) { try {
            MH_glUniform4ui64ARB.invokeExact(PFN_glUniform4ui64ARB, location, x, y, z, w);
        } catch (Throwable e) { throw new RuntimeException("error in glUniform4ui64ARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniform4ui64ARB"); }
    }

    public void Uniform1ui64vARB(@CType("GLint") int location, @CType("GLsizei") int count, @CType("const GLuint64 *") java.lang.foreign.MemorySegment value) {
        if (!Unmarshal.isNullPointer(PFN_glUniform1ui64vARB)) { try {
            MH_glUniform1ui64vARB.invokeExact(PFN_glUniform1ui64vARB, location, count, value);
        } catch (Throwable e) { throw new RuntimeException("error in glUniform1ui64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniform1ui64vARB"); }
    }

    public void Uniform2ui64vARB(@CType("GLint") int location, @CType("GLsizei") int count, @CType("const GLuint64 *") java.lang.foreign.MemorySegment value) {
        if (!Unmarshal.isNullPointer(PFN_glUniform2ui64vARB)) { try {
            MH_glUniform2ui64vARB.invokeExact(PFN_glUniform2ui64vARB, location, count, value);
        } catch (Throwable e) { throw new RuntimeException("error in glUniform2ui64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniform2ui64vARB"); }
    }

    public void Uniform3ui64vARB(@CType("GLint") int location, @CType("GLsizei") int count, @CType("const GLuint64 *") java.lang.foreign.MemorySegment value) {
        if (!Unmarshal.isNullPointer(PFN_glUniform3ui64vARB)) { try {
            MH_glUniform3ui64vARB.invokeExact(PFN_glUniform3ui64vARB, location, count, value);
        } catch (Throwable e) { throw new RuntimeException("error in glUniform3ui64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniform3ui64vARB"); }
    }

    public void Uniform4ui64vARB(@CType("GLint") int location, @CType("GLsizei") int count, @CType("const GLuint64 *") java.lang.foreign.MemorySegment value) {
        if (!Unmarshal.isNullPointer(PFN_glUniform4ui64vARB)) { try {
            MH_glUniform4ui64vARB.invokeExact(PFN_glUniform4ui64vARB, location, count, value);
        } catch (Throwable e) { throw new RuntimeException("error in glUniform4ui64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniform4ui64vARB"); }
    }

    public void GetUniformi64vARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLint64 *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetUniformi64vARB)) { try {
            MH_glGetUniformi64vARB.invokeExact(PFN_glGetUniformi64vARB, program, location, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetUniformi64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetUniformi64vARB"); }
    }

    public void GetUniformui64vARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLuint64 *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetUniformui64vARB)) { try {
            MH_glGetUniformui64vARB.invokeExact(PFN_glGetUniformui64vARB, program, location, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetUniformui64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetUniformui64vARB"); }
    }

    public void GetnUniformi64vARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLsizei") int bufSize, @CType("GLint64 *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetnUniformi64vARB)) { try {
            MH_glGetnUniformi64vARB.invokeExact(PFN_glGetnUniformi64vARB, program, location, bufSize, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetnUniformi64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetnUniformi64vARB"); }
    }

    public void GetnUniformui64vARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLsizei") int bufSize, @CType("GLuint64 *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetnUniformui64vARB)) { try {
            MH_glGetnUniformui64vARB.invokeExact(PFN_glGetnUniformui64vARB, program, location, bufSize, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetnUniformui64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetnUniformui64vARB"); }
    }

    public void ProgramUniform1i64ARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLint64") long x) {
        if (!Unmarshal.isNullPointer(PFN_glProgramUniform1i64ARB)) { try {
            MH_glProgramUniform1i64ARB.invokeExact(PFN_glProgramUniform1i64ARB, program, location, x);
        } catch (Throwable e) { throw new RuntimeException("error in glProgramUniform1i64ARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glProgramUniform1i64ARB"); }
    }

    public void ProgramUniform2i64ARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLint64") long x, @CType("GLint64") long y) {
        if (!Unmarshal.isNullPointer(PFN_glProgramUniform2i64ARB)) { try {
            MH_glProgramUniform2i64ARB.invokeExact(PFN_glProgramUniform2i64ARB, program, location, x, y);
        } catch (Throwable e) { throw new RuntimeException("error in glProgramUniform2i64ARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glProgramUniform2i64ARB"); }
    }

    public void ProgramUniform3i64ARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLint64") long x, @CType("GLint64") long y, @CType("GLint64") long z) {
        if (!Unmarshal.isNullPointer(PFN_glProgramUniform3i64ARB)) { try {
            MH_glProgramUniform3i64ARB.invokeExact(PFN_glProgramUniform3i64ARB, program, location, x, y, z);
        } catch (Throwable e) { throw new RuntimeException("error in glProgramUniform3i64ARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glProgramUniform3i64ARB"); }
    }

    public void ProgramUniform4i64ARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLint64") long x, @CType("GLint64") long y, @CType("GLint64") long z, @CType("GLint64") long w) {
        if (!Unmarshal.isNullPointer(PFN_glProgramUniform4i64ARB)) { try {
            MH_glProgramUniform4i64ARB.invokeExact(PFN_glProgramUniform4i64ARB, program, location, x, y, z, w);
        } catch (Throwable e) { throw new RuntimeException("error in glProgramUniform4i64ARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glProgramUniform4i64ARB"); }
    }

    public void ProgramUniform1i64vARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLsizei") int count, @CType("const GLint64 *") java.lang.foreign.MemorySegment value) {
        if (!Unmarshal.isNullPointer(PFN_glProgramUniform1i64vARB)) { try {
            MH_glProgramUniform1i64vARB.invokeExact(PFN_glProgramUniform1i64vARB, program, location, count, value);
        } catch (Throwable e) { throw new RuntimeException("error in glProgramUniform1i64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glProgramUniform1i64vARB"); }
    }

    public void ProgramUniform2i64vARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLsizei") int count, @CType("const GLint64 *") java.lang.foreign.MemorySegment value) {
        if (!Unmarshal.isNullPointer(PFN_glProgramUniform2i64vARB)) { try {
            MH_glProgramUniform2i64vARB.invokeExact(PFN_glProgramUniform2i64vARB, program, location, count, value);
        } catch (Throwable e) { throw new RuntimeException("error in glProgramUniform2i64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glProgramUniform2i64vARB"); }
    }

    public void ProgramUniform3i64vARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLsizei") int count, @CType("const GLint64 *") java.lang.foreign.MemorySegment value) {
        if (!Unmarshal.isNullPointer(PFN_glProgramUniform3i64vARB)) { try {
            MH_glProgramUniform3i64vARB.invokeExact(PFN_glProgramUniform3i64vARB, program, location, count, value);
        } catch (Throwable e) { throw new RuntimeException("error in glProgramUniform3i64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glProgramUniform3i64vARB"); }
    }

    public void ProgramUniform4i64vARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLsizei") int count, @CType("const GLint64 *") java.lang.foreign.MemorySegment value) {
        if (!Unmarshal.isNullPointer(PFN_glProgramUniform4i64vARB)) { try {
            MH_glProgramUniform4i64vARB.invokeExact(PFN_glProgramUniform4i64vARB, program, location, count, value);
        } catch (Throwable e) { throw new RuntimeException("error in glProgramUniform4i64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glProgramUniform4i64vARB"); }
    }

    public void ProgramUniform1ui64ARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLuint64") long x) {
        if (!Unmarshal.isNullPointer(PFN_glProgramUniform1ui64ARB)) { try {
            MH_glProgramUniform1ui64ARB.invokeExact(PFN_glProgramUniform1ui64ARB, program, location, x);
        } catch (Throwable e) { throw new RuntimeException("error in glProgramUniform1ui64ARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glProgramUniform1ui64ARB"); }
    }

    public void ProgramUniform2ui64ARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLuint64") long x, @CType("GLuint64") long y) {
        if (!Unmarshal.isNullPointer(PFN_glProgramUniform2ui64ARB)) { try {
            MH_glProgramUniform2ui64ARB.invokeExact(PFN_glProgramUniform2ui64ARB, program, location, x, y);
        } catch (Throwable e) { throw new RuntimeException("error in glProgramUniform2ui64ARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glProgramUniform2ui64ARB"); }
    }

    public void ProgramUniform3ui64ARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLuint64") long x, @CType("GLuint64") long y, @CType("GLuint64") long z) {
        if (!Unmarshal.isNullPointer(PFN_glProgramUniform3ui64ARB)) { try {
            MH_glProgramUniform3ui64ARB.invokeExact(PFN_glProgramUniform3ui64ARB, program, location, x, y, z);
        } catch (Throwable e) { throw new RuntimeException("error in glProgramUniform3ui64ARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glProgramUniform3ui64ARB"); }
    }

    public void ProgramUniform4ui64ARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLuint64") long x, @CType("GLuint64") long y, @CType("GLuint64") long z, @CType("GLuint64") long w) {
        if (!Unmarshal.isNullPointer(PFN_glProgramUniform4ui64ARB)) { try {
            MH_glProgramUniform4ui64ARB.invokeExact(PFN_glProgramUniform4ui64ARB, program, location, x, y, z, w);
        } catch (Throwable e) { throw new RuntimeException("error in glProgramUniform4ui64ARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glProgramUniform4ui64ARB"); }
    }

    public void ProgramUniform1ui64vARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLsizei") int count, @CType("const GLuint64 *") java.lang.foreign.MemorySegment value) {
        if (!Unmarshal.isNullPointer(PFN_glProgramUniform1ui64vARB)) { try {
            MH_glProgramUniform1ui64vARB.invokeExact(PFN_glProgramUniform1ui64vARB, program, location, count, value);
        } catch (Throwable e) { throw new RuntimeException("error in glProgramUniform1ui64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glProgramUniform1ui64vARB"); }
    }

    public void ProgramUniform2ui64vARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLsizei") int count, @CType("const GLuint64 *") java.lang.foreign.MemorySegment value) {
        if (!Unmarshal.isNullPointer(PFN_glProgramUniform2ui64vARB)) { try {
            MH_glProgramUniform2ui64vARB.invokeExact(PFN_glProgramUniform2ui64vARB, program, location, count, value);
        } catch (Throwable e) { throw new RuntimeException("error in glProgramUniform2ui64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glProgramUniform2ui64vARB"); }
    }

    public void ProgramUniform3ui64vARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLsizei") int count, @CType("const GLuint64 *") java.lang.foreign.MemorySegment value) {
        if (!Unmarshal.isNullPointer(PFN_glProgramUniform3ui64vARB)) { try {
            MH_glProgramUniform3ui64vARB.invokeExact(PFN_glProgramUniform3ui64vARB, program, location, count, value);
        } catch (Throwable e) { throw new RuntimeException("error in glProgramUniform3ui64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glProgramUniform3ui64vARB"); }
    }

    public void ProgramUniform4ui64vARB(@CType("GLuint") int program, @CType("GLint") int location, @CType("GLsizei") int count, @CType("const GLuint64 *") java.lang.foreign.MemorySegment value) {
        if (!Unmarshal.isNullPointer(PFN_glProgramUniform4ui64vARB)) { try {
            MH_glProgramUniform4ui64vARB.invokeExact(PFN_glProgramUniform4ui64vARB, program, location, count, value);
        } catch (Throwable e) { throw new RuntimeException("error in glProgramUniform4ui64vARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glProgramUniform4ui64vARB"); }
    }

}
