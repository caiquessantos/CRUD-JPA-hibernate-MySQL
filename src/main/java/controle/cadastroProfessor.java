package controle;
import java.util.List;
import infraestrutura.DAO;
import infraestrutura.TelefoneDAO;
import modelo.Professor;
import modelo.Telefone;
/**
 * Classe de cadastro de 'Professor' da aplicação.
 * 
 * @author Caíque Santos Santana
 * @version 1.0
 * @since Release 1 da aplicação
 * 
 * */
public class cadastroProfessor {
	
	/**
	 * Método que faz o o cadastro do 'Telefone' do 'Professor'.
	 * Checa se existe algum telefone que tenha o número ou o cpf igual aos próprios valores passados para
	 * o registro do novo objeto e caso exista, retorna nulo pois não podem existir cpfs ou números de telefones
	 * iguais.
	 * 
	 * @param nome - o nome que será cadastrado no novo professor
	 * @param cpf - o cpf que será cadastrado no novo professor
	 * @param operadora - a operadora que será cadastrada no novo professor
	 * @param numero - o número que será cadastrado no novo professor
	 * @return Telefone - o contato que foi salvo usando o professor cadastrado como parâmetro.
	 */
	public Telefone cadastro(String nome, String cpf, String operadora, String numero) {

		DAO<Object> dao = new DAO<Object>();
		TelefoneDAO tdao = new TelefoneDAO();
		List<Telefone> telefones = tdao.obterTodos();
	
		for (Telefone telefone : telefones) {
			if (cpf.equals(telefone.getAluno().getCPF()) || numero.equals(telefone.getNumero())) {
				return null;
			}
		}
		
		String operadoraMaiusculo = operadora.toUpperCase();
		Professor p = new Professor(nome, cpf);
		Telefone t = new Telefone(operadoraMaiusculo, numero, p);
		dao.abrirTransacao().inserir(p).inserir(t).fecharTransacao().fechar();

		return t;
	}

}
