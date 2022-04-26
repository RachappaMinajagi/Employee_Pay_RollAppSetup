package com.bridgelabz.employeepayrollapp.DTO;

import lombok.Data;

@Data
/**
 * Created ResponseDTO class to get output in form of message along with data
 */
public class ResponseDTO {
    private String messsage;
    private Object data;

    /**
     * create a parametrized constructor
     */
    public ResponseDTO(String messsage, Object data) {
        super();
        this.messsage = messsage;
        this.data = data;
    }
}