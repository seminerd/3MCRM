package com.sapo.team03.MCRM.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.sapo.team03.MCRM.Exception.InvalidFileException;

public class XlsxHandler {

	private MultipartFile xlsxIn;
	private File xlsxOut;

	public File getXlsxOut() {
		return xlsxOut;
	}

	public void setXlsxOut(File xlsxOut) {
		this.xlsxOut = xlsxOut;
	}

	public XlsxHandler(MultipartFile xlsx) {
		super();
		this.xlsxIn = xlsx;
	}

	void validate() {
		if (!(this.xlsxIn.getOriginalFilename().endsWith(".xlsx"))) {
			throw new InvalidFileException();
		}
	}

	public void receiver() throws IOException {
		validate();
		xlsxOut = new File("E:\\" + this.xlsxIn.getOriginalFilename());
		xlsxOut.createNewFile();
		FileOutputStream fout = new FileOutputStream(xlsxOut);
		fout.write(this.xlsxIn.getBytes());
		fout.close();
	}

}
