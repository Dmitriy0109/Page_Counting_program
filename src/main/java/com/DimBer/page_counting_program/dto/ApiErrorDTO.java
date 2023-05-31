package com.DimBer.page_counting_program.dto;

public class ApiErrorDTO {


    private String massage;

    public ApiErrorDTO(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
