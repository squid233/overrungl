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

public final class GLEXTTextureObject {
    public static final int GL_TEXTURE_PRIORITY_EXT = 0x8066;
    public static final int GL_TEXTURE_RESIDENT_EXT = 0x8067;
    public static final int GL_TEXTURE_1D_BINDING_EXT = 0x8068;
    public static final int GL_TEXTURE_2D_BINDING_EXT = 0x8069;
    public static final int GL_TEXTURE_3D_BINDING_EXT = 0x806A;
    public static final MethodHandle MH_glAreTexturesResidentEXT = RuntimeHelper.downcall(FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glAreTexturesResidentEXT;
    public static final MethodHandle MH_glBindTextureEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glBindTextureEXT;
    public static final MethodHandle MH_glDeleteTexturesEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glDeleteTexturesEXT;
    public static final MethodHandle MH_glGenTexturesEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGenTexturesEXT;
    public static final MethodHandle MH_glIsTextureEXT = RuntimeHelper.downcall(FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glIsTextureEXT;
    public static final MethodHandle MH_glPrioritizeTexturesEXT = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glPrioritizeTexturesEXT;

    public GLEXTTextureObject(overrungl.opengl.GLLoadFunc func) {
        PFN_glAreTexturesResidentEXT = func.invoke("glAreTexturesResidentEXT");
        PFN_glBindTextureEXT = func.invoke("glBindTextureEXT", "glBindTexture");
        PFN_glDeleteTexturesEXT = func.invoke("glDeleteTexturesEXT");
        PFN_glGenTexturesEXT = func.invoke("glGenTexturesEXT");
        PFN_glIsTextureEXT = func.invoke("glIsTextureEXT");
        PFN_glPrioritizeTexturesEXT = func.invoke("glPrioritizeTexturesEXT", "glPrioritizeTextures");
    }

    public @CType("GLboolean") boolean AreTexturesResidentEXT(@CType("GLsizei") int n, @CType("const GLuint *") java.lang.foreign.MemorySegment textures, @CType("GLboolean *") java.lang.foreign.MemorySegment residences) {
        if (!Unmarshal.isNullPointer(PFN_glAreTexturesResidentEXT)) { try {
            return (boolean) MH_glAreTexturesResidentEXT.invokeExact(PFN_glAreTexturesResidentEXT, n, textures, residences);
        } catch (Throwable e) { throw new RuntimeException("error in glAreTexturesResidentEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glAreTexturesResidentEXT"); }
    }

    public void BindTextureEXT(@CType("GLenum") int target, @CType("GLuint") int texture) {
        if (!Unmarshal.isNullPointer(PFN_glBindTextureEXT)) { try {
            MH_glBindTextureEXT.invokeExact(PFN_glBindTextureEXT, target, texture);
        } catch (Throwable e) { throw new RuntimeException("error in glBindTextureEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glBindTextureEXT"); }
    }

    public void DeleteTexturesEXT(@CType("GLsizei") int n, @CType("const GLuint *") java.lang.foreign.MemorySegment textures) {
        if (!Unmarshal.isNullPointer(PFN_glDeleteTexturesEXT)) { try {
            MH_glDeleteTexturesEXT.invokeExact(PFN_glDeleteTexturesEXT, n, textures);
        } catch (Throwable e) { throw new RuntimeException("error in glDeleteTexturesEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDeleteTexturesEXT"); }
    }

    public void GenTexturesEXT(@CType("GLsizei") int n, @CType("GLuint *") java.lang.foreign.MemorySegment textures) {
        if (!Unmarshal.isNullPointer(PFN_glGenTexturesEXT)) { try {
            MH_glGenTexturesEXT.invokeExact(PFN_glGenTexturesEXT, n, textures);
        } catch (Throwable e) { throw new RuntimeException("error in glGenTexturesEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGenTexturesEXT"); }
    }

    public @CType("GLboolean") boolean IsTextureEXT(@CType("GLuint") int texture) {
        if (!Unmarshal.isNullPointer(PFN_glIsTextureEXT)) { try {
            return (boolean) MH_glIsTextureEXT.invokeExact(PFN_glIsTextureEXT, texture);
        } catch (Throwable e) { throw new RuntimeException("error in glIsTextureEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glIsTextureEXT"); }
    }

    public void PrioritizeTexturesEXT(@CType("GLsizei") int n, @CType("const GLuint *") java.lang.foreign.MemorySegment textures, @CType("const GLclampf *") java.lang.foreign.MemorySegment priorities) {
        if (!Unmarshal.isNullPointer(PFN_glPrioritizeTexturesEXT)) { try {
            MH_glPrioritizeTexturesEXT.invokeExact(PFN_glPrioritizeTexturesEXT, n, textures, priorities);
        } catch (Throwable e) { throw new RuntimeException("error in glPrioritizeTexturesEXT", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glPrioritizeTexturesEXT"); }
    }

}
