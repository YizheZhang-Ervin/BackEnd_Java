package com.ervin.EZSpring.WebEntrance.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="user query class")
public class UserQuery {
    @ApiModelProperty(value="page number")
    Integer pageNum = 1;

    @ApiModelProperty(value="page size")
    Integer pageSize = 10;

    @ApiModelProperty(value="user name")
    String userName;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
