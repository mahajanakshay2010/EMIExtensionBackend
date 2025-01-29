package com.LoanManagement.EMIExtension.Service;

import java.util.List;
import java.util.Optional;

import com.LoanManagement.EMIExtension.Model.ExtensionsRequestsResponses;
import com.LoanManagement.EMIExtension.Repository.ExtensionsRequestsResponsesRepository;

public interface ExtensionRequestsResponsesService {
	
	ExtensionsRequestsResponses createResponse(ExtensionsRequestsResponses extensionsRequestsResponses);
	List<ExtensionsRequestsResponses> getAllResponses();
	Optional<ExtensionsRequestsResponses> getParticularResponse(int id);
	ExtensionsRequestsResponses updatExtensionsRequestsResponses(int id,ExtensionsRequestsResponses extensionsRequestsResponses);
	void deleteResponse(int id);
	ExtensionsRequestsResponses updateResponse(int requestId, ExtensionsRequestsResponses extensionsRequestsResponses);
}
