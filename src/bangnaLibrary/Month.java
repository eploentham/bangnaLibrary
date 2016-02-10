package bangnaLibrary;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author pop
 */
public class Month {
    private String month_id="", month_namet="";
    public void initial(){
        month_id=""; month_namet="";
    }
    public String getMonthNamet(){
        return month_namet;
    }
    public void setMonthNamet(String month_namet){
        this.month_namet = month_namet;
    }
    public String getMonthId(){
        return month_id;
    }
    public void setMonthId(String month_id){
        this.month_id = month_id;
    }

}
