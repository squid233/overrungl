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

public final class GLEXTBlendMinmax {
    public static final int GL_MIN_EXT = 0x8007;
    public static final int GL_MAX_EXT = 0x8008;
    public static final int GL_FUNC_ADD_EXT = 0x8006;
    public static final int GL_BLEND_EQUATION_EXT = 0x8009;
    public static final MethodHandle MH_glBlendEquationEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glBlendEquationEXT;

    public GLEXTBlendMinmax(overrungl.opengl.GLLoadFunc func) {
        PFN_glBlendEquationEXT = func.invoke("glBlendEquationEXT", "glBlendEquation");
    }

    public void BlendEquationEXT(@CType("GLenum") int mode) {
        if (!Unmarshal.isNullPointer(PFN_glBlendEquationEXT)) { try {
            MH_glBlendEquationEXT.invokeExact(PFN_glBlendEquationEXT, mode);
        } catch (Throwable e) { throw new RuntimeException("error in glBlendEquationEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glBlendEquationEXT"); }
    }

}
