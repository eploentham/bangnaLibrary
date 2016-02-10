package bangnaLibrary;

//import com.sun.org.apache.xml.internal.serialize.OutputFormat;
//import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class ChiNhso {
    //No generics\u000a

    List myData;
    Document dom;
    BBranch branch = new BBranch();
    Config1 config1 = new Config1();
    ChiTGovDB cgovdb = new ChiTGovDB();
    String CRLF="\r\n";
//    OutputFormat format;
    int i = 0x0A;
    private static final String NEWLINE = System.getProperty("line.separator");
    private static final String LINE_SEPARATOR_PATTERN ="\r\n|[\n\r\u2028\u2029\u0085]";
    String an="", nonDeductRoomBoard="",ProfFee="",Surcharge="0";

//    public ChiNhso() {
//        //create a list to hold the data
//        myData = new ArrayList();
//        //initialize the list
//        loadData();
//        //Get a DOM object
//        createDocument();
//
////        CRLF = NEWLINE;
//    }

//    public void runExample() {
//        System.out.println("Started .. ");
////        createDOMTree();
////        createDOMTree();
////        createXmlChiNhso("", "");
//        printToFile("","");
//        System.out.println("Generated file successfully.");
//    }

    /**
     * Add a list of books to the list
     * In a production system you might populate the list from a DB
     */
    private void loadData() {
        myData.add(new Book("Head First Java", "Kathy Sierra .. etc", "Java 1.5"));
        myData.add(new Book("Head First Design Patterns", "Kathy Sierra .. etc", "Java Architect"));
    }

    /**
     * Using JAXP in implementation independent manner create a document object
     * using which we create a xml tree in memory
     */
//    private void createDocument() {
//        //get an instance of factory
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        try {
//            //get an instance of builder
//            DocumentBuilder db = dbf.newDocumentBuilder();
//            //create an instance of DOM
//
////            String aaa = System.getProperty("line.separator");
//            dom = db.newDocument();
//            format = new OutputFormat(dom);
////            format.setLineSeparator(CRLF);
//        } catch (ParserConfigurationException pce) {
//            //dump it
//            System.out.println("Error while trying to instantiate DocumentBuilder " + pce);
//            System.exit(1);
//        }
//    }

    /**
     * The real workhorse which creates the XML structure
     */
//    private void createDOMTree() {
//        //create the root element <Books>
//        Element rootEle = dom.createElement("Books");
//        dom.appendChild(rootEle);
//        //No enhanced for
//        Iterator it = myData.iterator();
//        while (it.hasNext()) {
//            Book b = (Book) it.next();
//            //For each Book object  create <Book> element and attach it to root
//            Element bookEle = createBookElement(b);
//            rootEle.appendChild(bookEle);
//        }
//    }

    /**
     * Helper method which creates a XML element <Book>
     * @param b The book for which we need to create an xml representation
     * @return XML element snippet representing a book
     */
    private Element createBookElement(Book b) {
        Element bookEle = dom.createElement("Book");
        bookEle.setAttribute("Subject", b.getSubject());
        //create author element and author text node and attach it to bookElement
        Element authEle = dom.createElement("Author");
        Text authText = dom.createTextNode(b.getAuthor());
        authEle.appendChild(authText);
        bookEle.appendChild(authEle);
        //create title element and title text node and attach it to bookElement
        Element titleEle = dom.createElement("Title");
        Text titleText = dom.createTextNode(b.getTitle());
        titleEle.appendChild(titleText);
        bookEle.appendChild(titleEle);
        return bookEle;
    }

//    public void createXmlChiNhso(String branch_id, String cgov_id) {
//        Vector v_cgovi = new Vector();
//        Vector v_bi = new Vector();
//        String current_date = "", current_time = "", an="";
//        BillingInvoiceDB bill_invdb = new BillingInvoiceDB();
//        try {
//            
//            branch = config1.getBranch(branch_id);
//            current_date = config1.getDateDB("yyyyMMdd");//แก้ไขให้เป็น yyyyMMdd โดยให้ไปยึดที่ได้จะ system แทน
//            current_date= current_date.replaceAll("\\-", "");
//            current_time = config1.getTimeDB("hhmmss");
////            current_time = current_time.replace(":", "");
//            v_cgovi = cgovdb.getChiTGovItem(branch_id, cgov_id, "");
//            for (int i = 0; i <= v_cgovi.size() - 1; i++) {
//                try{
//                    createDocument();
//                    cgovdb.cgovi = (ChiTGovItem) v_cgovi.get(i);
//                    Element rootEle = dom.createElement("CIPN");
//                    dom.appendChild(rootEle);
//                    an = cgovdb.cgovi.getVisitAn();
//                    an = an.substring(0, an.length()-3);//แก้ไขให้ตรงตาม  สกส 9 degit
//                    
//
//                    Element headerEle = createHeaderElement(branch.getCipnId(), branch.getBranchNamet(), an, current_date+":" + current_time);
//                    rootEle.appendChild(headerEle);
//                    Element claimAuthEle = createClaimAuth(cgovdb.cgovi.getAuthCode(), cgovdb.cgovi.getAuthDt());
//                    rootEle.appendChild(claimAuthEle);
//
//                    String ipadt = getCsmbIPADT(branch_id, cgovdb.cgovi.getVisitVn(), cgovdb.cgovi.getPid());//ดึงตาม vn ก็ได้ ไม่ต้องดึงตามประเภทการรับชำระ
//                    Element iPADTEle = createIPADT(ipadt);
//                    rootEle.appendChild(iPADTEle);
//
//                    String ipdxop = getCsmbIPDxOp(branch_id, cgovdb.cgovi.getVisitId());//ดึงตาม vn ก็ได้ ไม่ต้องดึงตามประเภทการรับชำระ
//                    String ipdxop1[] = ipdxop.split("\\^");
//                    if(ipdxop1.length>=2) {
//                        Element iPDxOpEle = createIPDxOp(ipdxop1[1], ipdxop1[0]);
//                        rootEle.appendChild(iPDxOpEle);
//                    }
//
//                    v_bi = bill_invdb.listBillingInvoiceByPaymenyID(branch_id, cgovdb.cgovi.getVisitId(), cgovdb.cgovi.getTVisitPaymentId());//ดึงตาม vn แล้ว จะกรองตาม สิทธิ ดึงตาม billing_number ไม่ได้เพราะใน hopsital os ไม่มี คือออกบิลตาม extend
//                    for (int ii = 0; ii <= v_bi.size() - 1; ii++) {
//                        bill_invdb.tbi = (BillingInvoice) v_bi.get(ii);
//                        String inv = getCsmbInvoice(branch_id, cgovdb.cgovi.getVisitVn(), bill_invdb.tbi.getObjectId());//ต้องตาม invoice
//                        String inv1[] = inv.split("\\^");
//                        if(inv1.length>=4){
//                            Element invoices = createInvoices(bill_invdb.tbi.invoice_no, inv1[4], inv1[1], inv1[0], inv1[2], inv1[3]);
//                            rootEle.appendChild(invoices);
//                        }
//                    }
//
//                    String freeSchedule="",DeductRoomBoard="",nonDeductRoomBoard="",DeductMedDev="",nonDeductMedDev="";
//                    String cipn = getCbmsCIPNClaim(branch_id, cgovdb.cgovi.getVisitId());
//                    String cipn1[] = cipn.split("\\^");
//                    if(cipn1.length>=4){
//                        freeSchedule = cipn1[0];
//                        DeductRoomBoard = cipn1[1];
//                        nonDeductRoomBoard = cipn1[2];
//                        DeductMedDev = cipn1[3];
//                        nonDeductMedDev = cipn1[4];
//                    }
//                    Element cipnClaim = createCipnClaim(freeSchedule, DeductRoomBoard, nonDeductRoomBoard, DeductMedDev,nonDeductMedDev);
//                    rootEle.appendChild(cipnClaim);
//
//                    Element coInsurance = createCoInsurance("0", "0", "0", "0", "0");//รอก่อน ตอนนี้ยัง
//                    rootEle.appendChild(coInsurance);
//
//                    //nonDeductRoom ให้หาจาก ค่าห้องค่าอาหาร ส่วนที่ผู้ป่วยต้องจ่ายเอง
//                    //nonDeductMedDev ให้นำค่าจาก cipn ส่วน nonDeductMedDev มาได้เลย
//                    //ProfFee คือ df ทั้งหมด
//                    //Surcharge มาจาม bill group รหัส 91 ค่าธรรมเนียมพิเศษ (Surcharge) ส่วนที่ผู้ป่วยต้องจ่ายเอง
//                    //nonMedCare ค่าใช้จ่ายนอกการรักษาพยาบาล ส่วนที่ผู้ป่วยต้องจ่ายเอง  ยังไม่ต้องใส่
//                    nonDeductRoomBoard="0";
//                    String ProfFee = getSumDf(branch_id, cgovdb.cgovi.getVisitId());
//                    String Surcharge="0",nonMedCare="0";
//                    if(nonDeductRoomBoard==null)
//                        nonDeductRoomBoard="0";
//                    if(nonMedCare==null)
//                        nonMedCare="0";
//                    Element patCopay = createPatCopay(nonDeductRoomBoard, nonDeductMedDev, ProfFee, Surcharge, nonMedCare);
//                    rootEle.appendChild(patCopay);
//
//                    Element referral = createReferral();
//                    rootEle.appendChild(referral);
//
//                    printToFile(cgov_id, cgovdb.cgovi.getChiGovItemId());
//                }catch(Exception ex){
//                    Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    private String setAnFormatNhso(String an){
        if(an.length()>9){
            return an.substring(0, an.length()-3);//แก้ไขให้ตรงตาม  สกส 9 degit
        }else{
            return an;
        }
    }
    public void createXmlChiNhsoText(String branch_id, String cgov_id) {
        Vector v_cgovi = new Vector();
        Vector v_bi = new Vector();
        String current_date = "", current_time = "";
        BillingInvoiceDB bill_invdb = new BillingInvoiceDB();
        try {
            branch = config1.getBranch(branch_id);
            current_date = config1.getDateDB("yyyyMMdd");//แก้ไขให้เป็น yyyyMMdd โดยให้ไปยึดที่ได้จะ system แทน
            current_date= current_date.replaceAll("\\-", "");
            current_time = config1.getTimeDB("hhmmss");
//            current_time = current_time.replace(":", "");
            v_cgovi = cgovdb.getChiTGovItem(branch_id, cgov_id, "");
            for (int i = 0; i <= v_cgovi.size() - 1; i++) {
                try{
                    String text="";
                    cgovdb.cgovi = (ChiTGovItem) v_cgovi.get(i);
                    an = cgovdb.cgovi.getVisitAn();
                    an = setAnFormatNhso(an);//แก้ไขให้ตรงตาม  สกส 9 degit
                    nonDeductRoomBoard="";
                    text = "<CIPN>";

                    text += createHeaderText(branch.getCipnId(), branch.getBranchNamet(), an, current_date+":" + current_time);//20110326:102221
//                    text += createHeaderText(branch.getCipnId(), branch.getBranchNamet(), an, "20110326:102221");//20110326:102221
                    text+=createClaimAuthText(cgovdb.cgovi.getAuthCode(), cgovdb.cgovi.getAuthDt());
                    String ipadt = getCsmbIPADT(branch_id, cgovdb.cgovi.getVisitVn(), cgovdb.cgovi.getPid());//ดึงตาม vn ก็ได้ ไม่ต้องดึงตามประเภทการรับชำระ
                    text += createIPADTText(ipadt);

                    String ipdxop = getCsmbIPDxOp(branch_id, cgovdb.cgovi.getVisitId());//ดึงตาม vn ก็ได้ ไม่ต้องดึงตามประเภทการรับชำระ
                    String ipdxop1[] = ipdxop.split("\\^");
                    if(ipdxop1.length>=2) {
                        text += createIPDxOpText(ipdxop1[1], ipdxop1[0]);
                    }

                    v_bi = bill_invdb.listBillingInvoiceByPaymenyID(branch_id, cgovdb.cgovi.getVisitId(), cgovdb.cgovi.getTVisitPaymentId());//ดึงตาม vn แล้ว จะกรองตาม สิทธิ ดึงตาม billing_number ไม่ได้เพราะใน hopsital os ไม่มี คือออกบิลตาม extend
                    for (int ii = 0; ii <= v_bi.size() - 1; ii++) {
                        bill_invdb.tbi = (BillingInvoice) v_bi.get(ii);
                        String inv = getCsmbInvoice(branch_id, cgovdb.cgovi.getVisitVn(), bill_invdb.tbi.getObjectId());//ต้องตาม invoice
                        String inv1[] = inv.split("\\^");
                        if(inv1.length>=4){
                            text += createInvoicesText(bill_invdb.tbi.invoice_no, inv1[4], inv1[1], inv1[0], inv1[2], inv1[3]);
                        }
                    }

                    String freeSchedule="",DeductRoomBoard="",DeductMedDev="",nonDeductMedDev="";
                    String cipn = getCbmsCIPNClaim(branch_id, cgovdb.cgovi.getVisitId());
                    String cipn1[] = cipn.split("\\^");
                    if(cipn1.length>=4){
                        freeSchedule = cipn1[0];
                        DeductRoomBoard = cipn1[1];
//                        nonDeductRoomBoard = cipn1[2];
                        DeductMedDev = cipn1[3];
                        nonDeductMedDev = cipn1[4];
                    }
                    text += createCipnClaimText(freeSchedule, DeductRoomBoard, nonDeductRoomBoard, DeductMedDev,nonDeductMedDev);

                    text += createCoInsuranceText("0", "0", "0", "0", "0");//รอก่อน ตอนนี้ยัง

                    //nonDeductRoom ให้หาจาก ค่าห้องค่าอาหาร ส่วนที่ผู้ป่วยต้องจ่ายเอง
                    //nonDeductMedDev ให้นำค่าจาก cipn ส่วน nonDeductMedDev มาได้เลย
                    //ProfFee คือ df ทั้งหมด
                    //Surcharge มาจาม bill group รหัส 91 ค่าธรรมเนียมพิเศษ (Surcharge) ส่วนที่ผู้ป่วยต้องจ่ายเอง
                    //nonMedCare ค่าใช้จ่ายนอกการรักษาพยาบาล ส่วนที่ผู้ป่วยต้องจ่ายเอง  ยังไม่ต้องใส่
//                    nonDeductRoomBoard="0";
//                    String ProfFee = getSumDf(branch_id, cgovdb.cgovi.getVisitId());
                    String nonMedCare="0";
                    if(nonDeductRoomBoard==null){
                        nonDeductRoomBoard="0";
                    }
                    if(nonMedCare==null){
                        nonMedCare="0";
                    }
                    text += createPatCopayText(nonDeductRoomBoard, nonDeductMedDev, ProfFee, Surcharge, nonMedCare);

                    text += createReferralText();
//                    text+=CRLF+"</CIPN>";
                    text+=CRLF+"</CIPN>"+CRLF;

                    printToFileText(cgov_id, branch.getCipnId()+"-CIPN-"+an+"-"+current_date+current_time.substring(0, 4), text);
                }catch(Exception ex){
                    Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Element createHeaderElement(String authId, String authName, String docRef, String effectTime) {
        Element Ele = dom.createElement("Header");
//        dom.appendChild(Ele);
//        Ele.setAttribute("DocClass", "IPClaim");
        Element docClassEle = dom.createElement("DocClass");
        Text docClassT = dom.createTextNode("IPClaim");
        docClassEle.appendChild(docClassT);
        Ele.appendChild(docClassEle);

        Element docSysId = dom.createElement("DocSysID");
        docSysId.setAttribute("version", "1.0");
        Text cipn = dom.createTextNode("CIPN");
        docSysId.appendChild(cipn);
        Ele.appendChild(docSysId);

        Element servEle = dom.createElement("serviceEvent");
        Text adt = dom.createTextNode("ADT");
        servEle.appendChild(adt);
        Ele.appendChild(servEle);

        Element authIdEle = dom.createElement("authorID");
        Text authT = dom.createTextNode(authId);
        authIdEle.appendChild(authT);
        Ele.appendChild(authIdEle);

        Element authNameEle = dom.createElement("authorName");
        Text authNnameT = dom.createTextNode(authName);
        authNameEle.appendChild(authNnameT);
        Ele.appendChild(authNameEle);

        Element docRefEle = dom.createElement("DocumentRef");
        Text docRefT = dom.createTextNode(docRef);
        docRefEle.appendChild(docRefT);
        Ele.appendChild(docRefEle);

        Element effTimeEle = dom.createElement("effectiveTime");
        Text effTimeT = dom.createTextNode(effectTime);
        effTimeEle.appendChild(effTimeT);
        Ele.appendChild(effTimeEle);

        return Ele;
    }
    private String createHeaderText(String authId, String authName, String docRef, String effectTime) {
//        Element Ele = dom.createElement("Header");
        String txt="";
        txt=CRLF+"<Header>"+CRLF;
        txt+="<DocClass>IPClaim</DocClass>"+CRLF;
        txt+="<DocSysID version=\"1.0\">CIPN</DocSysID>"+CRLF;
        txt+="<serviceEvent>ADT</serviceEvent>"+CRLF;
        txt+="<authorID>"+authId+"</authorID>"+CRLF;
        txt+="<authorName>"+authName+"</authorName>"+CRLF;
        txt+="<DocumentRef>"+docRef+"</DocumentRef>"+CRLF;
        txt+="<effectiveTime>"+effectTime+"</effectiveTime>"+CRLF;
        txt+="</Header>";

        return txt;
    }

    private Element createClaimAuth(String authCode, String authDT) {
        Element Ele = dom.createElement("ClaimAuth");
        try {
//            dom.appendChild(Ele);
            Element authCodeEle = dom.createElement("AuthCode");
            Text authCodeT = dom.createTextNode(authCode);
            authCodeEle.appendChild(authCodeT);
            Ele.appendChild(authCodeEle);

            Element authDTEle = dom.createElement("AuthDT");
            Text authDTT = dom.createTextNode(authDT);
            authDTEle.appendChild(authDTT);
            Ele.appendChild(authDTEle);
        } catch (Exception ex) {
            Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ele;
    }
    private String createClaimAuthText(String authCode, String authDT) {
        String txt="";
        txt=CRLF+"<ClaimAuth>"+CRLF;
        txt+="<AuthCode>"+authCode+"</AuthCode>"+CRLF;
        txt+="<AuthDT>"+authDT+"</AuthDT>"+CRLF;
        txt+="</ClaimAuth>";
        return txt;
    }

    private Element createIPADT(String visitHn) {
        Element ipAdtEle = dom.createElement("IPADT");
        Text ipAdtT = dom.createTextNode(visitHn);
        ipAdtEle.appendChild(ipAdtT);
//        dom.appendChild(ipAdtEle);
        return ipAdtEle;
    }
    private String createIPADTText(String visitHn) {
        return CRLF+"<IPADT>"+visitHn+CRLF+"</IPADT>";
    }

    private Element createIPDxOp(String reccount, String data) {
        Element Ele = dom.createElement("IPDxOp");
//        dom.appendChild(Ele);

        Element ipdDxOpEle = dom.createElement("IPDxOp");
        ipdDxOpEle.setAttribute("Reccount", reccount);
        Text ipDxOpT = dom.createTextNode(data);
        ipdDxOpEle.appendChild(ipDxOpT);
        Ele.appendChild(ipdDxOpEle);
        return Ele;
    }
    private String createIPDxOpText(String reccount, String data) {
        return CRLF+"<IPDxOp Reccount =\""+reccount+"\">"+data+"</IPDxOp>";
    }

    private Element createInvoices(String invoice_number, String invoice_date, String reccount, String data, String total, String discount) {
        Element Ele = dom.createElement("Invoices");
//        dom.appendChild(Ele);

        Element invEle = dom.createElement("Invoice");
        Element invNumEle = dom.createElement("InvNumber");
        Text invNumT = dom.createTextNode(invoice_number);
        invNumEle.appendChild(invNumT);

        Element invDTEle = dom.createElement("InvDT");
        Text invDTT = dom.createTextNode(invoice_date);
        invDTEle.appendChild(invDTT);

        Element invItemsEle = dom.createElement("InvItems");
        invItemsEle.setAttribute("Reccount", reccount);
        Text invItemsT = dom.createTextNode(data);
        invItemsEle.appendChild(invItemsT);

        Element invTotalEle = dom.createElement("InvTotal");
        Text invTotalT = dom.createTextNode(total);
        invTotalEle.appendChild(invTotalT);

        Element invDiscountEle = dom.createElement("InvAddDiscount");
        Text invDiscountT = dom.createTextNode(discount);
        invDiscountEle.appendChild(invDiscountT);

        invEle.appendChild(invNumEle);
        invEle.appendChild(invDTEle);
        invEle.appendChild(invItemsEle);
        invEle.appendChild(invTotalEle);
        invEle.appendChild(invDiscountEle);
        Ele.appendChild(invEle);
        return Ele;
    }
    private String createInvoicesText(String invoice_number, String invoice_date, String reccount, String data, String total, String discount) {
        String txt="";
        txt=CRLF+"<Invoices>";
        txt+=CRLF+"<Invoice>"+CRLF;
        txt+="<InvNumber>"+invoice_number+"</InvNumber>"+CRLF;
        txt+="<InvDT>"+invoice_date+"</InvDT>"+CRLF;
        txt+="<InvItems Reccount=\""+reccount+"\">"+data+"</InvItems>"+CRLF;
        txt+="<InvTotal>"+total+"</InvTotal>"+CRLF;
        txt+="<InvAddDiscount>"+discount+"</InvAddDiscount>"+CRLF;
        txt+="</Invoice>"+CRLF+"</Invoices>";
        return txt;
    }

    private Element createCipnClaim(String feeSchedule, String deductRoom, String nonDeductRoom, String deductMedDev, String nonDeductMedDev) {
        Element Ele = dom.createElement("CIPNClaim");

        Element feeSchEle = dom.createElement("FeeScheduleItems");
        Text feeSchT = dom.createTextNode(feeSchedule);
        feeSchEle.appendChild(feeSchT);

        Element deductRoomEle = dom.createElement("DeductRoomBoard");
        Text deductRoomT = dom.createTextNode(deductRoom);
        deductRoomEle.appendChild(deductRoomT);

        Element nonDeductRoomEle = dom.createElement("nonDeductRoomBoard");
        Text nonDeductRoomT = dom.createTextNode(nonDeductRoom);
        nonDeductRoomEle.appendChild(nonDeductRoomT);

        Element deductMedDevEle = dom.createElement("DeductMedDev");
        Text deductMedDevT = dom.createTextNode(deductMedDev);
        deductMedDevEle.appendChild(deductMedDevT);
        
        Element nonDeductMedDevEle = dom.createElement("nonDeductMedDev");
        Text nonDeductMedDevT = dom.createTextNode(nonDeductMedDev);
        nonDeductMedDevEle.appendChild(nonDeductMedDevT);

        Ele.appendChild(feeSchEle);
        Ele.appendChild(deductRoomEle);
        Ele.appendChild(nonDeductRoomEle);
        Ele.appendChild(deductMedDevEle);
        Ele.appendChild(nonDeductMedDevEle);
        return Ele;
    }
    private String createCipnClaimText(String feeSchedule, String deductRoom, String nonDeductRoom, String deductMedDev, String nonDeductMedDev) {
        String txt="";
        txt=CRLF+"<CIPNClaim>"+CRLF;
        txt+="<FeeScheduleItems>"+feeSchedule+"</FeeScheduleItems>"+CRLF;
        txt+="<DeductRoomBoard>"+deductRoom+"</DeductRoomBoard>"+CRLF;
        txt+="<nonDeductRoomBoard>"+nonDeductRoom+"</nonDeductRoomBoard>"+CRLF;
        txt+="<DeductMedDev>"+deductMedDev+"</DeductMedDev>"+CRLF;
        txt+="<nonDeductMedDev>"+nonDeductMedDev+"</nonDeductMedDev>"+CRLF;
        txt+="</CIPNClaim>";
        return txt;
    }

    private Element createCoInsurance(String insuClass, String insuTotal, String insuRoom, String insuProf, String insuOther) {
        Element Ele = dom.createElement("CoInsurance");

        Element insuranceEle = dom.createElement("Insurance");
        Element insuClassEle = dom.createElement("InsuranceClass");
        Text insuClassT = dom.createTextNode(insuClass);
        insuClassEle.appendChild(insuClassT);

        Element insuTotalEle = dom.createElement("InsTotal");
        Text insuTotalT = dom.createTextNode(insuTotal);
        insuTotalEle.appendChild(insuTotalT);

        Element insuRoomEle = dom.createElement("InsRoomBoard");
        Text insuRoomT = dom.createTextNode(insuRoom);
        insuRoomEle.appendChild(insuRoomT);

        Element insuProfEle = dom.createElement("InsProfFee");
        Text insuProfT = dom.createTextNode(insuProf);
        insuProfEle.appendChild(insuProfT);

        Element insuOtherEle = dom.createElement("InsOther");
        Text insuOtherT = dom.createTextNode(insuOther);
        insuOtherEle.appendChild(insuOtherT);

        insuranceEle.appendChild(insuClassEle);
        insuranceEle.appendChild(insuTotalEle);
        insuranceEle.appendChild(insuRoomEle);
        insuranceEle.appendChild(insuProfEle);
        insuranceEle.appendChild(insuOtherEle);
        Ele.appendChild(insuranceEle);
        return Ele;
    }
    private String createCoInsuranceText(String insuClass, String insuTotal, String insuRoom, String insuProf, String insuOther) {
        String txt="";
        txt=CRLF+"<CoInsurance>";
        txt+=CRLF+"<Insurance>"+CRLF;
        txt+="<InsuranceClass>"+insuClass+"</InsuranceClass>"+CRLF;
        txt+="<InsTotal>"+insuTotal+"</InsTotal>"+CRLF;
        txt+="<InsRoomBoard>"+insuRoom+"</InsRoomBoard>"+CRLF;
        txt+="<InsProfFee>"+insuProf+"</InsProfFee>"+CRLF;
        txt+="<InsOther>"+insuOther+"</InsOther>"+CRLF;
        txt+="</Insurance>"+CRLF+"</CoInsurance>";
        return txt;
    }

    private Element createPatCopay(String nonDeductRoom, String nonDeductMedDev, String profFee, String surcharge, String nonMedCare) {
        Element Ele = dom.createElement("PatCopay");

        Element nonDeductRoomEle = dom.createElement("nonDeductRoomBoard");
        Text nonDeductRoomT = dom.createTextNode(nonDeductRoom);
        nonDeductRoomEle.appendChild(nonDeductRoomT);

        Element nondeductMedDevEle = dom.createElement("nonDeductMedDev");
        Text nondeductMedDevT = dom.createTextNode(nonDeductMedDev);
        nondeductMedDevEle.appendChild(nondeductMedDevT);

        Element profFeeEle = dom.createElement("ProfFee");
        Text profFeeT = dom.createTextNode(profFee);
        profFeeEle.appendChild(profFeeT);

        Element surchargeEle = dom.createElement("Surcharge");
        Text surchargeT = dom.createTextNode(surcharge);
        surchargeEle.appendChild(surchargeT);

        Element nonMedCareEle = dom.createElement("nonMedCare");
        Text mnonMedCareT = dom.createTextNode(nonMedCare);
        nonMedCareEle.appendChild(mnonMedCareT);

        Ele.appendChild(nonDeductRoomEle);
        Ele.appendChild(nondeductMedDevEle);
        Ele.appendChild(profFeeEle);
        Ele.appendChild(surchargeEle);
        Ele.appendChild(nonMedCareEle);
        return Ele;
    }
    private String createPatCopayText(String nonDeductRoom, String nonDeductMedDev, String profFee, String surcharge, String nonMedCare) {
        String txt="";
        txt=CRLF+"<PatCopay>";
        txt+=CRLF+"<nonDeductRoomBoard>"+nonDeductRoom+"</nonDeductRoomBoard>"+CRLF;
        txt+="<nonDeductMedDev>"+nonDeductMedDev+"</nonDeductMedDev>"+CRLF;
        txt+="<ProfFee>"+profFee+"</ProfFee>"+CRLF;
        txt+="<Surcharge>"+surcharge+"</Surcharge>"+CRLF;
        txt+="<nonMedCare>"+nonMedCare+"</nonMedCare>"+CRLF;
        return txt;
    }

    private Element createReferral() {
        Element Ele = dom.createElement("Referral");

        return Ele;
    }
    private String createReferralText() {
        return "<Referral/>";
    }

    /**
     * This method uses Xerces specific classes
     * prints the XML document to file.
     */
//    private void printToFile(String cgov_id,String filename) {
//        try {
//            int ch;
////            boolean success = (new File(branch.getPathfileCipn()+cgov_id)).mkdir();
////            if(!success) return;
//            StringBuilder strContent = new StringBuilder();
////            String filename1=branch.getPathfileCipn()+cgov_id+"//"+filename+".xml";
//            String filename1=branch.getPathfileCipn()+filename+".xml";
//            //print
//
//            format.setEncoding("TIS-620");
//            format.setIndenting(false);
//            format.setIndent(1);
////            format.setIndenting(true);
//            format.setLineSeparator("\r\n");
//            XMLSerializer serializer = new XMLSerializer(new FileOutputStream(new File(filename1)), format);
////            dom.createComment("<?EndNote HMAC=>");
////            serializer.endDocument();
//            serializer.serialize(dom);
//
//            //to generate output to console use this serializer
//            //XMLSerializer serializer = new XMLSerializer(System.out, format);
//            String endNote = "", tmp="", tmpMd5="";
////            ProcessingInstruction pi;
//            try {
//                char aa ;
//                File file = new File(filename1);
//                FileInputStream fin = null;
//
//
//                InputStream inputStream= new FileInputStream(file);
//                Reader reader = new InputStreamReader(inputStream,"TIS-620");
//
//
//
////                fin = new FileInputStream(file,"");
//                while( (ch = reader.read()) != -1){
//                    strContent.append((char)ch);
//                }
////                fin.close();
//                reader.close();
//
//                tmp = strContent.toString().replace("TIS-620", "windows-874");
//                tmp = tmp.replaceAll("&#xd;", System.getProperty("line.separator"));
////                tmpMd5 = tmp;
////                tmpMd5 = tmpMd5.replace("<?xml version='1.0' encoding='windows-874'?>", "");
//
//                endNote = AeSimpleMD5.MD5(tmp.substring(tmp.indexOf("?>")+3));
//                strContent.delete(0, strContent.length());
//                strContent.append(tmp);
//                strContent.append("<?EndNote HMAC=\"").append(endNote).append("\"?>");
//                byte[] steContent1 = strContent.toString().getBytes("TIS-620");
////                byte[] steContent1 = convertUTF8ToTis620(strContent.toString().getBytes());//&#xd;
//                FileOutputStream fos = new FileOutputStream(file);
//                fos.write(steContent1);
////                Writer out = new OutputStreamWriter(fos, "windows-874");
////                out.write(strContent.toString());
////                out.close();
//                fos.close();
////                pi = (ProcessingInstruction) dom.createProcessingInstruction("EndNote", "HMAC=\"" + aaa + "\"");
////                Element root = dom.getDocumentElement();
////                Element folks = (Element) root.getLastChild();
////                root.insertBefore(pi, folks);
////            }catch (NoSuchAlgorithmException ex) {
////                Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
//            }catch (IOException ex) {
//                Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
//            }catch (Exception ex) {
//                Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            //to generate a file output use fileoutputstream instead of system.out
////            XMLSerializer serializer = new XMLSerializer(new FileOutputStream(new File(filename+".xml")), format);
//
//        } catch (IOException ie) {
//            Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ie);
////            ie.printStackTrace();
//        }catch(Exception ex){
//            Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public static String md5( String source ) {
        try { 
            MessageDigest md = MessageDigest.getInstance( "MD5" );
            byte[] bytes = md.digest( source.getBytes() );
            return getString( bytes );
        } catch( Exception e ){
            e.printStackTrace();
            return null;
        }
    }
    private static String getString( byte[] bytes ) {
        StringBuffer sb = new StringBuffer();
        for( int i=0; i<bytes.length; i++ ){
            byte b = bytes[ i ];
            sb.append( ( int )( 0x00FF & b ) );
            if( i+1 <bytes.length ) {
                sb.append( "-" );
            }
        }
        return sb.toString();
    }
    private void printToFileText(String cgov_id,String filename, String data) {
        String filename1=branch.getPathfileCipn()+filename+".xml";
        String endNote = "", tmp="";
        try {
            config1.setDeleteFile(filename1);
            char aa ;
            File file = new File(filename1);
            FileInputStream fin = null;
            MessageDigest md = MessageDigest.getInstance("MD5");

            endNote = AeSimpleMD5.MD5(data);
//            endNote = md5(data);

            endNote = "<?EndNote HMAC=\""+endNote+"\"?>";
            FileOutputStream fos = new FileOutputStream(file);
            tmp = "<?xml version=\"1.0\" encoding=\"windows-874\"?>"+data+endNote;
            fos.write(tmp.getBytes("TIS-620"));
    //                Writer out = new OutputStreamWriter(fos, "windows-874");
    //                out.write(strContent.toString());
    //                out.close();
            fos.close();
        }catch (IOException ex) {
            Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex) {
            Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private byte[] convertUTF8ToTis620(byte[] encoded){
        String strUTF8="";
        byte[] theStringTis620 = null;
        try {
            strUTF8 = new String(encoded, "UTF-8");
            theStringTis620 = strUTF8.getBytes("TIS620");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return theStringTis620;
    }

//    private void printToFile(){
//        try {
//            //print
//            OutputFormat format = new OutputFormat(dom);
//            format.setIndenting(true);
//            //to generate output to console use this serializer
//            //XMLSerializer serializer = new XMLSerializer(System.out, format);
//
//            //to generate a file output use fileoutputstream instead of system.out
//            XMLSerializer serializer = new XMLSerializer(new FileOutputStream(new File("book.xml")), format);
//            serializer.serialize(dom);
//        } catch(IOException ie) {
//            ie.printStackTrace();
//        }
//    }

//    public static void main(String args[]) {
//        //create an instance
//        ChiNhso xce = new ChiNhso();
//        //run the example
//        xce.runExample();
//    }

    private String getDeptCsmb(String clinic_number, String dental_number) {
        if (dental_number.equals("25")) {// dental
            return "11";
        }
        if (clinic_number.equals("103") || clinic_number.equals("106") || clinic_number.equals("104") || clinic_number.equals("101")
                || clinic_number.equals("102") || clinic_number.equals("105")) {//อายุรกรรมต่างๆ
            return "01";
        } else if (clinic_number.equals("119") || clinic_number.equals("108")
                || clinic_number.equals("110") || clinic_number.equals("109")) {//ศัลยกรรม
            return "02";
        } else if (clinic_number.equals("111")) {//สูตินรีเวช
            return "03";
        } else if (clinic_number.equals("000")) {//นรีเวชกรรม
            return "04";
        } else if (clinic_number.equals("112")) {//กุมารเวช
            return "05";
        } else if (clinic_number.equals("113")) {//โสต ศอ นาสิก
            return "06";
        } else if (clinic_number.equals("114")) {//จักษุ
            return "07";
        } else if (clinic_number.equals("120")) {//ศัลยกรรมกระดูก
            return "08";
        } else if (clinic_number.equals("116")) {//จิตเวช
            return "09";
        } else if (clinic_number.equals("000")) {//รังสีวิทยา
            return "10";
        } else if (clinic_number.equals("08")) {//ทันตกรรม
            return "11";
        } else {
            return "12";
        }
    }

    private String getCsmbIPADT(String branch_id, String visit_vn, String pid) {
        // an|hn|IDTYPE|PIDPAT|TITLE|NAMEPAT|DOB|SEX|MARRIAGE|CHANGWAT|AMPHUR|NATION|DATEADM|TIMEADM|DATEDSC|TIMEDSC|LEAVEDAY|DCONFIRM|
        //DISCHS|DISCHT|ADM_W|DISCHWARD|DEPT|SVCTYPE|SVCCODE|UBCLASS|UCAREPLAN|PROJCODE|EVENTCODE|USERCODE
        //IDTYPE=ประเภทบัตร ใช้รหัสตามตารางที่ 23;PIDPAT=เลขที่บัตร ประชาชน/ปกส./ต่างด้าว/หนังสือเดินทาง/อื่นๆ;TITLE=คำนำหน้าชื่อ เช่น นาย, นาง, นส., ดช., ดญ.
        //NAMEPAT=ชื่อ?นามสกุลผู้ป่วย;DOB=วันเดือนปีเกิดของผู้ป่วยyyyymmdd คศ|SEX=เพศ 1=ชาย, 2=หญิง|CHANGWAT=รหัสจังหวัด ตามกระทรวงมหาดไทย|AMPHUR=รหัสอำเภอ ตามกระทรวงมหาดไทย
        //NATION=สัญชาติ ใช้รหัสตามตารางที่ 23|DATEADM=วันที่รับไว้ใน รพ.|TIMEADM=เวลาที่รับไว้ใน รพ. บันทึกเป็น ชม. นาที|DATEDSC=วันที่จำหน่าย|TIMEDSC=เวลาที่จำหน่าย บันทึกเป็น ชม. นาที
        //LEAVEDAY=จำนวนรวมวันลากลับบ้าน หน่วยเป็น วัน|
        //DCONFIRM=การยืนยันข้อมูล กรณี LOS > 180 วัน หรือ < 6 ชม. Y=ยืนยันN=ไม่ยืนยัน
        //DISCHS=สถานภาพการจำหน่าย ใช้รหัสตามตารางที่ 23|DISCHT=ประเภทการจำหน่าย ใช้รหัสตามตารางที่ 23|
        //ADM_W=น้ำหนักตัวในขณะที่เข้ารับการรักษาในโรงพยาบาล หน่วยเป็นกก. (kg.) ต้องมีในกรณีเด็กแรกเกิด อายุ <28 วัน
        //DISCHWARD=หอผู้ป่วยเมื่อจำหน่าย (ตามที่รพ. กำหนด)|DEPT=แผนกที่รักษาผู้ป่วยเป็นหลัก ใช้รหัสตามตารางที่ 23|SVCTYPE=รหัสระบุประเภทผู้ป่วยในIP = ผู้ป่วยในปกติ
        //SVCCODE=รหัสระบุกลุ่มย่อยของ SVCTYPE|UBCLASS=รหัสการมีสิทธิ์ต่างๆ สำหรับขรก. ที่เบิกกบก ใช้รหัส 31|
        //UCAREPLAN=รหัสการใช้สิทธิ์ สำหรับการใช้สิทธิ์ขรก. ที่เบิกกบก ใช้รหัส 10
        //PROJCODE=รหัสโครงการพิเศษ|EVENTCODE=รหัสเหตุการณ์พิเศษ |USERCODE=รหัสบันทึกพิเศษ (สำหรับรพ. ใช้)

        String status_marriage = "", ipadt = "", sql = "", visit_an = "", visit_hn = "", IDTYPE = "0", PIDPAT = "", TITLE = "", NAMEPAT = "", DOB = "";
        String SEX = "", MARRIAGE = "", CHANGWAT = "", AMPHUR = "", NATION = "", DATEADM = "", TIMEADM = "", DATEDSC = "", TIMEDSC = "", LEAVEDAY = "", DCONFIRM = "";
        String DISCHS = "", DISCHWARD = "", DEPT = "", SVCTYPE = "", ADM_W = "", SVCCODE = "", UBCLASS = "", UCAREPLAN = "", PROJCODE = "", EVENTCODE = "", USERCODE = "";
        String DISCHT = "";
        Connection conn;
        Statement st;
        TVisitVitalSignDB vsdb = new TVisitVitalSignDB();
        Vector vvs = new Vector();
        try {
            conn = config1.getConnectionHospital(branch_id);
            st = conn.createStatement();
            vsdb.tvvs = vsdb.getTVisitVitalSignByPK(branch_id, "", visit_vn, "visit_vn");
            sql = "Select tv.visit_hn, tv.visit_an, tp.patient_pid, fpp.patient_prefix_description, "
                    + "tp.patient_firstname || ' ' || tp.patient_lastname as fullname,"
                    + "case tp.patient_birthday when null then '' else tp.patient_birthday end,"
                    + "case tp.f_sex_id when null then '' else tp.f_sex_id end, "
                    + "case tp.f_patient_marriage_status_id when null then '' else tp.f_patient_marriage_status_id end, "
                    + "case tp.patient_changwat when null then '' else tp.patient_changwat end,"
                    + "case tp.patient_amphur when null then '' else tp.patient_amphur end,"
                    + "case tp.f_patient_nation_id when null then '' else tp.f_patient_nation_id end, "
                    + "case tv.visit_begin_visit_time when null then '' else tv.visit_begin_visit_time end,"
                    + "case tv.visit_financial_discharge_time when null then '' else tv.visit_financial_discharge_time end,"
                    + "case bvw.visit_ward_number when null then '' else bvw.visit_ward_number end , "
                    + "case bvc.visit_clinic_number when null then '' else bvc.visit_clinic_number end, "
                    + "case bsp.service_point_number when null then '' else bsp.service_point_number end, tv.t_visit_id "
                    + "From t_visit tv "
                    + "left join t_patient tp on tp.patient_hn = tv.visit_hn "
                    + "left join f_patient_prefix fpp on tp.f_patient_prefix_id = fpp.f_patient_prefix_id "
                    + "left join b_visit_ward bvw on bvw.b_visit_ward_id = tv.b_visit_ward_id "
                    + "left join b_visit_clinic bvc on bvc.b_visit_clinic_id = tv.b_visit_clinic_id "
                    + "left join b_service_point bsp on bsp.b_service_point_id = tv.b_service_point_id "
                    + "Where tv.visit_vn = '" + visit_vn + "' ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

//                visit_an = rs.getString("visit_an");
//                visit_an = setAnFormatNhso(visit_an);//แก้ไขให้ตรงตาม  สกส 9 degit
                visit_an = an;
                visit_hn = rs.getString("visit_hn");
//                PIDPAT = rs.getString("patient_pid");//pid
                PIDPAT = pid;//pid
                TITLE = rs.getString("patient_prefix_description");
                NAMEPAT = rs.getString("fullname");
                DOB = rs.getString("patient_birthday");
                DOB = config1.DateFormatShowHospital2DB(config1.DateFormatDB2Show(DOB, "ddMMyyyy"),"ddMMyyyy");
                DOB = DOB.replaceAll("\\-", "");
                SEX = rs.getString("f_sex_id");
                MARRIAGE = rs.getString("f_patient_marriage_status_id");
                CHANGWAT = rs.getString("patient_changwat");
                if(CHANGWAT.length()>2){
                    CHANGWAT = CHANGWAT.substring(0, 2);
                }else{
                    CHANGWAT = "";
                }
                AMPHUR = rs.getString("patient_amphur");
                if(AMPHUR.length()>2){
                    AMPHUR = AMPHUR.substring(0,4);
                }else{
                    AMPHUR = "";
                }
                NATION = rs.getString("f_patient_nation_id");
                DATEADM = rs.getString("visit_begin_visit_time");
                DATEADM = config1.DateFormatShowHospital2DB(config1.DateFormatDB2Show(DATEADM, "ddMMyyyy"),"ddMMyyyy");
                DATEADM = DATEADM.replaceAll("\\-", "");
                TIMEADM = rs.getString("visit_begin_visit_time");//ใส่ format
                TIMEADM = config1.TimeFormat(TIMEADM, "hhmm");
                DATEDSC = rs.getString("visit_financial_discharge_time");
                DATEDSC = config1.DateFormatShowHospital2DB(config1.DateFormatDB2Show(DATEDSC, "ddMMyyyy"),"ddMMyyyy");
                DATEDSC = DATEDSC.replaceAll("\\-", "");
                TIMEDSC = rs.getString("visit_financial_discharge_time");//ใส่ format
                TIMEDSC = config1.TimeFormat(TIMEDSC, "hhmm");
//                LEAVEDAY = rs.getString("patient_amphur");//จำนวนรวมวันลากลับบ้าน หน่วยเป็น วัน
                LEAVEDAY = "0";//ให้ใช้ค่านี้ไปก่อน
                DCONFIRM = "Y";//การยืนยันข้อมูล กรณี LOS > 180 วัน หรือ < 6 ชม. Y=ยืนยันN=ไม่ยืนยัน
                DISCHS = "4";//สถานภาพการจำหน่าย
                DISCHT = "1";//ประเภทการจำหน่าย ใช้รหัสตามตารางที่ 23   getTVisitVitalSign
//                ADM_W = vsdb.tvvs.getVisitVitalSignWeight();//น้ำหนักตัวในขณะที่เข้ารับการรักษาในโรงพยาบาล

                vvs = vsdb.getTVisitVitalSign(branch_id, "", visit_vn, "visit_vn");
                if(vvs.size()>0){
                    vsdb.tvvs = (TVisitVitalSign)vvs.get(0);
                    ADM_W = vsdb.tvvs.getVisitVitalSignWeight();
                }else{
                    ADM_W="0";
                }
                DISCHWARD = config1.StringNull(rs.getString("visit_ward_number"));//หอผู้ป่วยเมื่อจำหน่าย
                DEPT = getDeptCsmb(config1.StringNull(rs.getString("visit_clinic_number")), config1.StringNull(rs.getString("service_point_number")));//แผนกที่รักษาผู้ป่วยเป็นหลัก
                SVCTYPE = "";//รหัสระบุประเภทผู้ป่วยใน
                SVCCODE = "";//รหัสระบุกลุ่มย่อยของ SVCTYPE
                UBCLASS = "";//รหัสการมีสิทธิ์ต่างๆ สำหรับขรก. ที่เบิกกบก ใช้รหัส 31
                UCAREPLAN = "";//รหัสการใช้สิทธิ์ สำหรับการใช้สิทธิ์ขรก. ที่เบิกกบก ใช้รหัส 10
                PROJCODE = "";//รหัสโครงการพิเศษ
                EVENTCODE = "";//รหัสเหตุการณ์พิเศษ
                USERCODE = "";//รหัสบันทึกพิเศษ (สำหรับรพ. ใช้)
            }
            rs.close();
            conn.close();
            ipadt = CRLF+visit_an + "|" + visit_hn + "|" + IDTYPE + "|" + PIDPAT + "|" + TITLE + "|" + NAMEPAT + "|" + DOB + "|" + SEX + "|" + MARRIAGE + "|" + CHANGWAT + "|"
                    + AMPHUR + "|" + NATION + "|" + DATEADM + "|" + TIMEADM + "|" + DATEDSC + "|" + TIMEDSC + "|" + LEAVEDAY + "|" + DCONFIRM + "|" + DISCHS + "|" + DISCHT + "|"
                    + ADM_W + "|" + DISCHWARD + "|" + DEPT + "|" + SVCTYPE + "|" + SVCCODE + "|" + UBCLASS + "|" + UCAREPLAN + "|" + PROJCODE + "|" + EVENTCODE + "|" + USERCODE;
        } catch (Exception ex) {
            Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ipadt;
        //IDTYPE= 0 = ประชาชน/ปกส. 	1 = ต่างด้าว	2 = อนุญาตฯ	3 = Passport	9 = อื่นๆ
        //SEX=เพศ 1=ชาย, 2=หญิง      DOB,DATEADM=วันเดือนปีเกิดของผู้ป่วยyyyymmdd คศ,TIMEADM=HHMMSS
        //status marriage 1 = โสด	2 =  สมรส	3 = หม้าย/หย่า	4 = อื่นๆ
        //NATION 44 = จีน	45 = อินเดีย	46 = เวียดนาม	48 = พม่า 56 = ลาว	57 = กัมพูชา	97 = อื่นๆ	99 = ไทย
        //DISCHS 1 = Complete recovery	2 = Improved 3 = Not improved	4 = Normal delivery	5 = Undelivery	6 = Normal child d/c with mother	7 = Normal child d/c separately	8 = Stillbirth	9 = Dead
        //DISCHT 1 = With approval	2 = Against advice	3 = Escape	4 = By transfer	5 = Other	8 = Dead autopsy	9 = Dead no autopsy
        //DEPT 01 = อายุรกรรม	02 = ศัลยกรรม	03 = สูติกรรม	04 = นรีเวชกรรม	05 = กุมารเวช	06 = โสต ศอ นาสิก	07 = จักษุ	08 = ศัลยกรรมกระดูก	09 = จิตเวช	10 = รังสีวิทยา	11 = ทันตกรรม	12 = อื่นๆ
    }

    private String getCsmbIPDxOp(String branch_id, String visitId) {
        //AN=|CLASS=ประเภทของรหัสการวินิจฉัย/หัตถการ	D = รหัสการวินิจฉัย	P = รหัสหัตถการ
        //SUBCLASS=ชนิดของรหัสการวินิจฉัย/หัตถการ ใช้รหัสตามตารางที่ 17|CODE=รหัสการวินิจฉัยและสาเหตุภายนอก ใช้ ICD-10 หรือ ICD-10-TM
        //DR=แพทย์เจ้าของไข้ กรณีเป็นรหัสการวินิจฉัย หรือแพทย์ผู้ทำหัตถการ กรณีเป็นรหัสหัตถการ|DATEINDT3วันเวลาที่เริ่มทำหัตถการ
        //DATEOUT=วันเวลาที่หัตถการสิ้นสุด

        String ipdxop = "", sql = "", AN = "", CLASS = "", SUBCLASS = "", CODE = "", DR = "", DATEIN = "", DATEOUT = "";
        String time="";
        Integer i = 0;
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionHospital(branch_id);
            st = conn.createStatement();
            sql = "Select icd9.diag_icd9_icd9_number,icd9.diag_icd9_start_time,icd9.diag_icd9_finish_time,icd9.diag_icd9_staff_doctor, "
                    + "tv.visit_an,be.employee_number,f_diagnosis_operation_type_id "
                    + "From t_diag_icd9 icd9 "
                    + "left join t_visit tv on tv.t_visit_id = icd9.diag_icd9_vn "
                    + "left join b_employee be on be.b_employee_id = icd9.diag_icd9_staff_doctor "
                    + "Where tv.t_visit_id = '" + visitId + "' and icd9.diag_icd9_active = '1' "
                    + " ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                CLASS = "P";
//                AN = rs.getString("visit_an");
//                AN = setAnFormatNhso(AN);//แก้ไขให้ตรงตาม  สกส 9 degit
                AN = an;
                SUBCLASS = rs.getString("f_diagnosis_operation_type_id");
                CODE = rs.getString("diag_icd9_icd9_number");
                CODE = CODE.replaceAll("\\.", "");
                DATEIN = rs.getString("diag_icd9_start_time");
                time = rs.getString("diag_icd9_start_time").substring(11);
                time = time.replaceAll("\\:", "");
                DATEIN = config1.DateFormatShowHospital2DB(config1.DateFormatDB2Show(DATEIN, "ddMMyyyy"),"ddMMyyyy");
                DATEIN = DATEIN.replaceAll("\\-", "")+":"+time;
                DATEOUT = rs.getString("diag_icd9_finish_time");
                time = rs.getString("diag_icd9_finish_time").substring(11);
                time = time.replaceAll("\\:", "");
                DATEOUT = config1.DateFormatShowHospital2DB(config1.DateFormatDB2Show(DATEOUT, "ddMMyyyy"),"ddMMyyyy");
                DATEOUT = DATEOUT.replaceAll("\\-", "")+":"+time;
                DR = rs.getString("employee_number");
                ipdxop += AN + "|" + CLASS + "|" + SUBCLASS + "|" + CODE + "|" + DR + "|" + DATEIN + "|" + DATEOUT+CRLF;
                i++;
            }
            rs.close();
            sql = "Select visit_an,icd10.diag_icd10_number, icd10.diag_icd10_staff_doctor,be.employee_number ,f_diag_icd10_type_id "
                    + "From t_visit tv "
                    + "left join t_diag_icd10 icd10 on tv.t_visit_id = icd10.diag_icd10_vn "
                    + "left join b_employee be on be.b_employee_id = icd10.diag_icd10_staff_doctor "
                    + "Where tv.t_visit_id = '" + visitId + "' and icd10.diag_icd10_active= '1' ";
            ResultSet rs10 = st.executeQuery(sql);
            while (rs10.next()) {
                CLASS = "D";
//                AN = rs10.getString("visit_an");
//                AN = setAnFormatNhso(AN);//แก้ไขให้ตรงตาม  สกส 9 degit
                AN = an;
                SUBCLASS = rs10.getString("f_diag_icd10_type_id");
                CODE = rs10.getString("diag_icd10_number");
                CODE = CODE.replaceAll("\\.", "");
                DATEIN = "";
                DATEOUT = "";
                DR = rs10.getString("employee_number");
                ipdxop += AN + "|" + CLASS + "|" + SUBCLASS + "|" + CODE + "|" + DR + "|" + DATEIN + "|" + DATEOUT+CRLF;
                i++;
            }
            rs10.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
        }

        return CRLF+ipdxop + "^" + i.toString();
        //ชนิดของรหัสการวินิจฉัย/หัตถการ: (ใช้ร่วมกับฟิลด์ CLASS)
        //เมื่อ CLASS = D	1 = การวินิจฉัยหลัก (Principal Dx)	2 = โรคร่วม (Comorbidity)
        //3 = ภาวะแทรกซ้อน (Complication)	4 = การวินิจฉัยอื่น (Others)			5 = สาเหตุภายนอก (External cause)
        //เมื่อ CLASS = P	1 = หัตถการหลัก (Principal Proc)	2 = หัตถการรอง (Secondary Proc)
    }

    private String getBillGroup(String item_number, String f_item_group_id, String status_item_doctor, String item_name, String b16g_id) {
        String billgroup = "";
        if(b16g_id.indexOf(",")>0){//11,16
            billgroup=b16g_id;
        }else if(b16g_id.equals("")){
            billgroup="90";
        }else{
            billgroup=b16g_id;
        }
//        if (status_item_doctor.equals("1")) {//drug
//            billgroup = "17";
//        } else if (b16g_id.equals("3120000000001")) {//ค่าห้อง / ค่าอาหาร
//            billgroup = b16g_id;
//        } else if (b16g_id.equals("3120000000002")) {//ค่าอวัยวะเทียมและอุปกรณ์ในการบำบัดรักษา
//            billgroup = "02";
//        } else if (b16g_id.equals("3120000000003")) {//ค่ายาและสารอาหารทางเส้นเลือดใช้ที่รพ
//            billgroup = "03";
//        } else if (b16g_id.equals("3120000000004")) {//ค่ายาและสารอาหารทางเส้นเลือด ใช้ที่บ้าน
//            billgroup = "04";
//        } else if (b16g_id.equals("3120000000005")) {//ค่าเวชภัณฑ์ที่มิใช่ยา
//            billgroup = "05";
//        } else if (b16g_id.equals("3120000000006")) {//ค่าบริการโลหิตและส่วนประกอบของโลหิต
//            billgroup = "06";
//        } else if (b16g_id.equals("3120000000007")) {//ค่าตรวจทางเทคนิคการแพทย์และพยาธิฯ
//            billgroup = "07";
//        } else if (b16g_id.equals("3120000000008")) {//ค่าวินิจฉัยและรักษาทางรังสีวิทยา
//            billgroup = "08";
//        } else if (b16g_id.equals("3120000000009")) {//ค่าตรวจวินิจฉัยโดยวิธีพิเศษอื่นๆ
//            billgroup = "09";
//        } else if (f_item_group_id.equals("5")) {//service
//            billgroup = "12";
//        } else if (f_item_group_id.equals("6")) {//dental
//            billgroup = "13";
//        } else if (f_item_group_id.equals("7")) {//doctor df
//            billgroup = "17";
//        } else {
//            billgroup = "88";
//        }
        return billgroup;
        //BILLGROUP
        //01 = ค่าห้องและค่าอาหาร	02 = ค่าอวัยวะเทียมและอุปกรณ์ในการบำบัดรักษา
        //03 = ค่ายาและสารอาหารทางเส้นเลือดใช้ที่รพ.	04 = ค่ายาและสารอาหารทางเส้นเลือด ใช้ที่บ้าน
        //05 = ค่าเวชภัณฑ์ที่มิใช่ยา	06 = ค่าบริการโลหิตและส่วนประกอบของโลหิต
        //07 = ค่าตรวจทางเทคนิคการแพทย์และพยาธิฯ	08 = ค่าวินิจฉัยและรักษาทางรังสีวิทยา
        //09 = ค่าตรวจวินิจฉัยโดยวิธีพิเศษอื่นๆ	10 = ค?าอุปกรณ์ของใช้และเครื่องมือทางการแพทย์
        //11 = ค่าทำหัตถการและวิสัญญี	12 = ค่าบริการทางการพยาบาล
        //13 = ค่าบริการทางทันตกรรม	14 = ค่าบริการทางกายภาพบำบัดและเวชกรรมฟื้นฟู
        //15 = ค่าบริการฝังเข็ม/การบำบัดผู้ประกอบโรคศิลปอื่นๆ	16 = ค่าห้องผ่าตัดและห้องคลอด
        //17 = ค่าธรรมเนียมบุคลากรทางการแพทย์	88 = ค่าบริการอื่นๆ
        //90 = ไม่แยกหมวด (รวมทุกหมวด)	91 =ค่าธรรมเนียมพิเศษ (Surcharge)
    }

    private String getCsmbInvoice(String branch_id, String visit_vn, String tbi_id) {
        //เป็นข้อมูลรายละเอียดค่ารักษาทุกรายการ และให้รวมข้อมูล Surcharge (ซึ่งไม่ได้เป็นรายละเอียดค่ารักษา) ไว้ด้วย ข้อมูลส่วนนี้
        //อยู่ใน element Invoices ซึ่งประกอบด้วย child element Invoice จำนวน 1 element หรือมากกว่า  ในแต่ละ <Invoice >
        //ยังประกอบจาก child element จำนวน 5 elements โดยมีรูปแบบดังในตารางที่ 11 และคำอธิบายเนื้อหาข้อมูลตามตารางที่ 12
        //Child element ที่สำคัญคือ InvItems เป็นรายละเอียดค่าใช้จ่ายทุกรายการ รวมทั้ง Surcharge   แต่ละรายการจัดทำเป็นข้อความ 1 บรรทัด
        //โดยมีเนื้อหาและรูปแบบตามโครงสร้างข้อมูล Invoice ในตารางที่ 13  ที่แปลงเป็น vertical bar delimited line ทำนองเดียวกับข้อมูล IPADT
        //และระบุจำนวน record ไว้ใน attribute Reccount ของ element นี้ด้วย

        //AN=AN|SERVDATE=วันที่ให้บริการ|BILLGROUP=หมวดค่าใช้จ่ายตาม CSMBS ใช้รหัสตามตาราง 23
        //CSCODE=รหัสรายการ ตามประกาศกระทรวงการคลัง|CODE=รหัสรายการค่าบริการ ของรพ.
        //UNIT=หน่วยนับ ของ CODE|QTY=จำนวนหน่วยที่ใช้ ของ CODE|RATE=อัตรา (ต่อ UNIT) ตามราคาขายของรพ
        //REVRATE=Revision ของการปรับปรุงราคาของรพ.|AMOUNT=จำนวนเงินรวม (QTY * RATE)
        //DISCOUNT=ส่วนลดจาก AMOUNT ใช้เครื่องหมายเหมือน AMOUNT
        String invoice = "", sql = "", bill_search = "", billing_date="",TOTAL="";
        String AN = "", SERVDATE = "", BILLGROUP = "", CSCODE = "", CODE = "", UNIT = "", QTY = "", RATE = "", REVRATE = "", AMOUNT = "", DISCOUNT = "";
        Integer i = 0;
        Double amount = 0.0, qty = 0.0, discount = 0.0, price = 0.0, total = 0.0, totalRoom=0.0, df=0.0, surcharge=0.0;
        Connection conn, connitem;
        Statement st, stitem;
        try {
            conn = config1.getConnectionHospital(branch_id);
            connitem = config1.getConnectionBangna();
            st = conn.createStatement();
            stitem = connitem.createStatement();
            if (!tbi_id.equals("")) {
                bill_search = " and tbi.t_billing_invoice_id = '" + tbi_id + "'";
            }
            sql = "Select min(tbi.t_billing_invoice_date_time) as t_billing_invoice_date_time, "
                    + "min(bidu.item_drug_uom_description) as item_drug_uom_description, min(tor.order_price) as order_price,sum(tor.order_qty) as order_qty, "
                    + "min(bi.item_number) as item_number,min(tor.f_item_group_id) as f_item_group_id, "
                    + "min(bi.item_status_doctor) as item_status_doctor, min(tor.order_common_name) as order_common_name,"
                    + "min(b16g.billgroup_id) as billgroup_id, min(tor.order_date_time) as order_date_time "
                    + "From t_visit tv "
                    + "left join t_order tor on tv.t_visit_id = tor.t_visit_id and tor.f_order_status_id in ('1','2','4','5') "
                    + "left join t_order_drug tod on tod.t_order_id= tor.t_order_id and tod.order_drug_active = '1' "
                    + "left join b_item bi on bi.b_item_id= tor.b_item_id "
                    + "left join b_item_drug_uom bidu on tod.b_item_drug_uom_id_purch = bidu.b_item_drug_uom_id  and bidu.item_drug_uom_active = '1' "
                    + "left join t_billing_invoice tbi on tv.t_visit_id = tbi.t_visit_id and tbi.billing_invoice_active = '1' "
                    + "left join b_item_16_group b16g on b16g.b_item_16_group_id = bi.b_item_16_group_id "
                    + "Where tv.visit_vn = '" + visit_vn + "' " + bill_search+" and bi.item_number not in ('9','99','999') "
                    + " and tor.order_price >0 "
                    + "Group By bi.item_number ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
//                AN = rs.getString("visit_an");
//                AN = setAnFormatNhso(AN);
                AN = an;
                SERVDATE = rs.getString("order_date_time");
                SERVDATE = config1.DateFormatShowHospital2DB(config1.DateFormatDB2Show(SERVDATE,"ddMMyyyy"),"ddMMyyyy");
                SERVDATE = SERVDATE.replaceAll("\\-", "");
                BILLGROUP = getBillGroup(rs.getString("item_number"), rs.getString("f_item_group_id"),
                        rs.getString("item_status_doctor"), rs.getString("order_common_name"), rs.getString("billgroup_id"));
                CSCODE = "";
                CODE = rs.getString("item_number");
                UNIT = rs.getString("item_drug_uom_description");
                price = rs.getDouble("order_price");
                RATE = config1.NumberFormat(price);
                REVRATE = "";
                qty = rs.getDouble("order_qty");
                amount = price * qty;
                cgovdb.cbg = cgovdb.getChiBBillgroupByPK(stitem, branch_id, rs.getString("item_number"), "itemnumber");
                if(!cgovdb.cbg.getTmpCode().equals("")){
                    CODE = cgovdb.cbg.getTmpCode().trim();//ต้องเอา code ที่ส่งไปสกสส่ง ไม่ใช้ code ของโรงพยาบาล
                    UNIT = cgovdb.cbg.getUnit().trim();
                }
                CSCODE = cgovdb.cbg.getCsCode();
                REVRATE = "00"+cgovdb.cbg.getRevrate().toString();
                REVRATE = REVRATE.substring(0,3);
                if(BILLGROUP.equals("01") || BILLGROUP.equals("02") || BILLGROUP.equals("91")){//ต้องปรับ billing group ถ้าเป็นชุดนี้ต้องดึวตามนี้
                    cgovdb.cbg = cgovdb.getChiBBillgroupByPK(stitem, branch_id, rs.getString("item_number"), "itemnumber");
                    CODE = cgovdb.cbg.getTmpCode();//ต้องเอา code ที่ส่งไปสกสส่ง ไม่ใช้ code ของโรงพยาบาล
                    UNIT = cgovdb.cbg.getUnit().trim();
                    CSCODE = cgovdb.cbg.getCsCode().trim();
//                    price = cgovdb.cbg.getRate();//ใน invoice ใช้ rate ของ ร.พ.
//                    if( BILLGROUP.equals("01") && rs.getString("item_number").equals("5303")){
//                        totalRoom += amount;//หา nonDeductRoomBoard ต้องหาจาก invoice
//                    }
                    
                    if( BILLGROUP.equals("91")){
                        cgovdb.cbs = new ChiBSurcharge();
                        cgovdb.cbs = cgovdb.getChiBSurchareByPK(branch_id, cgovdb.cgovi.getSurchargeId(), "");
                        surcharge = cgovdb.cbs.getSurcharge();
//                        surcharge +=amount;
                    }
                    
                }else if(BILLGROUP.equals("17")){//หา profFee คือหา df แพทย์ ในหมวด PatCoPay
                    df +=amount;
                }
                
                if(UNIT == null){
                    UNIT="";
                }
                
                total += amount;
                QTY = config1.NumberFormat(qty);
                
                AMOUNT = config1.NumberFormat(amount);
                AMOUNT = AMOUNT.replaceAll("\\,", "");//สกส ไม่ให้มี ","
                RATE = RATE.replaceAll("\\,", "");//สกส ไม่ให้มี ","
                DISCOUNT = "0.00";
                billing_date = config1.DateFormatShowHospital2DB(config1.DateFormatDB2Show(rs.getString("t_billing_invoice_date_time"),"ddMMyyyy"),"ddMMyyyy");
                billing_date = billing_date.replaceAll("\\-", "");

                invoice += AN+"|"+SERVDATE+"|"+BILLGROUP+"|"+CSCODE+"|"+CODE+"|"+UNIT+"|"+QTY+"|"+RATE+"|"+REVRATE+"|"
                        + AMOUNT + "|" + DISCOUNT+CRLF;
                i++;
            }
            rs.close();
            conn.close();
            connitem.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
        }
        totalRoom = cgovdb.cgovi.getAdmitDay()*600;
        nonDeductRoomBoard=config1.NumberFormat(totalRoom);//เป็นค่าของ ค่าห้องที่ รพ คิด
        nonDeductRoomBoard = nonDeductRoomBoard.replaceAll("\\,", "");
        ProfFee=config1.NumberFormat(df);//หา profFee คือหา df แพทย์ ในหมวด PatCoPay
        ProfFee = ProfFee.replaceAll("\\,", "");//Surcharge="0"
        Surcharge=config1.NumberFormat(surcharge);//หา Surcharge คือหา Surcharge ในหมวด PatCoPay
        Surcharge = Surcharge.replaceAll("\\,", "");//Surcharge="0"
        TOTAL = config1.NumberFormat(total);
        TOTAL = TOTAL.replaceAll("\\,", "");
        return CRLF+invoice + "^" + i.toString() + "^" + TOTAL  + "^" + DISCOUNT+"^"+billing_date;
        //BILLGROUP
        //01 = ค่าห้องและค่าอาหาร	02 = ค่าอวัยวะเทียมและอุปกรณ์ในการบำบัดรักษา
        //03 = ค่ายาและสารอาหารทางเส้นเลือดใช้ที่รพ.	04 = ค่ายาและสารอาหารทางเส้นเลือด ใช้ที่บ้าน
        //05 = ค่าเวชภัณฑ์ที่มิใช่ยา	06 = ค่าบริการโลหิตและส่วนประกอบของโลหิต
        //07 = ค่าตรวจทางเทคนิคการแพทย์และพยาธิฯ	08 = ค?าวินิจฉัยและรักษาทางรังสีวิทยา
        //09 = ค่าตรวจวินิจฉัยโดยวิธีพิเศษอื่นๆ	10 = ค?าอุปกรณ์ของใช้และเครื่องมือทางการแพทย์
        //11 = ค่าทำหัตถการและวิสัญญี	12 = ค่าบริการทางการพยาบาล
        //13 = ค่าบริการทางทันตกรรม	14 = ค่าบริการทางกายภาพบำบัดและเวชกรรมฟื้นฟู
        //15 = ค่าบริการฝังเข็ม/การบำบัดผู้ประกอบโรคศิลปอื่นๆ	16 = ค่าห้องผ่าตัดและห้องคลอด
        //17 = ค่าธรรมเนียมบุคลากรทางการแพทย์	88 = ค่าบริการอื่นๆ
        //90 = ไม่แยกหมวด (รวมทุกหมวด)	91 =ค่าธรรมเนียมพิเศษ (Surcharge)
    }

    private String getCbmsCIPNClaim(String branch_id, String visit_id) {
        //เป็นข้อมูลรายการเบิกค่ารักษาส่วนนอก DRG คือ ค่าห้องค่าอาหาร และค่าอวัยวะเทียมและอุปกรณ์ในการบำบัดรักษาโรค
        //จากกรมบัญชีกลางข้อมูลส่วนนี้ อยู่ใน element CIPNClaim ซึ่งประกอบด้วย 5  child elements โดยมีรูปแบบดังในตารางที่ 14 และคำอธิบายเนื้อหาตามตารางที่ 15
        //Child element ที่สำคัญคือ FeeScheduleItems เป็นรายละเอียดข้อมูลรายการละ 1 บรรทัด แต่ละบรรทัดมีเนื้อหาและรูปแบบตามโครงสร้างข้อมูล CIPNClaim
        //ในตารางที่ 16  ที่แปลงเป็น vertical bar delimited line ทำนองเดียวกับข้อมูล IPADT

        //ให้ดึงแต่หมวด billgroup=01,02 เท่าน้นโดย FeeScheduleItems จะมีเพียง 2 บันทัดคือ 01,02 เป็น sum
        String cipnClaim = "",AN="",BILLGROUP="",CSCODE="",CSQTY="",CSRATE="",CSREVRATE="",CLAIM="",AMOUNT="",DISCOUNT="";
        String DeductRoomBoard="", DeductMedDev="", nonDeductMedDev="", sql="",bill_search="", cipnSearch01="", cipnSearch02="";
        Connection conn, connitem;
        Statement st, stitem;
        Double amount = 0.0, qty = 0.0, discount = 0.0, price = 0.0, totalRoom = 0.0, nontotalRoom=0.0, csAmount=0.0;
        Double sumFood=0.0;
        try {
            conn = config1.getConnectionHospital(branch_id);
            connitem = config1.getConnectionBangna();
            st = conn.createStatement();
            stitem = connitem.createStatement();
            bill_search = " and b16g.billgroup_id in ('01','02') ";
            if(!branch.getCipnFeeschedule01().equals("")){//เรื่อง ค่าห้อง ต้องให้การเงินป้อนตาม จำนวนวันของ สกส เพราะจะติดปัญหาเรื่อง อุปกรณ์อวัยวะเทียม ต้องดึงจาก t_order เหมือนกัน
                cipnSearch01 = " and bi.item_common_name like '"+branch.getCipnFeeschedule01()+"%' ";
            }
            if(!branch.getCipnFeeschedule02().equals("")){//เรื่อง ค่าห้อง ต้องให้การเงินป้อนตาม จำนวนวันของ สกส เพราะจะติดปัญหาเรื่อง อุปกรณ์อวัยวะเทียม ต้องดึงจาก t_order เหมือนกัน
                cipnSearch02 = " and bi.item_common_name like '"+branch.getCipnFeeschedule02()+"%' ";
            }
            sql = "Select sum(tor.order_qty) as order_qty, "
                    + "b16g.billgroup_id, bi.cscode, bi.item_number "
                    + "From t_visit tv "
                    + "left join t_order tor on tv.t_visit_id = tor.t_visit_id and tor.f_order_status_id in ('1','2','4','5') "
                    + "left join t_order_drug tod on tod.t_order_id= tor.t_order_id and tod.order_drug_active = '1' "
                    + "left join b_item bi on bi.b_item_id= tor.b_item_id "
                    + "left join b_item_drug_uom bidu on tod.b_item_drug_uom_id_purch = bidu.b_item_drug_uom_id  and bidu.item_drug_uom_active = '1' "
                    + "left join t_billing_invoice tbi on tv.t_visit_id = tbi.t_visit_id and tbi.billing_invoice_active = '1' "
                    + "left join b_item_16_group b16g on b16g.b_item_16_group_id = tor.b_item_16_group_id "
                    + "Where tv.t_visit_id = '" + visit_id + "' " + bill_search+" "+cipnSearch01+" "+cipnSearch02+" "
                    + "Group By b16g.billgroup_id, bi.cscode, bi.item_number "
                    + "Order By b16g.billgroup_id, bi.cscode ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                AN = an;
//                AN = setAnFormatNhso(AN);
                BILLGROUP = rs.getString("billgroup_id");
                CSCODE = rs.getString("cscode");
                qty = rs.getDouble("order_qty");
                qty = cgovdb.cgovi.getAdmitDay();
                CSQTY = config1.NumberFormat(qty);
                cgovdb.cbg = cgovdb.getChiBBillgroupByPK(stitem, branch_id, rs.getString("item_number"), "itemnumber");
                csAmount = cgovdb.cbg.getCsRate() * qty;// เป็นราคาตาม สกส
                amount = cgovdb.cbg.getRate() * qty;// เป็นราคารพ
                CLAIM = config1.NumberFormat(amount);
                AMOUNT=CLAIM;
                if(BILLGROUP.equals("01")){
                    sumFood = getSumFood(branch_id, visit_id);
                    amount+=sumFood;//ต้องรวมค่าอาหารด้วย
                    CLAIM = config1.NumberFormat(amount);
                    AMOUNT=CLAIM;
                    totalRoom+=csAmount;
                    CLAIM = config1.NumberFormat(totalRoom);
//                    AMOUNT=nonDeductRoomBoard;
                }
                DISCOUNT=String.valueOf(amount-amount);
                DISCOUNT=config1.NumberFormat(DISCOUNT);
                DISCOUNT = DISCOUNT.replaceAll("\\,", "");
//                CODE = cgovdb.cbg.getTmpCode();//ต้องเอา code ที่ส่งไปสกสส่ง ไม่ใช้ code ของโรงพยาบาล
//                UNIT = cgovdb.cbg.getUnit();
                CSCODE = cgovdb.cbg.getCsCode();
                CSREVRATE = cgovdb.cbg.getCsRevRate();
                CSRATE = config1.NumberFormat(cgovdb.cbg.getCsRate());
                CSRATE = CSRATE.replaceAll("\\,", "");
//                if(rs.getString("billgroup_id").equals("01")){
//                    DeductRoomBoard = AMOUNT;
//                    nonDeductRoomBoard = AMOUNT;
//                }
                AMOUNT = AMOUNT.replaceAll("\\,", "");//สกส ไม่ให้มี ","
                CLAIM = CLAIM.replaceAll("\\,", "");//สกส ไม่ให้มี ","
                cipnClaim+=AN + "|" + BILLGROUP + "|" + CSCODE + "|" + CSQTY + "|" + CSRATE + "|" + CSREVRATE + "|" + CLAIM + "|" + AMOUNT + "|" + DISCOUNT+CRLF;

            }
            rs.close();
            conn.close();
            connitem.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
        }

        DeductRoomBoard = totalRoom.toString();//เป็นค่าห้อง ตาม rate ที่ สกสคิด
        nonDeductRoomBoard =AMOUNT;
        DeductMedDev="0.00";
        nonDeductMedDev="0.00";
        nontotalRoom = Double.parseDouble(nonDeductRoomBoard)-totalRoom;
        if(nontotalRoom<0.0){
            nontotalRoom=0.0;
        }
        nonDeductRoomBoard = config1.NumberFormat(nontotalRoom);
        nonDeductRoomBoard = nonDeductRoomBoard.replaceAll("\\,", "");
        return CRLF+cipnClaim + "^" + DeductRoomBoard + "^" + nonDeductRoomBoard + "^" + DeductMedDev + "^" + nonDeductMedDev; // แก้ไขเรื่อง nonDeductRoomBoarch เพราะ เป็นส่วนเกินที่เก็บกับ patient
        //AN=AN|BILLGROUP|CSCODE|CSQTY|CSRATE|CSREVRATE|CLAIM|AMOUNT|DISCOUNT
        //BILLGROUP=หมวดค่าใช้จ่ายตาม CSMBS ใช้รหัสตามตาราง 23
        //CSCODE=รหัสรายการ ตามประกาศกระทรวงการคลัง
        //CSQTY=จำนวนหน่วยที่เบิก (หน่วยตามประกาศกระทรวงการคลัง)
        //CSRATE=อัตราที่ให้เบิก ต่อหน่วย ตามประกาศกระทรวงการคลัง
        //CSREVRATE=Revision ของการปรับปรุงราคา ตามที่ สกส.กำหนด
        //CLAIM=รวมจำนวนเงินที่เบิก
        //AMOUNT=จำนวนเงินรวมเมื่อคิดราคาตามอัตราของ รพ.
        //DISCOUNT=ส่วนลดจาก AMOUNT ใช้เครื่องหมายเหมือน AMOUNT

    }
    private String getSumDf(String branch_id, String visit_id) {
        String cipnClaim = "",AN="", sql="",bill_search="";
        Connection conn;
        Statement st;
        Double amount = 0.0, qty = 0.0, discount = 0.0, price = 0.0, total = 0.0;
        try {
            conn = config1.getConnectionHospital(branch_id);
            st = conn.createStatement();
            bill_search = " and b16g.billgroup_id in ('17') ";
            sql = "Select sum(tor.order_qty * tor.order_price) as df "
                    + "From t_visit tv "
                    + "left join t_order tor on tv.t_visit_id = tor.t_visit_id and tor.f_order_status_id in ('1','2','4','5') "
                    + "left join t_order_drug tod on tod.t_order_id= tor.t_order_id and tod.order_drug_active = '1' "
                    + "left join b_item bi on bi.b_item_id= tor.b_item_id "
                    + "left join b_item_drug_uom bidu on tod.b_item_drug_uom_id_purch = bidu.b_item_drug_uom_id  and bidu.item_drug_uom_active = '1' "
                    + "left join t_billing_invoice tbi on tv.t_visit_id = tbi.t_visit_id and tbi.billing_invoice_active = '1' "
                    + "left join b_item_16_group b16g on b16g.b_item_16_group_id = tor.b_item_16_group_id "
                    + "Where tv.t_visit_id = '" + visit_id + "' " + bill_search+" ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                AN = rs.getString("df");
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return AN;
    }
    private Double getSumFood(String branch_id, String visit_id) {
        String cipnClaim = "",AN="", sql="",bill_search="",cipnSearch01="";
        Connection conn;
        Statement st;
        Double amount = 0.0;
        try {
            conn = config1.getConnectionHospital(branch_id);
            st = conn.createStatement();
            bill_search = " and b16g.billgroup_id in ('01') ";
            cipnSearch01 = " and bi.item_common_name like 'ค่าอาหาร%' ";
            sql = "Select sum(tor.order_qty * tor.order_price) as amount, "
                + "b16g.billgroup_id, bi.cscode, bi.item_number "
                + "From t_visit tv "
                + "left join t_order tor on tv.t_visit_id = tor.t_visit_id and tor.f_order_status_id in ('1','2','4','5') "
                + "left join t_order_drug tod on tod.t_order_id= tor.t_order_id and tod.order_drug_active = '1' "
                + "left join b_item bi on bi.b_item_id= tor.b_item_id "
//                + "left join b_item_drug_uom bidu on tod.b_item_drug_uom_id_purch = bidu.b_item_drug_uom_id  and bidu.item_drug_uom_active = '1' "
//                + "left join t_billing_invoice tbi on tv.t_visit_id = tbi.t_visit_id and tbi.billing_invoice_active = '1' "
                + "left join b_item_16_group b16g on b16g.b_item_16_group_id = tor.b_item_16_group_id "
                + "Where tv.t_visit_id = '" + visit_id + "' " + bill_search+" "+cipnSearch01
                + "Group By b16g.billgroup_id, bi.cscode, bi.item_number ";
//                + "Order By b16g.billgroup_id, bi.cscode ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                amount = rs.getDouble("amount");
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ChiNhso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amount;
    }
}
