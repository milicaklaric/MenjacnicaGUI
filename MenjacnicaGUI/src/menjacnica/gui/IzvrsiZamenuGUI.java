package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtKupovni;
	private JTextField txtProdajni;
	private JTextField txtIznos;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI(MenjacnicaGUI m) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(IzvrsiZamenuGUI.class.getResource("/icons/zameni.png")));
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtKupovni = new JTextField();
		txtKupovni.setEditable(false);
		txtKupovni.setBounds(10, 37, 135, 20);
		contentPane.add(txtKupovni);
		txtKupovni.setColumns(10);
		
		txtProdajni = new JTextField();
		txtProdajni.setEditable(false);
		txtProdajni.setBounds(299, 37, 135, 20);
		contentPane.add(txtProdajni);
		txtProdajni.setColumns(10);
		
		JLabel lblKupovni = new JLabel("Kupovni kurs");
		lblKupovni.setBounds(10, 12, 115, 14);
		contentPane.add(lblKupovni);
		
		JLabel lblProdajniKurs = new JLabel("Prodajni kurs");
		lblProdajniKurs.setBounds(299, 12, 132, 14);
		contentPane.add(lblProdajniKurs);
		
		JLabel lblVakuta = new JLabel("Vakuta");
		lblVakuta.setBounds(186, 12, 46, 14);
		contentPane.add(lblVakuta);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "CHF"}));
		comboBox.setBounds(186, 37, 71, 20);
		contentPane.add(comboBox);
		
		JLabel lblIznos = new JLabel("Iznos");
		lblIznos.setBounds(10, 89, 46, 14);
		contentPane.add(lblIznos);
		
		txtIznos = new JTextField();
		txtIznos.setBounds(10, 114, 155, 20);
		contentPane.add(txtIznos);
		txtIznos.setColumns(10);
		
		JLabel lblVrstaTransakcije = new JLabel("Vrsta transakcije");
		lblVrstaTransakcije.setBounds(211, 89, 135, 14);
		contentPane.add(lblVrstaTransakcije);
		
		JRadioButton rdbtnKupovna = new JRadioButton("Kupovna");
		rdbtnKupovna.setSelected(true);
		buttonGroup.add(rdbtnKupovna);
		rdbtnKupovna.setBounds(211, 113, 109, 23);
		contentPane.add(rdbtnKupovna);
		
		JRadioButton rdbtnProdajna = new JRadioButton("Prodajna");
		rdbtnProdajna.setSelected(true);
		buttonGroup.add(rdbtnProdajna);
		rdbtnProdajna.setBounds(211, 139, 109, 23);
		contentPane.add(rdbtnProdajna);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				txtIznos.setText(""+slider.getValue());
				
			}
		});
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.setBounds(24, 178, 389, 45);
		contentPane.add(slider);
		
		JButton btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
		btnIzvrsiZamenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = "";
				String valuta = "";
				String transakcija = "";
				
				switch (comboBox.getSelectedIndex()) {
					case 0: valuta = "euro";
							break;
					case 1: valuta = "dolar";
							break;
					case 2: valuta = "franak";
							break;
				}
				
				if (rdbtnKupovna.isSelected())
					transakcija = "kupovina";
				else
					transakcija = "prodaja";
					
				s = s + "Valuta: " + valuta + "; Iznos: " + txtIznos.getText()
						+ "; Vrsta transakcije: " + transakcija ;
				
				m.ispis(s);
				dispose();
			}
			
		});
		btnIzvrsiZamenu.setBounds(30, 257, 135, 23);
		contentPane.add(btnIzvrsiZamenu);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOdustani.setBounds(265, 257, 148, 23);
		contentPane.add(btnOdustani);
	}
}
