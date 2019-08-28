package SapeFeeCalcRavi.app.model;


public class CSVResult {
	
	@Override
	public String toString() {
		return "CSVResult [clientId=" + clientId + ", transactionType=" + transactionType + ", transactionDate="
				+ transactionDate + ", priorityFlag=" + priorityFlag + ", processingFee=" + processingFee + "]";
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getPriorityFlag() {
		return priorityFlag;
	}
	public void setPriorityFlag(String priorityFlag) {
		this.priorityFlag = priorityFlag;
	}
	public String getProcessingFee() {
		return processingFee;
	}
	public void setProcessingFee(String processingFee) {
		this.processingFee = processingFee;
	}
	private String clientId;
	private String transactionType;
	private String transactionDate;
	private String priorityFlag;
	private String processingFee;
	

}
