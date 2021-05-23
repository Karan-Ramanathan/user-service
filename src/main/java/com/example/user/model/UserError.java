package com.example.user.model;

public class UserError {

  public UserError() {
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  private String code;

  public String getErrorMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  private String message;
}
