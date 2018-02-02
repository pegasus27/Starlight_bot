package main;

public class StarlightBot_core {
    public static final String BOTVERSION = "1.0.1 β";
    public static JDA jda_bot;
    public static final String BOT_TOKEN = ;
    //OSの改行のステータスを取得する
    public static String crlf = System.getProperty("line.separator");

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        Twitter_D.startUserStream();
        try {
            jda_bot = new JDABuilder(AccountType.BOT).addListener(new BotListener()).setToken(BOT_TOKEN).buildBlocking();
        } catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }

}