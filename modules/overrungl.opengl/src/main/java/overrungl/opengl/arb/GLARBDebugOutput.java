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

public final class GLARBDebugOutput {
    public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS_ARB = 0x8242;
    public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH_ARB = 0x8243;
    public static final int GL_DEBUG_CALLBACK_FUNCTION_ARB = 0x8244;
    public static final int GL_DEBUG_CALLBACK_USER_PARAM_ARB = 0x8245;
    public static final int GL_DEBUG_SOURCE_API_ARB = 0x8246;
    public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM_ARB = 0x8247;
    public static final int GL_DEBUG_SOURCE_SHADER_COMPILER_ARB = 0x8248;
    public static final int GL_DEBUG_SOURCE_THIRD_PARTY_ARB = 0x8249;
    public static final int GL_DEBUG_SOURCE_APPLICATION_ARB = 0x824A;
    public static final int GL_DEBUG_SOURCE_OTHER_ARB = 0x824B;
    public static final int GL_DEBUG_TYPE_ERROR_ARB = 0x824C;
    public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR_ARB = 0x824D;
    public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR_ARB = 0x824E;
    public static final int GL_DEBUG_TYPE_PORTABILITY_ARB = 0x824F;
    public static final int GL_DEBUG_TYPE_PERFORMANCE_ARB = 0x8250;
    public static final int GL_DEBUG_TYPE_OTHER_ARB = 0x8251;
    public static final int GL_MAX_DEBUG_MESSAGE_LENGTH_ARB = 0x9143;
    public static final int GL_MAX_DEBUG_LOGGED_MESSAGES_ARB = 0x9144;
    public static final int GL_DEBUG_LOGGED_MESSAGES_ARB = 0x9145;
    public static final int GL_DEBUG_SEVERITY_HIGH_ARB = 0x9146;
    public static final int GL_DEBUG_SEVERITY_MEDIUM_ARB = 0x9147;
    public static final int GL_DEBUG_SEVERITY_LOW_ARB = 0x9148;
    public static final MethodHandle MH_glDebugMessageControlARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_BOOLEAN));
    public final MemorySegment PFN_glDebugMessageControlARB;
    public static final MethodHandle MH_glDebugMessageInsertARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glDebugMessageInsertARB;
    public static final MethodHandle MH_glDebugMessageCallbackARB = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glDebugMessageCallbackARB;
    public static final MethodHandle MH_glGetDebugMessageLogARB = RuntimeHelper.downcall(FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetDebugMessageLogARB;

    public GLARBDebugOutput(overrungl.opengl.GLLoadFunc func) {
        PFN_glDebugMessageControlARB = func.invoke("glDebugMessageControlARB", "glDebugMessageControl");
        PFN_glDebugMessageInsertARB = func.invoke("glDebugMessageInsertARB", "glDebugMessageInsert");
        PFN_glDebugMessageCallbackARB = func.invoke("glDebugMessageCallbackARB", "glDebugMessageCallback");
        PFN_glGetDebugMessageLogARB = func.invoke("glGetDebugMessageLogARB", "glGetDebugMessageLog");
    }

    public void DebugMessageControlARB(@CType("GLenum") int source, @CType("GLenum") int type, @CType("GLenum") int severity, @CType("GLsizei") int count, @CType("const GLuint *") java.lang.foreign.MemorySegment ids, @CType("GLboolean") boolean enabled) {
        try { if (!Unmarshal.isNullPointer(PFN_glDebugMessageControlARB))
            MH_glDebugMessageControlARB.invokeExact(PFN_glDebugMessageControlARB, source, type, severity, count, ids, enabled);
        }
        catch (Throwable e) { throw new RuntimeException("error in glDebugMessageControlARB", e); }
    }

    public void DebugMessageInsertARB(@CType("GLenum") int source, @CType("GLenum") int type, @CType("GLuint") int id, @CType("GLenum") int severity, @CType("GLsizei") int length, @CType("const GLchar *") java.lang.foreign.MemorySegment buf) {
        try { if (!Unmarshal.isNullPointer(PFN_glDebugMessageInsertARB))
            MH_glDebugMessageInsertARB.invokeExact(PFN_glDebugMessageInsertARB, source, type, id, severity, length, buf);
        }
        catch (Throwable e) { throw new RuntimeException("error in glDebugMessageInsertARB", e); }
    }

    public void DebugMessageCallbackARB(@CType("GLDEBUGPROCARB") java.lang.foreign.MemorySegment callback, @CType("const void *") java.lang.foreign.MemorySegment userParam) {
        try { if (!Unmarshal.isNullPointer(PFN_glDebugMessageCallbackARB))
            MH_glDebugMessageCallbackARB.invokeExact(PFN_glDebugMessageCallbackARB, callback, userParam);
        }
        catch (Throwable e) { throw new RuntimeException("error in glDebugMessageCallbackARB", e); }
    }

    public @CType("GLuint") int GetDebugMessageLogARB(@CType("GLuint") int count, @CType("GLsizei") int bufSize, @CType("GLenum *") java.lang.foreign.MemorySegment sources, @CType("GLenum *") java.lang.foreign.MemorySegment types, @CType("GLuint *") java.lang.foreign.MemorySegment ids, @CType("GLenum *") java.lang.foreign.MemorySegment severities, @CType("GLsizei *") java.lang.foreign.MemorySegment lengths, @CType("GLchar *") java.lang.foreign.MemorySegment messageLog) {
        try { if (!Unmarshal.isNullPointer(PFN_glGetDebugMessageLogARB))
            return (int) MH_glGetDebugMessageLogARB.invokeExact(PFN_glGetDebugMessageLogARB, count, bufSize, sources, types, ids, severities, lengths, messageLog);
            else return 0;
        }
        catch (Throwable e) { throw new RuntimeException("error in glGetDebugMessageLogARB", e); }
    }

}