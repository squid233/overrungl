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

import org.overrun.glib.gl.GLExtCaps;
import org.overrun.glib.gl.GLLoadFunc;

import static org.overrun.glib.FunctionDescriptors.*;
import static org.overrun.glib.gl.GLLoader.check;
import static org.overrun.glib.gl.GLLoader.getExtCapabilities;

/**
 * {@code GL_ARB_draw_buffers_blend}
 *
 * @author squid233
 * @since 0.1.0
 */
public final class GLARBDrawBuffersBlend {
    public static void load(GLExtCaps ext, GLLoadFunc load) {
        if (!ext.GL_ARB_draw_buffers_blend) return;
        ext.glBlendEquationSeparateiARB = load.invoke("glBlendEquationSeparateiARB", IIIV);
        ext.glBlendEquationiARB = load.invoke("glBlendEquationiARB", IIV);
        ext.glBlendFuncSeparateiARB = load.invoke("glBlendFuncSeparateiARB", IIIIIV);
        ext.glBlendFunciARB = load.invoke("glBlendFunciARB", IIIV);
    }

    public static void glBlendEquationSeparateiARB(int buf, int modeRGB, int modeAlpha) {
        var ext = getExtCapabilities();
        try {
            check(ext.glBlendEquationSeparateiARB).invokeExact(buf, modeRGB, modeAlpha);
        } catch (Throwable e) {
            throw new AssertionError("should not reach here", e);
        }
    }

    public static void glBlendEquationiARB(int buf, int mode) {
        var ext = getExtCapabilities();
        try {
            check(ext.glBlendEquationiARB).invokeExact(buf, mode);
        } catch (Throwable e) {
            throw new AssertionError("should not reach here", e);
        }
    }

    public static void glBlendFuncSeparateiARB(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
        var ext = getExtCapabilities();
        try {
            check(ext.glBlendFuncSeparateiARB).invokeExact(buf, srcRGB, dstRGB, srcAlpha, dstAlpha);
        } catch (Throwable e) {
            throw new AssertionError("should not reach here", e);
        }
    }

    public static void glBlendFunciARB(int buf, int src, int dst) {
        var ext = getExtCapabilities();
        try {
            check(ext.glBlendFunciARB).invokeExact(buf, src, dst);
        } catch (Throwable e) {
            throw new AssertionError("should not reach here", e);
        }
    }
}
