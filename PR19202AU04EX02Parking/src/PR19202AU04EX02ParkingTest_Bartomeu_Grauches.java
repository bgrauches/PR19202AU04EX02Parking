import java.util.ArrayList;
import java.util.Scanner;

public class PR19202AU04EX02ParkingTest_Bartomeu_Grauches {
	
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<PR19202AU04EX02Parking_Bartomeu_Grauches> plases = new ArrayList<>();
	PR19202AU04EX02Parking_Bartomeu_Grauches cls = new PR19202AU04EX02Parking_Bartomeu_Grauches();
	
	
	private static int showMenu() {
		System.out.println("Benvingut al parking, triï una opció teclejant el número:\n");
		System.out.println("1 - Omplir parking a partir de fitxer*");
		System.out.println("2 - Entrar Cotxe");
		System.out.println("3 - Entrar Cotxe Discapacitat");
		System.out.println("4 - Surtir Cotxe");
		System.out.println("5 - Surtir Cotxe Discapacitat");
		System.out.println("6 - Sortir");
		
		int youChoose = scanner.nextInt();
		return youChoose;
	}
	
	private static void menu() {
		boolean Salir = false;
		while (Salir == false) {
			int opcion = showMenu();
			switch (opcion) {
			
				case 1:
					System.out.println("Omplir parking a partir de fitxer*");
					break;
				
				case 2:
					System.out.println("Entrar Cotxe");
					break;
					
				case 3:
					System.out.println("Entrar Cotxe Discapacitat");
					break;
					
				case 4:
					System.out.println("Surtir Cotxe");
					break;
					
				case 5:
					System.out.println("Surtir Cotxe Discapacitat");
					break;
					
				case 6:
					System.out.println("Guardar llistat de matricules en fitxer*");
					break;
					
				case 7:
					System.out.println("Gracies, vagi bé.");
					Salir = true;
					break;
					
				default:
					System.out.println("Opcions disponibles 1, 2, 3, 4, 5, 6 i 7.");	
			}
		}
	}
	
	private static void omplirParking() {
		plases.add();
	}
	
	private static void entrarCotxe() {
		
	}
	
	

	public static void main(String[] args) {
		menu();
		
	}

}
