package receiver;
import java.util.*;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */
public class PressePapier {

	/**
	 * Déclaration de la variable texte qui contiendra un contenu copié ou coupé
	 */
	private String texte;
    /**
     * Constructeur
     */
    public PressePapier() {
    	texte ="";
    }
    
    /**
     * @return une chaîne de caractères
     */
    public String getTexte(){
    	return texte;
    }
    
    /**
     * 
     * @return la longueur d'une chaîne de caractères contenue dans le presse-papiers
     */
    public int getLongueurSelection(){
    	return texte.length();
    }
    
   /**
    * Permet de modifier une chaine de caractères contenue dans le presse-papiers
    * @param txt
    */
    public void setTexte(String txt){
    	texte = txt;
    }


}