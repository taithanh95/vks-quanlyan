package com.bitsco.vks.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DenouncedPersonDTO {

    private Long id;

    @NotBlank(message = "Họ và tên người báo tin không được bỏ trống")
    private String fullName;

    private Date dateOfBirth;

    private Integer yearOfBirth;

    private String job;

    private String workplace;

    private String address;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private Integer status;

    private Long denouncementId;
}
