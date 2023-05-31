package com.DimBer.page_counting_program.service.impl;

import com.DimBer.page_counting_program.counter.PageCounter;
import com.DimBer.page_counting_program.dto.InputDataDTO;
import com.DimBer.page_counting_program.dto.OutputDataDTO;
import com.DimBer.page_counting_program.service.FileCountService;
import com.DimBer.page_counting_program.service.PageCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.List;
import java.util.Set;

@Service
public class PageCountServiceImpl implements PageCountService {

    private final Set<PageCounter> pageCounter;


    private FileCountService fileCountService;
    @Autowired
    public PageCountServiceImpl(@Qualifier("PageCounter") Set<PageCounter>pageCounter, FileCountService fileCountService){
        this.pageCounter=pageCounter;
        this.fileCountService=fileCountService;
    }

    public OutputDataDTO document(InputDataDTO inputDataDTO) {
        if (inputDataDTO.getPath()==null) throw new RuntimeException("Некоректный путь");
        if (inputDataDTO.getTypes()==null) throw new RuntimeException("Укажите тип");
        int sumOfPages=0;
        List<File> files=fileCountService.listOfFiles(new File(inputDataDTO.getPath()),inputDataDTO.getTypes());
        for (File file:files){
            for (PageCounter page:pageCounter){
                sumOfPages+=page.getPagesCont(file);
            }
        }

        return new OutputDataDTO(files.size(),sumOfPages);
    }


}
