package org.raychens.unittesting.mockingmethods.case102.superclassprotectedmethod.b;

import org.raychens.unittesting.mockingmethods.case102.superclassprotectedmethod.a.Parent;

public class Child extends Parent {

    @Override
    protected String doSomething(String string) {
        System.out.println("Child.doSomething(String): START");

        String resultPart1 = super.doSomething(string + "1");
        String resultPart2 = super.doSomething(string + "2");
        String resultPart3 = doSomethingMore(string + "1");
        String resultPart4 = doSomethingMore(string + "2");
        String result = resultPart1 + resultPart2 + resultPart3 + resultPart4 + "[Child]" + string.toLowerCase();
        System.out.println("Child.doSomething(String): result: " + result);

        System.out.println("Child.doSomething(String): END");
        return result;
    }

}
