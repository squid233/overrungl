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

public final class GLATIVertexArrayObject {
    public static final int GL_STATIC_ATI = 0x8760;
    public static final int GL_DYNAMIC_ATI = 0x8761;
    public static final int GL_PRESERVE_ATI = 0x8762;
    public static final int GL_DISCARD_ATI = 0x8763;
    public static final int GL_OBJECT_BUFFER_SIZE_ATI = 0x8764;
    public static final int GL_OBJECT_BUFFER_USAGE_ATI = 0x8765;
    public static final int GL_ARRAY_OBJECT_BUFFER_ATI = 0x8766;
    public static final int GL_ARRAY_OBJECT_OFFSET_ATI = 0x8767;
    public static final MethodHandle MH_glNewObjectBufferATI = RuntimeHelper.downcall(FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glNewObjectBufferATI;
    public static final MethodHandle MH_glIsObjectBufferATI = RuntimeHelper.downcall(FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glIsObjectBufferATI;
    public static final MethodHandle MH_glUpdateObjectBufferATI = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glUpdateObjectBufferATI;
    public static final MethodHandle MH_glGetObjectBufferfvATI = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetObjectBufferfvATI;
    public static final MethodHandle MH_glGetObjectBufferivATI = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetObjectBufferivATI;
    public static final MethodHandle MH_glFreeObjectBufferATI = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glFreeObjectBufferATI;
    public static final MethodHandle MH_glArrayObjectATI = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glArrayObjectATI;
    public static final MethodHandle MH_glGetArrayObjectfvATI = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetArrayObjectfvATI;
    public static final MethodHandle MH_glGetArrayObjectivATI = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetArrayObjectivATI;
    public static final MethodHandle MH_glVariantArrayObjectATI = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glVariantArrayObjectATI;
    public static final MethodHandle MH_glGetVariantArrayObjectfvATI = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetVariantArrayObjectfvATI;
    public static final MethodHandle MH_glGetVariantArrayObjectivATI = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetVariantArrayObjectivATI;

    public GLATIVertexArrayObject(overrungl.opengl.GLLoadFunc func) {
        PFN_glNewObjectBufferATI = func.invoke("glNewObjectBufferATI");
        PFN_glIsObjectBufferATI = func.invoke("glIsObjectBufferATI");
        PFN_glUpdateObjectBufferATI = func.invoke("glUpdateObjectBufferATI");
        PFN_glGetObjectBufferfvATI = func.invoke("glGetObjectBufferfvATI");
        PFN_glGetObjectBufferivATI = func.invoke("glGetObjectBufferivATI");
        PFN_glFreeObjectBufferATI = func.invoke("glFreeObjectBufferATI");
        PFN_glArrayObjectATI = func.invoke("glArrayObjectATI");
        PFN_glGetArrayObjectfvATI = func.invoke("glGetArrayObjectfvATI");
        PFN_glGetArrayObjectivATI = func.invoke("glGetArrayObjectivATI");
        PFN_glVariantArrayObjectATI = func.invoke("glVariantArrayObjectATI");
        PFN_glGetVariantArrayObjectfvATI = func.invoke("glGetVariantArrayObjectfvATI");
        PFN_glGetVariantArrayObjectivATI = func.invoke("glGetVariantArrayObjectivATI");
    }

    public @CType("GLuint") int NewObjectBufferATI(@CType("GLsizei") int size, @CType("const void *") java.lang.foreign.MemorySegment pointer, @CType("GLenum") int usage) {
        if (!Unmarshal.isNullPointer(PFN_glNewObjectBufferATI)) { try {
            return (int) MH_glNewObjectBufferATI.invokeExact(PFN_glNewObjectBufferATI, size, pointer, usage);
        } catch (Throwable e) { throw new RuntimeException("error in glNewObjectBufferATI", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glNewObjectBufferATI"); }
    }

    public @CType("GLboolean") boolean IsObjectBufferATI(@CType("GLuint") int buffer) {
        if (!Unmarshal.isNullPointer(PFN_glIsObjectBufferATI)) { try {
            return (boolean) MH_glIsObjectBufferATI.invokeExact(PFN_glIsObjectBufferATI, buffer);
        } catch (Throwable e) { throw new RuntimeException("error in glIsObjectBufferATI", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glIsObjectBufferATI"); }
    }

    public void UpdateObjectBufferATI(@CType("GLuint") int buffer, @CType("GLuint") int offset, @CType("GLsizei") int size, @CType("const void *") java.lang.foreign.MemorySegment pointer, @CType("GLenum") int preserve) {
        if (!Unmarshal.isNullPointer(PFN_glUpdateObjectBufferATI)) { try {
            MH_glUpdateObjectBufferATI.invokeExact(PFN_glUpdateObjectBufferATI, buffer, offset, size, pointer, preserve);
        } catch (Throwable e) { throw new RuntimeException("error in glUpdateObjectBufferATI", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glUpdateObjectBufferATI"); }
    }

    public void GetObjectBufferfvATI(@CType("GLuint") int buffer, @CType("GLenum") int pname, @CType("GLfloat *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetObjectBufferfvATI)) { try {
            MH_glGetObjectBufferfvATI.invokeExact(PFN_glGetObjectBufferfvATI, buffer, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetObjectBufferfvATI", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetObjectBufferfvATI"); }
    }

    public void GetObjectBufferivATI(@CType("GLuint") int buffer, @CType("GLenum") int pname, @CType("GLint *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetObjectBufferivATI)) { try {
            MH_glGetObjectBufferivATI.invokeExact(PFN_glGetObjectBufferivATI, buffer, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetObjectBufferivATI", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetObjectBufferivATI"); }
    }

    public void FreeObjectBufferATI(@CType("GLuint") int buffer) {
        if (!Unmarshal.isNullPointer(PFN_glFreeObjectBufferATI)) { try {
            MH_glFreeObjectBufferATI.invokeExact(PFN_glFreeObjectBufferATI, buffer);
        } catch (Throwable e) { throw new RuntimeException("error in glFreeObjectBufferATI", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glFreeObjectBufferATI"); }
    }

    public void ArrayObjectATI(@CType("GLenum") int array, @CType("GLint") int size, @CType("GLenum") int type, @CType("GLsizei") int stride, @CType("GLuint") int buffer, @CType("GLuint") int offset) {
        if (!Unmarshal.isNullPointer(PFN_glArrayObjectATI)) { try {
            MH_glArrayObjectATI.invokeExact(PFN_glArrayObjectATI, array, size, type, stride, buffer, offset);
        } catch (Throwable e) { throw new RuntimeException("error in glArrayObjectATI", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glArrayObjectATI"); }
    }

    public void GetArrayObjectfvATI(@CType("GLenum") int array, @CType("GLenum") int pname, @CType("GLfloat *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetArrayObjectfvATI)) { try {
            MH_glGetArrayObjectfvATI.invokeExact(PFN_glGetArrayObjectfvATI, array, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetArrayObjectfvATI", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetArrayObjectfvATI"); }
    }

    public void GetArrayObjectivATI(@CType("GLenum") int array, @CType("GLenum") int pname, @CType("GLint *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetArrayObjectivATI)) { try {
            MH_glGetArrayObjectivATI.invokeExact(PFN_glGetArrayObjectivATI, array, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetArrayObjectivATI", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetArrayObjectivATI"); }
    }

    public void VariantArrayObjectATI(@CType("GLuint") int id, @CType("GLenum") int type, @CType("GLsizei") int stride, @CType("GLuint") int buffer, @CType("GLuint") int offset) {
        if (!Unmarshal.isNullPointer(PFN_glVariantArrayObjectATI)) { try {
            MH_glVariantArrayObjectATI.invokeExact(PFN_glVariantArrayObjectATI, id, type, stride, buffer, offset);
        } catch (Throwable e) { throw new RuntimeException("error in glVariantArrayObjectATI", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glVariantArrayObjectATI"); }
    }

    public void GetVariantArrayObjectfvATI(@CType("GLuint") int id, @CType("GLenum") int pname, @CType("GLfloat *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetVariantArrayObjectfvATI)) { try {
            MH_glGetVariantArrayObjectfvATI.invokeExact(PFN_glGetVariantArrayObjectfvATI, id, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetVariantArrayObjectfvATI", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetVariantArrayObjectfvATI"); }
    }

    public void GetVariantArrayObjectivATI(@CType("GLuint") int id, @CType("GLenum") int pname, @CType("GLint *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetVariantArrayObjectivATI)) { try {
            MH_glGetVariantArrayObjectivATI.invokeExact(PFN_glGetVariantArrayObjectivATI, id, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetVariantArrayObjectivATI", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetVariantArrayObjectivATI"); }
    }

}
