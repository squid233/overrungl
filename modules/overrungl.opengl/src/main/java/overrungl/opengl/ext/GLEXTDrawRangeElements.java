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

public final class GLEXTDrawRangeElements {
    public static final int GL_MAX_ELEMENTS_VERTICES_EXT = 0x80E8;
    public static final int GL_MAX_ELEMENTS_INDICES_EXT = 0x80E9;
    public static final MethodHandle MH_glDrawRangeElementsEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glDrawRangeElementsEXT;

    public GLEXTDrawRangeElements(overrungl.opengl.GLLoadFunc func) {
        PFN_glDrawRangeElementsEXT = func.invoke("glDrawRangeElementsEXT", "glDrawRangeElements");
    }

    public void DrawRangeElementsEXT(@CType("GLenum") int mode, @CType("GLuint") int start, @CType("GLuint") int end, @CType("GLsizei") int count, @CType("GLenum") int type, @CType("const void *") java.lang.foreign.MemorySegment indices) {
        if (!Unmarshal.isNullPointer(PFN_glDrawRangeElementsEXT)) { try {
            MH_glDrawRangeElementsEXT.invokeExact(PFN_glDrawRangeElementsEXT, mode, start, end, count, type, indices);
        } catch (Throwable e) { throw new RuntimeException("error in glDrawRangeElementsEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDrawRangeElementsEXT"); }
    }

}
