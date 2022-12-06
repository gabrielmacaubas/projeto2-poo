package appswing;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Time;
import regras_negocio.Fachada;


public class TelaTime {
	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	
	private JButton button;
	private JButton button_1;
	
	private JTextField textField_1;
	private JTextField textField;
	
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	public TelaTime() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				listagem();
			}
		});
		frame.setTitle("Times");
		frame.setBounds(100, 100, 462, 351);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		
		scrollPane.setBounds(26, 42, 369, 120);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		
		table.setGridColor(Color.BLACK);
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		button = new JButton("Criar");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField.getText().isEmpty() || textField_1.getText().isEmpty()) {
						label.setText("campo vazio");
						
						return;
					}

					String nome = textField.getText();
					String origem = textField_1.getText();
					Time time = Fachada.criarTime(nome, origem);
					
					label.setText("time criado: "+time.getNome());
					listagem();
				}
				catch(Exception ex) {
					label.setText(ex.getMessage());
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBounds(298, 210, 95, 23);
		frame.getContentPane().add(button);

		label = new JLabel("");
		
		label.setForeground(Color.BLUE);
		label.setBackground(Color.RED);
		label.setBounds(26, 287, 830, 14);
		frame.getContentPane().add(label);

		button_1 = new JButton("Listar todos");
		
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listagem();
			}
		});
		button_1.setBounds(26, 8, 110, 23);
		frame.getContentPane().add(button_1);

		label_1 = new JLabel("nome");
		
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1.setBounds(26, 214, 40, 14);
		frame.getContentPane().add(label_1);

		textField = new JTextField();
		
		textField.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(62, 211, 85, 20);
		frame.getContentPane().add(textField);

		label_2 = new JLabel("origem");
		
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_2.setBounds(161, 214, 40, 14);
		frame.getContentPane().add(label_2);

		textField_1 = new JTextField();
		
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(203, 211, 85, 20);
		frame.getContentPane().add(textField_1);

	}

	public void listagem () {
		try{
			List<Time> lista = Fachada.listarTimes();
			DefaultTableModel model = new DefaultTableModel();

			model.addColumn("nome");
			model.addColumn("origem");

			for(Time time : lista) {
				model.addRow(new Object[]{time.getNome(), time.getOrigem()});
			}
			
			table.setModel(model);
		}
		catch(Exception erro){
			label.setText(erro.getMessage());
		}
	}
}
