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
package overrungl.opengl.threedfx;

import java.lang.foreign.*;
import java.lang.invoke.*;
import overrungl.annotation.*;
import overrungl.internal.RuntimeHelper;
import overrungl.util.*;

public final class GL3DFXTbuffer {
    public static final MethodHandle MH_glTbufferMask3DFX = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glTbufferMask3DFX;

    public GL3DFXTbuffer(overrungl.opengl.GLLoadFunc func) {
        PFN_glTbufferMask3DFX = func.invoke("glTbufferMask3DFX");
    }

    public void TbufferMask3DFX(@CType("GLuint") int mask) {
        try { if (!Unmarshal.isNullPointer(PFN_glTbufferMask3DFX))
            MH_glTbufferMask3DFX.invokeExact(PFN_glTbufferMask3DFX, mask);
        }
        catch (Throwable e) { throw new RuntimeException("error in glTbufferMask3DFX", e); }
    }

}