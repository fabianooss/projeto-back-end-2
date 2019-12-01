package org.senac.projeto.repository;

import java.util.List;

import org.senac.projeto.domain.Projeto;
import org.senac.projeto.vo.AreaTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

	@Query("select new org.senac.projeto.vo.AreaTotal(p.area.nome, sum(p.orcamento), count(p.id), avg(p.prazo)) "
			+ "from Projeto p "
			+ "group by p.area.nome "
			+ "order by p.area.nome")
	List<AreaTotal> findAreaTotal();

}
