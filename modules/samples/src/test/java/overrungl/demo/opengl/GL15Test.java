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

package overrungl.demo.opengl;

import overrungl.demo.util.IOUtil;
import overrungl.glfw.GLFWCallbacks;
import overrungl.glfw.GLFW;
import overrungl.glfw.GLFWErrorCallback;
import overrungl.opengl.GL;
import overrungl.opengl.GL11;
import overrungl.opengl.GLLoader;
import overrungl.stb.STBImage;
import overrungl.util.CheckUtil;

import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Objects;

import static java.lang.foreign.ValueLayout.JAVA_INT;

/**
 * Tests OpenGL 1.5 buffers
 *
 * @author squid233
 * @since 0.1.0
 */
public final class GL15Test {
    private final GLFW glfw = GLFW.INSTANCE;
    private MemorySegment window;
    private int vbo, tex;

    public void run() {
        try (var arena = Arena.ofShared()) {
            init();
            load(arena);
        }
        loop();

        GL.deleteBuffer(vbo);
        GL.deleteTexture(tex);

        GLFWCallbacks.free(window);
        glfw.destroyWindow(window);

        glfw.terminate();
        glfw.setErrorCallback(null);
    }

    private void init() {
        GLFWErrorCallback.createPrint().set();
        CheckUtil.check(glfw.init(), "Unable to initialize GLFW");
        glfw.defaultWindowHints();
        glfw.windowHint(GLFW.VISIBLE, false);
        glfw.windowHint(GLFW.RESIZABLE, true);
        window = glfw.createWindow(640, 480, "OpenGL 1.5", MemorySegment.NULL, MemorySegment.NULL);
        CheckUtil.checkNotNullptr(window, "Failed to create the GLFW window");
        glfw.setKeyCallback(window, (_, key, _, action, _) -> {
            if (key == GLFW.KEY_ESCAPE && action == GLFW.RELEASE) {
                glfw.setWindowShouldClose(window, true);
            }
        });
        glfw.setFramebufferSizeCallback(window, (_, width, height) ->
            GL.viewport(0, 0, width, height));
        var vidMode = glfw.getVideoMode(glfw.getPrimaryMonitor());
        if (vidMode != null) {
            var size = glfw.getWindowSize(window);
            glfw.setWindowPos(
                window,
                (vidMode.width() - size.x()) / 2,
                (vidMode.height() - size.y()) / 2
            );
        }

        glfw.makeContextCurrent(window);
        glfw.swapInterval(1);

        glfw.showWindow(window);
    }

    private void load(Arena arena) {
        Objects.requireNonNull(GLLoader.load(glfw::getProcAddress), "Failed to load OpenGL");

        GL.clearColor(0.4f, 0.6f, 0.9f, 1.0f);
        GL.enable(GL.TEXTURE_2D);

        vbo = GL.genBuffer();
        GL.bindBuffer(GL.ARRAY_BUFFER, vbo);
        GL.bufferData(arena, GL.ARRAY_BUFFER, new float[]{
            // Vertex          Color             Tex-coord
            0.0f, 0.5f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f,
            -0.5f, -0.5f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f,
            0.5f, -0.5f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f
        }, GL.STATIC_DRAW);
        GL.bindBuffer(GL.ARRAY_BUFFER, 0);

        tex = GL.genTexture();
        GL.bindTexture(GL.TEXTURE_2D, tex);
        GL.texParameteri(GL.TEXTURE_2D, GL.TEXTURE_MAG_FILTER, GL.NEAREST);
        GL.texParameteri(GL.TEXTURE_2D, GL.TEXTURE_MIN_FILTER, GL.NEAREST);
        try {
            final STBImage stbImage = STBImage.INSTANCE;
            var px = arena.allocate(JAVA_INT);
            var py = arena.allocate(JAVA_INT);
            var pc = arena.allocate(JAVA_INT);
            var data = stbImage.loadFromMemory(
                IOUtil.ioResourceToSegment(arena, "image.png", 256, 128),
                px, py, pc, STBImage.RGB
            );
            GL.texImage2D(GL.TEXTURE_2D,
                0,
                GL.RGB,
                px.get(JAVA_INT, 0),
                py.get(JAVA_INT, 0),
                0,
                GL.RGB,
                GL.UNSIGNED_BYTE,
                data);
            stbImage.free(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        GL.bindTexture(GL.TEXTURE_2D, 0);
    }

    private void loop() {
        while (!glfw.windowShouldClose(window)) {
            GL.clear(GL.COLOR_BUFFER_BIT | GL.DEPTH_BUFFER_BIT);

            // Draw triangle
            GL.bindTexture(GL.TEXTURE_2D, tex);
            GL.bindBuffer(GL.ARRAY_BUFFER, vbo);
            GL11.enableClientState(GL11.VERTEX_ARRAY);
            GL11.enableClientState(GL11.COLOR_ARRAY);
            GL11.enableClientState(GL11.TEXTURE_COORD_ARRAY);
            // 8 double words = 32 bytes
            final int stride = 8 << 2;
            GL11.vertexPointer(3, GL.FLOAT, stride, MemorySegment.NULL);
            GL11.colorPointer(3, GL.FLOAT, stride, MemorySegment.ofAddress(3 << 2));
            GL11.texCoordPointer(2, GL.FLOAT, stride, MemorySegment.ofAddress(6 << 2));
            GL.drawArrays(GL.TRIANGLES, 0, 3);
            GL11.disableClientState(GL11.VERTEX_ARRAY);
            GL11.disableClientState(GL11.COLOR_ARRAY);
            GL11.disableClientState(GL11.TEXTURE_COORD_ARRAY);
            GL.bindBuffer(GL.ARRAY_BUFFER, 0);
            GL.bindTexture(GL.TEXTURE_2D, 0);

            glfw.swapBuffers(window);

            glfw.pollEvents();
        }
    }

    public static void main(String[] args) {
        new GL15Test().run();
    }
}
