package com.example.robodog.service;

import com.example.robodog.model.Breed;
import com.example.robodog.model.Dog;

import java.util.ArrayList;
import java.util.List;

public class DogStorage {
    private final List<Dog> dogs = new ArrayList<>();
    private final DogCreator dogCreator = new DogCreator();

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void addRandomDog() {
        dogs.add(dogCreator.createRandomDog());
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public boolean updateDog(String name, int newAge, Breed newBreed) {
        for (Dog dog : dogs) {
            if (dog.getName().equals(name)) {
                dog.setAge(newAge);
                dog.setBreed(newBreed);
                return true;
            }
        }
        return false;
    }
}
