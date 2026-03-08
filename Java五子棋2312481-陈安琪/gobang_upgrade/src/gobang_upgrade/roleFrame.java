package gobang_upgrade;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class roleFrame extends JFrame{
private static final roleFrame instance=new roleFrame();
private roleFrame() {
	setTitle("兑换人物");
	setSize(600,500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);//什么意思
	JPanel cPanel=new JPanel(new GridLayout(2,3,20,20));
	setLayout(new BorderLayout());
	JPanel panel1=new JPanel(new BorderLayout());
	JPanel panel2=new JPanel(new BorderLayout());
	JPanel panel3=new JPanel(new BorderLayout());
	JPanel panel4=new JPanel(new BorderLayout());
	JPanel panel5=new JPanel(new BorderLayout());
	JPanel panel6=new JPanel(new BorderLayout());
	JButton btn1=new JButton("宫女 10金币");
	JButton btn2=new JButton("才人 30金币");
	JButton btn3=new JButton("贵人 60金币");
	JButton btn4=new JButton("昭仪 120金币");
	JButton btn5=new JButton("贵妃 200金币");
	JButton btn6=new JButton("皇后 500金币");
	ImageIcon imageIcon1=new ImageIcon("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\民女.jpg");
	ImageIcon imageIcon2=new ImageIcon("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\宫女.jpg");
	ImageIcon imageIcon3=new ImageIcon("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\才人.jpg");
	ImageIcon imageIcon4=new ImageIcon("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\贵人.jpg");
	ImageIcon imageIcon5=new ImageIcon("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\贵妃.jpg");
	ImageIcon imageIcon6=new ImageIcon("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\皇后.jpg");
	Image scaledImage1=imageIcon1.getImage().getScaledInstance(imageIcon1.getIconWidth()/4,imageIcon1.getIconHeight()/4, Image.SCALE_SMOOTH);
	Image scaledImage2=imageIcon2.getImage().getScaledInstance(imageIcon2.getIconWidth()/6,imageIcon2.getIconHeight()/6, Image.SCALE_SMOOTH);
	Image scaledImage3=imageIcon3.getImage().getScaledInstance(imageIcon3.getIconWidth()/6,imageIcon3.getIconHeight()/6, Image.SCALE_SMOOTH);
	Image scaledImage4=imageIcon4.getImage().getScaledInstance(imageIcon4.getIconWidth()/6,imageIcon4.getIconHeight()/6, Image.SCALE_SMOOTH);
	Image scaledImage5=imageIcon5.getImage().getScaledInstance(imageIcon5.getIconWidth()/6,imageIcon5.getIconHeight()/6, Image.SCALE_SMOOTH);
	Image scaledImage6=imageIcon6.getImage().getScaledInstance(imageIcon6.getIconWidth()/6,imageIcon6.getIconHeight()/6, Image.SCALE_SMOOTH);
	ImageIcon scaledImageIcon1=new ImageIcon(scaledImage1);
	ImageIcon scaledImageIcon2=new ImageIcon(scaledImage2);
	ImageIcon scaledImageIcon3=new ImageIcon(scaledImage3);
	ImageIcon scaledImageIcon4=new ImageIcon(scaledImage4);
	ImageIcon scaledImageIcon5=new ImageIcon(scaledImage5);
	ImageIcon scaledImageIcon6=new ImageIcon(scaledImage6);
	JLabel imageLabel1=new JLabel(scaledImageIcon1);
	JLabel imageLabel2=new JLabel(scaledImageIcon2);
	JLabel imageLabel3=new JLabel(scaledImageIcon3);
	JLabel imageLabel4=new JLabel(scaledImageIcon4);
	JLabel imageLabel5=new JLabel(scaledImageIcon5);
	JLabel imageLabel6=new JLabel(scaledImageIcon6);
	imageLabel1.setPreferredSize(new Dimension(150,200));
	imageLabel2.setPreferredSize(new Dimension(150,200));
	imageLabel3.setPreferredSize(new Dimension(150,200));
	imageLabel4.setPreferredSize(new Dimension(150,200));
	imageLabel5.setPreferredSize(new Dimension(150,200));
	imageLabel6.setPreferredSize(new Dimension(150,200));
	panel1.add(imageLabel1,BorderLayout.CENTER);
	panel2.add(imageLabel2,BorderLayout.CENTER);
	panel3.add(imageLabel3,BorderLayout.CENTER);
	panel4.add(imageLabel4,BorderLayout.CENTER);
	panel5.add(imageLabel5,BorderLayout.CENTER);
	panel6.add(imageLabel6,BorderLayout.CENTER);
	panel1.add(btn1,BorderLayout.SOUTH);
	panel2.add(btn2,BorderLayout.SOUTH);
	panel3.add(btn3,BorderLayout.SOUTH);
	panel4.add(btn4,BorderLayout.SOUTH);
	panel5.add(btn5,BorderLayout.SOUTH);
	panel6.add(btn6,BorderLayout.SOUTH);
	cPanel.add(panel1);
	cPanel.add(panel2);
	cPanel.add(panel3);
	cPanel.add(panel4);
	cPanel.add(panel5);
	cPanel.add(panel6);
	JButton retbtn=new JButton("返回");
	add(cPanel,BorderLayout.CENTER);
	add(retbtn,BorderLayout.SOUTH);
	retbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			
		}
	});
	btn1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Model.user.getScore()>=10) {
				Model.user.setScore(Model.user.getScore()-10);
				Model.user.setLevel(1);
				LogonFrame.getInstance().getUserr().get(LogonFrame.getInstance().getP()).setScore(Model.user.getScore());
				LogonFrame.getInstance().getUserr().get(LogonFrame.getInstance().getP()).setLevel(Model.user.getLevel());
				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\eclipse\\gobang_upgrade\\src\\用户数据.txt"))) {
		            oos.writeObject(LogonFrame.getInstance().getUserr());
		            System.out.println("ArrayList has been serialized to myList.ser");
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
				NorthPanel.getInstance().uplevel(1);
				JOptionPane.showMessageDialog(null, "购买成功","恭喜成功晋升为宫女！",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "购买失败","金币不足！",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	});
	btn2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Model.user.getScore()>=30) {
				Model.user.setScore(Model.user.getScore()-30);
				Model.user.setLevel(2);
				LogonFrame.getInstance().getUserr().get(LogonFrame.getInstance().getP()).setScore(Model.user.getScore());
				LogonFrame.getInstance().getUserr().get(LogonFrame.getInstance().getP()).setLevel(Model.user.getLevel());
				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\eclipse\\gobang_upgrade\\src\\用户数据.txt"))) {
					oos.writeObject(LogonFrame.getInstance().getUserr());
					System.out.println("ArrayList has been serialized to myList.ser");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//告诉控制器换身份
				JOptionPane.showMessageDialog(null, "购买成功","恭喜成功晋升为才人！",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "购买失败","金币不足！",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	});
	btn3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Model.user.getScore()>=60) {
				Model.user.setScore(Model.user.getScore()-60);
				Model.user.setLevel(3);
				LogonFrame.getInstance().getUserr().get(LogonFrame.getInstance().getP()).setScore(Model.user.getScore());
				LogonFrame.getInstance().getUserr().get(LogonFrame.getInstance().getP()).setLevel(Model.user.getLevel());
				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\eclipse\\gobang_upgrade\\src\\用户数据.txt"))) {
					oos.writeObject(LogonFrame.getInstance().getUserr());
					System.out.println("ArrayList has been serialized to myList.ser");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//告诉控制器换身份
				JOptionPane.showMessageDialog(null, "购买成功","恭喜成功晋升为贵人！",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "购买失败","金币不足！",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	});
	btn4.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Model.user.getScore()>=120) {
				Model.user.setScore(Model.user.getScore()-120);
				Model.user.setLevel(4);
				LogonFrame.getInstance().getUserr().get(LogonFrame.getInstance().getP()).setScore(Model.user.getScore());
				LogonFrame.getInstance().getUserr().get(LogonFrame.getInstance().getP()).setLevel(Model.user.getLevel());
				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\eclipse\\gobang_upgrade\\src\\用户数据.txt"))) {
					oos.writeObject(LogonFrame.getInstance().getUserr());
					System.out.println("ArrayList has been serialized to myList.ser");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//告诉控制器换身份
				JOptionPane.showMessageDialog(null, "购买成功","恭喜成功晋升为昭仪！",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "购买失败","金币不足！",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	});
	btn5.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Model.user.getScore()>=200) {
				Model.user.setScore(Model.user.getScore()-200);
				Model.user.setLevel(5);
				LogonFrame.getInstance().getUserr().get(LogonFrame.getInstance().getP()).setScore(Model.user.getScore());
				LogonFrame.getInstance().getUserr().get(LogonFrame.getInstance().getP()).setLevel(Model.user.getLevel());
				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\eclipse\\gobang_upgrade\\src\\用户数据.txt"))) {
					oos.writeObject(LogonFrame.getInstance().getUserr());
					System.out.println("ArrayList has been serialized to myList.ser");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//告诉控制器换身份
				JOptionPane.showMessageDialog(null, "购买成功","恭喜成功晋升为贵妃！",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "购买失败","金币不足！",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	});
	btn6.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Model.user.getScore()>=500) {
				Model.user.setScore(Model.user.getScore()-500);
				Model.user.setLevel(6);
				LogonFrame.getInstance().getUserr().get(LogonFrame.getInstance().getP()).setScore(Model.user.getScore());
				LogonFrame.getInstance().getUserr().get(LogonFrame.getInstance().getP()).setLevel(Model.user.getLevel());
				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\eclipse\\gobang_upgrade\\src\\用户数据.txt"))) {
					oos.writeObject(LogonFrame.getInstance().getUserr());
					System.out.println("ArrayList has been serialized to myList.ser");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//告诉控制器换身份
				JOptionPane.showMessageDialog(null, "购买成功","恭喜成功晋升为皇后！",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "购买失败","金币不足！",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	});
}
public static roleFrame getInstance() {
	return instance;
}
}
