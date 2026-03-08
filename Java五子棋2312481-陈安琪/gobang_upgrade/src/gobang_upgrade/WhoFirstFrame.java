package gobang_upgrade;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;

public class WhoFirstFrame extends JFrame {
	private static final WhoFirstFrame instance=new WhoFirstFrame();
	public static WhoFirstFrame getInstance() {
		return instance;
	}
    private JButton startButton;
    private JButton retButton;
    private boolean isRunning = false;
    public WhoFirstFrame() {
        // 初始化Frame
        setTitle("图片闪现Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // 初始化组件
        add(WhoFirstshowPanel.getInstance(), BorderLayout.CENTER);

        startButton = new JButton("开始");
        retButton = new JButton("返回");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(retButton);
        add(buttonPanel, BorderLayout.SOUTH);
        retButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
    }
}
        // 初始化Timer
        /*timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRandomImage();
            }
        });

        // 设置按钮事件监听器
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isRunning) {
                    isRunning = true;
                    startFlash();
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFlash();
            }
        });
    }

    private void startFlash() {
        // 开始随机闪现图片
        timer.start();
    }

    private void resetFlash() {
    	timer.stop(); // 停止计时器
        counter = 0;  // 重置计数器
        imageLabel.setIcon(null);
    }

    private void showRandomImage() {
        Collections.shuffle(imageList, new Random());
        lastImage = imageList.get(0);
        imageLabel.setIcon(lastImage);
        if (counter < 3) {
            counter++;
        } else {
            timer.stop();
            counter = 0; 
            isRunning=false;
        }
    }
}*/