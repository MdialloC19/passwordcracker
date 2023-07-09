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

/**
 * Cette classe représente une méthode de cassage de mot de passe en utilisant un dictionnaire.
 */
public class Dictionnaire extends Methodes {

    /**
     * Casse le mot de passe en utilisant un dictionnaire.
     *
     * @param motDePasse Le mot de passe à casser.
     */
    public void casserMotDePasse(String motDePasse) {
        List<String> dictionary = new ArrayList<>();

        // on ouvre le fichier en spécifiant son path et ensuite on le lit ligne par ligne grâce à la classe BufferedReader
        // Il faut noter que sur Linux, les séparateurs des chemins sont "./" et sur Windows, "../", tu peux les modifier selon ton programme
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("./././dictionary/passwords.txt")))) {
            String ligne;
            // Chaque ligne lue est ajoutée à la liste dictionary
            while ((ligne = reader.readLine()) != null) {
                dictionary.add(ligne);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // On parcourt les éléments de la liste dictionary et pour chaque élément, on compare son hash avec celui fourni en paramètre
        for (String mot : dictionary) {
            HachageMd5 hash = new HachageMd5(); // Pour éviter que tu déclares la méthode, il suffit de créer une instance de la classe HachageMd5
            try {
                String hashMdp = hash.hachage("?", mot); // Remplacer le "?" par l'algorithme de hachage approprié
                if (hashMdp.equals(motDePasse)) {
                    System.out.println("Mot de passe trouvé: " + mot);
                    System.exit(0);
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Mot de passe non trouvé");
    }

    /**
     * Casse le mot de passe en utilisant un dictionnaire avec des paramètres de connexion.
     *
     * @param host     L'hôte du serveur.
     * @param port     Le port du serveur.
     * @param path     Le chemin de la requête.
     * @param username Le nom d'utilisateur.
     */
    public void casserMotDePasse(String host, int port, String path, String username) {
        List<String> dictionary = new ArrayList<>();
        long debut = System.currentTimeMillis();
        // on ouvre le fichier en spécifiant son path et ensuite on le lit ligne par ligne grâce à la classe BufferedReader
        // Il faut noter que sur Linux, les séparateurs des chemins sont "./" et sur Windows, "../", tu peux les modifier selon ton programme
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("./././dictionary/passwords.txt")))) {
            String ligne;
            // Chaque ligne lue est ajoutée à la liste dictionary
            while ((ligne = reader.readLine()) != null) {
                dictionary.add(ligne);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // On parcourt les éléments de la liste dictionary et pour chaque élément, on compare son hash avec celui fourni en paramètre
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

    /**
     * Vérifie si le mot de passe donné correspond au mot de passe actuel.
     *
     * @param mdp      Le mot de passe actuel.
     * @param password Le mot de passe à vérifier.
     * @return true si le mot de passe correspond, sinon false.
     */
    public static boolean verification(String mdp, String password) {
        HachageMd5 hash = new HachageMd5();
        String actuMdp = "";
        try {
            actuMdp = hash.hachage("MD5", password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return mdp.equals(actuMdp);
    }
}
