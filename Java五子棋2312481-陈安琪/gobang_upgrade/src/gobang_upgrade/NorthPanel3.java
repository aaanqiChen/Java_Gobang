package gobang_upgrade;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NorthPanel3 extends JPanel{
	private ImageIcon imageIcon;
	private static final NorthPanel3 instance=new NorthPanel3();
	private NorthPanel3() {
		setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
		JLabel roleLabel=new JLabel("平民");
		JPanel rolePanel=new JPanel(new BorderLayout());
		imageIcon=new ImageIcon("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\平民.jpg");
		Image scaledImage1=imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth()/10,imageIcon.getIconHeight()/10, Image.SCALE_SMOOTH);
		ImageIcon scaledImageIcon1=new ImageIcon(scaledImage1);
		JLabel imageLabel=new JLabel(scaledImageIcon1);
		imageLabel.setPreferredSize(new Dimension(80,80));
		rolePanel.add(roleLabel,BorderLayout.NORTH);
		rolePanel.add(imageLabel,BorderLayout.CENTER);
		add(rolePanel);
		add(chesPanel.getInstance());
		add(new JLabel("             "));
		add(TimePanel.getInstance());
		add(new JLabel("             "));
		String[] options= {"默认","粉金绮梦","粉绿烟霭","梦水彩韵（紫）","星河梦幻（蓝）","翠笺素影"};
		JComboBox<String> themecbb=new JComboBox<>(options);
		add(themecbb);
		themecbb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selctheme=(String)themecbb.getSelectedItem();
					Control.getInstance().setLocalTheme(selctheme);
				
			}
		});
	}

	public static NorthPanel3 getInstance() {
		return instance;
	}
	public void uplevel(int i) {
		imageIcon=new ImageIcon("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\宫女.jpg");
	}
}
