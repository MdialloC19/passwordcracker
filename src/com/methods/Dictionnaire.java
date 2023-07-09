package com.methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.hachages.HachageMd5;
import com.socket.SocketServer;

public class Dictionnaire  extends Methodes{

    public void casserMotDePasse(String motDePasse){
        List<String> dictionary = new ArrayList<>();

        // on ouvre le fichier en especifiant son path et ensuite le lire ligne par ligne grace à la classe BufferedReader
        // Il faut noter sur linux les sépérateur des chemins c'est "./" et sur windows "../" donc tu peux le modifier sur ton programme
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("./././dictionary/passwords.txt")))) {
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
            HachageMd5 hash=new HachageMd5(); // pour eviter que tu déclares la méthode, il faut juste créer une instance de la classe HachageMd5
            try {
                String hashMdp = hash.hachage("?", mot);
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

    public void casserMotDePasse(String host, int port, String path, String username) {
        List<String> dictionary = new ArrayList<>();
        long debut = System.currentTimeMillis();
        // on ouvre le fichier en especifiant son path et ensuite le lire ligne par ligne grace à la classe BufferedReader
        // Il faut noter sur linux les sépérateur des chemins c'est "./" et sur windows "../" donc tu peux le modifier sur ton programme
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("./././dictionary/passwords.txt")))) {
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
                String response = SocketServer.casserRequest(host, port, path, username, mot);
                if (response.contains("Accepted")) {
                    System.out.println("Mot de passe trouvé : " + mot);
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }         
        }
        System.out.println("Mot de passe non trouvé");

        long fin = System.currentTimeMillis();
        System.out.println("La recherche a duré : " + (fin - debut) / 1000 + " secondes");
    }
    //cette function permet de faire la vérification du mot avec le hash
    public static boolean verification(String mdp,String password){
        HachageMd5 hash=new HachageMd5();
        String actuMdp="";
        try {
            actuMdp = hash.hachage("MD5",password);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mdp.equals(actuMdp);
    }
}
