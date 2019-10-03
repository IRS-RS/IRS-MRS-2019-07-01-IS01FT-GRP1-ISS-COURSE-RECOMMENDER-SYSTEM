package com.example.demo.readers;

import java.io.File;
import java.io.FileInputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.stereotype.Component;

@Component
public class PdfReader {
	public String getText(File file) throws Exception {
		PDDocument document = PDDocument.load(new FileInputStream(file));
        document.getClass();
        if(!document.isEncrypted()) {
        	PDFTextStripperByArea stripper = new PDFTextStripperByArea();
        	stripper.setSortByPosition(true);
        	PDFTextStripper tStripper = new PDFTextStripper();
        	String pdfInText=tStripper.getText(document);
        	tStripper=null;
        	document.close();
        	
        	return 	pdfInText;
        	}
        else {
        	document.close();
        	return "File format is not supported";
        	
        }
        	
        }
		
		
	}

