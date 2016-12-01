package abadboy.com.douban;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class DouBanHouseMessages {

	public static void main(String[] args) {

		Document document = null;
		String houseLink;
		String houseMessage;
		String userLink;
		String userNmae;
		String response;
		String time;

		try {

			for (int i = 0; i < 2000; i+=25) {
				document = Jsoup.connect("https://www.douban.com/group/pudongzufang/discussion?start="+i)
						.timeout(6000).get();
				Element housesMessages = document.getElementsByTag("tbody").get(1);
				Elements trElements = housesMessages.getElementsByTag("tr");
				for (Element trElement : trElements) {

					if (trElement.getElementsByTag("td").get(0).getElementsByTag("a").size() != 0) {

						Element houseElement = trElement.getElementsByTag("td").get(0);
						houseLink = houseElement.getElementsByTag("a").attr("href");
						System.out.print(houseLink + "\t");
						houseMessage = houseElement.getElementsByTag("a").get(0).ownText();
						System.out.print(houseMessage+ "\t");
						Element userElement = trElement.getElementsByTag("td").get(1);
						userLink = userElement.getElementsByTag("a").attr("href");
						System.out.print(userLink+ "\t");
						userNmae = userElement.getElementsByTag("a").get(0).ownText();
						System.out.print(userNmae+ "\t");
						Element responseElement = trElement.getElementsByTag("td").get(2);
						response = responseElement.ownText();
						System.out.print(response+ "\t");
						Element timeElement = trElement.getElementsByTag("td").get(3);
						time = timeElement.ownText();
						System.out.print(time+ "\t");


						/*PreparedStatement stmt = DatabaseUtil.getConnection().prepareStatement(
								"insert into douban (houseLink,houseMessage,userLink,userNmae,response,time) "
										+ "VALUES(?,?,?,?,?,?)");
						stmt.setString(1,houseLink);
						stmt.setString(2,houseMessage);
						stmt.setString(3,userLink);
						stmt.setString(4,userNmae);
						stmt.setString(5,response);
						stmt.setString(6,time);
						stmt.executeUpdate();*/
					}

					System.out.println();

					Thread.sleep(2000);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}/* catch (SQLException e) {
			e.printStackTrace();
		}*/ catch (InterruptedException e) {
			e.printStackTrace();
		}

	}





}
