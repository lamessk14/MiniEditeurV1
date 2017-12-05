package receiver;

import java.util.*;

import observer.Observer;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */

public interface MoteurEditeur {
/**
 * 
 * @param debutSelection
 * @param finSelection
 */
    public void selectionner(int debutSelection, int finSelection);

    public void copier();

    public void coller();

    public void couper();
/**
 * 
 * @param t
 */
    public void insererTxt(char t);
    
    public void supprimer();
}