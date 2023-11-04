package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Collector {

	String filePath = "StudentData";
	Student[] students = readStudentDataFromFile(filePath);
	
	public static Student[] readStudentDataFromFile(String filePath) {
		Student[] students = new Student[100];
		
		try(FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			
			String line;
			int studentCount =0;
			while((line = bufferedReader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 4) {
					String studentID = parts[0];
					String studentName = parts[1];
					String course = parts[2];
					String grade = parts [3];
					
					students[studentCount] = new Student(studentID, studentName, course, grade);
					
					studentCount++;
					}
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			return students;
		}
	

	public void studentSort() {
		students = Arrays.copyOf(students, students.length);
		
		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student student1, Student student2) {
				int gradeComparison = student1.getGrade().compareTo(student2.getGrade());
				if(gradeComparison !=0) {	
					return gradeComparison;
				}
				return student1.getCourse().compareTo(student2.getCourse());
		}
	});
}
	
	
	public void writeToFile(String course, String filename) {
		studentSort();
		
		String currentCourse = "";
		FileWriter fileWriter = null;
		
		for(Student student : students) {
			if(!student.getCourse().equals(currentCourse)) {
				if(fileWriter != null) {
					try {
						fileWriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				currentCourse = student.getCourse();
					if (currentCourse.equals(course)) {
					try {
						fileWriter = new FileWriter(filename);
						fileWriter.write("studentID, studentName, course, grade\n");
					}catch(IOException e) {
					e.printStackTrace();
				}
			}
			try {
				if(currentCourse.equals(course) && fileWriter != null) {
				fileWriter.write(student.getStudentID() + ", " + student.getStudentName() + "," + student.getCourse() + "," + student.getGrade() + "\n" );
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (fileWriter !=null) {
			try {
				fileWriter.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
}