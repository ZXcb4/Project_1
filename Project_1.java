import java.util.*;
public class Project_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice;
		String name = null;
		String name_e;
		String id = null;
		int courses = 0;
		String fix;
		int j;
		List<Integer> mark = new ArrayList<>();
		float avg = 0;
		String p_f;
		String m_m;
		for(int i=0 ; i != 1;) {
			System.out.print("Menu: \r\n"
					+ "1. Enter Student Details \r\n"
					+ "2. Enter Marks \r\n"
					+ "3. Display Marks Info. \r\n"
					+ "4. Display Student Details \r\n"
					+ "5. Exit \r\n"
					+ "Enter your choice: ");
			choice = input.nextInt();
			System.out.println("");
			fix = input.nextLine();
			if (choice == 1){
				System.out.println("Enter Student Name: ");
				name_e = input.nextLine().trim();
				name =name_e.substring(0,1).toUpperCase();
				for (j = 1; j < name_e.length();j++) {
					if (name_e.charAt(j-1) == ' ' ) {
						name = name + name_e.substring(j,j+1).toUpperCase();
					}
					else {
						name = name + name_e.substring(j,j+1);
					}
				}
				for (j = 0; j !=1;) {
					j=1;
					System.out.println("Enter ID Number: ");
					id = input.nextLine();
					if (id.charAt(0) != '4') {
						System.out.println("id must start with 4.\n");
						j--;
					}
					if (id.length() != 9) {
						System.out.println("The id must consist of 9 digits.\n");
						j--;
					}
				}
				for(j = 0; j != 1;) {
					System.out.println("How many courses last semester?");
					courses = input.nextInt();
					if (courses > 5 || courses < 1)
						System.out.println("The number of courses is incorrect; it must be between 1 and 5.\n");
					else
						j = 1;
				}
			}
			else if(choice == 2) {
				for (j=0;j<courses;) {
					int mark_e = input.nextInt();
					if (mark_e>=0 && mark_e<=100) {
						mark.add(mark_e);
						j++;
					}
					else {
						System.out.println("The mark must be between 100 and 0.");
					}
				}
				for(int m : mark) {
					avg = avg + m;
				}
				avg = avg / courses;
			}
			else if(choice == 4) {
				System.out.println("Name: " + name);
				System.out.println("KKU id: " + id);
				choice = 3;
			}
			if (choice == 3) {
				System.out.print("Course   Mark   "
						+ "  P/F      "
						+ "Avg: " + avg + " \r\n"
						+ "==================================== \r\n");
				j = 1;
				for(int m : mark) {
					if(m ==  Collections.max(mark)){
						m_m = "Max";
					}
					else if (m ==  Collections.min(mark)){
						m_m = "Min";
					}
					else {
						m_m = "--";
					}
					if(m >= 60) {
						p_f = "Pass";
					}
					else {
						p_f = "Fail";
					}
					System.out.println(j + "         " + m + "      " + p_f + "        " + m_m);
					j++;
				}
				System.out.println("\n");
			}
			else if(choice == 5)
				i++;			
		}
		input.close();
	}
}
