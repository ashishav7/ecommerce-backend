package com.ecommerce.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private String status;
    private String messageCode;
    private String message;
}
