package com.LoanManagement.EMIExtension.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.LoanManagement.EMIExtension.DTO.EMIsMasterDTO;
import com.LoanManagement.EMIExtension.Exceptions.maximumExtensionsLimitReachedExceptions;
import com.LoanManagement.EMIExtension.Model.ExtensionRequests;
import com.LoanManagement.EMIExtension.Repository.ExtensionRequestsRepository;

@Service
public class ExtensionRequestsServiceImpl implements ExtensionRequestsService {
	
	@Autowired
	private ExtensionRequestsRepository extensionRequestsRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ExtensionRequests requests(ExtensionRequests extensionRequests) {
		 List<ExtensionRequests> requestsByLoan = extensionRequestsRepository.findByLoanPlanId(extensionRequests.getLoanPlanId());
		 System.out.println(requestsByLoan);
	        if (requestsByLoan.size() >= 3) {
	            throw new maximumExtensionsLimitReachedExceptions("Maximum extensions limit reached for loan");
	        }
//	        System.out.println(extensionRequests.getRequestRaisedOn().getYear()+1900);
	     List<ExtensionRequests> requestByYear = extensionRequestsRepository.findByRequestRaisedOnYear(extensionRequests.getRequestRaisedOn().getYear()+1900);
	     if(requestByYear.size()>=2) {
	    	 throw new maximumExtensionsLimitReachedExceptions("Maximum extensions limit reached for loan");
	     }
		ExtensionRequests requests = extensionRequestsRepository.save(extensionRequests);

		return requests;
	}

	@Override
	public List<ExtensionRequests> getAllRequests() {
		// TODO Auto-generated method stub
		return extensionRequestsRepository.findAll();
	}

	@Override
	public Optional<ExtensionRequests> getParticularRequets(int requestId) {
		
		Optional<ExtensionRequests> extensionRequests = extensionRequestsRepository.findById(requestId);
		EMIsMasterDTO emi = restTemplate.getForObject("http://localhost:8083/getEMIbasedonId/"+extensionRequests.get().getEmisId(), EMIsMasterDTO.class);
		System.out.println(emi);
		emi.getId();
		return extensionRequests;
		
	}

	@Override
	public ExtensionRequests updateRequestsDetails(int requestId,ExtensionRequests extensionRequests) {
		Optional<ExtensionRequests> extensionRequests2 = extensionRequestsRepository.findById(requestId);
		if(extensionRequests2.isPresent()) {
			ExtensionRequests requestsDetails = extensionRequests2.get();
//			requestsDetails.setCustomerId(extensionRequests.getCustomerId());
//			requestsDetails.setEmisId(extensionRequests.getEmisId());
//			requestsDetails.setEtaPaymentDate(extensionRequests.getEtaPaymentDate());
//			requestsDetails.setExtensionReasons(extensionRequests.getExtensionReasons());
//			requestsDetails.setLoanPlanId(extensionRequests.getLoanPlanId());
//			requestsDetails.setOtherReasonString(extensionRequests.getOtherReasonString());
//			requestsDetails.setRequestRaisedOn(extensionRequests.getRequestRaisedOn());
			requestsDetails.setRequestStatus(extensionRequests.getRequestStatus());
			return extensionRequestsRepository.save(requestsDetails);
		}else {
			return null;
		}
		 
	}

	@Override
	public void deleteRequests(int requestId) {
		extensionRequestsRepository.deleteById(requestId);
		
	}
	
	public List<ExtensionRequests> AllReq(){
		return extensionRequestsRepository.AllReq();
	}
	
	public ExtensionRequests getReq() {
		return extensionRequestsRepository.getReq(1);
	}
	@Override
	public List<ExtensionRequests> newRequests(){
		return extensionRequestsRepository.newRequests("New");
	}

	@Override
	public ExtensionRequests updateRequestsStatus(int requestId,ExtensionRequests extensionRequests) {
		Optional<ExtensionRequests> extensionRequests2 = extensionRequestsRepository.findById(requestId);
		if(extensionRequests2.isPresent()) {
			ExtensionRequests requestsDetails = extensionRequests2.get();
			requestsDetails.setRequestStatus(extensionRequests.getRequestStatus());
			return extensionRequestsRepository.save(requestsDetails);
		}else {
			return null;
		}
		 
	}

	@Override
	public Optional<ExtensionRequests> getParticularRequetswithoutResttemp(int requestId) {
		// TODO Auto-generated method stub
		Optional<ExtensionRequests> extensionRequests = extensionRequestsRepository.findById(requestId);
		return extensionRequests;
	}

}
