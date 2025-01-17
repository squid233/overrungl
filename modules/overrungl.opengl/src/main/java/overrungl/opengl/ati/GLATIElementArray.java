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
package overrungl.opengl.ati;

import java.lang.foreign.*;
import java.lang.invoke.*;
import overrungl.annotation.*;
import overrungl.internal.RuntimeHelper;
import overrungl.util.*;

public final class GLATIElementArray {
    public static final int GL_ELEMENT_ARRAY_ATI = 0x8768;
    public static final int GL_ELEMENT_ARRAY_TYPE_ATI = 0x8769;
    public static final int GL_ELEMENT_ARRAY_POINTER_ATI = 0x876A;
    public static final MethodHandle MH_glElementPointerATI = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glElementPointerATI;
    public static final MethodHandle MH_glDrawElementArrayATI = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glDrawElementArrayATI;
    public static final MethodHandle MH_glDrawRangeElementArrayATI = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glDrawRangeElementArrayATI;

    public GLATIElementArray(overrungl.opengl.GLLoadFunc func) {
        PFN_glElementPointerATI = func.invoke("glElementPointerATI");
        PFN_glDrawElementArrayATI = func.invoke("glDrawElementArrayATI");
        PFN_glDrawRangeElementArrayATI = func.invoke("glDrawRangeElementArrayATI");
    }

    public void ElementPointerATI(@CType("GLenum") int type, @CType("const void *") java.lang.foreign.MemorySegment pointer) {
        if (!Unmarshal.isNullPointer(PFN_glElementPointerATI)) { try {
            MH_glElementPointerATI.invokeExact(PFN_glElementPointerATI, type, pointer);
        } catch (Throwable e) { throw new RuntimeException("error in glElementPointerATI", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glElementPointerATI"); }
    }

    public void DrawElementArrayATI(@CType("GLenum") int mode, @CType("GLsizei") int count) {
        if (!Unmarshal.isNullPointer(PFN_glDrawElementArrayATI)) { try {
            MH_glDrawElementArrayATI.invokeExact(PFN_glDrawElementArrayATI, mode, count);
        } catch (Throwable e) { throw new RuntimeException("error in glDrawElementArrayATI", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDrawElementArrayATI"); }
    }

    public void DrawRangeElementArrayATI(@CType("GLenum") int mode, @CType("GLuint") int start, @CType("GLuint") int end, @CType("GLsizei") int count) {
        if (!Unmarshal.isNullPointer(PFN_glDrawRangeElementArrayATI)) { try {
            MH_glDrawRangeElementArrayATI.invokeExact(PFN_glDrawRangeElementArrayATI, mode, start, end, count);
        } catch (Throwable e) { throw new RuntimeException("error in glDrawRangeElementArrayATI", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDrawRangeElementArrayATI"); }
    }

}
