package Interface;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import Controle.Turma;
import Entidade.Aluno;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaConsulta extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtFieldConsultaNome;
	private JTextField txtFieldConsultaMatricula;
	private JButton btnConsultar;
	private JButton btnCancelar;
	private Turma turma;
	
	public static void main(String[] args) {
		try {
			TelaConsulta dialog = new TelaConsulta(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TelaConsulta(JFrame parent, Turma turmaRecebida) {
		super(parent, "Cadastro de Alunos", true);
		this.turma = turmaRecebida;
		InitializeComponents();
		InitializeEvents();
		setLocationRelativeTo(parent);
	}
	
	private void InitializeComponents() {
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		btnCancelar = new JButton("Fechar");
		btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnCancelar.setBounds(274, 200, 150, 50);
		getContentPane().add(btnCancelar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnConsultar.setBounds(114, 200, 150, 50);
		getContentPane().add(btnConsultar);
		
		txtFieldConsultaNome = new JTextField();
		txtFieldConsultaNome.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtFieldConsultaNome.setColumns(10);
		txtFieldConsultaNome.setBounds(65, 81, 310, 20);
		getContentPane().add(txtFieldConsultaNome);
		
		txtFieldConsultaMatricula = new JTextField();
		txtFieldConsultaMatricula.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtFieldConsultaMatricula.setColumns(10);
		txtFieldConsultaMatricula.setBounds(65, 139, 310, 20);
		getContentPane().add(txtFieldConsultaMatricula);
		
		JLabel lblConsultarAlunoPor = new JLabel("Consultar Aluno por Nome:");
		lblConsultarAlunoPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarAlunoPor.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblConsultarAlunoPor.setBounds(65, 63, 310, 20);
		getContentPane().add(lblConsultarAlunoPor);
		
		JLabel lblConsultarAlunoPor_2 = new JLabel("Consultar Aluno por Matricula:");
		lblConsultarAlunoPor_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarAlunoPor_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblConsultarAlunoPor_2.setBounds(65, 114, 310, 25);
		getContentPane().add(lblConsultarAlunoPor_2);
	}
	
	private void InitializeEvents() {
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cancelar();
			}
		});
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultar();
			}
		});
	}
	
	private void Cancelar() {
		dispose();
	}
	
	private void Consultar() {
		String nome = txtFieldConsultaNome.getText().trim();
		String matriculaStr = txtFieldConsultaMatricula.getText().trim();
		
		Aluno alunoencontrado = null;
		
		if(nome.isEmpty() && matriculaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "É necessário digitar o Nome ou a Matricula do aluno para Consulta!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            txtFieldConsultaNome.requestFocus();
            return;
        }
		
		if(!matriculaStr.isEmpty()) {
			try {
                int matricula = Integer.parseInt(matriculaStr);
                alunoencontrado = this.turma.consultarAluno(matricula);
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "A Matrícula deve ser um número válido.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
                txtFieldConsultaMatricula.requestFocus();
                return;
            }
		}
		
		if (alunoencontrado == null && !nome.isEmpty()) {
            alunoencontrado = this.turma.consultarAluno(nome); 
        }
		
		if (alunoencontrado != null) {
			TelaCadastro telaCadastro = new TelaCadastro(this, alunoencontrado, true);
			telaCadastro.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Aluno não encontrado na turma.", "Não Foi Possível Consultar", JOptionPane.INFORMATION_MESSAGE);
        }
	}
}
