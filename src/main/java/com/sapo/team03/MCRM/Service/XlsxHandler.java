package com.sapo.team03.MCRM.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.sapo.team03.MCRM.DAO.LeadDAO;
import com.sapo.team03.MCRM.Exception.InvalidFileException;
import com.sapo.team03.MCRM.Model.Lead;

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

	void validate() {
		if (!(this.xlsxIn.getOriginalFilename().endsWith(".xlsx") || this.xlsxIn.getOriginalFilename().endsWith(".xlx")  )) {
			throw new InvalidFileException();
		}
	}

	public void receiveFile() throws IOException {
		validate();
		xlsxOut = new File("E:\\" + this.xlsxIn.getOriginalFilename());
		xlsxOut.createNewFile();
		FileOutputStream fout = new FileOutputStream(xlsxOut);
		fout.write(this.xlsxIn.getBytes());
		fout.close();
	}

	

}
