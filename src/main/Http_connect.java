package main;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import javax.xml.soap.Detail;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http_connect {
    public static String<> getResult() throws IOException {
        String urlString="https://starlight.kirara.ca/api/v1/card_t/200167";
        URL apiUrl=new URL(urlString);

        //webから取得していく
        String line,json="";
        BufferedReader reader = new BufferedReader(new InputStreamReader(apiUrl.openStream(), "UTF-8"));
        while((line = reader.readLine()) != null){
            json+=line;
        }
        reader.close();

        // JsonFactoryの生成
        JsonFactory factory = new JsonFactory();
// JsonParserの取得
        JsonParser parser = factory.createJsonParser(json);

//JSONのパース処理
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            String name = parser.getCurrentName();
            if(name != null) {
                parser.nextToken();
                if(name.equals("name")) {
                    //名前
                    this.setName(parser.getText());
                }else if(name.equals("age")) {
                    //年齢
                    this.setAge(parser.getText());
                }else if(name.equals("hometown")) {
                    //出身地
                    this.setHometown(parser.getText());
                }else if(name.equals("details")) {
                    //詳細情報
                    //this.setDetails(parseDetails(parser));
                } else {
                    //想定外のものは無視して次へ
                    parser.skipChildren();
                }
            }
        }




        ArrayList<Details> details=new ArrayList<Details>();

    //Arrayの終了までループ
        while(parser.nextToken() != JsonToken.END_ARRAY){
            //一つずつ詳細情報を作成していく
            Detail detail=new Detail();
            while (parser.nextToken() != JsonToken.END_OBJECT) {
                String name=parser.getCurrentName();
                parser.nextToken();
                if(name.equals("nickname")){
                   // detail.setNickname(parser.getText());
                }else if(name.equals("rerarity")){
                    //detail.setRerarity(parser.getText());
                }else if(name.equals("atk")){
                   // detail.setAtk(parser.getText());
                }else if(name.equals("def")){
                   // detail.setDef(parser.getText());
                }else {
                    parser.skipChildren();
                }
            }
           // details.add(bookmark);
        }

        return details;
    }
}
