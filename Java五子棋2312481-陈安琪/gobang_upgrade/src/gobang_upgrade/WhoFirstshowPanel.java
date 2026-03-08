package gobang_upgrade;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class WhoFirstshowPanel extends JPanel{
	public String imagePath;
	     public BufferedImage backgroundImage;
    	private static final WhoFirstshowPanel instance=new WhoFirstshowPanel();
    	private WhoFirstshowPanel() {}
    	public static WhoFirstshowPanel getInstance() {
			return instance;
		}
    	@Override
    	public void paintComponents(Graphics g) {
    		super.paintComponents(g);
    		if(backgroundImage!=null) {
    			double scaleFactor=Math.min(0.8,
    					0.8);
    			int scaleWidth=(int)(backgroundImage.getWidth()*scaleFactor);
    			int scaleHeight=(int)(backgroundImage.getHeight()*scaleFactor);
    			g.drawImage(backgroundImage.getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_SMOOTH),0,0, null);
    		}
    	
    }
    	public void setImagePath(String imagePath) {
    		this.imagePath = imagePath;
    		try {
    			backgroundImage=ImageIO.read(new File(imagePath));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		repaint();
    	}
    public void upbdImage(BufferedImage m) {
    	System.out.println("Come!");
	backgroundImage=m;
	repaint();
}
}
