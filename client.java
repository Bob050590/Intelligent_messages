import java.io.*;
import java.net.*;
public class client implements Runnable{
	Socket S;
	InputStreamReader ir;
	BufferedReader br;
	OutputStreamWriter ow;
	PrintWriter pw;
	frame fr;
	public  void clientConnecttoServer(){
	  		try{
	  			 
	  			 S = new Socket("192.168.0.21", 4001);//Server address and port number 
	  			 ir = new InputStreamReader(S.getInputStream());
	  			 br = new BufferedReader(ir);
	  			 ow = new OutputStreamWriter(S.getOutputStream());
	  			 pw = new PrintWriter(ow);
	  			 RunMain();	
	 		   }catch (Exception ae){
	 			   ae.printStackTrace();
	  		}
	}	
	public void RunMain() {
	   	String message;
	   	fr = new frame(this);
	   	 try {
			while((message = br.readLine()) != null){
				fr.display.append(message); 
				 
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}  
 public void run(){
	 clientConnecttoServer();
 }
    public static void main(String[] args) throws InterruptedException{
       client client1 = new client();
       client client2 = new client();
    	
       Thread one = new Thread(client1);
       Thread two = new Thread(client2);
       
       one.start();
       two.start();
       
       one.join();
       two.join();
    	
    }
    
    public void sendToFile(String data) throws IOException {
  	  
    	ow.write(data); 	
 	}   
    	        
    
}

