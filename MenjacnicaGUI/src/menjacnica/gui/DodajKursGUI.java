package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtSifra;
	private JTextField txtNaziv;
	private JTextField txtProdajni;
	private JTextField txtKupovni;
	private JTextField txtSrednji;
	private JTextField txtSkraceni;

	private MenjacnicaGUI m;

	/**
	 * Create the frame.
	 * @param m 
	 */
	public DodajKursGUI(MenjacnicaGUI m) {
		this.m = m;
		setResizable(false);
		setTitle("Dodaj kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 423, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 15, 5));
		
		JLabel lblSifra = new JLabel("Sifra");
		contentPane.add(lblSifra);
		
		JLabel lblNaziv = new JLabel("Naziv");
		lblNaziv.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblNaziv);
		
		txtSifra = new JTextField();
		txtSifra.setMinimumSize(new Dimension(1, 5));
		txtSifra.setPreferredSize(new Dimension(6, 10));
		txtSifra.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(txtSifra);
		txtSifra.setColumns(10);
		
		txtNaziv = new JTextField();
		txtNaziv.setMinimumSize(new Dimension(6, 10));
		txtNaziv.setPreferredSize(new Dimension(6, 10));
		contentPane.add(txtNaziv);
		txtNaziv.setColumns(10);
		
		JLabel lblProdajniKurs = new JLabel("Prodajni kurs");
		contentPane.add(lblProdajniKurs);
		
		JLabel lblKupovniKurs = new JLabel("Kupovni kurs");
		lblKupovniKurs.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblKupovniKurs);
		
		txtProdajni = new JTextField();
		txtProdajni.setPreferredSize(new Dimension(6, 10));
		txtProdajni.setMinimumSize(new Dimension(6, 10));
		txtProdajni.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(txtProdajni);
		txtProdajni.setColumns(10);
		
		txtKupovni = new JTextField();
		txtKupovni.setPreferredSize(new Dimension(6, 10));
		txtKupovni.setMinimumSize(new Dimension(6, 15));
		contentPane.add(txtKupovni);
		txtKupovni.setColumns(10);
		
		JLabel lblSrednjiKurs = new JLabel("Srednji kurs");
		contentPane.add(lblSrednjiKurs);
		
		JLabel lblSkraceniNaziv = new JLabel("Skraceni naziv");
		lblSkraceniNaziv.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblSkraceniNaziv);
		
		txtSrednji = new JTextField();
		txtSrednji.setPreferredSize(new Dimension(6, 10));
		txtSrednji.setMinimumSize(new Dimension(6, 15));
		txtSrednji.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(txtSrednji);
		txtSrednji.setColumns(10);
		
		txtSkraceni = new JTextField();
		txtSkraceni.setPreferredSize(new Dimension(6, 10));
		txtSkraceni.setMinimumSize(new Dimension(6, 15));
		contentPane.add(txtSkraceni);
		txtSkraceni.setColumns(10);
		
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s = "";
				s = s + "Sifra: " + txtSifra.getText() + "; Naziv: " + txtNaziv.getText()
						+ "; Prodajni kurs: " + txtProdajni.getText() + "; Srednji kurs: " + txtSrednji.getText()
						+ "; Kupovni kurs: " + txtKupovni.getText() + "; Skraceni naziv: " + txtSkraceni.getText();
				//ispis
				
				dispose();
				
			}
		});
		contentPane.add(btnDodaj);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOdustani.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(btnOdustani);
	}
	
	

}
