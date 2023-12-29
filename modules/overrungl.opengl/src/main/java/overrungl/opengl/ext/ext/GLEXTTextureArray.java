/*
 * MIT License
 *
 * Copyright (c) 2022-present Overrun Organization
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
package overrungl.opengl.ext.ext;

import overrungl.*;
import overrungl.opengl.*;
import java.lang.foreign.*;
import static java.lang.foreign.FunctionDescriptor.*;
import static java.lang.foreign.ValueLayout.*;
import static overrungl.opengl.GLLoader.*;

/**
 * {@code GL_EXT_texture_array}
 */
public final class GLEXTTextureArray {
    public static final int GL_TEXTURE_1D_ARRAY_EXT = 0x8C18;
    public static final int GL_PROXY_TEXTURE_1D_ARRAY_EXT = 0x8C19;
    public static final int GL_TEXTURE_2D_ARRAY_EXT = 0x8C1A;
    public static final int GL_PROXY_TEXTURE_2D_ARRAY_EXT = 0x8C1B;
    public static final int GL_TEXTURE_BINDING_1D_ARRAY_EXT = 0x8C1C;
    public static final int GL_TEXTURE_BINDING_2D_ARRAY_EXT = 0x8C1D;
    public static final int GL_MAX_ARRAY_TEXTURE_LAYERS_EXT = 0x88FF;
    public static final int GL_COMPARE_REF_DEPTH_TO_TEXTURE_EXT = 0x884E;
    public static void load(GLExtCaps ext, GLLoadFunc load) {
        if (!ext.GL_EXT_texture_array) return;
        ext.glFramebufferTextureLayerEXT = load.invoke("glFramebufferTextureLayerEXT", ofVoid(JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT));
    }

    public static void glFramebufferTextureLayerEXT(int target, int attachment, int texture, int level, int layer) {
        final var ext = getExtCapabilities();
        try {
            check(ext.glFramebufferTextureLayerEXT).invokeExact(target, attachment, texture, level, layer);
        } catch (Throwable e) { throw new AssertionError("should not reach here", e); }
    }

}