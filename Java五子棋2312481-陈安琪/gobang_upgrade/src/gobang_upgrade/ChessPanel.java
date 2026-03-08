package gobang_upgrade;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ChessPanel extends JPanel{
	private String imagePath;
	private int unit=30;
	private int sx,sy;
	private BufferedImage backgroundImage;
	private java.awt.Point dragPoint=null;
@Override
protected void paintComponent(Graphics g) {
	// TODO Auto-generated method stub
	super.paintComponent(g);
	int height=this.getHeight();
	int wide=this.getWidth();
	unit=height/25;
	sx=(wide-unit*(Model.WIDE-1))/2;
	sy=(height-unit*(Model.WIDE-1))/2;
	if(backgroundImage!=null) {
		double scaleFactor=Math.min((double)(unit*20)/backgroundImage.getWidth(),
				(double)(unit*20)/backgroundImage.getHeight());
		int scaleWidth=(int)(backgroundImage.getWidth()*scaleFactor);
		int scaleHeight=(int)(backgroundImage.getHeight()*scaleFactor);
		g.drawImage(backgroundImage.getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_SMOOTH),(sx-unit),(sy-unit), null);
	}
	g.setColor(Color.black);
	for(int i=0;i<Model.WIDE;i++) {
		g.drawLine(sx, sy+i*unit,sx+unit*(Model.WIDE-1),sy+i*unit );
		g.drawLine(sx+i*unit,sy,sx+i*unit,sy+unit*(Model.WIDE-1));
	}
	/*if(dragPoint!=null) {
		g.setColor(Color.RED);
		g.fillOval(dragPoint.x-10, dragPoint.y-10,20,20);
	}*/
	for(int row=0;row<Model.WIDE;row++) {
		for(int col=0;col<Model.WIDE;col++) {
			if(Model.getInstance().getChess(row, col)==Model.BLACK) {
				g.setColor(Color.black);
			}
			else if(Model.getInstance().getChess(row, col)==Model.WHITE) {
				g.setColor(Color.white);
			}else {
				continue;
			}
			g.fillOval(sx+unit*col-unit/2, sy+unit*row-unit/2, unit,unit);
		}
	}
}

public String getImagePath() {
	return imagePath;
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
public int getUnit() {
	return unit;
}
public void setUnit(int unit) {
	this.unit = unit;
}
public int getSx() {
	return sx;
}
public void setSx(int sx) {
	this.sx = sx;
}
public int getSy() {
	return sy;
}
public void setSy(int sy) {
	this.sy = sy;
}
public BufferedImage getBackgroundImage() {
	return backgroundImage;
}
public void setBackgroundImage(BufferedImage backgroundImage) {
	this.backgroundImage = backgroundImage;
}

private static final ChessPanel instance=new ChessPanel();
private ChessPanel() {
	imagePath="D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\默认.jpg";
	try {
		backgroundImage=ImageIO.read(new File(imagePath));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		backgroundImage=null;
	}
	addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseReleased(e);
			int row=(e.getY()-sy)/unit+((e.getY()-sy)%unit)/(unit/2);
			int col=(e.getX()-sx)/unit+((e.getX()-sx)%unit)/(unit/2);
			Control.getInstance().localPutChess(row, col);
			dragPoint=null;
		}
		@Override
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);
			dragPoint=e.getPoint();
		}
	});
	addMouseMotionListener(new MouseMotionListener() {
		
		@Override
		public void mouseMoved(MouseEvent e) {
			repaint();
			
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
		}
	});
}
public static ChessPanel getInstance() {
	return instance;
}
}
