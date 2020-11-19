package version1;

import java.awt.Canvas;

import javax.swing.JFrame;



public class UnderTheSea extends Canvas{

	// Medidas de la ventana
	public static final int WIDTH = 600;
	public static final int HEIGTH = 600;
	
	//Patron Singlenton
	public static UnderTheSea instance = null;
	
	// Ventana principal donde se desarrolla el juego.
	JFrame ventana = new JFrame("UnderSea");
	
	public UnderTheSea() {
		
	ventana.setBounds(0, 0, WIDTH, HEIGTH);	
	
	//JPanel panel = panel.add(this, );

	ventana.setVisible(true);
	
	// Permite que no se refresque automaticamente, en cambio hay que hacerlo automaticamente.
	ventana.setAutoRequestFocus(false);
	//Nos permitirá que el foco de atencion se vaya a la aplicación.
	this.requestFocus();
		
	}
	
	/**
	 * Instancia al patron singleton
	 * @return
	 */
	public static UnderTheSea getInstance() {
		
		if(instance == null) {
			instance = new UnderTheSea();
		}
		
		return instance;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		UnderTheSea.getInstance();
		

	}

}
