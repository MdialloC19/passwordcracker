package com.methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.hachages.HachageMd5;

public class Dictionnaire  extends Methodes{

    public void casserMotDePasse(String motDePasse){
        List<String> dictionary = new ArrayList<>();

        // on ouvre le fichier en especifiant son path et ensuite le lire ligne par ligne grace à la classe BufferedReader
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("../../../dictionary/passwords.txt")))) {
            String ligne;
            // Chaque ligne lue est ajoutée à la liste dictionary
            while ((ligne = reader.readLine()) != null) {
                dictionary.add(ligne);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        // on parcourt les éléments de la liste dictionnary et pour chaque elmt on compare son hash à celui fourni en paramétre 
        for (String mot : dictionary) {
            try {
                String hashMdp = HachageMd5.hachage("?", mot);
                if (hashMdp.equals(motDePasse)) {
                    System.out.println("Mot de passe trouvé: "+ mot);
                    System.exit(0);
                }
            } catch (NoSuchAlgorithmException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }           
        }
        System.out.println("Mot de passe non trouvé");
    }
    
}
