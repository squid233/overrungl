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
 * {@code GL_EXT_multi_draw_arrays}
 */
public final class GLEXTMultiDrawArrays {
    public static void load(GLExtCaps ext, GLLoadFunc load) {
        if (!ext.GL_EXT_multi_draw_arrays) return;
        ext.glMultiDrawArraysEXT = load.invoke("glMultiDrawArraysEXT", ofVoid(JAVA_INT, ADDRESS, ADDRESS, JAVA_INT));
        ext.glMultiDrawElementsEXT = load.invoke("glMultiDrawElementsEXT", ofVoid(JAVA_INT, ADDRESS, JAVA_INT, ADDRESS, JAVA_INT));
    }

    public static void glMultiDrawArraysEXT(int mode, @NativeType("const GLint *") MemorySegment first, @NativeType("const GLsizei *") MemorySegment count, int primcount) {
        final var ext = getExtCapabilities();
        try {
            check(ext.glMultiDrawArraysEXT).invokeExact(mode, first, count, primcount);
        } catch (Throwable e) { throw new AssertionError("should not reach here", e); }
    }

    public static void glMultiDrawElementsEXT(int mode, @NativeType("const GLsizei *") MemorySegment count, int type, @NativeType("const void *const*") MemorySegment indices, int primcount) {
        final var ext = getExtCapabilities();
        try {
            check(ext.glMultiDrawElementsEXT).invokeExact(mode, count, type, indices, primcount);
        } catch (Throwable e) { throw new AssertionError("should not reach here", e); }
    }

}
