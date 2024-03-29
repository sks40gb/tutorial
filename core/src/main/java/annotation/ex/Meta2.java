package annotation.ex;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {

    String str();

    int val() default 1;
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {

    String description();
}

@What(description = "An annotation test class")
@MyAnno(str = "Meta2", val = 99)
public class Meta2 {
    
    @What(description = "An annotation test method")
    @MyAnno(str = "Testing", val = 100)
    public static void myMeth() {
        Meta2 ob = new Meta2();

        try {
            MyAnno myAnno = ob.getClass().getAnnotation(MyAnno.class);
            System.out.println(myAnno.str() + " : " + myAnno.val());
            Method m = ob.getClass().getMethod("myMeth", null);
            System.out.println(m.getAnnotation(What.class).description());

        } catch (Exception exc) {
            System.out.println("Method Not Found.");
        }
    }

    public static void main(String args[]) {
        myMeth();
    }
}
