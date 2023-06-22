package com.ungdungso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ungdungso.model.BidsNotice;

public interface BidsNoticeRepostory extends JpaRepository<BidsNotice, String>{
	@Query(value="select * from bids_notice where public_date between :cfromDay and :ctoDay", nativeQuery = true)
	List<BidsNotice> queryGetBidsNotices(@Param("cfromDay") String fromDay,@Param("ctoDay") String toDay);
	

}
