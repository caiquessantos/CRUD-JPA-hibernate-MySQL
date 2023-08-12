package controle;
import java.util.List;
import java.util.Random;
import infraestrutura.DAO;
import infraestrutura.TelefoneDAO;
import modelo.Aluno;
import modelo.Telefone;
/**
 * Classe de cadastro de 'Aluno' da aplicação.
 * 
 * @author Caíque Santos Santana
 * @version 1.0
 * @since Release 1 da aplicação
 * 
 * */
public class cadastroAluno {
	
	/**
	 * Método que faz o o cadastro do 'Telefone' do 'Aluno'.
	 * Checa se existe algum telefone que tenha o número ou o cpf igual aos próprios valores passados para
	 * o registro do novo objeto e caso exista, retorna nulo pois não podem existir cpfs ou números de telefones
	 * iguais.
	 * Gera randomicamente 11 valores inteiros e transforma em string, sendo essa o número de matrícula.
	 * 
	 * @param nome - o nome que será cadastrado no novo aluno
	 * @param cpf - o cpf que será cadastrado no novo aluno
	 * @param operadora - a operadora que será cadastrada no novo aluno
	 * @param numero - o número que será cadastrado no novo aluno
	 * @return Telefone - o contato que foi salvo usando o aluno cadastrado como parâmetro.
	 * */
	public Telefone cadastrar(String nome, String cpf, String operadora, String numero) {
		DAO<Object> dao = new DAO<Object>();
		String nm = "";
		Random gerador = new Random();
		TelefoneDAO tdao = new TelefoneDAO();
		List<Telefone> telefones = tdao.obterTodos();

		for (Telefone telefone : telefones) {
			if (cpf.equals(telefone.getProfessor().getCPF()) || numero.equals(telefone.getNumero())) {
				return null;
			}
		}
		
		for (int i = 0; i <= 10; i++) {			
			int n = gerador.nextInt(9);
			String valor = Integer.toString(n);
			nm = nm+valor;
		}

		String operadoraMaiusculo = operadora.toUpperCase();
		Aluno a = new Aluno(nome, cpf, nm);	
		Telefone t = new Telefone(operadoraMaiusculo, numero, a);
		dao.abrirTransacao().inserir(a).inserir(t).fecharTransacao().fechar();
		return t;
	}	

	
}
