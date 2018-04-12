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