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

public final class GLARBInvalidateSubdata {
    public static final MethodHandle MH_glInvalidateTexSubImage = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glInvalidateTexSubImage;
    public static final MethodHandle MH_glInvalidateTexImage = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glInvalidateTexImage;
    public static final MethodHandle MH_glInvalidateBufferSubData = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glInvalidateBufferSubData;
    public static final MethodHandle MH_glInvalidateBufferData = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glInvalidateBufferData;
    public static final MethodHandle MH_glInvalidateFramebuffer = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glInvalidateFramebuffer;
    public static final MethodHandle MH_glInvalidateSubFramebuffer = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glInvalidateSubFramebuffer;

    public GLARBInvalidateSubdata(overrungl.opengl.GLLoadFunc func) {
        PFN_glInvalidateTexSubImage = func.invoke("glInvalidateTexSubImage");
        PFN_glInvalidateTexImage = func.invoke("glInvalidateTexImage");
        PFN_glInvalidateBufferSubData = func.invoke("glInvalidateBufferSubData");
        PFN_glInvalidateBufferData = func.invoke("glInvalidateBufferData");
        PFN_glInvalidateFramebuffer = func.invoke("glInvalidateFramebuffer");
        PFN_glInvalidateSubFramebuffer = func.invoke("glInvalidateSubFramebuffer");
    }

    public void InvalidateTexSubImage(@CType("GLuint") int texture, @CType("GLint") int level, @CType("GLint") int xoffset, @CType("GLint") int yoffset, @CType("GLint") int zoffset, @CType("GLsizei") int width, @CType("GLsizei") int height, @CType("GLsizei") int depth) {
        if (!Unmarshal.isNullPointer(PFN_glInvalidateTexSubImage)) { try {
            MH_glInvalidateTexSubImage.invokeExact(PFN_glInvalidateTexSubImage, texture, level, xoffset, yoffset, zoffset, width, height, depth);
        } catch (Throwable e) { throw new RuntimeException("error in glInvalidateTexSubImage", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glInvalidateTexSubImage"); }
    }

    public void InvalidateTexImage(@CType("GLuint") int texture, @CType("GLint") int level) {
        if (!Unmarshal.isNullPointer(PFN_glInvalidateTexImage)) { try {
            MH_glInvalidateTexImage.invokeExact(PFN_glInvalidateTexImage, texture, level);
        } catch (Throwable e) { throw new RuntimeException("error in glInvalidateTexImage", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glInvalidateTexImage"); }
    }

    public void InvalidateBufferSubData(@CType("GLuint") int buffer, @CType("GLintptr") long offset, @CType("GLsizeiptr") long length) {
        if (!Unmarshal.isNullPointer(PFN_glInvalidateBufferSubData)) { try {
            MH_glInvalidateBufferSubData.invokeExact(PFN_glInvalidateBufferSubData, buffer, offset, length);
        } catch (Throwable e) { throw new RuntimeException("error in glInvalidateBufferSubData", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glInvalidateBufferSubData"); }
    }

    public void InvalidateBufferData(@CType("GLuint") int buffer) {
        if (!Unmarshal.isNullPointer(PFN_glInvalidateBufferData)) { try {
            MH_glInvalidateBufferData.invokeExact(PFN_glInvalidateBufferData, buffer);
        } catch (Throwable e) { throw new RuntimeException("error in glInvalidateBufferData", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glInvalidateBufferData"); }
    }

    public void InvalidateFramebuffer(@CType("GLenum") int target, @CType("GLsizei") int numAttachments, @CType("const GLenum *") java.lang.foreign.MemorySegment attachments) {
        if (!Unmarshal.isNullPointer(PFN_glInvalidateFramebuffer)) { try {
            MH_glInvalidateFramebuffer.invokeExact(PFN_glInvalidateFramebuffer, target, numAttachments, attachments);
        } catch (Throwable e) { throw new RuntimeException("error in glInvalidateFramebuffer", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glInvalidateFramebuffer"); }
    }

    public void InvalidateSubFramebuffer(@CType("GLenum") int target, @CType("GLsizei") int numAttachments, @CType("const GLenum *") java.lang.foreign.MemorySegment attachments, @CType("GLint") int x, @CType("GLint") int y, @CType("GLsizei") int width, @CType("GLsizei") int height) {
        if (!Unmarshal.isNullPointer(PFN_glInvalidateSubFramebuffer)) { try {
            MH_glInvalidateSubFramebuffer.invokeExact(PFN_glInvalidateSubFramebuffer, target, numAttachments, attachments, x, y, width, height);
        } catch (Throwable e) { throw new RuntimeException("error in glInvalidateSubFramebuffer", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glInvalidateSubFramebuffer"); }
    }

}
