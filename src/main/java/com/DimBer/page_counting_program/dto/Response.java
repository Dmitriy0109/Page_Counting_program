package com.DimBer.page_counting_program.dto;

public class Response {


    private String massage;

    public Response(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
