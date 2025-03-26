import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Convertisseur extends JFrame implements ActionListener
{
	private JButton btEuros = new JButton ("Euros");
	private JButton btDevise = new JButton ("Dollars");
	private JButton btAC = new JButton ("AC");
	private JButton btApropos = new JButton ("Apropos");
	private JButton btTaux = new JButton ("Taux");
	private JButton btQuitter = new JButton ("Quitter");
	
	private JTextField txtMontant = new JTextField();
	
	private float taux= (float) 1.2;
	private String devise= "Dollars";
	
	//Les menus et les sous menus
	private JMenuBar uneBarre =new JMenuBar();
	private JMenu mnFichier = new JMenu("Fichier");
	private JMenu mnOperations= new JMenu("Operations");
	private JMenu mnAide = new JMenu("Aide");
	
	private JMenuItem itemEuros= new JMenuItem("Euros");
	private JMenuItem itemDevise= new JMenuItem("Devise");
	private JMenuItem itemAC= new JMenuItem("AC");
	private JMenuItem itemApropos= new JMenuItem("Apropos");
	private JMenuItem itemTaux= new JMenuItem("Taux");
	private JMenuItem itemQuitter= new JMenuItem("Quitter");
	
	public Convertisseur() {
		this.setTitle("Converstisseur 2A 2025");
		this.setBounds(100, 100, 500, 300);
		this.getContentPane().setBackground(Color.darkGray);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		
		//placements des objets
		this.btEuros.setBounds(40, 40, 100, 30);
		this.add(this.btEuros);
		
		this.txtMontant.setBounds(160, 40, 100, 30);
		this.add(this.txtMontant);
		
		this.btDevise.setBounds(280, 40, 100, 30);
		this.add(this.btDevise);
		
		this.btTaux.setBounds(40, 90, 100, 30);
		this.add(this.btTaux);
		
		this.btAC.setBounds(160, 90, 100, 30);
		this.add(this.btAC);
		
		this.btApropos.setBounds(280, 90, 100, 30);
		this.add(this.btApropos);
		
		this.btQuitter.setBounds(40, 130, 340, 30);
		this.add(this.btQuitter);
		
		//rendre les boutons ecoutables
		this.btEuros.addActionListener(this);
		this.btDevise.addActionListener(this);
		this.btAC.addActionListener(this);
		this.btApropos.addActionListener(this);
		this.btTaux.addActionListener(this);
		this.btQuitter.addActionListener(this);
		
		//Installer les menus
		this.mnFichier.add(this.itemQuitter);
		this.mnOperations.add(this.itemEuros);
		this.mnOperations.add(this.itemDevise);
		this.mnOperations.add(this.itemAC);
		this.mnOperations.add(this.itemTaux);
		this.mnAide.add(this.itemApropos);
		
		this.uneBarre.add(this.mnFichier);
		this.uneBarre.add(this.mnOperations);
		this.uneBarre.add(this.mnAide);
		
		this.setJMenuBar(this.uneBarre);
		
		//rendre lesitems ecoutables
		this.itemQuitter.addActionListener(this);
		this.itemAC.addActionListener(this);
		this.itemTaux.addActionListener(this);
		this.itemApropos.addActionListener(this);
		this.itemDevise.addActionListener(this);
		this.itemEuros.addActionListener(this);
		
		this.setVisible(true);
	}
	
	public static void main (String args[]) {
		Convertisseur unC = new Convertisseur();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== this.btQuitter || e.getSource()==this.itemQuitter){
			this.dispose(); //arret de l'application
		}
		else if (e.getSource()== this.btAC) {
			this.txtMontant.setText("");
		}
	
	else if (e.getSource()== this.btApropos || e.getSource()==this.itemApropos) {
		JOptionPane.showMessageDialog(this, "Application Convertisseur 2025\n"+
				"Réalisée par la classe 2A Slam\n" +
				"Tous droits réservés IRIS");
	}
	else if (e.getSource()== this.btEuros || e.getSource()==this.itemEuros) 
	{
		float mt = 0;
		try {
			mt= Float.parseFloat(this.txtMontant.getText());
			mt = mt * (float) 1.20;
			this.txtMontant.setText(""+mt);
		}
		catch(NumberFormatException exp) {
			JOptionPane.showMessageDialog(this, "Veuillez choisir un montant");
			
			this.txtMontant.setText("");
		}
	}
	else if (e.getSource()== this.btDevise || e.getSource()==this.itemDevise) 
	{
		float mt = 0;
		try {
			mt= Float.parseFloat(this.txtMontant.getText());
			mt = mt / (float) 1.20;
			this.txtMontant.setText(""+mt);
		}
		catch(NumberFormatException exp) {
			JOptionPane.showMessageDialog(this, "Veuillez choisir un montant");
			
			this.txtMontant.setText("");
		}
	}
	else if (e.getSource()== this.btTaux || e.getSource()==this.itemTaux) 
	{
		try {
			this.devise=JOptionPane.showInputDialog(this,"New Devise :");
			this.taux = Float.parseFloat(JOptionPane.showInputDialog(this, "New taux :"));
			this.btDevise.setText(this.devise);
		}
		catch(NumberFormatException exp) {
			JOptionPane.showMessageDialog(this, "Erreur de saisie");
			this.taux = (float) 1.20;
			this.devise= "Dollars";
		}
	}
		
	}
}
