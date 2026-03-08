package gobang_upgrade;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiddleFrame2 extends JFrame{
	private static final MiddleFrame2 instance=new MiddleFrame2();
	private MiddleFrame2() {
		setTitle("五子棋");
		setSize(450,600);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);//什么意思
		add(MiddlePanel2.getInstance());
		//setContentPane(backgroundPanel.instance);
	}
	public static MiddleFrame2 getInstance() {
		return instance;
	}
}
