/*
 * MIT License
 *
 * Copyright (c) 2024 Overrun Organization
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

package overrungl.stb

import overrungl.gen.address
import overrungl.gen.jboolean

const val stbPackage = "overrungl.stb"
const val stbLookup = "Handles.lookup"

val boolean_int = jboolean c "int"
val uchar_ptr = address c "unsigned char *"

val int_ptr_ptr = address c "int**"

fun main() {
    STBEasyFont()
    STBImage()
    STBImageResize2()
    STBImageWrite()
    STBPerlin()
    STBRectPack()
    STBTruetype()
    STBVorbis()
}
