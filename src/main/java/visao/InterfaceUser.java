package visao;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import controle.cadastroAluno;
import controle.cadastroProfessor;
import controle.consultaId;
import controle.consultarTelefones;
import modelo.Telefone;
import controle.editarPessoa;
import controle.removerPessoa;
/**
 * Classe de controle da aplicação
 * 
 * @author Caíque Santos Santana
 * @version 1.0
 * @since Release 1 da aplicação
 * 
 * */
public class InterfaceUser {
	
	/**
	 * Método que faz o controle principal do loop das ferramentas da aplicação.
	 * Chama outros métodos conforme eles sejam selecionados pelo user.
	 * 
	 * @return void
	 * */
	public void controlePrincipal() {
		Scanner entrada = new Scanner(System.in);
		int opcao= 0;
		
		while (opcao != 6) {
			System.out.println();
			System.out.println("|---------------------------|");
			System.out.println("|  Minha agenda telefônica  |");
			System.out.println("|---------------------------|");
			System.out.println("|                           |");
			System.out.println("| 1 => Cadastrar aluno      |");
			System.out.println("| 2 => Cadastrar Professor  |");
			System.out.println("| 3 => Consultar contatos   |");
			System.out.println("| 4 => Editar contato       |");
			System.out.println("| 5 => Excluir contato      |");
			System.out.println("| 6 => Sair                 |");
			System.out.println("|                           |");
			System.out.println("|---------------------------|");
			System.out.println();
			System.out.println("Qual ação deseja executar?");
			try {
				opcao = entrada.nextInt();
				entrada.nextLine();				
			} catch (InputMismatchException e) {
				System.out.println("\nOpção inválida");
				return;
				//log4j
			}
			
			switch (opcao) {
			case 1:
				cadastraAluno();
				break;
			case 2:
				cadastrarProfessor();
				break;
			case 3:
				consultarContatos();
				break;
			case 4:
				editarPessoa();
				break;
			case 5:
				deletarContator();
				break;
			case 6:
				break;
			default:
				break;
			}
		}		
		entrada.close();
	}

	/**
	 * Método que faz o controle da remoção de um 'Telefone' e chama, caso passe pelos testes de validação, a classe 'removerPessoa'. 
	 * 
	 * @return void
	 * */
	private void deletarContator() {
		Scanner entrada = new Scanner(System.in);
		consultarContatos();
		int id;
		System.out.println("\nInforme o ID do contato que deseja remover:");
		try {
			id = entrada.nextInt();
			entrada.nextLine();			
		}catch (InputMismatchException e) {
			//log4j
			System.out.println("\nOpção inválida");
			return;
		}
			consultaId cpi = new consultaId();
			cpi.consultar(id);
			removerPessoa rp = new removerPessoa();
			rp.remover(id);
			System.out.println("\nContato removido!");
	}
	/**
	 * Método que faz o loop e o controle da edição de um 'Telefone' e chama, caso passe pelos testes de validação, alguns dos métodos de edição. 
	 * 
	 * @return void
	 * */
	private void editarPessoa() {
		Scanner entrada = new Scanner(System.in);
		int opcao=0;
		while (opcao != 5) {
			System.out.println();
			System.out.println("|---------------------------|");
			System.out.println("|  Minha agenda telefônica  |");
			System.out.println("|---------------------------|");
			System.out.println("|                           |");
			System.out.println("| 1 => Editar CPF           |");
			System.out.println("| 2 => Editar nome          |");
			System.out.println("| 3 => Editar número        |");
			System.out.println("| 4 => Editar operadora     |");
			System.out.println("| 5 => voltar               |");
			System.out.println("|                           |");
			System.out.println("|---------------------------|");
			System.out.println();
			System.out.println("Qual ação deseja executar?");
			try {
				opcao = entrada.nextInt();
				entrada.nextLine();				
			} catch (InputMismatchException e) {
				//log4j
				System.out.println("\nOpção inválida");
				return;
			}
			switch (opcao) {
			case 1:
				editarPessoaCPF();
				break;
			case 2:
				editarPessoaNome();
				break;
			case 3:
				editarPessoaNumero();
				break;
			case 4:
				editarPessoaOperadora();
				break;
			case 5:
				break;
			default:
				break;
			}
		}
	}
	/**
	 * Método que faz o controle da edição de operadora de um 'Telefone' e chama, caso passe pelos testes de validação, o método editarOperadora
	 * presente na classe editarPessoa 
	 * 
	 * @return void
	 * */
	private void editarPessoaOperadora() {
		Scanner entrada = new Scanner(System.in);
		consultarContatos();
		int id;
		System.out.println("\nInforme o ID do contato que deseja editar:");
		try {
			id = entrada.nextInt();
			entrada.nextLine();			
		}catch (InputMismatchException e) {
			//log4j
			System.out.println("\nOpção inválida");
			return;
		}
		try {
			consultaId cid = new consultaId();
			cid.consultar(id);
			System.out.println("\nInforme a nova operadora:");
			String operadora = entrada.nextLine();
			if (operadora.isBlank()) {
				System.out.println("\nOPERADORA INVÁLIDA!");
				return;
			} else {
				editarPessoa edp = new editarPessoa();
				Telefone t = edp.editarOperadora(id, operadora);
				System.out.println("\nOperadora alterada para "+t.getOperadora());
			}
		} catch (Exception e) {
			System.out.println("\nID INEXISTENTE");
			return;
		}
	}
	
	/**
	 * Método que faz o controle da edição de numero de um 'Telefone' e chama, caso passe pelos testes de validação, o método editarNumero
	 * presente na classe editarPessoa 
	 * 
	 * @return void
	 * */
	private void editarPessoaNumero() {
		Scanner entrada = new Scanner(System.in);
		consultarContatos();
		int id;
		System.out.println("\nInforme o ID do contato que deseja editar:");
		try {
			id = entrada.nextInt();
			entrada.nextLine();			
		}catch (InputMismatchException e) {
			//log4j
			System.out.println("\nOpção inválida");
			return;
		}
		try {
			consultaId cid = new consultaId();
			cid.consultar(id);
			System.out.println("\nInforme o novo número sem espaços ou pontuação:");
			String numero = entrada.nextLine();
			if (numero.length()!=11 || numero.isBlank()) {
				System.out.println("\nNúmero INVÁLIDO!");
				return;
			} else {
				editarPessoa edp = new editarPessoa();
				Telefone t = edp.editarNumero(id, numero);
				System.out.println("\nNúmero atualizado para "+t.getNumero());
			}
		} catch (Exception e) {
			System.out.println("\nID INEXISTENTE E/OU NÚMERO JÁ CADASTRADO");
			return;
		}		
	}

	/**
	 * Método que faz o controle da edição do nome de um 'Telefone' e chama, caso passe pelos testes de validação, o método editarNome
	 * presente na classe editarPessoa 
	 * 
	 * @return void
	 * */
	private void editarPessoaNome() {
		Scanner entrada = new Scanner(System.in);
		consultarContatos();
		System.out.println("\nInforme o ID do contato que deseja editar:");
		int id;
		try {
			id = entrada.nextInt();
			entrada.nextLine();			
		}catch (InputMismatchException e) {
			//log4j
			System.out.println("\nOpção inválida");
			return;
		}		
			consultaId cid = new consultaId();
			cid.consultar(id);
			System.out.println("\nInforme o novo nome:");
			String nome = entrada.nextLine();
			if (nome.isBlank()) {
				System.out.println("\nNOME INVÁLIDO!");
				return;
			} else {
				try {
					editarPessoa edp = new editarPessoa();
					Telefone t = edp.editarNome(id, nome);
					if (t.getAluno()!=null) {
						System.out.println("\nNome atualizado para "+t.getAluno().getNome());					
					} else {
						System.out.println("\nNome atualizado para "+t.getProfessor().getNome());										
					}
				} catch (NullPointerException e) {
					// log4j
					System.out.println("\nID INEXISTENTE");
					return;
				}
			}
		}

	/**
	 * Método que faz o controle da edição de cpf de um 'Telefone' e chama, caso passe pelos testes de validação, o método editarCPF
	 * presente na classe editarPessoa 
	 * 
	 * @return void
	 * */
	private void editarPessoaCPF() {
		Scanner entrada = new Scanner(System.in);
		consultarContatos();
		System.out.println("\nInforme o ID do contato que deseja editar:");
		int id;
		try {
			id = entrada.nextInt();
			entrada.nextLine();			
		}catch (InputMismatchException e) {
			//log4j
			System.out.println("\nOpção inválida");
			return;
		}		try {
			consultaId cid = new consultaId();
			cid.consultar(id);
			System.out.println("\nInforme o novo CPF sem espaços ou pontuação:");
			String cpf = entrada.nextLine();
			if (cpf.length()!=11 || cpf.isBlank()) {
				System.out.println("\nCPF INVÁLIDO!");
				return;
			} else {
				editarPessoa edp = new editarPessoa();
				Telefone t = edp.editarCPF(id, cpf);
				if (t.getAluno()!=null) {
					System.out.println("\nCPF atualizado para: "+t.getAluno().getCPF());
				} else {
					System.out.println("\nCPF atualizado para: "+t.getProfessor().getCPF());
				}
			}
		} catch (Exception e) {
			System.out.println("\nID INEXISTENTE E/OU CPF JÁ CADASTRADO");
			return;
		}
	}
	
	/**
	 * Método que faz o controle da consulta de todos os contatos, chamando assim o método consultar presente na 
	 * classe consultarTelefones, informando o user caso não tenha nenhum contato cadastrado
	 * 
	 * @return void
	 * */
	private void consultarContatos() {
			consultarTelefones ct = new consultarTelefones();
			List<Telefone> telefones = ct.consultar();
			if (telefones.size()==0) {
				System.out.println("\nSem números cadastrados");
				return;
			}
			System.out.println("\nAlunos:");
			for (Telefone telefone : telefones) {
				if (telefone.getAluno()!=null) {
					System.out.println("\nID do contato: "+telefone.getId()+
							"\nNome: "+telefone.getAluno().getNome()+
							"\nCPF: "+telefone.getAluno().getCPF()+
							"\nNúmero: "+telefone.getNumero()+
							"\nOperadora: "+telefone.getOperadora()+
							"\nNúmero de matrícula: "+telefone.getAluno().getNumeroDeMatricula());
				}
			}
			System.out.println("\nProfessores:");
			for (Telefone telefone : telefones) {
				if (telefone.getProfessor()!=null) {
					System.out.println("\nID do contato: "+telefone.getId()+
							"\nNome: "+telefone.getProfessor().getNome()+
							"\nCPF: "+telefone.getProfessor().getCPF()+
							"\nNúmero: "+telefone.getNumero()+
							"\nOperadora: "+telefone.getOperadora());
				}
			}
	}

	/**
	 * Método que faz o controle do cadastro de um 'Professor' e chama, caso passe pelos testes de validação, o método cadastro
	 * presente na classe cadastroProfessor
	 * 
	 * @return void
	 * */
	private void cadastrarProfessor() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("\nInforme o nome do professor:");
		String nome = entrada.nextLine();
		if (nome.isBlank()) {
			System.out.println("\nNome não pode ser vazio!");
			return;
		} else {
			System.out.println("\nInforme o CPF do professor sem espaços ou pontuação:");
			String cpf = entrada.nextLine();
			if (cpf.isBlank() || cpf.length()!=11) {
				System.err.println("\nCPF inválido!");
				return;
			} else {
				System.out.println("\nInforme a operadora:");
				String operadora = entrada.nextLine();
				if (operadora.isBlank()) {
					System.out.println("\nOperadora inválida!");
					return;
				} else {
					System.out.println("\nInforme o número do professor sem espaços ou pontuação:");
					String numero = entrada.nextLine();
					if (numero.isBlank() || numero.length()!= 11) {
						System.out.println("\nNúmero inválido");
						return;
					} else {
						Telefone t = new Telefone();
						cadastroProfessor cp = new cadastroProfessor();
						try {
							t = cp.cadastro(nome, cpf, operadora, numero);
							System.out.println("\nCadastro de "+
							t.getProfessor().getNome()+" com CPF: "+
									t.getProfessor().getCPF()+" e número "+
							t.getNumero()+" relizado com sucesso!");
						} catch (Exception e) {
							System.out.println("\nCadastro não efetuado! número ou CPF já registrados!");
							return;
							// log4j
						}
					}
				}
			}
		}		
	}

	/**
	 * Método que faz o controle do cadastro de um 'Aluno' e chama, caso passe pelos testes de validação, o método cadastrar
	 * presente na classe cadastroAluno
	 * 
	 * @return void
	 * */
	private void cadastraAluno() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("\nInforme o nome do aluno:");
		String nome = entrada.nextLine();
		if (nome.isBlank()) {
			System.out.println("\nNome não pode ser vazio!");
			return;
		} else {
			System.out.println("\nInforme o CPF do aluno sem espaços ou pontuação:");
			String cpf = entrada.nextLine();
			if (cpf.isBlank() || cpf.length()!=11) {
				System.err.println("\nCPF inválido!");
				return;
			} else {
				System.out.println("\nInforme a operadora:");
				String operadora = entrada.nextLine();
				if (operadora.isBlank()) {
					System.out.println("\nOperadora inválida!");
					return;
				} else {
					System.out.println("\nInforme o número do aluno sem espaços ou pontuação:");
					String numero = entrada.nextLine();
					if (numero.isBlank() || numero.length()!= 11) {
						System.out.println("\nNúmero inválido");
						return;
					} else {
						Telefone t = new Telefone();
						cadastroAluno ca = new cadastroAluno();
						try {
							t = ca.cadastrar(nome, cpf, operadora, numero);
							System.out.println("\nCadastro de "+
							t.getAluno().getNome()+" com CPF: "+
									t.getAluno().getCPF()+" e número "+
							t.getNumero()+" relizado com sucesso!");
						} catch (Exception e) {
							System.out.println("\nCadastro não efetuado! número ou CPF já registrados!");
							return;
							// log4j
						}
					}
				}
			}
		}
	}
}
