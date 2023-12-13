package com.example.robodog.controller;

import com.example.robodog.model.Dog;
import com.example.robodog.service.DogStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

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
        List<Dog> allDogs = dogStorage.getDogs();
        Random random = new Random();
        int randomIndex = random.nextInt(allDogs.size());

        return allDogs.isEmpty() ? null : allDogs.get(randomIndex);
    }

    @PostMapping
    public void addDog(@RequestBody Dog dog) {
        dogStorage.addDog(dog);
    }

    @PutMapping("/{name}")
    public ResponseEntity<?> updateDog(@PathVariable String name, @RequestBody Dog dog) {
        boolean isUpdated = dogStorage.updateDog(name, dog.getAge(), dog.getBreed());
        if (isUpdated) {
            return ResponseEntity.ok().build(); // or return some success message
        } else {
            return ResponseEntity.notFound().build(); // or return some error message
        }
    }

}