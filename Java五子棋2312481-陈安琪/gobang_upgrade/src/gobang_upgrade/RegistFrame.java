package gobang_upgrade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class RegistFrame extends JFrame{
	public ArrayList<User> users=new ArrayList<User>();
	private String naa;
	private int idd;
	private int pwd1;
	private int pwd2;
	private  int gde;
	private static int i=0;
private static final RegistFrame instance=new RegistFrame();
private RegistFrame() {
	setBackground(new Color(240,248,255));
	setSize(300,550);
	setLocationRelativeTo(null);//什么意思
	JPanel regPanel=new JPanel(new GridLayout(6,1,0,20));
	regPanel.setBackground(new Color(240,248,255));
	JTextField idTF=new JTextField(10);
	JTextField naTF=new JTextField(10);
	JTextField pwTF=new JTextField(10);
	JTextField repwTF=new JTextField(10);
	Document iddocument=idTF.getDocument();
	Document nadocument=naTF.getDocument();
	Document pwdocument=pwTF.getDocument();
	Document repwdocument=repwTF.getDocument();
	JPanel idPanel=new JPanel(new FlowLayout());
	JPanel naPanel=new JPanel(new FlowLayout());
	JPanel genPanel=new JPanel(new FlowLayout());
	JPanel pwPanel=new JPanel(new FlowLayout());
	JPanel repwPanel=new JPanel(new FlowLayout());
	idPanel.setBackground(new Color(240,248,255));
	naPanel.setBackground(new Color(240,248,255));
	genPanel.setBackground(new Color(240,248,255));
	pwPanel.setBackground(new Color(240,248,255));
	repwPanel.setBackground(new Color(240,248,255));
	JButton confirmbtn=new JButton("确认");
	confirmbtn.setBackground(new Color(135,206,235));
	JRadioButton girlbtn=new JRadioButton("女");
	JRadioButton boybtn=new JRadioButton("男");
	JButton showSelectbtn=new JButton("展示选项");
	girlbtn.setBackground(new Color(240,248,255));
	boybtn.setBackground(new Color(240,248,255));
	showSelectbtn.setBackground(new Color(135,206,235));
	ButtonGroup group=new ButtonGroup();
	group.add(girlbtn);
	group.add(boybtn);
	genPanel.add(girlbtn);
	genPanel.add(boybtn);
	genPanel.add(showSelectbtn);
	idPanel.add(new Label("请输入id:"));
	idPanel.add(idTF);
	naPanel.add(new JLabel("输入用户名："));
	naPanel.add(naTF);
	pwPanel.add(new JLabel("输入密码："));
	pwPanel.add(pwTF);
	repwPanel.add(new JLabel("请再输一次密码："));
	repwPanel.add(repwTF);
	regPanel.add(idPanel);
	regPanel.add(naPanel);
	regPanel.add(genPanel);
	regPanel.add(pwPanel);
	regPanel.add(repwPanel);
	regPanel.add(confirmbtn);
	add(new JLabel("注册"),BorderLayout.NORTH);
	add(regPanel,BorderLayout.CENTER);
	iddocument.addDocumentListener(new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {}
		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			idd=Integer.parseInt(idTF.getText());
			i++;
		}
		@Override
		public void changedUpdate(DocumentEvent e) {}
	});
	nadocument.addDocumentListener(new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {}
		@Override
		public void insertUpdate(DocumentEvent e) {
			naa=naTF.getText();
			i++;
		}
		@Override
		public void changedUpdate(DocumentEvent e) {}
	});
	pwdocument.addDocumentListener(new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {	}
		@Override
		public void insertUpdate(DocumentEvent e) {
			pwd1=Integer.parseInt(pwTF.getText());
			i++;
		}
		@Override
		public void changedUpdate(DocumentEvent e) {}
	});
	repwdocument.addDocumentListener(new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {}
		@Override
		public void insertUpdate(DocumentEvent e) {
			pwd2=Integer.parseInt(repwTF.getText());
			i++;
		}
		@Override
		public void changedUpdate(DocumentEvent e) {}
	});
	showSelectbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(girlbtn.isSelected()) {
				gde=1;
			}
			if(boybtn.isSelected()) {
				gde=-1;
			}
			i++;
		}
	});
	confirmbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(true) {
				if(pwd1==pwd2) {
					users=deserializeList("D:\\eclipse\\gobang_upgrade\\src\\用户数据.txt");
					users.add(new User(naa,idd,pwd1,gde,0,0));
					System.out.println("注册成功！");
					System.out.println(i);
					naTF.setText("");
					idTF.setText("");
					pwTF.setText("");
					repwTF.setText("");
					i=0;
					dispose();
					LogonFrame.getInstance().setVisible(true);
					//检查文件中是否已经存在该用户
					//添加该用户
					//存到文件中
					try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\eclipse\\gobang_upgrade\\src\\用户数据.txt"))) {
			            oos.writeObject(users);
			            System.out.println("ArrayList has been serialized to myList.ser");
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        }
				}
				else {
					System.out.println("密码错误！");
				}
			}
			else System.out.println("注册失败！");
		}
	});
}
public static ArrayList<User> deserializeList(String filePath) {
    ArrayList<User> list = null;
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
        list = (ArrayList<User>) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
    return list;
}
public ArrayList<User> getUsers() {
	return users;
}
public static RegistFrame getInstance() {
	return instance;
}

}
