package addListDeleteUser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class App {

	public static void main(String[] args) throws IOException {
		
		menu();		 
	}

	private static void menu() throws IOException, NoSuchElementException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
		System.out.println();
		System.out.println(" Menu:");
		System.out.println("--------------------------");
		System.out.println("\t List users:   [1]");
		System.out.println("\t Add new user: [2]");
		System.out.println("\t Delete user:  [3]");
		System.out.println("\t Quit          [0]");
		System.out.println("--------------------------");
		System.out.print(" >> Your choice: ");
		
		String choice = br.readLine();
		
		switch(choice) {
		case "1":
			listUsers();
			break;
		case "2":
			addUser();
			break;
		case "3":
			deleteUser();
			break;
		case "0":
			appQuit();
			break;
		}
		}
	}

	private static void appQuit() {
		
		System.out.println();
		System.out.println(" Exiting...");
		System.exit(1);
	}

	private static void deleteUser() throws IOException {
		
		File file = new File("C:\\Users\\ASUS-TUF\\eclipse-workspace\\AddListDeleteUserFile\\src\\users");
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println();
		System.out.print(" Enter the user to delete: ");
		String s = br1.readLine();
		
		File tempFile = new File(file.getAbsolutePath() + ".tmp");
		BufferedReader br = new BufferedReader(new FileReader(file));
	    PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	    String userToDelete = s;
	    String currentUser;
	    while((currentUser = br.readLine()) != null) {
	    	String line = currentUser.trim();
	    	
	    	if(line.startsWith(userToDelete)) {
	    		String[] word = line.split(" ");
	    		System.out.print(" User '");
	    		System.out.print(word[0]);
	    		System.out.print("' was deleted");
	    		continue;
		}
		if((line.startsWith(userToDelete)) != true) {
		System.out.println();
	    	System.out.println(" Wrong type");
	    	System.out.println(" Please try again");
		}    
	    	pw.write(currentUser + "\n");
	    }
	    br.close();
	    pw.close();
	    file.delete();
	    tempFile.renameTo(file);    
	}

	private static void addUser() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println();
		System.out.print(" New user's name: ");
		String name = br.readLine();
		System.out.print(" New user's age: ");
		String age = br.readLine();
		
		File file = new File("C:\\Users\\ASUS-TUF\\eclipse-workspace\\AddListDeleteUserFile\\src\\users");
		FileWriter fw = new FileWriter(file, true);
		fw.write(name + " " + age + "\n");
		fw.close();
					
		System.out.println(" User '"+ name +"' was added");
	}

	private static void listUsers() throws IOException {
		
		System.out.println();
		System.out.println(" Users:");
		System.out.println("-------------------------");
		
		File file = new File("C:\\Users\\ASUS-TUF\\eclipse-workspace\\AddListDeleteUserFile\\src\\users");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		while(line != null) {
			System.out.println("\t " + line);
			line = br.readLine();
		}
		br.close();
	}
}


