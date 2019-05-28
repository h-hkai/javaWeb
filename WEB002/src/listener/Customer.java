package listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class Customer implements HttpSessionActivationListener, Serializable{
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("Customer sessionDidActivate...");
	}
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("Customer sessionWillPassivate...");
	}

}
