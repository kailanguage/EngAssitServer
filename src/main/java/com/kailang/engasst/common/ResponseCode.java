package com.kailang.engasst.common;

public enum ResponseCode {

    USERNAME_NOT_EMPTY(1, "用户名不能为空"),
    PASSWORD_NOT_EMPTY(2, "密码不能为空"),
    USERNAME_NOT_EXISTS(3, "账号不存在"),
    PASSWORD_ERROR(4, "密码错误"),
    PARAMTER_NOT_EMPTY(5, "参数不能为空"),
    USERNAME_EXISTS(6, "账号已注册"),
    REGISTER_FAIL(7, "注册失败"),
    NEED_LOGIN(8, "未登录"),
    USERNO_ILLEGAL(9, "账号ID不合法"),
    ILLEGAL_PARAM(40, "非法参数"),


    INSERT_FAIL(50,"插入失败"),
    UPDATE_FAIL(51,"更新失败"),
    SELECT_FAIL(52,"查询失败"),
    DELETE_FAIL(53,"删除失败"),

    NO_DATA(60,"无数据"),
    ;


    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
