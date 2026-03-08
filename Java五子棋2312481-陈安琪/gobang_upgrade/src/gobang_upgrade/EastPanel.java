package gobang_upgrade;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EastPanel extends JPanel{
private static final EastPanel instance=new EastPanel();
EastPanel(){
	setLayout(new BorderLayout());
	add(ChatPanel.getInstance(),BorderLayout.CENTER);
}
public static EastPanel getInstance() {
	return instance;
}

}
