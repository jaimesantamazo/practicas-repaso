import javax.swing.JFrame;

public class pruebas extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public pruebas() {
		this.setTitle("he cambiado el titulo");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		pruebas ventana = new pruebas();
		ventana.setVisible(true);

	}

}
