
// Cette classe permet de tester tout le code 

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import com.fabriques.FabriqueMethode;
import com.hachages.*;
import com.methods.*;
public class PassWordCracker {
    
    public static void main(String []args){
        System.out.println("****** Programme pour casser un code de 5 à 6 chiffres par deux méthodes- Hachage de Mot de passe ********\n\t\t 1- Méthode par BRUTE FORCE ( taper bruteforce)\n\t\t 2- Méthode par DICTIONNAIRE (dictionnaire)");
        
        Scanner sc=new Scanner(System.in);
        String mtd1=sc.nextLine();

        Methodes Method=FabriqueMethode.getInstance(mtd1);
        System.out.println("Donner le mot de passe hacher à rechercher");
        
        String mdp=sc.nextLine();

        System.out.println("Veuillez patienter SVP");

        Method.casserMotDePasse(mdp);

    
    }   
}