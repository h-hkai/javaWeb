package listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Person implements HttpSessionBindingListener {
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		
		System.out.println("person's valueBound...");
	
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {

		System.out.println("person's valueUnbound...");
	
	}
	
	
}
