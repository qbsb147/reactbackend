package com.kh.reactbackend.customException;

public class NonPageException extends RuntimeException {
    public NonPageException() {
        super("페이지를 불러오지 못했습니다.");
    }
    public NonPageException(String message) {
        super("페이지 오류 : " + message);
    }
}
