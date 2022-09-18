package org.overrun.glib;

import java.lang.foreign.*;

/**
 * A {@link MemoryAddress} wrapper.
 *
 * @author squid233
 * @since 0.1.0
 */
public class Pointer {
    /**
     * The pointer address.
     */
    protected final Addressable address;

    /**
     * Create the pointer instance.
     *
     * @param address the address
     */
    public Pointer(Addressable address) {
        this.address = address;
    }

    /**
     * Gets the address as {@link Addressable}.
     *
     * @return the address
     */
    public Addressable rawAddress() {
        return address;
    }

    /**
     * Gets the address.
     *
     * @return the memory address
     */
    public MemoryAddress address() {
        return rawAddress().address();
    }

    /**
     * Gets as memory segment.
     *
     * @param bytesSize the bytes size
     * @param session   the memory session to allocate
     * @return the memory segment
     */
    public MemorySegment segment(long bytesSize, MemorySession session) {
        return MemorySegment.ofAddress(address(), bytesSize, session);
    }

    /**
     * Gets as memory segment.
     *
     * @param layout  the memory layout
     * @param session the memory session to allocate
     * @return the memory segment
     */
    public MemorySegment segment(MemoryLayout layout, MemorySession session) {
        return segment(layout.byteSize(), session);
    }
}
