package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ObrisiKursGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtSifra;
	private JTextField txtNaziv;
	private JTextField txtProdajni;
	private JTextField txtKupovni;
	private JTextField txtSrednji;
	private JTextField txtSkraceni;
	
	private JButton btnObrisi;

	

	/**
	 * Create the frame.
	 */
	public ObrisiKursGUI(MenjacnicaGUI m) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ObrisiKursGUI.class.getResource("/icons/obrisi.png")));
		setTitle("Obrisi kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 15, 5));
		
		JLabel label = new JLabel("Sifra");
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Naziv");
		label_1.setAlignmentX(0.5f);
		contentPane.add(label_1);
		
		txtSifra = new JTextField();
		txtSifra.setPreferredSize(new Dimension(6, 10));
		txtSifra.setMinimumSize(new Dimension(1, 5));
		txtSifra.setColumns(10);
		txtSifra.setAlignmentX(0.0f);
		contentPane.add(txtSifra);
		
		txtNaziv = new JTextField();
		txtNaziv.setPreferredSize(new Dimension(6, 10));
		txtNaziv.setMinimumSize(new Dimension(6, 10));
		txtNaziv.setColumns(10);
		contentPane.add(txtNaziv);
		
		JLabel label_2 = new JLabel("Prodajni kurs");
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Kupovni kurs");
		label_3.setAlignmentX(0.5f);
		contentPane.add(label_3);
		
		txtProdajni = new JTextField();
		txtProdajni.setPreferredSize(new Dimension(6, 10));
		txtProdajni.setMinimumSize(new Dimension(6, 10));
		txtProdajni.setColumns(10);
		txtProdajni.setAlignmentX(0.0f);
		contentPane.add(txtProdajni);
		
		txtKupovni = new JTextField();
		txtKupovni.setPreferredSize(new Dimension(6, 10));
		txtKupovni.setMinimumSize(new Dimension(6, 15));
		txtKupovni.setColumns(10);
		contentPane.add(txtKupovni);
		
		JLabel label_4 = new JLabel("Srednji kurs");
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Skraceni naziv");
		label_5.setAlignmentX(0.5f);
		contentPane.add(label_5);
		
		txtSrednji = new JTextField();
		txtSrednji.setPreferredSize(new Dimension(6, 10));
		txtSrednji.setMinimumSize(new Dimension(6, 15));
		txtSrednji.setColumns(10);
		txtSrednji.setAlignmentX(0.0f);
		contentPane.add(txtSrednji);
		
		txtSkraceni = new JTextField();
		txtSkraceni.setPreferredSize(new Dimension(6, 10));
		txtSkraceni.setMinimumSize(new Dimension(6, 15));
		txtSkraceni.setColumns(10);
		contentPane.add(txtSkraceni);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Zaista obrisi kurs");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()) 
					btnObrisi.setEnabled(true);	
				else
					btnObrisi.setEnabled(false);
			}
		});
		contentPane.add(chckbxNewCheckBox);
		
		JLabel label_6 = new JLabel("");
		contentPane.add(label_6);
		
		
		
		JButton btnOdustanid = new JButton("Odustani");
		btnOdustanid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
		
		btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = "";
				s = s + "Obrisan kurs:  Sifra: " + txtSifra.getText() + "; Naziv: " + txtNaziv.getText()
						+ "; Prodajni kurs: " + txtProdajni.getText() + "; Srednji kurs: " + txtSrednji.getText()
						+ "; Kupovni kurs: " + txtKupovni.getText() + "; Skraceni naziv: " + txtSkraceni.getText();
			
				m.ispis(s);
				dispose();
			}
		});
		btnObrisi.setEnabled(false);
		contentPane.add(btnObrisi);
		btnOdustanid.setAlignmentX(0.5f);
		contentPane.add(btnOdustanid);
	}

}
