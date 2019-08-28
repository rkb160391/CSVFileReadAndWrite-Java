package SapeFeeCalcRavi.app.business.transaction;

import java.util.List;

import SapeFeeCalcRavi.app.model.CSVResult;
import SapeFeeCalcRavi.app.model.CSVTransaction;

public interface TransactionIntr {

	 List<CSVResult> boughtAndPurchaseDate(List<CSVTransaction> csvTransaction);

	
}
