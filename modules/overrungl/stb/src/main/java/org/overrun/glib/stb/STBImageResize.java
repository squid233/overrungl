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

package org.overrun.glib.stb;

import org.overrun.glib.RuntimeHelper;

import java.lang.foreign.Addressable;
import java.lang.foreign.MemorySession;

import static java.lang.foreign.ValueLayout.*;
import static org.overrun.glib.stb.Handles.*;

/**
 * The STB image resizer.
 *
 * @author squid233
 * @since 0.1.0
 */
public class STBImageResize {
    static {
        create();
    }

    protected STBImageResize() {
        throw new IllegalStateException("Do not construct instance");
    }

    public static boolean stbi_resize_uint8(Addressable inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                            Addressable outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                            int numChannels) {
        try {
            return (int) stbir_resize_uint8.invoke(inputPixels, inputW, inputH, inputStrideInBytes,
                outputPixels, outputW, outputH, outputStrideInBytes,
                numChannels) != 0;
        } catch (Throwable e) {
            throw new AssertionError("should not reach here");
        }
    }

    public static boolean stbi_resize_uint8(byte[] inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                            byte[] outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                            int numChannels) {
        try (var session = MemorySession.openShared()) {
            var seg = session.allocateArray(JAVA_BYTE, outputPixels.length);
            boolean b = stbi_resize_uint8(session.allocateArray(JAVA_BYTE, inputPixels), inputW, inputH, inputStrideInBytes,
                seg, outputW, outputH, outputStrideInBytes,
                numChannels);
            RuntimeHelper.toArray(seg, outputPixels);
            return b;
        }
    }

    public static boolean stbi_resize_float(Addressable inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                            Addressable outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                            int numChannels) {
        try {
            return (int) stbir_resize_float.invoke(inputPixels, inputW, inputH, inputStrideInBytes,
                outputPixels, outputW, outputH, outputStrideInBytes,
                numChannels) != 0;
        } catch (Throwable e) {
            throw new AssertionError("should not reach here");
        }
    }

    public static boolean stbi_resize_float(float[] inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                            float[] outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                            int numChannels) {
        try (var session = MemorySession.openShared()) {
            var seg = session.allocateArray(JAVA_FLOAT, outputPixels.length);
            boolean b = stbi_resize_float(session.allocateArray(JAVA_FLOAT, inputPixels), inputW, inputH, inputStrideInBytes,
                seg, outputW, outputH, outputStrideInBytes,
                numChannels);
            RuntimeHelper.toArray(seg, outputPixels);
            return b;
        }
    }

    public static boolean stbi_resize_uint8_srgb(Addressable inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                                 Addressable outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                                 int numChannels, int alphaChannel, int flags) {
        try {
            return (int) stbir_resize_uint8_srgb.invoke(inputPixels, inputW, inputH, inputStrideInBytes,
                outputPixels, outputW, outputH, outputStrideInBytes,
                numChannels, alphaChannel, flags) != 0;
        } catch (Throwable e) {
            throw new AssertionError("should not reach here");
        }
    }

    public static boolean stbi_resize_uint8_srgb(byte[] inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                                 byte[] outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                                 int numChannels, int alphaChannel, int flags) {
        try (var session = MemorySession.openShared()) {
            var seg = session.allocateArray(JAVA_BYTE, outputPixels.length);
            boolean b = stbi_resize_uint8_srgb(session.allocateArray(JAVA_BYTE, inputPixels), inputW, inputH, inputStrideInBytes,
                seg, outputW, outputH, outputStrideInBytes,
                numChannels, alphaChannel, flags);
            RuntimeHelper.toArray(seg, outputPixels);
            return b;
        }
    }

    public static boolean stbi_resize_uint8_srgb_edgemode(Addressable inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                                          Addressable outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                                          int numChannels, int alphaChannel, int flags,
                                                          int edgeWrapMode) {
        try {
            return (int) stbir_resize_uint8_srgb_edgemode.invoke(inputPixels, inputW, inputH, inputStrideInBytes,
                outputPixels, outputW, outputH, outputStrideInBytes,
                numChannels, alphaChannel, flags,
                edgeWrapMode) != 0;
        } catch (Throwable e) {
            throw new AssertionError("should not reach here");
        }
    }

    public static boolean stbi_resize_uint8_srgb_edgemode(byte[] inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                                          byte[] outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                                          int numChannels, int alphaChannel, int flags,
                                                          STBIREdge edgeWrapMode) {
        try (var session = MemorySession.openShared()) {
            var seg = session.allocateArray(JAVA_BYTE, outputPixels.length);
            boolean b = stbi_resize_uint8_srgb_edgemode(session.allocateArray(JAVA_BYTE, inputPixels), inputW, inputH, inputStrideInBytes,
                seg, outputW, outputH, outputStrideInBytes,
                numChannels, alphaChannel, flags,
                edgeWrapMode.getValue());
            RuntimeHelper.toArray(seg, outputPixels);
            return b;
        }
    }

    public static boolean stbi_resize_uint8_generic(Addressable inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                                    Addressable outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                                    int numChannels, int alphaChannel, int flags,
                                                    int edgeWrapMode, int filter, int space,
                                                    Addressable allocContext) {
        try {
            return (int) stbir_resize_uint8_generic.invoke(inputPixels, inputW, inputH, inputStrideInBytes,
                outputPixels, outputW, outputH, outputStrideInBytes,
                numChannels, alphaChannel, flags,
                edgeWrapMode, filter, space,
                allocContext) != 0;
        } catch (Throwable e) {
            throw new AssertionError("should not reach here");
        }
    }

    public static boolean stbi_resize_uint8_generic(byte[] inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                                    byte[] outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                                    int numChannels, int alphaChannel, int flags,
                                                    STBIREdge edgeWrapMode, STBIRFilter filter, STBIRColorspace space,
                                                    Addressable allocContext) {
        try (var session = MemorySession.openShared()) {
            var seg = session.allocateArray(JAVA_BYTE, outputPixels.length);
            boolean b = stbi_resize_uint8_generic(session.allocateArray(JAVA_BYTE, inputPixels), inputW, inputH, inputStrideInBytes,
                seg, outputW, outputH, outputStrideInBytes,
                numChannels, alphaChannel, flags,
                edgeWrapMode.getValue(), filter.getValue(), space.ordinal(),
                allocContext);
            RuntimeHelper.toArray(seg, outputPixels);
            return b;
        }
    }

    public static boolean stbi_resize_uint16_generic(Addressable inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                                     Addressable outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                                     int numChannels, int alphaChannel, int flags,
                                                     int edgeWrapMode, int filter, int space,
                                                     Addressable allocContext) {
        try {
            return (int) stbir_resize_uint16_generic.invoke(inputPixels, inputW, inputH, inputStrideInBytes,
                outputPixels, outputW, outputH, outputStrideInBytes,
                numChannels, alphaChannel, flags,
                edgeWrapMode, filter, space,
                allocContext) != 0;
        } catch (Throwable e) {
            throw new AssertionError("should not reach here");
        }
    }

    public static boolean stbi_resize_uint16_generic(short[] inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                                     short[] outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                                     int numChannels, int alphaChannel, int flags,
                                                     STBIREdge edgeWrapMode, STBIRFilter filter, STBIRColorspace space,
                                                     Addressable allocContext) {
        try (var session = MemorySession.openShared()) {
            var seg = session.allocateArray(JAVA_SHORT, outputPixels.length);
            boolean b = stbi_resize_uint16_generic(session.allocateArray(JAVA_SHORT, inputPixels), inputW, inputH, inputStrideInBytes,
                seg, outputW, outputH, outputStrideInBytes,
                numChannels, alphaChannel, flags,
                edgeWrapMode.getValue(), filter.getValue(), space.ordinal(),
                allocContext);
            RuntimeHelper.toArray(seg, outputPixels);
            return b;
        }
    }

    public static boolean stbi_resize_float_generic(Addressable inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                                    Addressable outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                                    int numChannels, int alphaChannel, int flags,
                                                    int edgeWrapMode, int filter, int space,
                                                    Addressable allocContext) {
        try {
            return (int) stbir_resize_float_generic.invoke(inputPixels, inputW, inputH, inputStrideInBytes,
                outputPixels, outputW, outputH, outputStrideInBytes,
                numChannels, alphaChannel, flags,
                edgeWrapMode, filter, space,
                allocContext) != 0;
        } catch (Throwable e) {
            throw new AssertionError("should not reach here");
        }
    }

    public static boolean stbi_resize_float_generic(float[] inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                                    float[] outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                                    int numChannels, int alphaChannel, int flags,
                                                    STBIREdge edgeWrapMode, STBIRFilter filter, STBIRColorspace space,
                                                    Addressable allocContext) {
        try (var session = MemorySession.openShared()) {
            var seg = session.allocateArray(JAVA_FLOAT, outputPixels.length);
            boolean b = stbi_resize_float_generic(session.allocateArray(JAVA_FLOAT, inputPixels), inputW, inputH, inputStrideInBytes,
                seg, outputW, outputH, outputStrideInBytes,
                numChannels, alphaChannel, flags,
                edgeWrapMode.getValue(), filter.getValue(), space.ordinal(),
                allocContext);
            RuntimeHelper.toArray(seg, outputPixels);
            return b;
        }
    }

    public static boolean stbi_resize(Addressable inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                      Addressable outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                      int datatype,
                                      int numChannels, int alphaChannel, int flags,
                                      int edgeModeHorizontal, int edgeModeVertical,
                                      int filterHorizontal, int filterVertical,
                                      int space, Addressable allocContext) {
        try {
            return (int) stbir_resize.invoke(inputPixels, inputW, inputH, inputStrideInBytes,
                outputPixels, outputW, outputH, outputStrideInBytes,
                datatype,
                numChannels, alphaChannel, flags,
                edgeModeHorizontal, edgeModeVertical,
                filterHorizontal, filterVertical,
                space, allocContext) != 0;
        } catch (Throwable e) {
            throw new AssertionError("should not reach here");
        }
    }

    public static boolean stbi_resize(Addressable inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                      Addressable outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                      STBIRDatatype datatype,
                                      int numChannels, int alphaChannel, int flags,
                                      STBIREdge edgeModeHorizontal, STBIREdge edgeModeVertical,
                                      STBIRFilter filterHorizontal, STBIRFilter filterVertical,
                                      STBIRColorspace space, Addressable allocContext) {
        return stbi_resize(inputPixels, inputW, inputH, inputStrideInBytes,
            outputPixels, outputW, outputH, outputStrideInBytes,
            datatype.ordinal(),
            numChannels, alphaChannel, flags,
            edgeModeHorizontal.getValue(), edgeModeVertical.getValue(),
            filterHorizontal.getValue(), filterVertical.getValue(),
            space.ordinal(), allocContext);
    }

    public static boolean stbi_resize_subpixel(Addressable inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                               Addressable outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                               int datatype,
                                               int numChannels, int alphaChannel, int flags,
                                               int edgeModeHorizontal, int edgeModeVertical,
                                               int filterHorizontal, int filterVertical,
                                               int space, Addressable allocContext,
                                               float xScale, float yScale,
                                               float xOffset, float yOffset) {
        try {
            return (int) stbir_resize_subpixel.invoke(inputPixels, inputW, inputH, inputStrideInBytes,
                outputPixels, outputW, outputH, outputStrideInBytes,
                datatype,
                numChannels, alphaChannel, flags,
                edgeModeHorizontal, edgeModeVertical,
                filterHorizontal, filterVertical,
                space, allocContext,
                xScale, yScale,
                xOffset, yOffset) != 0;
        } catch (Throwable e) {
            throw new AssertionError("should not reach here");
        }
    }

    public static boolean stbi_resize_subpixel(Addressable inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                               Addressable outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                               STBIRDatatype datatype,
                                               int numChannels, int alphaChannel, int flags,
                                               STBIREdge edgeModeHorizontal, STBIREdge edgeModeVertical,
                                               STBIRFilter filterHorizontal, STBIRFilter filterVertical,
                                               STBIRColorspace space, Addressable allocContext,
                                               float xScale, float yScale,
                                               float xOffset, float yOffset) {
        return stbi_resize_subpixel(inputPixels, inputW, inputH, inputStrideInBytes,
            outputPixels, outputW, outputH, outputStrideInBytes,
            datatype.ordinal(),
            numChannels, alphaChannel, flags,
            edgeModeHorizontal.getValue(), edgeModeVertical.getValue(),
            filterHorizontal.getValue(), filterVertical.getValue(),
            space.ordinal(), allocContext,
            xScale, yScale,
            xOffset, yOffset);
    }

    public static boolean stbi_resize_region(Addressable inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                             Addressable outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                             int datatype,
                                             int numChannels, int alphaChannel, int flags,
                                             int edgeModeHorizontal, int edgeModeVertical,
                                             int filterHorizontal, int filterVertical,
                                             int space, Addressable allocContext,
                                             float s0, float t0, float s1, float t1) {
        try {
            return (int) stbir_resize_region.invoke(inputPixels, inputW, inputH, inputStrideInBytes,
                outputPixels, outputW, outputH, outputStrideInBytes,
                datatype,
                numChannels, alphaChannel, flags,
                edgeModeHorizontal, edgeModeVertical,
                filterHorizontal, filterVertical,
                space, allocContext,
                s0, t0, s1, t1) != 0;
        } catch (Throwable e) {
            throw new AssertionError("should not reach here");
        }
    }

    public static boolean stbi_resize_region(Addressable inputPixels, int inputW, int inputH, int inputStrideInBytes,
                                             Addressable outputPixels, int outputW, int outputH, int outputStrideInBytes,
                                             STBIRDatatype datatype,
                                             int numChannels, int alphaChannel, int flags,
                                             STBIREdge edgeModeHorizontal, STBIREdge edgeModeVertical,
                                             STBIRFilter filterHorizontal, STBIRFilter filterVertical,
                                             STBIRColorspace space, Addressable allocContext,
                                             float s0, float t0, float s1, float t1) {
        return stbi_resize_region(inputPixels, inputW, inputH, inputStrideInBytes,
            outputPixels, outputW, outputH, outputStrideInBytes,
            datatype.ordinal(),
            numChannels, alphaChannel, flags,
            edgeModeHorizontal.getValue(), edgeModeVertical.getValue(),
            filterHorizontal.getValue(), filterVertical.getValue(),
            space.ordinal(), allocContext,
            s0, t0, s1, t1);
    }
}