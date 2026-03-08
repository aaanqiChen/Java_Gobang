package gobang_upgrade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MiddlePanel3 extends JPanel{
	JButton singelbtn=new JButton("人机模式") ;
	JButton doublebtn=new JButton("双人模式");
	JButton retbtn=new JButton("返回");
private static final MiddlePanel3 instance=new MiddlePanel3();
private MiddlePanel3() {
	JPanel panell=new JPanel();
	setOpaque(false);
	panell.setLayout(new GridLayout(5,1,0,30)); 
	JPanel panelk=new JPanel();
	panelk.setPreferredSize(new Dimension(100,50));
	JPanel panelk2=new JPanel();
	panelk2.setPreferredSize(new Dimension(100,50));
	panell.add(panelk);
	panell.add(panelk2);
	singelbtn.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
	singelbtn.setForeground(new Color(166,125,61)); // 设置前景色
	singelbtn.setBackground(new Color(255,245,228));
	doublebtn.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
	doublebtn.setForeground(new Color(166,125,61)); // 设置前景色
	doublebtn.setBackground(new Color(255,235,205));
	retbtn.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
	retbtn.setForeground(Color.WHITE); // 设置前景色
	retbtn.setBackground(new Color(210,180,140));
	panell.add(singelbtn);
	panell.add(doublebtn);
	panell.add(retbtn);
	add(panell,BorderLayout.CENTER);
	//setContentPane(backgroundPanel.instance);
	doublebtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MiddleFrame3.getInstance().dispose();
			//ChessFrame.getInstance().setVisible(true);
			//NorthPanel.getInstance().uplevel(1);
			ChooseFrame1.getInstance().setVisible(true);
			
		}
	});
	retbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MiddleFrame3.getInstance().dispose();
			StartFrame.getInstance().setVisible(true);
		}
	});
	singelbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//new WhoFirstFrame().setVisible(true);
		}
	});
}
public static MiddlePanel3 getInstance() {
	return instance;
}
}
