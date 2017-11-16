package cn.dto;

import cn.entity.Admin;

public class AdminDTO extends Admin {
    private int isDisabled;

    public int getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(int isDisabled) {
        this.isDisabled = isDisabled;
    }
}
