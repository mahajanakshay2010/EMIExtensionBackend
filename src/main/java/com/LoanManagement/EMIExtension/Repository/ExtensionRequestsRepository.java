package com.LoanManagement.EMIExtension.Repository;

import java.util.Date;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LoanManagement.EMIExtension.Model.ExtensionRequests;
@Repository
public interface ExtensionRequestsRepository extends JpaRepository<ExtensionRequests, Integer>{
	
	@Query(value="select r from ExtensionRequests r where r.requestStatus= :val")
	public List<ExtensionRequests> newRequests(@Param("val") String requestStatus );
	
	@Query(value="select r from ExtensionRequests r where r.loanPlanId= :val")
	public List<ExtensionRequests> findByLoanPlanId(@Param("val") int loanPlanId);
	
	@Query(value = "select * from Extension_Requests r where EXTRACT(YEAR FROM r.request_raised_on) = :year", nativeQuery = true)
    public List<ExtensionRequests> findByRequestRaisedOnYear(@Param("year") int year);
	
	
	
	
	@Query(value = "select r from ExtensionRequests r")
	public List<ExtensionRequests> AllReq();
	
	@Query(value = "select r from ExtensionRequests r where r.requestId=:val")
	public ExtensionRequests getReq(@Param("val") Integer requestId);

}
