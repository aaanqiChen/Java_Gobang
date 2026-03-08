package gobang_upgrade;

public class Theme {
	private String name;
	private String chessbg;
	private String chatbg;
	private int[] other=new int[3];
	public Theme(String name, String chessbg, String chatbg, int[] other) {
		super();
		this.name = name;
		this.chessbg = chessbg;
		this.chatbg = chatbg;
		this.other = other;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChessbg() {
		return chessbg;
	}
	public void setChessbg(String chessbg) {
		this.chessbg = chessbg;
	}
	public String getChatbg() {
		return chatbg;
	}
	public void setChatbg(String chatbg) {
		this.chatbg = chatbg;
	}
	public int[] getOther() {
		return other;
	}
	public void setOther(int[] other) {
		this.other = other;
	}
}
