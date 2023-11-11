/*
 * MIT License
 *
 * Copyright (c) 2023 Overrun Organization
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

package overrungl.opengl.ext.nv;

import overrungl.Callback;

import java.lang.foreign.FunctionDescriptor;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * {@link GLNVDrawVulkanImage}
 *
 * @author squid233
 * @since 0.1.0
 */
@FunctionalInterface
public interface GLVulkanProcNV extends Callback {
    FunctionDescriptor DESC = FunctionDescriptor.ofVoid();
    MethodType MTYPE = DESC.toMethodType();
    Native<GLVulkanProcNV> NATIVE = segment -> new GLVulkanProcNV() {
        @Override
        public void invoke() {
            try {
                nativeHandle(segment).invokeExact();
            } catch (Throwable e) {
                throw new AssertionError("should not reach here", e);
            }
        }
    };

    void invoke();

    @Override
    default FunctionDescriptor descriptor() {
        return DESC;
    }

    @Override
    default MethodHandle handle(MethodHandles.Lookup lookup) throws NoSuchMethodException, IllegalAccessException {
        return lookup.findVirtual(GLVulkanProcNV.class, "invoke", MTYPE);
    }
}
