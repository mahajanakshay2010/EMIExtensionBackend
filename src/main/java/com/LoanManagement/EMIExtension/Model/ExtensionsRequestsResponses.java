package com.LoanManagement.EMIExtension.Model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


@Entity
public class ExtensionsRequestsResponses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String response;
	private boolean isExtensionGranted;
	private Date responseDate;
	
	@OneToOne
	@JoinColumn(name="requestId")
	private ExtensionRequests extensionRequests;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public boolean getisExtensionGranted() {
		return isExtensionGranted;
	}

	public void setExtensionGranted(boolean isExtensionGranted) {
		this.isExtensionGranted = isExtensionGranted;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = new Date();
	}

	public ExtensionRequests getExtensionRequests() {
		return extensionRequests;
	}

	public void setExtensionRequests(ExtensionRequests extensionRequests) {
		this.extensionRequests = extensionRequests;
	}


	public ExtensionsRequestsResponses() {
		super();
	}

	public ExtensionsRequestsResponses(int id, String response, boolean isExtensionGranted, Date responseDate,
			ExtensionRequests extensionRequests) {
		super();
		this.id = id;
		this.response = response;
		this.isExtensionGranted = isExtensionGranted;
		this.responseDate = responseDate;
		this.extensionRequests = extensionRequests;
	}

	
	
	

	
	
	

}
