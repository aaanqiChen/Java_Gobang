package gobang_upgrade;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class chesPanel extends JPanel{
private static final chesPanel instance=new chesPanel();
private chesPanel() {
	setPreferredSize(new Dimension(50,50));
	
}
@Override
protected void paintComponent(Graphics g) {
	// TODO Auto-generated method stub
	super.paintComponent(g);
	if(Control.getInstance().getLocalColor()==Model.BLACK) {
	g.setColor(Color.BLACK);
	}
	else g.setColor(Color.WHITE);
	g.fillOval(0, 0, getWidth(),getHeight());
}
public void changechespanel() {
	repaint();
 }
public static chesPanel getInstance() {
	return instance;
}
}
