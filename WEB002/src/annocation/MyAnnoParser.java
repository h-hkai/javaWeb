package annocation;

import java.lang.reflect.Method;

public class MyAnnoParser {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Class clazz = TestMyAnno.class;
		Method method = clazz.getMethod("show", String.class);
	
		MyAnno annotation = method.getAnnotation(MyAnno.class);
		System.out.println(annotation.age());
		System.out.println(annotation.name());
	
	
	
	}
}
