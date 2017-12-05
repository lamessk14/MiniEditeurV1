package receiver;

import java.util.ArrayList;

import observer.Observer;
import observer.Subject;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */
public class MoteurEditeurImplem extends Subject implements MoteurEditeur {
	
	/*
	 * Déclaration des variables
	 */
	private Buffer buffer;
	private Selection sel;
	private PressePapier pp;

	/**
	 * Default constructor
	 */
	public MoteurEditeurImplem() {
		buffer = new Buffer();
		sel = new Selection();
		pp = new PressePapier();
		setObservers(new ArrayList<Observer>());
	}
	/**
	 * 
	 * @return
	 * la longueur de la chaine de caractère contenue dans le buffer
	 */
	public String getTexte(){
		return buffer.getTexte(0, buffer.getLongueurTexte());
	}
	
	/**
	 * 
	 * @return
	 * le contenu du presse-papiers
	 */
	
	public String getPressePapierTexte(){
		return pp.getTexte();
	}
	
	/**
	 * 
	 * @return
	 * la position du début de la sélection
	 */
	public int getSelectionDebut(){
		return sel.getDebutSelection();
	}
	
	/**
	 * 
	 * @return
	 * la position de la fin de la sélection
	 */
	public int getSelectionFin(){
		return sel.getFinSelection();
	}
	
	@Override
	/**
	 * Permet d'effectuer une sélection
	 */
	public void selectionner(int debutSelection, int finSelection) {
		sel.setDebutSelection(debutSelection);
		sel.setFinSelection(finSelection);
	}

	@Override
	/**
	 * Permet de faire la copie d'une sélection
	 */
	public void copier() {
		if(sel.getLongueurSelection() > 0){
			pp.setTexte(buffer.getTexte(sel.getDebutSelection(), sel.getFinSelection()));
		}
	}

	@Override
	/**
	 * Permet de couper une sélection non vide. Le contenu du buffer est ainsi supprimé.
	 */
	public void couper() {
		if(sel.getLongueurSelection() > 0){
			pp.setTexte(buffer.getTexte(sel.getDebutSelection(), sel.getFinSelection()));
			buffer.delete(sel.getDebutSelection(), sel.getFinSelection());
			selectionner(sel.getDebutSelection(),sel.getDebutSelection());
			
			notifyObservers();
		}
	}

	@Override
	/**
	 * Permet de coller une sélection non vide. Le contenu du buffer est ainsi modifié.
	 */
	public void coller() {
		if(sel.getLongueurSelection() > 0){
			buffer.delete(sel.getDebutSelection(), sel.getFinSelection());
			selectionner(sel.getDebutSelection(), sel.getDebutSelection());
		}
		buffer.modifier(sel.getDebutSelection(), pp.getTexte());
		int select = sel.getDebutSelection() + pp.getLongueurSelection();
		selectionner(select, select);
		
		notifyObservers();
	}

	@Override
	/**
	 * @param : char t
	 * permet d'insérer un texte dans l'éditeur caractère par caractère
	 */
	public void insererTxt(char t) {
		if(sel.getLongueurSelection() > 0){
			buffer.delete(sel.getDebutSelection(), sel.getFinSelection());
			selectionner(sel.getDebutSelection(),sel.getDebutSelection());
		}
		buffer.modifier(sel.getDebutSelection(), Character.toString(t));
		selectionner(sel.getDebutSelection()+1,sel.getDebutSelection()+1);

		notifyObservers();
	}
	/**
	 * Permet de supprimer un chaine de caractères ou un caractère
	 */
	public void supprimer() {
		if(sel.getLongueurSelection() > 0){
			buffer.delete(sel.getDebutSelection(), sel.getFinSelection());
			selectionner(sel.getDebutSelection(), sel.getDebutSelection());
		} else if(sel.getDebutSelection() > 0){
			buffer.delete(sel.getDebutSelection()-1, sel.getDebutSelection());
			selectionner(sel.getDebutSelection()-1,sel.getDebutSelection()-1);
		}
		notifyObservers();
	}
	
	@Override
	/**
	 * Notification des observers
	 */
	public void notifyObservers() {
		for(Observer o : getObservers()){
			o.notifyMe();
		}
	}

	@Override
	/**
	 * Ajout d'un observer
	 */
	public void registerObserver(Observer o) {
		getObservers().add(o);
	}

	@Override
	/**
	 * Suppression d'un observer
	 */
	public void removeObserver(Observer o) {
		getObservers().remove(o);
	}

}