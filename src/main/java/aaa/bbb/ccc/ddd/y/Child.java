package aaa.bbb.ccc.ddd.y;

import aaa.bbb.ccc.ddd.x.Parent;

public class Child extends Parent {

    protected void doSomething() {
        System.out.println("Child.doSomething(): BEGIN");

        // Invoke the protected superclass method for the 1st time.
        String someString1 = doSomethingWithReturn("abc", 123, true);
        System.out.println("Child.doSomething(): someString1: " + someString1);

        // Invoke the protected superclass method for the 2nd time.
        String someString2 = doSomethingWithReturn("def", 456, true);
        System.out.println("Child.doSomething(): someString2: " + someString2);

        // Invoke the protected superclass method for the 3rd time.
        String someString3 = doSomethingWithReturn("ghi", 789, false);
        System.out.println("Child.doSomething(): someString3: " + someString3);

        System.out.println("Child.doSomething(): END");
    }

}
