package org.raychens.unittesting.mockingmethods.case103.superclassprotectedmethod.b;

import static org.mockito.Mockito.spy;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.support.membermodification.MemberMatcher.method;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.raychens.unittesting.mockingmethods.case103.superclassprotectedmethod.a.Parent;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(PowerMockRunner.class)
// Put the superclass in the list of the classes preparing for test.
@PrepareForTest(Parent.class)
public class ChildTest {

    @Test
    public void test_doSomething() throws Exception {
        // Create the object to test as a spy object, if its interactions will
        // be verified later.
        Child child = spy(new Child());

        String string = RandomStringUtils.randomAlphanumeric(5);
        System.out.println("string: " + string);

        // Get the superclass protected method using the
        // PowerMockito.method(...) method then suppress its invocation using
        // the PowerMockito.suppress(...) method.
        suppress(method(Parent.class, "doSomething", String.class));
        suppress(method(Parent.class, "doSomethingMore", String.class));

        child.doSomething(string);

        // Verify the invocation of the superclass protected method, using the
        // PowerMockito.verifyPrivate(...) method.
        verifyPrivate(child).invoke("doSomething", string);
        verifyPrivate(child).invoke("doSomethingMore", string);
    }

    @Test
    public void test_doSomething_withoutMocking() {
        Child child = new Child();

        String string = RandomStringUtils.randomAlphanumeric(5);
        System.out.println("string: " + string);

        child.doSomething(string);
    }

}
