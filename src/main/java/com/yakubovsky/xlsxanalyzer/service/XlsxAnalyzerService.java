package com.yakubovsky.xlsxanalyzer.service;

import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.TreeSet;

@Service
public class XlsxAnalyzerService {

    public int findNthMaxNumber(String filePath, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Number should be positive");
        }

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            return findNthMaxNumber(sheet, n);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int findNthMaxNumber(Sheet sheet, int n) {
        TreeSet<Integer> sortedSet = new TreeSet<>();

        for (Row row : sheet) {
            Integer num = getNumericCellValue(row.getCell(0));
            if (num != null) {
                sortedSet.add(num);
                if (sortedSet.size() > n) {
                    sortedSet.pollFirst();
                }
            }
        }

        if (sortedSet.size() < n) {
            throw new IllegalStateException("Not enough numbers in the file");
        }

        return sortedSet.first();
    }

    private Integer getNumericCellValue(Cell cell) {
        if (cell != null && cell.getCellType() == CellType.NUMERIC) {
            return (int) cell.getNumericCellValue();
        }
        return null;
    }
}
