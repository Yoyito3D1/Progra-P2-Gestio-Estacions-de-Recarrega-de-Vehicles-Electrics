package aplicacio;

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;
import dades.*;

public class UsaLlistaEstacionsVE {
	static Scanner teclat = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Indica el numero de linies a llegir del fitxer (maxim 418)");
		int numLinies = Integer.parseInt(teclat.nextLine());
		String[] dataset = llegirLiniesFitxer(numLinies);
		
		EstacioRecarregaVE aux;
		LlistaEstacionsRecarrega llistaEstacions = new LlistaEstacionsRecarrega(numLinies+1);

		for (int i = 0; i < dataset.length; i++) {
			System.out.println("Linia " + (i + 1) + " conte " + dataset[i]);
			//Separem els elements de la estacio en parts d'un String per a poder administrarlos millor.
			String[] separacio = dataset[i].split(";");
			//Crearem una variable auxiliar per a cada estacio per a poder afegirla a la nostra llista.
			aux = new EstacioRecarregaVE(separacio[0], separacio[1], Float.parseFloat(separacio[2].replaceAll(",", ".")), Float.parseFloat(separacio[3].replaceAll(",", ".")), separacio[4], separacio[5], Integer.parseInt(separacio[6]));
			llistaEstacions.afegirNou(aux);
		}
		
		// Menu Principal
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Sisplau introdueix una de les següents opcions: ");
		System.out.println("1. Eliminar el conjunt d’estacions de recarrega que son d’una poblacio. El nom de la poblacio a eliminar es llegira de teclat. Per comprovar el bon funcionament, mostrar abans d’eliminar les estacions de la poblacio i el mateix despres de fer l’eliminacio per comprovar que ja no n’hi ha cap.");
		System.out.println("2. Trobar i mostrar la instancia de la primera estacio que hi ha a la llista que es troba ubicada a la provincia de Lleida. Fer el mateix per a l’estacio de la provincia de Barcelona. I dir quina es mes propera a la nostra posicio.");
		System.out.println("3. Mostrar el numero d’estacions que disposen de punts de recarrega d’un tipus de velocitat. El tipus de velocitat es llegira de teclat.");
		System.out.println("4. Mostrar la instancia de l’estacio que te mes places de capacitat. Si no tenim cap estacio, retornem el valor null.");
		System.out.println("5. Mostrar la instancia de l’estacio que esta mes propera a la nostra posicio. La latitud i longitud que indiquen la nostra posicio es llegira de teclat.");
		System.out.println("6. Mostrar les dades de les estacions que es troben properes a la nostra posicio (en un radi de 30km). La latitud i longitud que indiquen la nostra posicio es llegira de teclat.");
		System.out.println("7. Amplia el valor de distancia propera a 50 km i torna a calcular les estacions properes");
		System.out.println("8. Del resultat de les estacions properes mostra les dades de l’estacio que te mes places de capacitat");
		System.out.println("9. Mostrar el conjunt d’estacions de la llista.");
		System.out.println("10. Sortir del programa.");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		Scanner opcions = new Scanner(System.in);
		System.out.println("Introdueixi una opcio de l'1 al 10:");
		int eleccio = opcions.nextInt();
		
		while (eleccio != 10) {

		    if (eleccio < 1 || eleccio > 10) {
		        System.out.println("Introdueixi una opcio de l'1 al 10");
		        eleccio = opcions.nextInt();
		    }

		    else if(eleccio == 1) {
		        opcio1(llistaEstacions);
		        eleccio = 0;
		    }
		    
		    else if(eleccio == 2) {
		    	opcio2(llistaEstacions);
		    	eleccio = 0;
		    }
		    
		    else if(eleccio == 3) {
		        opcio3(llistaEstacions);
		        eleccio = 0;
		    }
		    
		    else if(eleccio == 4) {
		        opcio4(llistaEstacions);
		        eleccio = 0; 
		    }
		    
		    else if(eleccio == 5) {
		        opcio5(llistaEstacions);
		        eleccio = 0;
		    }
		    
		    else if(eleccio == 6) {
		        opcio6(llistaEstacions);
		        eleccio = 0;
		    }
		    
		    else if(eleccio == 7) {
		    	opcio7(llistaEstacions);
		    	eleccio = 0;
		    }
		    
		    else if(eleccio == 8) {
		    	opcio8(llistaEstacions);
		    	eleccio = 0;
		    }
		    
		    else if(eleccio == 9) {
		    	opcio9(llistaEstacions);
		    	eleccio = 0;
		    }
		}
		System.out.println("Gracies per utilitzar el nostre programa!");
		opcions.close();
	}

	private static String[] llegirLiniesFitxer(int nLinies) throws FileNotFoundException {
		
		if (nLinies < 0) nLinies = 0;
		if (nLinies > 418) nLinies = 418;
		String[] result = new String[nLinies];
		Scanner f = new Scanner(new File("EstacionsRecarregaReduit.csv"));

		String capcalera = f.nextLine();
		System.out.println("El format de les dades en cada linia es el següent\n" + capcalera);
		for (int i = 0; i < nLinies; i++) {
			result[i] = f.nextLine();
		}
		f.close();
		return result;
	}
	
	/**
	 * Eliminar el conjunt d’estacions de recarrega que son d’una poblacio. El nom de la poblacio a
	 * eliminar es llegira de teclat. Per comprovar el bon funcionament, mostrar abans d’eliminar les
	 * estacions de la poblacio i el mateix despres de fer l’eliminacio per comprovar que ja no n’hi ha
	 * cap.
	 * 
	 * @param llista
	 */
	private static void opcio1(LlistaEstacionsRecarrega llista) {
		System.out.println("Introdueixi la poblacio: ");
        String poblacio = teclat.nextLine();
		System.out.println("Llista d'estacions inicials: "+ llista.numElem());
        llista.eliminaPerPoblacio(poblacio);
        System.out.println("Nova llista d'estacions despres d'eleminar per poblacio: " + llista.numElem());
	}
	
	/**
	 * Trobar i mostrar la instancia de la primera estacio que hi ha a la llista que es troba ubicada a
	 * la provincia de Lleida. Fer el mateix per a l’estacio de la provincia de Barcelona. I dir quina es
	 * mes propera a la nostra posicio.
	 * 
	 * @param llista
	 */
	private static void opcio2(LlistaEstacionsRecarrega llista) {
		System.out.println("La 1a estacio de lleida es: "+llista.primerEstacioPerProvincia("Lleida"));
		System.out.println("La 1a estacio de Barcelona es: "+llista.primerEstacioPerProvincia("Barcelona"));
		System.out.println("Sisplau introdueixi la latitud: ");
		float latitut = teclat.nextFloat();
		System.out.println("Sisplau introdueixi la longitud: ");
		float longitud = teclat.nextFloat();
		if(llista.primerEstacioPerProvincia("Lleida").distanciaA(latitut, longitud) < llista.primerEstacioPerProvincia("Barcelona").distanciaA(latitut, longitud)) System.out.println("L'estacio mes propera a la nostra posicio es la de Lleida "+ llista.primerEstacioPerProvincia("Lleida"));
		else System.out.println("L'estacio mes propera a la nostra posicio es la de Barcelona "+ llista.primerEstacioPerProvincia("Barcelona"));
	}
	
	/**
	 * Mostrar el numero d’estacions que disposen de punts de recarrega d’un tipus de velocitat. El
	 * tipus de velocitat es llegira de teclat
	 * 
	 * @param llista
	 */
	private static void opcio3(LlistaEstacionsRecarrega llista) {
		System.out.println("Introdueixi un tipus de velocitat: ");
		String tipusVelocitat = teclat.nextLine();
		System.out.println("Hi ha un total de "+ llista.numeroEstacionsPerVelocitat(tipusVelocitat)+ " estacions amb aquest tipus de velocitat.");
	}
	
	/**
	 * Mostrar la instancia de l’estacio que te mes places de capacitat. Si no tenim cap estacio,
	 * retornem el valor null
	 * 
	 * @param llista
	 */
	private static void opcio4(LlistaEstacionsRecarrega llista) {
		System.out.println("L'estacio que te mes capacitat es: "+ llista.maximNumNPlaces());
	}
	
	/**
	 * Mostrar la instancia de l’estacio que esta mes propera a la nostra posicio. La latitud i longitud
	 * que indiquen la nostra posicio es llegira de teclat.
	 * 
	 * @param llista
	 */
	private static void opcio5(LlistaEstacionsRecarrega llista) {
		System.out.println("Sisplau introdueixi la latitud: ");
		float latitut = teclat.nextFloat();
		System.out.println("Sisplau introdueixi la longitud: ");
		float longitud = teclat.nextFloat();
		
		System.out.println("L'estacio mes propera es: " + llista.estacioMesPropera(latitut, longitud));
	}
	
	/**
	 * Mostrar les dades de les estacions que es troben properes a la nostra posicio (en un radi de 30
	 * km). La latitud i longitud que indiquen la nostra posicio es llegira de teclat.
	 * 
	 * @param llista
	 */
	private static void opcio6(LlistaEstacionsRecarrega llista) {
		System.out.println("Sisplau introdueixi la latitud: ");
		float latitut = teclat.nextFloat();
		System.out.println("Sisplau introdueixi la longitud: ");
		float longitud = teclat.nextFloat();
		
		LlistaEstacionsRecarrega aProp = llista.estacionsProperes(latitut, longitud);
		System.out.println("Les estacions que es troben properes a la nostra posicio son: "+ aProp.toString());
		System.out.println("Hi ha un total de: " + aProp.numElem() + " estacions a prop.");
	}
	
	/**
	 * Amplia el valor de distancia propera a 50 km i torna a calcular les estacions properes
	 * 
	 * @param llista
	 */
	private static void opcio7(LlistaEstacionsRecarrega llista) {
		LlistaEstacionsRecarrega.setDistanciaPropera(50.0);
		opcio6(llista);
	}

	/**
	 * Del resultat de les estacions properes mostra les dades de l’estacio que te mes places de capacitat
	 * 
	 * @param llista
	 */
	private static void opcio8(LlistaEstacionsRecarrega llista) {
		System.out.println("Sisplau introdueixi una distancia en km que cosideri propera: ");
		LlistaEstacionsRecarrega.setDistanciaPropera(teclat.nextDouble());
		
		System.out.println("Sisplau introdueixi la latitud: ");
		float latitut = teclat.nextFloat();
		System.out.println("Sisplau introdueixi la longitud: ");
		float longitud = teclat.nextFloat();
		
		LlistaEstacionsRecarrega aProp = llista.estacionsProperes(latitut, longitud);
		
		System.out.println(aProp.maximNumNPlaces());
	}
	
	/**
	 * Metode que retorna la llista en questio mitjançant el metode toString.
	 * 
	 * @param llista
	 */
	private static void opcio9(LlistaEstacionsRecarrega llista) {
		System.out.println(llista.toString());
	}
}