package interfaceGrafica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import BaseDados.PontosDAO;
import BaseDados.PontosJDBCDAO;
import Entidades.Pontos;
import Logica.GerenciadoraPontos;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Tela extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private PontosDAO dao;
	private JButton btnConfirmar;
	private JButton btnIniciar;
	private JLabel lblQuantosPontosVoc;
	private GerenciadoraPontos gerenciadora;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		dao = new PontosJDBCDAO();
		gerenciadora = new GerenciadoraPontos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 770, 309);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		criarIniciarJogo();
		criarInsercaoPlacar();
		carregarDados();
	}
	
	//INICIA UM NOVO JOGO AO CLICAR NO BOTAO "INICIAR JOGO"
	private void criarIniciarJogo() {
		btnIniciar = new JButton("Iniciar Jogo");
		btnIniciar.addActionListener(this);
		contentPane.add(btnIniciar);
		btnIniciar.setBounds(338, 333, 117, 25);
	}
	
	//AO INICIAR JOGO O TEXTFIELD É HABILITADO PARA RECEBER O PLACAR
	private void criarInsercaoPlacar() {
		
		textField = new JTextField();
		textField.setBounds(338, 438, 114, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblQuantosPontosVoc = new JLabel("Qual o placar de hoje?");
		contentPane.add(lblQuantosPontosVoc);
		lblQuantosPontosVoc.setBounds(308, 381, 270, 28);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(this);
		btnConfirmar.setBounds(335, 488, 117, 25);
		contentPane.add(btnConfirmar);
		desabilitarInsercaoPlacar();
	}

	private void desabilitarInsercaoPlacar() {
		textField.setEnabled(false);
		btnConfirmar.setEnabled(false);
		btnIniciar.setEnabled(true);
	}
	
	private void habilitarInsercaoPlacar() {
		textField.setEnabled(true);
		btnConfirmar.setEnabled(true);
		btnIniciar.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionName = e.getActionCommand();
		if(actionName.equalsIgnoreCase("confirmar")) {
			atualizarBanco();
			carregarDados();
			desabilitarInsercaoPlacar();
		}
		else if(actionName.equalsIgnoreCase("Iniciar Jogo")) {
			habilitarInsercaoPlacar();
		}
	}	

	private void atualizarBanco() {
		// SE NÃO TIVER NENHUM REGISTRO
		
		List<Pontos> pontos = dao.listaPontos();
		
			if(pontos.isEmpty()) {
				var pontosInseridos = Integer.parseInt(textField.getText());
				var pontosASalvar = new Pontos(pontosInseridos, pontosInseridos, pontosInseridos, 0, 0);
				dao.salvar(pontosASalvar);
				textField.setText("");
			}
			// SE TIVER UM OU MAIS REGISTROS, CALCULAR QUAL O NOVO RECORDE, MENOR E MAIOR PONTUACAO
			else {
				var pontosInseridos = Integer.parseInt(textField.getText());
				Pontos novaPontuacao = gerenciadora.obterNovaPontuacao(pontos, pontosInseridos);
				dao.salvar(novaPontuacao);
				}
		}
	
	
	private void carregarDados() {
		var result = dao.listar();
		table.setModel(DbUtils.resultSetToTableModel(result));
	}
}
