import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import de.winter.entity.Person;

public class App {
	public static void main(String[] args) throws FileNotFoundException {
		final double INC = 2.54;
		final double LBS = 0.45359;
		
		File datei = new File("biostats.csv");
		Scanner eingabe = new Scanner(datei);
		List<String> lines = new ArrayList<String>();
		List<Person> persons = new ArrayList<Person>();
		
		while ( eingabe.hasNext() ) {
			lines.add( eingabe.nextLine() );
		}
		eingabe.close();
		
		for ( int i = 1; i < lines.size(); i++) {
			String[] line = lines.get(i).split(",");
			
			String name = line[0].trim();
			String gender = line[1].trim();
			int age = Integer.parseInt( line[2].trim() );
			double height = round( Double.parseDouble( line[3].trim() ) * INC );
			double weight = Double.parseDouble( line[4].trim() ) * LBS;
			
			persons.add( new Person( name, gender, age, height, round(weight) ) );
		}
		
		for ( Person p : persons )
			System.out.println(p);
	}
	
	private static double round(double num) {
		return Math.round( num * 10 ) / 10.0 ;
	}
}
