package infraestrutura;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
/**
 * Classe de infrastrutura da aplicação
 * 
 * @author Caíque Santos Santana
 * @version 1.0
 * @since Release 1 da aplicação
 * 
 * */
public class DAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	/**
	 * Bloco estático responsável pela criação do EntityManager
	 * */
	static {
		try {
			emf = Persistence.createEntityManagerFactory("MuitospraUm");
		} catch (Exception e) {
			// log4j
		}
	}
	
	public DAO(){
		this(null);
	}

	public DAO(Class<E> classe) {
		em = emf.createEntityManager();
		this.classe = classe;
	}
	/**
	 * Método responsável por abrir a conexão com o banco de dados
	 * 
	 * @return DAO - a própria classe
	 * */
	public DAO<E> abrirTransacao(){
		em.getTransaction().begin();
		return this;
	}
	
	/**
	 * Método responsável por fazer o commit o banco de dados
	 * 
	 * @return DAO - a própria classe
	 * */
	public DAO<E> fecharTransacao(){
		em.getTransaction().commit();
		return this;
	}
	
	/**
	 * Método responsável por fechar a conexão com o banco de dados
	 * 
	 * @return void
	 * */
	public void fechar(){
		em.close();
	}
	
	/**
	 * Método responsável por fazer a inserção de uma entidade no banco de dados
	 * 
	 * @param entidade - a 'Entity' que foi passada
	 * @return DAO - a própria classe
	 * */
	public DAO<E> inserir(E entidade){
		em.persist(entidade);
		return this;
	}
	
	/**
	 * Método responsável por fazer o 'select' no banco de dados, selecionando todos no caso.
	 * 
	 * @return List<E> - Lista de todos os resultados da query
	 * */
	public List<E> obterTodos() {
		String jqpl = "select e from "+ classe.getName()+" e";
		TypedQuery<E> query = em.createQuery(jqpl, classe);
		return query.getResultList();
	}

	/**
	 * Método responsável por fazer a busca por id no banco de dados.
	 * 
	 * @param id - id da entidade que deverá ser encontrada
	 * @return E - entidade que tem o id informado
	 * */
	public E obterPorId(Object id) {
		return em.find(classe, id);
	}
	
	/**
	 * Método responsável por remover um objeto de uma entidade, fazendo a procura por id.
	 * 
	 * @param id - id da entidade que deverá ser encontrada
	 * @return void
	 * */
	public void remover(Long id) {
		em.remove(em.find(classe, id));
	}
}
