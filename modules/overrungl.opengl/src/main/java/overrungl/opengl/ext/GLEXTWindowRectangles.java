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

public final class GLEXTWindowRectangles {
    public static final int GL_INCLUSIVE_EXT = 0x8F10;
    public static final int GL_EXCLUSIVE_EXT = 0x8F11;
    public static final int GL_WINDOW_RECTANGLE_EXT = 0x8F12;
    public static final int GL_WINDOW_RECTANGLE_MODE_EXT = 0x8F13;
    public static final int GL_MAX_WINDOW_RECTANGLES_EXT = 0x8F14;
    public static final int GL_NUM_WINDOW_RECTANGLES_EXT = 0x8F15;
    public static final MethodHandle MH_glWindowRectanglesEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glWindowRectanglesEXT;

    public GLEXTWindowRectangles(overrungl.opengl.GLLoadFunc func) {
        PFN_glWindowRectanglesEXT = func.invoke("glWindowRectanglesEXT");
    }

    public void WindowRectanglesEXT(@CType("GLenum") int mode, @CType("GLsizei") int count, @CType("const GLint *") java.lang.foreign.MemorySegment box) {
        if (!Unmarshal.isNullPointer(PFN_glWindowRectanglesEXT)) { try {
            MH_glWindowRectanglesEXT.invokeExact(PFN_glWindowRectanglesEXT, mode, count, box);
        } catch (Throwable e) { throw new RuntimeException("error in glWindowRectanglesEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glWindowRectanglesEXT"); }
    }

}
