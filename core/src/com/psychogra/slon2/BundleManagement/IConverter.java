package com.psychogra.slon2.BundleManagement;

import com.badlogic.gdx.utils.XmlReader;

public interface IConverter <T> {

    public T convert(XmlReader.Element element);
}
