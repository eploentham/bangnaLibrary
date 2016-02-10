/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bangnaLibrary;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParser {
	List list;
	Document dom;
	public DomParser(){
		list = new ArrayList();
	}
	public void runExample() {
		parseXmlFile();
		parseDocument();
		printData();
	}
	private void parseXmlFile(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
//                        String currentdir = System.getProperty("user.dir");
//                        File file = new File(currentdir+"/bangna.xml");
			dom = db.parse("bangna.xml");
//                        FileInputStream fin = new FileInputStream(currentdir+"/bangna.xml");
//                        byte fileContent[] = new byte[(int)file.length()];
//                        fin.read(fileContent);
//                        String strFileContent = new String(fileContent);
//                        ByteArrayInputStream in = new ByteArrayInputStream(strFileContent.getBytes("utf-8")); 
//                        dom = db.parse(in);

		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	private void parseDocument(){
            Element docEle = dom.getDocumentElement();
            NodeList nl = docEle.getElementsByTagName("BangnaIni");
            if(nl != null && nl.getLength() > 0) {
                    for(int i = 0 ; i < nl.getLength();i++) {
                            Element el = (Element)nl.item(i);
                            BangnaIni e = getBangnaIni(el);
                            if(e.type.equals("use"))
                                list.add(e);
                    }
            }
	}
        public BangnaIni getBangnaIni()
        {
//            parseXmlFile();
//            parseDocument();
//            return (BangnaIni) list.get(0);
            return getBangnaIni2();
        }
        public BangnaIni getBangnaIniBySerial()
        {
            BangnaIni b = null;
            try
            {
                b = new BangnaIni();
                String currentdir = System.getProperty("user.dir");
                FileInputStream fis = new FileInputStream(currentdir+"/bangna.info");
                ObjectInputStream inStream = new ObjectInputStream(fis);
                b = (BangnaIni) inStream.readObject();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            
            return b;
        }
	private BangnaIni getBangnaIni(Element empEl) {
                BangnaIni b = new BangnaIni();
                b.type = empEl.getAttribute("type");
                b.database = getTextValue(empEl,"database");
                b.databasebangna = getTextValue(empEl,"databasebangna");
                b.hostname = getTextValue(empEl,"hostname");
                b.hostnamebangna = getTextValue(empEl,"hostnamebangna");
                b.passDB = getTextValue(empEl,"passDB");
                b.passDBbangna = getTextValue(empEl,"passDBbangna");
                b.userDB = getTextValue(empEl,"userDB");
                b.userDBbangna = getTextValue(empEl,"userDBbangna");
                b.hostnamebangna = getTextValue(empEl,"hostnamebangna");
                b.jasperReportType = getTextValue(empEl,"jasperReportType");
		return b;
	}
        public String getBangnaIniFromFile()
        {
            String txt = "";
            try
            {
                BufferedReader in = new BufferedReader(new FileReader("bangna.ini"));
                String st1;
                while ((st1 = in.readLine()) != null) {
                    txt = txt + st1 + "\n";
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            return txt;
        }
        public BangnaIni getBangnaIni2()
        {
            BangnaIni bangnaIni = new BangnaIni();
            try
            {
                BufferedReader in = new BufferedReader(new FileReader("bangna.ini"));
                String st1;
                while ((st1 = in.readLine()) != null) {
                    if(st1.indexOf("=")>0)
                    {
                        bangnaIni.txt = bangnaIni.txt + st1 + "\n";
                        String arr[] = st1.split("=");
                        if(arr[0].equals("database"))
                            bangnaIni.database = arr[1];
                        if(arr[0].equals("databasebangna"))
                            bangnaIni.databasebangna = arr[1];
                        if(arr[0].equals("databaseextend"))
                            bangnaIni.databaseextend = arr[1];
                        if(arr[0].equals("driverName"))
                            bangnaIni.driverName = arr[1];
                        if(arr[0].equals("driverNamebangna"))
                            bangnaIni.driverNamebangna = arr[1];
                        if(arr[0].equals("hostname"))
                            bangnaIni.hostname = arr[1];
                        if(arr[0].equals("hostnamebangna"))
                            bangnaIni.hostnamebangna = arr[1];
                        if(arr[0].equals("panelorderpanel4width"))
                            bangnaIni.panelorderpanel4width = arr[1];
                        if(arr[0].equals("passDB"))
                            bangnaIni.passDB = arr[1];
                        if(arr[0].equals("passDBbangna"))
                            bangnaIni.passDBbangna = arr[1];
                        if(arr[0].equals("userDB"))
                            bangnaIni.userDB = arr[1];
                        if(arr[0].equals("userDBbangna"))
                            bangnaIni.userDBbangna = arr[1];
                        if(arr[0].equals("jasperReportType"))
                            bangnaIni.jasperReportType = arr[1];
                        if(arr[0].equals("reportResultLab"))
                            bangnaIni.reportResultLab = arr[1];
                        if(arr[0].equals("reportRequestDrug"))
                            bangnaIni.reportRequestDrug = arr[1];
                        if(arr[0].equals("reportInvoiceGroup"))
                            bangnaIni.reportInvoiceGroup = arr[1];
                    }
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            return bangnaIni;
        }
	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}
	private int getIntValue(Element ele, String tagName) {
		return Integer.parseInt(getTextValue(ele,tagName));
	}
	private void printData(){
		System.out.println("No of elements '" + list.size() + "'.");
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	public static void main(String[] args){
		DomParser dpe = new DomParser();
		dpe.runExample();
	}
}