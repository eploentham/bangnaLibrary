package bangnaLibrary;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author pop
 */
public class Ward {
    private String ward_id="", ward_namet="";
    public void initial(){
        ward_id=""; ward_namet="";
    }
    public String getWardNamet(){
        return ward_namet;
    }
    public void setWardNamet(String ward_namet){
        this.ward_namet = ward_namet;
    }
    public String getWardId(){
        return ward_id;
    }
    public void setWardId(String ward_id){
        this.ward_id = ward_id;
    }

}
