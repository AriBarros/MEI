package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ade.mei.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long>{

}
