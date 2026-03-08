package gobang_upgrade;

import java.util.ArrayList;

public class ThemeArray extends ArrayList<Theme>{
	private int[] a= {0,0,0};
	private String tname;
	private String bg1;//="D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\雾影翠峰.jpg";
	private String bg2;//="D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\暖缎金屑.jpg";
	private static final ThemeArray instance=new ThemeArray();
	private Theme them=new Theme(tname,bg1,bg2,a);
	private ThemeArray() {
		// TODO Auto-generated constructor stub
		tname="翠笺素影";
		bg1="D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\翠笺素影.jpg";
		bg2="D:\\eclipse\\gobang_upgrade\\src\\五子棋图片\\翠笺素影1.jpg";
        them.setName(tname);
		them.setChessbg(bg1);
		them.setChatbg(bg2);
		them.setOther(a);
		add(them);
	}
	public static ThemeArray getInstance() {
		return instance;
	}
}
