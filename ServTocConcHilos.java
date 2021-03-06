import java.net.*;
import java.io.*;

public class ServTocConcHilos extends Thread{	
    private Socket socket = null;
    public ServTocConcHilos(Socket sock){ //recibimos la conexion
	    super("ServTocConcHilos"); //ejecutamos el constructor de la clase e inicializando el hilo
	    this.socket = sock; //recibimos osckets completos
    }
    public void run(){
	    try{
	    	PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
	    	BufferedReader in	= new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    	String LineaDeEntrada, LineaDeSalida;
	    	ProtocoloTocToc ptt = new ProtocoloTocToc();
	    	LineaDeSalida = ptt.processInput(null);
	    	out.println(LineaDeSalida);
	        while ((LineaDeEntrada = in.readLine()) != null) {          
            	LineaDeSalida = ptt.processInput(LineaDeEntrada);
             	out.println(LineaDeSalida);
             	if (LineaDeSalida.equals("Adios."))
                	break;
   		    }
   		    out.close();
   		    in.close();
   		    socket.close();
	    }catch (IOException e){
	    	e.printStackTrace();
	    }
    }
}
