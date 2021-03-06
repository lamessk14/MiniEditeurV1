package command;
import java.util.*;
import receiver.MoteurEditeurImplem;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */

public class Coller implements Command {
	
	//D�claration de variables
	private MoteurEditeurImplem moteur;

    /**
     * Constructeur
     */
    public Coller(MoteurEditeurImplem moteur1) {
    	moteur = moteur1;
    }

    /**
     * Permet d'ex�cuter la commande coller
     */
    @Override
    public void execute() {
        moteur.coller();
    }

}