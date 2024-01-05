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
 * {@code GL_EXT_external_buffer}
 */
public final class GLEXTExternalBuffer {
    public static void load(GLExtCaps ext, GLLoadFunc load) {
        if (!ext.GL_EXT_external_buffer) return;
        ext.glBufferStorageExternalEXT = load.invoke("glBufferStorageExternalEXT", ofVoid(JAVA_INT, JAVA_LONG, JAVA_LONG, ADDRESS, JAVA_INT));
        ext.glNamedBufferStorageExternalEXT = load.invoke("glNamedBufferStorageExternalEXT", ofVoid(JAVA_INT, JAVA_LONG, JAVA_LONG, ADDRESS, JAVA_INT));
    }

    public static void glBufferStorageExternalEXT(int target, long offset, long size, @NativeType("GLeglClientBufferEXT") MemorySegment clientBuffer, int flags) {
        final var ext = getExtCapabilities();
        try {
            check(ext.glBufferStorageExternalEXT).invokeExact(target, offset, size, clientBuffer, flags);
        } catch (Throwable e) { throw new AssertionError("should not reach here", e); }
    }

    public static void glNamedBufferStorageExternalEXT(int buffer, long offset, long size, @NativeType("GLeglClientBufferEXT") MemorySegment clientBuffer, int flags) {
        final var ext = getExtCapabilities();
        try {
            check(ext.glNamedBufferStorageExternalEXT).invokeExact(buffer, offset, size, clientBuffer, flags);
        } catch (Throwable e) { throw new AssertionError("should not reach here", e); }
    }

}
