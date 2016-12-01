package abadboy.com.dianping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class ZhuJiaJiao {

	public static final String PEOPLE_SQUARES="http://www.dianping.com/search/category/1/10/r860o3p";
	public static final String ZHU_JIA_JIAO="http://www.dianping.com/search/keyword/1/10_%E6%9C%B1%E5%AE%B6%E8%A7%92/o3p";

	public static void main(String[] args) throws IOException, InterruptedException {

		for (int i = 1; i < 10; i ++) {

			Document document = Jsoup.connect(PEOPLE_SQUARES+i)
					.timeout(6000).userAgent("Mozilla").get();
			String title = document.title();
			System.out.println(title);

			Elements shops = document.getElementsByClass("shop-list").get(0).getElementsByTag("li");
			for (Element shop : shops) {
				String shopName = shop.getElementsByClass("tit").select("a>h4").text();
				System.out.print(shopName + "\t");

				String price = shop.getElementsByClass("comment").select("a").last().text();
				System.out.print(price + "\t");

				String food = shop.getElementsByClass("tag-addr").select("a").first().text();
				System.out.print(food + "\t");

				String address = shop.getElementsByClass("addr").get(0).text();
				System.out.print(address + "\t");

				if (shop.getElementsByClass("comment-list").size() > 0) {
					String comment = shop.getElementsByClass("comment-list").get(0).text();
					System.out.print(comment + "\t");
				}

				System.out.println();
				Thread.sleep(2000);
			}

		}


	}
}
