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
package overrungl.opengl.sgis;

import java.lang.foreign.*;
import java.lang.invoke.*;
import overrungl.annotation.*;
import overrungl.internal.RuntimeHelper;
import overrungl.util.*;

public final class GLSGISFogFunction {
    public static final int GL_FOG_FUNC_SGIS = 0x812A;
    public static final int GL_FOG_FUNC_POINTS_SGIS = 0x812B;
    public static final int GL_MAX_FOG_FUNC_POINTS_SGIS = 0x812C;
    public static final MethodHandle MH_glFogFuncSGIS = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glFogFuncSGIS;
    public static final MethodHandle MH_glGetFogFuncSGIS = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetFogFuncSGIS;

    public GLSGISFogFunction(overrungl.opengl.GLLoadFunc func) {
        PFN_glFogFuncSGIS = func.invoke("glFogFuncSGIS");
        PFN_glGetFogFuncSGIS = func.invoke("glGetFogFuncSGIS");
    }

    public void FogFuncSGIS(@CType("GLsizei") int n, @CType("const GLfloat *") java.lang.foreign.MemorySegment points) {
        if (!Unmarshal.isNullPointer(PFN_glFogFuncSGIS)) { try {
            MH_glFogFuncSGIS.invokeExact(PFN_glFogFuncSGIS, n, points);
        } catch (Throwable e) { throw new RuntimeException("error in glFogFuncSGIS", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glFogFuncSGIS"); }
    }

    public void GetFogFuncSGIS(@CType("GLfloat *") java.lang.foreign.MemorySegment points) {
        if (!Unmarshal.isNullPointer(PFN_glGetFogFuncSGIS)) { try {
            MH_glGetFogFuncSGIS.invokeExact(PFN_glGetFogFuncSGIS, points);
        } catch (Throwable e) { throw new RuntimeException("error in glGetFogFuncSGIS", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetFogFuncSGIS"); }
    }

}
