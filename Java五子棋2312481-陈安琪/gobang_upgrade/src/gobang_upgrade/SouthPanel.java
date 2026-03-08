package gobang_upgrade;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SouthPanel extends JPanel{
	private JButton regretbtn=new JButton("悔棋");
private static final SouthPanel instance=new SouthPanel();
private SouthPanel() {
	setLayout(new FlowLayout());
	ipTF.setText("localhost");
	portTF.setText("2345");
	add(new JLabel("ip"));
	add(ipTF);
	add(new JLabel("端口"));
	add(portTF);
	add(connectbtn);
	add(Listenbtn);
	add(new JLabel("         "));
	add(regretbtn,BorderLayout.SOUTH);
	regretbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Control.getInstance().islocalregretChess();
		}
	});
	Listenbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Net.getInstance().beginListen();
			Listenbtn.setEnabled(false);
			Control.getInstance().setLocalColor(Model.BLACK);
			Control.getInstance().setLocalDoor(false);
			Control.getInstance().setNorchess();
			TimePanel.getInstance().setWay(1);
		}
	});
	connectbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String ip=ipTF.getText();
			String port=portTF.getText();
			Net.getInstance().connect(ip,Integer.parseInt(port));
			connectbtn.setEnabled(false);
			Control.getInstance().setLocalColor(Model.WHITE);
			Control.getInstance().setLocalDoor(true);
			TimePanel.getInstance().setWay(2);
			 //Control.getInstance().setCurrentPlayer();
			//Control.getInstance().setNorchess();
		}
	});
};
public static SouthPanel getInstance() {
	return instance;
}
private JTextField ipTF=new JTextField(20);
private JTextField portTF=new JTextField(10);
private JButton connectbtn=new JButton("进房间");
private JButton Listenbtn=new JButton("开房间");
}
