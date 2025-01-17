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
package overrungl.opengl.nv;

import java.lang.foreign.*;
import java.lang.invoke.*;
import overrungl.annotation.*;
import overrungl.internal.RuntimeHelper;
import overrungl.util.*;

public final class GLNVConservativeRasterPreSnapTriangles {
    public static final int GL_CONSERVATIVE_RASTER_MODE_NV = 0x954D;
    public static final int GL_CONSERVATIVE_RASTER_MODE_POST_SNAP_NV = 0x954E;
    public static final int GL_CONSERVATIVE_RASTER_MODE_PRE_SNAP_TRIANGLES_NV = 0x954F;
    public static final MethodHandle MH_glConservativeRasterParameteriNV = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glConservativeRasterParameteriNV;

    public GLNVConservativeRasterPreSnapTriangles(overrungl.opengl.GLLoadFunc func) {
        PFN_glConservativeRasterParameteriNV = func.invoke("glConservativeRasterParameteriNV");
    }

    public void ConservativeRasterParameteriNV(@CType("GLenum") int pname, @CType("GLint") int param) {
        if (!Unmarshal.isNullPointer(PFN_glConservativeRasterParameteriNV)) { try {
            MH_glConservativeRasterParameteriNV.invokeExact(PFN_glConservativeRasterParameteriNV, pname, param);
        } catch (Throwable e) { throw new RuntimeException("error in glConservativeRasterParameteriNV", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glConservativeRasterParameteriNV"); }
    }

}
