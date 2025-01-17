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
package overrungl.opengl.arb;

import java.lang.foreign.*;
import java.lang.invoke.*;
import overrungl.annotation.*;
import overrungl.internal.RuntimeHelper;
import overrungl.util.*;

public final class GLARBIndirectParameters {
    public static final int GL_PARAMETER_BUFFER_ARB = 0x80EE;
    public static final int GL_PARAMETER_BUFFER_BINDING_ARB = 0x80EF;
    public static final MethodHandle MH_glMultiDrawArraysIndirectCountARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glMultiDrawArraysIndirectCountARB;
    public static final MethodHandle MH_glMultiDrawElementsIndirectCountARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glMultiDrawElementsIndirectCountARB;

    public GLARBIndirectParameters(overrungl.opengl.GLLoadFunc func) {
        PFN_glMultiDrawArraysIndirectCountARB = func.invoke("glMultiDrawArraysIndirectCountARB", "glMultiDrawArraysIndirectCount");
        PFN_glMultiDrawElementsIndirectCountARB = func.invoke("glMultiDrawElementsIndirectCountARB", "glMultiDrawElementsIndirectCount");
    }

    public void MultiDrawArraysIndirectCountARB(@CType("GLenum") int mode, @CType("const void *") java.lang.foreign.MemorySegment indirect, @CType("GLintptr") long drawcount, @CType("GLsizei") int maxdrawcount, @CType("GLsizei") int stride) {
        if (!Unmarshal.isNullPointer(PFN_glMultiDrawArraysIndirectCountARB)) { try {
            MH_glMultiDrawArraysIndirectCountARB.invokeExact(PFN_glMultiDrawArraysIndirectCountARB, mode, indirect, drawcount, maxdrawcount, stride);
        } catch (Throwable e) { throw new RuntimeException("error in glMultiDrawArraysIndirectCountARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glMultiDrawArraysIndirectCountARB"); }
    }

    public void MultiDrawElementsIndirectCountARB(@CType("GLenum") int mode, @CType("GLenum") int type, @CType("const void *") java.lang.foreign.MemorySegment indirect, @CType("GLintptr") long drawcount, @CType("GLsizei") int maxdrawcount, @CType("GLsizei") int stride) {
        if (!Unmarshal.isNullPointer(PFN_glMultiDrawElementsIndirectCountARB)) { try {
            MH_glMultiDrawElementsIndirectCountARB.invokeExact(PFN_glMultiDrawElementsIndirectCountARB, mode, type, indirect, drawcount, maxdrawcount, stride);
        } catch (Throwable e) { throw new RuntimeException("error in glMultiDrawElementsIndirectCountARB", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glMultiDrawElementsIndirectCountARB"); }
    }

}
