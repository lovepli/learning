package com.datastructure.learning.basicTest.实用帮助类.其他javabean注解;

/**
 * @author longwei
 * @date 2017/12/15.
 * @email 1807639399@qq.com
 */
public class MyException extends RuntimeException {

  private String message;

  public MyException(String message){
    super(message);
    this.message=message;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
