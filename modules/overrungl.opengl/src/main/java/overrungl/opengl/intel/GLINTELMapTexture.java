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
package overrungl.opengl.intel;

import java.lang.foreign.*;
import java.lang.invoke.*;
import overrungl.annotation.*;
import overrungl.internal.RuntimeHelper;
import overrungl.util.*;

public final class GLINTELMapTexture {
    public static final int GL_TEXTURE_MEMORY_LAYOUT_INTEL = 0x83FF;
    public static final int GL_LAYOUT_DEFAULT_INTEL = 0;
    public static final int GL_LAYOUT_LINEAR_INTEL = 1;
    public static final int GL_LAYOUT_LINEAR_CPU_CACHED_INTEL = 2;
    public static final MethodHandle MH_glSyncTextureINTEL = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glSyncTextureINTEL;
    public static final MethodHandle MH_glUnmapTexture2DINTEL = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glUnmapTexture2DINTEL;
    public static final MethodHandle MH_glMapTexture2DINTEL = RuntimeHelper.downcall(FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glMapTexture2DINTEL;

    public GLINTELMapTexture(overrungl.opengl.GLLoadFunc func) {
        PFN_glSyncTextureINTEL = func.invoke("glSyncTextureINTEL");
        PFN_glUnmapTexture2DINTEL = func.invoke("glUnmapTexture2DINTEL");
        PFN_glMapTexture2DINTEL = func.invoke("glMapTexture2DINTEL");
    }

    public void SyncTextureINTEL(@CType("GLuint") int texture) {
        if (!Unmarshal.isNullPointer(PFN_glSyncTextureINTEL)) { try {
            MH_glSyncTextureINTEL.invokeExact(PFN_glSyncTextureINTEL, texture);
        } catch (Throwable e) { throw new RuntimeException("error in glSyncTextureINTEL", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glSyncTextureINTEL"); }
    }

    public void UnmapTexture2DINTEL(@CType("GLuint") int texture, @CType("GLint") int level) {
        if (!Unmarshal.isNullPointer(PFN_glUnmapTexture2DINTEL)) { try {
            MH_glUnmapTexture2DINTEL.invokeExact(PFN_glUnmapTexture2DINTEL, texture, level);
        } catch (Throwable e) { throw new RuntimeException("error in glUnmapTexture2DINTEL", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUnmapTexture2DINTEL"); }
    }

    public @CType("void*") java.lang.foreign.MemorySegment MapTexture2DINTEL(@CType("GLuint") int texture, @CType("GLint") int level, @CType("GLbitfield") int access, @CType("GLint *") java.lang.foreign.MemorySegment stride, @CType("GLenum *") java.lang.foreign.MemorySegment layout) {
        if (!Unmarshal.isNullPointer(PFN_glMapTexture2DINTEL)) { try {
            return (java.lang.foreign.MemorySegment) MH_glMapTexture2DINTEL.invokeExact(PFN_glMapTexture2DINTEL, texture, level, access, stride, layout);
        } catch (Throwable e) { throw new RuntimeException("error in glMapTexture2DINTEL", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glMapTexture2DINTEL"); }
    }

}
