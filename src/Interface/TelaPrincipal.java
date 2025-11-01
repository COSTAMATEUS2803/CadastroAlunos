package Interface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controle.Turma;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel TelaPrincipalLayout;
	private JButton btnCadastrar;
	private JButton btnConsultar;
	private JButton btnListar;
	private JButton btnFechar;
	private Turma turmaPrincipal = new Turma();
			
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {
		initializeComponents();
		initializeEvents();
	}
	
	private void initializeComponents() {
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 450);
		setLocationRelativeTo(null);
		TelaPrincipalLayout = new JPanel();
		TelaPrincipalLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(TelaPrincipalLayout);
		TelaPrincipalLayout.setLayout(null);
		
		btnCadastrar = new JButton("Cadastrar Aluno");
		btnCadastrar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnCadastrar.setBounds(10, 350, 150, 50);
		TelaPrincipalLayout.add(btnCadastrar);
		
		btnConsultar = new JButton("Consultar Aluno");
		btnConsultar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnConsultar.setBounds(330, 350, 150, 50);
		TelaPrincipalLayout.add(btnConsultar);
		
		btnListar = new JButton("Listar Alunos");
		btnListar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnListar.setBounds(170, 350, 150, 50);
		TelaPrincipalLayout.add(btnListar);
		
		btnFechar = new JButton("Sair");
		btnFechar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnFechar.setBounds(490, 350, 150, 50);
		TelaPrincipalLayout.add(btnFechar);
	}
	
	private void initializeEvents() {
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarAluno();
			}
		});
		
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarAlunos();
			}
		});
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarAluno();
			}
		});
		
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FecharAplicacao();
			}
		});
	}

	public void CadastrarAluno() {
		TelaCadastro telaCadastro = new TelaCadastro(this,this.turmaPrincipal);
		telaCadastro.setVisible(true);
	}
	
	public void ListarAlunos() {
		ArrayList<String> dadosAlunos = this.turmaPrincipal.listarAlunos();
		StringBuilder mensagem = new StringBuilder(" Alunos Cadastrados na Turma\n\n");
	    
	    for (String dado : dadosAlunos) {
	        mensagem.append(dado.substring(3)).append("\n"); 
	    }
	    JOptionPane.showMessageDialog(this,mensagem.toString(),"Lista de Alunos",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void ConsultarAluno() {
		TelaConsulta telaConsulta = new TelaConsulta(this, this.turmaPrincipal); 
	    telaConsulta.setVisible(true);
		
	}
	
	public void FecharAplicacao() {
		dispose();
	}
}
