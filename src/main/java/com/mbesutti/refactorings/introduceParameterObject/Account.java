package com.mbesutti.refactorings.introduceParameterObject;

import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class Account {
	double getFlowBetween (DateRange range) {
        double result = 0;
        Enumeration e = _entries.elements();
        while (e.hasMoreElements()) {
            Entry each = (Entry) e.nextElement();
            if (range.includes(each.getDate()))
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
    	double flow = anAccount.getFlowBetween(new DateRange(new Date(), new Date()));
	}
}
