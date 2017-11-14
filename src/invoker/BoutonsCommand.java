package invoker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import command.Command;

@SuppressWarnings("serial")
public class BoutonsCommand extends JButton {

	private String nom;
	private Command commande;

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

	public String getNom() {
		return nom;
	}

	public Command getCommand() {
		return commande;
	}

}