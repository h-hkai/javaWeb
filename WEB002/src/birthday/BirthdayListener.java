package birthday;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BirthdayListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				SimpleDateFormat format = new SimpleDateFormat("MM-dd");
				String currentDate = format.format(new Date());
				
				
			}
		}, new Date(), 1000*60);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextInitialized(sce);
	}

	
	
}
