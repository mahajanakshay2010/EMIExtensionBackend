package com.LoanManagement.EMIExtension.DTO;

import java.util.Date;

public class EMIsMasterDTO {

    private int id;
    private int customerId;
    private int loanPlanId;
    private float emiAmount;
    private Date emiStart;
    private int numberOfEmis;
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private String customerPan;
    private String emiStatus;

    public EMIsMasterDTO(int id, int customerId, int loanPlanId, float emiAmount, Date emiStart, int numberOfEmis,
                         String customerName, String customerPhone, String customerAddress, String customerPan,
                         String emiStatus) {
        this.id = id;
        this.customerId = customerId;
        this.loanPlanId = loanPlanId;
        this.emiAmount = emiAmount;
        this.emiStart = emiStart;
        this.numberOfEmis = numberOfEmis;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.customerPan = customerPan;
        this.emiStatus = emiStatus;
    }

    public EMIsMasterDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(float emiAmount) {
        this.emiAmount = emiAmount;
    }

    public Date getEmiStart() {
        return emiStart;
    }

    public void setEmiStart(Date emiStart) {
        this.emiStart = emiStart;
    }

    public int getNumberOfEmis() {
        return numberOfEmis;
    }

    public void setNumberOfEmis(int numberOfEmis) {
        this.numberOfEmis = numberOfEmis;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPan() {
        return customerPan;
    }

    public void setCustomerPan(String customerPan) {
        this.customerPan = customerPan;
    }

    public String getEmiStatus() {
        return emiStatus;
    }

    public void setEmiStatus(String emiStatus) {
        this.emiStatus = emiStatus;
    }

    @Override
    public String toString() {
        return "EMIsMasterDTO{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", loanPlanId=" + loanPlanId +
                ", emiAmount=" + emiAmount +
                ", emiStart=" + emiStart +
                ", numberOfEmis=" + numberOfEmis +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerPan='" + customerPan + '\'' +
                ", emiStatus='" + emiStatus + '\'' +
                '}';
    }
}