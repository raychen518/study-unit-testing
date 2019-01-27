package org.raychens.unittesting.mockingmethods.case002.privatestaticmethod;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(PowerMockRunner.class)
// Put the class under test in the list of the classes preparing for test.
@PrepareForTest(SomeObject.class)
public class SomeObjectTest {

    @Test
    public void test_doSomething() throws Exception {
        SomeObject someObject = new SomeObject();

        String string = RandomStringUtils.randomAlphanumeric(5);
        System.out.println("string: " + string);

        String resultFromPrivateAndStaticMethod = RandomStringUtils.randomAlphanumeric(5);
        System.out.println("resultFromPrivateAndStaticMethod: " + resultFromPrivateAndStaticMethod);
        // Invoke the PowerMockito.mockStatic(...) method here.
        mockStatic(SomeObject.class);
        // Use the PowerMockito.when(...) method instead of the
        // Mockito.when(...) method here.
        when(SomeObject.class, "doSomethingPrivatelyAndStatically", string)
                .thenReturn(resultFromPrivateAndStaticMethod);

        String result = someObject.doSomething(string);

        assertEquals(resultFromPrivateAndStaticMethod + "[doSomething]" + string.toLowerCase(), result);
    }

    // @Test
    public void test_doSomething_withoutMocking() {
        SomeObject someObject = new SomeObject();

        String string = RandomStringUtils.randomAlphanumeric(5);
        System.out.println("string: " + string);

        someObject.doSomething(string);
    }

}
