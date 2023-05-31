package com.DimBer.page_counting_program.service;

import com.DimBer.page_counting_program.dto.InputDataDTO;
import com.DimBer.page_counting_program.dto.OutputDataDTO;

public interface PageCountService {
    OutputDataDTO document(InputDataDTO inputDataDTO);
}
