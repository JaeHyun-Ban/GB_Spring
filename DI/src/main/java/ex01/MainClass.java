package ex01;

import javax.swing.Spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
//		SpringTest st = new SpringTest();
//		st.test();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context.xml");
		
		
		//객체를 생성한 적이 없지만 실행이 됬다
		//getBean을 이용해 xml에 생성된 객체를 가져온다
		SpringTest st = ctx.getBean(SpringTest.class);
		st.test();
		
		//스프링 설정
		SpringTest st2 = ctx.getBean(SpringTest.class);
		System.out.println(st == st2);
		
	}
	
	
}
