package gobang_upgrade;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MiddelPanel extends JPanel{
	private static final MiddelPanel instance=new MiddelPanel();
	private Image image=new ImageIcon("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\中间页面图（女）.jpg").getImage();
	JButton singelbtn=new JButton("人机模式") ;
	JButton doublebtn=new JButton("双人模式");
	JButton rolebtn=new JButton("选择人物");
	JButton retbtn=new JButton("返回");
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
		g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}
	private MiddelPanel() {
		JPanel panell=new JPanel();
		panell.setLayout(new GridLayout(8,1,0,30)); 
		JPanel panelk=new JPanel();
		panelk.setPreferredSize(new Dimension(100,25));
		JPanel panelk2=new JPanel();
		panelk2.setPreferredSize(new Dimension(100,25));
		JPanel panelk3=new JPanel();
		panelk3.setPreferredSize(new Dimension(100,25));
		JPanel panelk4=new JPanel();
		panelk4.setPreferredSize(new Dimension(100,25));
		JPanel nsPanel=new JPanel(new FlowLayout());
		JLabel nalabel=new JLabel(Model.user.getName());
		JLabel scorelabel=new JLabel("  金币:"+String.valueOf(Model.user.getScore()));
		nsPanel.add(nalabel);
		nsPanel.add(scorelabel);
		panell.add(nsPanel);
		panell.add(panelk2);
		panell.add(panelk3);
		panell.add(panelk4);
		singelbtn.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
		singelbtn.setForeground(Color.WHITE); // 设置前景色
		singelbtn.setBackground(new Color(255,192,203));
		doublebtn.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
		doublebtn.setForeground(Color.WHITE); // 设置前景色
		doublebtn.setBackground(new Color(255,192,203));
		rolebtn.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
		rolebtn.setForeground(Color.WHITE); // 设置前景色
		rolebtn.setBackground(new Color(255,192,203));
		retbtn.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
		retbtn.setForeground(Color.WHITE); // 设置前景色
		retbtn.setBackground(new Color(255,192,203));
		panell.add(singelbtn);
		panell.add(doublebtn);
		panell.add(rolebtn);
		panell.add(retbtn);
		add(panell,BorderLayout.CENTER);
		//setContentPane(backgroundPanel.instance);
		doublebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MiddleFrame.getInstance().dispose();
				ChooseFrame1.getInstance().setVisible(true);
				//NorthPanel.getInstance().uplevel(1);
				
			}
		});
		rolebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				roleFrame.getInstance().setVisible(true);
			}
		});
		singelbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//new WhoFirstFrame().setVisible(true);
			}
		});
		retbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StartFrame.getInstance().setVisible(true);
				MiddleFrame.getInstance().dispose();
			}
		});
	}
	public static MiddelPanel getInstance() {
		return instance;
	}
}
