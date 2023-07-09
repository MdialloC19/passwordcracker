package com.hachages;

import java.security.*;

/**
 * Cette classe représente une méthode de hachage MD5.
 */
public class HachageMd5 {

    /**
     * Calcule le hachage MD5 d'une chaîne de caractères.
     *
     * @param algo L'algorithme de hachage à utiliser (ignoré dans cette implémentation).
     * @param mdp  La chaîne de caractères à hacher.
     * @return Le hachage MD5 de la chaîne de caractères.
     * @throws NoSuchAlgorithmException Si l'algorithme de hachage spécifié est invalide.
     */
    public String hachage(String algo, String mdp) throws NoSuchAlgorithmException {

        // Encodage de la chaîne en MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(mdp.getBytes());
        byte[] digest = md.digest();

        // Conversion du hachage en une chaîne hexadécimale
        StringBuilder hexBuilder = new StringBuilder();
        for (byte b : digest) {
            String hex = String.format("%02x", b);
            hexBuilder.append(hex);
        }
        String hexHash = hexBuilder.toString();

        // Affichage du hachage
        System.out.println("Hachage MD5 : " + hexHash);

        return hexHash;
    }
}
