package com.ungdungso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ungdungso.model.Province;

public interface ProvinceRepository extends JpaRepository<Province, Integer> {

	@Query(value="select * from province where area= :carea", nativeQuery = true)
	List<Province> queryGetProvinceByArea(@Param("carea") String area);	
}
