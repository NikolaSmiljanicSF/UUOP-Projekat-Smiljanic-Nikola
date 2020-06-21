package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import CRUD.CRUDOperacije;
import gui.formeZaDodavanjeIIzmenu.AdministratoriForma;
import gui.formeZaDodavanjeIIzmenu.ServisneKnjiziceForma;
import model.Administrator;
import model.Automobil;
import model.ServisnaKnjizica;

public class ProzorPrikazServisnihKnjizica extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	private DefaultTableModel tableModel;
	private JTable servisneKnjiziceTabela;

	CRUDOperacije Crudoperacije = new CRUDOperacije();
	private Automobil automobil;
	
	public ProzorPrikazServisnihKnjizica(CRUDOperacije Crudoperacije) {
		this.Crudoperacije = Crudoperacije;
		setTitle("Servisne knjizice");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		
	}
	
	public void initGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
		btnAdd.setIcon(addIcon);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
		btnEdit.setIcon(editIcon);
		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
		btnDelete.setIcon(deleteIcon);
		
		mainToolbar.add(btnAdd);
		mainToolbar.add(btnEdit);
		mainToolbar.add(btnDelete);
		add(mainToolbar, BorderLayout.NORTH);
		mainToolbar.setFloatable(false); //Onemogucava korisniku da pomera Toolbar za akcije
	
		String[] zaglavlje = new String[] {"id", "vlasnistvo", "Lista obavljenih servisa"};
		Object[][] sadrzaj = new Object[Crudoperacije.getServisneKnjizice().size()][zaglavlje.length];
		
		for(int i = 0; i<Crudoperacije.getServisneKnjizice().size(); i++) {
			ServisnaKnjizica servisnaknjizica = Crudoperacije.getServisneKnjizice().get(i);
			sadrzaj[i][0] = servisnaknjizica.getId();
			sadrzaj[i][1] = servisnaknjizica.getVlasnistvo();
			sadrzaj[i][2] = servisnaknjizica.getObavljeniServisi();
		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlje);
		servisneKnjiziceTabela = new JTable(tableModel);
		
		servisneKnjiziceTabela.setRowSelectionAllowed(true);
		servisneKnjiziceTabela.setColumnSelectionAllowed(false);
		servisneKnjiziceTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		servisneKnjiziceTabela.setDefaultEditor(Object.class, null);
		servisneKnjiziceTabela.getTableHeader().setReorderingAllowed(false);
		
		
		JScrollPane scrollPane = new JScrollPane(servisneKnjiziceTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	
	public void initActions() {
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ServisneKnjiziceForma skf = new ServisneKnjiziceForma(Crudoperacije, null);
				skf.setVisible(true);
				
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = servisneKnjiziceTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate da odabere red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					int servisnaId = (int) tableModel.getValueAt(red, 0);
					ServisnaKnjizica servisnaknjizica = Crudoperacije.nadjiServisnuKnjizicu(servisnaId);
					if(servisnaknjizica == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja servisneKnjizice", "Greska", JOptionPane.WARNING_MESSAGE);
					} else {
						ServisneKnjiziceForma skf = new ServisneKnjiziceForma(Crudoperacije, servisnaknjizica);
						skf.setVisible(true);
					}
				}
				
			}
		});
	}
	
}