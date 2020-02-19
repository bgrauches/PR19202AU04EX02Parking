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
	int pcar = plases_noDiscp.size();
	int pdis = plases_discapacitats.size();
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
			BufferedReader bf = new BufferedReader(new FileReader(filePathRead));	
			String linia;
			//Mentres hi hagi linies, afegeix linies
			while ((linia=bf.readLine()) != null) {
				if(comporovarMatricula(linia)==false) {
					System.out.println("ALERTA =====> Matrícula " + linia + "incorrecte.");
				}
				llista_matricules.add(linia);
				System.out.println(llista_matricules); 							//PER COMPROVAR MEM SI LES GUARDA---------------------------------------------------------------------------------
			}
			bf.close();
		} catch (Exception e) {
			System.out.println("ALERTA =====> Fitxer incorrecte o inexistent.");
		}
		
	}
	
	//metode per comprovar si matricula donada per teclat es vàlida corresponent al patró [0-9]{4}[A-Z]{3}
	private static boolean comporovarMatricula(String matricula) {
		boolean matriculaOK = matricula.matches("[0-9]{4}[A-Z]{3}");
		return matriculaOK;
		
	}
	
	public int entraCotxe(String matricula) throws Exception{ //afegeix 1 cotxe a les places
		int a = 0;
		System.out.println("Escrigui la matricula del cotxe: ");
		String m = escriu.next();
		boolean matriculaOK = comporovarMatricula(m);
		
		try {
			if(matriculaOK == true) {
				if(llista_matricules.contains(matricula)) {
					System.out.println("El cotxe ja està al parking, no pot entrar.");
				} else if(llista_matricules.contains(matricula)==false) {
					llista_matricules.add(matricula);
					plases_noDiscp.add(matricula);
					this.tipusPlaces = TipusPlacesParking.No_Discapacitat;
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
		System.out.println("Escrigui la matricula del cotxe: ");
		String m = escriu.next();
		boolean matriculaOK = comporovarMatricula(m);
		
		try {
			if(matriculaOK == true) {
				if(llista_matricules.contains(matricula)) {
					System.out.println("El cotxe ja està al parking, no pot entrar.");
				} else if(llista_matricules.contains(matricula)==false) {
					llista_matricules.add(matricula);
					plases_discapacitats.add(matricula);
					this.tipusPlaces = TipusPlacesParking.Discapacitat;
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

		System.out.println("Escrigui la matricula del cotxe: ");
		String m = escriu.next();
		boolean matriculaOK = comporovarMatricula(m);
		
		try {
			if(matriculaOK == true) {
				if(llista_matricules.contains(matricula)) {
					System.out.println("El cotxe amb matricula " + matricula + " ha sortit del parking.");
					plases_noDiscp.remove(matricula);
					
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
		
		System.out.println("Escrigui la matricula del cotxe: ");
		String m = escriu.next();
		boolean matriculaOK = comporovarMatricula(m);
		
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
	
	
	enum TipusPlacesParking {	//Declaram els 2 tipus de plaçes que pot haver al parking
		Discapacitat,
		No_Discapacitat
	}
	protected TipusPlacesParking tipusPlaces;
	private TipusPlacesParking getTipusPlaces() {
		return tipusPlaces;
	}
	private void setTipusPlaces(TipusPlacesParking tipusPlaces) {
		this.tipusPlaces = tipusPlaces;
	}
	public int getPlacesOcupades(TipusPlacesParking tipus) {
		return plases;
	}															
	
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
				System.out.println("-------------Matricules--guardades--correctament-----------");
			}
			bw.close();
		} catch (Exception f) {
			System.out.println("No s'ha pogut escriure al fitxer especificat.");
		}
	}
}