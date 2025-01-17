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
package overrungl.opengl;

import java.lang.foreign.*;
import java.lang.invoke.*;
import overrungl.annotation.*;
import overrungl.internal.RuntimeHelper;
import overrungl.util.*;

public sealed class GL31 extends GL30 permits GL32 {
    public static final int GL_SAMPLER_2D_RECT = 0x8B63;
    public static final int GL_SAMPLER_2D_RECT_SHADOW = 0x8B64;
    public static final int GL_SAMPLER_BUFFER = 0x8DC2;
    public static final int GL_INT_SAMPLER_2D_RECT = 0x8DCD;
    public static final int GL_INT_SAMPLER_BUFFER = 0x8DD0;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT = 0x8DD5;
    public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER = 0x8DD8;
    public static final int GL_TEXTURE_BUFFER = 0x8C2A;
    public static final int GL_MAX_TEXTURE_BUFFER_SIZE = 0x8C2B;
    public static final int GL_TEXTURE_BINDING_BUFFER = 0x8C2C;
    public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING = 0x8C2D;
    public static final int GL_TEXTURE_RECTANGLE = 0x84F5;
    public static final int GL_TEXTURE_BINDING_RECTANGLE = 0x84F6;
    public static final int GL_PROXY_TEXTURE_RECTANGLE = 0x84F7;
    public static final int GL_MAX_RECTANGLE_TEXTURE_SIZE = 0x84F8;
    public static final int GL_R8_SNORM = 0x8F94;
    public static final int GL_RG8_SNORM = 0x8F95;
    public static final int GL_RGB8_SNORM = 0x8F96;
    public static final int GL_RGBA8_SNORM = 0x8F97;
    public static final int GL_R16_SNORM = 0x8F98;
    public static final int GL_RG16_SNORM = 0x8F99;
    public static final int GL_RGB16_SNORM = 0x8F9A;
    public static final int GL_RGBA16_SNORM = 0x8F9B;
    public static final int GL_SIGNED_NORMALIZED = 0x8F9C;
    public static final int GL_PRIMITIVE_RESTART = 0x8F9D;
    public static final int GL_PRIMITIVE_RESTART_INDEX = 0x8F9E;
    public static final int GL_COPY_READ_BUFFER = 0x8F36;
    public static final int GL_COPY_WRITE_BUFFER = 0x8F37;
    public static final int GL_UNIFORM_BUFFER = 0x8A11;
    public static final int GL_UNIFORM_BUFFER_BINDING = 0x8A28;
    public static final int GL_UNIFORM_BUFFER_START = 0x8A29;
    public static final int GL_UNIFORM_BUFFER_SIZE = 0x8A2A;
    public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS = 0x8A2B;
    public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 0x8A2C;
    public static final int GL_MAX_FRAGMENT_UNIFORM_BLOCKS = 0x8A2D;
    public static final int GL_MAX_COMBINED_UNIFORM_BLOCKS = 0x8A2E;
    public static final int GL_MAX_UNIFORM_BUFFER_BINDINGS = 0x8A2F;
    public static final int GL_MAX_UNIFORM_BLOCK_SIZE = 0x8A30;
    public static final int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS = 0x8A31;
    public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 0x8A32;
    public static final int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 0x8A33;
    public static final int GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT = 0x8A34;
    public static final int GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = 0x8A35;
    public static final int GL_ACTIVE_UNIFORM_BLOCKS = 0x8A36;
    public static final int GL_UNIFORM_TYPE = 0x8A37;
    public static final int GL_UNIFORM_SIZE = 0x8A38;
    public static final int GL_UNIFORM_NAME_LENGTH = 0x8A39;
    public static final int GL_UNIFORM_BLOCK_INDEX = 0x8A3A;
    public static final int GL_UNIFORM_OFFSET = 0x8A3B;
    public static final int GL_UNIFORM_ARRAY_STRIDE = 0x8A3C;
    public static final int GL_UNIFORM_MATRIX_STRIDE = 0x8A3D;
    public static final int GL_UNIFORM_IS_ROW_MAJOR = 0x8A3E;
    public static final int GL_UNIFORM_BLOCK_BINDING = 0x8A3F;
    public static final int GL_UNIFORM_BLOCK_DATA_SIZE = 0x8A40;
    public static final int GL_UNIFORM_BLOCK_NAME_LENGTH = 0x8A41;
    public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS = 0x8A42;
    public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES = 0x8A43;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER = 0x8A44;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER = 0x8A45;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER = 0x8A46;
    public static final int GL_INVALID_INDEX = 0xFFFFFFFF;
    public static final MethodHandle MH_glDrawArraysInstanced = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glDrawArraysInstanced;
    public static final MethodHandle MH_glDrawElementsInstanced = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glDrawElementsInstanced;
    public static final MethodHandle MH_glTexBuffer = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glTexBuffer;
    public static final MethodHandle MH_glPrimitiveRestartIndex = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glPrimitiveRestartIndex;
    public static final MethodHandle MH_glCopyBufferSubData = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glCopyBufferSubData;
    public static final MethodHandle MH_glGetUniformIndices = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetUniformIndices;
    public static final MethodHandle MH_glGetActiveUniformsiv = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetActiveUniformsiv;
    public static final MethodHandle MH_glGetActiveUniformName = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetActiveUniformName;
    public static final MethodHandle MH_glGetUniformBlockIndex = RuntimeHelper.downcall(FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetUniformBlockIndex;
    public static final MethodHandle MH_glGetActiveUniformBlockiv = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetActiveUniformBlockiv;
    public static final MethodHandle MH_glGetActiveUniformBlockName = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetActiveUniformBlockName;
    public static final MethodHandle MH_glUniformBlockBinding = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glUniformBlockBinding;

    public GL31(GLLoadFunc func) {
        super(func);
        PFN_glDrawArraysInstanced = func.invoke("glDrawArraysInstanced", "glDrawArraysInstancedANGLE", "glDrawArraysInstancedARB", "glDrawArraysInstancedEXT", "glDrawArraysInstancedNV");
        PFN_glDrawElementsInstanced = func.invoke("glDrawElementsInstanced", "glDrawElementsInstancedANGLE", "glDrawElementsInstancedARB", "glDrawElementsInstancedEXT", "glDrawElementsInstancedNV");
        PFN_glTexBuffer = func.invoke("glTexBuffer", "glTexBufferARB", "glTexBufferEXT", "glTexBufferOES");
        PFN_glPrimitiveRestartIndex = func.invoke("glPrimitiveRestartIndex");
        PFN_glCopyBufferSubData = func.invoke("glCopyBufferSubData", "glCopyBufferSubDataNV");
        PFN_glGetUniformIndices = func.invoke("glGetUniformIndices");
        PFN_glGetActiveUniformsiv = func.invoke("glGetActiveUniformsiv");
        PFN_glGetActiveUniformName = func.invoke("glGetActiveUniformName");
        PFN_glGetUniformBlockIndex = func.invoke("glGetUniformBlockIndex");
        PFN_glGetActiveUniformBlockiv = func.invoke("glGetActiveUniformBlockiv");
        PFN_glGetActiveUniformBlockName = func.invoke("glGetActiveUniformBlockName");
        PFN_glUniformBlockBinding = func.invoke("glUniformBlockBinding");
    }

    public void DrawArraysInstanced(@CType("GLenum") int mode, @CType("GLint") int first, @CType("GLsizei") int count, @CType("GLsizei") int instancecount) {
        if (!Unmarshal.isNullPointer(PFN_glDrawArraysInstanced)) { try {
            MH_glDrawArraysInstanced.invokeExact(PFN_glDrawArraysInstanced, mode, first, count, instancecount);
        } catch (Throwable e) { throw new RuntimeException("error in glDrawArraysInstanced", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDrawArraysInstanced"); }
    }

    public void DrawElementsInstanced(@CType("GLenum") int mode, @CType("GLsizei") int count, @CType("GLenum") int type, @CType("const void *") java.lang.foreign.MemorySegment indices, @CType("GLsizei") int instancecount) {
        if (!Unmarshal.isNullPointer(PFN_glDrawElementsInstanced)) { try {
            MH_glDrawElementsInstanced.invokeExact(PFN_glDrawElementsInstanced, mode, count, type, indices, instancecount);
        } catch (Throwable e) { throw new RuntimeException("error in glDrawElementsInstanced", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDrawElementsInstanced"); }
    }

    public void TexBuffer(@CType("GLenum") int target, @CType("GLenum") int internalformat, @CType("GLuint") int buffer) {
        if (!Unmarshal.isNullPointer(PFN_glTexBuffer)) { try {
            MH_glTexBuffer.invokeExact(PFN_glTexBuffer, target, internalformat, buffer);
        } catch (Throwable e) { throw new RuntimeException("error in glTexBuffer", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glTexBuffer"); }
    }

    public void PrimitiveRestartIndex(@CType("GLuint") int index) {
        if (!Unmarshal.isNullPointer(PFN_glPrimitiveRestartIndex)) { try {
            MH_glPrimitiveRestartIndex.invokeExact(PFN_glPrimitiveRestartIndex, index);
        } catch (Throwable e) { throw new RuntimeException("error in glPrimitiveRestartIndex", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glPrimitiveRestartIndex"); }
    }

    public void CopyBufferSubData(@CType("GLenum") int readTarget, @CType("GLenum") int writeTarget, @CType("GLintptr") long readOffset, @CType("GLintptr") long writeOffset, @CType("GLsizeiptr") long size) {
        if (!Unmarshal.isNullPointer(PFN_glCopyBufferSubData)) { try {
            MH_glCopyBufferSubData.invokeExact(PFN_glCopyBufferSubData, readTarget, writeTarget, readOffset, writeOffset, size);
        } catch (Throwable e) { throw new RuntimeException("error in glCopyBufferSubData", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glCopyBufferSubData"); }
    }

    public void GetUniformIndices(@CType("GLuint") int program, @CType("GLsizei") int uniformCount, @CType("const GLchar *const*") java.lang.foreign.MemorySegment uniformNames, @CType("GLuint *") java.lang.foreign.MemorySegment uniformIndices) {
        if (!Unmarshal.isNullPointer(PFN_glGetUniformIndices)) { try {
            MH_glGetUniformIndices.invokeExact(PFN_glGetUniformIndices, program, uniformCount, uniformNames, uniformIndices);
        } catch (Throwable e) { throw new RuntimeException("error in glGetUniformIndices", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetUniformIndices"); }
    }

    public void GetActiveUniformsiv(@CType("GLuint") int program, @CType("GLsizei") int uniformCount, @CType("const GLuint *") java.lang.foreign.MemorySegment uniformIndices, @CType("GLenum") int pname, @CType("GLint *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetActiveUniformsiv)) { try {
            MH_glGetActiveUniformsiv.invokeExact(PFN_glGetActiveUniformsiv, program, uniformCount, uniformIndices, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetActiveUniformsiv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetActiveUniformsiv"); }
    }

    public void GetActiveUniformName(@CType("GLuint") int program, @CType("GLuint") int uniformIndex, @CType("GLsizei") int bufSize, @CType("GLsizei *") java.lang.foreign.MemorySegment length, @CType("GLchar *") java.lang.foreign.MemorySegment uniformName) {
        if (!Unmarshal.isNullPointer(PFN_glGetActiveUniformName)) { try {
            MH_glGetActiveUniformName.invokeExact(PFN_glGetActiveUniformName, program, uniformIndex, bufSize, length, uniformName);
        } catch (Throwable e) { throw new RuntimeException("error in glGetActiveUniformName", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetActiveUniformName"); }
    }

    public @CType("GLuint") int GetUniformBlockIndex(@CType("GLuint") int program, @CType("const GLchar *") java.lang.foreign.MemorySegment uniformBlockName) {
        if (!Unmarshal.isNullPointer(PFN_glGetUniformBlockIndex)) { try {
            return (int) MH_glGetUniformBlockIndex.invokeExact(PFN_glGetUniformBlockIndex, program, uniformBlockName);
        } catch (Throwable e) { throw new RuntimeException("error in glGetUniformBlockIndex", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetUniformBlockIndex"); }
    }

    public void GetActiveUniformBlockiv(@CType("GLuint") int program, @CType("GLuint") int uniformBlockIndex, @CType("GLenum") int pname, @CType("GLint *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetActiveUniformBlockiv)) { try {
            MH_glGetActiveUniformBlockiv.invokeExact(PFN_glGetActiveUniformBlockiv, program, uniformBlockIndex, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetActiveUniformBlockiv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetActiveUniformBlockiv"); }
    }

    public void GetActiveUniformBlockName(@CType("GLuint") int program, @CType("GLuint") int uniformBlockIndex, @CType("GLsizei") int bufSize, @CType("GLsizei *") java.lang.foreign.MemorySegment length, @CType("GLchar *") java.lang.foreign.MemorySegment uniformBlockName) {
        if (!Unmarshal.isNullPointer(PFN_glGetActiveUniformBlockName)) { try {
            MH_glGetActiveUniformBlockName.invokeExact(PFN_glGetActiveUniformBlockName, program, uniformBlockIndex, bufSize, length, uniformBlockName);
        } catch (Throwable e) { throw new RuntimeException("error in glGetActiveUniformBlockName", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetActiveUniformBlockName"); }
    }

    public void UniformBlockBinding(@CType("GLuint") int program, @CType("GLuint") int uniformBlockIndex, @CType("GLuint") int uniformBlockBinding) {
        if (!Unmarshal.isNullPointer(PFN_glUniformBlockBinding)) { try {
            MH_glUniformBlockBinding.invokeExact(PFN_glUniformBlockBinding, program, uniformBlockIndex, uniformBlockBinding);
        } catch (Throwable e) { throw new RuntimeException("error in glUniformBlockBinding", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUniformBlockBinding"); }
    }

}
