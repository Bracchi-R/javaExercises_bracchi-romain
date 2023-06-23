package fr.bracchi.myApi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.bracchi.myApi.model.Animal;

@Service
public class AnimalService {
    ArrayList<Animal> animals = new ArrayList<Animal>();

    public AnimalService() {
        animals = new ArrayList<Animal>();

        this.animals.add(new Animal(1, "Chien", "Canidés", 15));
        this.animals.add(new Animal(2, "Chat", "Félides", 5));
        this.animals.add(new Animal(3, "Éléphant", "Proboscidiens", 4000));
        this.animals.add(new Animal(4, "Panda roux", "Mammifère", 6));
        this.animals.add(new Animal(4, "Girafe", "Giraffidae", 1000));
    }

    /*
    Pour récupérer tous les animaux, vous allez également ajouter une route GET « /animals » qui
    retournera la liste complète que vous avez.
     */

    public List<Animal> getAllAnimal() {
        return animals;
    }

    public Animal getAnimal(int id) {
        for(Animal animal : this.animals) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    public Animal createAnimal(String name, String type, int weight) {
        int id = animals.size() + 1;
        Animal animal = new Animal(id, name, type, weight);
        animals.add(animal);
        return animal;
    }

    public Animal updateAnimal(int id, String name, String type, int weight) {
        for (Animal animal : this.animals) {
            if (animal.getId() == id) {
                animal.setName(name);
                animal.setType(type);
                animal.setWeight(weight);
                return animal;
            }
        }
        return null;
    }

    public Animal deleteAnimal(int id) {
        for (Animal animal : this.animals) {
            if (animal.getId() == id) {
                return animals.remove(animals.indexOf(animal));
            }
        }
        return null;
    }
}
