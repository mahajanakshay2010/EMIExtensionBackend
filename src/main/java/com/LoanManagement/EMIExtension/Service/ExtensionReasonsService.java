package com.LoanManagement.EMIExtension.Service;

import java.util.List;
import java.util.Optional;

import com.LoanManagement.EMIExtension.Model.ExtensionReasons;

public interface ExtensionReasonsService {
	
	ExtensionReasons reasons(ExtensionReasons extensionReasons);
	List<ExtensionReasons> getForAll();
	Optional<ExtensionReasons> getParticularReason(int id);
	ExtensionReasons updateReasons(int id,ExtensionReasons extensionReasons);
	void deleteById(int id);
	List<ExtensionReasons> getAll();
	ExtensionReasons getAllByReason();
}
