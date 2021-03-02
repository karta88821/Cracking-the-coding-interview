import java.util.*;

public class Hello {

    public static void main(String[] args) {
        /*
        MyAnimalList myAnimalList = new MyAnimalList();
        
        Dog dog = new Dog();
        Cat cat = new Cat();
        myAnimalList.addAnimal(dog);
        myAnimalList.addAnimal(cat);

        for (Animal animal : myAnimalList.getAnimals()) {
            animal.makeNoise();
        }
        */
        
        // System.out.println(String.format("%, d", 1000000));

        /*
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 2);
        System.out.println(c.getTime());
        */
    }

    public void takeAnimal(ArrayList<? extends Animal> animals) {
        
    }

    public <T extends Animal> void takeAnimal(ArrayList<T> animals1, ArrayList<T> animals2) {

    }
} 

interface Pet {
    abstract void beFriendly();
    abstract void play();
}

class MyAnimalList {
    private ArrayList<Animal> animals = new ArrayList<Animal>();

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal a) {
        animals.add(a);
    }
}



abstract class Animal {
    abstract void makeNoise();
    abstract void eat();
    void sleep() {
        System.out.println("Sleeping...");
    }
    abstract void roam();
}

abstract class Feline extends Animal {
    void roam() {
        System.out.println("Feline roam.");
    }
}

abstract class Canine extends Animal {
    void roam() {
        System.out.println("Canine roam.");
    }
}

class Lion extends Feline {

    @Override
    void makeNoise() {
        System.out.println("Oh~~");
    }

    @Override
    void eat() {
        System.out.println("Lion eating~~");
    }

}

class Tiger extends Feline {

    @Override
    void makeNoise() {
        System.out.println("RRR~~");
    }

    @Override
    void eat() {
        System.out.println("Tiger eating~~");
    }

}

class Cat extends Feline implements Pet {

    @Override
    void makeNoise() {
        System.out.println("meow~~");
    }

    @Override
    void eat() {
        System.out.println("Cat eating~~");
    }

    @Override
    public void beFriendly() {
        // TODO Auto-generated method stub

    }

    @Override
    public void play() {
        // TODO Auto-generated method stub

    }

}

class Hippo extends Animal {

    @Override
    void makeNoise() {
        System.out.println("Hippo noise");

    }

    @Override
    void eat() {
        System.out.println("Hippo eating");
    }

    @Override
    void roam() {
        System.out.println("Hippo roam");
    }

}


class Dog extends Canine implements Pet {

    @Override
    void makeNoise() {
        System.out.println("wo wo~~");
    }

    @Override
    void eat() {
        System.out.println("Dog eating~~");
    }

    @Override
    public void beFriendly() {
        // TODO Auto-generated method stub

    }

    @Override
    public void play() {
        // TODO Auto-generated method stub

    }

}

class Wolf extends Canine {

    @Override
    void makeNoise() {
        System.out.println("oooo~~");
    }

    @Override
    void eat() {
        System.out.println("Wolf eating~~");
    }

}

class Home {
    Integer number;

    public Home() {
        this(1);
    }

    public Home(int i) {
    }
}

class Constant {

    static final int KEY;

    static {
        KEY = 123;
    }

    void test(Integer a) {
        int aa = a;
        
    }
}