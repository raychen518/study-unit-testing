package aaa.bbb.ccc.y;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.support.membermodification.MemberMatcher.method;
import static org.powermock.api.support.membermodification.MemberModifier.stub;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import aaa.bbb.ccc.x.Parent;

// Use PowerMock to run the tests.
@RunWith(PowerMockRunner.class)
// Tell PowerMock to prepare the aaa.bbb.ccc.x.Parent class for the testing.
@PrepareForTest(Parent.class)
public class ChildTest {

    @Test
    public void test_doSomething() throws Exception {
        // Create an instance of the class to test.
        // If some interactions of the instance need to be verified later, the
        // instance must be created as a spy object, using the Mockito.spy(...)
        // method.
        Child child = spy(new Child());

        // Prepare the parameter of the method to test.
        Object object = mock(Object.class);

        // The invocation of the protected superclass method -
        // aaa.bbb.ccc.x.Parent.doSomething(Object) can be stubbed here now
        // because even that method is invisible here PowerMock supports
        // stubbing the invocations of invisible methods.
        // To stub an invocation of an invisible method without return using
        // PowerMock, the following approach can be adopted.
        // (1) First, get the target method using the PowerMockito.method(...)
        // method.
        // (2) Then, stub (suppress) the invocation of the target method using
        // the PowerMockito.suppress(...) method.
        suppress(method(Parent.class, "doSomething", Object.class));

        // The invocation of the protected superclass method -
        // aaa.bbb.ccc.x.Parent.doSomethingWithReturn(String, int, boolean) can
        // be stubbed here now because even that method is invisible here
        // PowerMock supports stubbing the invocations of invisible methods.
        // To stub an invocation of an invisible method with return using
        // PowerMock, the following approach can be adopted.
        // (1) First, get the target method using the PowerMockito.method(...)
        // method.
        // (2) Then, stub the invocation of the target method using the
        // PowerMockito.stub(...) method.
        stub(method(Parent.class, "doSomethingWithReturn", String.class, int.class, boolean.class))
                .toReturn(mock(Object.class));

        // Execute the method to test.
        child.doSomething(object);

        // The invocations of those 2 protected superclass methods can be
        // verified here now because even those 2 methods are invisible here
        // PowerMock supports verifying the invocations of invisible methods.
        // To verify an invocation of an invisible method using PowerMock, the
        // PowerMockito.verifyPrivate(...) method can be used.
        // Note: Only the invocation of the protected superclass method -
        // aaa.bbb.ccc.x.Parent.doSomething(Object) is verified here since the
        // protected superclass method -
        // aaa.bbb.ccc.x.Parent.doSomethingWithReturn(String, int, boolean) has
        // a return and usually there is no need to verify an invocation of a
        // method with a return.
        verifyPrivate(child).invoke("doSomething", object);
    }

}
