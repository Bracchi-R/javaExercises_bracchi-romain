package fr.bracchi.myApi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import fr.bracchi.myApi.model.User;

@Service
public class UserService {
    ArrayList<User> users = new ArrayList<User>();

    public UserService() {
        users = new ArrayList<User>();

        this.users.add(new User(1, "Romain", 12));
        this.users.add(new User(2, "Camille", 14));
        this.users.add(new User(3, "Sylviane", 90));
    }
  
    public User getUser(Integer id) {
        for (User user : this.users) {
            if (user.getId() == id) {
            return user;
            }
        } 
    return null;
    } 

    /*
    Rendez-vous dans le dossier « service » à l’intérieur de « myApi ». Dans le fichier « UserService.java », vous devrez ajouter une méthode publique à la classe « UserService » qui sera nommée « createUser » prenant en paramètre le « name » et l’« age ». Elle devra retourner un « User ».
    Dans cette méthode, vous devrez créer une nouvelle variable « User » nommée « user » avec comme « id » la taille de votre tableau « users » + 1, autrement dit :
    users.size() + 1
    Les propriétés « name » et « age » de « user » auront pour valeur celles des paramètres de la méthode.
    Vous devrez par la suite ajouter « user » que vous venez de créer à votre tableau « users » en utilisant la méthode « add » de l’« ArrayList ». Pour finir, vous retournerez « user ».
     */

    public User createUser(String name, int age) {
        int id = users.size() + 1;
        User user = new User(id, name, age);
        users.add(user);
        return user;
    }
}
