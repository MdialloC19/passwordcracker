package com.methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Dictionnaire  extends Methodes{

    public void casserMotDePasse(String motDePasse){
        List<String> dictionary = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(new File("../../../dictionary/passwords")))) {
            String ligne;

            while ((ligne = reader.readLine()) != null) {
                dictionary.add(ligne);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        for (String mot : dictionary) {
            String hashMdp;
        }

    }
    
}
