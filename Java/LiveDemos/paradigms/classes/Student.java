package paradigms.classes;
public class Student{

	// attributes: they are private??
	private String [] grades;
	private String name;


	// declare an instance method
	public float computeGPA(){
		// for(int i = 0; i < grades.length ; i++){
		// 	String grade = grades[i];		s.computeGPA();

		// }
		float gpa = 0;
		for(String grade: grades){

			switch (grade) {
				case "A": gpa += 4.0; break;
				case "A-": gpa += 3.667; break;
				case "B+": gpa += 3.333; break;
				case "B": gpa += 3; break;
				case "B-": gpa += 2.667; break;
				case "C+": gpa += 2.333; break;
				case "C": gpa += 2; break;
				case "C-": gpa += 1.667; break;
				case "D": gpa += 1; break;
				case "F": gpa += 0; break;					
			}

		}

		return gpa / grades.length;
	}
	// we declare getter/ setter

	public void setGrades(String [] grades){
		this.grades = grades;
	}
}