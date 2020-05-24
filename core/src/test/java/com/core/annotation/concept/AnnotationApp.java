package com.core.annotation.concept;

@ClassPreamble(author = "Sunil", date = "23 jan 2014")
public class AnnotationApp {

    /**
     * test here for field
     */
    @FieldAnnotation(id = 1, name = "sunil")
    private String str;

    public static void main(String arg[]) {
        new AnnotationApp().doTestTarget();
    }

    @MethodAnnotation(shape = MethodAnnotation.Shape.CUBE, source = "me")
    public void doTestTarget() {
        System.out.print("Testing Target annotation");
    }
}
