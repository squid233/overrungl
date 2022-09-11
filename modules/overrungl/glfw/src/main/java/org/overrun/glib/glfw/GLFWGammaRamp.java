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

package org.overrun.glib.glfw;

import org.overrun.glib.Pointer;

import java.lang.foreign.*;

/**
 * This describes the gamma ramp for a monitor.
 *
 * <h3>Layout</h3>
 * <pre><code>
 * struct GLFWgammaramp {
 *     unsigned short* {@link #red() red};
 *     unsigned short* {@link #green() green};
 *     unsigned short* {@link #blue() blue};
 *     unsigned int {@link #size};
 * }</code></pre>
 *
 * @author squid233
 * @see GLFW#setGammaRamp
 * @see GLFW#setGammaRamp
 * @since 0.1.0
 */
public class GLFWGammaRamp extends Pointer {
    /**
     * The struct layout.
     */
    public static final GroupLayout LAYOUT = MemoryLayout.structLayout(
        ValueLayout.ADDRESS.withName("red"),
        ValueLayout.ADDRESS.withName("green"),
        ValueLayout.ADDRESS.withName("blue"),
        ValueLayout.JAVA_INT.withName("size")
    );

    /**
     * Create a {@code GLFWgammaramp const} instance.
     *
     * @param address the address
     */
    public GLFWGammaRamp(Addressable address) {
        super(address);
    }

    /**
     * Creates a {@code GLFWgammaramp} instance with the given memory session.
     *
     * @param session the memory session
     * @return the instance
     */
    public static GLFWGammaRamp create(MemorySession session) {
        return new GLFWGammaRamp(session.allocate(LAYOUT));
    }

    /**
     * Sets the red value array with the given memory session.
     *
     * @param session the memory session. the lifetime of the session
     *                <b>MUST</b> be equal or greater than this instance.
     * @param reds    the array
     * @return this
     */
    public GLFWGammaRamp red(MemorySession session, short[] reds) {
        address().set(ValueLayout.ADDRESS, 0L, session.allocateArray(ValueLayout.JAVA_SHORT, reds));
        return this;
    }

    /**
     * Sets the green value array with the given memory session.
     *
     * @param session the memory session. the lifetime of the session
     *                <b>MUST</b> be equal or greater than this instance.
     * @param greens  the array
     * @return this
     */
    public GLFWGammaRamp green(MemorySession session, short[] greens) {
        address().setAtIndex(ValueLayout.ADDRESS, 1L, session.allocateArray(ValueLayout.JAVA_SHORT, greens));
        return this;
    }

    /**
     * Sets the blue value array with the given memory session.
     *
     * @param session the memory session. the lifetime of the session
     *                <b>MUST</b> be equal or greater than this instance.
     * @param blues   the array
     * @return this
     */
    public GLFWGammaRamp blue(MemorySession session, short[] blues) {
        address().setAtIndex(ValueLayout.ADDRESS, 2L, session.allocateArray(ValueLayout.JAVA_SHORT, blues));
        return this;
    }

    /**
     * Sets the arrays size.
     *
     * @param size The number of elements in each array.
     * @return this
     */
    public GLFWGammaRamp size(int size) {
        address().set(ValueLayout.JAVA_INT, ValueLayout.ADDRESS.byteSize() * 3L, size);
        return this;
    }

    /**
     * Gets a red value at the given index.
     *
     * @param index the index
     * @return the red value
     */
    public short red(int index) {
        return nred().getAtIndex(ValueLayout.JAVA_SHORT, index);
    }

    /**
     * Gets a green value at the given index.
     *
     * @param index the index
     * @return the green value
     */
    public short green(int index) {
        return ngreen().getAtIndex(ValueLayout.JAVA_SHORT, index);
    }

    /**
     * Gets a blue value at the given index.
     *
     * @param index the index
     * @return the blue value
     */
    public short blue(int index) {
        return nblue().getAtIndex(ValueLayout.JAVA_SHORT, index);
    }

    /**
     * Gets the red value array.
     *
     * @param size the array size
     * @return the array
     */
    public short[] reds(int size) {
        short[] arr = new short[size];
        var addr = nred();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = addr.getAtIndex(ValueLayout.JAVA_SHORT, i);
        }
        return arr;
    }

    /**
     * Gets the green value array.
     *
     * @param size the array size
     * @return the array
     */
    public short[] greens(int size) {
        short[] arr = new short[size];
        var addr = ngreen();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = addr.getAtIndex(ValueLayout.JAVA_SHORT, i);
        }
        return arr;
    }

    /**
     * Gets the blue value array.
     *
     * @param size the array size
     * @return the array
     */
    public short[] blues(int size) {
        short[] arr = new short[size];
        var addr = nblue();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = addr.getAtIndex(ValueLayout.JAVA_SHORT, i);
        }
        return arr;
    }

    /**
     * Gets the red value array.
     *
     * @return An array of value describing the response of the red channel.
     */
    public short[] red() {
        return reds(size());
    }

    /**
     * Gets the green value array.
     *
     * @return An array of value describing the response of the green channel.
     */
    public short[] green() {
        return greens(size());
    }

    /**
     * Gets the blue value array.
     *
     * @return An array of value describing the response of the blue channel.
     */
    public short[] blue() {
        return blues(size());
    }

    /**
     * Gets the arrays size.
     *
     * @return The number of elements in each array.
     */
    public int size() {
        return address().get(ValueLayout.JAVA_INT, ValueLayout.ADDRESS.byteSize() * 3L);
    }

    public MemoryAddress nred() {
        return address().get(ValueLayout.ADDRESS, 0L);
    }

    public MemoryAddress ngreen() {
        return address().getAtIndex(ValueLayout.ADDRESS, 1L);
    }

    public MemoryAddress nblue() {
        return address().getAtIndex(ValueLayout.ADDRESS, 2L);
    }
}
