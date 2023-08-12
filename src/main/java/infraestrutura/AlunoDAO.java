package infraestrutura;
import modelo.Aluno;
/**
 * Classe de infrastrutura própria para a entidade 'Aluno'
 * 
 * @author Caíque Santos Santana
 * @version 1.0
 * @since Release 1 da aplicação
 * 
 * */
public class AlunoDAO extends DAO<Aluno>{
	
	public AlunoDAO() {
		super(Aluno.class);
	}
	
	/**
	 * Método que faz a remoção de um 'Aluno'.
	 * 
	 * @param id - id do 'Aluno'.
	 * @return void
	 * */
	public void removerAluno(Long id) {
		remover(id);
	}
}