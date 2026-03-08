package gobang_upgrade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class LogonFrame extends JFrame{
	public int p=0;
	ArrayList<User> userr=new ArrayList<User>();
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	private int idd;
	private int pww;
	private int j=0;
private static final LogonFrame instance=new LogonFrame();
private LogonFrame() {
	setSize(250,400);
	setLocationRelativeTo(null);//什么意思
	getContentPane().setBackground(new Color(245,245,220));
	JPanel logPanel=new JPanel();
	JPanel logPanel2=new JPanel();
	logPanel.setBackground(new Color(245,245,220));
	logPanel2.setBackground(new Color(245,245,220));
	logPanel.setLayout(new GridLayout(2,1,0,30));
	logPanel2.setLayout(new GridLayout(3,1,0,30));
	JPanel panelk=new JPanel();
	panelk.setPreferredSize(new Dimension(100,50));
	JPanel panelk2=new JPanel();
	panelk2.setPreferredSize(new Dimension(100,50));
	panelk.setBackground(new Color(245,245,220));
	panelk2.setBackground(new Color(245,245,220));
	JTextField nametext=new JTextField(10);
	JTextField passwordtext=new JTextField(10);
	Document document1=nametext.getDocument();
	Document document2=passwordtext.getDocument();
	JPanel naPanel=new JPanel(new FlowLayout());
	JPanel pwPanel=new JPanel(new FlowLayout());
	naPanel.setBackground(new Color(245,245,220));
	pwPanel.setBackground(new Color(245,245,220));
	JButton registbtn=new JButton("没有用户？注册一个");
	JButton conformbtn=new JButton("确定");
	registbtn.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
	registbtn.setForeground(new Color(166,125,61)); // 设置前景色
	registbtn.setBackground(new Color(255,245,228));
	registbtn.setPreferredSize(new Dimension(50,30));
	conformbtn.setFont(new Font("Serif", Font.PLAIN, 16)); // 设置字体
	conformbtn.setForeground(new Color(166,125,61)); // 设置前景色
	conformbtn.setBackground(new Color(173,216,173));
	conformbtn.setPreferredSize(new Dimension(50,30));
	naPanel.add(new JLabel("用户名(id)："));
	naPanel.add(nametext);
	pwPanel.add(new JLabel("密码："));
	pwPanel.add(passwordtext);
	logPanel.add(naPanel);
	logPanel.add(pwPanel);
	logPanel2.add(panelk);
	//logPanel2.add(panelk2);
	logPanel2.add(registbtn);
	logPanel2.add(conformbtn);
	add(new JLabel("登录"),BorderLayout.NORTH);
	add(logPanel,BorderLayout.CENTER);
	add(logPanel2,BorderLayout.SOUTH);
	registbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			RegistFrame.getInstance().setVisible(true);
			
		}
	});
	document1.addDocumentListener(new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			idd=Integer.parseInt(nametext.getText());
			j++;
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {}
	});
	document2.addDocumentListener(new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			pww=Integer.parseInt(passwordtext.getText());
			j++;
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {}
	});
	conformbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(true) {
				System.out.println(j);
				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\eclipse\\gobang_upgrade\\src\\用户数据.txt"))) {
		            @SuppressWarnings("unchecked")
		            List<User> deserializedList = (List<User>) ois.readObject();
		            System.out.println("ArrayList has been deserialized from myList.ser");
		            deserializedList.forEach(System.out::println);
		        } catch (IOException | ClassNotFoundException e1) {
		            e1.printStackTrace();
		            // 在实际应用中，您可能希望进行更详细的错误处理
		        }
				userr=deserializeList("D:\\eclipse\\gobang_upgrade\\src\\用户数据.txt");
				int n=userr.size();
				for(p=0;p<n;p++) {
					if(userr.get(p).getId()==idd) {
						break;
					}
				}
				//存储这个用户的值
				int pw1=userr.get(p).getPassword();
				System.out.println(pw1);
				System.out.println(pww);
				if(pww==pw1) {
					Model.user.setId(idd);
					Model.user.setPassword(pww);
					Model.user.setName(userr.get(p).getName());
					Model.user.setGender(userr.get(p).getGender());
					Model.user.setLevel(userr.get(p).getLevel());
					Model.user.setScore(userr.get(p).getScore());
					Model.user.toString();
					if(userr.get(p).getGender()==1) {
						MiddleFrame.getInstance().setVisible(true);
					}
					else {
						MiddleFrame2.getInstance().setVisible(true);
					}
					dispose();
				}
				else {
					System.out.println("密码错误");
				}
			}
		}
	});
}
public ArrayList<User> getUserr() {
	return userr;
}
public void setUserr(ArrayList<User> userr) {
	this.userr = userr;
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
public static LogonFrame getInstance() {
	return instance;
}
}
