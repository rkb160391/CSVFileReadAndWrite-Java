package SapeFeeCalcRavi.app.business.transaction.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import SapeFeeCalcRavi.app.business.transaction.TransactionIntr;
import SapeFeeCalcRavi.app.model.CSVResult;
import SapeFeeCalcRavi.app.model.CSVTransaction;

public class BusinessTransaction implements TransactionIntr {

	public  List<CSVResult> boughtAndPurchaseDate(List<CSVTransaction> listData) {
		List<CSVTransaction> listDataSameDayBoughtAndPurchase=new ArrayList<CSVTransaction>();
		 List<CSVResult> intradayTranData=new ArrayList<CSVResult>();
		CSVResult csvResult;
		listDataSameDayBoughtAndPurchase.addAll(listData);
		for (int i=0;i<listData.size();i++) {
			
			if(i==0) {
				intradayTranData.clear();
			}
			//listDataSameDayBoughtAndPurchase.add(listData.get(i));
			listDataSameDayBoughtAndPurchase.remove(0);
			//System.out.println(listData.get(i));
			for (int j=i+1;j<listData.size();j++) {
				csvResult=new CSVResult();
			//	System.out.println(listDataSameDayBoughtAndPurchase.get(j));
				if(listData.get(i).getClientId().equals(listData.get(j).getClientId()) && 
						listData.get(i).getSecurityId().equals(listData.get(j).getSecurityId()) && 
						(listData.get(i).getTransactionDate().equals(listData.get(j).getTransactionDate()))
						&& (listData.get(i).getTransactionType()!=listData.get(j).getTransactionType())
						) {
					
					csvResult.setClientId(listData.get(i).getClientId());
					csvResult.setTransactionType(listData.get(i).getTransactionType());
					csvResult.setPriorityFlag(listData.get(i).getPriorityFlag());
					csvResult.setTransactionDate(listData.get(i).getTransactionDate());
					csvResult.setProcessingFee("10$");
					intradayTranData.add(csvResult);
					csvResult=null;
					//mapAllData.put("IntrdaDayTransData", intradayTranData);
					//System.out.println(endData);
				}else {
					csvResult.setClientId(listData.get(i).getClientId());
					csvResult.setTransactionType(listData.get(i).getTransactionType());
					csvResult.setPriorityFlag(listData.get(i).getPriorityFlag());
					csvResult.setTransactionDate(listData.get(i).getTransactionDate());
					if(listData.get(i).getPriorityFlag().equals("Y")) {
						csvResult.setProcessingFee("500$");
					}else if(listData.get(i).getPriorityFlag().equals("N") && 
							(listData.get(i).getTransactionType().equals("SELL") || 
									listData.get(i).getTransactionType().equals("WITHDRAW"))) {
						csvResult.setProcessingFee("100$");
					}else if(listData.get(i).getPriorityFlag().equals("N") && (listData.get(i).getTransactionType().equals("BUY")||listData.get(i).getTransactionType().equals("DEPOSIT"))) {
						csvResult.setProcessingFee("50$");
					}
					intradayTranData.add(csvResult);
					csvResult=null;
//					/System.out.println(normalTranData);
					//mapAllData.put("NormalTransData", normalTranData);
				}
				break;
			}
			
		}
		return intradayTranData;
	}
	
}
