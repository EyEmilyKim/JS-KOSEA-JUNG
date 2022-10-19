package Oct18;

interface My {
   //상수
   static final int VALUE = 100; //상수
   //추상메소드
   abstract void doIt();
}

class Cat{int a; void doIt() {}}
abstract class Dog{
   void doIt() {
      int sum = My.VALUE;
   }//일반 메소드

}
class MyDog extends Dog{

   @Override
   void doDo() {   }

   @Override
   void doThat() {   }
}

public class Study3 {
   public static void main(String[] args) {
      Cat c = new Cat(); c.a=10; c.doIt();
      //Dog d = new Dog();
   }
}