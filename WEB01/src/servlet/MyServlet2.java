package servlet;

public class MyServlet2 implements IMyServlet{

	@Override
	public void init() {
		System.out.println("MyServlet2.init()...");
		
	}

	@Override
	public void service() {
		System.out.println("MyServlet2.servlet()...");
		
	}

	@Override
	public void destory() {
		System.out.println("MyServlet2.destory()...");
		
	}

}
