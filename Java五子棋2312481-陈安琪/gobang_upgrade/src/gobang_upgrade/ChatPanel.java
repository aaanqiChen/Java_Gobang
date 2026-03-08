package gobang_upgrade;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatPanel extends JPanel{
	private JTextArea messageArea;
	private JTextField inputField;
	private JButton sendbtn;
	//private String imagePath;
	//private Icon backgroundIcon;
	//JLabel backgroundLabel=new JLabel(backgroundIcon);
	private static final ChatPanel instance=new ChatPanel();
	private ChatPanel() {
    setLayout(new BorderLayout());
    add(new JLabel("聊天区"),BorderLayout.NORTH);
    messageArea=new JTextArea();
    messageArea.setEditable(false);
    //messageArea.setBackground(new Color(0,0,0,0));
    messageArea.setLineWrap(true);
    messageArea.setWrapStyleWord(true);
    //messageArea.setOpaque(false);
    JScrollPane scrollPane=new JScrollPane(messageArea);//学习了解
    //backgroundLabel.add(scrollPane,BorderLayout.CENTER);
    //add(backgroundLabel,BorderLayout.CENTER);
    add(scrollPane,BorderLayout.CENTER);
    JPanel inputPanel=new JPanel();
    inputPanel.setLayout(new BorderLayout());
    inputField=new JTextField();
    inputPanel.add(inputField,BorderLayout.CENTER);
    sendbtn=new JButton("发送");
    inputPanel.add(sendbtn,BorderLayout.EAST);
    add(inputPanel,BorderLayout.SOUTH);
    sendbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String message=inputField.getText();
			inputField.setText("");
			messageArea.append("我:"+message+"\n");
			Control.getInstance().sendmessage(message);
			
		}
	});
    inputField.addKeyListener(new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {}
		@Override
		public void keyReleased(KeyEvent e) {
			//阻值换行功能
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				e.consume();
				String message=inputField.getText();
				inputField.setText("");
				messageArea.append("我:"+message+"\n");
				Control.getInstance().sendmessage(message);
			}
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {}
	});

}

	/*public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
		backgroundIcon=new ImageIcon(imagePath);
		backgroundLabel.setIcon(backgroundIcon);
	}*/

	public static ChatPanel getInstance() {
		return instance;
	}
	public void receivemes(String substring) {
		messageArea.append("棋友："+substring+"\n");
		
	}
}
