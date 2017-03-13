package test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ApplicationContext context = new ClassPathXmlApplicationContext("test/spring.xml");
       Shape shape = (Shape)context.getBean("circle");
       shape.draw();
	}

}
