package com.ll.gramgram.base.rsData;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RsData<T> {
    private String resultCode;
    private String msg;
    private T data;
    private static final int DEFAULT_CODE = 1;

    public static <T> RsData<T> of(String resultCode, String msg, T data) {
        return new RsData<>(resultCode, msg, data);
    }

    public static <T> RsData<T> of(String resultCode, String msg) {
        return of(resultCode, msg, null);
    }

    public static <T> RsData<T> successOf(T data) {
        return of("S-%d".formatted(DEFAULT_CODE), "성공", data);
    }

    public static <T> RsData<T> failOf(T data) {
        return of("F-%d".formatted(DEFAULT_CODE), "실패", data);
    }

    public boolean isSuccess() {
        return resultCode.startsWith("S-");
    }

    public boolean isFail() {
        return !isSuccess();
    }
}
