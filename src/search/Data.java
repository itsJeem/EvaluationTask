package search;

import java.util.List;

public class Data {
	
	private String postCode;
	private String country;
	private String countryAbbreviation;
	private List<Places> places;
	
	public List<Places> getPlaces() {
		return places;
	}
	public void setPlaces(List<Places> places) {
		this.places = places;
	}
	
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountryAbbreviation() {
		return countryAbbreviation;
	}
	public void setCountryAbbreviation(String countryAbbreviation) {
		this.countryAbbreviation = countryAbbreviation;
	}

	
	


}
