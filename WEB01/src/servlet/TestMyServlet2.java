package servlet;

import org.junit.Test;

public class TestMyServlet2 {
	public static void main(String[] args) {
		testMyServlet1();
	}
	
	@Test
	public static void testMyServlet() {
		MyServlet ms = new MyServlet();
		ms.init();
		ms.service();
		ms.destory();
	}
	
	@Test
	public static void testMyServlet1() {
		try {
			String classname = "servlet.MyServlet";
			Class clazz = Class.forName(classname);
			MyServlet ms = (MyServlet) clazz.newInstance();
			ms.init();
			ms.service();
			ms.destory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
