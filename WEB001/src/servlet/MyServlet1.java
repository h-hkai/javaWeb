package servlet;

public class MyServlet1 implements IMyServlet{

	@Override
	public void init() {
		System.out.println("MyServlet1.init()...");
		
	}

	@Override
	public void service() {
		System.out.println("MyServlet1.service()...");
		
	}

	@Override
	public void destory() {
		System.out.println("MyServlet1.destory()...");
		
	}

}
