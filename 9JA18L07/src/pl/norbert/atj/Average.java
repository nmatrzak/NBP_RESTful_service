package pl.norbert.atj;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Average {
	private String currency;
	private double average;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

}
