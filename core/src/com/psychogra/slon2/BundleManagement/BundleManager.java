package com.psychogra.slon2.BundleManagement;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.InputStream;

import javax.xml.stream.XMLStreamReader;

/**
 * Created by juna8001 on 23.09.2017.
 */

public class BundleManager {

    public static void DeserializeBundle(InputStream input){

        XMLDecoder decoder = new XMLDecoder(input);
        BundleDTO bundle = (BundleDTO) decoder.readObject();
    }

}
