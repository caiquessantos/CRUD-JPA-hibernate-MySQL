package controle;
import infraestrutura.TelefoneDAO;
import modelo.Telefone;
/**
 * Classe de cadastro de busca por id da aplicação.
 * 
 * @author Caíque Santos Santana
 * @version 1.0
 * @since Release 1 da aplicação
 * 
 * */
public class consultaId {

	/**
	 * Método que faz a busca de um 'Telefone' a partir de um valor informado anteriormente, sendo esse convertido em Long e 
	 * usado como id.
	 * 
	 * @param id - valor do id informado pelo user para que seja pesquisado no bando de dados o 'Telefone' a partir dele.
	 * @return Telefone - o 'Telefone' que for encontrado, caso ele seja encontrado, caso não exista um 'Telefone' cadastrado
	 * para o id informado, ele irá gerar uma excessão que será tratada na classe 'interfaceUser'.
	 * */
	public Telefone consultar(int id) {
		Long n = (long) id;
		TelefoneDAO tdao = new TelefoneDAO();
		return tdao.obterPorId(n);
	}
}
