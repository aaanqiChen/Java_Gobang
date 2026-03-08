package gobang_upgrade;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class TimekeepPanel extends JPanel{
	private JLabel timerLabel;
	private int i=0;
	private int currentPlayer=1;
	private int timeLeft=Model.TIMER_DURATION;
	private Timer timer;
	private boolean isrunning=false;
	private static final TimekeepPanel instance=new TimekeepPanel();
	private TimekeepPanel() {
		timerLabel=new JLabel("TimeLeft:"+timeLeft,SwingConstants.CENTER);
		timerLabel.setFont(new Font("Serif",Font.PLAIN,24));
		add(timerLabel);
	}
	public int getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	public int getTimeLeft() {
		return timeLeft;
	}
	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}
	public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public void startTimer() {
		timer=new Timer(1000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timeLeft--;
				if(currentPlayer==1) {
				timerLabel.setText("黑棋"+"00:"+timeLeft);
				}
				else {
					timerLabel.setText("白棋"+"00:"+timeLeft);
					
				}
				if(timeLeft<=0) {
					timer.stop();
					JOptionPane.showMessageDialog(instance, "Play"+currentPlayer+"times out!");
				}
				//切换玩家
				if(i==1) {
					currentPlayer=-currentPlayer;
					timeLeft=Model.TIMER_DURATION;
					if(currentPlayer==1) {
						timerLabel.setText("黑棋"+"00:"+timeLeft);
					}
					else {
						timerLabel.setText("白棋"+"00:"+timeLeft);
						
					}
					i=0;
				}
			}
		});
		timer.start();
	}
	public static TimekeepPanel getInstance() {
		return instance;
	}
	
	/*private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private ScheduledFuture<?> timerFuture;
	private JLabel clockLabel;
    private int timeLeft=30;
    private boolean running = false;
    private boolean playerTurn = true;
 private static final TimekeepPanel instance=new TimekeepPanel();
 private TimekeepPanel() {
        clockLabel = new JLabel("00:30", SwingConstants.CENTER);
        setLayout(new BorderLayout());
        add(clockLabel, BorderLayout.CENTER);
    }
 public static TimekeepPanel getInstance() {
	return instance;
}
    /*public void startTimer(int duration) {
        timeLeft = duration;
        running = true;
        new Thread(this::runTimer).start();
    }*/
   /* private void startTimer(boolean isrunning) {
    	running=isrunning;
    	if (timerFuture != null && !timerFuture.isDone()) {
    		timerFuture.cancel(false); // Cancel any existing timer
    	}
    	
    	Runnable timerTask = () -> {
    		while (timeLeft> 0 && running) {
    			try {
    				Thread.sleep(1000); // Sleep for 1 second
    				timeLeft--;
    				updateTimeDisplay();
    			} catch (InterruptedException ie) {
    				Thread.currentThread().interrupt(); // Restore interrupt status
    				break; // Exit the loop if interrupted
    			}
    		}
    		
    		if (!running) {
    			// If the game was stopped, we don't need to do anything special here
    			// because the loop will have exited due to the gameRunning check.
    			return;
    		}
    		
    		// If we reach here, the timer has expired.
    		SwingUtilities.invokeLater(() -> {
    			clockLabel.setText("00:00");
    			System.out.println("Time's up! " + (playerTurn ? "Player 1's" : "Player 2's") + " turn is over.");
    			// Switch turns here (not implemented in this simple example)
    			// playerTurn = !playerTurn;
    			// You might also want to notify the other player via the network here.
    		});
    	};
    	
    	// Schedule the timer task to run immediately and then repeatedly (but it won't repeat in this case)
    	// However, we only need it to run once, so we'll cancel it after it completes its work.
    	timerFuture = scheduler.schedule(timerTask, 0, TimeUnit.SECONDS);
    }
    
 
   /* public void stopTimer() {
        running = false;
    }
 
    public void resetTimer() {
        stopTimer();
        clockLabel.setText("Time: 30");
    }
 
    private void runTimer() {
        while (running && timeLeft > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeLeft--;
            clockLabel.setText();
 
            if (timeLeft <= 0) {
                stopTimer();
                // Handle time out action (e.g., end turn)
                System.out.println("Time out! End of turn.");
            }
        }
    }*/
  /*  private void stopTimer() {
        running = false;
        if (timerFuture != null && !timerFuture.isDone()) {
            timerFuture.cancel(false); // Cancel the timer if it's still running
        }
        updateTimeDisplay(); // Update the display to reflect the current time remaining (if any)
    }
 
    private void resetTimer() {
        stopTimer(); // Stop the timer if it's running
        timeLeft = 30;
        updateTimeDisplay(); // Reset the display to 30 seconds
        // You might also want to reset other game state here, such as playerTurn.
    }
 
    private void updateTimeDisplay() {
        String timeString = String.format("%02d:%02d", timeLeft/ 60, timeLeft% 60);
        SwingUtilities.invokeLater(() -> clockLabel.setText(timeString));
    }*/
    /*public static void main(String[] args) {
        JFrame frame = new JFrame("Timer Panel");
        TimerPanel panel = new TimerPanel();
        frame.add(panel);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
 
        // Example usage
        panel.startTimer(30);
 
        // Simulate stopping the timer after 5 seconds for testing
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        panel.stopTimer();
        panel.resetTimer();
    }*/
}
