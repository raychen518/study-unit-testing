package org.raychens.unittesting.mockingmethods.case103.superclassprotectedmethod.b;

import org.raychens.unittesting.mockingmethods.case103.superclassprotectedmethod.a.Parent;

public class Child extends Parent {

    @Override
    protected void doSomething(String string) {
        System.out.println("Child.doSomething(String): START");

        super.doSomething(string);
        doSomethingMore(string);
        System.out.println("Child.doSomething(String): string.toLowerCase(): " + string.toLowerCase());

        System.out.println("Child.doSomething(String): END");
    }

}
