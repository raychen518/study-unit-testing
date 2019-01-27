package org.raychens.unittesting.mockito.stubbingbasics;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.mockito.Spy;

@FixMethodOrder(NAME_ASCENDING)
public class SomeObjectTest {

    @Spy
    SomeObject someObject = new SomeObject();

    @Before
    public void setUp() {
        initMocks(this);
        doReturn("abc").when(someObject).doSomething();
    }

    @Test
    public void test1() {
        System.out.println(someObject.doSomething());
    }

    @Test
    public void test2() {
        // ============================================================
        // Stubbing Can Be Overridden
        // ============================================================
        // A common stubbing can be put in the @Before method as a test fixture
        // for some test methods and one test method can also override that
        // common stubbing when necessary.
        doReturn("def").when(someObject).doSomething();
        System.out.println(someObject.doSomething());
    }

    @Test
    public void test3() {
        System.out.println(someObject.doSomething());
    }

    @Test
    public void test4() {
        // ============================================================
        // Stubbed Value Always Returns for Same Method Invocations
        // ============================================================
        // Once stubbed, a method invocation always returns the same stubbed
        // value until its stubbing is overridden.
        System.out.println(someObject.doSomething());
        System.out.println(someObject.doSomething());
        System.out.println(someObject.doSomething());
    }

    @Test
    public void test5() {
        System.out.println(someObject.doSomething());

        doReturn("def").when(someObject).doSomething();
        System.out.println(someObject.doSomething());

        doReturn("ghi").when(someObject).doSomething();
        System.out.println(someObject.doSomething());

        // ============================================================
        // Last Stubbing Is More Important
        // ============================================================
        // It is always the last stubbing that takes effect for a specified
        // method invocation.
        doReturn("jkl").when(someObject).doSomething();
        System.out.println(someObject.doSomething());
        System.out.println(someObject.doSomething());
        System.out.println(someObject.doSomething());
    }

}
