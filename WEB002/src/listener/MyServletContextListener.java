package listener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sec) {
//		ServletContext servletContext = sec.getServletContext();
//		Object source = sec.getSource();
		
		System.out.println("context create...");
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("run...");
			}
		}, new Date(), 5000);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String currentTime = "2018-05-26 00:00:00";
		Date parse = null;
		try {
			parse = format.parse(currentTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("run...");
			}
		}, parse, 24*60*60*1000);
	}
	
	public void contextDestroyed(ServletContextEvent sec) {
		
		
		System.out.println("context destory...");
	}
}
