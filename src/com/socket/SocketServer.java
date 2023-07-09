package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URLEncoder;

/**
 * Cette classe représente un client socket pour envoyer une requête HTTP.
 */
public class SocketServer {

    /**
     * Envoie une requête HTTP POST au serveur spécifié et récupère la réponse.
     *
     * @param host     L'hôte du serveur.
     * @param port     Le port du serveur.
     * @param path     Le chemin de la requête.
     * @param username Le nom d'utilisateur.
     * @param password Le mot de passe.
     * @return La réponse du serveur.
     * @throws IOException Si une erreur d'entrée/sortie se produit lors de la communication avec le serveur.
     */
    public static String casserRequest(String host, int port, String path, String username, String password) throws IOException {

        // Les paramètres du corps de la requête
        String params = "username=" + URLEncoder.encode(username, "UTF-8") +
                        "&password=" + URLEncoder.encode(password, "UTF-8");

        // Ouvrir une connexion avec le serveur
        Socket clientSocket = new Socket(host, port);

        // La requête HTTP à envoyer
        String requete = "POST " + path + " HTTP/1.1" + "\r\n" + // méthode + chemin + protocole + saut de ligne
                         "Host: " + host + "\r\n" +   // adresse du serveur
                         "Connection: close\r\n" +    // type de connexion : close ou keep-alive
                         "Content-Type: application/x-www-form-urlencoded" + "\r\n" +  // type de contenu
                         "Content-Length: " + params.length() + "\r\n" + "\r\n" +    // longueur du corps de la requête
                         params;

        // Envoie de la requête dans le flux de sortie pour l'envoyer au serveur
        OutputStream outputStream = clientSocket.getOutputStream();
        outputStream.write(requete.getBytes());
        outputStream.flush();

        InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader reader = new BufferedReader(isr);

        // Lire la réponse du serveur
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line).append("\n");
        }
        System.out.println(response.toString());

        reader.close();
        outputStream.close();
        clientSocket.close();

        return response.toString();
    }
}
