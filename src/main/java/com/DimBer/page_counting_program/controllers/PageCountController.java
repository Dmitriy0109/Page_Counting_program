package com.DimBer.page_counting_program.controllers;

import com.DimBer.page_counting_program.dto.InputDataDTO;
import com.DimBer.page_counting_program.dto.OutputDataDTO;
import com.DimBer.page_counting_program.services.PageCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PageCountController {

    private PageCountService pageCountService;

    @Autowired
    public PageCountController(PageCountService pageCountService) {
        this.pageCountService = pageCountService;
    }


    @PostMapping("/countFileAndPage")
    @ResponseStatus(HttpStatus.OK)
    public OutputDataDTO countFileAndPage(@RequestBody InputDataDTO inputDataDTO) {
        return pageCountService.searchDocuments(inputDataDTO);

    }
}
