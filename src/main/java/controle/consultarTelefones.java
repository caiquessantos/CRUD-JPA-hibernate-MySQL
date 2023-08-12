package controle;
import java.util.List;

import infraestrutura.TelefoneDAO;
import modelo.Telefone;

/**
 * Classe de consulta a todos os 'Telefone' da aplicação.
 * 
 * @author Caíque Santos Santana
 * @version 1.0
 * @since Release 1 da aplicação
 * 
 * */
public class consultarTelefones {

	/**
	 * Método que faz a consulta de todos os 'Telefones' cadastrados no banco de dados.
	 * 
	 * @return List<Telefone>: uma lista com todos os telefones cadastrados.
	 * */
	public List<Telefone> consultar(){
		TelefoneDAO tdao = new TelefoneDAO();
		List<Telefone> t = tdao.obterTodos();
		return t;
	}
}
