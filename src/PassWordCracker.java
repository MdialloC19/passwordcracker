
// Cette classe permet de tester tout le code 

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import com.fabriques.FabriqueMethode;
import com.hachages.*;
import com.methods.*;
public class PassWordCracker {
    
    public static void main(String []args){
        System.out.println("****** Programme pour casser un code de 5 à 6 chiffres par deux méthodes- Hachage de Mot de passe ********\n\t\t"+
        "1- Méthode par BRUTE FORCE \n\t\t"+" 2- Méthode par DICTIONNAIRE");
        
        Scanner sc=new Scanner(System.in);
        int choix=sc.nextInt();
        String mdp1=new String();
        switch (choix) {
            case 1:
            mdp1="bruteforce";
                break;
            case 2:
            mdp1="dictionnaire";
                break;
            case 3:
            mdp1="htpp";
                break;
            default:
            System.out.println("Choix indisponible");
                break;
        }
        Methodes Method=FabriqueMethode.getInstance(mdp1);
        
        System.out.println("1-Trouver un mot de passe \n2-Trouver le mot de passe d'authentification");
        int choix1=sc.nextInt();
        if(choix1==1){
            System.out.println("Donner le mot de passe hacher à rechercher");
            String mdp=sc.nextLine();
            Method.casserMotDePasse(mdp);

        }else{
            System.out.println("Donner le host");
            String host=sc.next();
            System.out.println("Donner le port");
            int port=sc.nextInt();
            System.out.println("Donner le path");
            String path=sc.next();
            System.out.println("Donner le username");
            String user=sc.next();

            Method.casserMotDePasse(host,port,path,user);

            

        }
        

        System.out.println("Veuillez patienter SVP");

      

    
    }
  
}