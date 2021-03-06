package com.kailang.engasst.pojo;

import java.math.BigDecimal;

public class Wordlib {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column WORDLIB.WNO
     *
     * @mbg.generated
     */
    private Integer wno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column WORDLIB.WLEVEL
     *
     * @mbg.generated
     */
    private BigDecimal wlevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column WORDLIB.EN
     *
     * @mbg.generated
     */
    private String en;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column WORDLIB.CN
     *
     * @mbg.generated
     */
    private String cn;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WORDLIB.WNO
     *
     * @return the value of WORDLIB.WNO
     *
     * @mbg.generated
     */
    public Integer getWno() {
        return wno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WORDLIB.WNO
     *
     * @param wno the value for WORDLIB.WNO
     *
     * @mbg.generated
     */
    public void setWno(Integer wno) {
        this.wno = wno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WORDLIB.WLEVEL
     *
     * @return the value of WORDLIB.WLEVEL
     *
     * @mbg.generated
     */
    public BigDecimal getWlevel() {
        return wlevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WORDLIB.WLEVEL
     *
     * @param wlevel the value for WORDLIB.WLEVEL
     *
     * @mbg.generated
     */
    public void setWlevel(BigDecimal wlevel) {
        this.wlevel = wlevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WORDLIB.EN
     *
     * @return the value of WORDLIB.EN
     *
     * @mbg.generated
     */
    public String getEn() {
        return en;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WORDLIB.EN
     *
     * @param en the value for WORDLIB.EN
     *
     * @mbg.generated
     */
    public void setEn(String en) {
        this.en = en == null ? null : en.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column WORDLIB.CN
     *
     * @return the value of WORDLIB.CN
     *
     * @mbg.generated
     */
    public String getCn() {
        return cn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column WORDLIB.CN
     *
     * @param cn the value for WORDLIB.CN
     *
     * @mbg.generated
     */
    public void setCn(String cn) {
        this.cn = cn == null ? null : cn.trim();
    }
}