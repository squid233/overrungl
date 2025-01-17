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

public final class GLNVMemoryAttachment {
    public static final int GL_ATTACHED_MEMORY_OBJECT_NV = 0x95A4;
    public static final int GL_ATTACHED_MEMORY_OFFSET_NV = 0x95A5;
    public static final int GL_MEMORY_ATTACHABLE_ALIGNMENT_NV = 0x95A6;
    public static final int GL_MEMORY_ATTACHABLE_SIZE_NV = 0x95A7;
    public static final int GL_MEMORY_ATTACHABLE_NV = 0x95A8;
    public static final int GL_DETACHED_MEMORY_INCARNATION_NV = 0x95A9;
    public static final int GL_DETACHED_TEXTURES_NV = 0x95AA;
    public static final int GL_DETACHED_BUFFERS_NV = 0x95AB;
    public static final int GL_MAX_DETACHED_TEXTURES_NV = 0x95AC;
    public static final int GL_MAX_DETACHED_BUFFERS_NV = 0x95AD;
    public static final MethodHandle MH_glGetMemoryObjectDetachedResourcesuivNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetMemoryObjectDetachedResourcesuivNV;
    public static final MethodHandle MH_glResetMemoryObjectParameterNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glResetMemoryObjectParameterNV;
    public static final MethodHandle MH_glTexAttachMemoryNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glTexAttachMemoryNV;
    public static final MethodHandle MH_glBufferAttachMemoryNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glBufferAttachMemoryNV;
    public static final MethodHandle MH_glTextureAttachMemoryNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glTextureAttachMemoryNV;
    public static final MethodHandle MH_glNamedBufferAttachMemoryNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glNamedBufferAttachMemoryNV;

    public GLNVMemoryAttachment(overrungl.opengl.GLLoadFunc func) {
        PFN_glGetMemoryObjectDetachedResourcesuivNV = func.invoke("glGetMemoryObjectDetachedResourcesuivNV");
        PFN_glResetMemoryObjectParameterNV = func.invoke("glResetMemoryObjectParameterNV");
        PFN_glTexAttachMemoryNV = func.invoke("glTexAttachMemoryNV");
        PFN_glBufferAttachMemoryNV = func.invoke("glBufferAttachMemoryNV");PFN_glTextureAttachMemoryNV = func.invoke("glTextureAttachMemoryNV");
        PFN_glNamedBufferAttachMemoryNV = func.invoke("glNamedBufferAttachMemoryNV");
    }

    public void GetMemoryObjectDetachedResourcesuivNV(@CType("GLuint") int memory, @CType("GLenum") int pname, @CType("GLint") int first, @CType("GLsizei") int count, @CType("GLuint *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetMemoryObjectDetachedResourcesuivNV)) { try {
            MH_glGetMemoryObjectDetachedResourcesuivNV.invokeExact(PFN_glGetMemoryObjectDetachedResourcesuivNV, memory, pname, first, count, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetMemoryObjectDetachedResourcesuivNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetMemoryObjectDetachedResourcesuivNV"); }
    }

    public void ResetMemoryObjectParameterNV(@CType("GLuint") int memory, @CType("GLenum") int pname) {
        if (!Unmarshal.isNullPointer(PFN_glResetMemoryObjectParameterNV)) { try {
            MH_glResetMemoryObjectParameterNV.invokeExact(PFN_glResetMemoryObjectParameterNV, memory, pname);
        } catch (Throwable e) { throw new RuntimeException("error in glResetMemoryObjectParameterNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glResetMemoryObjectParameterNV"); }
    }

    public void TexAttachMemoryNV(@CType("GLenum") int target, @CType("GLuint") int memory, @CType("GLuint64") long offset) {
        if (!Unmarshal.isNullPointer(PFN_glTexAttachMemoryNV)) { try {
            MH_glTexAttachMemoryNV.invokeExact(PFN_glTexAttachMemoryNV, target, memory, offset);
        } catch (Throwable e) { throw new RuntimeException("error in glTexAttachMemoryNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glTexAttachMemoryNV"); }
    }

    public void BufferAttachMemoryNV(@CType("GLenum") int target, @CType("GLuint") int memory, @CType("GLuint64") long offset) {
        if (!Unmarshal.isNullPointer(PFN_glBufferAttachMemoryNV)) { try {
            MH_glBufferAttachMemoryNV.invokeExact(PFN_glBufferAttachMemoryNV, target, memory, offset);
        } catch (Throwable e) { throw new RuntimeException("error in glBufferAttachMemoryNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glBufferAttachMemoryNV"); }
    }

    public void TextureAttachMemoryNV(@CType("GLuint") int texture, @CType("GLuint") int memory, @CType("GLuint64") long offset) {
        if (!Unmarshal.isNullPointer(PFN_glTextureAttachMemoryNV)) { try {
            MH_glTextureAttachMemoryNV.invokeExact(PFN_glTextureAttachMemoryNV, texture, memory, offset);
        } catch (Throwable e) { throw new RuntimeException("error in glTextureAttachMemoryNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glTextureAttachMemoryNV"); }
    }

    public void NamedBufferAttachMemoryNV(@CType("GLuint") int buffer, @CType("GLuint") int memory, @CType("GLuint64") long offset) {
        if (!Unmarshal.isNullPointer(PFN_glNamedBufferAttachMemoryNV)) { try {
            MH_glNamedBufferAttachMemoryNV.invokeExact(PFN_glNamedBufferAttachMemoryNV, buffer, memory, offset);
        } catch (Throwable e) { throw new RuntimeException("error in glNamedBufferAttachMemoryNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glNamedBufferAttachMemoryNV"); }
    }

}
