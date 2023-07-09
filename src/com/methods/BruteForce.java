package com.methods;

import com.hachages.HachageMd5;
import com.socket.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

// passer :e7247759c1633c0f9f1485f3690294a9
//aaaaaa: 0b4e7a0e5fe84ad35fb5f95b9ceeac79
// passe: b89f7a5ff3e3a225d572dac38b2a67f7
// passa: bec341ed1505df4197f2b66fcff3946a
public class BruteForce extends Methodes {

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

}
