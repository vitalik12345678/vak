package com.task.vak.exceprion.handler;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ExceptionDetails {

    private  final HttpStatus STATUS;
    private  final String MESSAGE;
    private  final int HTTP_CODE;

}
