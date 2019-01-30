package xxx.yyy.zzz.b;

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
        // xxx.yyy.zzz.a.Parent.doSomething(Object) cannot be stubbed here since
        // that method is invisible here.
        // ...

        // The invocation of the protected superclass method -
        // xxx.yyy.zzz.a.Parent.doSomethingWithReturn(String, int, boolean)
        // cannot be stubbed here since that method is invisible here.
        // ...

        // Execute the method to test.
        child.doSomething(object);

        // The invocations of those 2 protected superclass methods cannot be
        // verified here since those 2 methods are invisible here.
        // ...
    }

}
