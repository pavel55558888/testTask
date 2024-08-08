package com.example.testeffectivemobile.dto;

import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class DtoError {
    private List<ObjectError> listError;

    public List<ObjectError> getListError() {
        return listError;
    }

    public void setListError(List<ObjectError> listError) {
        this.listError = listError;
    }
}
