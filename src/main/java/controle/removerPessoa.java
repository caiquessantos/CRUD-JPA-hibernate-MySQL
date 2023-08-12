package controle;
import infraestrutura.AlunoDAO;
import infraestrutura.ProfessorDAO;
import infraestrutura.TelefoneDAO;
import modelo.Telefone;
/**
 * Classe de remoção de um contato('Telefone' incluindo o 'Aluno' ou 'Professor' que estiver atribuído a ele) da aplicação.
 * 
 * @author Caíque Santos Santana
 * @version 1.0
 * @since Release 1 da aplicação
 * 
 * */
public class removerPessoa {
	
	/**
	 * Método que faz a remoção de um 'Telefone' incluindo o 'Aluno' ou 'Professor' que estiver atribuído a ele.
	 * Faz a busca por id através de um valor de id passado anteriormente pelo usuárioe caso encontre o 'Telefone'
	 * atribuído a esse valor, faz a remoção desse 'Telefone' e do seu reespectivo 'Aluno' ou 'Professor' atribuído.
	 * 
	 *  @param id - id informado pelo user para a remoção.
	 *  @return void
	 * */
	public void remover(int id) {
		TelefoneDAO tdao = new TelefoneDAO();
		Long idt = (long) id;
		Telefone t = tdao.obterPorId(idt);

		if (t.getAluno() != null) {
			AlunoDAO adao = new AlunoDAO();
			Long idA = (long) t.getAluno().getId();
			tdao.abrirTransacao().remover(idt);
			tdao.fecharTransacao().fechar();
			adao.abrirTransacao().remover(idA);
			adao.fecharTransacao().fechar();	
		} else {
			ProfessorDAO pdao = new ProfessorDAO();
			Long idp = (long) t.getProfessor().getId();
			tdao.abrirTransacao().remover(idt);
			tdao.fecharTransacao().fechar();
			pdao.abrirTransacao().remover(idp);
			pdao.fecharTransacao().fechar();
		}
	}
}
