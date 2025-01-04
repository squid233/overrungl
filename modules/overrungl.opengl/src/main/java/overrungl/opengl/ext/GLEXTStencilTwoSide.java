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

public final class GLEXTStencilTwoSide {
    public static final int GL_STENCIL_TEST_TWO_SIDE_EXT = 0x8910;
    public static final int GL_ACTIVE_STENCIL_FACE_EXT = 0x8911;
    public static final MethodHandle MH_glActiveStencilFaceEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glActiveStencilFaceEXT;

    public GLEXTStencilTwoSide(overrungl.opengl.GLLoadFunc func) {
        PFN_glActiveStencilFaceEXT = func.invoke("glActiveStencilFaceEXT");
    }

    public void ActiveStencilFaceEXT(@CType("GLenum") int face) {
        try { if (!Unmarshal.isNullPointer(PFN_glActiveStencilFaceEXT))
            MH_glActiveStencilFaceEXT.invokeExact(PFN_glActiveStencilFaceEXT, face);
        }
        catch (Throwable e) { throw new RuntimeException("error in glActiveStencilFaceEXT", e); }
    }

}
