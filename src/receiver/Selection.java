package receiver;

import java.util.*;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */
public class Selection {

	/**
	 * D�claration des variables debut_selection et fin selection
	 */
	private int debut_selection;
	private int fin_selection;

	/**
	 * Constructeur
	 */
	public Selection() {
		debut_selection = 0;
		fin_selection = 0;
	}

	/**
	 * 
	 * @return la position du d�but de la s�lection
	 */
	public int getDebutSelection() {
		return debut_selection;
	}
/**
 * 
 * @return la position de la fin de la s�lection
 */
	public int getFinSelection() {
		return fin_selection;
	}
	/**
	 * 
	 * @return la longueur d'une s�lection
	 */
	public int getLongueurSelection(){
		return fin_selection-debut_selection ;
	}

	/**
	 * Permet de changer la position de d�but d'une s�lection
	 * @param debut
	 */
	public void setDebutSelection(int debut) {
		debut_selection = debut;
	}

	/**
	 * Permet de changer la position de fin d'une s�lection
	 * @param fin
	 */
	public void setFinSelection(int fin) {
		fin_selection = fin;
	}

}