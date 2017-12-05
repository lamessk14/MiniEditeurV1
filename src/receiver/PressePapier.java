package receiver;
import java.util.*;

/**
 * @author COULIBALY Fanta & Louise-Agn�s MACKONGO 
 */
public class PressePapier {

	/**
	 * D�claration de la variable texte qui contiendra un contenu copi� ou coup�
	 */
	private String texte;
    /**
     * Constructeur
     */
    public PressePapier() {
    	texte ="";
    }
    
    /**
     * @return une cha�ne de caract�res
     */
    public String getTexte(){
    	return texte;
    }
    
    /**
     * 
     * @return la longueur d'une cha�ne de caract�res contenue dans le presse-papiers
     */
    public int getLongueurSelection(){
    	return texte.length();
    }
    
   /**
    * Permet de modifier une chaine de caract�res contenue dans le presse-papiers
    * @param txt
    */
    public void setTexte(String txt){
    	texte = txt;
    }


}