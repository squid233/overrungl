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

public final class GLARBTextureBufferObject {
    public static final int GL_TEXTURE_BUFFER_ARB = 0x8C2A;
    public static final int GL_MAX_TEXTURE_BUFFER_SIZE_ARB = 0x8C2B;
    public static final int GL_TEXTURE_BINDING_BUFFER_ARB = 0x8C2C;
    public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING_ARB = 0x8C2D;
    public static final int GL_TEXTURE_BUFFER_FORMAT_ARB = 0x8C2E;
    public static final MethodHandle MH_glTexBufferARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glTexBufferARB;

    public GLARBTextureBufferObject(overrungl.opengl.GLLoadFunc func) {
        PFN_glTexBufferARB = func.invoke("glTexBufferARB", "glTexBuffer");
    }

    public void TexBufferARB(@CType("GLenum") int target, @CType("GLenum") int internalformat, @CType("GLuint") int buffer) {
        try { if (!Unmarshal.isNullPointer(PFN_glTexBufferARB))
            MH_glTexBufferARB.invokeExact(PFN_glTexBufferARB, target, internalformat, buffer);
        }
        catch (Throwable e) { throw new RuntimeException("error in glTexBufferARB", e); }
    }

}