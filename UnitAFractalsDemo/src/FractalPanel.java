import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FractalPanel extends JPanel implements MouseListener, KeyListener, ActionListener{
	int depth;
	int width, height;
	static Color[] colors = {Color.RED, Color.black, Color.blue,Color.yellow};
	Timer timer;//javax.swing
	double scale;
	
	public FractalPanel(int depth, int width, int height) {
		super();
		this.depth = depth;
		this.width = width;
		this.height = height;
		this.setBackground(Color.white);
		this.addMouseListener(this);
		this.addKeyListener(this);
		scale = 1;//no dilation
		timer = new Timer(50, this); //will trigger this object's actionPerformed every half a second
		
		this.setFocusable(true);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		//to dilate from center
		g2.translate(width/2, height/2);//move the whole panel to the center
		g2.scale(scale,scale);
		g2.translate(-width/2, -height/2);
		
		fractal(g,0,0,width,height,0, true);
	}
	public void fractal(Graphics g, int x, int y, int w, int h, int d, boolean split) {
		if(d>=depth)
			return;
		
		g.setColor(colors[(int)(Math.random()*colors.length)]);
		//g.fillRect(x, y, w, h);
		g.setColor(Color.black);
		g.drawRect(x, y, w, h);
		if(split) {//then it draws it and swaps the split type
			fractal(g, x, y, w/2, h, d+1, !split);
			fractal(g, x+w/2, y, w/2, h, d+1, !split);
		}else {
			fractal(g, x, y, w, h/2, d+1, !split);
			fractal(g, x, y+h/2, w, h/2, d+1, !split);
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
			depth = Math.min(15, depth+1);
		}else if(e.getButton()==MouseEvent.BUTTON3)
			depth = Math.max(1, depth-1);
		this.repaint();
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
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar()=='7') 
			depth = 7;
			this.repaint();
		if(e.getKeyChar()=='s') {
			if(timer.isRunning()) 
				timer.stop();
			
			else
				timer.start();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(depth<16)
		depth++;
		if(depth==16) {
			scale = scale*1.02;//dilates it by 2% more
			if(scale>4)//once we zoom in 4x, then it will go back to normal size
				scale = 1;
		}
		this.repaint();
	}
	
}