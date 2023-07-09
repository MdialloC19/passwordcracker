package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URLEncoder;

public class SocketServer {

        public static String casserRequest(String host, int port, String path, String username, String password) throws IOException{

                //WSWG
                // String host="localhost";
                // int port=80;
                // String path="/authentification/logi.php";
                // String username="moussa";
                

                //Les paramètres corps de la requête,
                String params="username="+URLEncoder.encode(username,"UTF-8")+
                              "&password="+URLEncoder.encode(password, "UTF-8");

                //ouvrir une connexion  avec le servir 
                Socket clientSocket=new Socket(host, port);

                //Le requetes http à envoyer

                String requete= "POST "+path+" HTTP/1.1"+"\r\n"+// method +chemein+protocol+"\r\n"
                                "Host: "+host+"\r\n"+   //address
                                "Connection: close\r\n"+// type de connection close ou kep-alive
                                "Content-Type: application/x-www-form-urlencoded"+"\r\n"+// type de contenu 
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
                return response.toString();
        }

    
}
