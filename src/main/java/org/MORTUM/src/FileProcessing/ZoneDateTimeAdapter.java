package org.MORTUM.src.FileProcessing;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;

public class ZoneDateTimeAdapter extends javax.xml.bind.annotation.adapters.XmlAdapter<java.lang.String, java.time.ZonedDateTime> {

    private static final String CUSTOM_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";

    @Override
    public ZonedDateTime unmarshal(String v) throws Exception {
        return ZonedDateTime.parse(v);
    }

    @Override
    public String marshal(ZonedDateTime v) throws Exception {
        return v.toString();
    }
}
