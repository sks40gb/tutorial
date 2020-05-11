package com.core.generic.custom;

public class A3_Cloneable {

    public static void main(String[] args) {
        ConfusedPerson1 person1 = new ConfusedPerson1("John");
        //Wrong implementation of cloning
//        ConfusedPerson1 clone1 = person1.clone();
        ConfusedPerson2 person2 = new ConfusedPerson2("Jack");
        ConfusedPerson2 clone2 = person2.clone();
    }
}


//---- This will allow to clone anything -------------
interface Cloneable1<T>{
    T clone();
}

class ConfusedPerson1 implements Cloneable1<String>{
    private String name;
    private int age;

    public ConfusedPerson1(String name) {
        this.name = name;
    }

    @Override
    public String clone() {
        return this.name;
    }
}

//--- This will ensure to clone in right way

interface Cloneable2<T extends Cloneable2<T>>{
    T clone();
}

class ConfusedPerson2 implements Cloneable2<ConfusedPerson2>{
    private String name;
    private int age;


    public ConfusedPerson2(String name) {
        this.name = name;
    }

    @Override
    public ConfusedPerson2 clone() {
        return new ConfusedPerson2(this.name);
    }
}
