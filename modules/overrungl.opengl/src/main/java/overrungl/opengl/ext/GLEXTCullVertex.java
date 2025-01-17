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

public final class GLEXTCullVertex {
    public static final int GL_CULL_VERTEX_EXT = 0x81AA;
    public static final int GL_CULL_VERTEX_EYE_POSITION_EXT = 0x81AB;
    public static final int GL_CULL_VERTEX_OBJECT_POSITION_EXT = 0x81AC;
    public static final MethodHandle MH_glCullParameterdvEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glCullParameterdvEXT;
    public static final MethodHandle MH_glCullParameterfvEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glCullParameterfvEXT;

    public GLEXTCullVertex(overrungl.opengl.GLLoadFunc func) {
        PFN_glCullParameterdvEXT = func.invoke("glCullParameterdvEXT");
        PFN_glCullParameterfvEXT = func.invoke("glCullParameterfvEXT");
    }

    public void CullParameterdvEXT(@CType("GLenum") int pname, @CType("GLdouble *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glCullParameterdvEXT)) { try {
            MH_glCullParameterdvEXT.invokeExact(PFN_glCullParameterdvEXT, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glCullParameterdvEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glCullParameterdvEXT"); }
    }

    public void CullParameterfvEXT(@CType("GLenum") int pname, @CType("GLfloat *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glCullParameterfvEXT)) { try {
            MH_glCullParameterfvEXT.invokeExact(PFN_glCullParameterfvEXT, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glCullParameterfvEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glCullParameterfvEXT"); }
    }

}
