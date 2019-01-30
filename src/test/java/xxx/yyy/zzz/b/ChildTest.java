package xxx.yyy.zzz.b;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.support.membermodification.MemberMatcher.method;
import static org.powermock.api.support.membermodification.MemberModifier.stub;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import xxx.yyy.zzz.a.Parent;

// Use PowerMock to run the tests.
@RunWith(PowerMockRunner.class)
// Tell PowerMock to prepare the xxx.yyy.zzz.a.Parent class for the tests.
@PrepareForTest(Parent.class)
// Tell PowerMock to ignore (actually defer) the loading of the given classes.
// Note: This setting is only needed when the [Could Not Reconfigure JMX] error
// occurs.
@PowerMockIgnore({ "javax.management.*" })
public class ChildTest {

    @Test
    public void test_doSomething() throws Exception {
        // Create an instance of the class to test.
        // Create the object to test as a spy object if its interactions need to
        // be verified later, using the Mockito.spy(...) method.
        Child child = spy(new Child());

        // Prepare the parameter of the method to test.
        Object object = mock(Object.class);

        // Stub the invocation (super.doSomething()) of the invisible
        // xxx.yyy.zzz.a.Parent.doSomething() method by first (1) getting the
        // method using the PowerMockito.method(...) method; (2) then
        // suppressing the invocation of the method using the
        // PowerMockito.suppress(...) method.
        suppress(method(Parent.class, "doSomething"));

        // Stub the invocation (doSomethingWithReturn()) of the invisible
        // xxx.yyy.zzz.a.Parent.doSomethingWithReturn() method by first (1)
        // getting the method using the PowerMockito.method(...) method; (2)
        // then stubbing the invocation of the method using the
        // PowerMockito.stub(...) method.
        stub(method(Parent.class, "doSomethingWithReturn")).toReturn(mock(Object.class));

        // Prepare the parameter of the method to test.
        child.doSomething(object);

        // Verify the invocations of the protected superclass methods, using the
        // PowerMockito.verifyPrivate(...) method.
        verifyPrivate(child).invoke("doSomething");
    }

}
