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
import overrungl.NativeType;
import overrungl.opengl.*;
import java.lang.foreign.*;

/**
 * {@code GL_EXT_copy_texture}
 */
public interface GLEXTCopyTexture {

    default void glCopyTexImage1DEXT(int target, int level, int internalformat, int x, int y, int width, int border) {
        throw new ContextException();
    }

    default void glCopyTexImage2DEXT(int target, int level, int internalformat, int x, int y, int width, int height, int border) {
        throw new ContextException();
    }

    default void glCopyTexSubImage1DEXT(int target, int level, int xoffset, int x, int y, int width) {
        throw new ContextException();
    }

    default void glCopyTexSubImage2DEXT(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
        throw new ContextException();
    }

    default void glCopyTexSubImage3DEXT(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
        throw new ContextException();
    }

}
