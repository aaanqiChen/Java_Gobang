package gobang_upgrade;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class Control {
	private boolean door=false;
	int localColor=Model.BLACK;
	int otherColor=Model.WHITE;
	public void localPutChess(int row,int col) {
		if(!door) {
			return;
		}
		boolean success=Model.getInstance().putChess(row,col, localColor);
		if(success) {
			door=false;
			Net.getInstance().sendChess(row,col);
			ChessPanel.getInstance().repaint();
			TimekeepPanel.getInstance().setI(1);
			int winner=Model.getInstance().whowin();
			if(winner==Model.BLACK) {
				if(localColor==Model.BLACK) {
					Model.user.setScore(Model.user.getScore()+1);
					LogonFrame.getInstance().getUserr().get(LogonFrame.getInstance().getP()).setScore(Model.user.getScore());
					try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\eclipse\\gobang_upgrade\\src\\用户数据.txt"))) {
			            oos.writeObject(LogonFrame.getInstance().getUserr());
			            System.out.println("ArrayList has been serialized to myList.ser");
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        }
				}
				int result=JOptionPane.showConfirmDialog(null, "是否重新开始一局","恭喜黑棋赢！",JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION) {
					//初始化棋盘
					System.exit(0);
				}
				return;
			}
			if(winner==Model.WHITE) {
				if(localColor==Model.WHITE) {
					Model.user.setScore(Model.user.getScore()+1);
					LogonFrame.getInstance().getUserr().get(LogonFrame.getInstance().getP()).setScore(Model.user.getScore());
					try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\eclipse\\gobang_upgrade\\src\\用户数据.txt"))) {
			            oos.writeObject(LogonFrame.getInstance().getUserr());
			            System.out.println("ArrayList has been serialized to myList.ser");
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        }
				}
				int result=JOptionPane.showConfirmDialog(null, "是否重新开始一局","恭喜黑棋赢！",JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION) {
					//初始化棋盘
					System.exit(0);
				}
			return;
			}
			/*if(result==JOptionPane.OK_CANCEL_OPTION) {
				Model.getInstance().clear();
				ChessPanel.getInstance().repaint();
				
			}
			else {
				
			}*/ //判断是否重来或复盘
			//TimePanel.getInstance().clearTimeKeep();
		}
	}
	
	public void otherPutChess(int row, int col) {
		boolean success=Model.getInstance().putChess(row, col, otherColor);
		if(success) {
			door=true;
		ChessPanel.getInstance().repaint();
		TimekeepPanel.getInstance().setI(1);
		int winner=Model.getInstance().whowin();
		if(winner==Model.BLACK) {
			JOptionPane.showMessageDialog(null, "黑棋赢！");
			return;
		}
		if(winner==Model.WHITE) {
			JOptionPane.showMessageDialog(null, "白棋赢！");
			return;
		}
		//TimePanel.getInstance().timeKeep();
		}
	else {
		System.out.println("请下在正确的位置");
	}
	}
	
private static final Control instance=new Control();
private Control() {
}
public static Control getInstance() {
	return instance;
}

public void setLocalColor(int color) {
	localColor=color;
	otherColor=-color;
	
}

public void setLocalDoor(boolean b) {
	door=b;
}

public void localregretChess() {
	Net.getInstance().sendRegret();
	Model.getInstance().regret();
	ChessPanel.getInstance().repaint();
	setLocalDoor(!door);
	TimekeepPanel.getInstance().setI(1);
	TimekeepPanel.getInstance().setTimeLeft(Model.TIMER_DURATION);
	//变一下计时
}
public void otherregretChess() {
	Model.getInstance().regret();
	ChessPanel.getInstance().repaint();
	setLocalDoor(!door);
	TimekeepPanel.getInstance().setI(1);
	TimekeepPanel.getInstance().setTimeLeft(Model.TIMER_DURATION);
}

public boolean getDoor() {
	return door;
}

public void setLocalTheme(String selctheme) {
	if(selctheme.equals("默认")) {
		ChessPanel.getInstance().setImagePath("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\默认.jpg");
	}
	if(selctheme.equals("粉金绮梦")) {
		ChessPanel.getInstance().setImagePath("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\粉金绮梦.jpg");
	}
	if(selctheme.equals("粉绿烟霭")) {
		ChessPanel.getInstance().setImagePath("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\粉绿烟霭.jpg");
	}
	if(selctheme.equals("翠笺素影")) {
		ChessPanel.getInstance().setImagePath("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\翠笺素影.jpg");
	}
	if(selctheme.equals("梦水彩韵（紫）")) {
		ChessPanel.getInstance().setImagePath("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\梦水彩韵（紫）.jpg");
	}
	if(selctheme.equals("星河梦幻（蓝）")) {
		ChessPanel.getInstance().setImagePath("D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\星河幻梦（蓝）.jpg");
		//ChessPanel.getInstance().setImagePath(ThemeArray.getInstance().get(0).getChessbg());
		//ChatPanel.getInstance().setImagePath(ThemeArray.getInstance().get(0).getChatbg());
		
	}

}

public void sendmessage(String message) {
	Net.getInstance().sendMessage(message);
	
}

public void receiveChat(String substring) {
	ChatPanel.getInstance().receivemes(substring);
}

public void upLevel(int i) {
	NorthPanel.getInstance().uplevel(i);
}

public void makeStart() {
	Net.getInstance().sendStart();
}

public void doStart() {
	JOptionPane.showMessageDialog(ChessFrame.getInstance(), "","请按开始键开始",JOptionPane.INFORMATION_MESSAGE);
	
}

public void haveStart() {
	Net.getInstance().coStart();
}

public void CCoStart() {
	TimePanel.getInstance().fstart();
	TimePanel.getInstance().setIsstart(true);
	//setNorchess();
	//setCurrentPlayer();
	//ScheduledFuture<?> future1 = ScheExecutorService.getScheduler().schedule(MyTask1.getInstance(), 5, TimeUnit.SECONDS);
	//ScheduledFuture<?> future2 = ScheExecutorService.getScheduler().scheduleAtFixedRate(MyTask1.getInstance(), 10, 1, TimeUnit.SECONDS);
	//future1.cancel(false);
}

public void setCurrentPlayer() {
	Net.getInstance().sentStartTime();
	TimekeepPanel.getInstance().setCurrentPlayer(localColor);
	TimekeepPanel.getInstance().startTimer();
}

public int getOtherColor() {
	return otherColor;
}

public void setOtherColor(int otherColor) {
	this.otherColor = otherColor;
}

public int getLocalColor() {
	return localColor;
}

public void setDoor(boolean door) {
	this.door = door;
}

public void CoTimerStart() {
	System.out.println("CoTimerStart!");
	// TODO Auto-generated method stub
	TimekeepPanel.getInstance().setCurrentPlayer(otherColor);
	TimekeepPanel.getInstance().startTimer();
	
}

public void islocalregretChess() {
	Net.getInstance().sendisregret();
}

public void IsOtherregret() {
	isRegretFrame.getInstance().setVisible(true);
}

public void yesregret() {
	localregretChess();
	}

public void noregret() {
	JOptionPane.showMessageDialog(null,"操作失败！","对方不允许悔棋！",JOptionPane.INFORMATION_MESSAGE);
}

public void setNorchess() {
	chesPanel.getInstance().changechespanel();
	
}
}
