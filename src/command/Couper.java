package command;
import java.util.*;
import receiver.MoteurEditeurImplem;

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
	     * 
	     */
	    @Override
	    public void execute() {
	        moteur.couper();
	    }

}