package controle;
import java.util.List;

import infraestrutura.TelefoneDAO;
import modelo.Telefone;
/**
 * Classe de edição para os atributos 'CPF', 'nome', 'numero', e 'operadora' do objeto 'Telefone' da aplicação.
 * 
 * @author Caíque Santos Santana
 * @version 1.0
 * @since Release 1 da aplicação
 * 
 * */
public class editarPessoa {
	
	/**
	 * Método que faz a edição do cpf de um 'Telefone'.
	 * Checa se existe um 'Aluno' ou 'Professor' cadastrado com o valor do cpf igual ao valor de cpf passado pelo usuário para
	 * a troca e caso exista ele retorna nulo e não faz a edição pos não podem existir duas pessoas com o mesmo cpf.
	 * 
	 * @param id - o id do contato que deseja editar
	 * @param cpf - o novo cpf do 'Telefone'
	 * @return Telefone - o telefone que foi editado, agora com o novo valor de cpf.
	 * */
	public Telefone editarCPF(int id, String cpf){
		Long n = (long) id;
		TelefoneDAO tdao = new TelefoneDAO();
		List<Telefone> telefones = tdao.obterTodos();
		for (Telefone telefone : telefones) {
			if (telefone.getAluno() != null) {
				if (cpf.equals(telefone.getAluno().getCPF())) {
					return null;
				}
			} else if (telefone.getProfessor() != null) {
				if (cpf.equals(telefone.getProfessor().getCPF())) {
					return null;
				}
			}
		}
		
		tdao.abrirTransacao();
		Telefone t = tdao.editarCPF(n, cpf);
		tdao.fecharTransacao().fechar();
		return t;
	}
	
	/**
	 * Método que faz a edição do nome de um 'Telefone'.
	 * 
	 * @param id - o id do contato que deseja editar
	 * @param nome - o novo nome do 'Telefone'
	 * @return Telefone - o telefone que foi editado, agora com o novo valor do nome.
	 * */
	public Telefone editarNome(int id, String nome){
		Long n = (long) id;
		TelefoneDAO tdao = new TelefoneDAO();
		tdao.abrirTransacao();
		Telefone t = tdao.editarNome(n, nome);
		tdao.fecharTransacao().fechar();
		return t;
	}
	
	/**
	 * Método que faz a edição do número de um 'Telefone'.
	 * Checa se existe um 'Aluno' ou 'Professor' cadastrado com o valor do número igual ao valor do número passado pelo usuário para
	 * a troca e caso exista ele retorna nulo e não faz a edição pos não podem existir duas pessoas com o mesmo número.
	 * 
	 * @param id - o id do contato que deseja editar
	 * @param numero - o novo número do 'Telefone'
	 * @return Telefone - o telefone que foi editado, agora com o novo valor do número.
	 * */
	public Telefone editarNumero(int id, String numero){
		Long n = (long) id;
		TelefoneDAO tdao = new TelefoneDAO();
		List<Telefone> telefones = tdao.obterTodos();
		for (Telefone telefone : telefones) {
			if (numero.equals(telefone.getNumero())) {
				return null;
			}
		}

		tdao.abrirTransacao();
		Telefone t = tdao.editarNumero(n, numero);
		tdao.fecharTransacao().fechar();
		return t;
	}
	
	/**
	 * Método que faz a edição da operadora de um 'Telefone'.
	 * 
	 * @param id - o id do contato que deseja editar
	 * @param nome - a nova operadora do 'Telefone'
	 * @return Telefone - o telefone que foi editado, agora com o novo valor da operadora.
	 * */
	public Telefone editarOperadora(int id, String operadora){
		Long n = (long) id;
		TelefoneDAO tdao = new TelefoneDAO();
		String operadoraMaiusculo = operadora.toUpperCase();
		tdao.abrirTransacao();
		Telefone t = tdao.editarOperadora(n, operadoraMaiusculo);
		tdao.fecharTransacao().fechar();
		return t;
	}

}
