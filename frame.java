import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.*;

	public class frame implements ActionListener{
		JFrame f;
		JLabel l;
		JTextArea display;
		JButton b;
		JTextField mes;

	    public frame(client myclient){
           try{
	        f = new JFrame("Client Chat");	    
	        f.setLocation(500,500);
	        f.setSize(500,500);
	        f.setLayout(null);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        l = new JLabel("Chat");
	        l.setBounds(5,100,200,200);
	        
	        display = new JTextArea();
	        display.setBounds(50,50,300,300);
	        display.setBackground(Color.LIGHT_GRAY);
	        
	        b = new JButton("SEND");
	        b.setBounds(320,380,50,50);
	        
	        mes = new JTextField();
	        mes.setBounds(50, 380, 250, 40);
	        mes.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e){
	        	if(e.getID() == 1001){
	        	  String cmd = e.getActionCommand();
	        	  display.append("\n" + cmd);
	        	  mes.setText("");
				  try {
					myclient.sendToFile(cmd);
				}   catch (IOException e1) {
					e1.printStackTrace();
				}
				}
	        	
	        	 }});
	        mes.setBackground(Color.pink);
	         f.add(l);
	         f.add(display);
	         f.add(b);
	         f.add(mes);
	         f.setVisible(true);

	    }catch (Exception e){
	    	e.printStackTrace();
	    };
	    } 
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}

