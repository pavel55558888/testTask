package com.example.testeffectivemobile.main_app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
@Schema(name = "Dto ошибки", description = "При ошибке валидации, будет показано что, где и когда")
public class DtoError {
    private String error;
    @Schema(name = "Ошибка",description = "При валидации данных происходит какая-либо ошибка(Несоответсвие данных), данном поле она отражается")
    private List<ObjectError> listError;

    public List<ObjectError> getListError() {
        return listError;
    }

    public void setListError(List<ObjectError> listError) {
        this.listError = listError;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
