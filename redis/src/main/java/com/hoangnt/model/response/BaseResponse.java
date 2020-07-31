package com.hoangnt.model.response;

import com.hoangnt.constant.MessageCode;
import com.hoangnt.constant.AppConstants;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Optional;

@Getter
@Setter
public class BaseResponse<T> extends MessageCode implements IBaseResponse<T> {
    Timestamp timestamp;
    protected T data;

    public BaseResponse() {
        super(AppConstants.SUCCESS.getCode(), AppConstants.SUCCESS.getMessage());
    }

    public BaseResponse(T data) {
        this();
        this.data = data;
        this.timestamp = new Timestamp(System.currentTimeMillis());

        if (data == null) {

        }
    }

    public BaseResponse(MessageCode messageCode, T data) {
        this(data);
        Optional.ofNullable(messageCode).ifPresent((MessageCode rc) -> {
            this.code = rc.getCode();
            this.message = rc.getMessage();
        });
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean isEmpty() {
        return this.data == null;
    }

    @Override
    public T getData() {
        return data;
    }
}
