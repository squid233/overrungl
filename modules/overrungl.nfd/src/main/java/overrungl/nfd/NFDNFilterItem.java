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

package overrungl.nfd;

import overrun.marshal.LayoutBuilder;
import overrun.marshal.Marshal;
import overrun.marshal.Unmarshal;
import overrun.marshal.struct.Struct;
import overrun.marshal.struct.StructAllocator;
import overrungl.util.value.Pair;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandles;

/**
 * <h2>Layout</h2>
 * <pre><code>
 * struct nfdnfilteritem_t {
 *     const nfdnchar_t* {@link #name};
 *     const nfdnchar_t* {@link #spec};
 * }</code></pre>
 *
 * @author squid233
 * @since 0.1.0
 */
public interface NFDNFilterItem<T extends NFDNFilterItem<T>> extends Struct<T> {
    /**
     * The struct layout.
     */
    StructLayout LAYOUT = LayoutBuilder.struct()
        .cAddress("name", MemoryLayout.sequenceLayout(Unmarshal.STR_SIZE, ValueLayout.JAVA_BYTE))
        .cAddress("spec", MemoryLayout.sequenceLayout(Unmarshal.STR_SIZE, ValueLayout.JAVA_BYTE))
        .build();
    /**
     * The allocator
     */
    StructAllocator<NFDNFilterItem<?>> OF = new StructAllocator<>(MethodHandles.lookup(), LAYOUT);

    /**
     * Mutable
     */
    interface Mutable extends NFDNFilterItem<Mutable> {
        /**
         * The allocator
         */
        StructAllocator<Mutable> OF = new StructAllocator<>(MethodHandles.lookup(), LAYOUT);

        /**
         * Sets {@link #name()}.
         *
         * @param val the value
         * @return this
         */
        Mutable name(MemorySegment val);

        /**
         * Sets {@link #spec()}.
         *
         * @param val the value
         * @return this
         */
        Mutable spec(MemorySegment val);
    }

    /**
     * {@return name}
     */
    MemorySegment name();

    /**
     * {@return spec}
     */
    MemorySegment spec();

    /**
     * {@return {@link #name()}}
     */
    default String javaName() {
        return Unmarshal.unmarshalAsString(name(), NFDInternal.nfdCharset);
    }

    /**
     * {@return {@link #spec()}}
     */
    default String javaSpec() {
        return Unmarshal.unmarshalAsString(spec(), NFDInternal.nfdCharset);
    }

    /**
     * Creates a {@code NFDNFilterItem} instance with the given allocator.
     *
     * @param allocator the allocator
     * @param name      the name of the filter
     * @param spec      the specification of the filter
     * @return the instance
     */
    static NFDNFilterItem<?> create(SegmentAllocator allocator, String name, String spec) {
        return Mutable.OF.of(allocator)
            .name(Marshal.marshal(allocator, name, NFDInternal.nfdCharset))
            .spec(Marshal.marshal(allocator, spec, NFDInternal.nfdCharset));
    }

    /**
     * Creates a {@code NFDNFilterItem.Buffer} instance with the given allocator and items.
     *
     * @param allocator the allocator
     * @param items     the items
     * @return the instance
     */
    @SafeVarargs
    static NFDNFilterItem<?> create(SegmentAllocator allocator, Pair<String>... items) {
        final var buffer = Mutable.OF.of(allocator, items.length);
        for (int i = 0, len = items.length; i < len; i++) {
            var item = items[i];
            buffer.slice(i)
                .name(Marshal.marshal(allocator, item.key(), NFDInternal.nfdCharset))
                .spec(Marshal.marshal(allocator, item.value(), NFDInternal.nfdCharset));
        }
        return buffer;
    }
}
