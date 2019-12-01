package org.senac.projeto.vo;

import java.math.BigDecimal;

public class AreaTotal {

	private String area;
	
	private BigDecimal orcamentoTotal;
	
	private long quantidadeProjetos;
	
	private double prazoMedio;
	
	public AreaTotal(String area, BigDecimal orcamentoTotal, long quantidadeProjetos, double prazoMedio) {
		super();
		this.area = area;
		this.orcamentoTotal = orcamentoTotal;
		this.quantidadeProjetos = quantidadeProjetos;
		this.prazoMedio = prazoMedio;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public BigDecimal getOrcamentoTotal() {
		return orcamentoTotal;
	}

	public void setOrcamentoTotal(BigDecimal orcamentoTotal) {
		this.orcamentoTotal = orcamentoTotal;
	}

	public long getQuantidadeProjetos() {
		return quantidadeProjetos;
	}

	public void setQuantidadeProjetos(long quantidadeProjetos) {
		this.quantidadeProjetos = quantidadeProjetos;
	}

	public double getPrazoMedio() {
		return prazoMedio;
	}

	public void setPrazoMedio(double prazoMedio) {
		this.prazoMedio = prazoMedio;
	}

	
	
	
}
