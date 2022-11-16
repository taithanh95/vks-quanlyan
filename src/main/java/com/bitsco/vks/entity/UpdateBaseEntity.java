package com.bitsco.vks.entity;

import com.bitsco.vks.entity.SppRegister;
import com.bitsco.vks.utils.Utils;

public class UpdateBaseEntity {
    public UpdateBaseEntity() {
        super();
    }
    /* Javascript show: confirm delete, confirm update */
    public static final String JS_DLG_CONFIRM_WARNING_UPDATE = "confirmUpdateDialog.show();";
    public static final String JS_DLG_CONFIRM_WARNING_DELETE = "confirmDeleteDialog.show();";
    public static final String JS_DLG_CONFIRM_DELETE = "confirmDialog.show();";
    private String for_type; // dÃ¹ng Ä‘á»ƒ chá»�n bá»‹ can hay ngÆ°ï¿½?i thá»¥ lÃ½
    private SppRegister searchBean;
    private String casecode;
    private String casename;
    private boolean displayDataTable;
    private String pageBeForwardted;
    private String warningMessages;
    private boolean confirmedWarning;
    private boolean capNhapTTBtnDisabled;
    private String userfor;
    private String regicode; // thÃªm regicode Ä‘á»ƒ cáº­p nháº­t bá»‹ can
    // dacnv 25/09/2013 them hÃ m xá»­ lÃ½ nÃºt back á»Ÿ pháº§n CNTT
    private String previousPage;
    private boolean available; // kiá»ƒm tra xem Ä‘Ã£ gÃ¡n accu vÃ o vá»¥ Ã¡n chÆ°a
    private String setnum;
    /*
     * TuTï¿½?2 - check chuyá»ƒn Ã¡n
     **/
    //private SppSppSpp spp_sppspp;
    private String closests;
    private boolean thulybiKCKN = false;
    /*
     * END
     **/

    // end dacnv 25/09/2013

    public void setUserfor(String userfor) {
        this.userfor = userfor;
    }

    public String getUserfor() {
        return userfor;
    }

    public void setRegicode(String regicode) {
        this.regicode = regicode;
    }

    public String getRegicode() {
        return regicode;
    }


    public void setCasecode(String casecode) {
        this.casecode = casecode;
    }

    public String getCasecode() {
        return casecode;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public String getCasename() {
        return casename;
    }

    public void setSetnum(String setnum) {
        this.setnum = setnum;
    }

    public String getSetnum() {
        return setnum;
    }

    public void setClosests(String closests) {
        this.closests = closests;
    }

    public String getClosests() {
        return closests;
    }

//    public void setThulybiKCKN(boolean thulybiKCKN) {
//        this.thulybiKCKN = thulybiKCKN;
//    }
    public void setThulybiKCKN(String thulybiKCKN) {
        this.thulybiKCKN = Utils.toBoolean(thulybiKCKN);
    }

    public boolean isThulybiKCKN() {
        return thulybiKCKN;
    }
}
