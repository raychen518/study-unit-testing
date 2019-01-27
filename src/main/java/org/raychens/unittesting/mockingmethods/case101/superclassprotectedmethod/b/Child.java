package org.raychens.unittesting.mockingmethods.case101.superclassprotectedmethod.b;

import org.raychens.unittesting.mockingmethods.case101.superclassprotectedmethod.a.Parent;

public class Child extends Parent {

    @Override
    protected String doSomething(String string) {
        System.out.println("Child.doSomething(String): START");

        String result = super.doSomething(string) + doSomethingMore(string) + "[Child]" + string.toLowerCase();
        System.out.println("Child.doSomething(String): result: " + result);

        System.out.println("Child.doSomething(String): END");
        return result;
    }

}
