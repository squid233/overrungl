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
package overrungl.opengl.ext.arb;
import overrungl.NativeType;
import overrungl.opengl.*;
import java.lang.foreign.*;

/**
 * {@code GL_ARB_texture_buffer_object}
 */
public interface GLARBTextureBufferObject extends overrun.marshal.DirectAccess {
    int GL_TEXTURE_BUFFER_ARB = 0x8C2A;
    int GL_MAX_TEXTURE_BUFFER_SIZE_ARB = 0x8C2B;
    int GL_TEXTURE_BINDING_BUFFER_ARB = 0x8C2C;
    int GL_TEXTURE_BUFFER_DATA_STORE_BINDING_ARB = 0x8C2D;
    int GL_TEXTURE_BUFFER_FORMAT_ARB = 0x8C2E;

    default void glTexBufferARB(int target, int internalFormat, int buffer) {
        throw new ContextException();
    }

}
