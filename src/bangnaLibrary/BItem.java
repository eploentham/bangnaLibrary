package bangnaLibrary;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import com.bangna.usecase.connection.Persistent;

/**
 *
 * @author root
 */
public class BItem extends Persistent {
    public String bItemId="";
    public String itemNamet="", itemNumber="", itemCommonName="",itemTradeName="", itemStatusDoctor="",itemDescriptione="", itemNickname="";
    public String itemActive="";
    public Double itemPriceCost=0.0;
    public Double itemPriceSale=0.0;
    public String itemIdOld="";
    public String itemSpecified="", uom="";

    public BItem() {
    }
    public void initial(){
        bItemId="";
        itemNamet=""; itemNumber=""; itemCommonName="";itemTradeName=""; itemStatusDoctor="";itemDescriptione="";itemNickname="";
        itemActive="";
        itemPriceCost=0.0;
        itemPriceSale=0.0;
        itemIdOld="";
    }
    public String getBItem(){
        return "b_item";
    }
    public String getFBItemId(){
        return "b_item_id";
    }
    public String getFItemNamet(){
        return "item_namet";
    }
    public String getFItemActive(){
        return "item_active";
    }
    public String getFItemPriceCost(){
        return "item_price_cost";
    }
    public String getFItemPriceSale(){
        return "item_price_sale";
    }
    public String getFItemIdOld(){
        return "item_id_old";
    }
    public String getFItemCommonName(){
        return "item_common_name";
    }
    public String getFItemNumber(){
        return "item_number";
    }
    public String getFItemTradName(){
        return "item_trade_name";
    }
    public String getFItemStatusDoctor(){
        return "item_status_doctor";
    }
    public String getFItemDescriptione(){
        return "item_descriptione";
    }
    public String getFItemNickname(){
        return "item_nick_name";
    }
    public String getFItemSpecified(){
        return "item_specified";
    }

    public BItem(String bItemId) {
        this.bItemId = bItemId;
    }

    public String getBItemId() {
        return bItemId;
    }

    public void setBItemId(String bItemId) {
        this.bItemId = bItemId;
    }

    public String getItemNamet() {
        return itemNamet;
    }

    public void setItemNamet(String itemNamet) {
        this.itemNamet = itemNamet;
    }

    public String getItemActive() {
        return itemActive;
    }

    public void setItemActive(String itemActive) {
        this.itemActive = itemActive;
    }

    public Double getItemPriceCost() {
        return itemPriceCost;
    }

    public void setItemPriceCost(Double itemPriceCost) {
        this.itemPriceCost = itemPriceCost;
    }

    public Double getItemPriceSale() {
        return itemPriceSale;
    }

    public void setItemPriceSale(Double itemPriceSale) {
        this.itemPriceSale = itemPriceSale;
    }

    public String getItemIdOld() {
        return itemIdOld;
    }
    public void setItemIdOld(String itemIdOld) {
        this.itemIdOld = itemIdOld;
    }

    public String getItemCommonName() {
        return itemCommonName;
    }
    public void setItemCommonName(String itemCommonName) {
        this.itemCommonName = itemCommonName;
    }

    public String getItemTradeName() {
        return itemTradeName;
    }
    public void setItemTradeName(String itemTradeName) {
        this.itemTradeName = itemTradeName;
    }

    public String getItemNumber() {
        return itemNumber;
    }
    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }
    public String getItemStatusDoctor() {
        return itemStatusDoctor;
    }
    public void setItemStatusDoctor(String itemStatusDoctor) {
        this.itemStatusDoctor = itemStatusDoctor;
    }
    public String getItemDescriptione() {
        return itemDescriptione;
    }
    public void setItemDescriptione(String itemDescriptione) {
        this.itemDescriptione = itemDescriptione;
    }

    public String getItemNickname() {
        return itemNickname;
    }
    public void setItemNickname(String itemNickname) {
        this.itemNickname = itemNickname;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (bItemId != null ? bItemId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof BItem)) {
//            return false;
//        }
//        BItem other = (BItem) object;
//        if ((this.bItemId == null && other.bItemId != null) || (this.bItemId != null && !this.bItemId.equals(other.bItemId))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "bangnaintranet.table.BItem[bItemId=" + bItemId + "]";
    }

}
