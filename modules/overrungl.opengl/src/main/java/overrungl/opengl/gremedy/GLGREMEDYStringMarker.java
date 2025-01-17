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
package overrungl.opengl.gremedy;

import java.lang.foreign.*;
import java.lang.invoke.*;
import overrungl.annotation.*;
import overrungl.internal.RuntimeHelper;
import overrungl.util.*;

public final class GLGREMEDYStringMarker {
    public static final MethodHandle MH_glStringMarkerGREMEDY = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glStringMarkerGREMEDY;

    public GLGREMEDYStringMarker(overrungl.opengl.GLLoadFunc func) {
        PFN_glStringMarkerGREMEDY = func.invoke("glStringMarkerGREMEDY");
    }

    public void StringMarkerGREMEDY(@CType("GLsizei") int len, @CType("const void *") java.lang.foreign.MemorySegment string) {
        if (!Unmarshal.isNullPointer(PFN_glStringMarkerGREMEDY)) { try {
            MH_glStringMarkerGREMEDY.invokeExact(PFN_glStringMarkerGREMEDY, len, string);
        } catch (Throwable e) { throw new RuntimeException("error in glStringMarkerGREMEDY", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glStringMarkerGREMEDY"); }
    }

}
