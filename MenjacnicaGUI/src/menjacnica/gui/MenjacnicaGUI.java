package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.Point;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextArea textArea;
	private MenjacnicaGUI m;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		this.m = this;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int opcija = 
						JOptionPane.showConfirmDialog(
							null, "Da li zelite da izadjete iz programa?",
							"Izlazak", JOptionPane.YES_NO_CANCEL_OPTION);
					
					if (opcija == JOptionPane.YES_OPTION)
						System.exit(0);
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/icons/Calculator-icon (1).png")));
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 630, 354);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		textArea = new JTextArea();
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				
				int opcija = fc.showOpenDialog(null);
				
				if (opcija == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					
					textArea.append("Ucitan fajl:  " + f.getAbsolutePath() + '\n');
				}
			}
		}
		);
		mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/icons/open1.png")));
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				
				int opcija = fc.showSaveDialog(null);
				
				if (opcija == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					
					textArea.append("Sacuvan fajl:  " + f.getAbsolutePath() + '\n');
				}
			}
		});
		mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/icons/save.png")));
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opcija = 
						JOptionPane.showConfirmDialog(
							null, "Da li zelite da izadjete iz programa?",
							"Izlazak", JOptionPane.YES_NO_CANCEL_OPTION);
					
					if (opcija == JOptionPane.YES_OPTION)
						System.exit(0);			
			}
		});
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"Aplikacija menjacnica, autor Milica Klaric",
						"O programu",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.EAST);
		panel.setPreferredSize(new Dimension(140, 10));
		panel.setLayout(null);
		
		JButton btnDodajKurs = new JButton("Dodaj kurs");
		btnDodajKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodajKursGUI dk = new DodajKursGUI(m);
				
				dk.setVisible(true);
				
			}
		});
		
		
		btnDodajKurs.setBounds(13, 5, 120, 23);
		panel.add(btnDodajKurs);
		
		JButton btnObrisiKurs = new JButton("Obrisi kurs");
		btnObrisiKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObrisiKursGUI ok = new ObrisiKursGUI(m);
				
				ok.setVisible(true);
			}
		});
		btnObrisiKurs.setBounds(13, 33, 120, 23);
		panel.add(btnObrisiKurs);
		
		JButton btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
		btnIzvrsiZamenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzvrsiZamenuGUI zk = new IzvrsiZamenuGUI();
				
				zk.setVisible(true);
			}
		});
		btnIzvrsiZamenu.setBounds(13, 61, 120, 23);
		panel.add(btnIzvrsiZamenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 70));
		panel_1.setBorder(new TitledBorder(null, "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		textArea.setBorder(new LineBorder(Color.GRAY));
		panel_1.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(255, 255, 255));
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPane.setAutoscrolls(true);
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
		scrollPane.setBackground(SystemColor.menu);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBorder(new LineBorder(Color.GRAY));
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u0160ifra", "Skra\u0107eni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Float.class, Float.class, Float.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		scrollPane.setViewportView(table);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);
		
		JMenuItem mntmDodajKurs = new JMenuItem("Dodaj kurs");
		mntmDodajKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodajKursGUI dk = new DodajKursGUI(m);
				
				dk.setVisible(true);
				
			}
		});
		popupMenu.add(mntmDodajKurs);
		
		JMenuItem mntmObrisiKurs = new JMenuItem("Obrisi kurs");
		mntmObrisiKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodajKursGUI dk = new DodajKursGUI(m);
				
				dk.setVisible(true);
			}
		});
		popupMenu.add(mntmObrisiKurs);
		
		JMenuItem mntmIzavrsiZamenu = new JMenuItem("Izavrsi zamenu");
		mntmIzavrsiZamenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IzvrsiZamenuGUI zk = new IzvrsiZamenuGUI();
				
				zk.setVisible(true);
			}
		});
		popupMenu.add(mntmIzavrsiZamenu);
	
	}
	
	
	
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
