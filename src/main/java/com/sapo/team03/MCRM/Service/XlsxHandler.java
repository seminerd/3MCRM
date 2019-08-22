package com.sapo.team03.MCRM.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.sapo.team03.MCRM.Exception.InvalidFileException;
import com.sapo.team03.MCRM.Marketing.Model.Customer;
import com.sapo.team03.MCRM.Utils.Utilities;

public class XlsxHandler {

	private MultipartFile xlsxIn;
	private File xlsxOut;

	public String getOutPath() {
		return xlsxOut.getPath();
	}

	public void setXlsxOut(File xlsxOut) {
		this.xlsxOut = xlsxOut;
	}

	public XlsxHandler(MultipartFile xlsx) {
		super();
		this.xlsxIn = xlsx;
	}

	public XlsxHandler() {
		// TODO Auto-generated constructor stub
	}

	void validate() {
		if (!(this.xlsxIn.getOriginalFilename().endsWith(".xlsx"))) {
			throw new InvalidFileException();
		}
	}

	public void receiveFile() throws IOException {
		validate();
		xlsxOut = new File("src/TEMP/" + LocalDate.now() + " " + this.xlsxIn.getOriginalFilename());

		xlsxOut.createNewFile();
		FileOutputStream fout = new FileOutputStream(xlsxOut);
		fout.write(this.xlsxIn.getBytes());
		Utilities.log("File has been saved to " + xlsxOut.getAbsolutePath());
		fout.close();
	}

	public String writeCustomersToFile(List<Customer> customers) throws IOException {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Customers list " + LocalDate.now());
		int rowNum = 1;

		for (Customer cust : customers) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(cust.getName());
			row.createCell(1).setCellValue(cust.getEmail());
			row.createCell(2).setCellValue(cust.getPhone());
			row.createCell(3).setCellValue("3MCRM");
		}
		FileOutputStream fileOut;
		String path = LocalDate.now() + " contacts.xlsx";
		try {
			
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		

	}

}
