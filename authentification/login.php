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
    <div class="container">
        <h2>Authentification</h2>
        <form method="POST" action="welcome.php">
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