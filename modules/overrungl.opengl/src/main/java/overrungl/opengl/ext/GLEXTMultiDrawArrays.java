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

public final class GLEXTMultiDrawArrays {
    public static final MethodHandle MH_glMultiDrawArraysEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glMultiDrawArraysEXT;
    public static final MethodHandle MH_glMultiDrawElementsEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glMultiDrawElementsEXT;

    public GLEXTMultiDrawArrays(overrungl.opengl.GLLoadFunc func) {
        PFN_glMultiDrawArraysEXT = func.invoke("glMultiDrawArraysEXT", "glMultiDrawArrays");
        PFN_glMultiDrawElementsEXT = func.invoke("glMultiDrawElementsEXT", "glMultiDrawElements");
    }

    public void MultiDrawArraysEXT(@CType("GLenum") int mode, @CType("const GLint *") java.lang.foreign.MemorySegment first, @CType("const GLsizei *") java.lang.foreign.MemorySegment count, @CType("GLsizei") int primcount) {
        if (!Unmarshal.isNullPointer(PFN_glMultiDrawArraysEXT)) { try {
            MH_glMultiDrawArraysEXT.invokeExact(PFN_glMultiDrawArraysEXT, mode, first, count, primcount);
        } catch (Throwable e) { throw new RuntimeException("error in glMultiDrawArraysEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glMultiDrawArraysEXT"); }
    }

    public void MultiDrawElementsEXT(@CType("GLenum") int mode, @CType("const GLsizei *") java.lang.foreign.MemorySegment count, @CType("GLenum") int type, @CType("const void *const*") java.lang.foreign.MemorySegment indices, @CType("GLsizei") int primcount) {
        if (!Unmarshal.isNullPointer(PFN_glMultiDrawElementsEXT)) { try {
            MH_glMultiDrawElementsEXT.invokeExact(PFN_glMultiDrawElementsEXT, mode, count, type, indices, primcount);
        } catch (Throwable e) { throw new RuntimeException("error in glMultiDrawElementsEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glMultiDrawElementsEXT"); }
    }

}
