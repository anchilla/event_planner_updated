package event_novi;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
@SuppressWarnings("serial")
public class Panel extends JPanel{

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color c2=new Color(105, 242, 250);
		Color c=new Color(177, 100, 255);
		Graphics2D d2=(Graphics2D) g;
		 d2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	        int w = getWidth();
	        int h = getHeight();

	        GradientPaint gp = new GradientPaint(0, 0, c2, 0, h, c);
	        d2.setPaint(gp);
	        d2.fillRect(0, 0, w, h);
	}
}