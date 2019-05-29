package classLoader;

import java.net.URL;

public class Demo {
	public static void main(String[] args) {
		Class clazz = Demo.class;
		ClassLoader classLoader = clazz.getClassLoader();
		String path = classLoader.getResource("db.properties").getPath();
		System.out.println(path);
	}
}
