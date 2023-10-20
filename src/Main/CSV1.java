package Main;

public class CSV1 {
	//COMPSCI class results
	String filepath = "StudentData";
	Students[] students = Collector.readStudentDataFromFile(filepath);
	
	for (Students students : students) {
	if(students.getCourse().equals(COMPSCI)) {
		System.out.println(students);
		}
	}
}
