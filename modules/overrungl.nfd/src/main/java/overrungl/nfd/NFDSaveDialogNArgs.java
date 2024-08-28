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

package overrungl.nfd;

import overrun.marshal.LayoutBuilder;
import overrun.marshal.Unmarshal;
import overrun.marshal.struct.Struct;
import overrun.marshal.struct.StructAllocator;
import overrungl.internal.RuntimeHelper;

/**
 * {@code NFDSaveDialogNArgs}
 */
public interface NFDSaveDialogNArgs extends Struct<NFDSaveDialogNArgs> {
    /**
     * The struct allocator.
     */
    StructAllocator<NFDSaveDialogNArgs> OF = new StructAllocator<>(java.lang.invoke.MethodHandles.lookup(),
        LayoutBuilder.struct()
            .cAddress("filterList")
            .add(RuntimeHelper.SIZE_T, "filterCount")
            .add(Unmarshal.STR_LAYOUT, "defaultPath")
            .add(Unmarshal.STR_LAYOUT, "defaultName")
            .cAddress("parentWindow", NFDWindowHandle.OF.layout())
            .build()
    );
}
