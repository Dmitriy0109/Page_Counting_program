package com.DimBer.page_counting_program.dto;


public class OutputDataDTO {
    private long documents;
    private long pages;

    public long getDocuments() {
        return documents;
    }

    public void setDocuments(long documents) {
        this.documents = documents;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public OutputDataDTO(long documents, long pages) {
        this.documents = documents;
        this.pages = pages;


    }
}
