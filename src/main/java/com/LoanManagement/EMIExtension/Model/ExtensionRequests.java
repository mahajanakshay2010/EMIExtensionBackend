package com.LoanManagement.EMIExtension.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ExtensionRequests {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestId;
	private int emisId;
	private int customerId;
	private int loanPlanId;
	
	@ManyToOne
	@JoinColumn(name = "extensionReasonsId", referencedColumnName  = "id")
	public ExtensionReasons extensionReasons;
	
	private String otherReasonString;
	private Date requestRaisedOn;
	private Date etaPaymentDate;
	private String requestStatus;
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getEmisId() {
		return emisId;
	}
	public void setEmisId(int emisId) {
		this.emisId = emisId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getLoanPlanId() {
		return loanPlanId;
	}
	public void setLoanPlanId(int loanPlanId) {
		this.loanPlanId = loanPlanId;
	}
	
	public ExtensionReasons getExtensionReasons() {
		return extensionReasons;
	}
	public void setExtensionReasons(ExtensionReasons extensionReasons) {
		this.extensionReasons = extensionReasons;
	}
	public String getOtherReasonString() {
		return otherReasonString;
	}
	public void setOtherReasonString(String otherReasonString) {
		this.otherReasonString = otherReasonString;
	}
	public Date getRequestRaisedOn() {
		return requestRaisedOn;
	}
	public void setRequestRaisedOn(Date requestRaisedOn) {
		this.requestRaisedOn = requestRaisedOn;
	}
	public Date getEtaPaymentDate() {
		return etaPaymentDate;
	}
	public void setEtaPaymentDate(Date etaPaymentDate) {
		this.etaPaymentDate = etaPaymentDate;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	
	public ExtensionRequests(int requestId, int emisId, int customerId, int loanPlanId,
			ExtensionReasons extensionReasons, String otherReasonString, Date requestRaisedOn, Date etaPaymentDate,
			String requestStatus) {
		super();
		this.requestId = requestId;
		this.emisId = emisId;
		this.customerId = customerId;
		this.loanPlanId = loanPlanId;
		this.extensionReasons = extensionReasons;
		this.otherReasonString = otherReasonString;
		this.requestRaisedOn = requestRaisedOn;
		this.etaPaymentDate = etaPaymentDate;
		this.requestStatus = requestStatus;
	}
	public ExtensionRequests() {
		super();
	}
	
	
	
	
	

}
