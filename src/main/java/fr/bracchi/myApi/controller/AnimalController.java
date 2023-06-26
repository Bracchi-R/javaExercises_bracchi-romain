package fr.bracchi.myApi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.bracchi.myApi.model.Animal;
import fr.bracchi.myApi.service.AnimalService;

@RestController
public class AnimalController {

    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @CrossOrigin // Pour récup les infos pour les affichées dans un HTML
    @GetMapping("/animals")
    public ResponseEntity<List<Animal>> getAllAnimal() {
        List<Animal> animals = animalService.getAllAnimal();
        
        if (!animals.isEmpty()) {
            return ResponseEntity.ok(animals); // status 200 (OK)
        } else {
            return ResponseEntity.noContent().build(); // status 404 (Non trouvé)
        }
    }

    @CrossOrigin
    @GetMapping("/animal")
    public ResponseEntity<Animal> getAnimal(@RequestParam int id) {
        Animal animal = animalService.getAnimal(id);

        if (animal != null) {
            return ResponseEntity.ok(animal); // status 200 (OK)
        } else {
            return ResponseEntity.notFound().build(); // status 404 (Non trouvé)
        }
    }

    @CrossOrigin
    @PostMapping("/animal")
    public ResponseEntity<Animal> createAnimal(@RequestBody AnimalResquest body) {
        Animal animal = animalService.createAnimal(body.getName(), body.getType(), body.getWeight());
        
        if (animal != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(animal); // status 201 (CREATED)
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // status 500 (Internal Server Error)
        }
    }
    
    @CrossOrigin
    @PutMapping("/animal")
    public ResponseEntity<Animal> updateAnimal(@RequestParam int id, @RequestBody AnimalResquest body) {
        String name = body.getName();
        String type = body.getType();
        int weight = body.getWeight();

        Animal animal = animalService.updateAnimal(id, name, type, weight);
        
        if (animal != null) {
            return ResponseEntity.ok(animal); // status 200 (OK)
        } else {
            return ResponseEntity.notFound().build(); // status 404 (Non trouvé)
        }
    }

    @CrossOrigin
    @DeleteMapping("/animal")
    public ResponseEntity<Animal> deleteAnimal(@RequestParam int id) {
        Animal animal = animalService.deleteAnimal(id);
        
        if (animal != null) {
            return ResponseEntity.ok(animal); // status 200 (OK)
        } else {
            return ResponseEntity.notFound().build(); // status 404 (Non trouvé)
        }
    }
}
