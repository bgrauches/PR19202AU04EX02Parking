import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PR19202AU04EX02Parking_Bartomeu_Grauches {
	static Scanner escriu = new Scanner(System.in);
	static ArrayList<String> llista_matricules = new ArrayList<String>();
	static ArrayList<String> plases_noDiscp = new ArrayList<String>();
	static ArrayList<String> plases_discapacitats = new ArrayList<String>();
	
	//numero de pla�es de discapacitats, no_discapacitats i total
	static int pNoDisc = plases_noDiscp.size();
	static int pDisc = plases_discapacitats.size();
	static int plasesTotals  = pNoDisc + pDisc;
	
	//metode per comprovar si matricula donada es v�lida corresponent al patr� [0-9]{4}[A-Z]{3}.
	private static boolean comporovarMatricula(String matricula) {
			boolean matriculaOK = matricula.matches("[0-9]{4}[A-Z]{3}");
			try {
				if(matriculaOK == false) {
					throw new Exception();
				}
			}catch(Exception e) {
				System.out.println("ALERTA =====> Matr�cula " + matricula + " incorrecte.");
			}
			return matriculaOK;
	}
	
	//metode per ficar de manera random un cotxe normal a pla�a de discapacitat
	private static void enterGarrulo() throws Exception {
		int numR = (int)(Math.random()*2);
		if(numR == 0) {
			try {
				if(numR == 2) {
					throw new Exception();
				}
			}catch(Exception e) {
				System.out.println("ALERTA =====> Garrulo detected!!! Ha aparcat a la pla�a: " + llista_matricules.get(plasesTotals));
			}
		}
	}
	
	//m�tode per calcular quan se supera el 85% de les pla�es de no discapacitats i tambe per calcular quan fa ple
	private static void calcularPercentNoDiscp() throws Exception {
		int num_NoDisc = pNoDisc ; //Numero de pla�es donades per par�metre a la calsse Parking_Test
		int numcal = ((plases_noDiscp.size()*100)/num_NoDisc );
		try {
			if(numcal >= num_NoDisc ) {
				throw new Exception();
			}
		}catch(Exception e) {
			System.out.println("ALERTA =====> Ocupaci� de places per no discapacitats supera el 85%.");
		}
		try {
			if(plases_noDiscp.size() >= num_NoDisc ) {
				throw new Exception();
			}
		}catch(Exception e) {
			System.out.println("ALERTA =====> Parking per no discapacitats ple."); //enviar als cotxes a places normals
			}
		}
	
	//m�tode per calcular quan se supera el 85% de les pla�es de discapacitats i tambe per calcular quan fa ple
	private static void calcularPercentDiscp() throws Exception {
		int num_Disc = pDisc; //Numero de pla�es donades per par�metre a la calsse Parking_Test
		int numcal = ((plases_discapacitats.size()*100)/num_Disc);
		try {
			if(numcal >= num_Disc) {
				throw new Exception();
			}
		}catch(Exception e) {
			System.out.println("ALERTA =====> Ocupaci� de places per discapacitats supera el 85%.");
		}
		try {
			if(plases_discapacitats.size() >= num_Disc) {
				throw new Exception();
			}
		}catch(Exception e) {
			System.out.println("ALERTA =====> Parking per discapacitats ple. Ha ocupat pla�a normal num: " + llista_matricules.get(plasesTotals)); //enviar als cotxes a places normals
			}
		}
	
	
	public PR19202AU04EX02Parking_Bartomeu_Grauches(int places_no_discapacitats, int places_discapacitats) { // En teoria ha de ser public Parking nom�s
		this.pNoDisc = places_no_discapacitats;
		this.pDisc= places_discapacitats;
	}
	
	
	//m�tode on agafa el path de l'arxiu a llegir, comprova les maticules mijan�ant el m�tode comporovarMatricula i les afegeix a l'arrayList  llista_matricules
	public void llegirMatricules(String path) throws Exception{
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(path));	
			String linia;
			while ((linia=bf.readLine()) != null) {
				if(comporovarMatricula(linia)==false) {
					System.out.println("ALERTA =====> Matr�cula " + linia + " incorrecte.");
				}
				llista_matricules.add(linia);
				System.out.println(llista_matricules); 							//PER COMPROVAR MEM SI LES GUARDA---------------------------------------------------------------------------------
			}
			bf.close();
		} catch (Exception e) {
			throw new Exception("ALERTA =====> Fitxer incorrecte o inexistent.");
		}
		
	}
	
	//m�tode mitjan�ant entra un cotxe no_discapaciat entra al parking en cas de que la matricula sigui correcta
	public int entraCotxe(String matricula) throws Exception{
		int a = 0;
		System.out.println("Escrigui la matricula del cotxe per entrar: ");
		String m = escriu.nextLine();
		boolean matriculaOK = comporovarMatricula(m);	
		
		try {
			if(llista_matricules.contains(m) == false && matriculaOK == true) {
				llista_matricules.add(m);
				enterGarrulo();
				calcularPercentNoDiscp();
				this.tipusPlaces = TipusPlacesParking.No_Discapacitat;
			}
			else {
				throw new Exception();
			}
		}catch(Exception e) {
			System.out.println("El cotxe ja est� al parking, no pot entrar.");
		}
		
		return a;
		
	}

	//m�tode mitjan�ant entra un cotxe discapaciat entra al parking en cas de que la matricula sigui correcta	
	public int entraCotxeDiscapacitat(String matricula) throws Exception{
		int b = 0;
		System.out.println("Escrigui la matricula del cotxe per entrar: ");
		String m = escriu.nextLine();
		boolean matriculaOK = comporovarMatricula(m);
		
		try {
			if(llista_matricules.contains(m) == false && matriculaOK == true) {
				llista_matricules.add(m);
				calcularPercentDiscp();
				this.tipusPlaces = TipusPlacesParking.Discapacitat;
			}
			else {
				throw new Exception();
			}
		}catch(Exception e) {
			System.out.println("El cotxe ja est� al parking, no pot entrar.");
		}
		return b;
		
	}
	
	//metode on treurem un cotxe no_discapacitat del parking en cas que la matricula sigui correcta
	public void surtCotxe(String matricula) throws Exception{

		System.out.println("Escrigui la matricula del cotxe per sortir: ");
		String m = escriu.nextLine();
		boolean matriculaOK = comporovarMatricula(m);
		
		try {
			if(matriculaOK == true) {
				if(llista_matricules.contains(m)) {
					System.out.println("El cotxe amb matricula " + m + " ha sortit del parking.");
					llista_matricules.remove(llista_matricules.indexOf(m));
					plases_noDiscp.remove(plases_noDiscp.indexOf(m)); //amb llevam la matr�cula de la seva posici� a l'array
					calcularPercentNoDiscp();
					
				} else if(llista_matricules.contains(m)==false) {
					throw new Exception();
				}
			}
		} catch (Exception w){
			System.out.println("El cotxe no �s al parking.");
		}
		return;
	}
	
	//metode on treurem un cotxe discapacitat del parking en cas que la matricula sigui correcta
	public void surtCotxeDiscapacitats(String matricula) throws Exception{	
		
		System.out.println("Escrigui la matricula del cotxe per sortir: ");
		String m = escriu.nextLine();
		boolean matriculaOK = comporovarMatricula(m);
		
		try {
			if(matriculaOK == true) {
				if(llista_matricules.contains(m)) {
					System.out.println("El cotxe amb matricula " + m + " ha sortit del parking.");
					llista_matricules.remove(llista_matricules.indexOf(m));
					plases_discapacitats.remove(plases_discapacitats.indexOf(m)); //en llevam la matr�cula de la seva posici� a l'array
					calcularPercentDiscp();
					
				} else if(llista_matricules.contains(m)==false) {
					throw new Exception();
				}
			}
		} catch (Exception w){
			System.out.println("El cotxe no �s al parking.");
		}
		return;
	}
	
	
	enum TipusPlacesParking {	//Declaram els 2 tipus de pla�es que pot haver al parking
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
		return plasesTotals;
	}															
	
	public int getPlacesLliures(TipusPlacesParking tipus) {
		return plasesTotals;
	}
	
	//m�tode mitjan�ant el cual guardam els Strings de l'arraList llista_matricules a un fitxer txt definit per teclat
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
		} catch (IOException f) {
			throw new Exception("No s'ha pogut escriure al fitxer especificat.");
		}
	}
}