package com.methods;

import com.socket.*;
import java.io.IOException;

/**
 * Cette classe représente une méthode de brute force pour casser un mot de passe.
 */
public class BruteForce extends Methodes {

    /**
     * Casse le mot de passe en utilisant la méthode brute force.
     *
     * @param mdp Le mot de passe à casser.
     */
    public void casserMotDePasse(String mdp) {

        char motDePasse[] = { 'a', 'a', 'a', 'a', 'a' };

        int motDePasseLength = motDePasse.length;
        long debut = System.currentTimeMillis();
        System.out.println("crackage brute force ....");
        while (motDePasse[motDePasseLength - 1] <= 'z') {

            if (verification(mdp, new String(motDePasse))) {
                System.out.println("Voici le mot de passe correspondant " + new String(motDePasse));
                break;
            } else if (new String(motDePasse) == "zzzzz") {
                System.out.println("Le mot de passe n'est pas trouvé");
            }
            // Génération des combinaisons
            int index = 0;
            while (index < motDePasseLength) {
                if (motDePasse[index] < 'z') {
                    motDePasse[index]++;
                    break;
                } else {
                    motDePasse[index] = 'a';
                    index++;
                }
            }
            System.out.println(new String(motDePasse));
        }
        long fin = System.currentTimeMillis();
        System.out.println("La recherche a durée :" + (fin - debut) / 1000 + "s");

    }

    /**
     * Casse le mot de passe en utilisant la méthode brute force avec des paramètres de connexion.
     *
     * @param host     L'hôte du serveur.
     * @param port     Le port du serveur.
     * @param path     Le chemin de la requête.
     * @param username Le nom d'utilisateur.
     */
    public void casserMotDePasse(String host, int port, String path, String username) {
        char[] motDePasse = { 'a', 'a', 'a', 'a', 'a' };
        int motDePasseLength = motDePasse.length;

        long debut = System.currentTimeMillis();
        System.out.println("Crackage brute force ....");

        boolean motDePasseTrouve = false; // Variable de contrôle

        while (motDePasse[motDePasseLength - 1] <= 'z' && !motDePasseTrouve) {
            String password = new String(motDePasse);
            try {
                String response = SocketServer.casserRequest(host, port, path, username, password);
                if (response.contains("Accepted")) {
                    System.out.println("Mot de passe trouvé : " + password);
                    motDePasseTrouve = true; // Mot de passe trouvé, on met la variable à true pour sortir de la boucle
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Génération des combinaisons
            int index = motDePasseLength - 1; // Démarrer depuis la dernière position du mot de passe

            while (index >= 0) {
                if (motDePasse[index] < 'z') {
                    motDePasse[index]++; // Incrémenter la lettre actuelle
                    break;
                } else {
                    motDePasse[index] = 'a'; // Réinitialiser la lettre actuelle à 'a'
                    index--; // Passer à la position précédente
                }
            }
        }

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
        System.out.println(password);
        // HachageMd5 hash=new HachageMd5();
        // String actuMdp="";
        // try {
        // actuMdp = hash.hachage("MD5",password);
        // } catch (NoSuchAlgorithmException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        String actuMdp = password;
        return mdp.equals(actuMdp);
    }

    /**
     * Effectue une recherche récursive de brute force pour trouver le mot de passe.
     *
     * @param password  Le mot de passe à trouver.
     * @param chaine    La chaîne de caractères en cours de construction.
     * @param position  La position actuelle dans la chaîne de caractères.
     * @return Le mot de passe trouvé, ou null s'il n'est pas trouvé.
     */
    public static String recursifBruteForce(String password, char[] chaine, int position){
        if(position == password.length()-1){
            for (int i = 97; i < 127; i++) {
                chaine[position] = (char)i;
               //System.out.println(new String(chaine));
                String combinaison = new String(chaine);
                if(password.equals(combinaison)){
                    // mot de passe trouvé
                    System.out.println("mot de passe trouvé");
                    return combinaison;
                }
            }
            return null;
        }else{
            for (int i = 97; i < 123; i++) {
                chaine[position] = (char)i;
                if(recursifBruteForce(password, chaine, position+1)!= null){
                    return chaine.toString();
                }
            }
        }
        return null;
    }
}
