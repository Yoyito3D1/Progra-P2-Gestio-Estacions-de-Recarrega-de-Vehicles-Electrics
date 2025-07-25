package dades;

public class LlistaEstacionsRecarrega {

	// Definim les varibles

	private int nElem;
	private EstacioRecarregaVE[] llista;
	public static double distanciaPropera = 30.0;

	/*
	 * Creem el constructor
	 * 
	 * @param i
	 */
	public LlistaEstacionsRecarrega(int i) {
		nElem = 0;
		llista = new EstacioRecarregaVE[i];

	}

	/*
	 * Funcio per afegir una nova estacio a la llista
	 * 
	 * @param p
	 */
	public void afegirNou(EstacioRecarregaVE p) {
		if (nElem < llista.length) {
			llista[nElem] = p.copia();
			nElem++;
		}
	}

	/*
	 * Funcio que elimina les estacions d'una certa poblacio
	 * 
	 * @param municipi
	 */

	public void eliminaPerPoblacio(String municipi) {
		for (int i = 0; i < nElem; i++) {
			if (llista[i].esTrobaEnAquestMunicipi(municipi)) {
				for (int pos = i; pos < nElem; pos++)
					llista[pos] = llista[pos + 1];
				nElem--; // !!!!!!!!!!!Per que serveix
			} else
				i++;
		}
	}

	/*
	 * Funcio que ens retorna una llista que conte totes les estacions d'un municipi
	 * 
	 * @param municipi
	 * 
	 * @return aux
	 */

	public LlistaEstacionsRecarrega estacionsPerPoblacio(String municipi) {
		LlistaEstacionsRecarrega aux = new LlistaEstacionsRecarrega(nElem);
		for (int i = 0; i < nElem; i++) {
			if (llista[i].getMunicipi().equalsIgnoreCase(municipi)) {
				aux.afegirNou(llista[i]);// !!!Ensenyar meu
			}
		}
		return aux;
	}

	/*
	 * Funcio que ens retorna la 1a estacio d'una provincia 
	 * 
	 * @param provincia
	 * 
	 * @return llista[i]
	 */

	public EstacioRecarregaVE primerEstacioPerProvincia(String provincia) {
		boolean sortir = false;
		int i = 0;
		while (i < nElem && !sortir) {
			if (llista[i].getProvincia().equals(provincia)) {
				sortir = true;
			} else
				i++;
		}
		return llista[i];
	}

	/*
	 * Funcio que retorna el numero d’estacions que disposen de punts de recarrega
	 * d’un tipus de velocitat. El tipus de velocitat es rep per parametre.
	 * 
	 * @param tipusVelocitat
	 * 
	 * @return vegades
	 */

	public int numeroEstacionsPerVelocitat(String tipusVelocitat) {
		int vegades = 0;
		for (int i = 0; i < nElem; i++) {
			if (llista[i].teAquestTipusRecarrega(tipusVelocitat))
				vegades++;
		}
		return vegades;
	}

	/*
	 * Funcio que retorna la instancia de l’estacio que te mes places de capacitat.
	 * 
	 * 
	 * @return aux
	 */

	public EstacioRecarregaVE maximNumNPlaces() {
		if (nElem == 0)
			return null;
		int maxim = 0;
		EstacioRecarregaVE aux = llista[0].copia();
		for (int i = 0; i < nElem; i++) {
			if (llista[i].getNumPlaces() > maxim) {
				maxim = llista[i].getNumPlaces();
				aux = llista[i].copia();// !!!!!!!!!!!El
			}
		}
		return aux;
	}

	/*
	 * Funcio que retorna un duplicat de la instancia de l’estacio que esta mes
	 * propera a la nostra posicio.
	 * 
	 * @param lat, lon
	 * 
	 * @return llista[indexmin]
	 */

	public EstacioRecarregaVE estacioMesPropera(float lat, float lon) {

		int indexmin = 0;
		double menysDistancia = Integer.MAX_VALUE;

		for (int i = 0; i < nElem; i++) {
			if (llista[i].distanciaA(lat, lon) < menysDistancia) {
				menysDistancia = llista[i].distanciaA(lat, lon);
				indexmin = i;
			}
		}
		return llista[indexmin];
	}
	/*
	 * El metode crea i retorna una llista amb les estacions que es consideren
	 * properes tenint en compte el valor indicat en el punt anterior a partir del
	 * valor d’una posicio que es rep per parametre
	 * 
	 * @param latitudActual, longitudActual
	 * 
	 * @return aux
	 * 
	 */

	public LlistaEstacionsRecarrega estacionsProperes(float latitudActual, float longitudActual) {
		LlistaEstacionsRecarrega aux = new LlistaEstacionsRecarrega(nElem);
		for (int i = 0; i < nElem; i++) {
			if ((llista[i].distanciaA(latitudActual, longitudActual)) <= distanciaPropera) {
				aux.afegirNou(llista[i]);
			}
		}
		return aux;
	}

	/* Funcio toString
	 * 
	 * 
	 * @param 
	 * 
	 * @return text
	 */

	public String toString() {
		String text = "";
		for (int i = 0; i < nElem; i++) {
			text = text + llista[i] + "\n";
		}
		return text;
	}

   	/* Funcio que retorna el numero d'elements de la llista
	 * 
	 * 
	 * @param 
	 * @return nElem
	 */

	public int numElem() {
		return nElem;
	}

	/*Funcio que canvia la distancia minima
	 * 
	 * 
	 * @param canvi
	 */
	public static void canviDistanciaMin(double canvi) {
		distanciaPropera = canvi;
	}

	
	/* Funcio que canvia la distancia propera
	 * 
	 * 
	 * @param distanciapropera
	 */
	public static void setDistanciaPropera(double distanciaPropera) {
		LlistaEstacionsRecarrega.distanciaPropera = distanciaPropera;
	}
	
	

}