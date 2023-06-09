# passwordcracker
This application allow us to cracker a password by different way : bruteforce , dictionnary. On the other hand we can know the password of given hashed code (md5 or sha1). 
(Cheikh xaral ma continuer français sinon do suivre :)

# Boy_bayill_ci_li_xel
Sur ce veuillez prendre le temps de lire les lignes directrices suivantes :

    Les soumissions doivent être compatibles avec les objectifs de la repository.
    Assurez-vous que votre code est documenté (avec des commentaires clairs) et facile à comprendre.
    Essayez de suivre le style de code existant dans la repository.
    Les tests doivent être fournis pour toutes les nouvelles fonctionnalités et les bogues corrigés.
    Ajoutez vos modifications à la branche en utilisant des commits fréquents
    Soumettez une demande de fusion pour que vos modifications soient examinées et fusionnées dans la branche principale
    La branche principale doit être stable à tout moment, vous ne pouvez pas le modifier sans concertation. Veuillez ouvrir une nouvelle branche pour les nouvelles fonctionnalités et corriger les bogues.

# documentation_à_lire
https://docs.oracle.com/javase/8/docs/api/java/security/MessageDigest.html : pour la fonction md5
https://www.md5hashgenerator.com/ : pour générer des hash en md5

# organisation_du_code
- Les dossiers src et bin sont crées à la racine du projet, src contient les fcihiers .java et les .class sont dans bin.
- Pour l'organisation interne au sein des fichiers dans src, nous les avons rassemblés en packages : le com.methods contient les classes relatives aux méthodes pour casser le code (Methodes.java, Dictionnaire.java et BruteForce.java). Le package com.fabriques contient la classe FabriqueMethode.java
- sur linux tu peux taper la commande tree pour bien voir l'arborescence

# Compilation
- Assure-toi d'être à la racine du projet, puis exécute la commande suivante depuis la ligne de commande :
 - javac -d bin src/com/methods/*.java
 - javac -d bin src/com/fabriques/*.java
 - java -cp bin src.PassWordCracker.java

NB: PassWordCraker.java est le fichier principale.