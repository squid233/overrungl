/*
 * MIT License
 *
 * Copyright (c) 2022-2024 Overrun Organization
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
package overrungl.stb;

import java.lang.foreign.*;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.invoke.*;
import overrungl.annotation.*;
import overrungl.struct.*;
import overrungl.util.*;

/// ## Members
/// ### alloc_buffer
/// [VarHandle][#VH_alloc_buffer] - [Getter][#alloc_buffer()] - [Setter][#alloc_buffer(java.lang.foreign.MemorySegment)]
/// ### alloc_buffer_length_in_bytes
/// [VarHandle][#VH_alloc_buffer_length_in_bytes] - [Getter][#alloc_buffer_length_in_bytes()] - [Setter][#alloc_buffer_length_in_bytes(int)]
/// ## Layout
/// [Java definition][#LAYOUT]
/// ```c
/// typedef struct stb_vorbis_alloc {
///     char * alloc_buffer;
///     int alloc_buffer_length_in_bytes;
/// } STBVorbisAlloc;
/// ```
public final class STBVorbisAlloc extends Struct {
    /// The struct layout of `stb_vorbis_alloc`.
    public static final StructLayout LAYOUT = LayoutBuilder.struct(
        ValueLayout.ADDRESS.withName("alloc_buffer"),
        ValueLayout.JAVA_INT.withName("alloc_buffer_length_in_bytes")
    );
    /// The [VarHandle] of `alloc_buffer` of type `(MemorySegment base, long baseOffset, long index)java.lang.foreign.MemorySegment`.
    public static final VarHandle VH_alloc_buffer = LAYOUT.arrayElementVarHandle(PathElement.groupElement("alloc_buffer"));
    /// The [VarHandle] of `alloc_buffer_length_in_bytes` of type `(MemorySegment base, long baseOffset, long index)int`.
    public static final VarHandle VH_alloc_buffer_length_in_bytes = LAYOUT.arrayElementVarHandle(PathElement.groupElement("alloc_buffer_length_in_bytes"));

    /// Creates `STBVorbisAlloc` with the given segment.
    /// @param segment the memory segment
    public STBVorbisAlloc(MemorySegment segment) { super(segment, LAYOUT); }

    /// Allocates a `STBVorbisAlloc` with the given segment allocator.
    /// @param allocator the segment allocator
    /// @return the allocated `STBVorbisAlloc`
    public static STBVorbisAlloc alloc(SegmentAllocator allocator) { return new STBVorbisAlloc(allocator.allocate(LAYOUT)); }

    /// Allocates a `STBVorbisAlloc` with the given segment allocator and count.
    /// @param allocator the segment allocator
    /// @param count     the count
    /// @return the allocated `STBVorbisAlloc`
    public static STBVorbisAlloc alloc(SegmentAllocator allocator, long count) { return new STBVorbisAlloc(allocator.allocate(LAYOUT, count)); }

    /// {@return `alloc_buffer` at the given index}
    /// @param segment the segment of the struct
    /// @param index   the index
    public static @CType("char *") java.lang.foreign.MemorySegment get_alloc_buffer(MemorySegment segment, long index) { return (java.lang.foreign.MemorySegment) VH_alloc_buffer.get(segment, 0L, index); }
    /// {@return `alloc_buffer`}
    /// @param segment the segment of the struct
    public static @CType("char *") java.lang.foreign.MemorySegment get_alloc_buffer(MemorySegment segment) { return STBVorbisAlloc.get_alloc_buffer(segment, 0L); }
    /// {@return `alloc_buffer` at the given index}
    /// @param index the index
    public @CType("char *") java.lang.foreign.MemorySegment alloc_bufferAt(long index) { return STBVorbisAlloc.get_alloc_buffer(this.segment(), index); }
    /// {@return `alloc_buffer`}
    public @CType("char *") java.lang.foreign.MemorySegment alloc_buffer() { return STBVorbisAlloc.get_alloc_buffer(this.segment()); }
    /// Sets `alloc_buffer` with the given value at the given index.
    /// @param segment the segment of the struct
    /// @param index   the index
    /// @param value   the value
    public static void set_alloc_buffer(MemorySegment segment, long index, @CType("char *") java.lang.foreign.MemorySegment value) { VH_alloc_buffer.set(segment, 0L, index, value); }
    /// Sets `alloc_buffer` with the given value.
    /// @param segment the segment of the struct
    /// @param value   the value
    public static void set_alloc_buffer(MemorySegment segment, @CType("char *") java.lang.foreign.MemorySegment value) { STBVorbisAlloc.set_alloc_buffer(segment, 0L, value); }
    /// Sets `alloc_buffer` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBVorbisAlloc alloc_bufferAt(long index, @CType("char *") java.lang.foreign.MemorySegment value) { STBVorbisAlloc.set_alloc_buffer(this.segment(), index, value); return this; }
    /// Sets `alloc_buffer` with the given value.
    /// @param value the value
    /// @return `this`
    public STBVorbisAlloc alloc_buffer(@CType("char *") java.lang.foreign.MemorySegment value) { STBVorbisAlloc.set_alloc_buffer(this.segment(), value); return this; }

    /// {@return `alloc_buffer_length_in_bytes` at the given index}
    /// @param segment the segment of the struct
    /// @param index   the index
    public static @CType("int") int get_alloc_buffer_length_in_bytes(MemorySegment segment, long index) { return (int) VH_alloc_buffer_length_in_bytes.get(segment, 0L, index); }
    /// {@return `alloc_buffer_length_in_bytes`}
    /// @param segment the segment of the struct
    public static @CType("int") int get_alloc_buffer_length_in_bytes(MemorySegment segment) { return STBVorbisAlloc.get_alloc_buffer_length_in_bytes(segment, 0L); }
    /// {@return `alloc_buffer_length_in_bytes` at the given index}
    /// @param index the index
    public @CType("int") int alloc_buffer_length_in_bytesAt(long index) { return STBVorbisAlloc.get_alloc_buffer_length_in_bytes(this.segment(), index); }
    /// {@return `alloc_buffer_length_in_bytes`}
    public @CType("int") int alloc_buffer_length_in_bytes() { return STBVorbisAlloc.get_alloc_buffer_length_in_bytes(this.segment()); }
    /// Sets `alloc_buffer_length_in_bytes` with the given value at the given index.
    /// @param segment the segment of the struct
    /// @param index   the index
    /// @param value   the value
    public static void set_alloc_buffer_length_in_bytes(MemorySegment segment, long index, @CType("int") int value) { VH_alloc_buffer_length_in_bytes.set(segment, 0L, index, value); }
    /// Sets `alloc_buffer_length_in_bytes` with the given value.
    /// @param segment the segment of the struct
    /// @param value   the value
    public static void set_alloc_buffer_length_in_bytes(MemorySegment segment, @CType("int") int value) { STBVorbisAlloc.set_alloc_buffer_length_in_bytes(segment, 0L, value); }
    /// Sets `alloc_buffer_length_in_bytes` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBVorbisAlloc alloc_buffer_length_in_bytesAt(long index, @CType("int") int value) { STBVorbisAlloc.set_alloc_buffer_length_in_bytes(this.segment(), index, value); return this; }
    /// Sets `alloc_buffer_length_in_bytes` with the given value.
    /// @param value the value
    /// @return `this`
    public STBVorbisAlloc alloc_buffer_length_in_bytes(@CType("int") int value) { STBVorbisAlloc.set_alloc_buffer_length_in_bytes(this.segment(), value); return this; }

}
