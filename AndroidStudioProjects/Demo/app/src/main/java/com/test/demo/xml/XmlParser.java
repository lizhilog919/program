package com.test.demo.xml;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Li Zhi
 * 2017/3/29.
 */

public interface XmlParser {
    List<Book> parser(InputStream inputStream) throws Exception;
    String serialize(List<Book> books) throws Exception;
}
