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

package org.overrun.glib.gl.ext.amd;

import org.jetbrains.annotations.Nullable;
import org.overrun.glib.FunctionDescriptors;
import org.overrun.glib.RuntimeHelper;
import org.overrun.glib.gl.GLExtCaps;
import org.overrun.glib.gl.GLLoadFunc;

import java.lang.foreign.Addressable;
import java.lang.foreign.MemorySession;
import java.lang.invoke.MethodHandle;

import static java.lang.foreign.ValueLayout.JAVA_INT;
import static org.overrun.glib.gl.GLCaps.check;

/**
 * {@code GL_AMD_name_gen_delete}
 *
 * @author squid233
 * @since 0.1.0
 */
public class GLAMDNameGenDelete {
    @Nullable
    public static MethodHandle glDeleteNamesAMD, glGenNamesAMD, glIsNameAMD;

    public static void load(GLLoadFunc load) {
        if (!GLExtCaps.GL_AMD_name_gen_delete) return;
        glDeleteNamesAMD = load.invoke("glDeleteNamesAMD", FunctionDescriptors.IIPV);
        glGenNamesAMD = load.invoke("glGenNamesAMD", FunctionDescriptors.IIPV);
        glIsNameAMD = load.invoke("glIsNameAMD", FunctionDescriptors.IIZ);
    }

    public static void glDeleteNamesAMD(int identifier, int num, Addressable names) {
        try {
            check(glDeleteNamesAMD).invoke(identifier, num, names);
        } catch (Throwable e) {
            throw new AssertionError("should not reach here");
        }
    }

    public static void glDeleteNamesAMD(int identifier, int[] names) {
        try (var session = MemorySession.openShared()) {
            glDeleteNamesAMD(identifier, names.length, session.allocateArray(JAVA_INT, names));
        }
    }

    public static void glDeleteNameAMD(int identifier, int name) {
        try (var session = MemorySession.openShared()) {
            glDeleteNamesAMD(identifier, 1, session.allocate(JAVA_INT, name));
        }
    }

    public static void glGenNamesAMD(int identifier, int num, Addressable names) {
        try {
            check(glGenNamesAMD).invoke(identifier, num, names);
        } catch (Throwable e) {
            throw new AssertionError("should not reach here");
        }
    }

    public static void glGenNamesAMD(int identifier, int[] names) {
        try (var session = MemorySession.openShared()) {
            var seg = session.allocateArray(JAVA_INT, names.length);
            glGenNamesAMD(identifier, names.length, seg);
            RuntimeHelper.toArray(seg, names);
        }
    }

    public static int glGenNameAMD(int identifier) {
        try (var session = MemorySession.openShared()) {
            var seg = session.allocate(JAVA_INT);
            glGenNamesAMD(identifier, 1, seg);
            return seg.get(JAVA_INT, 0);
        }
    }

    public static boolean glIsNameAMD(int identifier, int name) {
        try {
            return (boolean) check(glIsNameAMD).invoke(identifier, name);
        } catch (Throwable e) {
            throw new AssertionError("should not reach here");
        }
    }
}