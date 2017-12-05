package receiver;

import java.util.*;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */
public class Selection {

	/**
	 * Déclaration des variables debut_selection et fin selection
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
	 * @return la position du début de la sélection
	 */
	public int getDebutSelection() {
		return debut_selection;
	}
/**
 * 
 * @return la position de la fin de la sélection
 */
	public int getFinSelection() {
		return fin_selection;
	}
	/**
	 * 
	 * @return la longueur d'une sélection
	 */
	public int getLongueurSelection(){
		return fin_selection-debut_selection ;
	}

	/**
	 * Permet de changer la position de début d'une sélection
	 * @param debut
	 */
	public void setDebutSelection(int debut) {
		debut_selection = debut;
	}

	/**
	 * Permet de changer la position de fin d'une sélection
	 * @param fin
	 */
	public void setFinSelection(int fin) {
		fin_selection = fin;
	}

}