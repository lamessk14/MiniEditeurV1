package invoker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import command.Command;

/**
 * @author COULIBALY Fanta & Louise-Agnès MACKONGO 
 */

@SuppressWarnings("serial")
public class BoutonsCommand extends JButton {

	/**
	 * Déclaration des variables commande et nom(nom de la commande)
	 */
	private String nom;
	private Command commande;

	/**
	 * 
	 * @param nom1
	 * @param commande1
	 */
	public BoutonsCommand(String nom1, final Command commande1) {
			super(nom1);
			nom = nom1;
			commande = commande1;
			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					commande.execute();
				}
			});
		}

	/**
	 * 
	 * @return le nom d'une commande
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * 
	 * @return une commande(copier, coller, couper)
	 */
	public Command getCommand() {
		return commande;
	}

}
