package com.LoanManagement.EMIExtension.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LoanManagement.EMIExtension.Model.ExtensionReasons;

@Repository
public interface ExtensionReasonsRepository extends JpaRepository<ExtensionReasons, Integer>{
	
	@Query(value="select r from ExtensionReasons r")
	public List<ExtensionReasons> getAll();
	
	@Query(value="select r from ExtensionReasons r where r.reason = :val")
	public ExtensionReasons getAllByReason(@Param("val") String reasonss);

}
