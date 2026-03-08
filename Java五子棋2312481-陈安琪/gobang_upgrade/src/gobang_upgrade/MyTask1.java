package gobang_upgrade;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MyTask1 implements Runnable {
	int randomIndex=2;
	private int counter=0;
	 private List<String> imagePaths = new ArrayList<>();
	    private static final MyTask1 instance=new MyTask1();
	    private MyTask1() {
	    	imagePaths.add("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\石头剪刀布1.jpg");
	    	imagePaths.add("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\石头剪刀布2.jpg");
	    	imagePaths.add("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\石头剪刀步3.jpg");
	    	Random random = new Random();
	    	randomIndex = random.nextInt(imagePaths.size());
	    }
	   public static MyTask1 getInstance() {
		return instance;
	}
    @Override
    public void run() {
    	WhoFirstFrame.getInstance().setVisible(true);
    	String selectedImagePath = imagePaths.get(randomIndex);
    	counter++;
    	WhoFirstshowPanel.getInstance().setImagePath(selectedImagePath);
    	/*try {
    		System.out.println(selectedImagePath);
            BufferedImage selectedImage = ImageIO.read(new File(selectedImagePath));
            WhoFirstshowPanel.getInstance().upbdImage(selectedImage);
            // 在这里处理你的图片，比如显示它、保存到其他地方等
        } catch (IOException e) {
            System.err.println("无法读取选中的图片: " + e.getMessage());
        }*/
        System.out.println("Task executed at: " + System.currentTimeMillis());
    }
}
