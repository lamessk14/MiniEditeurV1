package command;
import java.util.*;
import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */

public class Couper implements Command {

	//D�claration de variables
		private MoteurEditeurImplem moteur;

	    /**
	     * Constructeur
	     */
	    public Couper(MoteurEditeurImplem moteur1) {
	    	moteur = moteur1;
	    }

	    /**
	     * Ex�cution de la fonction couper dans l'objet moteur
	     */
	    @Override
	    public void execute() {
	        moteur.couper();
	    }

}