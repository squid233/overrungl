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
/// ## Layout
/// [Java definition][#LAYOUT]
/// ```c
/// typedef struct stbtt_bakedchar {
///     unsigned short x0;
///     unsigned short y0;
///     unsigned short x1;
///     unsigned short y1;
///     float xoff;
///     float yoff;
///     float xadvance;
/// } STBTTBakedChar;
/// ```
public final class STBTTBakedChar extends Struct {
    /// The struct layout of `stbtt_bakedchar`.
    public static final StructLayout LAYOUT = LayoutBuilder.struct(
        ValueLayout.JAVA_SHORT.withName("x0"),
        ValueLayout.JAVA_SHORT.withName("y0"),
        ValueLayout.JAVA_SHORT.withName("x1"),
        ValueLayout.JAVA_SHORT.withName("y1"),
        ValueLayout.JAVA_FLOAT.withName("xoff"),
        ValueLayout.JAVA_FLOAT.withName("yoff"),
        ValueLayout.JAVA_FLOAT.withName("xadvance")
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

    /// Creates `STBTTBakedChar` with the given segment.
    /// @param segment the memory segment
    public STBTTBakedChar(MemorySegment segment) { super(segment, LAYOUT); }

    /// Allocates a `STBTTBakedChar` with the given segment allocator.
    /// @param allocator the segment allocator
    /// @return the allocated `STBTTBakedChar`
    public static STBTTBakedChar alloc(SegmentAllocator allocator) { return new STBTTBakedChar(allocator.allocate(LAYOUT)); }

    /// Allocates a `STBTTBakedChar` with the given segment allocator and count.
    /// @param allocator the segment allocator
    /// @param count     the count
    /// @return the allocated `STBTTBakedChar`
    public static STBTTBakedChar alloc(SegmentAllocator allocator, long count) { return new STBTTBakedChar(allocator.allocate(LAYOUT, count)); }

    /// {@return `x0` at the given index}
    /// @param segment the segment of the struct
    /// @param index   the index
    public static @CType("unsigned short") short get_x0(MemorySegment segment, long index) { return (short) VH_x0.get(segment, 0L, index); }
    /// {@return `x0`}
    /// @param segment the segment of the struct
    public static @CType("unsigned short") short get_x0(MemorySegment segment) { return STBTTBakedChar.get_x0(segment, 0L); }
    /// {@return `x0` at the given index}
    /// @param index the index
    public @CType("unsigned short") short x0At(long index) { return STBTTBakedChar.get_x0(this.segment(), index); }
    /// {@return `x0`}
    public @CType("unsigned short") short x0() { return STBTTBakedChar.get_x0(this.segment()); }
    /// Sets `x0` with the given value at the given index.
    /// @param segment the segment of the struct
    /// @param index   the index
    /// @param value   the value
    public static void set_x0(MemorySegment segment, long index, @CType("unsigned short") short value) { VH_x0.set(segment, 0L, index, value); }
    /// Sets `x0` with the given value.
    /// @param segment the segment of the struct
    /// @param value   the value
    public static void set_x0(MemorySegment segment, @CType("unsigned short") short value) { STBTTBakedChar.set_x0(segment, 0L, value); }
    /// Sets `x0` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBTTBakedChar x0At(long index, @CType("unsigned short") short value) { STBTTBakedChar.set_x0(this.segment(), index, value); return this; }
    /// Sets `x0` with the given value.
    /// @param value the value
    /// @return `this`
    public STBTTBakedChar x0(@CType("unsigned short") short value) { STBTTBakedChar.set_x0(this.segment(), value); return this; }

    /// {@return `y0` at the given index}
    /// @param segment the segment of the struct
    /// @param index   the index
    public static @CType("unsigned short") short get_y0(MemorySegment segment, long index) { return (short) VH_y0.get(segment, 0L, index); }
    /// {@return `y0`}
    /// @param segment the segment of the struct
    public static @CType("unsigned short") short get_y0(MemorySegment segment) { return STBTTBakedChar.get_y0(segment, 0L); }
    /// {@return `y0` at the given index}
    /// @param index the index
    public @CType("unsigned short") short y0At(long index) { return STBTTBakedChar.get_y0(this.segment(), index); }
    /// {@return `y0`}
    public @CType("unsigned short") short y0() { return STBTTBakedChar.get_y0(this.segment()); }
    /// Sets `y0` with the given value at the given index.
    /// @param segment the segment of the struct
    /// @param index   the index
    /// @param value   the value
    public static void set_y0(MemorySegment segment, long index, @CType("unsigned short") short value) { VH_y0.set(segment, 0L, index, value); }
    /// Sets `y0` with the given value.
    /// @param segment the segment of the struct
    /// @param value   the value
    public static void set_y0(MemorySegment segment, @CType("unsigned short") short value) { STBTTBakedChar.set_y0(segment, 0L, value); }
    /// Sets `y0` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBTTBakedChar y0At(long index, @CType("unsigned short") short value) { STBTTBakedChar.set_y0(this.segment(), index, value); return this; }
    /// Sets `y0` with the given value.
    /// @param value the value
    /// @return `this`
    public STBTTBakedChar y0(@CType("unsigned short") short value) { STBTTBakedChar.set_y0(this.segment(), value); return this; }

    /// {@return `x1` at the given index}
    /// @param segment the segment of the struct
    /// @param index   the index
    public static @CType("unsigned short") short get_x1(MemorySegment segment, long index) { return (short) VH_x1.get(segment, 0L, index); }
    /// {@return `x1`}
    /// @param segment the segment of the struct
    public static @CType("unsigned short") short get_x1(MemorySegment segment) { return STBTTBakedChar.get_x1(segment, 0L); }
    /// {@return `x1` at the given index}
    /// @param index the index
    public @CType("unsigned short") short x1At(long index) { return STBTTBakedChar.get_x1(this.segment(), index); }
    /// {@return `x1`}
    public @CType("unsigned short") short x1() { return STBTTBakedChar.get_x1(this.segment()); }
    /// Sets `x1` with the given value at the given index.
    /// @param segment the segment of the struct
    /// @param index   the index
    /// @param value   the value
    public static void set_x1(MemorySegment segment, long index, @CType("unsigned short") short value) { VH_x1.set(segment, 0L, index, value); }
    /// Sets `x1` with the given value.
    /// @param segment the segment of the struct
    /// @param value   the value
    public static void set_x1(MemorySegment segment, @CType("unsigned short") short value) { STBTTBakedChar.set_x1(segment, 0L, value); }
    /// Sets `x1` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBTTBakedChar x1At(long index, @CType("unsigned short") short value) { STBTTBakedChar.set_x1(this.segment(), index, value); return this; }
    /// Sets `x1` with the given value.
    /// @param value the value
    /// @return `this`
    public STBTTBakedChar x1(@CType("unsigned short") short value) { STBTTBakedChar.set_x1(this.segment(), value); return this; }

    /// {@return `y1` at the given index}
    /// @param segment the segment of the struct
    /// @param index   the index
    public static @CType("unsigned short") short get_y1(MemorySegment segment, long index) { return (short) VH_y1.get(segment, 0L, index); }
    /// {@return `y1`}
    /// @param segment the segment of the struct
    public static @CType("unsigned short") short get_y1(MemorySegment segment) { return STBTTBakedChar.get_y1(segment, 0L); }
    /// {@return `y1` at the given index}
    /// @param index the index
    public @CType("unsigned short") short y1At(long index) { return STBTTBakedChar.get_y1(this.segment(), index); }
    /// {@return `y1`}
    public @CType("unsigned short") short y1() { return STBTTBakedChar.get_y1(this.segment()); }
    /// Sets `y1` with the given value at the given index.
    /// @param segment the segment of the struct
    /// @param index   the index
    /// @param value   the value
    public static void set_y1(MemorySegment segment, long index, @CType("unsigned short") short value) { VH_y1.set(segment, 0L, index, value); }
    /// Sets `y1` with the given value.
    /// @param segment the segment of the struct
    /// @param value   the value
    public static void set_y1(MemorySegment segment, @CType("unsigned short") short value) { STBTTBakedChar.set_y1(segment, 0L, value); }
    /// Sets `y1` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBTTBakedChar y1At(long index, @CType("unsigned short") short value) { STBTTBakedChar.set_y1(this.segment(), index, value); return this; }
    /// Sets `y1` with the given value.
    /// @param value the value
    /// @return `this`
    public STBTTBakedChar y1(@CType("unsigned short") short value) { STBTTBakedChar.set_y1(this.segment(), value); return this; }

    /// {@return `xoff` at the given index}
    /// @param segment the segment of the struct
    /// @param index   the index
    public static @CType("float") float get_xoff(MemorySegment segment, long index) { return (float) VH_xoff.get(segment, 0L, index); }
    /// {@return `xoff`}
    /// @param segment the segment of the struct
    public static @CType("float") float get_xoff(MemorySegment segment) { return STBTTBakedChar.get_xoff(segment, 0L); }
    /// {@return `xoff` at the given index}
    /// @param index the index
    public @CType("float") float xoffAt(long index) { return STBTTBakedChar.get_xoff(this.segment(), index); }
    /// {@return `xoff`}
    public @CType("float") float xoff() { return STBTTBakedChar.get_xoff(this.segment()); }
    /// Sets `xoff` with the given value at the given index.
    /// @param segment the segment of the struct
    /// @param index   the index
    /// @param value   the value
    public static void set_xoff(MemorySegment segment, long index, @CType("float") float value) { VH_xoff.set(segment, 0L, index, value); }
    /// Sets `xoff` with the given value.
    /// @param segment the segment of the struct
    /// @param value   the value
    public static void set_xoff(MemorySegment segment, @CType("float") float value) { STBTTBakedChar.set_xoff(segment, 0L, value); }
    /// Sets `xoff` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBTTBakedChar xoffAt(long index, @CType("float") float value) { STBTTBakedChar.set_xoff(this.segment(), index, value); return this; }
    /// Sets `xoff` with the given value.
    /// @param value the value
    /// @return `this`
    public STBTTBakedChar xoff(@CType("float") float value) { STBTTBakedChar.set_xoff(this.segment(), value); return this; }

    /// {@return `yoff` at the given index}
    /// @param segment the segment of the struct
    /// @param index   the index
    public static @CType("float") float get_yoff(MemorySegment segment, long index) { return (float) VH_yoff.get(segment, 0L, index); }
    /// {@return `yoff`}
    /// @param segment the segment of the struct
    public static @CType("float") float get_yoff(MemorySegment segment) { return STBTTBakedChar.get_yoff(segment, 0L); }
    /// {@return `yoff` at the given index}
    /// @param index the index
    public @CType("float") float yoffAt(long index) { return STBTTBakedChar.get_yoff(this.segment(), index); }
    /// {@return `yoff`}
    public @CType("float") float yoff() { return STBTTBakedChar.get_yoff(this.segment()); }
    /// Sets `yoff` with the given value at the given index.
    /// @param segment the segment of the struct
    /// @param index   the index
    /// @param value   the value
    public static void set_yoff(MemorySegment segment, long index, @CType("float") float value) { VH_yoff.set(segment, 0L, index, value); }
    /// Sets `yoff` with the given value.
    /// @param segment the segment of the struct
    /// @param value   the value
    public static void set_yoff(MemorySegment segment, @CType("float") float value) { STBTTBakedChar.set_yoff(segment, 0L, value); }
    /// Sets `yoff` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBTTBakedChar yoffAt(long index, @CType("float") float value) { STBTTBakedChar.set_yoff(this.segment(), index, value); return this; }
    /// Sets `yoff` with the given value.
    /// @param value the value
    /// @return `this`
    public STBTTBakedChar yoff(@CType("float") float value) { STBTTBakedChar.set_yoff(this.segment(), value); return this; }

    /// {@return `xadvance` at the given index}
    /// @param segment the segment of the struct
    /// @param index   the index
    public static @CType("float") float get_xadvance(MemorySegment segment, long index) { return (float) VH_xadvance.get(segment, 0L, index); }
    /// {@return `xadvance`}
    /// @param segment the segment of the struct
    public static @CType("float") float get_xadvance(MemorySegment segment) { return STBTTBakedChar.get_xadvance(segment, 0L); }
    /// {@return `xadvance` at the given index}
    /// @param index the index
    public @CType("float") float xadvanceAt(long index) { return STBTTBakedChar.get_xadvance(this.segment(), index); }
    /// {@return `xadvance`}
    public @CType("float") float xadvance() { return STBTTBakedChar.get_xadvance(this.segment()); }
    /// Sets `xadvance` with the given value at the given index.
    /// @param segment the segment of the struct
    /// @param index   the index
    /// @param value   the value
    public static void set_xadvance(MemorySegment segment, long index, @CType("float") float value) { VH_xadvance.set(segment, 0L, index, value); }
    /// Sets `xadvance` with the given value.
    /// @param segment the segment of the struct
    /// @param value   the value
    public static void set_xadvance(MemorySegment segment, @CType("float") float value) { STBTTBakedChar.set_xadvance(segment, 0L, value); }
    /// Sets `xadvance` with the given value at the given index.
    /// @param index the index
    /// @param value the value
    /// @return `this`
    public STBTTBakedChar xadvanceAt(long index, @CType("float") float value) { STBTTBakedChar.set_xadvance(this.segment(), index, value); return this; }
    /// Sets `xadvance` with the given value.
    /// @param value the value
    /// @return `this`
    public STBTTBakedChar xadvance(@CType("float") float value) { STBTTBakedChar.set_xadvance(this.segment(), value); return this; }

}
