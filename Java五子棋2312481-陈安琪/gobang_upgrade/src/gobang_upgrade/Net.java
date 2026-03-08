package gobang_upgrade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Net {
private ServerSocket ss;
private Socket s;
private BufferedReader in;
private PrintStream out;
public static final int PORT=2345;
public void beginListen() {
	new Thread() {
		public void run() {
			try {
				System.out.println("开始监听");
			ss=new ServerSocket(PORT);
			s=ss.accept();
			in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			out=new PrintStream(s.getOutputStream(),true);
			startReadThred();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}.start();
}
public void connect(String ip,int port) {
	try {
		System.out.println("连接成功");
		s=new Socket(ip,port);
		in=new BufferedReader(new InputStreamReader(s.getInputStream()));
		out=new PrintStream(s.getOutputStream(),true);
		startReadThred();
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
protected void startReadThred() {
	new Thread() {
		public void run() {
			String line;
			try {
				while((line=in.readLine())!=null) {
					parseMassage(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}.start();
}
protected void parseMassage(String line) {
	//chat:XXX
	//chess:XXX
	//other:XXX
	if(line.startsWith("Chat:")) {
		parseChat(line.substring(5));
	}else if(line.startsWith("Chess:")) {
		parseChess(line.substring(6));
	}
	else if(line.startsWith("Regret:")){
		parseRegret();
	}
	else if(line.startsWith("Start:")){
		parseStart();
	}
	else if(line.startsWith("Costart:")) {
		parseCostart();
	}
	else if(line.startsWith("TimerStart:")) {
		parseTimerStart();
	}
	else if(line.startsWith("Isregret:")) {
		parseIsregret();
	}
	}
private void parseIsregret() {
	Control.getInstance().IsOtherregret();
	
}
private void parseTimerStart() {
	Control.getInstance().CoTimerStart();
	
}
private void parseCostart() {
	Control.getInstance().CCoStart();
}
private void parseStart() {
	Control.getInstance().doStart();
}
private void parseChat(String substring) {
	Control.getInstance().receiveChat(substring);
	
}
private void parseRegret() {
	Control.getInstance().otherregretChess();
	
}
private void parseChess(String substr) {
	String[] a=substr.split(",");
	int row=Integer.parseInt(a[0]);
	int col=Integer.parseInt(a[1]);
	Control.getInstance().otherPutChess(row,col);
	
}
private static final Net instance=new Net();
private Net(){}
public static Net getInstance() {
	return instance;
}
public void sendChess(int row, int col) {
	out.println("Chess:"+row+","+col);
}
public void sendRegret() {
	out.println("Regret:");
	
}
public void sendMessage(String message) {
	out.println("Chat:"+message);
	
}
public void sendStart() {
	out.println("Start:");
}
public void coStart() {
	out.println("Costart:");
}
public void sentStartTime() {
	out.println("TimerStart:");
	
}
public void sendisregret() {
	out.println("Isregret:");
	
}
}

