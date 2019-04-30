package servlet;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestMyServlet {
	public static void main(String[] args) {
		testMyServlet();
	}
	
	@Test
	public static void testMyServlet() {
		
		try {
			SAXReader saxReader = new SAXReader();
			org.dom4j.Document document = saxReader.read("src/servlet/web.xml");
			Element rootElement = document.getRootElement();
			Element servletElement = rootElement.element("servlet");
			String servletClass = servletElement.element("servlet-class").getText();
			System.out.println(servletClass);
			Class class1 = Class.forName(servletClass);
			MyServlet1 ms1 = (MyServlet1) class1.newInstance();
			ms1.init();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
