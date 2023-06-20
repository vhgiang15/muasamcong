package com.ungdungso.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ungdungso.model.InvestField;

public interface InvestFieldRepository extends JpaRepository<InvestField, String>{
	@Query(value="SELECT invest_field_name FROM invest_field where invest_field= :cinvest", nativeQuery = true)
	String queryName(@Param("cinvest") String invest);

}
