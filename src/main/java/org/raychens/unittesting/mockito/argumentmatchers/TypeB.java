package org.raychens.unittesting.mockito.argumentmatchers;

public class TypeB {

    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }

}
