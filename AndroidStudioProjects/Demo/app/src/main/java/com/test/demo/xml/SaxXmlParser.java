package com.test.demo.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by Li Zhi
 * 2017/3/29.
 */

public class SaxXmlParser implements XmlParser{
    @Override
    public List<Book> parser(InputStream inputStream) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XmlHandler handler = new XmlHandler();
        parser.parse(inputStream, handler);
        return handler.getData();
    }

    @Override
    public String serialize(List<Book> books) throws Exception {
        SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        TransformerHandler handler = factory.newTransformerHandler();
        Transformer transformer = handler.getTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        StringWriter writer = new StringWriter();
        Result result = new StreamResult(writer);
        handler.setResult(result);
        String uri = "";
        String local_name = "";
        handler.startDocument();
        handler.startElement(uri, local_name, "books",null);
        char[] ch = null;
        for (Book book : books) {
            handler.startElement(uri,local_name,"book",null);

            handler.startElement(uri,local_name,"id",null);
            ch = String.valueOf(book.getId()).toCharArray();
            handler.characters(ch,0,ch.length);
            handler.endElement(uri,local_name,"id");

            handler.startElement(uri,local_name,"name",null);
            ch = String.valueOf(book.getName()).toCharArray();
            handler.characters(ch,0,ch.length);
            handler.endElement(uri,local_name,"name");

            handler.startElement(uri,local_name,"date",null);
            ch = String.valueOf(book.getDate()).toCharArray();
            handler.characters(ch,0,ch.length);
            handler.endElement(uri,local_name,"date");

            handler.endElement(uri,local_name,"book");
        }
        handler.endElement(uri,local_name,"books");
        handler.endDocument();
        return writer.toString();
    }

    public static class XmlHandler extends DefaultHandler {
        private List<Book> data;
        private Book mBook;
        private StringBuilder mStringBuilder;

        public List<Book> getData(){
            return data;
        }

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            data = new ArrayList<>();
            mStringBuilder = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            if(localName.equals(Book.class.getSimpleName().toLowerCase())){
                mBook = new Book();
            }
            mStringBuilder.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);
            mStringBuilder.append(ch,start,length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
            Field[] fields = Book.class.getDeclaredFields();
            for (Field field : fields) {
                String name = field.getName();
                if(localName.equals(name)){
                    field.setAccessible(true);
                    String type = field.getGenericType().toString();
                    try {
                        if(type.equals("int")){
                            field.setInt(mBook,Integer.parseInt(mStringBuilder.toString()));
                        }else if(type.equals("boolean")){
                            field.setBoolean(mBook,Boolean.parseBoolean(mStringBuilder.toString()));
                        }else if(type.equals("float")){
                            field.setFloat(mBook, Float.parseFloat(mStringBuilder.toString()));
                        }else if(type.equals("double")){
                            field.setDouble(mBook, Double.parseDouble(mStringBuilder.toString()));
                        }else if(type.equals("short")){
                            field.setShort(mBook, Short.parseShort(mStringBuilder.toString()));
                        }else if(type.equals("long")){
                            field.setLong(mBook, Long.parseLong(mStringBuilder.toString()));
                        }else if(type.equals("byte")){
                            field.setByte(mBook, Byte.parseByte(mStringBuilder.toString()));
                        }else {
                            field.set(mBook, mStringBuilder.toString());
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try {
                        field.set(mBook,mStringBuilder.toString());
                        field.set(mBook,0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if(localName.equals(Book.class.getSimpleName().toLowerCase())){
                data.add(mBook);
            }
        }
    }
}
