<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Récupération des informations du formulaire
    $username = $_POST["username"];
    $password = $_POST["password"];

    //Connexion à la base de données
    $servername = "localhost";
    $dbname = "crack";
    $dbusername = "root";
    $dbpassword = "";

    try {
        $conn = new PDO("mysql:host=$servername;dbname=$dbname", $dbusername, $dbpassword);
        $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        //On Vérifie les informations d'authentification
        $stmt = $conn->prepare("SELECT * FROM users WHERE username = :username");
        $stmt->bindParam(':username', $username);
        $stmt->execute();
        $user = $stmt->fetch();

        if ($user && (md5($password) == $user['password'])) {
            echo "Bienvenue, " . $username . " !";
        } else {
            echo "Identifiant ou mot de passe incorrect.";
        }
    } catch(PDOException $e) {
        echo "Erreur de connexion à la base de données : " . $e->getMessage();
    }
}
?>
