import java.net.*;
import java.io.*;

public class ServTocConcurrente{
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket = null;
        boolean escuchando = true;
        try {
           // el socket se abre en el puerto 4444
            serversocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("No puedo escuchar en el puerto: 4444.");
            System.exit(1); // cerrar y avisar al sistema operativo que terminamos con estatus de 0
        }
        //creando nuestros hilo 
        while(escuchando){
        	new ServTocConcHilos(serversocket.accept()).start();
        }
    }
}
