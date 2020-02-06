package com.test.excels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.test.parabank.BaseClass;


public class ExcelOperations extends BaseClass
{
FileInputStream fis=null;	
XSSFWorkbook book = null;
XSSFSheet sheet = null;
Class<?> className = ExcelOperations.class;
Iterator<Cell> cells;
@Test
public void excelOperations()
{
	try {
		System.out.println("./excelFiles/Test1.xlsx");
		fis = new FileInputStream("./excelFiles/Test1.xlsx");
	} catch (FileNotFoundException e) 
	{
		logging(className).error(e.getMessage());
	}
	catch(Exception e)
	{
		System.out.println("in catch"+ e.getMessage());
		logging(className).error(e.getMessage());
	}
	try {
		book = new XSSFWorkbook(fis);
	} catch (IOException e) {
		logging(className).error(e.getMessage());
	}
	
	sheet = book.getSheetAt(0);
	Iterator<Row> rows = sheet.iterator();
	while(rows.hasNext())
	{
		cells=rows.next().cellIterator();
		while(cells.hasNext())
		{
			System.out.print(cells.next()+" ");
		}
		System.out.println();
	}
}

	
}
