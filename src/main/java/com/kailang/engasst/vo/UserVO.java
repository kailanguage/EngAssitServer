package com.kailang.engasst.vo;

public class UserVO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CUSTOMER.USERNO
     *
     * @mbg.generated
     */
    private Integer userno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CUSTOMER.UNAME
     *
     * @mbg.generated
     */
    private String uname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CUSTOMER.UPASSWORD
     *
     * @mbg.generated
     */
    private String upassword;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CUSTOMER.USERNO
     *
     * @return the value of CUSTOMER.USERNO
     *
     * @mbg.generated
     */
    public Integer getUserno() {
        return userno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CUSTOMER.USERNO
     *
     * @param userno the value for CUSTOMER.USERNO
     *
     * @mbg.generated
     */
    public void setUserno(Integer userno) {
        this.userno = userno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CUSTOMER.UNAME
     *
     * @return the value of CUSTOMER.UNAME
     *
     * @mbg.generated
     */
    public String getUname() {
        return uname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CUSTOMER.UNAME
     *
     * @param uname the value for CUSTOMER.UNAME
     *
     * @mbg.generated
     */
    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CUSTOMER.UPASSWORD
     *
     * @return the value of CUSTOMER.UPASSWORD
     *
     * @mbg.generated
     */
    public String getUpassword() {
        return upassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CUSTOMER.UPASSWORD
     *
     * @param upassword the value for CUSTOMER.UPASSWORD
     *
     * @mbg.generated
     */
    public void setUpassword(String upassword) {
        this.upassword = upassword == null ? null : upassword.trim();
    }
}