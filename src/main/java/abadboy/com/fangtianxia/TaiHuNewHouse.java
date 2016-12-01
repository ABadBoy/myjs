package abadboy.com.fangtianxia;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by peter zhao on 6/6/2016.
 */
public class TaiHuNewHouse {

	public static String houseName, housePrice;

	public static void main(String[] args) throws IOException {

		for (int i = 1; i < 4; i++) {
			Document document = Jsoup.connect("http://newhouse.wuxi.fang.com/house/s/taihuxinchengbankuai/b9"+i)
					.timeout(6000).get();
			String title = document.title();
			System.out.println(title );

			Element ul = document.getElementsByClass("nl_con").first().getElementsByTag("ul").first();
			Elements li = ul.getElementsByTag("li");
			for (Element element : li) {
				houseName = element.getElementsByClass("nlcd_name").select("a").text();
				housePrice = element.getElementsByClass("nhouse_price").select("span").text();

				System.out.print( houseName + "\t"+housePrice + "\n");

			}
		}


	}


}
