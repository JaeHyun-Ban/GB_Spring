package ex04.quiz;

public class Airplane {

	private IBattery battery;// 모든 건전지를 받을 수 있도록 인터페이스를 받음
	
	//기본생성자
	public Airplane() {}
	
	// 생성자 주입
	public Airplane (IBattery battery) {
		this.battery = battery;
	}

	// getter
	public IBattery getBattery() {
		return battery;
	}

	//setter
	public void setBattery(IBattery battery) {
		this.battery = battery;
	}
	
}
