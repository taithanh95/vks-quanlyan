package com.bitsco.vks.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerificationInvestigationDTO {

    private Long id;

    private String verificationInvestigationCode;

    @NotNull(message = "Ngày yêu cầu xác minh là bắt buộc")
    private Date verificationDate;

    private String procuratorsRequest;

    private String procuratorsRequestId;

    @NotBlank(message = "Nội dung yêu cầu xác minh không được bỏ trống")
    private String contentRequest;

    private String result;

    private String note;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private Integer status;

    private Long denouncementId;
}
