import java.util.ArrayList;
import java.util.Scanner;

public class PR19202AU04EX02ParkingTest_Bartomeu_Grauches {
	
	static Scanner scanner = new Scanner(System.in);
	static Scanner scanner2 = new Scanner(System.in);
	static ArrayList<PR19202AU04EX02Parking_Bartomeu_Grauches> plases = new ArrayList<>();
	
	
	private static int showMenu() {
		System.out.println("Benvingut al parking, triï una opció teclejant el número:\n");
		System.out.println("1 - Omplir parking a partir de fitxer");
		System.out.println("2 - Entrar Cotxe");
		System.out.println("3 - Entrar Cotxe Discapacitat");
		System.out.println("4 - Surtir Cotxe");
		System.out.println("5 - Surtir Cotxe Discapacitat");
		System.out.println("6 - Guardar llistat de matricules en fitxer");
		System.out.println("7 - Sortir");
		
		int youChoose = scanner.nextInt();
		return youChoose;
	}
	
	private static void menu(PR19202AU04EX02Parking_Bartomeu_Grauches objeto) {
		boolean Salir = false;
		while (Salir == false) {
			int opcion = showMenu();
			switch (opcion) {
			
				case 1:
					System.out.println("Escriu el path del txt de les matricules");
					String filePathRead = scanner2.nextLine();
					try {
						objeto.llegirMatricules(filePathRead);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;

				
				case 2:
					try {
						objeto.entraCotxe("");
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 3:
					try {
						objeto.entraCotxeDiscapacitat("");
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 4:
					try {
						objeto.surtCotxe("");
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 5:
					try {
						objeto.surtCotxeDiscapacitats("");
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
					
				case 6:
					try {
						objeto.guardarMatricules("");
					} catch (Exception e) {
						e.printStackTrace();
					}
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
	
	public static void main(String[] args) {
		PR19202AU04EX02Parking_Bartomeu_Grauches parking = new PR19202AU04EX02Parking_Bartomeu_Grauches(10,5);
		menu(parking);
		
		
		
	}

}