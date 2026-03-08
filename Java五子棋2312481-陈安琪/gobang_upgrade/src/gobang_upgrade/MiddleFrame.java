package gobang_upgrade;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiddleFrame extends JFrame{
private static final MiddleFrame instance=new MiddleFrame();
private MiddleFrame() {
	setTitle("五子棋");
	setSize(450,600);
	setLayout(new BorderLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);//什么意思
	add(MiddelPanel.getInstance());
	//setContentPane(backgroundPanel.instance);
}
/*private static class backgroundPanel extends JPanel{
	private Image backgroundImage;
	private static final backgroundPanel instance=new backgroundPanel();
	private backgroundPanel() {
		String imagepath="D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\中间页面图（女）.jpg";
		try {
			backgroundImage=ImageIO.read(new File(imagepath));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			backgroundImage=null;
		}
		
	}
	public static backgroundPanel getInstance() {
		return instance;
	}
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		if(backgroundImage!=null) {
			System.out.println("hehe");
			Dimension size=getSize();
			g.drawImage(backgroundImage, 0, 0, size.width, size.height,this);
		}
	}
	
}*/
public static MiddleFrame getInstance() {
	return instance;
}
}
