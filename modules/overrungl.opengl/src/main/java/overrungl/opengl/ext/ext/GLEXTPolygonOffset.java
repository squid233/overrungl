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
 * {@code GL_EXT_polygon_offset}
 */
public final class GLEXTPolygonOffset {
    public static final int GL_POLYGON_OFFSET_EXT = 0x8037;
    public static final int GL_POLYGON_OFFSET_FACTOR_EXT = 0x8038;
    public static final int GL_POLYGON_OFFSET_BIAS_EXT = 0x8039;
    public static void load(GLExtCaps ext, GLLoadFunc load) {
        if (!ext.GL_EXT_polygon_offset) return;
        ext.glPolygonOffsetEXT = load.invoke("glPolygonOffsetEXT", ofVoid(JAVA_FLOAT, JAVA_FLOAT));
    }

    public static void glPolygonOffsetEXT(float factor, float bias) {
        final var ext = getExtCapabilities();
        try {
            check(ext.glPolygonOffsetEXT).invokeExact(factor, bias);
        } catch (Throwable e) { throw new AssertionError("should not reach here", e); }
    }

}