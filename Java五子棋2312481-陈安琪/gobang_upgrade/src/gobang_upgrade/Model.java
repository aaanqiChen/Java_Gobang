package gobang_upgrade;

import java.util.ArrayList;

public class Model {
	private static final Model instance=new Model();
	private Model() {
		
	}
	public static Model getInstance() {
		return instance;
	}
public static final int BLACK=1;
public static final int WHITE=-1;
public static final int SPACE=0;
public static final int WIDE=19;
public static final int TIMER_DURATION=30;
public static final User user=new User();
private int[][] data=new int[WIDE][WIDE];
private ArrayList<Point> chessList=new ArrayList<>();
private int lastrow,lastcol;
public boolean putChess(int row,int col,int color) {
	if(row>=0&&row<WIDE&&col>=0&&col<WIDE&&data[row][col]==SPACE) {
		data[row][col]=color;
		lastrow=row;
		lastcol=col;
		Point.getInstancce().setRow(row);
		Point.getInstancce().setCol(col);
		Point.getInstancce().setColor(color);
		chessList.add(Point.getInstancce());
		return true;
	}
	return false;
}
public int getChess(int row,int col) {
	if(row>=0&&row<WIDE&&col>=0&&col<WIDE&&data[row][col]!=SPACE) {
	return data[row][col];
	}
	else return SPACE;
}
public void clear() {
	for(int row=0;row<WIDE;row++) {
		for(int col=0;col<WIDE;col++) {
			data[row][col]=SPACE;
		}
	}
}
public void regret() {
	int size=chessList.size();
	int r=chessList.get(size-1).getRow();
	int c=chessList.get(size-1).getCol();
	data[r][c]=SPACE;
	chessList.remove(size-1);
	lastrow=chessList.get(size-2).getRow();
	lastcol=chessList.get(size-2).getCol();
}
public void aiReplay() {
	
}
public int whowin() {
	int row=lastrow;
	int column=lastcol;
	int[] k= {0,0,0,0};
	for(int i=0;getChess(row,column-i)==getChess(row,column);i++) {
		k[0]++;
	}
	for(int i=1;getChess(row,column+i)==getChess(row,column);i++) {
		k[0]++;
	}
	for(int i=0;getChess(row-i,column)==getChess(row,column);i++) {
		k[1]++;
	}
	for(int i=1;getChess(row+i,column)==getChess(row,column);i++) {
		k[1]++;
	}
	for(int i=0;getChess(row-i,column-i)==getChess(row,column);i++) {
		k[2]++;
	}
	for(int i=1;getChess(row+i,column-i)==getChess(row,column);i++) {
		k[2]++;
	}
	for(int i=0;getChess(row-i,column-i)==getChess(row,column);i++) {
		k[3]++;
	}
	for(int i=1;getChess(row+i,column+i)==getChess(row,column);i++) {
		k[3]++;
	}
	if(k[0]>=5||k[1]>=5||k[2]>=5||k[3]>=5) {
		return getChess(row,column);
	}
	else return 0;
}

}
