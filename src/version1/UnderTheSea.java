package version1;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UnderTheSea extends Canvas {

	// Medidas de la ventana
	public static final int WIDTH = 600;
	public static final int HEIGTH = 600;

	// Patron Singlenton
	public static UnderTheSea instance = null;

	// Ventana principal donde se desarrolla el juego.
	JFrame ventana = new JFrame("UnderTheSea");

	public UnderTheSea() {

		JPanel panel = (JPanel) ventana.getContentPane();

		// Establezco el tipo de panel para añadir el canvas
		panel.setLayout(new BorderLayout());
		// Añado el tipo de panel
		panel.add(this, BorderLayout.CENTER);

		// Establecemos las medidas de la ventana.
		ventana.setBounds(0, 0, WIDTH, HEIGTH);

		// Hacemos que la ventana sea visible
		ventana.setVisible(true);

		// Permite que no se refresque automaticamente, en cambio hay que hacerlo
		// automaticamente.
		ventana.setIgnoreRepaint(true);
		// Nos permitirá que el foco de atencion se vaya a la aplicación.
		this.requestFocus();

		// Esto nos permite interceptar cuando quieren cerrar la ventana y ejecutamos un
		// listener con un adaptador, como es una interfaz debemos de instanciarlo de
		// una forma diferente
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				cierraAplicacion();
			}
		});
	}

	/**
	 * Método que contiene un array de opciones, en caso de que sea una respuesta
	 * positiva se saldrá, sino permanezerá dentro del juego.
	 */
	private void cierraAplicacion() {
		String[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(ventana, "¿Desea cerrar la aplicación?", "Salir de la aplicación",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	/**
	 * Instancia al patron singleton
	 * 
	 * @return
	 */
	public static UnderTheSea getInstance() {

		// Si la instancia es nula, llama al constructor de la clase.
		if (instance == null) {
			instance = new UnderTheSea();
		}

		return instance;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Nueva instancia al constructor de la clase mediante el singlenton
		UnderTheSea.getInstance();

	}

}
