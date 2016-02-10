package bangnaLibrary;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class Claim {
    private String claim_id="", claim_namet="";
    public void initial(){
        claim_id=""; claim_namet="";
    }
    public String getClaimNamet(){
        return claim_namet;
    }
    public void setClaimNamet(String claim_namet){
        this.claim_namet = claim_namet;
    }
    public String getClaimId(){
        return claim_id;
    }
    public void setClaimId(String claim_id){
        this.claim_id = claim_id;
    }

}
