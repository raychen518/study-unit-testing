package org.raychens.unittesting.mockingmethods.case102.superclassprotectedmethod.b;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.support.membermodification.MemberMatcher.method;
import static org.powermock.api.support.membermodification.MemberModifier.replace;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.raychens.unittesting.mockingmethods.case102.superclassprotectedmethod.a.Parent;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(PowerMockRunner.class)
// Put the superclass in the list of the classes preparing for test.
@PrepareForTest(Parent.class)
public class ChildTest {

    @Test
    public void test_doSomething() throws Exception {
        Child child = new Child();

        String string = RandomStringUtils.randomAlphanumeric(5);
        System.out.println("string: " + string);

        String result1FromSuperclassProtectedMethod1 = RandomStringUtils.randomAlphanumeric(5);
        System.out.println("result1FromSuperclassProtectedMethod1: " + result1FromSuperclassProtectedMethod1);

        String result2FromSuperclassProtectedMethod1 = RandomStringUtils.randomAlphanumeric(5);
        System.out.println("result2FromSuperclassProtectedMethod1: " + result2FromSuperclassProtectedMethod1);

        // Replace the superclass protected method with the specified method
        // invocation handler, using the PowerMockito.replace(...) method.
        // Get the superclass protected method by the getDeclaredMethod(...)
        // method in the Java Reflection API and using the class under test as
        // the target instead of the superclass if the superclass protected
        // method has been overridden by the class under test.
        replace(Child.class.getDeclaredMethod("doSomething", String.class)).with(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String result;

                // Specify the different results for the invocations of the
                // superclass protected method which have different method
                // arguments.
                String methodArgument1 = (String) args[0];
                if (methodArgument1.equals(string + 1)) {
                    result = result1FromSuperclassProtectedMethod1;
                } else if (methodArgument1.equals(string + 2)) {
                    result = result2FromSuperclassProtectedMethod1;
                } else {
                    result = StringUtils.EMPTY;
                }

                return result;
            }
        });

        String result1FromSuperclassProtectedMethod2 = RandomStringUtils.randomAlphanumeric(5);
        System.out.println("result1FromSuperclassProtectedMethod2: " + result1FromSuperclassProtectedMethod2);

        String result2FromSuperclassProtectedMethod2 = RandomStringUtils.randomAlphanumeric(5);
        System.out.println("result2FromSuperclassProtectedMethod2: " + result2FromSuperclassProtectedMethod2);

        // Replace the superclass protected method with the specified method
        // invocation handler, using the PowerMockito.replace(...) method.
        // Get the superclass protected method by the PowerMockito.method(...)
        // method and using the superclass as the target if the superclass
        // protected method has not been overridden by the class under test.
        replace(method(Parent.class, "doSomethingMore", String.class)).with(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String result;

                // Specify the different results for the invocations of the
                // superclass protected method which have different method
                // arguments.
                String methodArgument1 = (String) args[0];
                if (methodArgument1.equals(string + 1)) {
                    result = result1FromSuperclassProtectedMethod2;
                } else if (methodArgument1.equals(string + 2)) {
                    result = result2FromSuperclassProtectedMethod2;
                } else {
                    result = StringUtils.EMPTY;
                }

                return result;
            }
        });

        String result = child.doSomething(string);

        String expectedResult = result1FromSuperclassProtectedMethod1 + result2FromSuperclassProtectedMethod1
                + result1FromSuperclassProtectedMethod2 + result2FromSuperclassProtectedMethod2 + "[Child]"
                + string.toLowerCase();
        assertEquals(expectedResult, result);
    }

    @Test
    public void test_doSomething_withoutMocking() {
        Child child = new Child();

        String string = RandomStringUtils.randomAlphanumeric(5);
        System.out.println("string: " + string);

        child.doSomething(string);
    }

}
