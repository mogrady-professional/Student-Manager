package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;

public class StudentFileParser {

	public void parse(String fileName, StudentManager sm) {
		String record = null;
		System.out.println("[INFO] Attempting to Load Database from " + fileName + " ...");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))))) {
			while ((record = br.readLine()) != null) {

				// G0>>Samantha>>O'Reilly>>-785371626869>>Physics>>Longford
				String[] fields = record.split(">>");
				if (fields.length != 6)
					continue;

				Student s = new Student(fields[0], fields[1], fields[2], new Date(Long.parseLong(fields[3])));
				s.setAddress(new Address(fields[5]));
				s.setCourse(new Course(fields[4]));
				sm.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR] Cannot load the Data from " + fileName + ". " + e.getMessage());
			System.exit(0);
		}
	}
}
