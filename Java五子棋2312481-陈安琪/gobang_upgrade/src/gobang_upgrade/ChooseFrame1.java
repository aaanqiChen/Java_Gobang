package gobang_upgrade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseFrame1 extends JFrame{
private static final ChooseFrame1 instance=new ChooseFrame1();
private ChooseFrame1() {
	setSize(300,400);
	setBackground(new Color(238,255,238));
	JPanel chPanel=new JPanel();
	chPanel.setBackground(new Color(238,255,238));
	chPanel.setLayout(new GridLayout(3,1,0,40));
	JButton competbtn=new JButton("比赛模式");
	JButton relaxbtn=new JButton("休闲模式");
	JButton chretbtn=new JButton("返回");
	chretbtn.setBackground(new Color(155,230,155));
	relaxbtn.setBackground(new Color(185,240,185));
	competbtn.setBackground(new Color(215,250,215));
	chPanel.add(competbtn);
	chPanel.add(relaxbtn);
	chPanel.add(chretbtn);
	add(new JLabel("选择游戏模式"),BorderLayout.NORTH);
	add(chPanel,BorderLayout.CENTER);
	competbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			ChessFrame.getInstance().setVisible(true);
		}
	});
	relaxbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			ChessFrame2.getInstance().setVisible(true);
		}
	});
	chretbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			//完善获取上一个页面信息
			MiddleFrame.getInstance().setVisible(true);
		}
	});
}
public static ChooseFrame1 getInstance() {
	return instance;
}
}
