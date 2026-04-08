import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class FractalPanel extends JPanel implements MouseListener{
	int depth;//how far it can recurse (so the computer doesn't run out of memory)
	int width, height;//dimensions of the rectangle
	static Color[] colors = {Color.red, Color.blue, Color.black, Color.green, Color.yellow};//of rectangles
	
	public FractalPanel(int depth, int width, int height) {
		super();
		this.depth = depth;
		this.width = width;
		this.height = height;
		this.addMouseListener(this);
		this.setFocusable(true);//focuses on the mouse you are using
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.white);
		fractal(g, 0, 0, width, height, 0);
		
	}
	public void fractal(Graphics g, int x, int y, int w, int h, int d) {
		if(d >= depth)
			return;
		g.setColor(colors[(int)(Math.random()*colors.length)]);
		g.fillRect(x, y, w, h);
		g.setColor(Color.black);
		g.drawRect(x, y, w, h);//to draw a border
		if(Math.random()<.5) {
			fractal(g, x, y, w/2, h, d+1);
			fractal(g,x+w/2, y, w/2, h, d+1);
		}
		else {
			fractal(g,x, y, w, h/2, d+1);
			fractal(g,x,y+h/2,w,h/2,d+1);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton()==MouseEvent.BUTTON1) {
			depth = Math.min(depth++, 15);
		}else if(e.getButton()==MouseEvent.BUTTON2)
			depth = Math.max(1,  depth--);
		this.repaint();//repaints with each press
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}