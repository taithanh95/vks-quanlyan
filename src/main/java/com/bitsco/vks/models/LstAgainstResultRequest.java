package com.bitsco.vks.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LstAgainstResultRequest {
    private String sortField;
    private String sortOrder;

    private String action;

    private String resultid;
    private String resultname;
}
