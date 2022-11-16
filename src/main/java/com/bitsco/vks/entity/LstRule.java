package com.bitsco.vks.entity;

public class LstRule {
    private String nameOfCaseType;
    private String nameOfUseFor;
    private String caseType;
    private String userFor;
    private String ruleTime;
    private String setUnit;
    private String nameOfSetUnit;
    private String thoihan_tu;
    private String thoihan_den;

    public LstRule() {
        super();
    }

//    public void setCaseType(String caseType) {
//        this.caseType = caseType;
//        this.nameOfCaseType = getNameOfCaseType();
//    }

    public String getCaseType() {
        return caseType;
    }

//    public void setUserFor(String useFor) {
//        this.userFor = useFor;
//        this.nameOfUseFor = getNameOfUseFor();
//    }

    public String getUserFor() {
        return userFor;
    }

    public void setRuleTime(String ruleTime) {
        this.ruleTime = ruleTime;
    }

    public String getRuleTime() {
        return ruleTime;
    }

//    public void setSetUnit(String setUnit) {
//        this.setUnit = setUnit;
//        this.nameOfSetUnit = getNameOfSetUnit();
//    }

    public String getSetUnit() {
        return setUnit;
    }

//    public Map<String, String> getListOfCaseType() {
//        return Utils.getCategoryFromBundle(null, Constants.CATEGORIES.CaseLevel);
//    }


//    public Map<String, String> getListOfUseFor() {
//        return Utils.getCategoryFromBundle(null, Constants.CATEGORIES.UseFor);
//    }

//    public Map<String, String> getListOfSetUnit() {
//        return Utils.getCategoryFromBundle(null, Constants.CATEGORIES.SetUnit);
//    }

    public void setNameOfCaseType(String nameOfCaseType) {
        this.nameOfCaseType = nameOfCaseType;
    }

//    public String getNameOfCaseType() {
//        return Utils.getTextFromBundle(null, Constants.CATEGORIES.CaseLevel, this.getCaseType());
//    }

    public void setNameOfSetUnit(String nameOfSetUnit) {
        this.nameOfSetUnit = nameOfSetUnit;
    }

//    public String getNameOfSetUnit() {
//        return Utils.getTextFromBundle(null, Constants.CATEGORIES.SetunitTime, this.getSetUnit());
//    }

    public void setNameOfUseFor(String nameOfUseFor) {
        this.nameOfUseFor = nameOfUseFor;
    }

//    public String getNameOfUseFor() {
//        return Utils.getTextFromBundle(null, Constants.CATEGORIES.UseFor, this.getUserFor());
//    }

    public void setThoihan_den(String thoihan_den) {
        this.thoihan_den = thoihan_den;
    }

    public String getThoihan_den() {
        return thoihan_den;
    }

    public void setThoihan_tu(String thoihan_tu) {
        this.thoihan_tu = thoihan_tu;
    }

    public String getThoihan_tu() {
        return thoihan_tu;
    }
}
