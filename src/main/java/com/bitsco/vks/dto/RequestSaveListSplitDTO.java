package com.bitsco.vks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestSaveListSplitDTO implements Serializable {
    private List<RequestSaveSplitDTO> sppcasesplit;
    private String choiceType;
    private String choice;
}
