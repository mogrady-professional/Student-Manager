package ie.gmit.dip;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Menu {
	private StudentManager sm = new StudentManager();
	private Scanner s;
	private boolean keepRunning = true;

	public Menu() {
		s = new Scanner(System.in);
	}

	public void start() throws InterruptedException {
		while (keepRunning) {
			showOptions();
			int choice = Integer.parseInt(s.next()); // Blocks...
			switch (choice) {
			case 1 -> add();
			case 2 -> delete();
			case 3 -> showAllStudents();
			case 4 -> searchByID();
			case 5 -> searchByFirstName();
			case 6 -> total();
			case 7 -> save();
			case 8 -> load();
			case 9 -> about();
			case 10 -> {
				System.out.println("[INFO] Shutting Down...please wait...");
				System.out.println("Thank you for using Student Manager.");
				TimeUnit.SECONDS.sleep(1);
				keepRunning = false;
			}
			default -> System.out.println("[ERROR] Invalid Input.");
			}
		}
	}

	private void save() {
		System.out.println("[INFO] Save Student Manager Database");
		System.out.println(
				"Enter the Filepath Location where to Save the Database: (including the Filename and extension):");
		String file = s.next(); // Student ID. Block and wait....
		try {
			DatabaseUtils.save(sm, file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private void load() {
		System.out.println("[INFO] Load Student Manager Database");
		System.out.println("Enter the Location of the Database: (include the Filename and extension)\n i.e. C:\\Users\\Michael\\Desktop\\db\\100000-students.db");
		String file = s.next(); // Student ID. Block and wait....
		try {
			long start = System.currentTimeMillis();
			sm = DatabaseUtils.load(file);
			System.out.println("[INFO] Database Found!");
			System.out.println("[INFO] Loading Database...");
			System.out.println("[INFO] Load time (ms): " + (System.currentTimeMillis() - start));
			System.out.println("[INFO] Database Loaded Successfully!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void loadFromFile(String fileName) {
		StudentFileParser sfp = new StudentFileParser();
		sfp.parse(fileName, sm);
	}

	private void add() {
		System.out.println("[INFO] Add a Student");
		System.out.println("Enter Student ID>");
		String id = s.next(); // Student ID. Block and wait....

		System.out.println("Enter Student First Name>");
		String fname = s.next(); //

		System.out.println("Enter Student Surname>");
		String surname = s.next(); //
		s.nextLine();

		Date d = new Date();

		Student s1 = new Student(id, fname, surname, d);

		System.out.println("Enter Address>");
		s1.setAddress(new Address(s.nextLine()));

		System.out.println("Enter Course Name>");
		s1.setCourse(new Course(s.nextLine()));

		boolean added = sm.add(s1); // Add the student to the array in StudentManager
		if (added) {
			System.out.println("[INFO] Student added okay. There are now " + sm.size() + " records in the database.");
		} else {
			System.out.println("[INFO] Could not add student to database.");
		}
	}

	private void delete() {
		System.out.println("[INFO] Delete a Student");

		System.out.println("Enter Student ID>");
		String id = s.next(); // Student ID. Block and wait....

		boolean deleted = sm.delete(id);
		if (deleted) {
			System.out.println("[INFO] Student deleted okay. There are now " + sm.size() + " records in the database.");
		} else {
			System.out.println("[INFO] No student found with that ID.");
		}
	}

	private void showAllStudents() {
		System.out.println("[INFO] Printing List of all Students");
		sm.listAllStudents();
	}

	private void searchByID() {
		System.out.println("[INFO] Search for a Student by ID");
		System.out.println("Enter Student ID>");
		String id = s.next(); // Student ID. Block and wait....

		Student s1 = sm.getStudentById(id);

		if (s1 != null) {
			System.out.println(s1);
		} else {
			System.out.println("[INFO] No student found with that ID.");
		}
	}

	private void searchByFirstName() {
		System.out.println("[INFO] Search for Students by First Name");
		System.out.println("Enter Student First Name>");
		String name = s.next(); // Student Name. Block and wait....

		Student[] students = sm.getStudentsByFirstName(name);
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
		}
	}

	private void total() {
		System.out.println("[INFO] Get Total Number of Students");
		int total = sm.size();
		System.out.println("[INFO] " + total + " students found.");
	}

	private void about() {
		System.out.println(
				"This is an application I developed during the Object Oriented Software Develoment Module \nwithin the Higher Diploma in Science in Software Development at GMIT.");
		System.out.println("~ Michael O'Grady\nwww.michaelogrady.net");
	}

	private void showOptions() {
		System.out.println("################################################");
		System.out.println("#               Student Manager 1.0            #");
		System.out.println("#                   Main Menu                  #");
		System.out.println("################################################");
		System.out.println("# Select an Option:                            #");
		System.out.println("# (1) Add Student                              #");
		System.out.println("# (2) Delete Student                           #");
		System.out.println("# (3) List All Students                        #");
		System.out.println("# (4) Search for Student by ID                 #");
		System.out.println("# (5) Search for Students By First Name        #");
		System.out.println("# (6) Get Total Number of Students             #");
		System.out.println("# (7) Save Database                            #");
		System.out.println("# (8) Load Database                            #");
		System.out.println("# (9) About this Project                       #");
		System.out.println("# (10) Quit                                    #");
		System.out.println("################################################");
		System.out.println("Select an option [1-10]>");
	}
}