package bangnaLibrary;

import com.bangna.usecase.connection.Persistent;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author pop
 */
public class TypeFoods extends Persistent{
    public String type_foods_id="";
    public String type_foods_namet="";
    public String foods_price="";
    public void initial(){
        type_foods_id=""; type_foods_namet=""; foods_price="";
    }
    public String getTypeFoodsNamet(){
        return type_foods_namet;
    }
    public void setTypeFoodsNamet(String type_foods_namet){
        this.type_foods_namet = type_foods_namet;
    }
    public String getTypeFoodsId(){
        return type_foods_id;
    }
    public void setTypeFoodsId(String type_foods_id){
        this.type_foods_id = type_foods_id;
    }
    public String getFoodsPrice(){
        return foods_price;
    }
    public void setFoodsPrice(String foods_price){
        this.foods_price = foods_price;
    }
}
