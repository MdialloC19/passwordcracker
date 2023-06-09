package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URLEncoder;

public class SocketServer {

        void TestRequest() throws IOException{

                //WSWG
                String host="localhost";
                int port=80;
                String path="/authentification/logi.php";
                String username="moussa";
                String password="ababa";

                //Les paramètres corps de la requête,
                String params="username="+URLEncoder.encode(username,"UTF-8")+
                              "&password="+URLEncoder.encode(password, "UTF-8");

                //ouvrir une connexion  avec le servir 
                Socket clientSocket=new Socket(host, port);

                //Le requetes http à envoyer

                String requete= "POST "+path+" HTPP/1.1"+"\r\n"+
                                "Host: "+host+"\r\n"+
                                "Connection: close\r\n"+
                                "Content-Type: application/x-www-form-urlencoded"+"\r\n"+
                                "Content-Length: "+params.length()+"\r\n"+"\r\n"+
                                params;
                
                // Envoie de la requete dans le flux de sortie pour l'envoyer au serveur.
                OutputStream outputStream=clientSocket.getOutputStream();
                outputStream.write(requete.getBytes());
                outputStream.flush();

                InputStreamReader isr=new InputStreamReader(clientSocket.getInputStream());
                BufferedReader reader=new BufferedReader(isr);

                // Lire la réponse du serveur
                String line;
                StringBuilder response=new StringBuilder();
                while((line=reader.readLine())!=null){
                    response.append(line).append("\n");
                }
                System.out.println(response.toString());

                reader.close();
                outputStream.close();
                clientSocket.close();
        }

    
}
