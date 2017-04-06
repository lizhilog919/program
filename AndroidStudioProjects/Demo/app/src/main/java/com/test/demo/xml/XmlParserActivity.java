package com.test.demo.xml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.test.demo.BaseActivity;
import com.test.demo.R;

import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.XMLReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.SAXParser;

public class XmlParserActivity extends BaseActivity implements View.OnClickListener {

    TextView mTextView,mTvXml;
    InputStream mInputStream;
    XmlParser mXmlParser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_parser);
        mTextView = (TextView) findViewById(R.id.text);
        mTvXml = (TextView) findViewById(R.id.xml);
        try {
            mInputStream = getAssets().open("parser.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String reader(InputStream inputStream){
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(mInputStream));
        String s;
        try {
            while ((s=reader.readLine())!= null){
                builder.append(s + "\n");
            }
            mInputStream.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    @Override
    public void onClick(View v) {
        StringBuilder builder = new StringBuilder();
        builder.append(reader(mInputStream));
        switch (v.getId()){
            case R.id.sax:
                mXmlParser = new SaxXmlParser();
                builder.append("\n sax: \n");
                break;
            case R.id.dom:
                mXmlParser = new DomXmlParser();
                builder.append("\n dom: \n");
                break;
            case R.id.pull:
                mXmlParser = new PullXmlParser();
                builder.append("\n pull: \n");
                break;
        }
        long time = System.currentTimeMillis();
        List<Book> books = parser(mXmlParser);
        builder.append(books);
        builder.append("\n cost time: ").append(System.currentTimeMillis() - time);
        mTextView.setText(builder);
        try {
            mTvXml.setText(mXmlParser.serialize(books));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Book> parser(XmlParser parser){
        try {
            return parser.parser(mInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                mInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
