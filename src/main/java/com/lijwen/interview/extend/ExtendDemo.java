package com.lijwen.interview.extend;

public class ExtendDemo {


}


class Base {
    public static void main(String[] args) {
        Base[] test = new Base[]{new Base(), new Child()};
        for (int i = 0; i < test.length; i++) {
            test[i].Iam(new Child());
        }
    }

    void Iam(Base b) {
        System.out.println("Base;Overload");
    }

    void Iam(Child c) {
        System.out.println("Child;Overload");
    }
}

class Child extends Base {
    void Iam(Base b) {
        System.out.println("Base;Override");
    }

    void Iam(Child c) {
        System.out.println("Child;Override");
    }
}