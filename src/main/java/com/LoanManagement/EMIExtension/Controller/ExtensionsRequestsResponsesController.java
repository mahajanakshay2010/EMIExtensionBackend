package com.LoanManagement.EMIExtension.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LoanManagement.EMIExtension.Model.ExtensionsRequestsResponses;
import com.LoanManagement.EMIExtension.Service.ExtensionRequestsResponsesService;
import com.LoanManagement.EMIExtension.Service.ExtensionRequestsResponsesServiceImpl;

@RestController
@RequestMapping("/api/emiextensions")
@CrossOrigin
public class ExtensionsRequestsResponsesController {

	Logger logger = LoggerFactory.getLogger(ExtensionsRequestsResponsesController.class);
	
	@Autowired
	private ExtensionRequestsResponsesService extensionRequestsResponsesService;
	
	@PutMapping("{requestId}")
	public ResponseEntity<ExtensionsRequestsResponses>  approveRejectExtensionRequests(@PathVariable int requestId,
			@RequestBody ExtensionsRequestsResponses extensionsRequestsResponses) {
		logger.trace("Respone method called to give the Response");
		ExtensionsRequestsResponses ResponseDTO = extensionRequestsResponsesService.updateResponse(requestId, extensionsRequestsResponses);
		return new ResponseEntity<>(ResponseDTO,HttpStatus.CREATED);
	}

	
	
	
	
	
	@Autowired
	private ExtensionRequestsResponsesServiceImpl extensionRequestsResponsesServiceImpl;
	@PostMapping("/responses")
	public ExtensionsRequestsResponses responses(@RequestBody ExtensionsRequestsResponses extensionsRequestsResponses) {
		return extensionRequestsResponsesServiceImpl.createResponse(extensionsRequestsResponses);
	}
	
	@GetMapping("/getresponsebasedOnRequestId/{requestId}")
	public Optional<ExtensionsRequestsResponses> getResponse(@PathVariable int requestId) {
		logger.trace("Response fetched");
		return extensionRequestsResponsesServiceImpl.getReqRes(requestId);
	}

	@GetMapping("/getAllResponses")
	public List<ExtensionsRequestsResponses> getAllExtensionsRequestsResponses() {
		return extensionRequestsResponsesServiceImpl.getAllResponses();
	}

	@GetMapping("/getParticularResponses/{id}")
	public Optional<ExtensionsRequestsResponses> getParticularResponses(@PathVariable int id) {
		return extensionRequestsResponsesServiceImpl.getParticularResponse(id);
	}

	@PutMapping("/updateResponse/{id}")
	public ExtensionsRequestsResponses updateResponse(@PathVariable int id,
			@RequestBody ExtensionsRequestsResponses extensionsRequestsResponses) {
		return extensionRequestsResponsesServiceImpl.updatExtensionsRequestsResponses(id, extensionsRequestsResponses);
	}

	@DeleteMapping("/deleteResponse/{id}")
	public void deleteResponse(@PathVariable int id) {
		extensionRequestsResponsesServiceImpl.deleteResponse(id);
	}

	@GetMapping("/getAllResp")
	public List<ExtensionsRequestsResponses> getAllResp() {
		return extensionRequestsResponsesServiceImpl.getAllResp();
	}

	@GetMapping("/getOneResp")
	public ExtensionsRequestsResponses getOneResp() {
		return extensionRequestsResponsesServiceImpl.getOneResp();
	}

	

	@PutMapping("/update/{requestId}")
	public ExtensionsRequestsResponses update(@PathVariable int requestId,
			@RequestBody ExtensionsRequestsResponses extensionsRequestsResponses) {
		return extensionRequestsResponsesServiceImpl.updatExtensionsRequestsResponses(requestId,
				extensionsRequestsResponses);
	}

}
