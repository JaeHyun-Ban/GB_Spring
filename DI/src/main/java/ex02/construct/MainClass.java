package ex02.construct;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		//호텔은 생성될 때 반드시 Chef를 필요로 한다
		//>Hotel은 Chef한테 의존적이다
//		Chef c = new Chef();		
//		Hotel h = new Hotel(c);
//		h.getChef().cooking();;
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context.xml");
		Hotel h = ctx.getBean(Hotel.class);
		h.getChef().cooking();//chef객체를 따로 생성하지 않았지만 bean에서 이미 처리했으므로 동작한다
		
		
		
	}
	
	
}
