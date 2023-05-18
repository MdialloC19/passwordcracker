// Tous les fabrques je les rassembles dans le package com.fabriques
package com.fabriques;
import com.methods.*;


public class FabriqueMethode {

    Methodes MethodPourMot=null;
    //Dans ce bout de code nous choisir quelle instance choisir pour trouver le code
    public Methodes getInstance(String method){

        if(method.equalsIgnoreCase("bruteforce")){

            MethodPourMot= new BruteForce();

        }else if(method.equalsIgnoreCase("dictionnaire")){

            MethodPourMot= new Dictionnaire();
            
        } else {
            throw new IllegalArgumentException("Type de méthode invalide.");
        }
        return MethodPourMot;
    }
    
}
