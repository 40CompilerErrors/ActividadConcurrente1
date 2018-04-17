
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

/*
 * Hacemos que la clase Ball extienda de Thread
 */
class Ball extends Thread {
	/*
	 * Creamos una variable booleana llamada fin a modo de flag
	 */
	public static boolean fin = false;

	Ball(JPanel c, Color clr) {
		box = c;
		color = clr;
	}

	/*
	 * Creamos el run. El bucle while gestiona el funcionamiento del flag. Una
	 * vez se sale del bucle while se vuelve a pintar el fondo.
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {

		draw(); // draw ball for first time
		for (int k = 1; k <= 1000; k++) {
			while (!fin) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					return;
				}
				move();
			}
			Graphics g = box.getGraphics();
			g.setColor(box.getBackground());
			g.fillOval(x, y, XSIZE, YSIZE);
		}
	}

	void draw() {
		Graphics g = box.getGraphics();
		g.setColor(color);
		g.fillOval(x, y, XSIZE, YSIZE);
	}

	void move() {
		Graphics g = box.getGraphics();
		g.setColor(box.getBackground());
		g.fillOval(x, y, XSIZE, YSIZE); // draw over old ball
		x = x + dx;
		y = y + dy;
		Dimension d = box.getSize();
		if (x <= 0) {
			x = 0;
			dx = -dx;
		}
		if (x + XSIZE >= d.width) {
			x = d.width - XSIZE;
			dx = -dx;
		}
		if (y <= 0) {
			y = 0;
			dy = -dy;
		}
		if (y + YSIZE >= d.height) {
			y = d.height - YSIZE;
			dy = -dy;
		}
		g.setColor(color);
		g.fillOval(x, y, XSIZE, YSIZE);
	}

	private JPanel box;
	private Color color;
	private static final int XSIZE = 20, YSIZE = 20;
	private int x = 50, y = 0, dx = 2, dy = 2;

}