package com.bitsco.vks.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseListRequest implements Serializable {
    public String sortField;
    public String sortOrder;
}
