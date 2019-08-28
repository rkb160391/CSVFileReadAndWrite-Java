package SapeFeeCalcRavi.app.readfile.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;

import SapeFeeCalcRavi.app.model.CSVTransaction;
import SapeFeeCalcRavi.app.readfile.ReadInputFileInterface;

public class CSVFileReader implements ReadInputFileInterface {

	
	public List<CSVTransaction> readInputFromFile(String filePath) {
		String row;
		BufferedReader csvReader;
		List<CSVTransaction>  columnData=new ArrayList<CSVTransaction>();
		try {
			csvReader = new BufferedReader(new FileReader(filePath));
			while ((row = csvReader.readLine()) != null) {
				
				CsvMapper mapper = new CsvMapper();
				Builder bootstrap = CsvSchema.builder();
				bootstrap
                .addColumn("externalTransactionId", CsvSchema.ColumnType.STRING)
                .addColumn("clientId", CsvSchema.ColumnType.STRING)
                .addColumn("securityId", CsvSchema.ColumnType.STRING)
                .addColumn("transactionType", CsvSchema.ColumnType.STRING)
                .addColumn("transactionDate", CsvSchema.ColumnType.STRING)
                .addColumn("marketValue", CsvSchema.ColumnType.STRING)
                .addColumn("priorityFlag", CsvSchema.ColumnType.STRING)
//                .addColumn("miles", CsvSchema.ColumnType.NUMBER)
                .build().withHeader();
				CsvSchema shema=bootstrap.build();
				
				MappingIterator<CSVTransaction> it = mapper.reader(CSVTransaction.class).with(shema).readValues(row);
				while (it.hasNext()){
					CSVTransaction row1 = it.next();
				    columnData.add(row1);
				}
				
			}
			
			/*
			 * for (int i=0;i<columnData.size(); i++) { if(i==0) {
			 * 
			 * }else { System.out.println(columnData.get(i)); } }
			 */
			csvReader.close();
			return columnData;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return columnData;
	}

}
