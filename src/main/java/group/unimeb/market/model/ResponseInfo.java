package group.unimeb.market.model;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "Response data wrapper")
public class ResponseInfo<T> implements Serializable {
    public static final Integer CODE_SUCCESS_VALUE = 200;
    public static final Integer CODE_ERROR_VALUE = 1000;
    public static final String MSG_SUCCESS_VALUE = "success";
    public static final String MSG_ERROR_VALUE = "unknown error";

    @ApiModelProperty(required = true, value = "Response code", example = "200", position = 0)
    private Integer code;
    @ApiModelProperty(required = true, value = "Response message", example = "success", position = 1)
    private String msg;
    @ApiModelProperty(required = true, value = "Response data", position = 2)
    private T data;

    public static <T> ResponseInfo<T> buildSuccess() {
        return buildSuccess(null);
    }

    public static <T> ResponseInfo<T> buildSuccess(T data) {
        return build(CODE_SUCCESS_VALUE, MSG_SUCCESS_VALUE, data);
    }

    public static <T> ResponseInfo<T> buildFailure(Integer code, String msg) {
        return build(code, msg, null);
    }

    public static <T> ResponseInfo<T> buildFailure(String msg) {
        return build(CODE_ERROR_VALUE, msg, null);
    }

    public static <T> ResponseInfo<T> buildFailure() {
        return build(CODE_ERROR_VALUE, MSG_ERROR_VALUE, null);
    }

    private static <T> ResponseInfo<T> build(Integer code, String msg, T data) {
        ResponseInfo<T> responseInfo = new ResponseInfo<>();
        responseInfo.setCode(code);
        responseInfo.setMsg(msg);
        if (data != null) {
            responseInfo.data = data;
        }
        return responseInfo;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
