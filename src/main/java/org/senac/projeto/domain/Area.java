package org.senac.projeto.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Area {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String nome;
	
	@NotNull
	@Positive
	private BigDecimal orcamentoMinimo;

	@NotNull
	@Positive	
	private BigDecimal orcamentoMaximo;

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

	public BigDecimal getOrcamentoMinimo() {
		return orcamentoMinimo;
	}

	public void setOrcamentoMinimo(BigDecimal orcamentoMinimo) {
		this.orcamentoMinimo = orcamentoMinimo;
	}

	public BigDecimal getOrcamentoMaximo() {
		return orcamentoMaximo;
	}

	public void setOrcamentoMaximo(BigDecimal orcamentoMaximo) {
		this.orcamentoMaximo = orcamentoMaximo;
	}

	
	
}
