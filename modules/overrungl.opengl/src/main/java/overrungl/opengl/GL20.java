/*
 * MIT License
 *
 * Copyright (c) 2023-2024 Overrun Organization
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

package overrungl.opengl;

/**
 * The OpenGL 2.0 constants.
 *
 * @author squid233
 * @since 0.1.0
 */
public sealed interface GL20 extends GL20C permits GLLegacy {
    int VERTEX_PROGRAM_TWO_SIDE = 0x8643;
    int POINT_SPRITE = 0x8861;
    int COORD_REPLACE = 0x8862;
    int MAX_TEXTURE_COORDS = 0x8871;
}
