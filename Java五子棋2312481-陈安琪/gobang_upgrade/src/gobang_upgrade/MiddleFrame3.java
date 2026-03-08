package gobang_upgrade;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiddleFrame3 extends JFrame{
	private Image image=new ImageIcon("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\中间背景图（普通）.jpg").getImage();
private static final MiddleFrame3 instance=new MiddleFrame3();
private MiddleFrame3() {
	setTitle("五子棋");
	setSize(450,600);
	setLayout(new BorderLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);//什么意思
	JPanel backgroundPanel=new JPanel() {
		@Override
		protected void paintChildren(Graphics g) {
			// TODO Auto-generated method stub
			super.paintChildren(g);
			Graphics2D g2d=(Graphics2D) g;
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
			g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
};
backgroundPanel.setLayout(new BorderLayout());
backgroundPanel.add(MiddlePanel3.getInstance(),BorderLayout.CENTER);
add(backgroundPanel);
}

public static MiddleFrame3 getInstance() {
	return instance;
}
}
