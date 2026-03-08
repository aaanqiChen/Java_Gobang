package gobang_upgrade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;


public class StartFrame extends JFrame{
	private static final StartFrame instance=new StartFrame();
	private StartFrame() {
		setSize(400,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);//什么意思
		setContentPane(StartPanel.getInstance());
		/*JLabel titleLabel = new JLabel("桃李满天下 - 五子棋", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24)); // 设置字体
        add(titleLabel,BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)); // 设置按钮之间的间隔
        buttonPanel.setBackground(Color.LIGHT_GRAY); // 设置背景色
        buttonPanel.setBorder(new EtchedBorder()); 
        JButton button1=new JButton("进入游戏");
        button1.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
        button1.setForeground(Color.BLUE); // 设置前景色
    	JButton button2=new JButton("登录");
    	button2.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
    	button2.setForeground(Color.BLUE); // 设置前景色
    	JButton button3=new JButton("游戏说明");
    	button3.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
    	button3.setForeground(Color.BLUE); // 设置前景色
    	JButton button4=new JButton("退出游戏");
    	button4.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
    	button4.setForeground(Color.BLUE); // 设置前景色
    	buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        add(buttonPanel,BorderLayout.SOUTH);
        setContentPane(startpaintPanel.getInstance());*/
	}
	public static StartFrame getInstance() {
		return instance;
	}
}
