package com.pmc.final_project.bean;

import org.apache.ibatis.type.Alias;

@Alias("Paybean")
public class Paybean {
	private String pl_u_code;
    private String pl_pr_id;
    private String pl_qty;
    private String pl_price;
    private String pl_payment;

    public String getPl_u_code() {
        return pl_u_code;
    }

    public void setPl_u_code(String pl_u_code) {
        this.pl_u_code = pl_u_code;
    }

    public String getPl_pr_id() {
        return pl_pr_id;
    }

    public void setPl_pr_id(String pl_pr_id) {
        this.pl_pr_id = pl_pr_id;
    }

    public String getPl_qty() {
        return pl_qty;
    }

    public void setPl_qty(String pl_qty) {
        this.pl_qty = pl_qty;
    }

    public String getPl_price() {
        return pl_price;
    }

    public void setPl_price(String pl_price) {
        this.pl_price = pl_price;
    }

    public String getPl_payment() {
        return pl_payment;
    }

    public void setPl_payment(String pl_payment) {
        this.pl_payment = pl_payment;
    }
}
