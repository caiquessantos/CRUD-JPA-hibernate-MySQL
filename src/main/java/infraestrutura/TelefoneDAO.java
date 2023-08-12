package infraestrutura;
import modelo.Telefone;
/**
 * Classe de infrastrutura própria para a entidade 'Telefone'
 * 
 * @author Caíque Santos Santana
 * @version 1.0
 * @since Release 1 da aplicação
 * 
 * */
public class TelefoneDAO extends DAO<Telefone> {

	public TelefoneDAO() {
		super(Telefone.class);
	}
	
	/**
	 * Método que faz a edição do 'CPF' de um 'Telefone'.
	 * Checa se o 'Telefone' é associado a um 'Aluno' ou 'Professor' e faz o set no 'CPF' dele com o novo valor de cpf informado anteriormente.
	 * 
	 *  @param id - o id do 'Telefone' que será editado
	 *  @return Telefone - o 'Telefone' editado, com o novo valor de 'CPF'.
	 * */
	public Telefone editarCPF(Long id, String cpf) {
		Telefone t = obterPorId(id);
		if (t.getAluno() != null) {
			t.getAluno().setCPF(cpf);
		} else {
			t.getProfessor().setCPF(cpf);
		}
		return t;
	}
	
	/**
	 * Método que faz a edição do 'nome' de um 'Telefone'.
	 * Checa se o 'Telefone' é associado a um 'Aluno' ou 'Professor' e faz o set no 'nome' dele com o novo valor de nome informado anteriormente.
	 * 
	 *  @param id - o id do 'Telefone' que será editado
	 *  @return Telefone - o 'Telefone' editado, com o novo valor de 'nome'.
	 * */
	public Telefone editarNome(Long id, String nome) {
		Telefone t = obterPorId(id);
		if (t.getAluno() != null) {
			t.getAluno().setNome(nome);;
		} else {
			t.getProfessor().setNome(nome);
		}
		return t;
	}
	
	/**
	 * Método que faz a edição da 'operadora' de um 'Telefone'.
	 * Faz o set na 'operadora' do 'Telefone' desejado, com o novo valor de operadora informado anteriormente.
	 * 
	 *  @param id - o id do 'Telefone' que será editado
	 *  @return Telefone - o 'Telefone' editado, com o novo valor de 'operadora'.
	 * */
	public Telefone editarOperadora(Long id, String operadora) {
		Telefone t = obterPorId(id);
		t.setOperadora(operadora);
		return t;
	}
	
	/**
	 * Método que faz a edição do 'numero' de um 'Telefone'.
	 * Checa se o 'Telefone' é associado a um 'Aluno' ou 'Professor' e faz o set no 'numero' dele com o novo valor de número informado anteriormente.
	 * 
	 *  @param id - o id do 'Telefone' que será editado
	 *  @return Telefone - o 'Telefone' editado, com o novo valor de 'numero'.
	 * */
	public Telefone editarNumero(Long id, String numero) {
		Telefone t = obterPorId(id);
		if (t.getAluno() != null) {
			t.setNumero(numero);
		} else {
			t.setNumero(numero);
		}		
		return t;
	}
	/**
	 * Método que faz a remoção de um 'Telefone'.
	 * 
	 * @param id - id do 'Telefone'.
	 * @return void
	 * */
	public void removerContato(Long id) {
		remover(id);
	}
}
