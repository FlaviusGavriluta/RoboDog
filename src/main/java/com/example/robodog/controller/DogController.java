package com.example.robodog.controller;

import com.example.robodog.model.Dog;
import com.example.robodog.service.DogStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {
    @Autowired
    private DogStorage dogStorage;

    @GetMapping
    public List<Dog> getAllDogs() {
        return dogStorage.getDogs();
    }

    @GetMapping("/random")
    public Dog getRandomDog() {
        dogStorage.addRandomDog();
        return dogStorage.getDogs().get(dogStorage.getDogs().size() - 1);
    }

    @PostMapping
    public void addDog(@RequestBody Dog dog) {
        dogStorage.addDog(dog);
    }

    @PutMapping("/{name}")
    public void updateDog(@PathVariable String name, @RequestBody Dog dog) {
        dogStorage.updateDog(name, dog.getAge(), dog.getBreed());
    }
}