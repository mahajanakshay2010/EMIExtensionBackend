package com.LoanManagement.EMIExtension.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.LoanManagement.EMIExtension.Model.ExtensionRequests;
import com.LoanManagement.EMIExtension.Model.ExtensionsRequestsResponses;
import com.LoanManagement.EMIExtension.Repository.ExtensionRequestsRepository;
import com.LoanManagement.EMIExtension.Repository.ExtensionsRequestsResponsesRepository;

@Service
public class ExtensionRequestsResponsesServiceImpl implements ExtensionRequestsResponsesService{
	@Autowired
	private ExtensionsRequestsResponsesRepository extensionsRequestsResponsesRepository;
	@Autowired
	private ExtensionRequestsRepository extensionRequestsRepository;

	@Override
	public ExtensionsRequestsResponses createResponse(
			ExtensionsRequestsResponses extensionsRequestsResponses) {
		// TODO Auto-generated method stub
		return extensionsRequestsResponsesRepository.save(extensionsRequestsResponses);
	}

	@Override
	public List<ExtensionsRequestsResponses> getAllResponses() {
		// TODO Auto-generated method stub
		return extensionsRequestsResponsesRepository.findAll();
	}

	@Override
	public Optional<ExtensionsRequestsResponses> getParticularResponse(int id) {
		return extensionsRequestsResponsesRepository.findById(id);
	}

	@Override
	public ExtensionsRequestsResponses updatExtensionsRequestsResponses(int id,
			ExtensionsRequestsResponses extensionsRequestsResponses) {
		// TODO Auto-generated method stub
		Optional<ExtensionsRequestsResponses> response = extensionsRequestsResponsesRepository.findById(id);
		if(response.isPresent()) {
			ExtensionsRequestsResponses newResponses = response.get();
			newResponses.setResponse(extensionsRequestsResponses.getResponse());
			newResponses.setExtensionGranted(extensionsRequestsResponses.getisExtensionGranted());
			newResponses.setResponseDate(extensionsRequestsResponses.getResponseDate());
			newResponses.setExtensionRequests(extensionsRequestsResponses.getExtensionRequests());
			return extensionsRequestsResponsesRepository.save(newResponses);
		}
		else {
			return null;
		}
		
	}
	
	public Optional<ExtensionsRequestsResponses> getReqRes(int requestId) {
		return extensionsRequestsResponsesRepository.getReqResp(requestId);
	}

	@Override
	public void deleteResponse(int id) {
		// TODO Auto-generated method stub
		extensionsRequestsResponsesRepository.deleteById(id);
	}
	
	public List<ExtensionsRequestsResponses> getAllResp(){
		return extensionsRequestsResponsesRepository.getAllResp();
	}
	
	public ExtensionsRequestsResponses getOneResp() {
		return extensionsRequestsResponsesRepository.getOneResp(1);
	}

	public ExtensionsRequestsResponses updateResponse(int requestId, ExtensionsRequestsResponses extensionsRequestsResponses) {
		Optional<ExtensionRequests> request = extensionRequestsRepository.findById(extensionsRequestsResponses.getExtensionRequests().getRequestId());
		if(request.isPresent()) {
			ExtensionsRequestsResponses extensionsRequestsResponses2 = new ExtensionsRequestsResponses();
			extensionsRequestsResponses2.setResponse(extensionsRequestsResponses.getResponse());
			extensionsRequestsResponses2.setExtensionGranted(extensionsRequestsResponses.getisExtensionGranted());
			extensionsRequestsResponses2.setResponseDate(extensionsRequestsResponses.getResponseDate());
			extensionsRequestsResponses2.setExtensionRequests(request.get());
			return extensionsRequestsResponsesRepository.save(extensionsRequestsResponses2);
		}
		else {
			return null;
		}
		
	}
	
//	public ExtensionsRequestsResponses update(int requestId,
//			ExtensionsRequestsResponses extensionsRequestsResponses) {
//		// TODO Auto-generated method stub
//		Optional<ExtensionRequests> request = extensionRequestsRepository.findById(requestId);
//		if(request.isPresent()) {
//			ExtensionsRequestsResponses newResponses = new ExtensionsRequestsResponses();
//			newResponses.setResponse(extensionsRequestsResponses.getResponse());
//			newResponses.setExtensionGranted(extensionsRequestsResponses.getisExtensionGranted());
//			newResponses.setResponseDate(extensionsRequestsResponses.getResponseDate());
//			newResponses.setExtensionRequests(extensionsRequestsResponses.getExtensionRequests());
//			return extensionsRequestsResponsesRepository.save(newResponses);
//		}
//		else {
//			return null;
//		}
		
//	}
	
	
	
	
	
	
	
	
	

}
