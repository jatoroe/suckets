/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class Cliente {
        public static void main(String[] args) {
            try{
                Socket cliente = new Socket("localHost",8000);
                 //3. Abriuendo flujos
                
                InputStream flujoEntrada = cliente.getInputStream();
                OutputStream flujoSalida = cliente.getOutputStream();
                
                //4 . Decoradores
             BufferedReader lectura = new BufferedReader(new InputStreamReader(flujoEntrada));
            PrintWriter escritura = new PrintWriter(flujoSalida,true);
            
              //5 solicitando datos usuario
             BufferedReader LecturaUsuario = new BufferedReader(new InputStreamReader(System.in));
            
             
             String mensajeLeido="";
             String mensajeUsuario="";
             while(true){
                 System.out.println("Que mensaje desea enviar");
                 mensajeUsuario = LecturaUsuario.readLine();
                 
                 // 6. Enviando La informacion al servidor
                 escritura.println(mensajeUsuario);
                 // 7 Recibiendo la respuesta
                 mensajeLeido = lectura.readLine();
                 System.out.println("Me contestaron " + mensajeLeido);
             }
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}