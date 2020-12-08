package ex04.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		//Car Airplaine 빈을 생성하고, 아무 배터리나 의존성 주입
		//각 객체 안에 있는 배터리를 자바클래스에서 출력
		
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context.xml");
		
		Car c = ctx.getBean(Car.class);
		c.getBattery().energy();;
		
		Airplane a = ctx.getBean("ap", Airplane.class);//아이디가 ap인 class

		a.getBattery().energy();
		
		
		
		
		
		
		
		
		
		
		
	}
}
