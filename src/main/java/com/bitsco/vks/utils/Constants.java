package com.bitsco.vks.utils;

public interface Constants {
    interface SPRING_SCAN {
        String VKS_PACKAGE_ENTITIES = "com.bitsco.vks.entity";
        String REPORT_PACKAGE_ENTITIES = "com.vnptpay.cms.bss.server.entity.digitalchannel";
        String PARTNER_PACKAGE_ENTITIES = "com.vnptpay.cms.bss.server.entity.partner";
        String RECONCILE_PACKAGE_ENTITIES = "com.vnptpay.cms.bss.server.entity.reconcile";

        String VKS_JPA_UNIT_NAME = "VKS_JPA_UNIT_NAME";
        String REPORT_JPA_UNIT_NAME = "REPORT_JPA_UNIT_NAME";
        String PARTNER_JPA_UNIT_NAME = "PARTNER_JPA_UNIT_NAME";
        String RECONCILE_JPA_UNIT_NAME = "RECONCILE_JPA_UNIT_NAME";
    }

    public enum CATEGORIES {
        OptionClosed("constants.categories.option-closed"),
        OptionCon1("constants.categories.option-contype1"),
        OptionCon("constants.categories.option-contype"),
        OptionDoc("constants.categories.option-doctype"),
        OptionDomain("constants.categories.option-domain"),
        YesNo("constants.categories.yes-no"),
        specialTransferOption("Constants.CATEGORIES.specialTransferOption"),
        StatusOption("Constants.CATEGORIES.StatusOption"),
        Trangthaipc("constants.categories.Trangthaipc"), //(da pc/chua pc - Y/N)
        Applyfor("constants.categories.applyfor"), //ap dung cho (vu an/bi can - A/C)
        applyfinish("constants.categories.applyfinish"), //giai doan chuan bi xet xu/giai doan xet xu (N/Y)
        appealtype("constants.categories.appealtype"), //khang cao/khong khang cao (Y/N)
        decitype("constants.categories.decitype"), //Loai QD (DC: dinh chi; TDC: tam dinh chi; GH: gia han; BPKCTT: bien phap khan cap tam thoi; BPBD: ap dung cac bien phap bao dam; XX: dua vu an ra xet xu; CVA: chuyen vu an; H: hoan)
        Usefor_against("constants.categories.usefor_against"), //cap khang nghi (Phuc tham/giam doc tham - G4/G5)
        Usefor_deci("constants.categories.usefor_deci"), //Giai doan ap dung (So tham/Phuc tham/giam doc tham - G3/G4/G5)
        UseFor("constants.categories.usefor"),
        userforlookup("constants.categories.userforlookup"),
        userforlookup_huyen("constants.categories.userforlookup_huyen"),
        Userfor_Lookup("constants.categories.userfor_lookup"),
        Userfor_Regi("constants.categories.userfor_regi"),
        CaseLevel("constants.categories.caselevel"),
        Code("constants.categories.code"),
        SetUnit("constants.categories.setunittime"),
        Penaltyfor("constants.categories.penaltyfor"),
        Penaltytype("constants.categories.penaltytype"),
        SetRight("constants.categories.setright"),
        Relationtype("constants.categories.relationtype"),
        Relationfor("constants.categories.relationfor"),
        Complaintfor("constants.categories.complaintfor"),
        SetunitTime("constants.categories.setunittime"),
        Cost("constants.categories.cost"),
        Urgent("constants.categories.urgent"),
        ReasonType("categories.choice"),
        CaseType("constants.categories.casetype"),
        Regiid("constants.categories.regiid"),
        Agafor("constants.categories.agafor"),
        Appeafor("constants.categories.appeafor"),
        SpcSpp("constants.categories.SPPSPC"),
        agalevel("constants.categories.agalevel"),
        SpcSppCT("constants.categories.SPPSPCCT"),
        gd_tt("constants.categories.gd_tt"),
        gd_tt_G4("constants.categories.gd_tt_G4"),
        FromTo("constants.categories.fromto"),
        FromToDetail("constants.categories.fromtodetail"),
        Sex("constants.categories.sex"),
        Sex_Accused("constants.categories.sex_Accused"),
        Status_Acc("constants.categories.status_Acc"),
        Name_Acc("constants.categories.name_Acc"),
        State_Acc("constants.categories.state_Acc"),
        SexLookup("constants.categories.sexLookup"),
        AccusedStatus("constants.categories.AccusedStatus"),
        RegisterStatus("constants.categories.regstatus"),
        RegisterClosed("constants.categories.regiclosed"),
        TrangThaiThuLy("constants.categories.trangthaithuly"),
        Indtype("constants.categories.indtype"),
        Donviraqd("constants.categories.donviraqd"),
        Phientoa_CentType("constants.categories.phientoa.centtype"), //Phien toa GDT-TT
        Quyetdinh_CentType("constants.categories.quyetdinh.jurytype"), //Quyet dinh GDT-TT
        GroupContent("spp_Faq.type"),
        NewsStatus("constants.categories.newsstt"),
        Months("constants.categories.reports.month"),
        HsSummaryReports("constants.categories.reports.hs.TH"),
        HsMonthlyReports("constants.categories.reports.hs.M"),
        SpcSppTranstype("constants.categories.Transtype"),
        typeRegister("constants.categories.typeRegister"),
        typeDecision("constants.categories.typeDecision"),
        typeAccused("constants.categories.typeAccused"),
        reportType("constants.categories.reportType"),
        CloseStatus("constants.categories.closestatus"),
        AssignType("constants.categories.AssignType"),
        SexAccused("constants.categories.B-G"),
        Modules("constants.categories.modules"),
        Option("constants.categories.option"),
        AgaLevel("constants.categories.agalevel"),
        ResolveOption("constants.categories.ResolveOption"),
        positionOption("constants.categories.PositionJury"),
        doctype("constants.categories.doctype"),
        booktype("constants.categories.booktype"),
        compresolresult("constants.categories.compresolresult"),
        Themes("constants.categories.themes"),
        ResolveDocument("constants.categories.resolvedocement"),
        typeDecisionGS("constants.categories.typeDecisionGS"),
        Level("constants.categories.level"),
        Userfor("constants.categories.userfor"),
        userfor_SPP("constants.categories.userfor_SPP"),
        typeCase("constants.categories.typeCase"),
        RegisterTransfer("constants.categories.regtransfer"),
        HeroinUnit("constants.categories.heroinunit"),
        SppCentenceStatus("constants.categories.centence.status"),
        StatusRegister("SppRegister.status"),
        appliedLaws("constants.categories.appliedLaws"),
        useforLaws("constants.categories.useforLaws"),
        branchJobs("constants.categories.branchJobs"),
        useforPenalties("constants.categories.useforPenalties"), //Trang thai thu ly
        useforPenalties_h("constants.categories.useforPenalties_h"),
        SppCentenceMovement("constants.categories.sppcentencemovement"),
        UpdateRpt("constants.categories.updaterpt"),
        status_NameYN("constants.categories.status_NameYN"),
        applyfor_name("constants.categories.applyfor_name"),
        applyfinish_name("constants.categories.applyfinish_name"),
        rptId("constants.categories.rptId"),
        status_Name("constants.categories.status_Name"),
        lstpol_name("constants.categories.lstpol_name"),
        ChangeidSSP("constants.categories.ChangeidSSP");

        private String prefix;

        CATEGORIES(String _prefix) {
            this.prefix = _prefix;
        }

        public String toString() {
            return this.prefix;
        }
    }

    public static final String SELECTIONMODE_SINGLE = "single";
    public static final String SELECTIONMODE_MULTIPLE = "multiple";
    /*
     * Resource Bundles
     */
    public static final String BUNDLE_QTHT = "qthtBundle";
    public static final String BUNDLE_QLA = "qlaBundle";
    public static final String BUNDLE_DM = "dmBundle";
    public static final String BUNDLE_HS = "hsBundle";
    public static final String BUNDLE_ERROR = "errBundle";


    /*
     * Quyen han
     */
    public static final String ROLE_ADMIN = "A";
    public static final String ROLE_LIST = "L";
    public static final String ROLE_USER = "U";

    public static final String UseFor_G1 = "G1";
    public static final String UseFor_G2 = "G2";
    public static final String UseFor_G3 = "G3";
    public static final String UseFor_G4 = "G4";
    public static final String UseFor_G5 = "G5";
    public static final String UseFor_G6 = "G6";
    public static final String AGAINST = "against";
    public static final String APPEAL = "appeal";

    /*  HungTD5 06/11/2012 */
    public static final String ApplyFor_BiCan = "A";
    public static final String ApplyFor_VuAn = "C";

    public static final String DONVIRAQD_SPC = "SPC";
    public static final String DONVIRAQD_SPP = "SPP";
    public static final String DONVIRAQD_POL = "POL";
    public static final String DONVIRAQD_POLICE = "02"; // c??ng an
    public static final String DONVIRAQD_ARMY = "04"; // qu??n ?????i
    public static final String DONVIRAQD_RANGER = "08"; // Ki???m l??m
    public static final String DONVIRAQD_CUSTOM = "06"; // H???i quan
    public static final String DONVIRAQD_BORGUA = "09"; // Bi??n ph??ng
    //start-thaopth 07/11/2012
    public static final String ID_EXIST = "id_exist";
    public static final String NAME_EXIST = "name_exist";
    //end-thaopth 07/11/2012

    /* HungTD5 10/11/2012: Trang thai thu ly */
    public static final int TRANGTHAITHULY_DATHULY = 1;
    public static final int TRANGTHAITHULY_CHUATHULY = 2;
    /* End */

    public static final String DML_INSERT = "I";
    public static final String DML_UPDATE = "U";
    public static final String DML_DELETE = "D";

    public static final String FOR_BICAN = "BC"; // b??????? can
    public static final String FOR_NTL = "NTL"; // ng???????????i th?????? l????
    public static final String FOR_BANAN = "CENTENCE";

    /**
     * TuTD2 24/12/2012: Tr???ng th??i quy???t ?????nh v??? vi???c
     */
    public static final String DECISION_G3 = ",0101,0107,0109,0131," + //G3
            "1101,1103,1107,1109,1131,1134," + //G3
            "2101,2103,2107,2109,2131,2134," + //G3
            "3103,3107,3109,3131," + //G3
            "4103,4107,4109,4131,"; //G3
    public static final String DECISION_G4 = ",0307,0311,0313,0315," + "1307,1311,1313,1315," + //G4
            "2307,2311,2313,2315," + "3307,3311,3313,3315," + //G4
            "4307,4311,4313,4315,"; //G4
    public static final String DECISION_G5 = ",0501,1501,2501,3501,4501,"; //G5

    // 28/12/2012 HungTD5: Danh muc Decision id (Tham kh???o t???i b???ng LST_DECITYPE)

    public enum DECITYPE {
        ExtendTime("GH"); //Quyet dinh gia han thoi han chuan bi xet xu
        private String decitype;

        DECITYPE(String decitype) {
            this.decitype = decitype;
        }

        public String toString() {
            return this.decitype;
        }
    }


    /* End */

    /* HungTD5: 06-01-2012 report file */

    public enum Reports {
        BAOCAOTHANG_1A_ACCUSED("BaoCaoThang\\G3_ACCUSED.rpt"), //M???u b??o c??o 1A - XXST - B??? can, bi c??o
        BAOCAOTHANG_1A_CASE("BaoCaoThang\\G3_CASE.rpt"), // M???u b??o c??o 1A - XXST - V??? ??n
        BAOCAOTHANG_1B_ACCUSED("BaoCaoThang\\G4_ACCUSED.rpt"), // M???u b??o c??o 1B - XXPT - B??? can, b??? c??o
        BAOCAOTHANG_1B_CASE("BaoCaoThang\\G4_CASE.rpt"), // M???u b??o c??o 1B - XXPT - V??? ??n
        BAOCAOTHANG_1C_ACCUSED("BaoCaoThang\\G5_ACCUSED.rpt"), // M???u b??o c??o 1C - XXGDT, TT - B??? can, b??? c??o
        BAOCAOTHANG_1C_CASE("BaoCaoThang\\G5_CASE.rpt"); // M???u b??o c??o 1C - XXGDT, TT - V??? ??n

        String reportFile;

        Reports(String reportFile) {
            this.reportFile = reportFile;
        }

        public String toString() {
            return this.reportFile;
        }

    }

    public static final String LAW_HINHSU_CODEID = "01";

    /* HungTD5 1/12/2012: Tr???ng th??i th??? l?? */

    public enum Register_closest {
        N("NEW"), //M??? th??? l??
        Newsppback("NEWSPPBACK"), //M??? th??? l??, vi???n ki???m s??t kh??ng ch???p nh???n tr??? h??? s??
        End("END"), //K???t th??c, c?? b???n ??n
        Closed("CLOSED"), //????nh ch???
        Pending("PENDING"), // T???m ????nh ch???
        Transferspc("TRANSFERSPC"), //B??n giao VKS kh??c
        Returnspp("RETURNSPP"), // Tr??? h??? s?? ??i???u tra b??? sung
        Unclose("UNCLOSE"), //M??? l???i th??? l??
        Newunfinish("NEWUNFINISH"); //M??? th??? l??, vi???n ki???m s??t kh??ng ch???p nh???n tr??? h??? s??

        private String closest;

        Register_closest(String closest) {
            this.closest = closest;
        }


        public String toString() {
            return this.closest;
        }
    }

    /* HungTD5:  ph???c v??? c???ng th???i gian th??? l?? v???i t???ng t??nh ch???t c???a ??n (nghi??m tr???ng, ??b nghi??m tr???ng...) */

    public enum CaseImportant {
        L0("L0"),
        L1("L1"),
        L2("L2"),
        L3("L3"),
        L4("L4"),
        G4("g4"),
        G5("g5");

        private String value;

        CaseImportant(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }

        /* HungTD5: lo???i ??n h??nh s??? */
        public static final String CASETYPE_HS = "hs";

        /* HungTD5: lo???i b??o c??o */
        public static final String REPORTYPE_MONTHLY = "monthly";

    }

    public static final Integer STATUS_ACTIVE = 1;
}
