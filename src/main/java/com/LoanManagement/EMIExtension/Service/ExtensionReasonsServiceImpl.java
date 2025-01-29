package com.LoanManagement.EMIExtension.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.LoanManagement.EMIExtension.Model.ExtensionReasons;
import com.LoanManagement.EMIExtension.Repository.ExtensionReasonsRepository;


@Service
public class ExtensionReasonsServiceImpl implements ExtensionReasonsService{
	
	@Autowired
	private ExtensionReasonsRepository extensionReasonsRepository;

	@Override
	public ExtensionReasons reasons(@RequestBody ExtensionReasons extensionReasons) {
		ExtensionReasons extensionReasons2 = extensionReasonsRepository.save(extensionReasons);
		return extensionReasons2;
	}

	@Override
	public List<ExtensionReasons> getForAll() {
		// TODO Auto-generated method stub
		return extensionReasonsRepository.findAll();
	}
	
	@Override
	public Optional<ExtensionReasons> getParticularReason(int id) {
		return extensionReasonsRepository.findById(id);
	}

	@Override
	public ExtensionReasons updateReasons(int id, ExtensionReasons extensionReasons) {
		Optional<ExtensionReasons> extensionReasons2 =  extensionReasonsRepository.findById(id);
		if(extensionReasons2.isPresent()) {
			ExtensionReasons reasons = extensionReasons2.get();
			reasons.setReason(extensionReasons.getReason());
			return extensionReasonsRepository.save(reasons);
		}
		else {
			return null;
		}
		
	}

	@Override
	public void deleteById(int id) {
		extensionReasonsRepository.deleteById(id);
	}
	
	@Override
	public List<ExtensionReasons> getAll() {
		return extensionReasonsRepository.getAll();
	}
	@Override
	public ExtensionReasons getAllByReason() {
		return extensionReasonsRepository.getAllByReason("Not");
	}

	

}
