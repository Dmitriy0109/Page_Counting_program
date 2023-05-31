package com.DimBer.page_counting_program.counter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;

@Component
@Qualifier("PageCounter")
public class PdfCounter implements PageCounter {
    @Override
    public int getPagesCont(File file) {
        int pages = 0;
        if (file == null || !file.isFile()) {
            throw new RuntimeException("Файл не найден");
        }
        if (file.getName().endsWith(".pdf")) {
            try (PDDocument pdDocument = PDDocument.load(file)) {
                pages = (pdDocument.getNumberOfPages());
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return pages;
    }
}
