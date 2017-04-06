package com.test.demo.xml;

import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Li Zhi
 * 2017/3/30.
 */

public class DomXmlParser implements XmlParser {
    @Override
    public List<Book> parser(InputStream inputStream) throws Exception {
        List<Book> books = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        Element element = document.getDocumentElement();
        NodeList bookNodes = element.getElementsByTagName("book");
        int length = bookNodes.getLength();
        for (int i = 0; i < length; i++) {
            Book book = new Book();
            Element e = (Element) bookNodes.item(i);
            NodeList child = e.getChildNodes();
            int l = child.getLength();
            for (int j = 0; j < l; j++) {
                Node node = child.item(j);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element c = (Element) node;
                    Node first = c.getFirstChild();
                    if(first.getNodeType() == Node.TEXT_NODE) {
                        if("id".equals(c.getNodeName())){
                            try {
                                book.setId(Integer.parseInt(first.getNodeValue()));
                            }catch (Exception error){
                                error.printStackTrace();
                                book.setId(-1);
                            }
                        }else if("name".equals(c.getNodeName())){
                            book.setName(first.getNodeValue());
                        }else if("date".equals(c.getNodeName())){
                            book.setDate(first.getNodeValue());
                        }
                    }
                }
            }
            books.add(book);
        }
        return books;
    }

    @Override
    public String serialize(List<Book> books) throws Exception {
        return null;
    }
}
