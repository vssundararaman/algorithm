package SHL;

public class ParentChildExample {

    public static void main(String[] args) {
        Child child = new Child("Hello");

    }
}

class Parent{
 static String name = "ParentName";
    Parent(String name){
        System.out.println("Parent Constructor " + name);
    }
    Parent(){
        System.out.println("Parent Constructor " + name);
    }
}

class Child extends Parent{
    String name;
    Child(String name){
        super();
        System.out.println("Child Constructor " + name);
    }
}
