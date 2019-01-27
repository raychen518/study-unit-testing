package org.raychens.unittesting.mockito.argumentmatchers;

public class TypeC {

    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }

}
