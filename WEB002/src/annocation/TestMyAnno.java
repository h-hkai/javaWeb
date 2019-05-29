package annocation;

public class TestMyAnno {
	
	@MyAnno(name = "Hugo")
	
//	@MyAnno(value = "xxx")
			
//	@MyAnno(value = { "" })
	public static void show(String str) {
		System.out.println("show running...");
	}
	
	
}
