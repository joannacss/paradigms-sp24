package paradigms;

import paradigms.classes.Student;

public class StudentMain{

	public static void main(String [] args){
		Student s = new Student();

		s.setGrades(new String[]{ "A", "A-", "B+"});
		float g = s.computeGPA();

		System.out.println("GPA is " + g);
	}
}