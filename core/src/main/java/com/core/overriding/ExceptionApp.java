package com.core.overriding;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Sunil
 */
public class ExceptionApp {

}

interface Colorable {

    public List color() throws IOException;
}

class Toy implements Colorable {

    @Override
    public List color() {
        System.out.println("coloring Toy");
        return null;
    }

}

class Machine implements Colorable {

    @Override
    public List color() throws RuntimeException {
        System.out.println("coloring machine");
        return null;
    }

}

class Device implements Colorable {

    @Override
    public List color() throws IOException, RuntimeException {
        System.out.println("coloring Device");
        return null;
    }

}
