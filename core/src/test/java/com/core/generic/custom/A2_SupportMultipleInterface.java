package com.core.generic.custom;

import java.io.*;

/**
 * @Ref - https://youtu.be/LEAoMMEIUXk?t=524
 */
public class A2_SupportMultipleInterface {

    public static void main(String[] args) throws IOException {
        write();

        DataInputStream stream = new DataInputStream(new FileInputStream("src/main/resources/person"));
        Person person = read(stream);
        System.out.println(person);

        RandomAccessFile randomAccess = new RandomAccessFile("src/main/resources/person","rw");
        person = read(randomAccess);
        System.out.println(person);
    }

//    interface DataInputCloseable extends DataInput, Cloneable {}
//    private static Person read(DataInputCloseable source) {}
// --> It can read the content from DataInput & Closeable which is not possible by interface alone.
    private static<T extends DataInput & Closeable> Person read(T source) {
        try(T input = source){
          return new Person(input.readUTF(), input.readInt());
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void write(){
        try(DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("src/main/resources/person"))){
            outputStream.writeUTF("Sunil");
            outputStream.writeInt(30);
        }catch (IOException e){
         e.printStackTrace();
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
