package aaa.bbb.ccc.y;

import aaa.bbb.ccc.x.Parent;

public class Child extends Parent {

    @Override
    protected void doSomething(Object object) {
        System.out.println("Child.doSomething(Object): BEGIN");

        // Invoke a protected superclass method.
        super.doSomething(object);

        // Invoke another protected superclass method.
        Object someObject = doSomethingWithReturn("abc", 123, true);
        System.out.println("Child.doSomething(Object): someObject: " + someObject);

        System.out.println("Child.doSomething(Object): END");
    }

}
