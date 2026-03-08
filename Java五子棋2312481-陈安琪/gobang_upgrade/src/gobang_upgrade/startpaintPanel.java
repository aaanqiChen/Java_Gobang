package gobang_upgrade;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class startpaintPanel extends JPanel{
	private static final startpaintPanel instance=new startpaintPanel();
	public static startpaintPanel getInstance() {
		return instance;
	}
	private Image backgroundImage;
	 private String imagepath="D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\封面图.jpg";
    private  startpaintPanel() {
        try {
            // 加载背景图片
            backgroundImage = ImageIO.read(new File(imagepath));
        } catch (IOException e) {
            e.printStackTrace();
            // 处理图片加载失败的情况
        }
    }
 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // 绘制背景图片
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
 
    @Override
    public Dimension getPreferredSize() {
        // 如果图片已经加载，则返回图片的尺寸作为面板的首选尺寸
        if (backgroundImage != null) {
            return new Dimension(backgroundImage.getWidth(instance), backgroundImage.getHeight(instance));
        }
        // 否则，返回默认尺寸
        return super.getPreferredSize();
    }
}
