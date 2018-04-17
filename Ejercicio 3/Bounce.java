
/*
 * NOTA IMPORTANTE
 * Los comentarios en este codigo indican las cosas que se han escrito o
 * modificado a partir del codigo aportado por el profesor. De esta forma
 * queda claro que cosas se han modificado ya que son indicadas previamente 
 * por un comentario.
 * 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bounce extends JFrame {
	private JPanel surface;

	public static void main(String[] a) {
		JFrame jf = new Bounce();
		jf.setSize(600, 500);
		jf.setVisible(true);
	}

	/*
	 * Creamos y colocamos el nuevo boton clear
	 */

	Bounce() {
		setTitle("Bounce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane();
		cp.setBackground(new Color(255, 204, 153));
		surface = new JPanel();
		surface.setBackground(new Color(255, 204, 153));
		cp.add(surface, "Center");
		JPanel south = new JPanel();
		south.setBackground(new Color(153, 204, 153));
		JButton start = new JButton("Start");
		start.addActionListener(new ButtonHandler());
		south.add(start);
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ButtonHandler());
		south.add(clear);
		cp.add(south, "South");
		JButton close = new JButton("Close");
		close.addActionListener(new ButtonHandler());
		south.add(close);
		cp.add(south, "South");
	}

	/*
	 * Reajustamos las acciones de cada boton con el action listener. En start
	 * anadimos que reinicie el flag, poniendo la variable booleana fin a false.
	 * El close ya funcionara, debido a que la creacion de una bola es realizada
	 * en un hilo esto no impidiendo la ejecucion de salida de este boton En
	 * clear cambiamos la variable booleana fin que hara que se accione el flag
	 * en la clase Ball
	 * 
	 */

	class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String arg = e.getActionCommand();
			if (arg.equals("Start")) {
				Ball b1 = new Ball(surface, Color.blue);
				b1.start();
				Ball.fin = false;
			} else if (arg.equals("Close")) {
				System.exit(0);
			} else if (arg.equals("Clear")) {
				Ball.fin = true;
			}
		}
	}
}