package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxy2 {
	public static void main(String[] args) {
		
		Target target = new Target();
		
		TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] arg2) throws Throwable {
//						System.out.println(proxy);
						Object invoke = method.invoke(target, arg2);
						return invoke;
					}
				});
		proxy.method1();
		proxy.method2();
		System.out.println(proxy.sum(100, 100));
	}
}
