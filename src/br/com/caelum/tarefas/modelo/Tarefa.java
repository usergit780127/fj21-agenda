package br.com.caelum.tarefas.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=5) // validacao bean validation
	private String descricao; // input de formulario.jsp deve possuir o mesmo nome do atributo para o spring mvc fazer a ligacao
	
	private boolean finalizado;
	
	@Temporal(TemporalType.DATE) // somente a data
	private Calendar dataFinalizacao; // nao foi usado na insercao no banco e na visualizacao em tela para exercicios antes hibernate
	
	// JavaBean - construtor vazio
	public Tarefa() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
}
