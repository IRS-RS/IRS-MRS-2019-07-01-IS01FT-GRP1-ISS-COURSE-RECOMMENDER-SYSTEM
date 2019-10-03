package com.example.demo.readers;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Component;


@Component
public class WordReader {
	public String getText(File file) throws Exception {
		XWPFDocument docx=new XWPFDocument(new FileInputStream(file));
	       XWPFWordExtractor we = new XWPFWordExtractor(docx);
	       System.out.println(we.getText());
	       String t = we.getText();
	       we.close();
	       return t;
	}
}
