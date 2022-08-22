package vip.epss.entity.vo.vo;
/*
* 状态码
* 1成功 0失败
* 提示信息
* 字符串
* 回显数据
* object对象
* */
public class MessageModel {

    private Integer code=1;//状态码 1成功 0失败
    private String msg="成功！";//提示信息
    private Object object;//回显对象

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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
