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
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.invoke.VarHandle;

/**
 * This describes the input state of a gamepad.
 *
 * <h3>Layout</h3>
 * <pre><code>
 * struct GLFWgamepadstate {
 *     unsigned char {@link #buttons() buttons}[15];
 *     float {@link #axes() axes}[6];
 * }</code></pre>
 *
 * @author squid233
 * @since 0.1.0
 */
public class GLFWGamepadState extends Pointer {
    /**
     * The struct member layout.
     */
    public static final SequenceLayout
        BUTTONS_LAYOUT = MemoryLayout.sequenceLayout(15, ValueLayout.JAVA_BYTE).withName("buttons"),
        AXES_LAYOUT = MemoryLayout.sequenceLayout(6, ValueLayout.JAVA_FLOAT).withName("axes");
    /**
     * The struct layout.
     */
    public static final GroupLayout LAYOUT = MemoryLayout.structLayout(
        BUTTONS_LAYOUT,
        AXES_LAYOUT
    );
    private static final VarHandle
        pButtons = LAYOUT.varHandle(PathElement.groupElement("buttons"), PathElement.sequenceElement()),
        pAxes = LAYOUT.varHandle(PathElement.groupElement("axes"), PathElement.sequenceElement());

    /**
     * Create a {@code GLFWgamepadstate} instance.
     *
     * @param address the address
     */
    public GLFWGamepadState(Addressable address) {
        super(address);
    }

    /**
     * Creates a {@code GLFWgamepadstate} instance with the given memory session.
     *
     * @param session the memory session
     * @return the instance
     */
    public static GLFWGamepadState create(MemorySession session) {
        return new GLFWGamepadState(session.allocate(LAYOUT));
    }

    /**
     * Gets the button state array by the memory session.
     *
     * @param session the memory session
     * @return The states of each <a href="https://www.glfw.org/docs/latest/group__gamepad__buttons.html">gamepad button</a>,
     * {@code PRESS} or {@code RELEASE}.
     */
    public byte[] buttons(MemorySession session) {
        var seg = segment(LAYOUT, session);
        byte[] arr = new byte[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (byte) pButtons.get(seg, (long) i);
        }
        return arr;
    }

    /**
     * Gets the button state array.
     *
     * @return The states of each <a href="https://www.glfw.org/docs/latest/group__gamepad__buttons.html">gamepad button</a>,
     * {@code PRESS} or {@code RELEASE}.
     */
    public byte[] buttons() {
        try (var session = MemorySession.openShared()) {
            return buttons(session);
        }
    }

    /**
     * Gets the button state at the given index.
     *
     * @param index the index
     * @return the state, {@code PRESS} or {@code RELEASE}
     */
    public boolean button(int index) {
        try (var session = MemorySession.openShared()) {
            var seg = segment(LAYOUT, session);
            return (byte) pButtons.get(seg, (long) index) == GLFW.PRESS;
        }
    }

    /**
     * Gets the axe state array by the memory session.
     *
     * @param session the memory session
     * @return The states of each <a href="https://www.glfw.org/docs/latest/group__gamepad__axes.html">gamepad axis</a>,
     * in the range -1.0 to 1.0 inclusive.
     */
    public float[] axes(MemorySession session) {
        var seg = segment(LAYOUT, session);
        float[] arr = new float[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) pAxes.get(seg, (long) i);
        }
        return arr;
    }

    /**
     * Gets the axe state array.
     *
     * @return The states of each <a href="https://www.glfw.org/docs/latest/group__gamepad__axes.html">gamepad axis</a>,
     * in the range -1.0 to 1.0 inclusive.
     */
    public float[] axes() {
        try (var session = MemorySession.openShared()) {
            return axes(session);
        }
    }

    /**
     * Gets the axe state at the given index.
     *
     * @param index the index
     * @return the state, in the range -1.0 to 1.0 inclusive
     */
    public float axe(int index) {
        try (var session = MemorySession.openShared()) {
            var seg = segment(LAYOUT, session);
            return (float) pAxes.get(seg, (long) index);
        }
    }
}
