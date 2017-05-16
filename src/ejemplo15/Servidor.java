/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo15;

import com.sun.istack.internal.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author Estudiante
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(7000);
            System.out.println("Servidor esperando");
            Socket cliente = serverSocket.accept();
            Socket cliente2 = serverSocket.accept();
            System.out.println("Se ha conectado un cliente");
            
            //3. FLUJOS
            
            InputStream flujoEntrada = cliente.getInputStream();
            OutputStream flujoSalida =cliente.getOutputStream();
            
               InputStream flujoEntrada2 = cliente2.getInputStream();
            OutputStream flujoSalida2 =cliente2.getOutputStream();
           
            // 4. DECORADORES
            
            BufferedReader lectura = new BufferedReader(new InputStreamReader(flujoEntrada));
            PrintWriter escritura = new PrintWriter(flujoSalida,true);
            
             BufferedReader lectura2 = new BufferedReader(new InputStreamReader(flujoEntrada));
            PrintWriter escritura2 = new PrintWriter(flujoSalida,true);
            
            BufferedReader LecturaUsuario = new BufferedReader(new InputStreamReader(System.in));
            
            String mensajeLeido="";
            
            while(true){
                //5. Recibo la informacion
                mensajeLeido = lectura.readLine();
                System.out.println(mensajeLeido);
                 //6. Mensaje respuesta
                
                System.out.println("Respuesta");
                mensajeLeido = LecturaUsuario.readLine();
                 escritura.println("ECO " +  mensajeLeido);
            }
            
            
        }
        catch(IOException ex){
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}