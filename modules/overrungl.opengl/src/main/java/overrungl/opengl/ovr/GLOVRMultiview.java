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
package overrungl.opengl.ovr;

import java.lang.foreign.*;
import java.lang.invoke.*;
import overrungl.annotation.*;
import overrungl.internal.RuntimeHelper;
import overrungl.util.*;

public final class GLOVRMultiview {
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_NUM_VIEWS_OVR = 0x9630;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_BASE_VIEW_INDEX_OVR = 0x9632;
    public static final int GL_MAX_VIEWS_OVR = 0x9631;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_VIEW_TARGETS_OVR = 0x9633;
    public static final MethodHandle MH_glFramebufferTextureMultiviewOVR = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glFramebufferTextureMultiviewOVR;
    public static final MethodHandle MH_glNamedFramebufferTextureMultiviewOVR = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glNamedFramebufferTextureMultiviewOVR;

    public GLOVRMultiview(overrungl.opengl.GLLoadFunc func) {
        PFN_glFramebufferTextureMultiviewOVR = func.invoke("glFramebufferTextureMultiviewOVR");PFN_glNamedFramebufferTextureMultiviewOVR = func.invoke("glNamedFramebufferTextureMultiviewOVR");
    }

    public void FramebufferTextureMultiviewOVR(@CType("GLenum") int target, @CType("GLenum") int attachment, @CType("GLuint") int texture, @CType("GLint") int level, @CType("GLint") int baseViewIndex, @CType("GLsizei") int numViews) {
        if (!Unmarshal.isNullPointer(PFN_glFramebufferTextureMultiviewOVR)) { try {
            MH_glFramebufferTextureMultiviewOVR.invokeExact(PFN_glFramebufferTextureMultiviewOVR, target, attachment, texture, level, baseViewIndex, numViews);
        } catch (Throwable e) { throw new RuntimeException("error in glFramebufferTextureMultiviewOVR", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glFramebufferTextureMultiviewOVR"); }
    }

    public void NamedFramebufferTextureMultiviewOVR(@CType("GLuint") int framebuffer, @CType("GLenum") int attachment, @CType("GLuint") int texture, @CType("GLint") int level, @CType("GLint") int baseViewIndex, @CType("GLsizei") int numViews) {
        if (!Unmarshal.isNullPointer(PFN_glNamedFramebufferTextureMultiviewOVR)) { try {
            MH_glNamedFramebufferTextureMultiviewOVR.invokeExact(PFN_glNamedFramebufferTextureMultiviewOVR, framebuffer, attachment, texture, level, baseViewIndex, numViews);
        } catch (Throwable e) { throw new RuntimeException("error in glNamedFramebufferTextureMultiviewOVR", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glNamedFramebufferTextureMultiviewOVR"); }
    }

}
