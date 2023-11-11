import java.util.Scanner;


public class ClimatePrint {
	
	
	public void printLoop() { 
		int listInt = -1;
		Scanner scan = new Scanner(System.in);
		
		while (listInt != 7) { // Loop until user enters  to exit
			
			System.out.println("[1] Calculate average temperature for a country according to temperature unit and year.");
			System.out.println("[2] Calculate average temperature for a city according to temperature unit and year.");
			System.out.println("[3] Calculate average wind speed for a city according to speed unit and year.");
			System.out.println("[4] Calculate average humidity of a city for every year.");
			System.out.println("[5] Count how many times a year a specific radiation intensity value appears for a city.");
			System.out.println("[6] Calculate the “felt temperature” value of a city for a specific month and year.");
			System.out.println("[7] Exit the application.");
			
			System.out.print("Please select an option: ");
			
			listInt = scan.nextInt();
			System.out.println();
			
			switch (listInt) {
			case 1:
				//average temperature for a country
				break;
			case 2:
				//average temperature for a city
				break;
			case 3:
				// average wind speed for a city
				break;
			case 4:
				//average humidity of a city
				break;
			case 5:
				//many times a year a specific radiation
				break;
			case 6:
				//“felt temperature” value of a city
				break;
			case 7:
				System.out.println("==> Closing the application...");
				break;
			default: // Unexpected input, loop the program again
				System.out.println("Incorrect option input! Please reenter another option input: ");
				listInt = scan.nextInt();
				
				break;
			}
		}
		scan.close(); // Close keyboard scanner
	}

}
