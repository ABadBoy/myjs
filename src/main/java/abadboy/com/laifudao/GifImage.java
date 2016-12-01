package abadboy.com.laifudao;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GifImage {

	public static void main(String[] args) throws IOException {

		Document document = Jsoup
				.connect("http://www.laifudao.com/tupian/gaoxiaogif_1.htm").timeout(6000).get();
		String title = document.title();
		System.out.println(title);

		Elements elements = document.getElementsByClass("pic-content");
		for (Element element : elements) {

			String gifAddress = element.getElementsByTag("a").first().getElementsByTag("img").first().attr("src");

			URL url = new URL(gifAddress);

			BufferedImage image = ImageIO.read(url);


			String gifName = element.getElementsByTag("a").first().getElementsByTag("img").first().attr("alt");


			ImageIO.write(image, "gif", new File("E:\\gaoxiao\\"+gifName+".gif"));

		}
	}

}
