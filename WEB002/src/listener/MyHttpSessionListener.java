package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		String id = se.getSession().getId();
		System.out.println("session created..." + id);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session destoryed...");
	}

}
