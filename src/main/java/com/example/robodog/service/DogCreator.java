package com.example.robodog.service;

import com.example.robodog.model.Breed;
import com.example.robodog.model.Dog;

import java.util.Random;

public class DogCreator {
    private static final String[] names = {"Buddy", "Rocky", "Bella", "Charlie", "Lucy", "Max", "Molly"};
    private static final Breed[] breeds = Breed.values();

    public Dog createRandomDog() {
        Random random = new Random();
        int age = random.nextInt(15) + 1;
        String name = names[random.nextInt(names.length)];
        Breed breed = breeds[random.nextInt(breeds.length)];

        return new Dog(age, name, breed);
    }
}
