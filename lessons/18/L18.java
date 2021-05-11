
import java.lang.*;
import java.lang.annotation.*;
import java.lang.reflect.*;

class A {
  void method() {
    System.out.println("A");
  }
}

// объявление типа аннотации
@interface SomeAnnotation {
  String description();
}

// аннотация
@SomeAnnotation(description = "")
class B extends A {
  // если опечататься в названии
  // (например, mehtod), то компилятор
  // выдаст ошибку, если есть аннотация
  // Override
  @Override
  void method() {
    System.out.println("B");
  }
}

public class L18 {
  public static void main(String[] args) {
    A obj = new B();
    obj.method();
    System.out.println("Class of obj: " + obj.getClass().getName());
    System.out.println("Class of B: " + B.class.getName());
    for (Method m : B.class.getDeclaredMethods()) {
      System.out.println("Method: " + m.getName());
    }
  }
}
