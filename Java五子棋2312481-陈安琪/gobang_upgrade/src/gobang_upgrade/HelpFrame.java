package gobang_upgrade;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelpFrame extends JFrame{
	JLabel inforlabel=new JLabel("游戏规则介绍：");
	JButton retbtn=new JButton("返回");
private static final HelpFrame instance=new HelpFrame();
private HelpFrame() {
	setTitle("游戏说明");
	setSize(400,600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);//什么意思
	add(inforlabel,BorderLayout.CENTER);
	add(retbtn,BorderLayout.SOUTH);
	retbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			StartFrame.getInstance().setVisible(true);
			
		}
	});
}
public static HelpFrame getInstance() {
	return instance;
}
}
