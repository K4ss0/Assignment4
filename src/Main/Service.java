package Main;

public class Service {
	
	public static void main(String[] args) {
		Collector collector = new Collector();
		collector.writeToFile("COMPSCI", "Course1.csv");
		collector.writeToFile("APMTH", "Course2.csv");
		collector.writeToFile("STAT", "Course3.csv");
	}

}
