<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        .container {
            border: 2px, solid, black;
          /*  background-color: red;*/
            width: 50%;
            margin: auto;
        }
        h2{
            text-align: center;
        }
    </style>
</head>
<body>
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
    <div class="container">
        <h2>Authentification</h2>
        <form method="POST" action="<?php echo $_SERVER["PHP_SELF"]; ?>">
            <table>
                <tr>
                    <td>
                        <label for="username">Nom d'utilisateur :</label>
                    </td>
                    <td>
                        <input type="text" name="username" id="username" required><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="password">Mot de passe :</label>
                    </td>
                    <td>
                       <input type="password" name="password" id="password" required><br>
                    </td>
                </tr>
            </table>      
            <input type="submit" value="Se connecter">
        </form>
    </div>
</body>
</html>