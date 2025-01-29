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

import com.LoanManagement.EMIExtension.Model.ExtensionReasons;
import com.LoanManagement.EMIExtension.Repository.ExtensionReasonsRepository;
import com.LoanManagement.EMIExtension.Service.ExtensionReasonsService;
import com.LoanManagement.EMIExtension.Service.ExtensionReasonsServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/emiextensions")
@CrossOrigin
public class ExtensionReasonsController {

	Logger logger = LoggerFactory.getLogger(ExtensionReasonsController.class);

	@Autowired
	private ExtensionReasonsService extensionReasonsService;

	@GetMapping("/reasons")
	public ResponseEntity<List<ExtensionReasons>> getAllRea() {
		logger.trace("Get All Reasons method called");
		List<ExtensionReasons> ReasonDTO = extensionReasonsService.getForAll();
		return new ResponseEntity<>(ReasonDTO, HttpStatus.OK);
	}
	
	
	
	
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Welcome";
	}
	

	@PostMapping("/createreasons")
	public ResponseEntity<ExtensionReasons> reasons(@RequestBody ExtensionReasons extensionReasons) {
		ExtensionReasons extensionReasons2 = extensionReasonsService.reasons(extensionReasons);
		return new ResponseEntity<>(extensionReasons2, HttpStatus.CREATED);
	}

	

	@GetMapping("/getParticularReason/{id}")
	public Optional<ExtensionReasons> getParticularReason(@PathVariable int id) {
		return extensionReasonsService.getParticularReason(id);
	}

	@PostMapping("/updateReasons/{id}")
	public ExtensionReasons updateReasons(@PathVariable int id, @RequestBody ExtensionReasons extensionReasons) {
		return extensionReasonsService.updateReasons(id, extensionReasons);
	}

	@DeleteMapping("/deleteReason/{id}")
	public void deleteReasons(@PathVariable int id) {
		logger.trace("reason deleted");
		extensionReasonsService.deleteById(id);
	}

	@GetMapping("/getAll")
	public List<ExtensionReasons> getAll() {
		return extensionReasonsService.getAll();
	}

	@GetMapping("/getAllByReason")
	public ExtensionReasons getAllReasons() {
		return extensionReasonsService.getAllByReason();
	}
}
