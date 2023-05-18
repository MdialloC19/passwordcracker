
// Cette classe permet de tester tout le code 
public class PassWordCracker {
    
    public static void main(String []args){
        System.out.println("****** Programme pour casser un code de 5 à 6 chiffres par deux méthodes ********\n\t\t1- Méthode par BRUTE FORCE \n\t\t2- Méthode par DICTIONNAIRE");
    
        int passwordLength = 6; // Longueur du mot de passe
        char[] password = new char[passwordLength];

        while (password[passwordLength - 1] < 'z') {
            // Afficher le mot de passe actuel
            System.out.println(new String(password));

            // Générer la prochaine combinaison
            int index = 0;
            while (index < passwordLength) {
                if (password[index] < 'z') {
                    password[index]++;
                    break;
                } else {
                    password[index] = 'a';
                    index++;
                }
            }
        }
    }
}