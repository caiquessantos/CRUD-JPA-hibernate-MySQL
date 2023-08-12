package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String operadora;
	
	@Column(nullable = false, length = 11)
	private String numero;

	@ManyToOne
	private Aluno aluno;

	@ManyToOne
	private Professor professor;
	
	public Telefone() {}

	public Telefone(String operadora, String numero, Professor professor) {
		super();
		this.operadora = operadora;
		this.numero = numero;
		this.professor = professor;
	}

	public Telefone(String operadora, String numero, Aluno aluno) {
		super();
		this.operadora = operadora;
		this.numero = numero;
		this.aluno = aluno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
}
