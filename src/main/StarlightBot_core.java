package main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StarlightBot_core {
    public static final String BOTVERSION = "1.0.1 β";
    //public static JDA jda_bot;
    public static String BOT_TOKEN = "";
    //OSの改行のステータスを取得する
    public static String crlf = System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {
        // TODO 自動生成されたメソッド・スタブ
        //if (BOT_TOKEN == "") BOT_TOKEN = Readbot_token("../.idea/bot_token");
        //System.out.println(BOT_TOKEN);
/*        try {
        } catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
        jda_bot = new JDABuilder(AccountType.BOT).addListener(new BotListener()).setToken(BOT_TOKEN).buildBlocking();
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }*/
        JsonNode nodes = null;
        nodes = Request_Json.get_Json(Http_connect.getResult());
        if(nodes == null)System.out.println("damedesu");
        //ObjectMapper mapper = new ObjectMapper();
        //JsonNode node = mapper.readTree(nodes);

        //if(node == null)System.out.println("damedesu");
            /*
            int age = node.get("age").asInt();
            System.out.println(age);

            String city = node.get("address").get("city").asText();
            System.out.println(city);

            String number = node.get("phoneNumbers").get(0).get("number").asText();
            System.out.println(number);
            */
        JsonNode child= nodes.get("explain");
        String condition = child.textValue();
        System.out.println(condition);

    }

    public static String Readbot_token(String path) throws IOException {

        return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
    }

}

