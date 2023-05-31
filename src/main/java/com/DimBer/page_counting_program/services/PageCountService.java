package com.DimBer.page_counting_program.services;

import com.DimBer.page_counting_program.dto.InputDataDTO;
import com.DimBer.page_counting_program.dto.OutputDataDTO;

public interface PageCountService {
    OutputDataDTO searchDocuments(InputDataDTO inputDataDTO);
}
