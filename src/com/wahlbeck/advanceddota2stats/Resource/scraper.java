import java.net.*;
import java.io.*;

public class scraper {

	public void getMatchHistory(String apikey) throws Exception {
		URL urlString = new URL("https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/v001/?key=" + apikey + "&account_id=0:42440556");
		BufferedReader in = new BufferedReader(
		new InputStreamReader(urlString.openStream()));
		String inputLine;
		/*StringBuilder stringBuilder = new StringBuilder();*/
		while ((inputLine = in.readLine()) != null)
			/*stringBuilder.append(inputLine);*/
			System.out.println(inputLine);
		in.close();
		/*System.out.println(stringBuilder);*/
	}

}
