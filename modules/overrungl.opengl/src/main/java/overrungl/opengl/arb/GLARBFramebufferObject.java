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

public final class GLARBFramebufferObject {
    public static final int GL_INVALID_FRAMEBUFFER_OPERATION = 0x0506;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING = 0x8210;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE = 0x8211;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE = 0x8212;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE = 0x8213;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE = 0x8214;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE = 0x8215;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE = 0x8216;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE = 0x8217;
    public static final int GL_FRAMEBUFFER_DEFAULT = 0x8218;
    public static final int GL_FRAMEBUFFER_UNDEFINED = 0x8219;
    public static final int GL_DEPTH_STENCIL_ATTACHMENT = 0x821A;
    public static final int GL_MAX_RENDERBUFFER_SIZE = 0x84E8;
    public static final int GL_DEPTH_STENCIL = 0x84F9;
    public static final int GL_UNSIGNED_INT_24_8 = 0x84FA;
    public static final int GL_DEPTH24_STENCIL8 = 0x88F0;
    public static final int GL_TEXTURE_STENCIL_SIZE = 0x88F1;
    public static final int GL_UNSIGNED_NORMALIZED = 0x8C17;
    public static final int GL_FRAMEBUFFER_BINDING = 0x8CA6;
    public static final int GL_DRAW_FRAMEBUFFER_BINDING = 0x8CA6;
    public static final int GL_RENDERBUFFER_BINDING = 0x8CA7;
    public static final int GL_READ_FRAMEBUFFER = 0x8CA8;
    public static final int GL_DRAW_FRAMEBUFFER = 0x8CA9;
    public static final int GL_READ_FRAMEBUFFER_BINDING = 0x8CAA;
    public static final int GL_RENDERBUFFER_SAMPLES = 0x8CAB;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 0x8CD0;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 0x8CD1;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 0x8CD2;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 0x8CD3;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER = 0x8CD4;
    public static final int GL_FRAMEBUFFER_COMPLETE = 0x8CD5;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 0x8CD6;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 0x8CD7;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER = 0x8CDB;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER = 0x8CDC;
    public static final int GL_FRAMEBUFFER_UNSUPPORTED = 0x8CDD;
    public static final int GL_MAX_COLOR_ATTACHMENTS = 0x8CDF;
    public static final int GL_COLOR_ATTACHMENT0 = 0x8CE0;
    public static final int GL_COLOR_ATTACHMENT1 = 0x8CE1;
    public static final int GL_COLOR_ATTACHMENT2 = 0x8CE2;
    public static final int GL_COLOR_ATTACHMENT3 = 0x8CE3;
    public static final int GL_COLOR_ATTACHMENT4 = 0x8CE4;
    public static final int GL_COLOR_ATTACHMENT5 = 0x8CE5;
    public static final int GL_COLOR_ATTACHMENT6 = 0x8CE6;
    public static final int GL_COLOR_ATTACHMENT7 = 0x8CE7;
    public static final int GL_COLOR_ATTACHMENT8 = 0x8CE8;
    public static final int GL_COLOR_ATTACHMENT9 = 0x8CE9;
    public static final int GL_COLOR_ATTACHMENT10 = 0x8CEA;
    public static final int GL_COLOR_ATTACHMENT11 = 0x8CEB;
    public static final int GL_COLOR_ATTACHMENT12 = 0x8CEC;
    public static final int GL_COLOR_ATTACHMENT13 = 0x8CED;
    public static final int GL_COLOR_ATTACHMENT14 = 0x8CEE;
    public static final int GL_COLOR_ATTACHMENT15 = 0x8CEF;
    public static final int GL_DEPTH_ATTACHMENT = 0x8D00;
    public static final int GL_STENCIL_ATTACHMENT = 0x8D20;
    public static final int GL_FRAMEBUFFER = 0x8D40;
    public static final int GL_RENDERBUFFER = 0x8D41;
    public static final int GL_RENDERBUFFER_WIDTH = 0x8D42;
    public static final int GL_RENDERBUFFER_HEIGHT = 0x8D43;
    public static final int GL_RENDERBUFFER_INTERNAL_FORMAT = 0x8D44;
    public static final int GL_STENCIL_INDEX1 = 0x8D46;
    public static final int GL_STENCIL_INDEX4 = 0x8D47;
    public static final int GL_STENCIL_INDEX8 = 0x8D48;
    public static final int GL_STENCIL_INDEX16 = 0x8D49;
    public static final int GL_RENDERBUFFER_RED_SIZE = 0x8D50;
    public static final int GL_RENDERBUFFER_GREEN_SIZE = 0x8D51;
    public static final int GL_RENDERBUFFER_BLUE_SIZE = 0x8D52;
    public static final int GL_RENDERBUFFER_ALPHA_SIZE = 0x8D53;
    public static final int GL_RENDERBUFFER_DEPTH_SIZE = 0x8D54;
    public static final int GL_RENDERBUFFER_STENCIL_SIZE = 0x8D55;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE = 0x8D56;
    public static final int GL_MAX_SAMPLES = 0x8D57;
    public static final MethodHandle MH_glIsRenderbuffer = RuntimeHelper.downcall(FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glIsRenderbuffer;
    public static final MethodHandle MH_glBindRenderbuffer = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glBindRenderbuffer;
    public static final MethodHandle MH_glDeleteRenderbuffers = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glDeleteRenderbuffers;
    public static final MethodHandle MH_glGenRenderbuffers = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGenRenderbuffers;
    public static final MethodHandle MH_glRenderbufferStorage = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glRenderbufferStorage;
    public static final MethodHandle MH_glGetRenderbufferParameteriv = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetRenderbufferParameteriv;
    public static final MethodHandle MH_glIsFramebuffer = RuntimeHelper.downcall(FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glIsFramebuffer;
    public static final MethodHandle MH_glBindFramebuffer = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glBindFramebuffer;
    public static final MethodHandle MH_glDeleteFramebuffers = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glDeleteFramebuffers;
    public static final MethodHandle MH_glGenFramebuffers = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGenFramebuffers;
    public static final MethodHandle MH_glCheckFramebufferStatus = RuntimeHelper.downcall(FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glCheckFramebufferStatus;
    public static final MethodHandle MH_glFramebufferTexture1D = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glFramebufferTexture1D;
    public static final MethodHandle MH_glFramebufferTexture2D = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glFramebufferTexture2D;
    public static final MethodHandle MH_glFramebufferTexture3D = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glFramebufferTexture3D;
    public static final MethodHandle MH_glFramebufferRenderbuffer = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glFramebufferRenderbuffer;
    public static final MethodHandle MH_glGetFramebufferAttachmentParameteriv = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetFramebufferAttachmentParameteriv;
    public static final MethodHandle MH_glGenerateMipmap = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glGenerateMipmap;
    public static final MethodHandle MH_glBlitFramebuffer = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glBlitFramebuffer;
    public static final MethodHandle MH_glRenderbufferStorageMultisample = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glRenderbufferStorageMultisample;
    public static final MethodHandle MH_glFramebufferTextureLayer = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glFramebufferTextureLayer;
    public static final int GL_INDEX = 0x8222;

    public GLARBFramebufferObject(overrungl.opengl.GLLoadFunc func) {
        PFN_glIsRenderbuffer = func.invoke("glIsRenderbuffer");
        PFN_glBindRenderbuffer = func.invoke("glBindRenderbuffer");
        PFN_glDeleteRenderbuffers = func.invoke("glDeleteRenderbuffers");
        PFN_glGenRenderbuffers = func.invoke("glGenRenderbuffers");
        PFN_glRenderbufferStorage = func.invoke("glRenderbufferStorage");
        PFN_glGetRenderbufferParameteriv = func.invoke("glGetRenderbufferParameteriv");
        PFN_glIsFramebuffer = func.invoke("glIsFramebuffer");
        PFN_glBindFramebuffer = func.invoke("glBindFramebuffer");
        PFN_glDeleteFramebuffers = func.invoke("glDeleteFramebuffers");
        PFN_glGenFramebuffers = func.invoke("glGenFramebuffers");
        PFN_glCheckFramebufferStatus = func.invoke("glCheckFramebufferStatus");
        PFN_glFramebufferTexture1D = func.invoke("glFramebufferTexture1D");
        PFN_glFramebufferTexture2D = func.invoke("glFramebufferTexture2D");
        PFN_glFramebufferTexture3D = func.invoke("glFramebufferTexture3D");
        PFN_glFramebufferRenderbuffer = func.invoke("glFramebufferRenderbuffer");
        PFN_glGetFramebufferAttachmentParameteriv = func.invoke("glGetFramebufferAttachmentParameteriv");
        PFN_glGenerateMipmap = func.invoke("glGenerateMipmap");
        PFN_glBlitFramebuffer = func.invoke("glBlitFramebuffer");
        PFN_glRenderbufferStorageMultisample = func.invoke("glRenderbufferStorageMultisample");
        PFN_glFramebufferTextureLayer = func.invoke("glFramebufferTextureLayer");
    }

    public @CType("GLboolean") boolean IsRenderbuffer(@CType("GLuint") int renderbuffer) {
        if (!Unmarshal.isNullPointer(PFN_glIsRenderbuffer)) { try {
            return (boolean) MH_glIsRenderbuffer.invokeExact(PFN_glIsRenderbuffer, renderbuffer);
        } catch (Throwable e) { throw new RuntimeException("error in glIsRenderbuffer", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glIsRenderbuffer"); }
    }

    public void BindRenderbuffer(@CType("GLenum") int target, @CType("GLuint") int renderbuffer) {
        if (!Unmarshal.isNullPointer(PFN_glBindRenderbuffer)) { try {
            MH_glBindRenderbuffer.invokeExact(PFN_glBindRenderbuffer, target, renderbuffer);
        } catch (Throwable e) { throw new RuntimeException("error in glBindRenderbuffer", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glBindRenderbuffer"); }
    }

    public void DeleteRenderbuffers(@CType("GLsizei") int n, @CType("const GLuint *") java.lang.foreign.MemorySegment renderbuffers) {
        if (!Unmarshal.isNullPointer(PFN_glDeleteRenderbuffers)) { try {
            MH_glDeleteRenderbuffers.invokeExact(PFN_glDeleteRenderbuffers, n, renderbuffers);
        } catch (Throwable e) { throw new RuntimeException("error in glDeleteRenderbuffers", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDeleteRenderbuffers"); }
    }

    public void GenRenderbuffers(@CType("GLsizei") int n, @CType("GLuint *") java.lang.foreign.MemorySegment renderbuffers) {
        if (!Unmarshal.isNullPointer(PFN_glGenRenderbuffers)) { try {
            MH_glGenRenderbuffers.invokeExact(PFN_glGenRenderbuffers, n, renderbuffers);
        } catch (Throwable e) { throw new RuntimeException("error in glGenRenderbuffers", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGenRenderbuffers"); }
    }

    public void RenderbufferStorage(@CType("GLenum") int target, @CType("GLenum") int internalformat, @CType("GLsizei") int width, @CType("GLsizei") int height) {
        if (!Unmarshal.isNullPointer(PFN_glRenderbufferStorage)) { try {
            MH_glRenderbufferStorage.invokeExact(PFN_glRenderbufferStorage, target, internalformat, width, height);
        } catch (Throwable e) { throw new RuntimeException("error in glRenderbufferStorage", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glRenderbufferStorage"); }
    }

    public void GetRenderbufferParameteriv(@CType("GLenum") int target, @CType("GLenum") int pname, @CType("GLint *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetRenderbufferParameteriv)) { try {
            MH_glGetRenderbufferParameteriv.invokeExact(PFN_glGetRenderbufferParameteriv, target, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetRenderbufferParameteriv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetRenderbufferParameteriv"); }
    }

    public @CType("GLboolean") boolean IsFramebuffer(@CType("GLuint") int framebuffer) {
        if (!Unmarshal.isNullPointer(PFN_glIsFramebuffer)) { try {
            return (boolean) MH_glIsFramebuffer.invokeExact(PFN_glIsFramebuffer, framebuffer);
        } catch (Throwable e) { throw new RuntimeException("error in glIsFramebuffer", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glIsFramebuffer"); }
    }

    public void BindFramebuffer(@CType("GLenum") int target, @CType("GLuint") int framebuffer) {
        if (!Unmarshal.isNullPointer(PFN_glBindFramebuffer)) { try {
            MH_glBindFramebuffer.invokeExact(PFN_glBindFramebuffer, target, framebuffer);
        } catch (Throwable e) { throw new RuntimeException("error in glBindFramebuffer", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glBindFramebuffer"); }
    }

    public void DeleteFramebuffers(@CType("GLsizei") int n, @CType("const GLuint *") java.lang.foreign.MemorySegment framebuffers) {
        if (!Unmarshal.isNullPointer(PFN_glDeleteFramebuffers)) { try {
            MH_glDeleteFramebuffers.invokeExact(PFN_glDeleteFramebuffers, n, framebuffers);
        } catch (Throwable e) { throw new RuntimeException("error in glDeleteFramebuffers", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDeleteFramebuffers"); }
    }

    public void GenFramebuffers(@CType("GLsizei") int n, @CType("GLuint *") java.lang.foreign.MemorySegment framebuffers) {
        if (!Unmarshal.isNullPointer(PFN_glGenFramebuffers)) { try {
            MH_glGenFramebuffers.invokeExact(PFN_glGenFramebuffers, n, framebuffers);
        } catch (Throwable e) { throw new RuntimeException("error in glGenFramebuffers", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGenFramebuffers"); }
    }

    public @CType("GLenum") int CheckFramebufferStatus(@CType("GLenum") int target) {
        if (!Unmarshal.isNullPointer(PFN_glCheckFramebufferStatus)) { try {
            return (int) MH_glCheckFramebufferStatus.invokeExact(PFN_glCheckFramebufferStatus, target);
        } catch (Throwable e) { throw new RuntimeException("error in glCheckFramebufferStatus", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glCheckFramebufferStatus"); }
    }

    public void FramebufferTexture1D(@CType("GLenum") int target, @CType("GLenum") int attachment, @CType("GLenum") int textarget, @CType("GLuint") int texture, @CType("GLint") int level) {
        if (!Unmarshal.isNullPointer(PFN_glFramebufferTexture1D)) { try {
            MH_glFramebufferTexture1D.invokeExact(PFN_glFramebufferTexture1D, target, attachment, textarget, texture, level);
        } catch (Throwable e) { throw new RuntimeException("error in glFramebufferTexture1D", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glFramebufferTexture1D"); }
    }

    public void FramebufferTexture2D(@CType("GLenum") int target, @CType("GLenum") int attachment, @CType("GLenum") int textarget, @CType("GLuint") int texture, @CType("GLint") int level) {
        if (!Unmarshal.isNullPointer(PFN_glFramebufferTexture2D)) { try {
            MH_glFramebufferTexture2D.invokeExact(PFN_glFramebufferTexture2D, target, attachment, textarget, texture, level);
        } catch (Throwable e) { throw new RuntimeException("error in glFramebufferTexture2D", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glFramebufferTexture2D"); }
    }

    public void FramebufferTexture3D(@CType("GLenum") int target, @CType("GLenum") int attachment, @CType("GLenum") int textarget, @CType("GLuint") int texture, @CType("GLint") int level, @CType("GLint") int zoffset) {
        if (!Unmarshal.isNullPointer(PFN_glFramebufferTexture3D)) { try {
            MH_glFramebufferTexture3D.invokeExact(PFN_glFramebufferTexture3D, target, attachment, textarget, texture, level, zoffset);
        } catch (Throwable e) { throw new RuntimeException("error in glFramebufferTexture3D", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glFramebufferTexture3D"); }
    }

    public void FramebufferRenderbuffer(@CType("GLenum") int target, @CType("GLenum") int attachment, @CType("GLenum") int renderbuffertarget, @CType("GLuint") int renderbuffer) {
        if (!Unmarshal.isNullPointer(PFN_glFramebufferRenderbuffer)) { try {
            MH_glFramebufferRenderbuffer.invokeExact(PFN_glFramebufferRenderbuffer, target, attachment, renderbuffertarget, renderbuffer);
        } catch (Throwable e) { throw new RuntimeException("error in glFramebufferRenderbuffer", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glFramebufferRenderbuffer"); }
    }

    public void GetFramebufferAttachmentParameteriv(@CType("GLenum") int target, @CType("GLenum") int attachment, @CType("GLenum") int pname, @CType("GLint *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetFramebufferAttachmentParameteriv)) { try {
            MH_glGetFramebufferAttachmentParameteriv.invokeExact(PFN_glGetFramebufferAttachmentParameteriv, target, attachment, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetFramebufferAttachmentParameteriv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetFramebufferAttachmentParameteriv"); }
    }

    public void GenerateMipmap(@CType("GLenum") int target) {
        if (!Unmarshal.isNullPointer(PFN_glGenerateMipmap)) { try {
            MH_glGenerateMipmap.invokeExact(PFN_glGenerateMipmap, target);
        } catch (Throwable e) { throw new RuntimeException("error in glGenerateMipmap", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGenerateMipmap"); }
    }

    public void BlitFramebuffer(@CType("GLint") int srcX0, @CType("GLint") int srcY0, @CType("GLint") int srcX1, @CType("GLint") int srcY1, @CType("GLint") int dstX0, @CType("GLint") int dstY0, @CType("GLint") int dstX1, @CType("GLint") int dstY1, @CType("GLbitfield") int mask, @CType("GLenum") int filter) {
        if (!Unmarshal.isNullPointer(PFN_glBlitFramebuffer)) { try {
            MH_glBlitFramebuffer.invokeExact(PFN_glBlitFramebuffer, srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
        } catch (Throwable e) { throw new RuntimeException("error in glBlitFramebuffer", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glBlitFramebuffer"); }
    }

    public void RenderbufferStorageMultisample(@CType("GLenum") int target, @CType("GLsizei") int samples, @CType("GLenum") int internalformat, @CType("GLsizei") int width, @CType("GLsizei") int height) {
        if (!Unmarshal.isNullPointer(PFN_glRenderbufferStorageMultisample)) { try {
            MH_glRenderbufferStorageMultisample.invokeExact(PFN_glRenderbufferStorageMultisample, target, samples, internalformat, width, height);
        } catch (Throwable e) { throw new RuntimeException("error in glRenderbufferStorageMultisample", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glRenderbufferStorageMultisample"); }
    }

    public void FramebufferTextureLayer(@CType("GLenum") int target, @CType("GLenum") int attachment, @CType("GLuint") int texture, @CType("GLint") int level, @CType("GLint") int layer) {
        if (!Unmarshal.isNullPointer(PFN_glFramebufferTextureLayer)) { try {
            MH_glFramebufferTextureLayer.invokeExact(PFN_glFramebufferTextureLayer, target, attachment, texture, level, layer);
        } catch (Throwable e) { throw new RuntimeException("error in glFramebufferTextureLayer", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glFramebufferTextureLayer"); }
    }

}
