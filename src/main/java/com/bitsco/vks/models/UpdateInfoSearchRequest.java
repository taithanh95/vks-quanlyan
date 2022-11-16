package com.bitsco.vks.models;

import lombok.Data;

@Data
public class UpdateInfoSearchRequest extends BaseListRequest {
    public String casecode;
    public String userfor;
}
