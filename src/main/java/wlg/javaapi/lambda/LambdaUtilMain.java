package wlg.javaapi.lambda;

import java.util.*;

/**
 * Lambda Expressions
 * @author Administrator
 *
 */
public class LambdaUtilMain {

	/**
	 * 接口的动态判断使用
	 * @param roster
	 * @param tester 接口类，可动态多样化
	 */
	public static void printPersons(List<Person> roster, CheckPerson tester) {
	    for (Person p : roster) {
	        if (tester.test(p)) {
	            p.printPerson();
	        }
	    }
	}
	
	/**
	 * 接口及泛型的组合使用
	 * @param persons
	 * @param filter 制定一个泛型的接口
	 */
	public static void filterPersons(List<Person> persons,Filter<Person> filter){
		for (Person p : persons) {
	        if (filter.test(p)) {
	            p.printPerson();
	        }
	    }
	}
	
	
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setGender(Sex.MALE);
		
		Person p2 = new Person();
		p2.setGender(Sex.FEMALE);
		
		Person p3 = new Person();
		p3.setGender(Sex.FEMALE);
		p3.setName("Seven");
		
		Person p4 = new Person();
		p4.setGender(Sex.FEMALE);
		p4.setName("Seven");
		p4.setEmailAddress("seven@seven.com");
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		//接口动态的具体体现 1
		printPersons(persons,new CheckPersonService());
		
		System.out.println("-------------------------");
		
		//接口的动态使用体现 2 使用匿名类
		printPersons(persons,new CheckPerson(){
			@Override
			public boolean test(Person p) {
				return p.gender == Sex.FEMALE;
			}
		});
		
		System.out.println("-------------------------");
		
		//接口的动态使用 3 Lambda Expressions
		printPersons(persons,
				(Person p) -> 
				p.gender==Sex.FEMALE
				&& "Seven".equals(p.name));
		
		System.out.println("-------------------------");
		//泛型和匿名类的组合,及接口的动态性使用 4 Lambda Expressons 在一种写法
		filterPersons(persons,
				p -> {
					String mail = "seven@seven.com";
					return p.gender==Sex.FEMALE && mail.equals(p.emailAddress);});
	}
}
