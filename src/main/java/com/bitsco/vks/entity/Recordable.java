package com.bitsco.vks.entity;

import java.util.Date;

public interface Recordable {

    Long getId();

    void setCreateUser(String username);

    void setCreateDate(Date date);

    void setUpdateUser(String username);

    void setUpdateDate(Date date);

    default void updateRecordInfo(String username) {
        if (this.getId() != null) {
            this.setUpdateUser(username);
            this.setUpdateDate(new Date());
        } else {
            this.setCreateUser(username);
            this.setCreateDate(new Date());
        }
    }

}
