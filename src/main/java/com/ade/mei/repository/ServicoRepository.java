package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ade.mei.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository <Servico, Long> {
	


}
