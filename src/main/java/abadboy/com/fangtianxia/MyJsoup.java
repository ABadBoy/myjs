package abadboy.com.fangtianxia;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class MyJsoup {

    public static String houseId , houseName, houseMessage,housSize,housePrice,squarePrice,otherMessages;

    public static void main(String[] args) {

        try {
            for (int i = 1; i < 10 ; i++) {

                Document document = Jsoup.connect("http://esf.zz.fang.com/house-a0362-b04557/j270-k290-i3"+ i+"/" )
                        .timeout(6000).get();
                String title = document.title();
                System.out.println(title + i+"页");
                Elements housesMessages = document.getElementsByTag("dl");

                for (Element house : housesMessages) {

                    String houseIdDl = house.attr("id");
                    System.out.print(i+ houseIdDl + "\t");

                    Elements housesData = house.getElementsByTag("dd");

                    for (Element houseData : housesData){

                        if(houseData.getElementsByClass("mt10").first()!=null) {
                            Element name = houseData.getElementsByClass("mt10").first().getElementsByTag("a").first();
                            System.out.print(name.attr("title") + "\t");

                            System.out.print(houseData.getElementsByClass("mt12").first().getElementsByTag("p").first().ownText() + "\t");
                            Element area = houseData.select("div.area.alignR>p").first();
                            System.out.print(area.ownText().substring(0, 2) + "平" + "\t");

                            String totalPrice = houseData.select("div.moreInfo>p").first().getElementsByTag("span").first().ownText();
                            System.out.print(totalPrice + "万" + "\t");

                            String squareMeterPrice = houseData.select("div.moreInfo>p").last().ownText();
                            System.out.print(squareMeterPrice.substring(0, squareMeterPrice.length() - 2)+"\t");

                            String  anotherMessage = houseData.select("div.pt4.floatl").first().getElementsByTag("span").text();
                            System.out.print(anotherMessage);

                            houseId = houseIdDl;
                            houseName = name.attr("title");
                            houseMessage = houseData.getElementsByClass("mt12").first().getElementsByTag("p").first().ownText();
                            housSize = area.ownText().substring(0, 2);
                            housePrice = totalPrice + "万";
                            squarePrice = squareMeterPrice.substring(0, squareMeterPrice.length() - 2);
                            otherMessages = anotherMessage;

                          /*  PreparedStatement stmt = DatabaseUtil.getConnection().prepareStatement(
                                    "insert into house (houseId , houseName, houseMessage,housSize,housePrice,squareMeterPrice,otherMessages) "
                                            + "VALUES(?,?,?,?,?,?,?)");
                            stmt.setString(1,houseId);
                            stmt.setString(2,houseName);
                            stmt.setString(3,houseMessage);
                            stmt.setString(4,housSize);
                            stmt.setString(5,housePrice);
                            stmt.setString(6,squarePrice);
                            stmt.setString(7,otherMessages);
                            stmt.executeUpdate();*/

                        }

                    }
                    System.out.println();

                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
