package SapeFeeCalcRavi.app.readfile;

import java.util.List;

import SapeFeeCalcRavi.app.model.CSVTransaction;

public interface ReadInputFileInterface {
	public List<CSVTransaction> readInputFromFile(String filePath);
}
