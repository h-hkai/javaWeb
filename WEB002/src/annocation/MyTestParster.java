package annocation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTestParster {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class clazz = TestDemo.class;
		
		Method[] methods = clazz.getMethods();
		
		if (methods != null) {
			for (Method method : methods) {
				boolean annotationPresent = method.isAnnotationPresent(MyTest.class);
				if (annotationPresent) {
					method.invoke(clazz.newInstance(), null);
				}
			}
		}
	}
}
