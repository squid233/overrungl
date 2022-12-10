/*
 * MIT License
 *
 * Copyright (c) 2022 Overrun Organization
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
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.overrun.glib.gl.ext.arb;

import org.overrun.glib.gl.*;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;

/**
 * {@code GL_ARB_draw_indirect}
 *
 * @author squid233
 * @since 0.1.0
 */
public final class GLARBDrawIndirect {
    public static void load(GLExtCaps ext, GLLoadFunc load) {
    }

    public static void glDrawArraysIndirect(int mode, MemorySegment indirect) {
        GL40C.drawArraysIndirect(mode, indirect);
    }

    public static void glDrawArraysIndirect(int mode, DrawArraysIndirectCommand indirect) {
        GL40C.drawArraysIndirect(mode, indirect);
    }

    public static void glDrawArraysIndirect(SegmentAllocator allocator, int mode, int[] indirect) {
        GL40C.drawArraysIndirect(allocator, mode, indirect);
    }

    public static void glDrawElementsIndirect(int mode, int type, MemorySegment indirect) {
        GL40C.drawElementsIndirect(mode, type, indirect);
    }

    public static void glDrawElementsIndirect(int mode, int type, DrawElementsIndirectCommand indirect) {
        GL40C.drawElementsIndirect(mode, type, indirect);
    }

    public static void glDrawElementsIndirect(SegmentAllocator allocator, int mode, int type, int[] indirect) {
        GL40C.drawElementsIndirect(allocator, mode, type, indirect);
    }
}
