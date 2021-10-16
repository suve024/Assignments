package week3.day1;

public class Students {
	
	public void getStudentInfo(int id) {
		System.out.println("Student ID: "+ id);
	}
	
	public void getStudentInfo(int id, String name) {
		System.out.println("Student ID: "+ id);
		System.out.println("Student Name: "+ name);
	}
	public void getStudentInfo(String email, String phonenumber) {
		System.out.println("Student Email: "+ email);
		System.out.println("Student PhoneNumber: "+ phonenumber);
	}

	public static void main(String[] args) {
		Students obj = new Students();
		obj.getStudentInfo(5);
		obj.getStudentInfo(2, "Thara");
		obj.getStudentInfo("thara@gmail.com", "98361768935");

	}

}
