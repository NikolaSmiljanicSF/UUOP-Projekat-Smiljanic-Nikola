package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import CRUD.CRUDOperacije;
import model.Administrator;
import model.Musterija;
import model.Serviser;

public class GlavniProzorMusterija extends JFrame {
	
	private JMenuBar mainMenu = new JMenuBar();
	private JMenu automobilMenu= new JMenu("Automobil");
	private JMenuItem nekiItem = new JMenuItem("Neki"); 
	private JMenu servisneknjiziceMenu = new JMenu("servisne knjizice");
	private JMenuItem servoItem = new JMenuItem("servo");
	
	private CRUDOperacije crudoperacije;
	private Musterija prijavljeni;
	private Serviser prijavljeniServiser;
	private Administrator prijavljeniAdministrator;
	
	public GlavniProzorMusterija(CRUDOperacije crudoperacije, Musterija prijavljeni) {
		this.crudoperacije = crudoperacije;
		this.prijavljeni = prijavljeni;
		setTitle("Musterija: " + prijavljeni.getKorisnickoIme());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
	}
	
	private void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(automobilMenu);
		automobilMenu.add(nekiItem);
		mainMenu.add(servisneknjiziceMenu);
		servisneknjiziceMenu.add(servoItem);
	}
	
	private void initActions() {
		
	}
	
}