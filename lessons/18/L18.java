
import java.lang.*;

class A {
  void method() {
    System.out.println("A");
  }
}

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
  }
}
