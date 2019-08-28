package SapeFeeCalcRavi.app.model;

import java.util.Comparator;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CSVTransaction {
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String externalTransactionId;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String clientId;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String securityId;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String transactionType;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MMyy")
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String transactionDate;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String marketValue;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private String priorityFlag;

	public String getPriorityFlag() {
		return priorityFlag;
	}

	public void setPriorityFlag(String priorityFlag) {
		this.priorityFlag = priorityFlag;
	}

	public String getExternalTransactionId() {
		return externalTransactionId;
	}

	public void setExternalTransactionId(String externalTransactionId) {
		this.externalTransactionId = externalTransactionId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
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

	public String getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}
	/*
	 * Comparator<CSVTransaction> compareByClientgId = new
	 * Comparator<CSVTransaction>() {
	 * 
	 * @Override public int compare(CSVTransaction o1, CSVTransaction o2) { return
	 * o1.getClientId().compareTo(o2.getClientId()); } }; Comparator<CSVTransaction>
	 * compareBysecurityId = new Comparator<CSVTransaction>() {
	 * 
	 * @Override public int compare(CSVTransaction o1, CSVTransaction o2) { return
	 * o1.getSecurityId().compareTo(o2.getSecurityId()); } };
	 */

	@Override
	public String toString() {
		return "Transaction [externalTransactionId=" + externalTransactionId + ", clientId=" + clientId
				+ ", securityId=" + securityId + ", transactionType=" + transactionType + ", transactionDate="
				+ transactionDate + ", marketValue=" + marketValue + ", priorityFlag=" + priorityFlag + "]";
	}

}
