package infraestrutura;
import modelo.Professor;
/**
 * Classe de infrastrutura própria para a entidade 'Professor'
 * 
 * @author Caíque Santos Santana
 * @version 1.0
 * @since Release 1 da aplicação
 * 
 * */
public class ProfessorDAO extends DAO<Professor>{
	
	public ProfessorDAO() {
		super(Professor.class);
	}

	/**
	 * Método que faz a remoção de um 'Professor'.
	 * 
	 * @param id - id do 'Professor'.
	 * @return void
	 * */
	public void removerProfessor(Long id) {
		remover(id);
	}
	
}
