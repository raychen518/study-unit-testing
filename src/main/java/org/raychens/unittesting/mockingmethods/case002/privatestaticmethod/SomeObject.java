package org.raychens.unittesting.mockingmethods.case002.privatestaticmethod;

public class SomeObject {

    private static String doSomethingPrivatelyAndStatically(String string) {
        System.out.println("doSomethingPrivatelyAndStatically(String): START");

        String result = "[doSomethingPrivatelyAndStatically]" + string.toUpperCase();
        System.out.println("doSomethingPrivatelyAndStatically(String): result: " + result);

        System.out.println("doSomethingPrivatelyAndStatically(String): END");
        return result;
    }

    public String doSomething(String string) {
        System.out.println("doSomething(String): START");

        String result = doSomethingPrivatelyAndStatically(string) + "[doSomething]" + string.toLowerCase();
        System.out.println("doSomething(String): result: " + result);

        System.out.println("doSomething(String): END");
        return result;
    }

}
