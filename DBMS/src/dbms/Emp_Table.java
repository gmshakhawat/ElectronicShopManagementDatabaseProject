/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author panther
 */
public class Emp_Table {
    
    SimpleStringProperty Eid;
    SimpleStringProperty Ename;
    SimpleStringProperty Egender;
    SimpleStringProperty Eaddr;
    SimpleStringProperty Econtact;
    SimpleStringProperty Eadhaar;

    Emp_Table(String Eid, String Ename, String Egender, String Eaddr, String Econtact,String Eadhaar) {
        this.Eid = new SimpleStringProperty(Eid);
        this.Ename = new SimpleStringProperty(Ename);
        this.Egender = new SimpleStringProperty(Egender);
        this.Eaddr = new SimpleStringProperty(Eaddr);
        this.Econtact = new SimpleStringProperty(Econtact);
        this.Eadhaar = new SimpleStringProperty(Eadhaar);
    }
    public String getEid(){
        return Eid.get();
    }
    public String getEname(){
        return Ename.get();
    }
    public String getEgender(){
        return Egender.get();
    }
    public String getEaddr(){
        return Eaddr.get();
    }
    public String getEcontact(){
        return Econtact.get();
    }
    public String getEadhaar(){
        return Eadhaar.get();
    }
    
    public void setEadhaar(String s){
        this.Eadhaar.set(s);
    }
    public void setEid(String s){
        this.Eid.set(s);
    }
    public void setEname(String n){
        this.Ename.set(n);
    }
    
    public void setEgender(String p){
        this.Egender.set(p);
    }
    public void setEaddr(String p){
        this.Eaddr.set(p);
    }
    public void setEcontact(String p){
        this.Econtact.set(p);
    }
    
}
