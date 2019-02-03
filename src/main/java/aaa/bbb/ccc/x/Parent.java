package aaa.bbb.ccc.x;

public class Parent {

    private Object someObject;

    protected void doSomething(Object object) {
        System.out.println("Parent.doSomething(Object): BEGIN");

        // Do something...
        System.out.println("Parent.doSomething(Object): Doing Something...");

        System.out.println("Parent.doSomething(Object): END");
    }

    protected Object doSomethingWithReturn(String string, int integer, boolean bool) {
        System.out.println("Parent.doSomethingWithReturn(String, int, boolean): BEGIN");

        // Do something...
        System.out.println("Parent.doSomethingWithReturn(String, int, boolean): Doing Something...");

        System.out.println("Parent.doSomethingWithReturn(String, int, boolean): END");
        return someObject;
    }

}
