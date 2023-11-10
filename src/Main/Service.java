package Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
                               
public class Service {
	
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		Collector collector = new Collector();
		Student[] sortedStudents = collector.studentSort();
		collector.courseArrays(sortedStudents);
		
		String compSciFile = "Course1.csv";
		String statFile = "Course2.csv";
		String apmthFile = "Course3.csv";
		
		if (collector.compSciStudents != null) {
		writeToFile(collector.compSciStudents, compSciFile);
		}
		if (collector.statStudents != null) {
		writeToFile(collector.statStudents, statFile);
		}
		if (collector.apmthStudents != null) {
		writeToFile(collector.apmthStudents, apmthFile);
		}
	}
	private static void writeToFile(Student[] compScistudents, String fileName) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
			for (Student student : compScistudents) {
				writer.write(student.toString());
				writer.newLine();
			}
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}


