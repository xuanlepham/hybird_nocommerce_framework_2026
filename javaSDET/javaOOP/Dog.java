package javaOOP;

public class Dog extends Animals{
    public static void main(String[] args){
        Dog dog = new Dog(); // khai báo object đại diện cho class

        System.out.println(dog.animalAge);

        dog.setAnimalName("shiba");
        System.out.println(dog.getAnimalName());
    }
}
