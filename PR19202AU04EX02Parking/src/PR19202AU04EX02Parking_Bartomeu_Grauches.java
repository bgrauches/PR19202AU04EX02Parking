import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PR19202AU04EX02Parking_Bartomeu_Grauches {
	static Scanner escriu = new Scanner(System.in);
	static ArrayList<String> llista_matricules = new ArrayList<String>();
	static ArrayList<String> plases_noDiscp = new ArrayList<String>();
	static ArrayList<String> plases_discapacitats = new ArrayList<String>();
	
	//numero de plaçes de discapacitats, no_discapacitats i total
	int pcar;
	int pdis;
	int plases = pcar + pdis;
 
	
	

	public PR19202AU04EX02Parking_Bartomeu_Grauches(int places_no_discapacitats, int places_discapacitats) { // En teoria ha de ser public Parking només
		this.pcar = places_no_discapacitats;
		this.pdis = places_discapacitats;
	}
	
	//Introudim el path de l'arxiu per teclat i els String del document se guarden a l'arrayList matricules
	public void llegirMatricules(String path) throws Exception{
		
		System.out.println("Escriu el path del txt de les matricules");
		String filePathRead = escriu.next();
		
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(filePathRead));	//ARRAY DE MATRICULES? O SE PODEN GUARDAR DIRECTAMENT A guardarMatricules?
			String linia;
			//Mentres hi hagi linies, afegeix linies
			while ((linia=bf.readLine()) != null) {
				if(comporovarMatricula(linia)==false) {
					System.out.println("ALERTA =====> Matrícula " + linia + "incorrecte.");
				}
				llista_matricules.add(linia);
			}
			bf.close();
		} catch (Exception e) {
			System.out.println("ALERTA =====> Fitxer incorrecte o inexistent.");
		}
		
	}
	
	//metode per comprovar si matricula es vàlida corresponent al patró [0-9]{4}[A-Z]{3}
	public static boolean comporovarMatricula(String matricula) {
		boolean matriculaOK = matricula.matches("[0-9]{4}[A-Z]{3}");
		return matriculaOK;
		
	}
	
	public int entraCotxe(String matricula) throws Exception{ //afegeix 1 cotxe a les places
		int a = 0;
		boolean matriculaOK = comporovarMatricula(matricula);
		
		try {
			if(matriculaOK == true) {
				if(llista_matricules.contains(matricula)) {
					System.out.println("El cotxe ja està al parking, no pot entrar.");
				} else if(llista_matricules.contains(matricula)==false) {
					plases_noDiscp.add(matricula);
					System.out.println("El cotxe amb matricula " + matricula + " ha entrat al parking.");
				}
			} else {
				System.out.println("ALERTA =====> Matrícula " + matricula + "incorrecte.");
			}
		} catch (Exception w){
			System.out.println("ALERTA =====> Parking per no discapacitats ple.");
		}
		return a;
		
	}
																												//RETURN PARKING?
	public int entraCotxeDiscapacitat(String matricula) throws Exception{
		int b = 0;
		boolean matriculaOK = comporovarMatricula(matricula);
		
		try {
			if(matriculaOK == true) {
				if(llista_matricules.contains(matricula)) {
					System.out.println("El cotxe ja està al parking, no pot entrar.");
				} else if(llista_matricules.contains(matricula)==false) {
					plases_discapacitats.add(matricula);
					System.out.println("El cotxe amb matricula " + matricula + " ha entrat al parking.");
				}
			} else {
				System.out.println("ALERTA =====> Matrícula " + matricula + "incorrecte.");
			}
		} catch (Exception w){
			System.out.println("ALERTA =====> Parking per discapacitats ple.");
		}
		return b;
		
	}
	
	public void surtCotxe(String matricula) throws Exception{	//lleva 1 cotxe a les places

		boolean matriculaOK = comporovarMatricula(matricula);
		
		try {
			if(matriculaOK == true) {
				if(llista_matricules.contains(matricula)) {
					plases_discapacitats.remove(matricula);
					System.out.println("El cotxe amb matricula " + matricula + " ha sortit del parking.");
					
				} else if(llista_matricules.contains(matricula)==false) {
					System.out.println("El cotxe no és al parking.");
				}
			} else {
				System.out.println("ALERTA =====> Matrícula " + matricula + "incorrecte.");
			}
		} catch (Exception w){
			System.out.println("ALERTA =====> Parking per discapacitats ple.");
		}
		return;
	}
	
	public void surtCotxeDiscapacitats(String matricula) throws Exception{	//lleva 1 cotxe a les places disc
		
		boolean matriculaOK = comporovarMatricula(matricula);
		
		try {
			if(matriculaOK == true) {
				if(llista_matricules.contains(matricula)) {
					plases_noDiscp.remove(matricula);
					System.out.println("El cotxe amb matricula " + matricula + " ha sortit del parking.");
					
				} else if(llista_matricules.contains(matricula)==false) {
					System.out.println("El cotxe no és al parking.");
				}
			} else {
				System.out.println("ALERTA =====> Matrícula " + matricula + "incorrecte.");
			}
		} catch (Exception w){
			System.out.println("ALERTA =====> Parking per discapacitats ple.");
		}
		return;
	}
	
	
	enum TipusPlacesParking {
		Discapacitat,
		No_Discapacitat
	}
	public int getPlacesOcupades(TipusPlacesParking tipus) {
		return plases;
	}															//NOSE SI EL RETURN ESTÁ BÉ
	
	public int getPlacesLliures(TipusPlacesParking tipus) {
		return plases;
	}
	
	public void guardarMatricules(String path) throws Exception{
		System.out.println("Escriu el path del txt on guardam les matricules");
		String filePathWrite = escriu.next();
		try {  
		    BufferedWriter bw = new BufferedWriter(new FileWriter(filePathWrite)); 
			
			for (int i = 0; i < llista_matricules.size() ; i++) {
				bw.write(llista_matricules.get(i) + "\n");
			}
			bw.close();
		} catch (Exception f) {
			System.out.println("No s'ha pogut escriure al fitxer especificat.");
		}
	}
}