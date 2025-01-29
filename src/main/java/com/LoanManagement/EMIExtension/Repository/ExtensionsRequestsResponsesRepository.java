package com.LoanManagement.EMIExtension.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LoanManagement.EMIExtension.Model.ExtensionRequests;
import com.LoanManagement.EMIExtension.Model.ExtensionsRequestsResponses;

@Repository
public interface ExtensionsRequestsResponsesRepository extends JpaRepository<ExtensionsRequestsResponses, Integer>{
	
	@Query(value = "select r from ExtensionsRequestsResponses r")
	public List<ExtensionsRequestsResponses> getAllResp();
	
	@Query(value = "select r from ExtensionsRequestsResponses r where id=:val")
	public ExtensionsRequestsResponses getOneResp(@Param("val") Integer id);
	
	@Query(value = "select * from emi.extensions_requests_responses where request_id=:requestId",nativeQuery = true)
	public Optional<ExtensionsRequestsResponses> getReqResp(@Param("requestId") int requestId);
	
//	@Query(value = "select * from Extension_Requests r where EXTRACT(YEAR FROM r.request_raised_on) = :year", nativeQuery = true)
//    public List<ExtensionRequests> findByRequestRaisedOnYear(@Param("year") int year);
	
//	@Query(value="select r from ExtensionRequests r where r.requestStatus= :val")
//	public List<ExtensionRequests> newRequests(@Param("val") String requestStatus );

}
