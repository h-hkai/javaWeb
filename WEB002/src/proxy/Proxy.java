package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.junit.Test;

public class Proxy {
	@Test
	public void test1() {
		TargetInterface objProxy = (TargetInterface) java.lang.reflect.Proxy.newProxyInstance(
				Target.class.getClassLoader(),
				new Class[] {TargetInterface.class},
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] arg2) throws Throwable {
						Object invoke = method.invoke(new Target(), arg2);
						return invoke;
					}
				});
		objProxy.method1();
		System.out.println(objProxy.method2());
		
	}
}
