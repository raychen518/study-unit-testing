package org.raychens.unittesting.mockito.argumentmatchers;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyMapOf;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyVararg;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * <p>
 * This test class demonstrates how to use the argument matchers for flexible
 * stubbing and verification.
 * </p>
 *
 * <p>
 * It should be reasonable to use complicated argument matching, since the
 * natural matching style using the equals(...) method with occasional
 * anyXxx(...) argument matchers tend to give clean and simple tests. Sometimes
 * it's just better to refactor/implement the code to allow the matching using
 * the equals(...) method in the testing.
 * </p>
 *
 * <p>
 * When an argument matcher is used in one stubbing/invocation, all other
 * arguments in that stubbing/invocation must also be the argument matchers. For
 * a fixed value, using the eq(...) method turns it to an argument matcher.
 * </p>
 */
@FixMethodOrder(NAME_ASCENDING)
public class SomeObjectTest {

    /**
     * <pre>
     * Argument Matchers
     * ========================================================================================================================
     * [ ] 01. anyByte()                        Match any byte value or non-null Byte object.
     * [ ] 02. anyShort()                       Match any short value or non-null Short object.
     * [X] 03. anyInt()                         Match any int value or non-null Integer object.
     * [ ] 04. anyLong()                        Match any long value or non-null Long object.
     * [ ] 05. anyFloat()                       Match any float value or non-null Float object.
     * [ ] 06. anyDouble()                      Match any double value or non-null Double object.
     * [X] 07. anyBoolean()                     Match any boolean value or non-null Boolean object.
     * [ ] 08. anyChar()                        Match any char value or non-null Character object.
     *
     * [X] 09. anyString()                      Match any non-null String object.
     * [X] 10. anyObject()                      Match anything, including null.
     * [ ] 11. any()                            <Be completely same as anyObject(); actually, be a shorter alias to anyObject()>
     * [X] 12. any(Class<T>)                    Match any object of the specified type, including null.
     *
     * [ ] 13. anyList()                        Match any non-null list.
     * [X] 14. anyListOf(Class<T>)              Match any non-null list which elements are of the specified type.
     * [ ] 15. anySet()                         Match any non-null set.
     * [ ] 16. anySetOf(Class<T>)               Match any non-null set which elements are of the specified type.
     * [ ] 17. anyCollection()                  Match any non-null collection.
     * [ ] 18. anyCollectionOf(Class<T>)        Match any non-null collection which elements are of the specified type.
     * [ ] 19. anyMap()                         Match any non-null map.
     * [X] 20. anyMapOf(Class<K>, Class<V>)     Match any non-null map which keys and values are of the specified types.
     * [X] 21. anyVararg()                      Match any vararg, meaning any number and values of arguments.
     *
     * [X] 22. eq()                             Match any value that is equal to the given value.
     * ========================================================================================================================
     * </pre>
     */

    private static final String COMMON_METHOD_RETURN = "COMMON METHOD RETURN";

    private static final int PROCESS_TIMES = 3;

    @Mock
    private SomeDependency someDependency;

    @InjectMocks
    private SomeObject someObject = new SomeObject();

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void test_03_anyInt_1_unstubbed() {
        someObject.setSomeDependency(new SomeDependency());

        someObject.doSomethingUsingInteger();
    }

    @Test
    public void test_03_anyInt_2_stubbed() {
        when(someDependency.doSomething(anyInt())).thenReturn(COMMON_METHOD_RETURN);

        someObject.doSomethingUsingInteger();

        verify(someDependency, times(PROCESS_TIMES)).doSomething(anyInt());
    }

    @Test
    public void test_07_anyBoolean_1_unstubbed() {
        someObject.setSomeDependency(new SomeDependency());

        someObject.doSomethingUsingBoolean();
    }

    @Test
    public void test_07_anyBoolean_2_stubbed() {
        when(someDependency.doSomething(anyBoolean())).thenReturn(COMMON_METHOD_RETURN);

        someObject.doSomethingUsingBoolean();

        verify(someDependency, times(PROCESS_TIMES)).doSomething(anyBoolean());
    }

    @Test
    public void test_09_anyString_1_unstubbed() {
        someObject.setSomeDependency(new SomeDependency());

        someObject.doSomethingUsingString();
    }

    @Test
    public void test_09_anyString_2_stubbed() {
        when(someDependency.doSomething(anyString())).thenReturn(COMMON_METHOD_RETURN);

        someObject.doSomethingUsingString();

        verify(someDependency, times(PROCESS_TIMES)).doSomething(anyString());
    }

    @Test
    public void test_10_anyObject_1_unstubbed() {
        someObject.setSomeDependency(new SomeDependency());

        someObject.doSomethingUsingObject();
    }

    @Test
    public void test_10_anyObject_2_stubbed() {
        // A cast to java.lang.Object is necessary here to make the compiler
        // recognize the SomeDependency.doSomething(...) method as
        // SomeDependency.doSomething(Object) instead of some other overloaded
        // method.
        when(someDependency.doSomething((Object) anyObject())).thenReturn(COMMON_METHOD_RETURN);

        someObject.doSomethingUsingObject();

        verify(someDependency, times(PROCESS_TIMES)).doSomething((Object) anyObject());
    }

    @Test
    public void test_12_anyType_1_unstubbed() {
        someObject.setSomeDependency(new SomeDependency());

        someObject.doSomethingUsingType();
    }

    @Test
    public void test_12_anyType_2_stubbed() {
        when(someDependency.doSomething(any(TypeA.class))).thenReturn(COMMON_METHOD_RETURN);
        when(someDependency.doSomething(any(TypeB.class))).thenReturn(COMMON_METHOD_RETURN);
        when(someDependency.doSomething(any(TypeC.class))).thenReturn(COMMON_METHOD_RETURN);

        someObject.doSomethingUsingType();

        verify(someDependency).doSomething(any(TypeA.class));
        verify(someDependency).doSomething(any(TypeB.class));
        verify(someDependency).doSomething(any(TypeC.class));
    }

    @Test
    public void test_14_anyListOf_1_unstubbed() {
        someObject.setSomeDependency(new SomeDependency());

        someObject.doSomethingUsingList();
    }

    @Test
    public void test_14_anyListOf_2_stubbed() {
        when(someDependency.doSomething(anyListOf(Object.class))).thenReturn(COMMON_METHOD_RETURN);

        someObject.doSomethingUsingList();

        verify(someDependency).doSomething(anyListOf(Object.class));
    }

    @Test
    public void test_20_anyMapOf_1_unstubbed() {
        someObject.setSomeDependency(new SomeDependency());

        someObject.doSomethingUsingMap();
    }

    @Test
    public void test_20_anyMapOf_2_stubbed() {
        when(someDependency.doSomething(anyMapOf(String.class, Object.class))).thenReturn(COMMON_METHOD_RETURN);

        someObject.doSomethingUsingMap();

        verify(someDependency).doSomething(anyMapOf(String.class, Object.class));
    }

    @Test
    public void test_21_anyVararg_1_unstubbed() {
        someObject.setSomeDependency(new SomeDependency());

        someObject.doSomethingUsingVararg();
    }

    @Test
    public void test_21_anyVararg_2_stubbed() {
        // A cast to java.lang.Object[] is necessary here to make the compiler
        // recognize the SomeDependency.doSomething(...) method as
        // SomeDependency.doSomething(Object...) instead of some other
        // overloaded method.
        when(someDependency.doSomething((Object[]) anyVararg())).thenReturn(COMMON_METHOD_RETURN);

        someObject.doSomethingUsingVararg();

        verify(someDependency).doSomething((Object[]) anyVararg());
    }

    @Test
    public void test_22_eq_01_unstubbed() {
        someObject.setSomeDependency(new SomeDependency());

        someObject.doSomething02();
    }

    @Test
    public void test_22_eq_02_stubbed() {
        // The InvalidUseOfMatchersException exception occurs if not all method
        // arguments are using the argument matchers.
        when(someDependency.doSomething(anyString(), anyInt(), eq(true))).thenReturn(COMMON_METHOD_RETURN);

        someObject.doSomething02();

        verify(someDependency, times(PROCESS_TIMES)).doSomething(anyString(), anyInt(), eq(true));
    }

    @Test
    public void test_99_general_01_unstubbed() {
        someObject.setSomeDependency(new SomeDependency());

        someObject.doSomething01();
    }

    @Test
    public void test_99_general_02_stubbed() {
        when(someDependency.doSomething(anyString())).thenReturn(COMMON_METHOD_RETURN);
        when(someDependency.doSomething(anyInt())).thenReturn(COMMON_METHOD_RETURN);
        when(someDependency.doSomething(anyBoolean())).thenReturn(COMMON_METHOD_RETURN);
        when(someDependency.doSomething((Object) anyObject())).thenReturn(COMMON_METHOD_RETURN);
        when(someDependency.doSomething(any(Type.class))).thenReturn(COMMON_METHOD_RETURN);
        when(someDependency.doSomething(anyListOf(Object.class))).thenReturn(COMMON_METHOD_RETURN);
        when(someDependency.doSomething(anyMapOf(String.class, Object.class))).thenReturn(COMMON_METHOD_RETURN);
        when(someDependency.doSomething((Object[]) anyVararg())).thenReturn(COMMON_METHOD_RETURN);

        someObject.doSomething01();

        verify(someDependency).doSomething(anyString());
        verify(someDependency).doSomething(anyInt());
        verify(someDependency).doSomething(anyBoolean());
        verify(someDependency).doSomething((Object) anyObject());
        verify(someDependency).doSomething(any(Type.class));
        verify(someDependency).doSomething(anyListOf(Object.class));
        verify(someDependency).doSomething(anyMapOf(String.class, Object.class));
        verify(someDependency).doSomething((Object[]) anyVararg());

    }

}
