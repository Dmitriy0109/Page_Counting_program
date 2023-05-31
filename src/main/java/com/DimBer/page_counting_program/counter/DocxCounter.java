package com.DimBer.page_counting_program.counter;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Component
@Qualifier("PageCounter")
public class DocxCounter implements PageCounter {
    @Override
    public int getPagesCont(File file) {
        int pageCount = 0;
        if (file == null || !file.isFile()) {
            throw new RuntimeException("Файл не найден");
        }
        if (file.getName().endsWith(".docx")) {
            try (XWPFDocument doc = new XWPFDocument(new FileInputStream(file))) {
                XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
                pageCount= extractor.getExtendedProperties().getPages();
            } catch (Exception e) {
                return 1;
            }
        }
        return pageCount;
    }
}
