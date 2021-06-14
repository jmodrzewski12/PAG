package zadanie7;

import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class interfejs implements ActionListener {
	

	public static boolean isNumeric(String string) {
	    int intValue;
	    System.out.println(String.format("wpisany tekst: \"%s\"", string));
			
	    if(string == null || string.equals("")) {
	        System.out.println("Pusty wiersz");
	        return false;
	    }
	    
	    try {
	        intValue = Integer.parseInt(string);
	        return true;
	    } catch (NumberFormatException e) {
	        System.out.println("Znaki nie numeryczne");
	    }
	    return false;
	}

	JFrame ramka = new JFrame();
	JFrame ramka2 = new JFrame();
	JButton przyciskWpisz = new JButton("Wpisz");
	JButton przyciskWpisz2 = new JButton("Wpisz");
	JButton przyciskAnuluj = new JButton("Anuluj");
	
	
	JTextField znaki = new JTextField(20);
	String tekst = znaki.getText();
	JTextField znaki2 = new JTextField(20);
	String tekst2 = znaki2.getText();
	
	JLabel label = new JLabel("Wpisz wartoœæ numeryczn¹: ",JLabel.CENTER);

	
	public String getTekst() {
		return znaki.getText();
	}
	
	public String getTekst2() {
		return znaki2.getText();
	}
	
	
    public void prepareGUI(){
        ramka.setTitle("Testowanie danych wejœciowych");
 		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		ramka.setSize(400, 100);
 		ramka.setLocation(600,400);
 		ramka.setLayout(new FlowLayout());
 		ramka.setVisible(true);
 		znaki.setEnabled(false);
    }

	
    public void przyciskiRamka(){
        ramka.add(przyciskWpisz);
        przyciskWpisz.addActionListener( this);
    }
    
    public void actionPerformed(ActionEvent e) {
    	Object src = e.getSource();

    	if(src == przyciskWpisz) {
    		ramka2.dispose();
    		prepareGUI2();
    		znaki2.setText("");
    	}

        else if(src == przyciskWpisz2) {
            if(isNumeric(getTekst2())) {
            	System.out.println(isNumeric(getTekst2()));
            	znaki.setText(getTekst2());
            	ramka2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            	ramka2.dispose();
            	
            }
            else if(!isNumeric(getTekst2())) {
        		//ramka2.dispose();
        		//prepareGUI2();
        		znaki2.setText("");
        		label.setText("Ponownie wpisz wartoœæ numeryczn¹: ");
            }
        }

        else if(src == przyciskAnuluj) {
        	ramka2.dispose();
        	ramka2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
 
    }
    

    
    public void prepareGUI2(){
        ramka2.setTitle("Input");
 		ramka2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		ramka2.setSize(250, 150);
 		ramka2.setLocation(650,450);
 		ramka2.setLayout(new FlowLayout());
 		ramka2.setVisible(true);
 		
 		
 		ramka2.add(label);
 		ramka2.add(znaki2);
 		przyciskiRamka2();
    }
    
    public void przyciskiRamka2(){
        ramka2.add(przyciskWpisz2);
        ramka2.add(przyciskAnuluj);
        przyciskWpisz2.addActionListener( this);
        przyciskAnuluj.addActionListener( this);
    
    }
	
	public interfejs() {
		prepareGUI();
 		przyciskiRamka();
 		ramka.add(znaki);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new interfejs();
			}
		});
	}
}



