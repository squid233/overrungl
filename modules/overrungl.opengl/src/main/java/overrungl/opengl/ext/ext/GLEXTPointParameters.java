/*
 * MIT License
 *
 * Copyright (c) 2022-2024 Overrun Organization
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
import overrungl.NativeType;
import overrungl.opengl.*;
import java.lang.foreign.*;

/**
 * {@code GL_EXT_point_parameters}
 */
public interface GLEXTPointParameters extends overrun.marshal.DirectAccess {
    int GL_POINT_SIZE_MIN_EXT = 0x8126;
    int GL_POINT_SIZE_MAX_EXT = 0x8127;
    int GL_POINT_FADE_THRESHOLD_SIZE_EXT = 0x8128;
    int GL_DISTANCE_ATTENUATION_EXT = 0x8129;

    default void glPointParameterfEXT(int pname, float param) {
        throw new ContextException();
    }

    default void glPointParameterfvEXT(int pname, @NativeType("const GLfloat *") MemorySegment params) {
        throw new ContextException();
    }

}
