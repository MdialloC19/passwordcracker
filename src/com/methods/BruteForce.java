package com.methods;

import java.security.NoSuchAlgorithmException;

import com.hachages.HachageMd5;

public class BruteForce extends Methodes{

    //int     [] chiffre={0,1,2,3,4,5,6,7,8,9};
    //String  [] alphabetsArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "!"};

    public void casserMotDePasse(String mdp){

        char motDePasse[]={'a','a','a', 'a','a'};

        int motDePasseLength=motDePasse.length;
        while (motDePasse[motDePasseLength - 1] <='z') {
            
            if(verification(mdp,new String(motDePasse))){
                System.out.println("Voici le mot de passe correspondant "+new String(motDePasse));
                break;
            }else if(new String(motDePasse)=="zzzzz"){
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

    }

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
