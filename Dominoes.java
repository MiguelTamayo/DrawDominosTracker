import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Dominoes {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dominoes window = new Dominoes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dominoes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GameDominos gs = new GameDominos();
		Opponent o = new Opponent();
		
		DefaultTableModel tm = new DefaultTableModel(new Object[][] {
			{0, null, null, null, null, null, null},
			{null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null},
			{null, null, null, null, null, null, null},
		},new String[] {
				"0'S", "1'S", "2'S", "3'S", "4'S", "5'S", "6'S"
			});
		int counter=0;
		 for(int top = 0; top < 7; top++){
	            for(int bottom = 0; bottom < 7; bottom++){
	                if (bottom<=top){
	                	tm.setValueAt(gs.getAvailableDominos().get(counter), top, bottom);
	                	counter++;
	                }
	            }
	        }
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel_4 = new JPanel();
		JPanel panel_3 = new JPanel();
		JPanel panel_2 = new JPanel();
		JPanel panel_1 = new JPanel();
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_111259720853636");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblChooseYourDomino = new JLabel("choose your domino");
		GridBagConstraints gbc_lblChooseYourDomino = new GridBagConstraints();
		gbc_lblChooseYourDomino.insets = new Insets(0, 0, 5, 0);
		gbc_lblChooseYourDomino.gridx = 0;
		gbc_lblChooseYourDomino.gridy = 0;
		panel.add(lblChooseYourDomino, gbc_lblChooseYourDomino);
		
		

		table = new JTable(tm);
		
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(true);
		
		DefaultListModel lstmodel2=new DefaultListModel();
		JList list_1 = new JList(lstmodel2);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lstmodel2.addElement(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
				tm.setValueAt(null,table.getSelectedRow(), table.getSelectedColumn());
			}
		});
		
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		panel.add(table, gbc_table);
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 2;
		panel.add(btnAdd, gbc_btnAdd);
		
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.insets = new Insets(0, 0, 5, 0);
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 0;
		gbc_list_1.gridy = 3;
		panel.add(list_1, gbc_list_1);
		
		JButton btnDone = new JButton("done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0;i<list_1.getModel().getSize();i++) {
					gs.removeFromPlay(((Domino)(list_1.getModel().getElementAt(i))).getID());
					o.removeDominosById(((Domino)(list_1.getModel().getElementAt(i))).getID());
				}
				panel_1.setVisible(true);
				panel.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnDone = new GridBagConstraints();
		gbc_btnDone.gridx = 0;
		gbc_btnDone.gridy = 4;
		panel.add(btnDone, gbc_btnDone);
		
		frame.getContentPane().add(panel_1, "name_111274859270097");
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblMenu = new JLabel("menu");
		GridBagConstraints gbc_lblMenu = new GridBagConstraints();
		gbc_lblMenu.insets = new Insets(0, 0, 5, 0);
		gbc_lblMenu.gridx = 0;
		gbc_lblMenu.gridy = 0;
		panel_1.add(lblMenu, gbc_lblMenu);

		table_1 = new JTable(tm);
		JButton btnViewAll = new JButton("view all");
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				int counter=0;
				 for(int top = 0; top < 7; top++){
			            for(int bottom = 0; bottom < 7; bottom++){
			                if (bottom<=top){
			                	tm.setValueAt(gs.getAvailableDominos().get(counter), top, bottom);
			                	counter++;
			                }
			            }
			        }
			}
		});
		GridBagConstraints gbc_btnViewAll = new GridBagConstraints();
		gbc_btnViewAll.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewAll.gridx = 0;
		gbc_btnViewAll.gridy = 1;
		panel_1.add(btnViewAll, gbc_btnViewAll);
		
		JButton btnViewOpponent = new JButton("view opponent");
		btnViewOpponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int counter=0;
				 for(int top = 0; top < 7; top++){
			            for(int bottom = 0; bottom < 7; bottom++){
			                if (bottom<=top){
			                	tm.setValueAt(o.getDominos().get(counter), top, bottom);
			                	counter++;
			                }
			            }
			        }
				panel_1.setVisible(false);
				panel_3.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnViewOpponent = new GridBagConstraints();
		gbc_btnViewOpponent.insets = new Insets(0, 0, 5, 0);
		gbc_btnViewOpponent.gridx = 0;
		gbc_btnViewOpponent.gridy = 2;
		panel_1.add(btnViewOpponent, gbc_btnViewOpponent);

		textField = new JTextField();
		JButton btnOpponentSkipped = new JButton("opponent skipped");
		btnOpponentSkipped.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				o.removeDominos(Integer.parseInt(textField.getText()));
			}
		});
		GridBagConstraints gbc_btnOpponentSkipped = new GridBagConstraints();
		gbc_btnOpponentSkipped.insets = new Insets(0, 0, 5, 0);
		gbc_btnOpponentSkipped.gridx = 0;
		gbc_btnOpponentSkipped.gridy = 3;
		panel_1.add(btnOpponentSkipped, gbc_btnOpponentSkipped);
		
		JButton btnEnterPlayed = new JButton("enter played");
		btnEnterPlayed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_4.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnEnterPlayed = new GridBagConstraints();
		gbc_btnEnterPlayed.insets = new Insets(0, 0, 5, 0);
		gbc_btnEnterPlayed.gridx = 0;
		gbc_btnEnterPlayed.gridy = 4;
		panel_1.add(btnEnterPlayed, gbc_btnEnterPlayed);
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 5;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		frame.getContentPane().add(panel_2, "name_111285067798152");
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblAllDomino = new JLabel("all domino");
		GridBagConstraints gbc_lblAllDomino = new GridBagConstraints();
		gbc_lblAllDomino.insets = new Insets(0, 0, 5, 0);
		gbc_lblAllDomino.gridx = 0;
		gbc_lblAllDomino.gridy = 0;
		panel_2.add(lblAllDomino, gbc_lblAllDomino);
		
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.insets = new Insets(0, 0, 5, 0);
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 0;
		gbc_table_1.gridy = 1;
		panel_2.add(table_1, gbc_table_1);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_2.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 2;
		panel_2.add(btnBack, gbc_btnBack);
		
		frame.getContentPane().add(panel_3, "name_111290331169917");
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblOpponentDominos = new JLabel("opponent dominos");
		GridBagConstraints gbc_lblOpponentDominos = new GridBagConstraints();
		gbc_lblOpponentDominos.insets = new Insets(0, 0, 5, 0);
		gbc_lblOpponentDominos.gridx = 0;
		gbc_lblOpponentDominos.gridy = 0;
		panel_3.add(lblOpponentDominos, gbc_lblOpponentDominos);
		
		table_2 = new JTable(tm);
		GridBagConstraints gbc_table_2 = new GridBagConstraints();
		gbc_table_2.insets = new Insets(0, 0, 5, 0);
		gbc_table_2.fill = GridBagConstraints.BOTH;
		gbc_table_2.gridx = 0;
		gbc_table_2.gridy = 1;
		panel_3.add(table_2, gbc_table_2);
		
		JButton btnReturn = new JButton("return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_3.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnReturn = new GridBagConstraints();
		gbc_btnReturn.gridx = 0;
		gbc_btnReturn.gridy = 2;
		panel_3.add(btnReturn, gbc_btnReturn);
		
		frame.getContentPane().add(panel_4, "name_111293065678032");
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblPlayedDomino = new JLabel("played domino");
		GridBagConstraints gbc_lblPlayedDomino = new GridBagConstraints();
		gbc_lblPlayedDomino.insets = new Insets(0, 0, 5, 0);
		gbc_lblPlayedDomino.gridx = 0;
		gbc_lblPlayedDomino.gridy = 0;
		panel_4.add(lblPlayedDomino, gbc_lblPlayedDomino);
		
		table_3 = new JTable(tm);

		table_3.setRowSelectionAllowed(false);
		table_3.setColumnSelectionAllowed(false);
		table_3.setCellSelectionEnabled(true);
		GridBagConstraints gbc_table_3 = new GridBagConstraints();
		gbc_table_3.insets = new Insets(0, 0, 5, 0);
		gbc_table_3.fill = GridBagConstraints.BOTH;
		gbc_table_3.gridx = 0;
		gbc_table_3.gridy = 1;
		panel_4.add(table_3, gbc_table_3);
		
		JButton btnAddToPlayed = new JButton("add to played and exit");
		btnAddToPlayed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int counter=0;
				 for(int top = 0; top < 7; top++){
			            for(int bottom = 0; bottom < 7; bottom++){
			                if (bottom<=top){
			                	tm.setValueAt(gs.getAvailableDominos().get(counter), top, bottom);
			                	counter++;
			                }
			            }
			        }
				 gs.removeFromPlay(((Domino)(table_3.getModel().getValueAt(table_3.getSelectedRow(), table_3.getSelectedColumn()))).getID());
				 o.removeDominosById(((Domino)(table_3.getModel().getValueAt(table_3.getSelectedRow(), table_3.getSelectedColumn()))).getID());
				panel_4.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAddToPlayed = new GridBagConstraints();
		gbc_btnAddToPlayed.gridx = 0;
		gbc_btnAddToPlayed.gridy = 2;
		panel_4.add(btnAddToPlayed, gbc_btnAddToPlayed);
	}

}
