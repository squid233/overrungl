/*
 * MIT License
 *
 * Copyright (c) 2022-present Overrun Organization
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
package overrungl.opengl.ext.nv;
import overrungl.NativeType;
import overrungl.opengl.*;
import java.lang.foreign.*;

/**
 * {@code GL_NV_conservative_raster_pre_snap_triangles}
 */
public interface GLNVConservativeRasterPreSnapTriangles {
    int GL_CONSERVATIVE_RASTER_MODE_NV = 0x954D;
    int GL_CONSERVATIVE_RASTER_MODE_POST_SNAP_NV = 0x954E;
    int GL_CONSERVATIVE_RASTER_MODE_PRE_SNAP_TRIANGLES_NV = 0x954F;

    default void glConservativeRasterParameteriNV(int pname, int param) {
        throw new ContextException();
    }

}
