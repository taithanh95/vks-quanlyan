package com.bitsco.vks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdmFunctions {

    private String module;
    private String modulename; // Hiển thị khi view detail

    private String funcid;
    private String funcname;
    private String path;
    private String parentid;
    private String parentname; // Hiển thị tên chức năng cha khi view

    private int space; // Phục vụ cho việc hiển thị menu theo cấu trúc cây
    private int menuorder;

    private String groupid; // Phục vụ cho việc gán chức năng cho nhóm
    private String userid; // Phục vụ cho việc gán chức năng cho NSD

    private String userroles; // Phục vụ cho việc gán thao tác cho NSD
    private String grouproles; // Phục vụ cho việc gán thao tác cho nhóm
    private String submenu; // Phục vụ cho việc tạo dynamic menu

}
