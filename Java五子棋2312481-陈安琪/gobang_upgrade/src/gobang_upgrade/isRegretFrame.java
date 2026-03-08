package gobang_upgrade;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class isRegretFrame extends JFrame{
private static final isRegretFrame instance=new isRegretFrame();
private isRegretFrame() {
	setSize(400,300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);//什么意思
	JPanel panel=new JPanel(new FlowLayout());
	JButton okbtn=new JButton("同意");
	JButton nobtn=new JButton("不同意！");
	add(new JLabel("是否同意对方悔棋？"),BorderLayout.NORTH);
	panel.add(okbtn);
	panel.add(nobtn);
	add(panel,BorderLayout.SOUTH);
	okbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Control.getInstance().yesregret();
			dispose();
		}
	});
	nobtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		Control.getInstance().noregret();
		dispose();
		}
	});
}
public static isRegretFrame getInstance() {
	return instance;
}
}

