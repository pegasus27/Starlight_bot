package main;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Request_Json {


    public static String get_Json() {
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
                    this.setDetails(parseDetails(parser));
                } else {
                    //想定外のものは無視して次へ
                    parser.skipChildren();
                }
            }
        }
    }
}
