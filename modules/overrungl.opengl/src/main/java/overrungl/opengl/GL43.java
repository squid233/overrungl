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
package overrungl.opengl;

import java.lang.foreign.*;
import java.lang.invoke.*;
import overrungl.annotation.*;
import overrungl.internal.RuntimeHelper;
import overrungl.util.*;

public sealed class GL43 extends GL42 permits GL44 {
    public static final int GL_NUM_SHADING_LANGUAGE_VERSIONS = 0x82E9;
    public static final int GL_VERTEX_ATTRIB_ARRAY_LONG = 0x874E;
    public static final int GL_COMPRESSED_RGB8_ETC2 = 0x9274;
    public static final int GL_COMPRESSED_SRGB8_ETC2 = 0x9275;
    public static final int GL_COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 0x9276;
    public static final int GL_COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 0x9277;
    public static final int GL_COMPRESSED_RGBA8_ETC2_EAC = 0x9278;
    public static final int GL_COMPRESSED_SRGB8_ALPHA8_ETC2_EAC = 0x9279;
    public static final int GL_COMPRESSED_R11_EAC = 0x9270;
    public static final int GL_COMPRESSED_SIGNED_R11_EAC = 0x9271;
    public static final int GL_COMPRESSED_RG11_EAC = 0x9272;
    public static final int GL_COMPRESSED_SIGNED_RG11_EAC = 0x9273;
    public static final int GL_PRIMITIVE_RESTART_FIXED_INDEX = 0x8D69;
    public static final int GL_ANY_SAMPLES_PASSED_CONSERVATIVE = 0x8D6A;
    public static final int GL_MAX_ELEMENT_INDEX = 0x8D6B;
    public static final int GL_COMPUTE_SHADER = 0x91B9;
    public static final int GL_MAX_COMPUTE_UNIFORM_BLOCKS = 0x91BB;
    public static final int GL_MAX_COMPUTE_TEXTURE_IMAGE_UNITS = 0x91BC;
    public static final int GL_MAX_COMPUTE_IMAGE_UNIFORMS = 0x91BD;
    public static final int GL_MAX_COMPUTE_SHARED_MEMORY_SIZE = 0x8262;
    public static final int GL_MAX_COMPUTE_UNIFORM_COMPONENTS = 0x8263;
    public static final int GL_MAX_COMPUTE_ATOMIC_COUNTER_BUFFERS = 0x8264;
    public static final int GL_MAX_COMPUTE_ATOMIC_COUNTERS = 0x8265;
    public static final int GL_MAX_COMBINED_COMPUTE_UNIFORM_COMPONENTS = 0x8266;
    public static final int GL_MAX_COMPUTE_WORK_GROUP_INVOCATIONS = 0x90EB;
    public static final int GL_MAX_COMPUTE_WORK_GROUP_COUNT = 0x91BE;
    public static final int GL_MAX_COMPUTE_WORK_GROUP_SIZE = 0x91BF;
    public static final int GL_COMPUTE_WORK_GROUP_SIZE = 0x8267;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_COMPUTE_SHADER = 0x90EC;
    public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_COMPUTE_SHADER = 0x90ED;
    public static final int GL_DISPATCH_INDIRECT_BUFFER = 0x90EE;
    public static final int GL_DISPATCH_INDIRECT_BUFFER_BINDING = 0x90EF;
    public static final int GL_COMPUTE_SHADER_BIT = 0x00000020;
    public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS = 0x8242;
    public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH = 0x8243;
    public static final int GL_DEBUG_CALLBACK_FUNCTION = 0x8244;
    public static final int GL_DEBUG_CALLBACK_USER_PARAM = 0x8245;
    public static final int GL_DEBUG_SOURCE_API = 0x8246;
    public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM = 0x8247;
    public static final int GL_DEBUG_SOURCE_SHADER_COMPILER = 0x8248;
    public static final int GL_DEBUG_SOURCE_THIRD_PARTY = 0x8249;
    public static final int GL_DEBUG_SOURCE_APPLICATION = 0x824A;
    public static final int GL_DEBUG_SOURCE_OTHER = 0x824B;
    public static final int GL_DEBUG_TYPE_ERROR = 0x824C;
    public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 0x824D;
    public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 0x824E;
    public static final int GL_DEBUG_TYPE_PORTABILITY = 0x824F;
    public static final int GL_DEBUG_TYPE_PERFORMANCE = 0x8250;
    public static final int GL_DEBUG_TYPE_OTHER = 0x8251;
    public static final int GL_MAX_DEBUG_MESSAGE_LENGTH = 0x9143;
    public static final int GL_MAX_DEBUG_LOGGED_MESSAGES = 0x9144;
    public static final int GL_DEBUG_LOGGED_MESSAGES = 0x9145;
    public static final int GL_DEBUG_SEVERITY_HIGH = 0x9146;
    public static final int GL_DEBUG_SEVERITY_MEDIUM = 0x9147;
    public static final int GL_DEBUG_SEVERITY_LOW = 0x9148;
    public static final int GL_DEBUG_TYPE_MARKER = 0x8268;
    public static final int GL_DEBUG_TYPE_PUSH_GROUP = 0x8269;
    public static final int GL_DEBUG_TYPE_POP_GROUP = 0x826A;
    public static final int GL_DEBUG_SEVERITY_NOTIFICATION = 0x826B;
    public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH = 0x826C;
    public static final int GL_DEBUG_GROUP_STACK_DEPTH = 0x826D;
    public static final int GL_BUFFER = 0x82E0;
    public static final int GL_SHADER = 0x82E1;
    public static final int GL_PROGRAM = 0x82E2;
    public static final int GL_VERTEX_ARRAY = 0x8074;
    public static final int GL_QUERY = 0x82E3;
    public static final int GL_PROGRAM_PIPELINE = 0x82E4;
    public static final int GL_SAMPLER = 0x82E6;
    public static final int GL_MAX_LABEL_LENGTH = 0x82E8;
    public static final int GL_DEBUG_OUTPUT = 0x92E0;
    public static final int GL_CONTEXT_FLAG_DEBUG_BIT = 0x00000002;
    public static final int GL_MAX_UNIFORM_LOCATIONS = 0x826E;
    public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 0x9310;
    public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 0x9311;
    public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 0x9312;
    public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 0x9313;
    public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 0x9314;
    public static final int GL_MAX_FRAMEBUFFER_WIDTH = 0x9315;
    public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 0x9316;
    public static final int GL_MAX_FRAMEBUFFER_LAYERS = 0x9317;
    public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 0x9318;
    public static final int GL_INTERNALFORMAT_SUPPORTED = 0x826F;
    public static final int GL_INTERNALFORMAT_PREFERRED = 0x8270;
    public static final int GL_INTERNALFORMAT_RED_SIZE = 0x8271;
    public static final int GL_INTERNALFORMAT_GREEN_SIZE = 0x8272;
    public static final int GL_INTERNALFORMAT_BLUE_SIZE = 0x8273;
    public static final int GL_INTERNALFORMAT_ALPHA_SIZE = 0x8274;
    public static final int GL_INTERNALFORMAT_DEPTH_SIZE = 0x8275;
    public static final int GL_INTERNALFORMAT_STENCIL_SIZE = 0x8276;
    public static final int GL_INTERNALFORMAT_SHARED_SIZE = 0x8277;
    public static final int GL_INTERNALFORMAT_RED_TYPE = 0x8278;
    public static final int GL_INTERNALFORMAT_GREEN_TYPE = 0x8279;
    public static final int GL_INTERNALFORMAT_BLUE_TYPE = 0x827A;
    public static final int GL_INTERNALFORMAT_ALPHA_TYPE = 0x827B;
    public static final int GL_INTERNALFORMAT_DEPTH_TYPE = 0x827C;
    public static final int GL_INTERNALFORMAT_STENCIL_TYPE = 0x827D;
    public static final int GL_MAX_WIDTH = 0x827E;
    public static final int GL_MAX_HEIGHT = 0x827F;
    public static final int GL_MAX_DEPTH = 0x8280;
    public static final int GL_MAX_LAYERS = 0x8281;
    public static final int GL_MAX_COMBINED_DIMENSIONS = 0x8282;
    public static final int GL_COLOR_COMPONENTS = 0x8283;
    public static final int GL_DEPTH_COMPONENTS = 0x8284;
    public static final int GL_STENCIL_COMPONENTS = 0x8285;
    public static final int GL_COLOR_RENDERABLE = 0x8286;
    public static final int GL_DEPTH_RENDERABLE = 0x8287;
    public static final int GL_STENCIL_RENDERABLE = 0x8288;
    public static final int GL_FRAMEBUFFER_RENDERABLE = 0x8289;
    public static final int GL_FRAMEBUFFER_RENDERABLE_LAYERED = 0x828A;
    public static final int GL_FRAMEBUFFER_BLEND = 0x828B;
    public static final int GL_READ_PIXELS = 0x828C;
    public static final int GL_READ_PIXELS_FORMAT = 0x828D;
    public static final int GL_READ_PIXELS_TYPE = 0x828E;
    public static final int GL_TEXTURE_IMAGE_FORMAT = 0x828F;
    public static final int GL_TEXTURE_IMAGE_TYPE = 0x8290;
    public static final int GL_GET_TEXTURE_IMAGE_FORMAT = 0x8291;
    public static final int GL_GET_TEXTURE_IMAGE_TYPE = 0x8292;
    public static final int GL_MIPMAP = 0x8293;
    public static final int GL_MANUAL_GENERATE_MIPMAP = 0x8294;
    public static final int GL_AUTO_GENERATE_MIPMAP = 0x8295;
    public static final int GL_COLOR_ENCODING = 0x8296;
    public static final int GL_SRGB_READ = 0x8297;
    public static final int GL_SRGB_WRITE = 0x8298;
    public static final int GL_FILTER = 0x829A;
    public static final int GL_VERTEX_TEXTURE = 0x829B;
    public static final int GL_TESS_CONTROL_TEXTURE = 0x829C;
    public static final int GL_TESS_EVALUATION_TEXTURE = 0x829D;
    public static final int GL_GEOMETRY_TEXTURE = 0x829E;
    public static final int GL_FRAGMENT_TEXTURE = 0x829F;
    public static final int GL_COMPUTE_TEXTURE = 0x82A0;
    public static final int GL_TEXTURE_SHADOW = 0x82A1;
    public static final int GL_TEXTURE_GATHER = 0x82A2;
    public static final int GL_TEXTURE_GATHER_SHADOW = 0x82A3;
    public static final int GL_SHADER_IMAGE_LOAD = 0x82A4;
    public static final int GL_SHADER_IMAGE_STORE = 0x82A5;
    public static final int GL_SHADER_IMAGE_ATOMIC = 0x82A6;
    public static final int GL_IMAGE_TEXEL_SIZE = 0x82A7;
    public static final int GL_IMAGE_COMPATIBILITY_CLASS = 0x82A8;
    public static final int GL_IMAGE_PIXEL_FORMAT = 0x82A9;
    public static final int GL_IMAGE_PIXEL_TYPE = 0x82AA;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_TEST = 0x82AC;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_TEST = 0x82AD;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_WRITE = 0x82AE;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_WRITE = 0x82AF;
    public static final int GL_TEXTURE_COMPRESSED_BLOCK_WIDTH = 0x82B1;
    public static final int GL_TEXTURE_COMPRESSED_BLOCK_HEIGHT = 0x82B2;
    public static final int GL_TEXTURE_COMPRESSED_BLOCK_SIZE = 0x82B3;
    public static final int GL_CLEAR_BUFFER = 0x82B4;
    public static final int GL_TEXTURE_VIEW = 0x82B5;
    public static final int GL_VIEW_COMPATIBILITY_CLASS = 0x82B6;
    public static final int GL_FULL_SUPPORT = 0x82B7;
    public static final int GL_CAVEAT_SUPPORT = 0x82B8;
    public static final int GL_IMAGE_CLASS_4_X_32 = 0x82B9;
    public static final int GL_IMAGE_CLASS_2_X_32 = 0x82BA;
    public static final int GL_IMAGE_CLASS_1_X_32 = 0x82BB;
    public static final int GL_IMAGE_CLASS_4_X_16 = 0x82BC;
    public static final int GL_IMAGE_CLASS_2_X_16 = 0x82BD;
    public static final int GL_IMAGE_CLASS_1_X_16 = 0x82BE;
    public static final int GL_IMAGE_CLASS_4_X_8 = 0x82BF;
    public static final int GL_IMAGE_CLASS_2_X_8 = 0x82C0;
    public static final int GL_IMAGE_CLASS_1_X_8 = 0x82C1;
    public static final int GL_IMAGE_CLASS_11_11_10 = 0x82C2;
    public static final int GL_IMAGE_CLASS_10_10_10_2 = 0x82C3;
    public static final int GL_VIEW_CLASS_128_BITS = 0x82C4;
    public static final int GL_VIEW_CLASS_96_BITS = 0x82C5;
    public static final int GL_VIEW_CLASS_64_BITS = 0x82C6;
    public static final int GL_VIEW_CLASS_48_BITS = 0x82C7;
    public static final int GL_VIEW_CLASS_32_BITS = 0x82C8;
    public static final int GL_VIEW_CLASS_24_BITS = 0x82C9;
    public static final int GL_VIEW_CLASS_16_BITS = 0x82CA;
    public static final int GL_VIEW_CLASS_8_BITS = 0x82CB;
    public static final int GL_VIEW_CLASS_S3TC_DXT1_RGB = 0x82CC;
    public static final int GL_VIEW_CLASS_S3TC_DXT1_RGBA = 0x82CD;
    public static final int GL_VIEW_CLASS_S3TC_DXT3_RGBA = 0x82CE;
    public static final int GL_VIEW_CLASS_S3TC_DXT5_RGBA = 0x82CF;
    public static final int GL_VIEW_CLASS_RGTC1_RED = 0x82D0;
    public static final int GL_VIEW_CLASS_RGTC2_RG = 0x82D1;
    public static final int GL_VIEW_CLASS_BPTC_UNORM = 0x82D2;
    public static final int GL_VIEW_CLASS_BPTC_FLOAT = 0x82D3;
    public static final int GL_UNIFORM = 0x92E1;
    public static final int GL_UNIFORM_BLOCK = 0x92E2;
    public static final int GL_PROGRAM_INPUT = 0x92E3;
    public static final int GL_PROGRAM_OUTPUT = 0x92E4;
    public static final int GL_BUFFER_VARIABLE = 0x92E5;
    public static final int GL_SHADER_STORAGE_BLOCK = 0x92E6;
    public static final int GL_VERTEX_SUBROUTINE = 0x92E8;
    public static final int GL_TESS_CONTROL_SUBROUTINE = 0x92E9;
    public static final int GL_TESS_EVALUATION_SUBROUTINE = 0x92EA;
    public static final int GL_GEOMETRY_SUBROUTINE = 0x92EB;
    public static final int GL_FRAGMENT_SUBROUTINE = 0x92EC;
    public static final int GL_COMPUTE_SUBROUTINE = 0x92ED;
    public static final int GL_VERTEX_SUBROUTINE_UNIFORM = 0x92EE;
    public static final int GL_TESS_CONTROL_SUBROUTINE_UNIFORM = 0x92EF;
    public static final int GL_TESS_EVALUATION_SUBROUTINE_UNIFORM = 0x92F0;
    public static final int GL_GEOMETRY_SUBROUTINE_UNIFORM = 0x92F1;
    public static final int GL_FRAGMENT_SUBROUTINE_UNIFORM = 0x92F2;
    public static final int GL_COMPUTE_SUBROUTINE_UNIFORM = 0x92F3;
    public static final int GL_TRANSFORM_FEEDBACK_VARYING = 0x92F4;
    public static final int GL_ACTIVE_RESOURCES = 0x92F5;
    public static final int GL_MAX_NAME_LENGTH = 0x92F6;
    public static final int GL_MAX_NUM_ACTIVE_VARIABLES = 0x92F7;
    public static final int GL_MAX_NUM_COMPATIBLE_SUBROUTINES = 0x92F8;
    public static final int GL_NAME_LENGTH = 0x92F9;
    public static final int GL_TYPE = 0x92FA;
    public static final int GL_ARRAY_SIZE = 0x92FB;
    public static final int GL_OFFSET = 0x92FC;
    public static final int GL_BLOCK_INDEX = 0x92FD;
    public static final int GL_ARRAY_STRIDE = 0x92FE;
    public static final int GL_MATRIX_STRIDE = 0x92FF;
    public static final int GL_IS_ROW_MAJOR = 0x9300;
    public static final int GL_ATOMIC_COUNTER_BUFFER_INDEX = 0x9301;
    public static final int GL_BUFFER_BINDING = 0x9302;
    public static final int GL_BUFFER_DATA_SIZE = 0x9303;
    public static final int GL_NUM_ACTIVE_VARIABLES = 0x9304;
    public static final int GL_ACTIVE_VARIABLES = 0x9305;
    public static final int GL_REFERENCED_BY_VERTEX_SHADER = 0x9306;
    public static final int GL_REFERENCED_BY_TESS_CONTROL_SHADER = 0x9307;
    public static final int GL_REFERENCED_BY_TESS_EVALUATION_SHADER = 0x9308;
    public static final int GL_REFERENCED_BY_GEOMETRY_SHADER = 0x9309;
    public static final int GL_REFERENCED_BY_FRAGMENT_SHADER = 0x930A;
    public static final int GL_REFERENCED_BY_COMPUTE_SHADER = 0x930B;
    public static final int GL_TOP_LEVEL_ARRAY_SIZE = 0x930C;
    public static final int GL_TOP_LEVEL_ARRAY_STRIDE = 0x930D;
    public static final int GL_LOCATION = 0x930E;
    public static final int GL_LOCATION_INDEX = 0x930F;
    public static final int GL_IS_PER_PATCH = 0x92E7;
    public static final int GL_SHADER_STORAGE_BUFFER = 0x90D2;
    public static final int GL_SHADER_STORAGE_BUFFER_BINDING = 0x90D3;
    public static final int GL_SHADER_STORAGE_BUFFER_START = 0x90D4;
    public static final int GL_SHADER_STORAGE_BUFFER_SIZE = 0x90D5;
    public static final int GL_MAX_VERTEX_SHADER_STORAGE_BLOCKS = 0x90D6;
    public static final int GL_MAX_GEOMETRY_SHADER_STORAGE_BLOCKS = 0x90D7;
    public static final int GL_MAX_TESS_CONTROL_SHADER_STORAGE_BLOCKS = 0x90D8;
    public static final int GL_MAX_TESS_EVALUATION_SHADER_STORAGE_BLOCKS = 0x90D9;
    public static final int GL_MAX_FRAGMENT_SHADER_STORAGE_BLOCKS = 0x90DA;
    public static final int GL_MAX_COMPUTE_SHADER_STORAGE_BLOCKS = 0x90DB;
    public static final int GL_MAX_COMBINED_SHADER_STORAGE_BLOCKS = 0x90DC;
    public static final int GL_MAX_SHADER_STORAGE_BUFFER_BINDINGS = 0x90DD;
    public static final int GL_MAX_SHADER_STORAGE_BLOCK_SIZE = 0x90DE;
    public static final int GL_SHADER_STORAGE_BUFFER_OFFSET_ALIGNMENT = 0x90DF;
    public static final int GL_SHADER_STORAGE_BARRIER_BIT = 0x00002000;
    public static final int GL_MAX_COMBINED_SHADER_OUTPUT_RESOURCES = 0x8F39;
    public static final int GL_DEPTH_STENCIL_TEXTURE_MODE = 0x90EA;
    public static final int GL_TEXTURE_BUFFER_OFFSET = 0x919D;
    public static final int GL_TEXTURE_BUFFER_SIZE = 0x919E;
    public static final int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT = 0x919F;
    public static final int GL_TEXTURE_VIEW_MIN_LEVEL = 0x82DB;
    public static final int GL_TEXTURE_VIEW_NUM_LEVELS = 0x82DC;
    public static final int GL_TEXTURE_VIEW_MIN_LAYER = 0x82DD;
    public static final int GL_TEXTURE_VIEW_NUM_LAYERS = 0x82DE;
    public static final int GL_TEXTURE_IMMUTABLE_LEVELS = 0x82DF;
    public static final int GL_VERTEX_ATTRIB_BINDING = 0x82D4;
    public static final int GL_VERTEX_ATTRIB_RELATIVE_OFFSET = 0x82D5;
    public static final int GL_VERTEX_BINDING_DIVISOR = 0x82D6;
    public static final int GL_VERTEX_BINDING_OFFSET = 0x82D7;
    public static final int GL_VERTEX_BINDING_STRIDE = 0x82D8;
    public static final int GL_MAX_VERTEX_ATTRIB_RELATIVE_OFFSET = 0x82D9;
    public static final int GL_MAX_VERTEX_ATTRIB_BINDINGS = 0x82DA;
    public static final int GL_VERTEX_BINDING_BUFFER = 0x8F4F;
    public static final int GL_STACK_UNDERFLOW = 0x0504;
    public static final int GL_STACK_OVERFLOW = 0x0503;
    public static final MethodHandle MH_glClearBufferData = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glClearBufferData;
    public static final MethodHandle MH_glClearBufferSubData = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glClearBufferSubData;
    public static final MethodHandle MH_glDispatchCompute = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glDispatchCompute;
    public static final MethodHandle MH_glDispatchComputeIndirect = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glDispatchComputeIndirect;
    public static final MethodHandle MH_glCopyImageSubData = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glCopyImageSubData;
    public static final MethodHandle MH_glFramebufferParameteri = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glFramebufferParameteri;
    public static final MethodHandle MH_glGetFramebufferParameteriv = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetFramebufferParameteriv;
    public static final MethodHandle MH_glGetInternalformati64v = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetInternalformati64v;
    public static final MethodHandle MH_glInvalidateTexSubImage = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glInvalidateTexSubImage;
    public static final MethodHandle MH_glInvalidateTexImage = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glInvalidateTexImage;
    public static final MethodHandle MH_glInvalidateBufferSubData = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glInvalidateBufferSubData;
    public static final MethodHandle MH_glInvalidateBufferData = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glInvalidateBufferData;
    public static final MethodHandle MH_glInvalidateFramebuffer = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glInvalidateFramebuffer;
    public static final MethodHandle MH_glInvalidateSubFramebuffer = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glInvalidateSubFramebuffer;
    public static final MethodHandle MH_glMultiDrawArraysIndirect = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glMultiDrawArraysIndirect;
    public static final MethodHandle MH_glMultiDrawElementsIndirect = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glMultiDrawElementsIndirect;
    public static final MethodHandle MH_glGetProgramInterfaceiv = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetProgramInterfaceiv;
    public static final MethodHandle MH_glGetProgramResourceIndex = RuntimeHelper.downcall(FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetProgramResourceIndex;
    public static final MethodHandle MH_glGetProgramResourceName = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetProgramResourceName;
    public static final MethodHandle MH_glGetProgramResourceiv = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetProgramResourceiv;
    public static final MethodHandle MH_glGetProgramResourceLocation = RuntimeHelper.downcall(FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetProgramResourceLocation;
    public static final MethodHandle MH_glGetProgramResourceLocationIndex = RuntimeHelper.downcall(FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetProgramResourceLocationIndex;
    public static final MethodHandle MH_glShaderStorageBlockBinding = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glShaderStorageBlockBinding;
    public static final MethodHandle MH_glTexBufferRange = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
    public final MemorySegment PFN_glTexBufferRange;
    public static final MethodHandle MH_glTexStorage2DMultisample = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_BOOLEAN));
    public final MemorySegment PFN_glTexStorage2DMultisample;
    public static final MethodHandle MH_glTexStorage3DMultisample = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_BOOLEAN));
    public final MemorySegment PFN_glTexStorage3DMultisample;
    public static final MethodHandle MH_glTextureView = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glTextureView;
    public static final MethodHandle MH_glBindVertexBuffer = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glBindVertexBuffer;
    public static final MethodHandle MH_glVertexAttribFormat = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_BOOLEAN, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glVertexAttribFormat;
    public static final MethodHandle MH_glVertexAttribIFormat = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glVertexAttribIFormat;
    public static final MethodHandle MH_glVertexAttribLFormat = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glVertexAttribLFormat;
    public static final MethodHandle MH_glVertexAttribBinding = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glVertexAttribBinding;
    public static final MethodHandle MH_glVertexBindingDivisor = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
    public final MemorySegment PFN_glVertexBindingDivisor;
    public static final MethodHandle MH_glDebugMessageControl = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.JAVA_BOOLEAN));
    public final MemorySegment PFN_glDebugMessageControl;
    public static final MethodHandle MH_glDebugMessageInsert = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glDebugMessageInsert;
    public static final MethodHandle MH_glDebugMessageCallback = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glDebugMessageCallback;
    public static final MethodHandle MH_glGetDebugMessageLog = RuntimeHelper.downcall(FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetDebugMessageLog;
    public static final MethodHandle MH_glPushDebugGroup = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glPushDebugGroup;
    public static final MethodHandle MH_glPopDebugGroup = RuntimeHelper.downcall(FunctionDescriptor.ofVoid());
    public final MemorySegment PFN_glPopDebugGroup;
    public static final MethodHandle MH_glObjectLabel = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glObjectLabel;
    public static final MethodHandle MH_glGetObjectLabel = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetObjectLabel;
    public static final MethodHandle MH_glObjectPtrLabel = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glObjectPtrLabel;
    public static final MethodHandle MH_glGetObjectPtrLabel = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetObjectPtrLabel;
    public static final MethodHandle MH_glGetPointerv = RuntimeHelper.downcall(FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS));
    public final MemorySegment PFN_glGetPointerv;

    public GL43(GLLoadFunc func) {
        super(func);
        PFN_glClearBufferData = func.invoke("glClearBufferData");
        PFN_glClearBufferSubData = func.invoke("glClearBufferSubData");
        PFN_glDispatchCompute = func.invoke("glDispatchCompute");
        PFN_glDispatchComputeIndirect = func.invoke("glDispatchComputeIndirect");
        PFN_glCopyImageSubData = func.invoke("glCopyImageSubData", "glCopyImageSubDataEXT", "glCopyImageSubDataOES");
        PFN_glFramebufferParameteri = func.invoke("glFramebufferParameteri");
        PFN_glGetFramebufferParameteriv = func.invoke("glGetFramebufferParameteriv");
        PFN_glGetInternalformati64v = func.invoke("glGetInternalformati64v");
        PFN_glInvalidateTexSubImage = func.invoke("glInvalidateTexSubImage");
        PFN_glInvalidateTexImage = func.invoke("glInvalidateTexImage");
        PFN_glInvalidateBufferSubData = func.invoke("glInvalidateBufferSubData");
        PFN_glInvalidateBufferData = func.invoke("glInvalidateBufferData");
        PFN_glInvalidateFramebuffer = func.invoke("glInvalidateFramebuffer");
        PFN_glInvalidateSubFramebuffer = func.invoke("glInvalidateSubFramebuffer");
        PFN_glMultiDrawArraysIndirect = func.invoke("glMultiDrawArraysIndirect", "glMultiDrawArraysIndirectAMD", "glMultiDrawArraysIndirectEXT");
        PFN_glMultiDrawElementsIndirect = func.invoke("glMultiDrawElementsIndirect", "glMultiDrawElementsIndirectAMD", "glMultiDrawElementsIndirectEXT");
        PFN_glGetProgramInterfaceiv = func.invoke("glGetProgramInterfaceiv");
        PFN_glGetProgramResourceIndex = func.invoke("glGetProgramResourceIndex");
        PFN_glGetProgramResourceName = func.invoke("glGetProgramResourceName");
        PFN_glGetProgramResourceiv = func.invoke("glGetProgramResourceiv");
        PFN_glGetProgramResourceLocation = func.invoke("glGetProgramResourceLocation");
        PFN_glGetProgramResourceLocationIndex = func.invoke("glGetProgramResourceLocationIndex");
        PFN_glShaderStorageBlockBinding = func.invoke("glShaderStorageBlockBinding");
        PFN_glTexBufferRange = func.invoke("glTexBufferRange", "glTexBufferRangeEXT", "glTexBufferRangeOES");
        PFN_glTexStorage2DMultisample = func.invoke("glTexStorage2DMultisample");
        PFN_glTexStorage3DMultisample = func.invoke("glTexStorage3DMultisample", "glTexStorage3DMultisampleOES");
        PFN_glTextureView = func.invoke("glTextureView", "glTextureViewEXT", "glTextureViewOES");
        PFN_glBindVertexBuffer = func.invoke("glBindVertexBuffer");
        PFN_glVertexAttribFormat = func.invoke("glVertexAttribFormat");
        PFN_glVertexAttribIFormat = func.invoke("glVertexAttribIFormat");
        PFN_glVertexAttribLFormat = func.invoke("glVertexAttribLFormat");
        PFN_glVertexAttribBinding = func.invoke("glVertexAttribBinding");
        PFN_glVertexBindingDivisor = func.invoke("glVertexBindingDivisor");
        PFN_glDebugMessageControl = func.invoke("glDebugMessageControl", "glDebugMessageControlARB", "glDebugMessageControlKHR");
        PFN_glDebugMessageInsert = func.invoke("glDebugMessageInsert", "glDebugMessageInsertARB", "glDebugMessageInsertKHR");
        PFN_glDebugMessageCallback = func.invoke("glDebugMessageCallback", "glDebugMessageCallbackARB", "glDebugMessageCallbackKHR");
        PFN_glGetDebugMessageLog = func.invoke("glGetDebugMessageLog", "glGetDebugMessageLogARB", "glGetDebugMessageLogKHR");
        PFN_glPushDebugGroup = func.invoke("glPushDebugGroup", "glPushDebugGroupKHR");
        PFN_glPopDebugGroup = func.invoke("glPopDebugGroup", "glPopDebugGroupKHR");
        PFN_glObjectLabel = func.invoke("glObjectLabel", "glObjectLabelKHR");
        PFN_glGetObjectLabel = func.invoke("glGetObjectLabel", "glGetObjectLabelKHR");
        PFN_glObjectPtrLabel = func.invoke("glObjectPtrLabel", "glObjectPtrLabelKHR");
        PFN_glGetObjectPtrLabel = func.invoke("glGetObjectPtrLabel", "glGetObjectPtrLabelKHR");
        PFN_glGetPointerv = func.invoke("glGetPointerv", "glGetPointervEXT", "glGetPointervKHR");
    }

    public void ClearBufferData(@CType("GLenum") int target, @CType("GLenum") int internalformat, @CType("GLenum") int format, @CType("GLenum") int type, @CType("const void *") java.lang.foreign.MemorySegment data) {
        if (!Unmarshal.isNullPointer(PFN_glClearBufferData)) { try {
            MH_glClearBufferData.invokeExact(PFN_glClearBufferData, target, internalformat, format, type, data);
        } catch (Throwable e) { throw new RuntimeException("error in glClearBufferData", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glClearBufferData"); }
    }

    public void ClearBufferSubData(@CType("GLenum") int target, @CType("GLenum") int internalformat, @CType("GLintptr") long offset, @CType("GLsizeiptr") long size, @CType("GLenum") int format, @CType("GLenum") int type, @CType("const void *") java.lang.foreign.MemorySegment data) {
        if (!Unmarshal.isNullPointer(PFN_glClearBufferSubData)) { try {
            MH_glClearBufferSubData.invokeExact(PFN_glClearBufferSubData, target, internalformat, offset, size, format, type, data);
        } catch (Throwable e) { throw new RuntimeException("error in glClearBufferSubData", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glClearBufferSubData"); }
    }

    public void DispatchCompute(@CType("GLuint") int num_groups_x, @CType("GLuint") int num_groups_y, @CType("GLuint") int num_groups_z) {
        if (!Unmarshal.isNullPointer(PFN_glDispatchCompute)) { try {
            MH_glDispatchCompute.invokeExact(PFN_glDispatchCompute, num_groups_x, num_groups_y, num_groups_z);
        } catch (Throwable e) { throw new RuntimeException("error in glDispatchCompute", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDispatchCompute"); }
    }

    public void DispatchComputeIndirect(@CType("GLintptr") long indirect) {
        if (!Unmarshal.isNullPointer(PFN_glDispatchComputeIndirect)) { try {
            MH_glDispatchComputeIndirect.invokeExact(PFN_glDispatchComputeIndirect, indirect);
        } catch (Throwable e) { throw new RuntimeException("error in glDispatchComputeIndirect", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDispatchComputeIndirect"); }
    }

    public void CopyImageSubData(@CType("GLuint") int srcName, @CType("GLenum") int srcTarget, @CType("GLint") int srcLevel, @CType("GLint") int srcX, @CType("GLint") int srcY, @CType("GLint") int srcZ, @CType("GLuint") int dstName, @CType("GLenum") int dstTarget, @CType("GLint") int dstLevel, @CType("GLint") int dstX, @CType("GLint") int dstY, @CType("GLint") int dstZ, @CType("GLsizei") int srcWidth, @CType("GLsizei") int srcHeight, @CType("GLsizei") int srcDepth) {
        if (!Unmarshal.isNullPointer(PFN_glCopyImageSubData)) { try {
            MH_glCopyImageSubData.invokeExact(PFN_glCopyImageSubData, srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth);
        } catch (Throwable e) { throw new RuntimeException("error in glCopyImageSubData", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glCopyImageSubData"); }
    }

    public void FramebufferParameteri(@CType("GLenum") int target, @CType("GLenum") int pname, @CType("GLint") int param) {
        if (!Unmarshal.isNullPointer(PFN_glFramebufferParameteri)) { try {
            MH_glFramebufferParameteri.invokeExact(PFN_glFramebufferParameteri, target, pname, param);
        } catch (Throwable e) { throw new RuntimeException("error in glFramebufferParameteri", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glFramebufferParameteri"); }
    }

    public void GetFramebufferParameteriv(@CType("GLenum") int target, @CType("GLenum") int pname, @CType("GLint *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetFramebufferParameteriv)) { try {
            MH_glGetFramebufferParameteriv.invokeExact(PFN_glGetFramebufferParameteriv, target, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetFramebufferParameteriv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetFramebufferParameteriv"); }
    }

    public void GetInternalformati64v(@CType("GLenum") int target, @CType("GLenum") int internalformat, @CType("GLenum") int pname, @CType("GLsizei") int count, @CType("GLint64 *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetInternalformati64v)) { try {
            MH_glGetInternalformati64v.invokeExact(PFN_glGetInternalformati64v, target, internalformat, pname, count, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetInternalformati64v", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetInternalformati64v"); }
    }

    public void InvalidateTexSubImage(@CType("GLuint") int texture, @CType("GLint") int level, @CType("GLint") int xoffset, @CType("GLint") int yoffset, @CType("GLint") int zoffset, @CType("GLsizei") int width, @CType("GLsizei") int height, @CType("GLsizei") int depth) {
        if (!Unmarshal.isNullPointer(PFN_glInvalidateTexSubImage)) { try {
            MH_glInvalidateTexSubImage.invokeExact(PFN_glInvalidateTexSubImage, texture, level, xoffset, yoffset, zoffset, width, height, depth);
        } catch (Throwable e) { throw new RuntimeException("error in glInvalidateTexSubImage", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glInvalidateTexSubImage"); }
    }

    public void InvalidateTexImage(@CType("GLuint") int texture, @CType("GLint") int level) {
        if (!Unmarshal.isNullPointer(PFN_glInvalidateTexImage)) { try {
            MH_glInvalidateTexImage.invokeExact(PFN_glInvalidateTexImage, texture, level);
        } catch (Throwable e) { throw new RuntimeException("error in glInvalidateTexImage", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glInvalidateTexImage"); }
    }

    public void InvalidateBufferSubData(@CType("GLuint") int buffer, @CType("GLintptr") long offset, @CType("GLsizeiptr") long length) {
        if (!Unmarshal.isNullPointer(PFN_glInvalidateBufferSubData)) { try {
            MH_glInvalidateBufferSubData.invokeExact(PFN_glInvalidateBufferSubData, buffer, offset, length);
        } catch (Throwable e) { throw new RuntimeException("error in glInvalidateBufferSubData", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glInvalidateBufferSubData"); }
    }

    public void InvalidateBufferData(@CType("GLuint") int buffer) {
        if (!Unmarshal.isNullPointer(PFN_glInvalidateBufferData)) { try {
            MH_glInvalidateBufferData.invokeExact(PFN_glInvalidateBufferData, buffer);
        } catch (Throwable e) { throw new RuntimeException("error in glInvalidateBufferData", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glInvalidateBufferData"); }
    }

    public void InvalidateFramebuffer(@CType("GLenum") int target, @CType("GLsizei") int numAttachments, @CType("const GLenum *") java.lang.foreign.MemorySegment attachments) {
        if (!Unmarshal.isNullPointer(PFN_glInvalidateFramebuffer)) { try {
            MH_glInvalidateFramebuffer.invokeExact(PFN_glInvalidateFramebuffer, target, numAttachments, attachments);
        } catch (Throwable e) { throw new RuntimeException("error in glInvalidateFramebuffer", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glInvalidateFramebuffer"); }
    }

    public void InvalidateSubFramebuffer(@CType("GLenum") int target, @CType("GLsizei") int numAttachments, @CType("const GLenum *") java.lang.foreign.MemorySegment attachments, @CType("GLint") int x, @CType("GLint") int y, @CType("GLsizei") int width, @CType("GLsizei") int height) {
        if (!Unmarshal.isNullPointer(PFN_glInvalidateSubFramebuffer)) { try {
            MH_glInvalidateSubFramebuffer.invokeExact(PFN_glInvalidateSubFramebuffer, target, numAttachments, attachments, x, y, width, height);
        } catch (Throwable e) { throw new RuntimeException("error in glInvalidateSubFramebuffer", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glInvalidateSubFramebuffer"); }
    }

    public void MultiDrawArraysIndirect(@CType("GLenum") int mode, @CType("const void *") java.lang.foreign.MemorySegment indirect, @CType("GLsizei") int drawcount, @CType("GLsizei") int stride) {
        if (!Unmarshal.isNullPointer(PFN_glMultiDrawArraysIndirect)) { try {
            MH_glMultiDrawArraysIndirect.invokeExact(PFN_glMultiDrawArraysIndirect, mode, indirect, drawcount, stride);
        } catch (Throwable e) { throw new RuntimeException("error in glMultiDrawArraysIndirect", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glMultiDrawArraysIndirect"); }
    }

    public void MultiDrawElementsIndirect(@CType("GLenum") int mode, @CType("GLenum") int type, @CType("const void *") java.lang.foreign.MemorySegment indirect, @CType("GLsizei") int drawcount, @CType("GLsizei") int stride) {
        if (!Unmarshal.isNullPointer(PFN_glMultiDrawElementsIndirect)) { try {
            MH_glMultiDrawElementsIndirect.invokeExact(PFN_glMultiDrawElementsIndirect, mode, type, indirect, drawcount, stride);
        } catch (Throwable e) { throw new RuntimeException("error in glMultiDrawElementsIndirect", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glMultiDrawElementsIndirect"); }
    }

    public void GetProgramInterfaceiv(@CType("GLuint") int program, @CType("GLenum") int programInterface, @CType("GLenum") int pname, @CType("GLint *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetProgramInterfaceiv)) { try {
            MH_glGetProgramInterfaceiv.invokeExact(PFN_glGetProgramInterfaceiv, program, programInterface, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetProgramInterfaceiv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetProgramInterfaceiv"); }
    }

    public @CType("GLuint") int GetProgramResourceIndex(@CType("GLuint") int program, @CType("GLenum") int programInterface, @CType("const GLchar *") java.lang.foreign.MemorySegment name) {
        if (!Unmarshal.isNullPointer(PFN_glGetProgramResourceIndex)) { try {
            return (int) MH_glGetProgramResourceIndex.invokeExact(PFN_glGetProgramResourceIndex, program, programInterface, name);
        } catch (Throwable e) { throw new RuntimeException("error in glGetProgramResourceIndex", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetProgramResourceIndex"); }
    }

    public void GetProgramResourceName(@CType("GLuint") int program, @CType("GLenum") int programInterface, @CType("GLuint") int index, @CType("GLsizei") int bufSize, @CType("GLsizei *") java.lang.foreign.MemorySegment length, @CType("GLchar *") java.lang.foreign.MemorySegment name) {
        if (!Unmarshal.isNullPointer(PFN_glGetProgramResourceName)) { try {
            MH_glGetProgramResourceName.invokeExact(PFN_glGetProgramResourceName, program, programInterface, index, bufSize, length, name);
        } catch (Throwable e) { throw new RuntimeException("error in glGetProgramResourceName", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetProgramResourceName"); }
    }

    public void GetProgramResourceiv(@CType("GLuint") int program, @CType("GLenum") int programInterface, @CType("GLuint") int index, @CType("GLsizei") int propCount, @CType("const GLenum *") java.lang.foreign.MemorySegment props, @CType("GLsizei") int count, @CType("GLsizei *") java.lang.foreign.MemorySegment length, @CType("GLint *") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetProgramResourceiv)) { try {
            MH_glGetProgramResourceiv.invokeExact(PFN_glGetProgramResourceiv, program, programInterface, index, propCount, props, count, length, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetProgramResourceiv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetProgramResourceiv"); }
    }

    public @CType("GLint") int GetProgramResourceLocation(@CType("GLuint") int program, @CType("GLenum") int programInterface, @CType("const GLchar *") java.lang.foreign.MemorySegment name) {
        if (!Unmarshal.isNullPointer(PFN_glGetProgramResourceLocation)) { try {
            return (int) MH_glGetProgramResourceLocation.invokeExact(PFN_glGetProgramResourceLocation, program, programInterface, name);
        } catch (Throwable e) { throw new RuntimeException("error in glGetProgramResourceLocation", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetProgramResourceLocation"); }
    }

    public @CType("GLint") int GetProgramResourceLocationIndex(@CType("GLuint") int program, @CType("GLenum") int programInterface, @CType("const GLchar *") java.lang.foreign.MemorySegment name) {
        if (!Unmarshal.isNullPointer(PFN_glGetProgramResourceLocationIndex)) { try {
            return (int) MH_glGetProgramResourceLocationIndex.invokeExact(PFN_glGetProgramResourceLocationIndex, program, programInterface, name);
        } catch (Throwable e) { throw new RuntimeException("error in glGetProgramResourceLocationIndex", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetProgramResourceLocationIndex"); }
    }

    public void ShaderStorageBlockBinding(@CType("GLuint") int program, @CType("GLuint") int storageBlockIndex, @CType("GLuint") int storageBlockBinding) {
        if (!Unmarshal.isNullPointer(PFN_glShaderStorageBlockBinding)) { try {
            MH_glShaderStorageBlockBinding.invokeExact(PFN_glShaderStorageBlockBinding, program, storageBlockIndex, storageBlockBinding);
        } catch (Throwable e) { throw new RuntimeException("error in glShaderStorageBlockBinding", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glShaderStorageBlockBinding"); }
    }

    public void TexBufferRange(@CType("GLenum") int target, @CType("GLenum") int internalformat, @CType("GLuint") int buffer, @CType("GLintptr") long offset, @CType("GLsizeiptr") long size) {
        if (!Unmarshal.isNullPointer(PFN_glTexBufferRange)) { try {
            MH_glTexBufferRange.invokeExact(PFN_glTexBufferRange, target, internalformat, buffer, offset, size);
        } catch (Throwable e) { throw new RuntimeException("error in glTexBufferRange", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glTexBufferRange"); }
    }

    public void TexStorage2DMultisample(@CType("GLenum") int target, @CType("GLsizei") int samples, @CType("GLenum") int internalformat, @CType("GLsizei") int width, @CType("GLsizei") int height, @CType("GLboolean") boolean fixedsamplelocations) {
        if (!Unmarshal.isNullPointer(PFN_glTexStorage2DMultisample)) { try {
            MH_glTexStorage2DMultisample.invokeExact(PFN_glTexStorage2DMultisample, target, samples, internalformat, width, height, fixedsamplelocations);
        } catch (Throwable e) { throw new RuntimeException("error in glTexStorage2DMultisample", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glTexStorage2DMultisample"); }
    }

    public void TexStorage3DMultisample(@CType("GLenum") int target, @CType("GLsizei") int samples, @CType("GLenum") int internalformat, @CType("GLsizei") int width, @CType("GLsizei") int height, @CType("GLsizei") int depth, @CType("GLboolean") boolean fixedsamplelocations) {
        if (!Unmarshal.isNullPointer(PFN_glTexStorage3DMultisample)) { try {
            MH_glTexStorage3DMultisample.invokeExact(PFN_glTexStorage3DMultisample, target, samples, internalformat, width, height, depth, fixedsamplelocations);
        } catch (Throwable e) { throw new RuntimeException("error in glTexStorage3DMultisample", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glTexStorage3DMultisample"); }
    }

    public void TextureView(@CType("GLuint") int texture, @CType("GLenum") int target, @CType("GLuint") int origtexture, @CType("GLenum") int internalformat, @CType("GLuint") int minlevel, @CType("GLuint") int numlevels, @CType("GLuint") int minlayer, @CType("GLuint") int numlayers) {
        if (!Unmarshal.isNullPointer(PFN_glTextureView)) { try {
            MH_glTextureView.invokeExact(PFN_glTextureView, texture, target, origtexture, internalformat, minlevel, numlevels, minlayer, numlayers);
        } catch (Throwable e) { throw new RuntimeException("error in glTextureView", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glTextureView"); }
    }

    public void BindVertexBuffer(@CType("GLuint") int bindingindex, @CType("GLuint") int buffer, @CType("GLintptr") long offset, @CType("GLsizei") int stride) {
        if (!Unmarshal.isNullPointer(PFN_glBindVertexBuffer)) { try {
            MH_glBindVertexBuffer.invokeExact(PFN_glBindVertexBuffer, bindingindex, buffer, offset, stride);
        } catch (Throwable e) { throw new RuntimeException("error in glBindVertexBuffer", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glBindVertexBuffer"); }
    }

    public void VertexAttribFormat(@CType("GLuint") int attribindex, @CType("GLint") int size, @CType("GLenum") int type, @CType("GLboolean") boolean normalized, @CType("GLuint") int relativeoffset) {
        if (!Unmarshal.isNullPointer(PFN_glVertexAttribFormat)) { try {
            MH_glVertexAttribFormat.invokeExact(PFN_glVertexAttribFormat, attribindex, size, type, normalized, relativeoffset);
        } catch (Throwable e) { throw new RuntimeException("error in glVertexAttribFormat", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glVertexAttribFormat"); }
    }

    public void VertexAttribIFormat(@CType("GLuint") int attribindex, @CType("GLint") int size, @CType("GLenum") int type, @CType("GLuint") int relativeoffset) {
        if (!Unmarshal.isNullPointer(PFN_glVertexAttribIFormat)) { try {
            MH_glVertexAttribIFormat.invokeExact(PFN_glVertexAttribIFormat, attribindex, size, type, relativeoffset);
        } catch (Throwable e) { throw new RuntimeException("error in glVertexAttribIFormat", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glVertexAttribIFormat"); }
    }

    public void VertexAttribLFormat(@CType("GLuint") int attribindex, @CType("GLint") int size, @CType("GLenum") int type, @CType("GLuint") int relativeoffset) {
        if (!Unmarshal.isNullPointer(PFN_glVertexAttribLFormat)) { try {
            MH_glVertexAttribLFormat.invokeExact(PFN_glVertexAttribLFormat, attribindex, size, type, relativeoffset);
        } catch (Throwable e) { throw new RuntimeException("error in glVertexAttribLFormat", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glVertexAttribLFormat"); }
    }

    public void VertexAttribBinding(@CType("GLuint") int attribindex, @CType("GLuint") int bindingindex) {
        if (!Unmarshal.isNullPointer(PFN_glVertexAttribBinding)) { try {
            MH_glVertexAttribBinding.invokeExact(PFN_glVertexAttribBinding, attribindex, bindingindex);
        } catch (Throwable e) { throw new RuntimeException("error in glVertexAttribBinding", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glVertexAttribBinding"); }
    }

    public void VertexBindingDivisor(@CType("GLuint") int bindingindex, @CType("GLuint") int divisor) {
        if (!Unmarshal.isNullPointer(PFN_glVertexBindingDivisor)) { try {
            MH_glVertexBindingDivisor.invokeExact(PFN_glVertexBindingDivisor, bindingindex, divisor);
        } catch (Throwable e) { throw new RuntimeException("error in glVertexBindingDivisor", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glVertexBindingDivisor"); }
    }

    public void DebugMessageControl(@CType("GLenum") int source, @CType("GLenum") int type, @CType("GLenum") int severity, @CType("GLsizei") int count, @CType("const GLuint *") java.lang.foreign.MemorySegment ids, @CType("GLboolean") boolean enabled) {
        if (!Unmarshal.isNullPointer(PFN_glDebugMessageControl)) { try {
            MH_glDebugMessageControl.invokeExact(PFN_glDebugMessageControl, source, type, severity, count, ids, enabled);
        } catch (Throwable e) { throw new RuntimeException("error in glDebugMessageControl", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDebugMessageControl"); }
    }

    public void DebugMessageInsert(@CType("GLenum") int source, @CType("GLenum") int type, @CType("GLuint") int id, @CType("GLenum") int severity, @CType("GLsizei") int length, @CType("const GLchar *") java.lang.foreign.MemorySegment buf) {
        if (!Unmarshal.isNullPointer(PFN_glDebugMessageInsert)) { try {
            MH_glDebugMessageInsert.invokeExact(PFN_glDebugMessageInsert, source, type, id, severity, length, buf);
        } catch (Throwable e) { throw new RuntimeException("error in glDebugMessageInsert", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDebugMessageInsert"); }
    }

    public void DebugMessageCallback(@CType("GLDEBUGPROC") java.lang.foreign.MemorySegment callback, @CType("const void *") java.lang.foreign.MemorySegment userParam) {
        if (!Unmarshal.isNullPointer(PFN_glDebugMessageCallback)) { try {
            MH_glDebugMessageCallback.invokeExact(PFN_glDebugMessageCallback, callback, userParam);
        } catch (Throwable e) { throw new RuntimeException("error in glDebugMessageCallback", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glDebugMessageCallback"); }
    }

    public @CType("GLuint") int GetDebugMessageLog(@CType("GLuint") int count, @CType("GLsizei") int bufSize, @CType("GLenum *") java.lang.foreign.MemorySegment sources, @CType("GLenum *") java.lang.foreign.MemorySegment types, @CType("GLuint *") java.lang.foreign.MemorySegment ids, @CType("GLenum *") java.lang.foreign.MemorySegment severities, @CType("GLsizei *") java.lang.foreign.MemorySegment lengths, @CType("GLchar *") java.lang.foreign.MemorySegment messageLog) {
        if (!Unmarshal.isNullPointer(PFN_glGetDebugMessageLog)) { try {
            return (int) MH_glGetDebugMessageLog.invokeExact(PFN_glGetDebugMessageLog, count, bufSize, sources, types, ids, severities, lengths, messageLog);
        } catch (Throwable e) { throw new RuntimeException("error in glGetDebugMessageLog", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetDebugMessageLog"); }
    }

    public void PushDebugGroup(@CType("GLenum") int source, @CType("GLuint") int id, @CType("GLsizei") int length, @CType("const GLchar *") java.lang.foreign.MemorySegment message) {
        if (!Unmarshal.isNullPointer(PFN_glPushDebugGroup)) { try {
            MH_glPushDebugGroup.invokeExact(PFN_glPushDebugGroup, source, id, length, message);
        } catch (Throwable e) { throw new RuntimeException("error in glPushDebugGroup", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glPushDebugGroup"); }
    }

    public void PopDebugGroup() {
        if (!Unmarshal.isNullPointer(PFN_glPopDebugGroup)) { try {
            MH_glPopDebugGroup.invokeExact(PFN_glPopDebugGroup);
        } catch (Throwable e) { throw new RuntimeException("error in glPopDebugGroup", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glPopDebugGroup"); }
    }

    public void ObjectLabel(@CType("GLenum") int identifier, @CType("GLuint") int name, @CType("GLsizei") int length, @CType("const GLchar *") java.lang.foreign.MemorySegment label) {
        if (!Unmarshal.isNullPointer(PFN_glObjectLabel)) { try {
            MH_glObjectLabel.invokeExact(PFN_glObjectLabel, identifier, name, length, label);
        } catch (Throwable e) { throw new RuntimeException("error in glObjectLabel", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glObjectLabel"); }
    }

    public void GetObjectLabel(@CType("GLenum") int identifier, @CType("GLuint") int name, @CType("GLsizei") int bufSize, @CType("GLsizei *") java.lang.foreign.MemorySegment length, @CType("GLchar *") java.lang.foreign.MemorySegment label) {
        if (!Unmarshal.isNullPointer(PFN_glGetObjectLabel)) { try {
            MH_glGetObjectLabel.invokeExact(PFN_glGetObjectLabel, identifier, name, bufSize, length, label);
        } catch (Throwable e) { throw new RuntimeException("error in glGetObjectLabel", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetObjectLabel"); }
    }

    public void ObjectPtrLabel(@CType("const void *") java.lang.foreign.MemorySegment ptr, @CType("GLsizei") int length, @CType("const GLchar *") java.lang.foreign.MemorySegment label) {
        if (!Unmarshal.isNullPointer(PFN_glObjectPtrLabel)) { try {
            MH_glObjectPtrLabel.invokeExact(PFN_glObjectPtrLabel, ptr, length, label);
        } catch (Throwable e) { throw new RuntimeException("error in glObjectPtrLabel", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glObjectPtrLabel"); }
    }

    public void GetObjectPtrLabel(@CType("const void *") java.lang.foreign.MemorySegment ptr, @CType("GLsizei") int bufSize, @CType("GLsizei *") java.lang.foreign.MemorySegment length, @CType("GLchar *") java.lang.foreign.MemorySegment label) {
        if (!Unmarshal.isNullPointer(PFN_glGetObjectPtrLabel)) { try {
            MH_glGetObjectPtrLabel.invokeExact(PFN_glGetObjectPtrLabel, ptr, bufSize, length, label);
        } catch (Throwable e) { throw new RuntimeException("error in glGetObjectPtrLabel", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetObjectPtrLabel"); }
    }

    public void GetPointerv(@CType("GLenum") int pname, @CType("void **") java.lang.foreign.MemorySegment params) {
        if (!Unmarshal.isNullPointer(PFN_glGetPointerv)) { try {
            MH_glGetPointerv.invokeExact(PFN_glGetPointerv, pname, params);
        } catch (Throwable e) { throw new RuntimeException("error in glGetPointerv", e); }
        } else { throw new SymbolNotFoundError("Symbol not found: glGetPointerv"); }
    }

    // --- OverrunGL custom code ---
    public void DebugMessageCallback(Arena arena, @CType("GLDEBUGPROC") GLDebugProc callback, @CType("const void *") MemorySegment userParam) { DebugMessageCallback(Marshal.marshal(arena, callback), userParam); }
}
