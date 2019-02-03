package aaa.bbb.ccc.ddd.x;

public class Parent {

    private String someString;

    protected String doSomethingWithReturn(String string, int integer, boolean bool) {
        System.out.println("Parent.doSomethingWithReturn(String, int, boolean): BEGIN");

        // Do something...
        System.out.println("Parent.doSomethingWithReturn(String, int, boolean): Doing Something...");

        System.out.println("Parent.doSomethingWithReturn(String, int, boolean): END");
        return someString;
    }

}
