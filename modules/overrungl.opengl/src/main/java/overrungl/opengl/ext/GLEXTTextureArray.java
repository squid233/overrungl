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

public final class GLEXTTextureArray {
    public static final int GL_TEXTURE_1D_ARRAY_EXT = 0x8C18;
    public static final int GL_PROXY_TEXTURE_1D_ARRAY_EXT = 0x8C19;
    public static final int GL_TEXTURE_2D_ARRAY_EXT = 0x8C1A;
    public static final int GL_PROXY_TEXTURE_2D_ARRAY_EXT = 0x8C1B;
    public static final int GL_TEXTURE_BINDING_1D_ARRAY_EXT = 0x8C1C;
    public static final int GL_TEXTURE_BINDING_2D_ARRAY_EXT = 0x8C1D;
    public static final int GL_MAX_ARRAY_TEXTURE_LAYERS_EXT = 0x88FF;
    public static final int GL_COMPARE_REF_DEPTH_TO_TEXTURE_EXT = 0x884E;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER_EXT = 0x8CD4;
    public static final MethodHandle MH_glFramebufferTextureLayerEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glFramebufferTextureLayerEXT;

    public GLEXTTextureArray(overrungl.opengl.GLLoadFunc func) {
        PFN_glFramebufferTextureLayerEXT = func.invoke("glFramebufferTextureLayerEXT", "glFramebufferTextureLayer");
    }

    public void FramebufferTextureLayerEXT(@CType("GLenum") int target, @CType("GLenum") int attachment, @CType("GLuint") int texture, @CType("GLint") int level, @CType("GLint") int layer) {
        try { if (!Unmarshal.isNullPointer(PFN_glFramebufferTextureLayerEXT))
            MH_glFramebufferTextureLayerEXT.invokeExact(PFN_glFramebufferTextureLayerEXT, target, attachment, texture, level, layer);
        }
        catch (Throwable e) { throw new RuntimeException("error in glFramebufferTextureLayerEXT", e); }
    }

}