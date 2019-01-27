package org.raychens.unittesting.mockito.argumentmatchers;

public class Type {

    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }

}
