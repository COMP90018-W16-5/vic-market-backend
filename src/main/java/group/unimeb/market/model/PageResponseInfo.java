package group.unimeb.market.model;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "Paged response data wrapper")
public class PageResponseInfo<T> implements Serializable {
    public static final Integer CODE_SUCCESS_VALUE = 200;
    public static final Integer CODE_ERROR_VALUE = 1000;
    public static final String MSG_SUCCESS_VALUE = "success";
    public static final String MSG_ERROR_VALUE = "unknown error";

    @ApiModelProperty(required = true,
            value = "Response code",
            dataType = "int",
            example = "200",
            position = 0)
    private Integer code;
    @ApiModelProperty(required = true,
            value = "Response message",
            dataType = "string",
            example = "success",
            position = 1)
    private String msg;
    @ApiModelProperty(required = false,
            value = "Response data",
            position = 2)
    private T data;
    @ApiModelProperty(required = true,
            value = "Page number",
            dataType = "int",
            example = "1",
            position = 3)
    private Integer page;
    @ApiModelProperty(required = true,
            value = "Whether it has next page",
            dataType = "boolean",
            example = "true", position = 4)
    private boolean hasNext;
    @ApiModelProperty(required = true,
            value = "Whether it has pre page",
            dataType = "boolean",
            example = "true", position = 5)
    private boolean hasPrevious;

    public static <T> PageResponseInfo<T> buildSuccess() {
        return buildSuccess(null);
    }

    public static <T> PageResponseInfo<T> buildSuccess(T data) {
        return build(CODE_SUCCESS_VALUE, MSG_SUCCESS_VALUE, data);
    }

    public static <T> PageResponseInfo<T> buildFailure(Integer code, String msg) {
        return build(code, msg, null);
    }

    public static <T> PageResponseInfo<T> buildFailure(String msg) {
        return build(CODE_ERROR_VALUE, msg, null);
    }

    public static <T> PageResponseInfo<T> buildFailure() {
        return build(CODE_ERROR_VALUE, MSG_ERROR_VALUE, null);
    }

    private static <T> PageResponseInfo<T> build(Integer code, String msg, T data) {
        PageResponseInfo<T> responseInfo = new PageResponseInfo<>();
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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
