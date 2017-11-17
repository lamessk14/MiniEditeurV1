package receiver;

import java.util.ArrayList;
import observer.Observer;
import observer.Subject;

/**
 * 
 */
public class MoteurEditeurImplem implements MoteurEditeur {
	
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
		//setObservers(new ArrayList<Observer>());
	}
	
	public String getTexte(){
		return buffer.getTexte(0, buffer.getLongueurTexte());
	}
	
	public String getPressePapierTexte(){
		return pp.getTexte();
	}
	
	public int getSelectionDebut(){
		return sel.getDebutSelection();
	}
	
	public int getSelectionFin(){
		return sel.getFinSelection();
	}
	
	@Override
	public void selectionner(int debutSelection, int finSelection) {
		sel.setDebutSelection(debutSelection);
		sel.setFinSelection(finSelection);
	}

	@Override
	public void copier() {
		if(sel.getLongueurSelection() > 0){
			pp.setTexte(buffer.getTexte(sel.getDebutSelection(), sel.getFinSelection()));
		}
	}

	@Override
	public void couper() {
		
		if(sel.getLongueurSelection() > 0){
			pp.setTexte(buffer.getTexte(sel.getDebutSelection(), sel.getFinSelection()));
			buffer.delete(sel.getDebutSelection(), sel.getFinSelection());
			selectionner(sel.getDebutSelection(),sel.getDebutSelection());
			
			notifyObservers();
		}
	}

	@Override
	public void coller() {
		if(_selection.getLongueur() > 0){
			_buffer.delete(_selection.getDebut(), _selection.getFin());
			selectionner(_selection.getDebut(),_selection.getDebut());
		}
		_buffer.insert(_selection.getDebut(), _pressePapier.getTexte());
		int select = _selection.getDebut() + _pressePapier.getLongueurTexte();
		selectionner(select, select);
		
		notifyObservers();
	}

	@Override
	public void insererTxt(char t) {
		if(_selection.getLongueur() > 0){
			_buffer.delete(_selection.getDebut(), _selection.getFin());
			selectionner(_selection.getDebut(),_selection.getDebut());
		}
		_buffer.insert(_selection.getDebut(), Character.toString(c));
		selectionner(_selection.getDebut()+1,_selection.getDebut()+1);

		notifyObservers();
	}

}