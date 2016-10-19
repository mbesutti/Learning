package com.mbesutti.refactorings.introduceParameterObject.original;

import java.util.Date;

public class Entry {
	public Entry (double value, Date chargeDate) {
        _value = value;
        _chargeDate = chargeDate;
    }
    Date getDate(){
        return _chargeDate;
    }
    double getValue(){
        return _value;
    }
    private final Date _chargeDate;
    private final double _value;
}
