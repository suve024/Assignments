package week3.day2;

public class Desktop implements Software{

	public void hardwareResources() {
System.out.println("Hardware Resources");		
	}

	public void softwareResources() {
		System.out.println("Software Resources");		
	}
	public void desktopModel() {
		System.out.println("desktop Model");
	}
	public static void main(String[] args) {
		Desktop d = new Desktop();
		d.desktopModel();
		d.hardwareResources();
		d.softwareResources();
	}

	

}
