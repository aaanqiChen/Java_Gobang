package gobang_upgrade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;



public class TimePanel extends JPanel {
	private JLabel timeLabel;
	private JButton togglebtn;
	private javax.swing.Timer timer;
	private boolean running=false;
	private boolean isstart=false;
	private int way=0;
	public boolean isIsstart() {
		return isstart;
	}
	public void setIsstart(boolean isstart) {
		this.isstart = isstart;
	}
	public int getWay() {
		return way;
	}
	public void setWay(int way) {
		this.way = way;
	}
	private int elapsedTime=0;
	private String th,tm,ts;
private static final TimePanel instance=new TimePanel();
TimePanel(){
	setLayout(new BorderLayout());
	timeLabel=new JLabel("00:00:00",SwingConstants.CENTER);
	timeLabel.setFont(new Font("Serif",Font.PLAIN,24));
	timeLabel.setForeground(Color.RED);
	timeLabel.setOpaque(true);
	Color timeBColor=new Color(100,100,150);
	timeLabel.setBackground(timeBColor);//颜色调整
	togglebtn = new JButton("开始");
	togglebtn.addActionListener(new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(way==1) {
			Control.getInstance().makeStart();
			if(isstart) {
			if (timer.isRunning()) {
				timer.stop();
				running=false;
				togglebtn.setText("开始");
			} else {
				timer.start();
				running=true;
				togglebtn.setText("停止");
			}
			
		}
		}
			else {
				Control.getInstance().haveStart();
				isstart=true;
				if(isstart) {
					if (timer.isRunning()) {
						timer.stop();
						running=false;
						togglebtn.setText("开始");
					} else {
						timer.start();
						running=true;
						togglebtn.setText("停止");
					}
					
				}
			}
		}
	});
	JPanel norpanel=new JPanel(new FlowLayout());
	norpanel.add(timeLabel);
	norpanel.add(togglebtn);
	add(norpanel,BorderLayout.NORTH);
	add(TimekeepPanel.getInstance(),BorderLayout.CENTER);
	timer = new Timer(1000, e -> {
		if (running) {
			elapsedTime++;
			if(elapsedTime/3600>=10) {
				th=String.valueOf(elapsedTime/3600);
			}
			else th="0"+String.valueOf(elapsedTime/3600);
			if(elapsedTime/60>=10) {
				tm=String.valueOf(elapsedTime/60);
			}
			else tm="0"+String.valueOf(elapsedTime/60);
			if(elapsedTime%60>=10) {
				ts=String.valueOf(elapsedTime%60);
			}
			else ts="0"+String.valueOf(elapsedTime%60);
			timeLabel.setText(th+":"+tm+":"+ts);
			
		}
	});
}
public void fstart() {
	timer.start();
	running=true;
	togglebtn.setText("停止");
}
public static TimePanel getInstance() {
	return instance;
}

}