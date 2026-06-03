class Animal {

    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

public class Exercise18_InheritanceExample {

    public static void main(String[] args) {

        Animal animalObject = new Animal();
        Dog dogObject = new Dog();

        animalObject.makeSound();
        dogObject.makeSound();
    }
}