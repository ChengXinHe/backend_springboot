package com.example.spring2.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;


//我们也可以把这个class变为record。
//record will
//private final, getter, public constructor, equals, hashcode
//and toString
public record ApiException(
        String message,
        Throwable throwable,
        HttpStatus httpStatus,
        ZonedDateTime zonedDateTime) {
}
//@Data
//public class ApiException {
//    private final String message;
//    private final Throwable throwable;
//    private final HttpStatus httpStatus;
//    private final ZonedDateTime zonedDateTime;
//}

// 因为有@data，所以可以删掉所有剩下的。在customerserivce中因为有定制化的getter 和 setter所以不能动。
//    public ApiException(String message,
//                        Throwable throwable,
//                        HttpStatus httpStatus,
//                        ZonedDateTime zonedDateTime) {
//        this.message = message;
//        this.throwable = throwable;
//        this.httpStatus = httpStatus;
//        this.zonedDateTime = zonedDateTime;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public Throwable getThrowable() {
//        return throwable;
//    }
//
//    public HttpStatus getHttpStatus() {
//        return httpStatus;
//    }
//
//    public ZonedDateTime getZonedDateTime() {
//        return zonedDateTime;
//    }
//
//    @Override
//    public String toString() {
//        return "ApiException{" +
//                "message='" + message + '\'' +
//                ", throwable=" + throwable +
//                ", httpStatus=" + httpStatus +
//                ", zonedDateTime=" + zonedDateTime +
//                '}';
//    }

