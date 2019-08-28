package SapeFeeCalcRavi.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.bean.ColumnPositionMappingStrategy;

import SapeFeeCalcRavi.app.business.transaction.TransactionIntr;
import SapeFeeCalcRavi.app.business.transaction.impl.BusinessTransaction;
import SapeFeeCalcRavi.app.model.CSVResult;
import SapeFeeCalcRavi.app.model.CSVTransaction;
import SapeFeeCalcRavi.app.readfile.ReadInputFileInterface;
import SapeFeeCalcRavi.app.readfile.impl.CSVFileReader;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		final String CSV_INPUT_LOCATION = "C:\\Users\\Acer\\Desktop\\Study\\Sapient-Test\\Sample_Input.csv";
		/*
		 * File file = new File("resources\\Sample_Input.csv"); String absolutePath =
		 * file.getAbsolutePath(); System.out.println("Path : "+absolutePath);
		 */
		// name of generated csv
		final String CSV_OUTPUT_LOCATION = "Sample_Output.csv ";
		ReadInputFileInterface read = new CSVFileReader();
		List<String> output = new ArrayList<String>();
		List<CSVTransaction> csvTransaction = read.readInputFromFile(CSV_INPUT_LOCATION);
		// CSVTransaction columName=csvTransaction.get(0);
		TransactionIntr itr = new BusinessTransaction();
		List<CSVResult> resultData = itr.boughtAndPurchaseDate(csvTransaction);
		resultData.remove(0);
		// Output
		//System.out.println(resultData.toString());

		ColumnPositionMappingStrategy<CSVResult> mappingStrategy = new ColumnPositionMappingStrategy<CSVResult>();
		mappingStrategy.setType(CSVResult.class);
		

		// Write list to StatefulBeanToCsv object
		try {
			FileWriter writer = new FileWriter(CSV_OUTPUT_LOCATION);
			// Createing StatefulBeanToCsv object
			StatefulBeanToCsvBuilder<CSVResult> builder = new StatefulBeanToCsvBuilder<CSVResult>(writer);
			StatefulBeanToCsv<CSVResult> beanWriter = builder.build();
			beanWriter.write(resultData);
			writer.close();
			System.out.println("File Write Successfull");
		} catch (CsvDataTypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
