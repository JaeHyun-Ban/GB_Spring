package ex05.collection;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("collection-context.xml");
		
		Custom c = ctx.getBean(Custom.class);
		
		System.out.println(c.getLists().toString());
		
		System.out.println(c.getVo().get(0).getId());
		System.out.println(c.getVo().get(0).getName());
		
		System.out.println(c.getVo().get(1).getId());
		System.out.println(c.getVo().get(1).getName());
		
		
		
	}
}










































