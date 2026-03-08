package gobang_upgrade;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ChessFrame2 extends JFrame{
	private static final ChessFrame2 instance=new ChessFrame2();
	private ChessFrame2() {
		setTitle("五子棋");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		add(ChessPanel.getInstance(),BorderLayout.CENTER);
		add(SouthPanel.getInstance(),BorderLayout.SOUTH);
		add(EastPanel.getInstance(),BorderLayout.EAST);
	    add(NorthPanel2.getInstance(),BorderLayout.NORTH);
	}
	public static ChessFrame2 getInstance() {
		return instance;
	}
}
