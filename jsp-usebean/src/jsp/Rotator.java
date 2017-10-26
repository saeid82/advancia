package jsp;

public class Rotator {
	private String image[] = { "image/bigdata.png", 
								"image/business.png" , 
								"image/development.png"};
	
	private String link[] = {"http://www.advancia.it/public/outsourcing/" , 
							 "http://www.advancia.it/public/bi/" , 
							 "http://www.advancia.it/public/systemint/"};
	
	private int selectedIndex = 0;
	
	public String getImage() {
		return image[selectedIndex];
	}
	
	public String getLink() {
		return link[selectedIndex];
	}
	
	public void nextAd() {
		selectedIndex = (selectedIndex +1) % image.length;
	}
	
	
	
	}
