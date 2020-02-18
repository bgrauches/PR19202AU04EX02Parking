import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PR19202AU04EX02Parking_Bartomeu_Grauches {
	static Scanner escriu = new Scanner(System.in);
	static ArrayList<String> matricules = new ArrayList<String>();
	
	int Parking;
	private int getParking() {
		return Parking;
	}

	private void setParking(int parking) {
		Parking = parking;
	}

	public void Parking(int places_no_discapacitats, int places_discapacitats) { // En teoria ha de ser public Parking només
		places_no_discapacitats = 100;
		places_discapacitats = 20;
	}
	
	//Introudim el path de l'arxiu per teclat i els String del document se guarden a l'arrayList matricules
	public static void llegirMatricules(String path) throws Exception{
		
		System.out.println("Escriu el path del txt de les matricules");
		String filePathRead = escriu.next();
		
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(filePathRead));	//ARRAY DE MATRICULES? O SE PODEN GUARDAR DIRECTAMENT A guardarMatricules?
			String linia;
			//Mentres hi hagi linies, afegeix linies
			while ((linia=bf.readLine()) != null) {

				matricules.add(linia);
			}
			bf.close();
		} catch (Exception e) {
			System.out.println("No es troba el fitxer especificat.");
		}
		
	}
	
	public int entraCotxe(String matricula) throws Exception{ //afegeix 1 cotxe a les places
		return Parking;
	}
																												//RETURN PARKING?
	public int entraCotxeDiscapacitat(String matricula) throws Exception{ //afegeix 1 cotxe a les places disc
		return Parking;
	}
	
	public void surtCotxe(String matricula) throws Exception{	//lleva 1 cotxe a les places
		
	}
	
	public void surtCotxeDiscapacitats(String matricula) throws Exception{	//lleva 1 cotxe a les places disc
		
	}
	
	
	enum TipusPlacesParking {
		Discapacitat,
		No_Discapacitat
	}
	public int getPlacesOcupades(TipusPlacesParking tipus) {
		return Parking;
	}															//NOSE SI EL RETURN ESTÁ BÉ
	
	public int getPlacesLliures(TipusPlacesParking tipus) {
		return Parking;
	}
	
	public static void guardarMatricules(String path) throws Exception{
		System.out.println("Escriu el path del txt on guardam les matricules");
		String filePathWrite = escriu.next();
		try {  
		    BufferedWriter bw = new BufferedWriter(new FileWriter(filePathWrite)); 
			
			for (int i = 0; i < matricules.size() ; i++) {
				bw.write(matricules.get(i) + "\n");
			}
			bw.close();
		} catch (Exception f) {
			System.out.println("No s'ha pogut escriure al fitxer especificat.");
		}
	}
}
