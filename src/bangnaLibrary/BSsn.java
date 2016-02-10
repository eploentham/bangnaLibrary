/*
 * To change this template; choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import com.bangna.usecase.connection.Persistent;

/**
 *
 * @author root
 */
public class BSsn extends Persistent{
    private String cardid="", id="", prefix_namet="", first_namet="", last_namet="", ssn_id="", hos_id="", date_start="", date_end="", birth_day="";

    public void initial(){
        cardid=""; id=""; prefix_namet=""; first_namet=""; last_namet=""; ssn_id=""; hos_id=""; date_start=""; date_end=""; birth_day="";
    }
    public String CardID() {
        return "card_id";
    }
    public String ID() {
        return "id";
    }
    public String Prefix_NameT() {
        return "prefix_namet";
    }
    public String First_Namet() {
        return "first_namet";
    }
    public String Last_Namet() {
        return "last_namet";
    }
    public String SSN_ID() {
        return "ssn_id";
    }
    public String Hos_ID() {
        return "hos_id";
    }
    public String Date_Start() {
        return "date_start";
    }
    public String Date_End() {
        return "date_end";
    }
    public String Birth_Day() {
        return "birth_day";
    }
    public String SSN() {
        return "b_ssn";
    }
    
    public String getCardID() {
        return cardid;
    }
    public void setCardID(String cardid) {        
        this.cardid = cardid;
    }

    public String getID() {
        return id;
    }
    public void setID(String id) {
        this.id = id;
    }
    
    public String getPrefixNameT() {
        return prefix_namet;
    }
    public void setPrefixNameT(String prefix_namet) {
        this.prefix_namet = prefix_namet;
    }

    public String getFirstNameT() {
        return first_namet;
    }
    public void setFirstNameT(String first_namet) {
        this.first_namet = first_namet;
    }

    public String getLastNameT() {
        return last_namet;
    }
    public void setLastNameT(String last_namet) {
        this.last_namet = last_namet;
    }

    public String getSSNID() {
        return ssn_id;
    }
    public void setSSNID(String ssn_id) {
        this.ssn_id = ssn_id;
    }

    public String getHOSID() {
        return hos_id;
    }
    public void setHOSID(String hos_id) {
        this.hos_id = hos_id;
    }

    public String getDateStart() {
        return date_start;
    }
    public void setDateStart(String date_start) {
        this.date_start = date_start;
    }

    public String getDateEnd() {
        return date_end;
    }
    public void setDateEnd(String date_end) {
        this.date_end = date_end;
    }

    public String getBirthDay() {
        return birth_day;
    }
    public void setBirthDay(String birth_day) {
        this.birth_day = birth_day;
    }
}
