package gobang_upgrade;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheExecutorService {
	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	private ScheExecutorService() {}
	 
    // 提供一个静态方法来获取这个实例
    public static ScheduledExecutorService getScheduler() {
        return scheduler;
    }
}

