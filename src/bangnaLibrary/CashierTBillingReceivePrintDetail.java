/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import com.bangna.usecase.connection.Persistent;
//import java.io.Serializable;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;

/**
 *
 * @author root
 */
//@Entity
//@Table(name = "cashier_t_billing_receive_print_detail", catalog = "bangna5", schema = "public")
//@NamedQueries({
//    @NamedQuery(name = "CashierTBillingReceivePrintDetail.findAll", query = "SELECT c FROM CashierTBillingReceivePrintDetail c")})
public class CashierTBillingReceivePrintDetail extends Persistent{
//    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @Column(name = "t_billing_receive_print_detail_id", nullable = false, length = 255)
    private String tBillingReceivePrintDetailId="";
//    @Column(name = "row1", precision = 17, scale = 17)
    private Double row1=0.0;
//    @Column(name = "code", length = 255)
    private String code="";
//    @Column(name = "name1", length = 255)
    private String name1="";
//    @Column(name = "price", precision = 17, scale = 17)
    private Double price=0.0;
//    @Column(name = "t_billing_receive_print_id", length = 255)
    private String tBillingReceivePrintId="";
//    @Column(name = "node", length = 255)
    private String node="";
//    @Column(name = "sort_line1", precision = 17, scale = 17)
    private Double sortLine1=0.0;
//    @Column(name = "sort_line2", precision = 17, scale = 17)
    private Double sortLine2=0.0;
//    @Column(name = "sort_line3", precision = 17, scale = 17)
    private Double sortLine3=0.0;
//    @Column(name = "sort_line4", precision = 17, scale = 17)
    private Double sortLine4=0.0;
//    @Column(name = "sort_line5", precision = 17, scale = 17)
    private Double sortLine5=0.0;
//    @Column(name = "sort_line6", precision = 17, scale = 17)
    private Double sortLine6=0.0;

    public CashierTBillingReceivePrintDetail() {
    }
    public void initial(){
        tBillingReceivePrintDetailId="";
        row1=0.0;
        code="";
        name1="";
        price=0.0;
        tBillingReceivePrintId="";
        node="";
        sortLine1=0.0;
        sortLine2=0.0;
        sortLine3=0.0;
        sortLine4=0.0;
        sortLine5=0.0;
        sortLine6=0.0;
    }
    public String getCashierTBillingReceivePrintDetail() {
        return "cashier_t_billing_receive_print_detail";
      }
      public String getFTBillingReceivePrintDetailId() {
        return "t_billing_receive_print_detail_id";
      }
      public String getFRow1() {
        return "row1";
      }
      public String getFCode() {
        return "code";
      }
      public String getFName1() {
        return "name1";
      }
      public String getFPrice() {
        return "price";
      }
      public String getFTBillingReceivePrintId() {
        return "t_billing_receive_print_id";
      }
      public String getFNode() {
        return "node";
      }
      public String getFSortLine1() {
        return "sort_line1";
      }
      public String getFSortLine2() {
        return "sort_line2";
      }
      public String getFSortLine3() {
        return "sort_line3";
      }
      public String getFSortLine4() {
        return "sort_line4";
      }
      public String getFSortLine5() {
        return "sort_line5";
      }
      public String getFSortLine6() {
        return "sort_line6";
      }

    public CashierTBillingReceivePrintDetail(String tBillingReceivePrintDetailId) {
        this.tBillingReceivePrintDetailId = tBillingReceivePrintDetailId;
    }

    public String getTBillingReceivePrintDetailId() {
        return tBillingReceivePrintDetailId;
    }

    public void setTBillingReceivePrintDetailId(String tBillingReceivePrintDetailId) {
        this.tBillingReceivePrintDetailId = tBillingReceivePrintDetailId;
    }

    public Double getRow1() {
        return row1;
    }

    public void setRow1(Double row1) {
        this.row1 = row1;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTBillingReceivePrintId() {
        return tBillingReceivePrintId;
    }

    public void setTBillingReceivePrintId(String tBillingReceivePrintId) {
        this.tBillingReceivePrintId = tBillingReceivePrintId;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Double getSortLine1() {
        return sortLine1;
    }

    public void setSortLine1(Double sortLine1) {
        this.sortLine1 = sortLine1;
    }

    public Double getSortLine2() {
        return sortLine2;
    }

    public void setSortLine2(Double sortLine2) {
        this.sortLine2 = sortLine2;
    }

    public Double getSortLine3() {
        return sortLine3;
    }

    public void setSortLine3(Double sortLine3) {
        this.sortLine3 = sortLine3;
    }

    public Double getSortLine4() {
        return sortLine4;
    }

    public void setSortLine4(Double sortLine4) {
        this.sortLine4 = sortLine4;
    }

    public Double getSortLine5() {
        return sortLine5;
    }
    public void setSortLine5(Double sortLine5) {
        this.sortLine5 = sortLine5;
    }
    
    public Double getSortLine6() {
        return sortLine6;
    }
    public void setSortLine6(Double sortLine6) {
        this.sortLine6 = sortLine6;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (tBillingReceivePrintDetailId != null ? tBillingReceivePrintDetailId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof CashierTBillingReceivePrintDetail)) {
//            return false;
//        }
//        CashierTBillingReceivePrintDetail other = (CashierTBillingReceivePrintDetail) object;
//        if ((this.tBillingReceivePrintDetailId == null && other.tBillingReceivePrintDetailId != null) || (this.tBillingReceivePrintDetailId != null && !this.tBillingReceivePrintDetailId.equals(other.tBillingReceivePrintDetailId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "bangnaLibrary.CashierTBillingReceivePrintDetail[tBillingReceivePrintDetailId=" + tBillingReceivePrintDetailId + "]";
//    }

}
