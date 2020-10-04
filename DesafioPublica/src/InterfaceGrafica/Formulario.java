package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Formulario implements ActionListener{

	JTextField txt;
	JTextArea textArea;
	JLabel label;
	JButton button, button1;
	ImageIcon fig1;
	
	public Formulario() {
		JFrame frame = new JFrame("Minhas Pontuações");
		frame.setSize(800, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setVisible(true);
		
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		button1 = new JButton("Novo Jogo");
		button1.addActionListener(this);
		panel.add(button1);
		frame.add( panel, BorderLayout.NORTH);	
		
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		label = new JLabel("Pontuação:");
		panel1.add(label); 
		txt = new JTextField(5);
		panel1.add(txt);
		button1 = new JButton("Salvar");
		button1.addActionListener(this);
		panel1.add(button1);
		frame.add( panel1, BorderLayout.CENTER);	
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Formulario();
			}
		});
	}

}
