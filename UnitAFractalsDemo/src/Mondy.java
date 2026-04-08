import java.awt.Color;

import javax.swing.JFrame;

public class Mondy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setTitle("Fractal Fun Rectangles");
		frame.setSize(1000,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//add panel
		FractalPanel panel = new FractalPanel(5, 1000, 800);
		frame.add(panel);
	}

}
