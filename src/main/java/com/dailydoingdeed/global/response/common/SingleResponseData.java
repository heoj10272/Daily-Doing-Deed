package com.dailydoingdeed.global.response.common;

import lombok.Getter;

@Getter
public class SingleResponseData<T> extends ResponseData {
    private T data;

    private SingleResponseData(T data) {
        this.data = data;
    }

    public static <T> SingleResponseData of(T data) {
        return new SingleResponseData(data);
    }
}