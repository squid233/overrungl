/*
 * MIT License
 *
 * Copyright (c) 2023-2025 Overrun Organization
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

package overrungl.stb;

import overrungl.annotation.CType;
import overrungl.internal.RuntimeHelper;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;

/// [stb_perlin.h](https://github.com/nothings/stb/blob/master/stb_perlin.h)
///
/// @author squid233
/// @since 0.1.0
public final class STBPerlin {
    //region ---[BEGIN GENERATOR BEGIN]---
    //@formatter:off
    //region Fields
    //endregion
    //region Method handles
    /// Method handles.
    public static final class Handles {
        private Handles() { }
        /// The method handle of `stb_perlin_noise3`.
        public static final MethodHandle MH_stb_perlin_noise3 = RuntimeHelper.downcall(STBInternal.lookup(), "stb_perlin_noise3", FunctionDescriptor.of(ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
        /// The method handle of `stb_perlin_noise3_seed`.
        public static final MethodHandle MH_stb_perlin_noise3_seed = RuntimeHelper.downcall(STBInternal.lookup(), "stb_perlin_noise3_seed", FunctionDescriptor.of(ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT));
        /// The method handle of `stb_perlin_ridge_noise3`.
        public static final MethodHandle MH_stb_perlin_ridge_noise3 = RuntimeHelper.downcall(STBInternal.lookup(), "stb_perlin_ridge_noise3", FunctionDescriptor.of(ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_INT));
        /// The method handle of `stb_perlin_fbm_noise3`.
        public static final MethodHandle MH_stb_perlin_fbm_noise3 = RuntimeHelper.downcall(STBInternal.lookup(), "stb_perlin_fbm_noise3", FunctionDescriptor.of(ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_INT));
        /// The method handle of `stb_perlin_turbulence_noise3`.
        public static final MethodHandle MH_stb_perlin_turbulence_noise3 = RuntimeHelper.downcall(STBInternal.lookup(), "stb_perlin_turbulence_noise3", FunctionDescriptor.of(ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_INT));
        /// The method handle of `stb_perlin_noise3_wrap_nonpow2`.
        public static final MethodHandle MH_stb_perlin_noise3_wrap_nonpow2 = RuntimeHelper.downcall(STBInternal.lookup(), "stb_perlin_noise3_wrap_nonpow2", FunctionDescriptor.of(ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_FLOAT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT, ValueLayout.JAVA_BYTE));
    }
    //endregion

    public static @CType("float") float stb_perlin_noise3(@CType("float") float x, @CType("float") float y, @CType("float") float z, @CType("int") int x_wrap, @CType("int") int y_wrap, @CType("int") int z_wrap) {
        try {
            return (float) Handles.MH_stb_perlin_noise3.invokeExact(x, y, z, x_wrap, y_wrap, z_wrap);
        } catch (Throwable e) { throw new RuntimeException("error in stb_perlin_noise3", e); }
    }

    public static @CType("float") float stb_perlin_noise3_seed(@CType("float") float x, @CType("float") float y, @CType("float") float z, @CType("int") int x_wrap, @CType("int") int y_wrap, @CType("int") int z_wrap, @CType("int") int seed) {
        try {
            return (float) Handles.MH_stb_perlin_noise3_seed.invokeExact(x, y, z, x_wrap, y_wrap, z_wrap, seed);
        } catch (Throwable e) { throw new RuntimeException("error in stb_perlin_noise3_seed", e); }
    }

    public static @CType("float") float stb_perlin_ridge_noise3(@CType("float") float x, @CType("float") float y, @CType("float") float z, @CType("float") float lacunarity, @CType("float") float gain, @CType("float") float offset, @CType("int") int octaves) {
        try {
            return (float) Handles.MH_stb_perlin_ridge_noise3.invokeExact(x, y, z, lacunarity, gain, offset, octaves);
        } catch (Throwable e) { throw new RuntimeException("error in stb_perlin_ridge_noise3", e); }
    }

    public static @CType("float") float stb_perlin_fbm_noise3(@CType("float") float x, @CType("float") float y, @CType("float") float z, @CType("float") float lacunarity, @CType("float") float gain, @CType("int") int octaves) {
        try {
            return (float) Handles.MH_stb_perlin_fbm_noise3.invokeExact(x, y, z, lacunarity, gain, octaves);
        } catch (Throwable e) { throw new RuntimeException("error in stb_perlin_fbm_noise3", e); }
    }

    public static @CType("float") float stb_perlin_turbulence_noise3(@CType("float") float x, @CType("float") float y, @CType("float") float z, @CType("float") float lacunarity, @CType("float") float gain, @CType("int") int octaves) {
        try {
            return (float) Handles.MH_stb_perlin_turbulence_noise3.invokeExact(x, y, z, lacunarity, gain, octaves);
        } catch (Throwable e) { throw new RuntimeException("error in stb_perlin_turbulence_noise3", e); }
    }

    public static @CType("float") float stb_perlin_noise3_wrap_nonpow2(@CType("float") float x, @CType("float") float y, @CType("float") float z, @CType("int") int x_wrap, @CType("int") int y_wrap, @CType("int") int z_wrap, @CType("unsigned char") byte seed) {
        try {
            return (float) Handles.MH_stb_perlin_noise3_wrap_nonpow2.invokeExact(x, y, z, x_wrap, y_wrap, z_wrap, seed);
        } catch (Throwable e) { throw new RuntimeException("error in stb_perlin_noise3_wrap_nonpow2", e); }
    }

    //@formatter:on
    //endregion ---[END GENERATOR END]---

    private STBPerlin() {
    }
}
