package p1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

interface I1 {

    void m1();

    void m2();

}

class C1 implements I1 {

    public int a;
    public int b;
    public int c;
    public int d;

    C1() {
        System.out.println("Default Constructor");
    }

    public C1(int a, int b) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "C1{" + "a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + '}';
    }

    @Override
    public void m1() {
        System.out.println("m1 of c1");
    }

    @Override
    public void m2() {
        System.out.println("m2 of c1");
    }

}

class Main {

    public static void main(String[] args) throws Exception {

        Class t = Class.forName("p1.C1");
        Object o = t.newInstance();
        System.out.println("Name of Class " + t.getName());
        System.out.println("Canonical Name of Class " + t.getCanonicalName());
        System.out.println("Simple Name of Class " + t.getSimpleName());
        System.out.println("Type Name of Class " + t.getTypeName());
        Constructor c[] = t.getDeclaredConstructors();
        for (Constructor cc : c) {
            System.out.println(cc.getName());
            System.out.println(cc.getModifiers());
            System.out.println(cc.getParameterCount());
            if (cc.getParameterCount() != 0) {
                o = cc.newInstance(3, 2);
                int i = o.getClass().getField("a").getInt(o);
                int j = o.getClass().getField("b").getInt(o);
                System.out.println("a=" + i);
                System.out.println("b=" + j);
            } else {
                int i = o.getClass().getField("a").getInt(o);
                int j = o.getClass().getField("b").getInt(o);
                System.out.println("a=" + i);
                System.out.println("b=" + j);
            }
            Field ff[] = t.getFields();
            for (Field f : ff) {
                System.out.println(f.getName());
            }

            Method m[] = t.getMethods();
            Method mm[] = t.getDeclaredMethods();
            for (Method mtd : mm) {
                System.out.println(mtd.getName());
                System.out.println(mtd.getParameterCount());
                System.out.println(mtd.getReturnType());

            }
        }
    }
}
