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


    private FileCountService countService;
    @Autowired
    public PageCountServiceImpl(@Qualifier("PageCounter") Set<PageCounter>pageCounter, FileCountService fileCountService){
        this.pageCounter=pageCounter;
        this.countService =fileCountService;
    }

    public OutputDataDTO document(InputDataDTO inputDataDTO) {
        if (inputDataDTO.getPath()==null) throw new RuntimeException("Путь пуст");
        if (inputDataDTO.getTypes()==null|| inputDataDTO.getTypes().length==0){
            throw new RuntimeException("Укажите тип");
        }
        int sumOfPages=0;
        List<File> files= countService.listOfFiles(new File(inputDataDTO.getPath()),inputDataDTO.getTypes());
        for (File file:files){
            for (PageCounter page:pageCounter){
                sumOfPages+=page.getPagesCont(file);
            }
        }

        return new OutputDataDTO(files.size(),sumOfPages);
    }


}
