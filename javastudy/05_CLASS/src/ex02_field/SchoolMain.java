package ex02_field;

public class SchoolMain {
	public static void main(String[] args) {
	
	School school = new School();
	
	school.name = "경인중학교";
	
	Student student1 = new Student();
	student1.name = "전지현";
	student1.stuNo = "11025";
	Student student2 = new Student();
	student2.name = "정우성";
	student2.stuNo = "11026";
	
	school.students[0] = student1;	// school.students[i]에 값을 지정함.
	school.students[1] = student2;	
	
	for(int i = 0; i < school.students.length; i++) {
		System.out.println(school.students[i].stuNo);
		System.out.println(school.students[i].name);
	}
	
	}
	

}
