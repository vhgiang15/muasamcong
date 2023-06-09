package com.ungdungso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ungdungso.model.BidsNotice;

public interface BidsNoticeRepostory extends JpaRepository<BidsNotice, String>{
	@Query(value="select * from bids_notice where public_date between :cfromDay and :ctoDay order by public_date desc;", nativeQuery = true)
	List<BidsNotice> queryGetBidsNotices(@Param("cfromDay") String fromDay,@Param("ctoDay") String toDay);
	
	@Query(value="select count(*) from bids_notice where public_date between :cfromDay and :ctoDay", nativeQuery = true)
	int queryCountGetBidsNotices(@Param("cfromDay") String fromDay,@Param("ctoDay") String toDay);
	
	@Query(value="select count(*) from bids_notice where location like :clocation and public_date between :cfromDay and :ctoDay", nativeQuery = true)
	int queryCountGetBidsNoticesByLocation(@Param("clocation") String location, @Param("cfromDay") String fromDay,@Param("ctoDay") String toDay);
	
	@Query(value="select * from bids_notice where public_date between :cfromDay and :ctoDay order by public_date desc limit :coffset,10", nativeQuery = true)
	List<BidsNotice> queryGetBidsNoticesByPage(@Param("cfromDay") String fromDay,@Param("ctoDay") String toDay,@Param("coffset") int offset);
	
	@Query(value="select * from bids_notice where notify_no like :cnotifyNo and location like :clocation and (public_date between :cfromDay and :ctoDay) order by public_date desc", nativeQuery = true)
	List<BidsNotice> querySearchBidsNotices(@Param("cnotifyNo") String notifyNo,@Param("clocation") String location,@Param("cfromDay") String fromDay, @Param("ctoDay") String toDay);
	
	@Query(value="select * from bids_notice where location like :clocation and (public_date between :cfromDay and :ctoDay) and invest_field like :cinvestField order by public_date desc", nativeQuery = true)
	List<BidsNotice> queryReportBidsNotices(@Param("clocation") String location,@Param("cfromDay") String fromDay, @Param("ctoDay") String toDay, @Param("cinvestField") String investField);
	
	@Query(value="select * from bids_notice where location like :clocation and investor_name like :ckey and (public_date between :cfromDay and :ctoDay) and invest_field like :cinvestField order by public_date", nativeQuery = true)
	List<BidsNotice> queryReportByInvetor(@Param("clocation") String location,@Param("ckey") String key,@Param("cfromDay") String fromDay, @Param("ctoDay") String toDay, @Param("cinvestField") String investField);
	
	@Query(value="select * from bids_notice where location like :clocation and procuring_entity_name like :ckey and (public_date between :cfromDay and :ctoDay) and invest_field like :cinvestField order by public_date", nativeQuery = true)
	List<BidsNotice> queryReportByProcuring(@Param("clocation") String location,@Param("ckey") String key,@Param("cfromDay") String fromDay, @Param("ctoDay") String toDay, @Param("cinvestField") String investField);
	
	@Query(value="select * from bids_notice where location like :clocation and bid_name like :ckey and (public_date between :cfromDay and :ctoDay) and invest_field like :cinvestField order by public_date", nativeQuery = true)
	List<BidsNotice> queryReportByBidName(@Param("clocation") String location,@Param("ckey") String key,@Param("cfromDay") String fromDay, @Param("ctoDay") String toDay, @Param("cinvestField") String investField);
	
	@Query(value="select * from bids_notice where location like :clocation and contractor_name like :ckey and (public_date between :cfromDay and :ctoDay) and invest_field like :cinvestField order by public_date", nativeQuery = true)
	List<BidsNotice> queryReportByContractor(@Param("clocation") String location,@Param("ckey") String key,@Param("cfromDay") String fromDay, @Param("ctoDay") String toDay, @Param("cinvestField") String investField);
	
	@Query(value="select * from bids_notice where decision_date IS null and (public_date between :cfromDay and :ctoDay) order by public_date", nativeQuery = true)
	List<BidsNotice> queryGetBidNotFinish(@Param("cfromDay") String fromDay, @Param("ctoDay") String toDay);
}
