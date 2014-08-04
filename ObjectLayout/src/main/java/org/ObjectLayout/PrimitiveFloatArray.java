/*
 * Written by Gil Tene and Martin Thompson, and released to the public domain,
 * as explained at http://creativecommons.org/publicdomain/zero/1.0/
 */

package org.ObjectLayout;

/**
 * A subclassable array of floats.
 */

public class PrimitiveFloatArray extends PrimitiveArray {

    private float[] array;

    public float[] getArray() {
        return array;
    }

    public float get(final int index) {
        return array[index];
    }

    public void set(final int index, final float value) {
        array[index] = value;
    }

    public static PrimitiveFloatArray newInstance(final int length) {
        return PrimitiveArray.newSubclassInstance(PrimitiveFloatArray.class, length);
    }

    @Override
    final void initializePrimitiveArray(final int length) {
        if (length > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Cannot instantiate array with more than Integer.MAX_VALUE elements");
        }
        array = new float[(int) length];
    }
}