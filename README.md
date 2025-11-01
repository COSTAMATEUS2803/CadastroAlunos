# CadastroAlunos
Sistema de Cadastro de Alunos feito em Java no Eclipse IDE para a disciplina de Programação Orientada a Objetos

Instruções:
Exercício: Sistema de Gerenciamento de Turma (SGT)
Objetivo: Desenvolver uma aplicação desktop simples para gerenciar os alunos de uma turma, utilizando conceitos fundamentais de Programação Orientada a Objetos, armazenamento em vetor e uma interface gráfica básica com Java Swing.

Requisitos Mandatórios:
  Fundamentos da Linguagem Java: O projeto deve ser desenvolvido em Java, utilizando a sintaxe padrão, tipos de dados primitivos, estruturas de controle (if, for) e boas práticas.

Classes:
  Crie uma classe Aluno (entidade) que deve conter os atributos:
    matricula (int)
    nome (String)
    nota1 (double)
    nota2 (double)
  Crie uma classe Turma (controle/negócio) que deve conter como atributo:
    Um vetor (array) de objetos Aluno. Ex: Aluno[] alunos;
    Um contador (int) para saber quantos alunos já foram inseridos no vetor (necessário para não ultrapassar o limite).

Vetores: A classe Turma deve inicializar o vetor com um tamanho fixo (ex: 40 alunos). Todas as operações (adicionar, consultar, listar) devem ser feitas manipulando este vetor.

Métodos:
  Na classe Aluno:
    Método calcularMedia(): Deve retornar a média aritmética das notas (nota1 e nota2).
  Na classe Turma:
    Método adicionarAluno(Aluno a): Adiciona um novo aluno ao vetor. (Lembre-se de verificar se o vetor não está cheio).
    Método listarAlunos(): Retorna uma String (ou um ArrayList<String>) contendo os dados de todos os alunos cadastrados e sua respectiva média.

Sobrecarga de Métodos:
  Na classe Turma, crie o método consultarAluno() de forma sobrecarregada:
    consultarAluno(int matricula): Busca e retorna um objeto Aluno pela matrícula.
    consultarAluno(String nome): Busca e retorna um objeto Aluno pelo nome exato. (Se houver mais de um, pode retornar o primeiro que encontrar).
    
Interface Gráfica (GUI):
  Utilize a biblioteca Java Swing (pacote javax.swing).
  Crie uma tela principal (JFrame) que permita ao usuário realizar as seguintes ações através de botões (JButton):
    Cadastrar Aluno: Abre uma nova janela (JDialog ou JFrame) com campos de texto (JTextField) para matrícula, nome, nota1 e nota2. Ao clicar em "Salvar", o aluno deve ser instanciado e adicionado à Turma.
    Listar Alunos: Ao clicar, exibe todos os alunos cadastrados (com nome, matrícula e média) em uma área de texto (JTextArea) ou usando JOptionPane.showMessageDialog.
    Consultar Aluno: Permite ao usuário digitar uma matrícula ou um nome e exibe os dados do aluno encontrado (utilize os métodos sobrecarregados).

Desafio (Complexidade Média+):
  Matrizes: Modifique a classe Aluno para que, ao invés de nota1 e nota2, ela tenha uma matriz de notas, por exemplo, double[2][2] (representando 2 bimestres, com 2 notas cada). O método calcularMedia() deverá ser ajustado para calcular a média geral.
  Validação: Na GUI, impeça o cadastro de um aluno se algum campo estiver vazio ou se a matrícula já existir no vetor.
