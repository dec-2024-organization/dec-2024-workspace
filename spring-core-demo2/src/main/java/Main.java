import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.mybeans.Employee;
import com.demo.mybeans.Person;

public class Main {

	public static void main(String[] args) {
		Person person1 = new Person(501, "Rupert", "Grint");
		System.out.println(person1);
		
		// first create the IOC container
		ApplicationContext context = new ClassPathXmlApplicationContext("my-anno.xml");
		Person person2 = context.getBean("person", Person.class);
		System.out.println(person2);
		
		Employee emp1 = context.getBean("employee", Employee.class);
		System.out.println(emp1);
		
	}

}
