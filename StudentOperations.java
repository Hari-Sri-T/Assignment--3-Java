//StudentOperations.java //Perform CRUD operations
import java.util.*;
class StudentOperations{
	ArrayList<Student> students; // <Student> refers to Student.java
	
	public StudentOperations(){
		this.students = new ArrayList<>();
	}
	
	public void addStudent(Student student){ //Adding Student
		students.add(student);
		System.out.println("Student Added");
	}
	
	public void displayStudents(){
		for (Student student : students){
			student.display();
		}
	}
	
	public void searchStudent(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Search by:\n1. PRN\n2. Name\n3. Position");
        int choice = Integer.parseInt(scan.nextLine());

        switch (choice) {
            case 1:
                System.out.println("Enter PRN to search: ");
                long prn = Long.parseLong(scan.nextLine());
                searchByPRN(prn);
                break;
            case 2:
                System.out.println("Enter Name to search: ");
                String name = scan.nextLine();
                searchByName(name);
                break;
            case 3:
                System.out.println("Enter Position (Index) to search: ");
                int pos = Integer.parseInt(scan.nextLine());
                searchByPosition(pos);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
	
	public void searchByPRN(long prn) {
        for (Student student : students) {
            if (student.getPRN() == prn) {
                System.out.println("Student Found:");
                student.display();
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }
	
	
	public void searchByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Student Found:");
                student.display();
                return;
            }
        }
        System.out.println("Student with Name " + name + " not found.");
    }
	
	public void searchByPosition(int pos) {
        if (pos >= 0 && pos < students.size()) {
            System.out.println("Student at Position " + pos + ":");
            students.get(pos).display();
        } else {
            System.out.println("Invalid Position! No student exists at index " + pos);
        }
    }
}
	
