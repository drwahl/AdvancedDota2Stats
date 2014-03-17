public class ad2s {

	public static void main(String[] args) {
		scraper d2scraper = new scraper();
		d2scraper.authenticate();
		d2scraper.getMatchHistory(); /*returns match history data*/
		dbdriver dbdriver = new dbdriver();
		dbdriver.updatedb(); /*update db with data from getMatchHistory*/
	}

}
