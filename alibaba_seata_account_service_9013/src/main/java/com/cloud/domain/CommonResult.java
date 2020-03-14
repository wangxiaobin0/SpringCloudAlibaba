package com.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @date 2020/3/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private String errorCode;
    private String errorMessage;
    private T data;

    public CommonResult(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
