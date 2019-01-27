package org.raychens.unittesting.mockito.stubbingbasics;

import org.apache.commons.lang3.RandomStringUtils;

public class SomeObject {

    public String doSomething() {
        System.out.println("SomeObject.doSomethingWithReturn(): START");
        System.out.println("SomeObject.doSomethingWithReturn(): doing...");
        System.out.println("SomeObject.doSomethingWithReturn(): END");
        return RandomStringUtils.randomAlphanumeric(5);
    }

}
