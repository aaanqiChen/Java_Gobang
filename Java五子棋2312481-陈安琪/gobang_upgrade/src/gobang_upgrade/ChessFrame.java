package gobang_upgrade;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ChessFrame extends JFrame{
	private static final ChessFrame instance=new ChessFrame();
	private ChessFrame() {
		setTitle("五子棋");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		add(ChessPanel.getInstance(),BorderLayout.CENTER);
		add(SouthPanel.getInstance(),BorderLayout.SOUTH);
		add(EastPanel.getInstance(),BorderLayout.EAST);
	    add(NorthPanel.getInstance(),BorderLayout.NORTH);
	}
	public static ChessFrame getInstance() {
		return instance;
	}
}
