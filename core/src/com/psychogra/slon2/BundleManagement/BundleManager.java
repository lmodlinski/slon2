package com.psychogra.slon2.BundleManagement;

import java.beans.XMLDecoder;
import java.io.InputStream;

public class BundleManager {

    public static void main(String[] args){
        System.out.println("DUPA");
    }

    public static void DeserializeBundle(InputStream input){

        XMLDecoder decoder = new XMLDecoder(input);
        BundleDTO bundle = (BundleDTO) decoder.readObject();
        System.out.println(bundle.name);
    }

}
