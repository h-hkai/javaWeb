package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println(scab.getName());
		System.out.println(scab.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println(scab.getName());
		System.out.println(scab.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println(scab.getName());
		System.out.println(scab.getValue());
	}
	
}
