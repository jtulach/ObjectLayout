/*
 * Written by Gil Tene and Martin Thompson, and released to the public domain,
 * as explained at http://creativecommons.org/publicdomain/zero/1.0/
 */

package org.ObjectLayout;

import org.ObjectLayout.intrinsifiable.PrimitiveArray;
import org.ObjectLayout.intrinsifiable.AbstractPrimitiveIntArray;

/**
 * A subclassable array of ints.
 *
 * PrimitiveIntArray is designed with semantics specifically chosen and restricted such that a "flat" memory
 * layout of the implemented data structure would be possible on optimizing JVMs. While fully functional
 * on all JVM implementation (of Java SE 6 and above), the semantics are such that a JVM may transparently
 * optimise the implementation to provide a compact contiguous layout that facilitates dead-reckoning (as
 * opposed to de-referenced) access to elements
 */

public class PrimitiveIntArray extends AbstractPrimitiveIntArray {

    /**
     * Get a reference to the internal {@link int[]} representation of the array.
     *
     * @return a reference to the internal {@link int[]} representation of the array
     */
    public int[] getArray() {
        return _getArray();
    }

    /**
     * Get the value of an element in the array.
     *
     * @param index the index of the element
     * @return the value of the element at the given index
     */
    public int get(final int index) {
        return _getArray()[index];
    }

    /**
     * set the value of an element in the array.
     *
     * @param index the index of the element to set
     * @param value the value to assign to the element
     */
    public void set(final int index, final int value) {
        _getArray()[index] = value;
    }

    public static PrimitiveIntArray newInstance(final int length) {
        return PrimitiveArray.newInstance(PrimitiveIntArray.class, length);
    }

    /**
     * Default constructor
     */
    public PrimitiveIntArray() {
        super();
    }

    /**
     * Copying constructor
     *
     * @param sourceArray the array to copy
     */
    public PrimitiveIntArray(PrimitiveIntArray sourceArray) {
        super(sourceArray);
    }
}