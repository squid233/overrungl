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
/// ### x0
/// [VarHandle][#VH_x0] - [Getter][#x0()] - [Setter][#x0(short)]
///
/// coordinates of bbox in bitmap
///
/// ### y0
/// [VarHandle][#VH_y0] - [Getter][#y0()] - [Setter][#y0(short)]
///
/// coordinates of bbox in bitmap
///
/// ### x1
/// [VarHandle][#VH_x1] - [Getter][#x1()] - [Setter][#x1(short)]
///
/// coordinates of bbox in bitmap
///
/// ### y1
/// [VarHandle][#VH_y1] - [Getter][#y1()] - [Setter][#y1(short)]
///
/// coordinates of bbox in bitmap
///
/// ### xoff
/// [VarHandle][#VH_xoff] - [Getter][#xoff()] - [Setter][#xoff(float)]
/// ### yoff
/// [VarHandle][#VH_yoff] - [Getter][#yoff()] - [Setter][#yoff(float)]
/// ### xadvance
/// [VarHandle][#VH_xadvance] - [Getter][#xadvance()] - [Setter][#xadvance(float)]
/// ### xoff2
/// [VarHandle][#VH_xoff2] - [Getter][#xoff2()] - [Setter][#xoff2(float)]
/// ### yoff2
/// [VarHandle][#VH_yoff2] - [Getter][#yoff2()] - [Setter][#yoff2(float)]
/// ## Layout
/// [Java definition][#LAYOUT]
/// ```c
/// typedef struct stbtt_packedchar {
///     unsigned short x0;
///     unsigned short y0;
///     unsigned short x1;
///     unsigned short y1;
///     float xoff;
///     float yoff;
///     float xadvance;
///     float xoff2;
///     float yoff2;
/// } STBTTPackedChar;
/// ```
public final class STBTTPackedChar extends Struct {
    /// The struct layout of `stbtt_packedchar`.
    public static final StructLayout LAYOUT = LayoutBuilder.struct(
        ValueLayout.JAVA_SHORT.withName("x0"),
        ValueLayout.JAVA_SHORT.withName("y0"),
        ValueLayout.JAVA_SHORT.withName("x1"),
        ValueLayout.JAVA_SHORT.withName("y1"),
        ValueLayout.JAVA_FLOAT.withName("xoff"),
        ValueLayout.JAVA_FLOAT.withName("yoff"),
        ValueLayout.JAVA_FLOAT.withName("xadvance"),
        ValueLayout.JAVA_FLOAT.withName("xoff2"),
        ValueLayout.JAVA_FLOAT.withName("yoff2")
    );
    /// The [VarHandle] of `x0` of type `(MemorySegment base, long baseOffset, long index)short`.
    public static final VarHandle VH_x0 = LAYOUT.arrayElementVarHandle(PathElement.groupElement("x0"));
    /// The [VarHandle] of `y0` of type `(MemorySegment base, long baseOffset, long index)short`.
    public static final VarHandle VH_y0 = LAYOUT.arrayElementVarHandle(PathElement.groupElement("y0"));
    /// The [VarHandle] of `x1` of type `(MemorySegment base, long baseOffset, long index)short`.
    public static final VarHandle VH_x1 = LAYOUT.arrayElementVarHandle(PathElement.groupElement("x1"));
    /// The [VarHandle] of `y1` of type `(MemorySegment base, long baseOffset, long index)short`.
    public static final VarHandle VH_y1 = LAYOUT.arrayElementVarHandle(PathElement.groupElement("y1"));
    /// The [VarHandle] of `xoff` of type `(MemorySegment base, long baseOffset, long index)float`.
    public static final VarHandle VH_xoff = LAYOUT.arrayElementVarHandle(PathElement.groupElement("xoff"));
    /// The [VarHandle] of `yoff` of type `(MemorySegment base, long baseOffset, long index)float`.
    public static final VarHandle VH_yoff = LAYOUT.arrayElementVarHandle(PathElement.groupElement("yoff"));
    /// The [VarHandle] of `xadvance` of type `(MemorySegment base, long baseOffset, long index)float`.
    public static final VarHandle VH_xadvance = LAYOUT.arrayElementVarHandle(PathElement.groupElement("xadvance"));
    /// The [VarHandle] of `xoff2` of type `(MemorySegment base, long baseOffset, long index)float`.
    public static final VarHandle VH_xoff2 = LAYOUT.arrayElementVarHandle(PathElement.groupElement("xoff2"));
    /// The [VarHandle] of `yoff2` of type `(MemorySegment base, long baseOffset, long index)float`.
    public static final VarHandle VH_yoff2 = LAYOUT.arrayElementVarHandle(PathElement.groupElement("yoff2"));

    /// Creates `STBTTPackedChar` with the given segment.
    /// @param segment the memory segment
    public STBTTPackedChar(MemorySegment segment) { super(segment, LAYOUT); }

    /// Allocates a `STBTTPackedChar` with the given segment allocator.
    /// @param allocator the segment allocator
    /// @return the allocated `STBTTPackedChar`
    public static STBTTPackedChar alloc(SegmentAllocator allocator) { return new STBTTPackedChar(allocator.allocate(LAYOUT)); }

    /// Allocates a `STBTTPackedChar` with the given segment allocator and count.
    /// @param allocator the segment allocator
    /// @param count     the count
    /// @return the allocated `STBTTPackedChar`
    public static STBTTPackedChar alloc(SegmentAllocator allocator, long count) { return new STBTTPackedChar(allocator.allocate(LAYOUT, count)); }

    /// {@return `x0` at the given index}
    /// @param index the index
    public @CType("unsigned short") short x0At(long index) { return (short) VH_x0.get(this.segment(), 0L, index); }
    /// {@return `x0`}
    public @CType("unsigned short") short x0() { return this.x0At(0L); }
    /// Sets `x0` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar x0At(long index, @CType("unsigned short") short value) { VH_x0.set(this.segment(), 0L, index, value); return this; }
    /// Sets `x0` with the given value.
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar x0(@CType("unsigned short") short value) { return this.x0At(0L, value); }

    /// {@return `y0` at the given index}
    /// @param index the index
    public @CType("unsigned short") short y0At(long index) { return (short) VH_y0.get(this.segment(), 0L, index); }
    /// {@return `y0`}
    public @CType("unsigned short") short y0() { return this.y0At(0L); }
    /// Sets `y0` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar y0At(long index, @CType("unsigned short") short value) { VH_y0.set(this.segment(), 0L, index, value); return this; }
    /// Sets `y0` with the given value.
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar y0(@CType("unsigned short") short value) { return this.y0At(0L, value); }

    /// {@return `x1` at the given index}
    /// @param index the index
    public @CType("unsigned short") short x1At(long index) { return (short) VH_x1.get(this.segment(), 0L, index); }
    /// {@return `x1`}
    public @CType("unsigned short") short x1() { return this.x1At(0L); }
    /// Sets `x1` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar x1At(long index, @CType("unsigned short") short value) { VH_x1.set(this.segment(), 0L, index, value); return this; }
    /// Sets `x1` with the given value.
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar x1(@CType("unsigned short") short value) { return this.x1At(0L, value); }

    /// {@return `y1` at the given index}
    /// @param index the index
    public @CType("unsigned short") short y1At(long index) { return (short) VH_y1.get(this.segment(), 0L, index); }
    /// {@return `y1`}
    public @CType("unsigned short") short y1() { return this.y1At(0L); }
    /// Sets `y1` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar y1At(long index, @CType("unsigned short") short value) { VH_y1.set(this.segment(), 0L, index, value); return this; }
    /// Sets `y1` with the given value.
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar y1(@CType("unsigned short") short value) { return this.y1At(0L, value); }

    /// {@return `xoff` at the given index}
    /// @param index the index
    public @CType("float") float xoffAt(long index) { return (float) VH_xoff.get(this.segment(), 0L, index); }
    /// {@return `xoff`}
    public @CType("float") float xoff() { return this.xoffAt(0L); }
    /// Sets `xoff` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar xoffAt(long index, @CType("float") float value) { VH_xoff.set(this.segment(), 0L, index, value); return this; }
    /// Sets `xoff` with the given value.
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar xoff(@CType("float") float value) { return this.xoffAt(0L, value); }

    /// {@return `yoff` at the given index}
    /// @param index the index
    public @CType("float") float yoffAt(long index) { return (float) VH_yoff.get(this.segment(), 0L, index); }
    /// {@return `yoff`}
    public @CType("float") float yoff() { return this.yoffAt(0L); }
    /// Sets `yoff` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar yoffAt(long index, @CType("float") float value) { VH_yoff.set(this.segment(), 0L, index, value); return this; }
    /// Sets `yoff` with the given value.
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar yoff(@CType("float") float value) { return this.yoffAt(0L, value); }

    /// {@return `xadvance` at the given index}
    /// @param index the index
    public @CType("float") float xadvanceAt(long index) { return (float) VH_xadvance.get(this.segment(), 0L, index); }
    /// {@return `xadvance`}
    public @CType("float") float xadvance() { return this.xadvanceAt(0L); }
    /// Sets `xadvance` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar xadvanceAt(long index, @CType("float") float value) { VH_xadvance.set(this.segment(), 0L, index, value); return this; }
    /// Sets `xadvance` with the given value.
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar xadvance(@CType("float") float value) { return this.xadvanceAt(0L, value); }

    /// {@return `xoff2` at the given index}
    /// @param index the index
    public @CType("float") float xoff2At(long index) { return (float) VH_xoff2.get(this.segment(), 0L, index); }
    /// {@return `xoff2`}
    public @CType("float") float xoff2() { return this.xoff2At(0L); }
    /// Sets `xoff2` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar xoff2At(long index, @CType("float") float value) { VH_xoff2.set(this.segment(), 0L, index, value); return this; }
    /// Sets `xoff2` with the given value.
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar xoff2(@CType("float") float value) { return this.xoff2At(0L, value); }

    /// {@return `yoff2` at the given index}
    /// @param index the index
    public @CType("float") float yoff2At(long index) { return (float) VH_yoff2.get(this.segment(), 0L, index); }
    /// {@return `yoff2`}
    public @CType("float") float yoff2() { return this.yoff2At(0L); }
    /// Sets `yoff2` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar yoff2At(long index, @CType("float") float value) { VH_yoff2.set(this.segment(), 0L, index, value); return this; }
    /// Sets `yoff2` with the given value.
    /// @param value the value
    /// @return `this`
    public STBTTPackedChar yoff2(@CType("float") float value) { return this.yoff2At(0L, value); }

}
