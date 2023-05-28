
// Cette classe permet de tester tout le code 

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import com.fabriques.FabriqueMethode;
import com.hachages.*;
import com.methods.*;
public class PassWordCracker {
    
    public static void main(String []args){
        System.out.println("****** Programme pour casser un code de 5 à 6 chiffres par deux méthodes ********\n\t\t 1- Méthode par BRUTE FORCE ( taper bruteforce)\n\t\t 2- Méthode par DICTIONNAIRE (dictionnaire)");
        
        Scanner sc=new Scanner(System.in);
        String mdp1=sc.nextLine();

        Methodes Method=FabriqueMethode.getInstance(mdp1);
        System.out.println("Donner le mot de passe hacher à rechercher");
        
        String mdp=sc.nextLine();

        System.out.println("Veuillez patienter SVP");

        Method.casserMotDePasse(mdp);

    
        // int passwordLength = 5; 
        // //char[] password = new char[passwordLength];
        // char password[]={'a','a','a', 'a','a'};
       

        // while (password[passwordLength - 1] <= 'z') {
            
        //     if(verification(mdp,new String(password))){
        //         System.out.println("Voici le mot de passe correspondant "+new String(password));
        //         break;
        //     }
        //     // Génération des combinaisons
        //     int index = 0;
        //     while (index < passwordLength) {
        //         if (password[index] < 'z') {
        //             password[index]++;
        //             break;
        //         } else {
        //             password[index] = 'a';
        //             index++;
        //         }
        //     }
        // }
    }
    // public static boolean verification(String mdp,String password){
    //     HachageMd5 hash=new HachageMd5();
    //     String actuMdp="";
    //     try {
    //         actuMdp = hash.hachage("MD5",password);
    //     } catch (NoSuchAlgorithmException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    //     return mdp.equals(actuMdp);
    // }
}