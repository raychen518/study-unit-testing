package org.raychens.unittesting.mockingmethods.case101.superclassprotectedmethod.b;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.support.membermodification.MemberMatcher.method;
import static org.powermock.api.support.membermodification.MemberModifier.stub;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.raychens.unittesting.mockingmethods.case101.superclassprotectedmethod.a.Parent;

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

        String resultFromSuperclassProtectedMethod1 = RandomStringUtils.randomAlphanumeric(5);
        System.out.println("resultFromSuperclassProtectedMethod1: " + resultFromSuperclassProtectedMethod1);

        // Stub the invocation of the superclass protected method to return an
        // expected value, using the PowerMockito.stub(...) method.
        // Get the superclass protected method by the getDeclaredMethod(...)
        // method in the Java Reflection API and using the class under test as
        // the target instead of the superclass if the superclass protected
        // method has been overridden by the class under test.
        stub(Child.class.getDeclaredMethod("doSomething", String.class)).toReturn(resultFromSuperclassProtectedMethod1);

        String resultFromSuperclassProtectedMethod2 = RandomStringUtils.randomAlphanumeric(5);
        System.out.println("resultFromSuperclassProtectedMethod2: " + resultFromSuperclassProtectedMethod2);

        // Stub the invocation of the superclass protected method to return an
        // expected value, using the PowerMockito.stub(...) method.
        // Get the superclass protected method by the PowerMockito.method(...)
        // method and using the superclass as the target if the superclass
        // protected method has not been overridden by the class under test.
        stub(method(Parent.class, "doSomethingMore", String.class)).toReturn(resultFromSuperclassProtectedMethod2);

        String result = child.doSomething(string);

        String expectedResult = resultFromSuperclassProtectedMethod1 + resultFromSuperclassProtectedMethod2 + "[Child]"
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
