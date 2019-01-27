package org.raychens.unittesting.mockito.argumentmatchers;

public class TypeA {

    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }

}
