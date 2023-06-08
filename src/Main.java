public class Main {
    public static void main(String[] args) {
        String password = "passe";

        char[] chaine = new char[password.length()];
        
        long debut = System.currentTimeMillis();
        System.out.println("crackage brute force ....");
        String foundPassword = recursifBruteForce(password, chaine, 0);
        long fin = System.currentTimeMillis();
        long duree = (fin - debut)/1000;
        System.out.println("cela nous a pris "+duree+"s");

        if(foundPassword == null){
            System.out.println("bravo !");
        }

    }

    public static String recursifBruteForce(String password, char[] chaine, int position){
        if(position == password.length()-1){
            for (int i = 97; i < 127; i++) {
                chaine[position] = (char)i;
               //System.out.println(new String(chaine));
                String combinaison = new String(chaine);
                if(password.equals(combinaison)){
                    // mot de passe trouve
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
