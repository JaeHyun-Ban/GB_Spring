package ex08.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ex02.construct.Chef;
import ex02.construct.Hotel;
import ex03.setter.DatabaseDev;
import ex03.setter.MemberDAO;
import ex04.quiz.Airplane;
import ex04.quiz.Battery1;
import ex04.quiz.Battery2;
import ex04.quiz.Car;
import ex05.collection.MemberVO;

@Configuration //이 클래스가 스프링 설정파일이라는것을 표기(xml문서를 대신한다)
public class JavaConfig {
	
	//application-context.xml 을 참고
//	<bean id="chef" class="ex02.construct.Chef" />
//	<bean id="hotel" class="ex02.construct.Hotel">
//		<!-- 2.셰프생성자를 호텔생성자에 의존성 주입 -->
//		<constructor-arg ref="chef" />
//	</bean>
	
	//@Bean이 붙은 메서드를 스프링컨테이너가 객체로 생성한다.
	@Bean
	public Chef chef() {
		return new Chef();
	}

	@Bean
	public Hotel hotel() {
		return new Hotel(new Chef());
	}
	
	//-------------------------------------------
//	<bean id="db" class="ex03.setter.DatabaseDev">
//		<!-- setter에 set을 제거한 형태이다 -->
//		<property name="url" value="bean주소는 사서쓰세요 제발..." />
//		<property name="uid" value="bean아이디" />
//		<property name="upw" value="bean비밀번호" />
//	</bean>
//	<bean class="ex03.setter.MemberDAO">
//		<!-- db bean을 넣어준다 -->
//		<property name="ds" ref="db" />
//	</bean>
	
	@Bean
	public DatabaseDev db() {
		DatabaseDev dev = new DatabaseDev();
		dev.setUrl("자바로 설정한 데이터베이스 주소");
		dev.setUid("자바로 설정한 데이터베이스 아이디");
		dev.setUpw("자바로 설정한 데이터베이스 비밀번호");
		
		return dev;
	}
	
	@Bean
	public MemberDAO memberDAO() {
		
		MemberDAO dao = new MemberDAO();
		dao.setDs(db());
		return dao;
	}
	
	
	//배터리1,2 생성
	@Bean
	public Battery1 bt1() {
		return new Battery1();
	}
	
	@Bean
	public Battery2 bt2() {
		return new Battery2();
	}
	
	@Bean
	public Car car() {
		//생성한 bt1을 Car생성시에 넣어서 생성
		return new Car(bt1());
	}
	
	@Bean
	public Airplane ap() {
		Airplane ap = new Airplane();
		ap.setBattery(bt2());
		return ap;
//		return new Airplane(bt2());
	}
	
	
	
}
















































