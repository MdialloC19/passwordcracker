package com.hachages;

import java.security.*;
import java.util.Scanner;

public class HachageMd5 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Veuillez saisir la chaîne à encoder en MD5");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        
        // Encodage de la chaîne en MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(s.getBytes()); 
        byte[] digest = md.digest();
        
        // Conversion du hachage en une chaîne hexadécimale
        /* //Affichage de l'encodage en hexadécimal 
        for (byte b : digest) {
            voir+=b;
        }
        
        String hexNumber = Integer.toHexString(Integer.parseInt(voir));
        System.out.println(hexNumber); */
        StringBuilder hexBuilder = new StringBuilder();
        // la j'ai utiliser string build pour pouvoir concater les string sans encombrer le heap de nouvelle objet 
        for (byte b : digest) {
            String hex = String.format("%02x", b);
            hexBuilder.append(hex);
        }
        String hexHash = hexBuilder.toString();
        
        // Affichage du hachage
        System.out.println("Hachage MD5 : " + hexHash);
    }
}
