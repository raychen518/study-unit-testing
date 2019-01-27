package org.raychens.unittesting.mockingmethods.case001.privatemethod;

public class SomeObject {

    public String doSomething(String string) {
        System.out.println("doSomething(String): START");

        String result = doSomethingPrivately(string) + "[doSomething]" + string.toLowerCase();
        System.out.println("doSomething(String): result: " + result);

        System.out.println("doSomething(String): END");
        return result;
    }

    private String doSomethingPrivately(String string) {
        System.out.println("doSomethingPrivately(String): START");

        String result = "[doSomethingPrivately]" + string.toUpperCase();
        System.out.println("doSomethingPrivately(String): result: " + result);

        System.out.println("doSomethingPrivately(String): END");
        return result;
    }

}
