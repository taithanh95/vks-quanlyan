package com.bitsco.vks.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 04/07/2022
 * Time: 10:11 AM
 */
@Data
public class MonitorEntity {
    /**
     * Bien dung chung
     */
    // autocomplate toa an
    private LstSPP atxtSppid; // chứa giá trị của autocomplete toa an
    private LstInspector atxtInsp; // chứa giá trị của autocomplete kiểm sát viên
    private LstLaw atxtLaw; // chứa giá trị của autocomplete tội danh
    private LstDecisionEntity atxtDeciid;

    //ma ten vu viec
    private String casecode;
    private String casename;

    //tu ngay-den ngay
    private Date fdate;
    private Date tdate;
    private Date fdateAgainst;
    private Date tdateAgainst;
    private Date fdateAppeal;
    private Date tdateAppeal;
    private Date fdateLaw;
    private Date tdateLaw;
    private Date fdatePenalty;
    private Date tdatePenalty;
    private Date fdateRegister;
    private Date tdateRegister;
    private Date todateRegister;
    private Date tdateAccused;
    private Date fdateDecision;
    private Date tdateDecision;
    private Date fdateTrans;
    private Date tdateTrans;
    private Date fdateVerify;
    private Date tdateVerify;

    private Date fdateAccused;
    //Biến trung gian để lấy ra tên tòa án xử lý cho giám sát
    private String sppname;

    //thong tin thu ly
    private String setnum; //so thu ly
    private Date indate; //ngay thu ly
    private Date setdate;
    private Date finishdate;
    private String sppid;
    private String caselevel;
    private String typeregister;
    private String rnumday; //Số ngày sắp hết hạn
    private String usefor;
    private String usefor_dis;
    private String caselevel_dis; //Dung de hien thi cap do vu an
    private boolean boospecial = false;
    private boolean boolawyer = false;
    private String special;
    private String lawyer;
    private String inspcode;
    //thông tin vụ án
    private String address;
    private String locaname;
    private String crimdate;
    private String numaccused;

    //Thong tin khang nghi
    private String againstcode;
    private String spcspp;
    private String forindate;
    private String spcsppname;
    private String forsetnum;
    private String regiclosed;

    //Thong tin khang cao
    private String appecode;
    private String appealid;
    private String regicode;
    private String appename;
    private String appealname;

    //thông tin quyết định
    private String deciid;
    private String typedeci;
    private String accuname;
    private String deciname;
    private Date utildate;
    private String lawname;
    private String userfor;
    private String numday_char;
    //thông tin bàn giao
    private String stagetrans; // loại hồ sơ nhận hoặc giao hồ sơ
    private String typetrans; // loại báo cáo chuyển nhận hồ sơ từ các đơn vị
    private LstSPP sppTransfer;
    private LstSPP sppReceive;
    private String transtype;
    private String transfrom;
    private String transto;
    private Date transdate;
    private String sender;
    private String receipter;

    //thông tin vụ án
    private String name; //tên vụ án
    private String spcname;
    private Date begin_indate; //ngày khởi tố
    private String namespp; //tên VKS
    private Date fromdate;
    private Date todate;
    //   private Date finishdate; //ngày kết thúc
    private String sobican;
    //Thong tin dieu luat
    private String lawid;
    private String item;
    private String point;
    private Date actdate;
    private String fullname;
    private String status;

    //Thong tin hinh phat

    private String penaltyid;
    private String penaltyname;
    private int numyear;
    private int nummonth;
    private int numday;
    private LstPenalty listPenalty;
    private long nummoney;
    private String suspended;
    private boolean suspendedboolean;

    private boolean boomovement = false;
    private String movement;

    //thông tin bị can bị cáo
    private String classify;
    private String accucode;
    private String birthday;
    private String sex;
    private String sexname;
    private String sex_txt;
    private String localdetail;
    private String natiname;
    private String conviction;
    private String offence;
    private String counname;
    private String namecasecode;
    private String identify;
    private String appliedLaw;
    private String appliedLaw_dis;
    private String useforLaw;
    private String useforLaw_dis;
    private String remark;
    private String useforPenalty;
    private String useforPenalty_dis;


    /**
     * **bien cua lawrelation
     **/
    private String relationname; //quan he phap luat
    private String compfinish; //nhung vu viec da ket thuc

    private boolean underlevel; //xet ca cap truc thuoc

    //Ẩn hiện cấp trưc thuộc

    private boolean treetype;

    private String crtuser;
    private Date crtdate;
    private String mdfuser;
    private Date mdfdate;

    private Long rowcount;
    private Integer rnum;

    private String code;
}
