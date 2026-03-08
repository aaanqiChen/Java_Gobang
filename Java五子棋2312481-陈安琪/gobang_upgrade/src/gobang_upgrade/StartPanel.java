package gobang_upgrade;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPanel extends JPanel {
	private Image image=new ImageIcon("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\封面图.jpg").getImage();
	JButton button1=new JButton("进入游戏");
	JButton button2=new JButton("登录");
	JButton button3=new JButton("游戏说明");
	JButton button4=new JButton("退出游戏");
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
		g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}
	private static final StartPanel instance=new StartPanel();
	private StartPanel() {
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(4,1,0,30));
		button1.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
        button1.setForeground(Color.WHITE); // 设置前景色
        button1.setBackground(new Color(124,205,175));
        button2.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
        button2.setForeground(Color.WHITE); // 设置前景色
        button2.setBackground(new Color(124,205,175));
        button3.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
        button3.setForeground(Color.WHITE); // 设置前景色
        button3.setBackground(new Color(124,205,175));
        button4.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
        button4.setForeground(Color.WHITE); // 设置前景色
        button4.setBackground(new Color(124,205,175));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		JLabel label0=new JLabel("古风");
		label0.setFont(new Font("Serif", Font.BOLD, 100)); // 设置字体
		add(label0,BorderLayout.NORTH);
		JLabel label=new JLabel("五子棋");
		label.setFont(new Font("Serif", Font.BOLD, 100)); // 设置字体
		add(label,BorderLayout.CENTER);
		add(panel,BorderLayout.SOUTH);
		//add(label,BorderLayout.NORTH);
		//add(panel,BorderLayout.CENTER);
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StartFrame.getInstance().dispose();
				MiddleFrame3.getInstance().setVisible(true);
			}
		});
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StartFrame.getInstance().dispose();
				LogonFrame.getInstance().setVisible(true);
			}
		});
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HelpFrame.getInstance().setVisible(true);
			}
		});
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	public static StartPanel getInstance() {
		return instance;
	}
	
}
