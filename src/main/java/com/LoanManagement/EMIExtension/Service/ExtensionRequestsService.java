package com.LoanManagement.EMIExtension.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.LoanManagement.EMIExtension.Model.ExtensionRequests;

public interface ExtensionRequestsService {
	ExtensionRequests requests( ExtensionRequests extensionRequests);
	List<ExtensionRequests> getAllRequests();
	Optional<ExtensionRequests> getParticularRequets(int requestId);
	Optional<ExtensionRequests> getParticularRequetswithoutResttemp(int requestId);
	ExtensionRequests updateRequestsDetails(int requestId,ExtensionRequests extensionRequests);
	void deleteRequests(int requestId);
	List<ExtensionRequests> newRequests();
	ExtensionRequests updateRequestsStatus(int requestId,ExtensionRequests extensionRequests);
}
