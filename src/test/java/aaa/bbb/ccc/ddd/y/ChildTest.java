package aaa.bbb.ccc.ddd.y;

import static org.powermock.api.support.membermodification.MemberMatcher.method;
import static org.powermock.api.support.membermodification.MemberModifier.replace;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import aaa.bbb.ccc.ddd.x.Parent;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Parent.class)
public class ChildTest {

    @Test
    public void test_doSomething() throws Exception {
        // Create an instance of the class to test.
        Child child = new Child();

        // The invocation of the protected superclass method -
        // aaa.bbb.ccc.ddd.x.Parent.doSomethingWithReturn(String, int, boolean)
        // can be stubbed here now because even that method is invisible here
        // PowerMock supports stubbing the invocations of invisible methods.
        // To stub an invocation of an invisible method with return using
        // PowerMock, while that method has been invoked using different
        // parameters, the following approach can be adopted.
        // (1) First, get the target method using the PowerMockito.method(...)
        // method.
        // (2) Then, stub (replace) the invocation of the target method using
        // the PowerMockito.replace(...) method.
        replace(method(Parent.class, "doSomethingWithReturn", String.class, int.class, boolean.class))
                .with(new InvocationHandler() {

                    // Per the different method arguments, the protected
                    // superclass method -
                    // aaa.bbb.ccc.ddd.x.Parent.doSomethingWithReturn(String,
                    // int, boolean) returns the different results.
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String result;

                        String argument1 = (String) args[0];
                        int argument2 = (int) args[1];
                        boolean argument3 = (boolean) args[2];
                        if (argument3) {
                            result = new StringBuilder().append(argument1).append("+").append(argument2).toString();
                        } else {
                            result = new StringBuilder().append(argument1).append("-").append(argument2).toString();
                        }

                        return result;
                    }

                });

        // Execute the method to test.
        child.doSomething();
    }

}
