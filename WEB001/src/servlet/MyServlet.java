package servlet;

public class MyServlet implements IMyServlet {

	public void init() {
		System.out.println("init...");
	}

	public void service() {
		System.out.println("service...");
	}

	public void destory() {
		System.out.println("destory...");
	}

}
