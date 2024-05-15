package com.allianz.test;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ZDemo2ExcelTest {

    public static void main(String[] args) throws IOException, FileNotFoundException {


        FileInputStream file=new FileInputStream("src/test/resources/Files/test_data/hrm_data.xlsx");

        XSSFWorkbook book=new XSSFWorkbook(file);

        XSSFSheet sheet= book.getSheet("invalidLoginTest");

        int rowCount=sheet.getPhysicalNumberOfRows();
        int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data=new Object[rowCount-1][cellCount];

        //write a logic to print all cell values one by one
        //add the values to two dim Object[][]

        DataFormatter format=new DataFormatter();
        for(int r=1;r<rowCount;r++)
        {
            for(int c=0;c<cellCount;c++)
            {
                data[r-1][c]=format.formatCellValue(sheet.getRow(r).getCell(c));
            }
        }
        System.out.println(data);


        book.close();
        file.close();
    }

}
