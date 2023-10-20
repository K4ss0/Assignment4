package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Collector {

	public static void main(String[] args) {
		// file reader
		// 4 parts Student ID' Student Name, Course, Grade
		String filePath = "StudentData";
		Students[] students = readStudentDataFromFile(filePath);
	}
	
	public static Students[]readStudentDataFromFile(String filePath){
		Students[] students = new Students[100];
		
		try(FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			
			String line;
			int studentCount = 0;
			while((line = bufferedReader.readLine()) != null) {
				String[]parts = line.split(",");
				if (parts.length == 4) {
					String studentID = parts[0];
					String studentName = parts[1];
					String course = parts[2];
					String grade = parts[3];
					
					students[studentCount] = new Students(studentID, studentName, course, grade);
					
					studentCount++;
					System.out.println(students);
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return students;
		}
}