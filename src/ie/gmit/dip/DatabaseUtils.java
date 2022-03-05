package ie.gmit.dip;

import java.io.*;

public class DatabaseUtils {

	public static void save(StudentManager sm, String fileName) throws Exception {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
			out.writeObject(sm);
			out.close();
			System.out.println("[INFO] Database Successfully Saved in " + fileName);
		} catch (IOException e) {
			throw new Exception("[ERROR] Cannot save the Student Manager to " + fileName + ". " + e.getMessage());
		}
	}

	public static StudentManager load(String fileName) throws Exception {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(fileName)));
			StudentManager sm = (StudentManager) in.readObject();
			in.close();
			return sm;
		} catch (IOException e) {
			throw new Exception("[ERROR] Cannot load the Student Manager from " + fileName + ". " + e.getMessage());
		}
	}
}
