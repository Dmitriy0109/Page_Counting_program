package com.DimBer.page_counting_program.service;

import java.io.File;
import java.util.List;

public interface FileCountService {
    List<File> listOfFiles(File path,String []types);
}
