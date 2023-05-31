package com.DimBer.page_counting_program.services.impl;

import com.DimBer.page_counting_program.services.FileCountService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileCountServiceImpl implements FileCountService {
    @Override
    public List<File> listOfFiles(File path, String[] types) {
        List<File> files = new ArrayList<>();
        fileSelection(files, path, types);
        return files;
    }

    private void fileSelection(List<File> files, File path, String[] types) {
        if (!path.isDirectory()) {
            throw new RuntimeException("Путь не верен");
        }
        File[] allFiles = path.listFiles();
        if (allFiles.length != 0) {
            for (File file : allFiles) {
                if (file.isDirectory()) {
                    fileSelection(files, file, types);
                } else {
                    for (int i = 0; i < types.length; i++) {
                        if (file.getName().endsWith(types[i])) {
                            files.add(file);
                        }
                    }
                }
            }
        }

    }
}
