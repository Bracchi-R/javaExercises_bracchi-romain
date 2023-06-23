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

    /*
    Rendez-vous dans le dossier « service » à l’intérieur de « myApi ». Dans le fichier « UserService.java », vous devrez ajouter une méthode publique à la classe « UserService » qui sera nommée « updateUser » prenant en paramètre un « id » le « name » et l’« age ». Elle devra retourner un « User ».
    Dans cette méthode, vous devrez parcourir le tableau « users » et vérifier quand les « id » seront les mêmes. Dès que la condition sera vraie, c’est-à-dire que l’« id » de votre paramètre et l’« id » de l’« user » seront identiques, vous pourrez modifier les valeurs « name » et « age » avec les « setters » approprié. Vous retournerez ensuite un « user » modifié. 
    Si vous ne trouvez pas l’« id » dans la liste « users » vous retournerez « null »
     */

    public User updateUser(Integer id, String name, Integer age) {
        for (User user : this.users) {
            if (user.getId() == id) {
                user.setName(name);
                user.setAge(age);
                return user;
            }
        }
        return null;
    }

    /*
    Rendez-vous dans le dossier « service » à l’intérieur de « myApi ». Dans le fichier « UserService.java », vous devrez ajouter une méthode publique à la classe « UserService » qui sera nommée « deleteUser » prenant en paramètre un « id ». Elle devra retourner un « User ».
    Dans cette méthode, vous devrez parcourir le tableau « users » et vérifier quand les « id » seront les mêmes. Dès que la condition sera vraie, c’est-à-dire que l’« id » de votre paramètre et l’« id » de l’« user » seront identiques, vous pourrez supprimer l’utilisateur avec la méthode « remove » de « users ». Cette méthode prendra en paramètre l’« index » d’où se situe l’objet dans « users ». Pour cela, vous utiliserez la méthode « indexOf » de « users » qui prends en paramètre un « User » et qui vous retournera l’« index » de l’objet dans le tableau.
    Vous retournerez ensuite le retour de la méthode « remove » qui sera le « user » supprimé de la liste. Si vous ne trouvez pas l’« id » dans la liste, « users » vous retournerez « null ».
     */

    public User deleteUser(Integer id) {
        for (User user : this.users) {
            if(user.getId() == id) {
                int index = this.users.indexOf(user);
                return this.users.remove(index);
                //ou
                //return users.remove(users.indexOf(user));
            }
        }
        return null;
    }
}
