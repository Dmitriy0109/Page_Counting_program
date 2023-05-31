package com.DimBer.page_counting_program.controllers;

import com.DimBer.page_counting_program.dto.InputDataDTO;
import com.DimBer.page_counting_program.dto.OutputDataDTO;
import com.DimBer.page_counting_program.service.PageCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PageCountController {

    private PageCountService pageCountService;

    @Autowired
    public PageCountController(PageCountService pageCountService) {
        this.pageCountService = pageCountService;
    }


    @PostMapping("/getDocuments")
    public ResponseEntity<OutputDataDTO> getDocuments(@RequestBody InputDataDTO inputDataDTO) {

        return new ResponseEntity<>(pageCountService.document(inputDataDTO), HttpStatusCode.valueOf(200));
    }
}
