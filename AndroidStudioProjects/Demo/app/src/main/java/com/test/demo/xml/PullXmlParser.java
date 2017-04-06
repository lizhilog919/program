package com.test.demo.xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Li Zhi
 * 2017/3/30.
 */

public class PullXmlParser implements XmlParser {
    @Override
    public List<Book> parser(InputStream inputStream) throws Exception {
        List<Book> books = null;
        Book book = null;
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(inputStream, "utf-8");
        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT){
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                    books = new ArrayList<>();
                    break;
                case XmlPullParser.START_TAG:
                    if("book".equals(parser.getName())){
                        book = new Book();
                    }else if("id".equals(parser.getName())){
                        eventType = parser.next();
                        book.setId(Integer.parseInt(parser.getText()));
                    }else if("name".equals(parser.getName())){
                        eventType = parser.next();
                        book.setName(parser.getText());
                    }else if("date".equals(parser.getName())){
                        eventType = parser.next();
                        book.setDate(parser.getText());
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if("book".equals(parser.getName())){
                        books.add(book);
                        book = null;
                    }
                    break;
            }
            eventType = parser.next();
        }
        return books;
    }

    @Override
    public String serialize(List<Book> books) throws Exception {
        return null;
    }
}
