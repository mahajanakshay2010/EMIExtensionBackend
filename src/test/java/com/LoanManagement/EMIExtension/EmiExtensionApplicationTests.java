package com.LoanManagement.EMIExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.LoanManagement.EMIExtension.Exceptions.maximumExtensionsLimitReachedExceptions;
import com.LoanManagement.EMIExtension.Model.ExtensionReasons;
import com.LoanManagement.EMIExtension.Model.ExtensionRequests;
import com.LoanManagement.EMIExtension.Model.ExtensionsRequestsResponses;
import com.LoanManagement.EMIExtension.Repository.ExtensionReasonsRepository;
import com.LoanManagement.EMIExtension.Repository.ExtensionRequestsRepository;
import com.LoanManagement.EMIExtension.Repository.ExtensionsRequestsResponsesRepository;
import com.LoanManagement.EMIExtension.Service.ExtensionReasonsService;
import com.LoanManagement.EMIExtension.Service.ExtensionRequestsResponsesService;
import com.LoanManagement.EMIExtension.Service.ExtensionRequestsService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmiExtensionApplicationTests {
	
	@Autowired
	private ExtensionReasonsService extensionReasonsService;
	@Autowired
	private ExtensionRequestsService extensionRequestsService;
	
	@MockBean
	private ExtensionReasonsRepository extensionReasonsRepository;
	@MockBean 
	private ExtensionRequestsRepository extensionRequestsRepository;
	
	@MockBean
	private ExtensionsRequestsResponsesRepository extensionsRequestsResponsesRepository;
	@Autowired
	private ExtensionRequestsResponsesService extensionRequestsResponsesService;
	
	@Test
	public void testGetForAll() {
		ExtensionReasons extensionReasons = new ExtensionReasons(1, "salary not credited");
		ExtensionReasons extensionReasons1 = new ExtensionReasons(2, "salary not credited");
		when(extensionReasonsRepository.findAll()).thenReturn(List.of(extensionReasons,extensionReasons1));
		List<ExtensionReasons> result= extensionReasonsService.getForAll();
		assertEquals(2, result.size());
		
	}
	
	@Test
	public void testRequests() {
		ExtensionReasons extensionReasons = new ExtensionReasons(1, "salary not credited");
		ExtensionRequests extensionRequests = new ExtensionRequests(1, 1, 1, 1,extensionReasons , "Not enoughf Balance", new Date(), new Date(), "New");
		ExtensionRequests extensionRequests2 = new ExtensionRequests(2, 1, 1, 1,extensionReasons , "Not enoughf Balance", new Date(), new Date(), "New");
		ExtensionRequests extensionRequests3 = new ExtensionRequests(3, 1, 1, 1,extensionReasons , "Not enoughf Balance", new Date(), new Date(), "New");
		ExtensionRequests extensionRequests4 = new ExtensionRequests(3, 1, 1, 1,extensionReasons , "Not enoughf Balance",new Date() , new Date(), "New");
		when(extensionRequestsRepository.save(extensionRequests3)).thenReturn(extensionRequests3);
		when(extensionRequestsRepository.save(extensionRequests)).thenReturn(extensionRequests);
		when(extensionRequestsRepository.save(extensionRequests2)).thenReturn(extensionRequests2);
		when(extensionRequestsRepository.findByLoanPlanId(extensionRequests4.getLoanPlanId())).thenReturn(List.of(extensionRequests,extensionRequests2,extensionRequests3));
		assertThrows(maximumExtensionsLimitReachedExceptions.class, () -> extensionRequestsService.requests(extensionRequests4));
	}
	
	@Test
	public void testRequestsforYear() {
		ExtensionReasons extensionReasons = new ExtensionReasons(1, "salary not credited");
		ExtensionRequests extensionRequests = new ExtensionRequests(1, 1, 1, 1,extensionReasons , "Not enoughf Balance", new Date(), new Date(), "New");
		ExtensionRequests extensionRequests2 = new ExtensionRequests(2, 1, 1, 1,extensionReasons , "Not enoughf Balance", new Date(), new Date(), "New");
		when(extensionRequestsRepository.save(extensionRequests)).thenReturn(extensionRequests);
		when(extensionRequestsRepository.save(extensionRequests2)).thenReturn(extensionRequests2);
		ExtensionRequests extensionRequests3 = new ExtensionRequests(3, 1, 1, 2,extensionReasons , "Not enoughf Balance", new Date(), new Date(), "New");
		when(extensionRequestsRepository.findByRequestRaisedOnYear(extensionRequests3.getRequestRaisedOn().getYear()+1900)).thenReturn(List.of(extensionRequests,extensionRequests2));
		assertThrows(maximumExtensionsLimitReachedExceptions.class, () -> extensionRequestsService.requests(extensionRequests3));

	}
	
	
	
//	@Test
//	public void testGetParticularRequest() {
//		ExtensionReasons extensionReasons = new ExtensionReasons(1, "salary not credited");
//		ExtensionRequests extensionRequests = new ExtensionRequests(1, 1, 1, 1,extensionReasons , "Not enoughf Balance", new Date(), new Date(), "New");
//		when(extensionRequestsRepository.findById(1)).thenReturn(Optional.of(extensionRequests));
//		Optional<ExtensionRequests> req = extensionRequestsService.getParticularRequets(1);
//		assertEquals(extensionRequests, req.get());
//	}
	
	@Test
	public void testGetAllRequests() {
		
		ExtensionReasons extensionReasons = new ExtensionReasons(1, "salary not credited");
		ExtensionRequests extensionRequests = new ExtensionRequests(1, 1, 1, 1,extensionReasons , "Not enoughf Balance", new Date(), new Date(), "New");
		ExtensionRequests extensionRequests2 = new ExtensionRequests(2, 1, 1, 1,extensionReasons , "Not enoughf Balance", new Date(), new Date(), "New");
		when(extensionRequestsRepository.findAll()).thenReturn(List.of(extensionRequests,extensionRequests2));
		List<ExtensionRequests> extensionRequests1 = extensionRequestsService.getAllRequests();
		assertEquals(2, extensionRequests1.size());
	}
	
	@Test
	public void testNewExtensionRequets() {
		ExtensionReasons extensionReasons = new ExtensionReasons(1, "salary not credited");
		ExtensionRequests extensionRequests = new ExtensionRequests(1, 1, 1, 1,extensionReasons , "Not enoughf Balance", new Date(), new Date(), "New");
		ExtensionRequests extensionRequests2 = new ExtensionRequests(2, 1, 1, 1,extensionReasons , "Not enoughf Balance", new Date(), new Date(), "Pending");
		when(extensionRequestsRepository.newRequests("New")).thenReturn(List.of(extensionRequests));
		List<ExtensionRequests> extensionRequests3 = extensionRequestsService.newRequests();
		assertEquals(1, extensionRequests3.size());
	}
	
	@Test
	public void testRequestStatus() {
		int requestId=1;
		ExtensionReasons extensionReasons = new ExtensionReasons(1, "salary not credited");
		ExtensionRequests extensionRequests = new ExtensionRequests(1, 1, 1, 1,extensionReasons , "Not enoughf Balance", new Date(), new Date(), "New");
		ExtensionRequests extensionRequests2 = new ExtensionRequests(2, 1, 1, 1,extensionReasons , "Not enoughf Balance", new Date(), new Date(), "Pending");
		when(extensionRequestsRepository.findById(requestId)).thenReturn(Optional.of(extensionRequests));
		when(extensionRequestsRepository.save(any(ExtensionRequests.class))).thenReturn(extensionRequests2);
		ExtensionRequests extensionRequests3 = extensionRequestsService.updateRequestsDetails(requestId, extensionRequests2);
		assertEquals("Pending", extensionRequests3.getRequestStatus());
		}
	 
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testApproveReject() {
		ExtensionReasons extensionReasons = new ExtensionReasons(1, "salary not credited");
		ExtensionRequests extensionRequests = new ExtensionRequests(1, 1, 1, 1,extensionReasons , "Not enoughf Balance", new Date(), new Date(), "New") ;
		ExtensionsRequestsResponses extensionsRequestsResponses = new ExtensionsRequestsResponses(1, "Approved", true, new Date(), extensionRequests);
		int requestId=1;
		when(extensionRequestsRepository.findById(requestId)).thenReturn(Optional.of(extensionRequests));
		when(extensionsRequestsResponsesRepository.save(any(ExtensionsRequestsResponses.class))).thenReturn(extensionsRequestsResponses);
		ExtensionsRequestsResponses extensionsRequestsResponses2 = extensionRequestsResponsesService.updateResponse(requestId, extensionsRequestsResponses);
		assertEquals(extensionsRequestsResponses, extensionsRequestsResponses2);
		
	}

}
