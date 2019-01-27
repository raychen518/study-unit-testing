package org.raychens.unittesting.mockingmethods.case103.superclassprotectedmethod.a;

public class Parent {

    protected void doSomething(String string) {
        System.out.println("Parent.doSomething(String): START");

        System.out.println("Parent.doSomething(String): string.toUpperCase(): " + string.toUpperCase());

        System.out.println("Parent.doSomething(String): END");
    }

    protected void doSomethingMore(String string) {
        System.out.println("Parent.doSomethingMore(String): START");

        System.out.println("Parent.doSomethingMore(String): string.hashCode(): " + string.hashCode());

        System.out.println("Parent.doSomethingMore(String): END");
    }

}
