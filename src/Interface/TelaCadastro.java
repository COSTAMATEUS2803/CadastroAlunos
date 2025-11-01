package Interface;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Controle.Turma;
import Entidade.Aluno;

public class TelaCadastro extends JDialog {

	private static final long serialVersionUID = 1L;
	private JButton btnCancelar;
	private JButton btnCadastrar;
	private JTextField txtFieldNome;
	private JTextField txtFieldMatricula;
	private JTextField txtFieldNota1;
	private JTextField txtFieldNota2;
	private JLabel lblSemestre2;
	private JLabel lblNota3;
	private JTextField txtFieldNota3;
	private JLabel lblNota4;
	private JTextField txtFieldNota4;
	private Turma turma;
	private Aluno alunoParaExibir;
	private boolean isViewMode = false;
	
	public static void main(String[] args) {
		try {
			TelaCadastro dialog = new TelaCadastro(null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public TelaCadastro(JDialog parent, Aluno aluno, boolean isView) {
		super(parent, "Consulta de Aluno", true);
		this.alunoParaExibir = aluno;
		this.turma = null;
		this.isViewMode = isView;
		InitializeComponents();
	    InitializeEvents();
	    setViewMode();
	    setLocationRelativeTo(parent);
	    setViewMode();
	}
	
	public TelaCadastro(JFrame parent, Turma turmaRecebida) {
		super(parent, "Cadastro de Alunos", true);
		this.turma = turmaRecebida;
		this.alunoParaExibir = null;
		this.isViewMode = false;
		InitializeComponents();
		InitializeEvents();
		setLocationRelativeTo(null);
	}
	
	public void InitializeComponents() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			btnCancelar = new JButton("Fechar");
			btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 14));
			btnCancelar.setBounds(274, 200, 150, 50);
			getContentPane().add(btnCancelar);
		}
		{
			btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.setFont(new Font("Verdana", Font.PLAIN, 14));
			btnCadastrar.setBounds(114, 200, 150, 50);
			getContentPane().add(btnCadastrar);
		}
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNome.setBounds(68, 37, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblMatricula.setBounds(47, 62, 67, 14);
		getContentPane().add(lblMatricula);
		
		JLabel lblSemestre1 = new JLabel("Primeiro Semestre:");
		lblSemestre1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblSemestre1.setBounds(23, 89, 134, 14);
		getContentPane().add(lblSemestre1);
		
		JLabel lblNota1 = new JLabel("Nota 1:");
		lblNota1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNota1.setBounds(167, 89, 57, 14);
		getContentPane().add(lblNota1);
		
		JLabel lblNota2 = new JLabel("Nota 2:");
		lblNota2.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNota2.setBounds(301, 89, 57, 14);
		getContentPane().add(lblNota2);
		
		txtFieldNome = new JTextField();
		txtFieldNome.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtFieldNome.setBounds(114, 36, 310, 20);
		getContentPane().add(txtFieldNome);
		txtFieldNome.setColumns(10);
		
		txtFieldMatricula = new JTextField();
		txtFieldMatricula.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtFieldMatricula.setColumns(10);
		txtFieldMatricula.setBounds(114, 61, 310, 20);
		getContentPane().add(txtFieldMatricula);
		
		txtFieldNota1 = new JTextField();
		txtFieldNota1.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtFieldNota1.setColumns(10);
		txtFieldNota1.setBounds(224, 87, 67, 20);
		getContentPane().add(txtFieldNota1);
		
		txtFieldNota2 = new JTextField();
		txtFieldNota2.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtFieldNota2.setColumns(10);
		txtFieldNota2.setBounds(357, 87, 67, 20);
		getContentPane().add(txtFieldNota2);
		
		lblSemestre2 = new JLabel("Segundo Semestre:");
		lblSemestre2.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblSemestre2.setBounds(16, 116, 141, 17);
		getContentPane().add(lblSemestre2);
		
		lblNota3 = new JLabel("Nota 1:");
		lblNota3.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNota3.setBounds(167, 116, 57, 14);
		getContentPane().add(lblNota3);
		
		txtFieldNota3 = new JTextField();
		txtFieldNota3.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtFieldNota3.setColumns(10);
		txtFieldNota3.setBounds(224, 113, 67, 20);
		getContentPane().add(txtFieldNota3);
		
		lblNota4 = new JLabel("Nota 2:");
		lblNota4.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNota4.setBounds(301, 116, 57, 14);
		getContentPane().add(lblNota4);
		
		txtFieldNota4 = new JTextField();
		txtFieldNota4.setFont(new Font("Verdana", Font.PLAIN, 12));
		txtFieldNota4.setColumns(10);
		txtFieldNota4.setBounds(357, 113, 67, 20);
		getContentPane().add(txtFieldNota4);
	}
	
	public void InitializeEvents() {
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fechar();
			}
		});
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastrar();
			}
		});
	}
	
	public void Cadastrar() {
		String nome = txtFieldNome.getText().trim();
		String matriculaStr = txtFieldMatricula.getText().trim();
		String n1B1Str = txtFieldNota1.getText().trim();
		String n2B1Str = txtFieldNota2.getText().trim();
		String n1B2Str = txtFieldNota3.getText().trim();
		String n2B2Str = txtFieldNota4.getText().trim();
		
		if(nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Nome é obrigatório.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            txtFieldNome.requestFocus();
            return;
        }
		
		if(matriculaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo Matrícula é obrigatório.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            txtFieldMatricula.requestFocus();
            return;
        }
		
		if(n1B1Str.isEmpty() || n2B1Str.isEmpty() || n1B2Str.isEmpty() || n2B2Str.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Os campos das Notas são obrigatórios.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
		}
	
		try {
			int matricula = Integer.parseInt(matriculaStr);
	        double n1B1 = Double.parseDouble(n1B1Str);
	        double n2B1 = Double.parseDouble(n2B1Str);
	        double n1B2 = Double.parseDouble(n1B2Str);
	        double n2B2 = Double.parseDouble(n2B2Str);
	        
	        double[][] notas = {
	                {n1B1, n2B1},
	                {n1B2, n2B2} 
	            };
	        Aluno novoAluno = new Aluno(matricula, nome, notas);
	        this.turma.adicionarAluno(novoAluno);
			JOptionPane.showMessageDialog(this, "O aluno foi cadastrado com sucesso!", "Cadastro Bem Sucedido", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}	catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "A Matrícula e as Notas devem ser números válidos. Erro: " + e.getMessage(), "Erro de Formato", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void Fechar() {
		dispose();
	}
	
	public void setViewMode() {
		if (this.isViewMode && this.alunoParaExibir != null) {
	        this.txtFieldNome.setText(this.alunoParaExibir.getNome());
	        this.txtFieldMatricula.setText(String.valueOf(this.alunoParaExibir.getMatricula()));
	        double[][] notas = this.alunoParaExibir.getNotas();
	        this.txtFieldNota1.setText(String.valueOf(notas[0][0]));
	        this.txtFieldNota2.setText(String.valueOf(notas[0][1]));
	        this.txtFieldNota3.setText(String.valueOf(notas[1][0]));
	        this.txtFieldNota4.setText(String.valueOf(notas[1][1]));
	        this.txtFieldNome.setEditable(false);
	        this.txtFieldMatricula.setEditable(false);
	        this.txtFieldNota1.setEditable(false);
	        this.txtFieldNota2.setEditable(false);
	        this.txtFieldNota3.setEditable(false);
	        this.txtFieldNota4.setEditable(false);
	        this.btnCadastrar.setEnabled(false);
	    }
	}
}
