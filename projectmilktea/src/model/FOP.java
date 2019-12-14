/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class FOP {
    private String FOPID;
    private String FOPName;

    public FOP(String FOPID, String FOPName) {
        this.FOPID = FOPID;
        this.FOPName = FOPName;
    }

    public String getFOPID() {
        return FOPID;
    }

    public void setFOPID(String FOPID) {
        this.FOPID = FOPID;
    }

    public String getFOPName() {
        return FOPName;
    }

    public void setFOPName(String FOPName) {
        this.FOPName = FOPName;
    }
    
}
