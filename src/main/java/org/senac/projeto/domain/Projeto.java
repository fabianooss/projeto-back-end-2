package org.senac.projeto.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Projeto {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String nome;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;
	
	@NotNull
	@Positive
	private Integer prazo;
	
	@NotNull
	private BigDecimal orcamento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Integer getPrazo() {
		return prazo;
	}

	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}

	public BigDecimal getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(BigDecimal orcamento) {
		this.orcamento = orcamento;
	}

	public void validarOrcamento() throws Exception {
		if (this.orcamento.doubleValue() 
				< this.area.getOrcamentoMinimo().doubleValue() 
			||
			this.orcamento.doubleValue() 
				> this.area.getOrcamentoMaximo().doubleValue()
				) {
			
			throw new Exception("Orçamento do projeto fora do limite mínimo ou máximo");
		}
		
	}
	
	

}
