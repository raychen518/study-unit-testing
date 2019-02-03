package aaa.bbb.ccc.y;

import static org.mockito.Mockito.mock;

import org.junit.Test;

public class ChildTest2 {

    @Test
    public void test_doSomething() {
        // Create an instance of the class to test.
        Child child = new Child();

        // Prepare the parameter of the method to test.
        Object object = mock(Object.class);

        // The invocation of the protected superclass method -
        // aaa.bbb.ccc.x.Parent.doSomething(Object) cannot be stubbed here
        // because that method is invisible here and Mockito doesn't support
        // stubbing the invocations of invisible methods.
        // ...

        // The invocation of the protected superclass method -
        // aaa.bbb.ccc.x.Parent.doSomethingWithReturn(String, int, boolean)
        // cannot be stubbed here because that method is invisible here and
        // Mockito doesn't support stubbing the invocations of invisible
        // methods.
        // ...

        // Execute the method to test.
        child.doSomething(object);

        // The invocations of those 2 protected superclass methods cannot be
        // verified here because those 2 methods are invisible here and Mockito
        // doesn't support verifying the invocations of invisible methods.
        // ...
    }

}
