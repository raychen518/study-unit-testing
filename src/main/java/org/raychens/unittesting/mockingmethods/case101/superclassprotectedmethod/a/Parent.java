package org.raychens.unittesting.mockingmethods.case101.superclassprotectedmethod.a;

public class Parent {

    protected String doSomething(String string) {
        System.out.println("Parent.doSomething(String): START");

        String result = "[Parent]" + string.toUpperCase();
        System.out.println("Parent.doSomething(String): result: " + result);

        System.out.println("Parent.doSomething(String): END");
        return result;
    }

    protected String doSomethingMore(String string) {
        System.out.println("Parent.doSomethingMore(String): START");

        String result = "[Parent]" + string.hashCode();
        System.out.println("Parent.doSomethingMore(String): result: " + result);

        System.out.println("Parent.doSomethingMore(String): END");
        return result;
    }

}
