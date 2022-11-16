package com.bitsco.vks.entity;

public class LstResolve {
    private String resolid;
    private String resolname;
    private String state;
    private String state_;

    public LstResolve (){
        super();
    }


    public void setResolid(String resolid) {
        this.resolid = resolid;
    }

    public String getResolid() {
        return resolid;
    }

    public void setResolname(String resolname) {
        this.resolname = resolname;
    }

    public String getResolname() {
        return resolname;
    }

//    public void setState(String state) {
//        this.state = state;
//        this.state_ = Utils.getTextFromBundle(null, Constants.CATEGORIES.State_Acc, this.state);
//
//    }

    public String getState() {
        return state;
    }

    public void setState_(String state_) {
        this.state_ = state_;
    }

//    public String getState_() {
//        return state_ = Utils.getTextFromBundle(null, Constants.CATEGORIES.State_Acc, this.state);
//    }
}
