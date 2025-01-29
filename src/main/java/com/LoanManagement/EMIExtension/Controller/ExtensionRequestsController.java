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
import com.LoanManagement.EMIExtension.Model.ExtensionRequests;
import com.LoanManagement.EMIExtension.Service.ExtensionRequestsService;
import com.LoanManagement.EMIExtension.Service.ExtensionRequestsServiceImpl;

@RestController
@RequestMapping("/api/emiextensions")
@CrossOrigin
public class ExtensionRequestsController {
	
	Logger logger = LoggerFactory.getLogger(ExtensionRequestsController.class);
	
	
	@Autowired
	private ExtensionRequestsService extensionRequestsService;

	
	@PostMapping("/newrequest")
	public ResponseEntity<ExtensionRequests> requests(@RequestBody ExtensionRequests ExtensionRequestDTO) {
		logger.trace("request created for emi extension");
		ExtensionRequests extensionRequests2 = extensionRequestsService.requests(ExtensionRequestDTO);
		return new ResponseEntity<>(extensionRequests2,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllRequests")
	public ResponseEntity<List<ExtensionRequests>> getAllRequets(){
		logger.trace("Get All Requests Method Called");
		List<ExtensionRequests> ExtensionRequestDTOs = extensionRequestsService.getAllRequests();
		return new ResponseEntity<>( ExtensionRequestDTOs,HttpStatus.OK);
	}
	
	@GetMapping("rest/{requestId}")
	public ResponseEntity<Optional<ExtensionRequests>>  getParticularId(@PathVariable Integer requestId){
		logger.trace("Get Particular Request Method with rest template Called");
		Optional<ExtensionRequests> ExtensionRequestDTO = extensionRequestsService.getParticularRequets(requestId);
		return new ResponseEntity<>( ExtensionRequestDTO,HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<ExtensionRequests>>  getNewRequests(){
		logger.trace("All requests with New Status are Fetched");
		List<ExtensionRequests> ExtensionRequestDTOs = extensionRequestsService.newRequests();
		return new ResponseEntity<> (ExtensionRequestDTOs,HttpStatus.OK);
	}
	
	@GetMapping("/{requestId}")
	public ResponseEntity<Optional<ExtensionRequests>>  getParticularRequest(@PathVariable Integer requestId){
		logger.trace("Get Particular Request Method Called");
		Optional<ExtensionRequests> ExtensionRequestDTO = extensionRequestsService.getParticularRequetswithoutResttemp(requestId);
		return new ResponseEntity<>( ExtensionRequestDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updateStatus/{requestId}")
	public ResponseEntity<ExtensionRequests>  updateRequestsStatus(@PathVariable Integer requestId, @RequestBody ExtensionRequests extensionRequests) {
		logger.trace("Update status for request method called");
		return new ResponseEntity<>(extensionRequestsService.updateRequestsDetails(requestId, extensionRequests),HttpStatus.CREATED);
	}
	
	
	
	
	
	
	@Autowired
	private ExtensionRequestsServiceImpl extensionRequestsServiceImpl;
	
	@PutMapping("/updateRequests/{requestId}")
	public ExtensionRequests updateRequests(@PathVariable Integer requestId, @RequestBody ExtensionRequests extensionRequests) {
		logger.trace("Status Updated");
		return extensionRequestsServiceImpl.updateRequestsDetails(requestId, extensionRequests);
	}
	@DeleteMapping("deleteRequest/{requestId}")
	public void deleteRequests(@PathVariable Integer requestId) {
		extensionRequestsServiceImpl.deleteRequests(requestId);
	}
	
	@GetMapping("/getAllReq")
	public List<ExtensionRequests> AllReq(){
		return extensionRequestsServiceImpl.AllReq();
	}
	
	@GetMapping("/getReq")
	public ExtensionRequests getReq() {
		return extensionRequestsServiceImpl.getReq();
	}
	
	
	
	
	
}
