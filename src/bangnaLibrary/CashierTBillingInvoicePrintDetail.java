/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaLibrary;

import com.bangna.usecase.connection.Persistent;

/**
 *
 * @author root
 */
public class CashierTBillingInvoicePrintDetail extends Persistent{
    public String tBillingInvoicePrintDetailId="";
    public Double row1=0.0;
    public String code="";
    public String name1="";
    public Double price=0.0;
    public String tBillingInvoicePrintId="";
    public String node="";
    public Double sortLine1=0.0;
    public Double sortLine2=0.0;
    public Double sortLine3=0.0;
    public Double sortLine4=0.0;
    public Double sortLine5=0.0;
    public Double sortLine6=0.0;

    public CashierTBillingInvoicePrintDetail() {
    }
    public void initial(){
        tBillingInvoicePrintDetailId="";
        row1=0.0;
        code="";
        name1="";
        price=0.0;
        tBillingInvoicePrintId="";
        node="";
        sortLine1=0.0;
        sortLine2=0.0;
        sortLine3=0.0;
        sortLine4=0.0;
        sortLine5=0.0;
        sortLine6=0.0;
    }
    public String getCashierTBillingInvoicePrintDetail() {
        return "cashier_t_billing_invoice_print_detail";
      }
      public String getFTBillingInvoicePrintDetailId() {
        return "t_billing_invoice_print_detail_id";
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
      public String getFTBillingInvoicePrintId() {
        return "t_billing_invoice_print_id";
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

    public CashierTBillingInvoicePrintDetail(String tBillingInvoicePrintDetailId) {
        this.tBillingInvoicePrintDetailId = tBillingInvoicePrintDetailId;
    }

    public String getTBillingInvoicePrintDetailId() {
        return tBillingInvoicePrintDetailId;
    }

    public void setTBillingInvoicePrintDetailId(String tBillingInvoicePrintDetailId) {
        this.tBillingInvoicePrintDetailId = tBillingInvoicePrintDetailId;
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

    public String getTBillingInvoicePrintId() {
        return tBillingInvoicePrintId;
    }

    public void setTBillingInvoicePrintId(String tBillingInvoicePrintId) {
        this.tBillingInvoicePrintId = tBillingInvoicePrintId;
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
//        hash += (tBillingInvoicePrintDetailId != null ? tBillingInvoicePrintDetailId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof CashierTBillingInvoicePrintDetail)) {
//            return false;
//        }
//        CashierTBillingInvoicePrintDetail other = (CashierTBillingInvoicePrintDetail) object;
//        if ((this.tBillingInvoicePrintDetailId == null && other.tBillingInvoicePrintDetailId != null) || (this.tBillingInvoicePrintDetailId != null && !this.tBillingInvoicePrintDetailId.equals(other.tBillingInvoicePrintDetailId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "bangnaLibrary.CashierTBillingInvoicePrintDetail[tBillingInvoicePrintDetailId=" + tBillingInvoicePrintDetailId + "]";
//    }

}
