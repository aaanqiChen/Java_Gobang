package gobang_upgrade;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ChessFrame3 extends JFrame{
	private static final ChessFrame3 instance=new ChessFrame3();
	private ChessFrame3() {
		setTitle("五子棋");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		add(ChessPanel.getInstance(),BorderLayout.CENTER);
		add(SouthPanel.getInstance(),BorderLayout.SOUTH);
		add(EastPanel.getInstance(),BorderLayout.EAST);
	    add(NorthPanel3.getInstance(),BorderLayout.NORTH);
	}
	public static ChessFrame3 getInstance() {
		return instance;
	}
}
