package com.mbesutti.refactorings.introduceParameterObject.original;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class Account {
	double getFlowBetween (Date start, Date end) {
        double result = 0;
        Enumeration e = _entries.elements();
        while (e.hasMoreElements()) {
            Entry each = (Entry) e.nextElement();
            if (each.getDate().equals(start) ||
                each.getDate().equals(end) ||
                 (each.getDate().after(start) && each.getDate().before(end)))
            {
                result += each.getValue();
      }
        }
        return result;
    }
    private final Vector _entries = new Vector();
    
    //client code
    public static void main(String[] args) {
    	Account anAccount = new Account();
    	double flow = anAccount.getFlowBetween(new Date(), new Date());
	}
}
