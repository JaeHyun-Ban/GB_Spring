package ex08.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ex02.construct.Hotel;
import ex03.setter.MemberDAO;
import ex04.quiz.Airplane;
import ex04.quiz.Car;

public class MainClass {
	
	public static void main(String[] args) {
		
		//자바 설정을 확인하는 클래스(자바 xml파일)
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Hotel h = ctx.getBean(Hotel.class);
		h.getChef().cooking();
		
		MemberDAO dao = ctx.getBean(MemberDAO.class);
		dao.info();
		
		//bettery와 Car, Airplane을 자바설정으로 생성
		Car c = ctx.getBean(Car.class);
		Airplane ap = ctx.getBean(Airplane.class);
		c.getBattery().energy();
		ap.getBattery().energy();
		
		
		
		
		
		
		
	}
}









































