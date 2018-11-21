package pl.norbert.atj;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Rate")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rate {
	@XmlElement(name = "No")
	private String no;
	@XmlElement(name = "EffectiveDate")
	private String effectiveDate;
	@XmlElement(name = "Mid")
	private double mid;
	@XmlElement(name = "Bid")
	private double bid;
	@XmlElement(name = "Ask")
	private double ask;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public double getMid() {
		return mid;
	}

	public void setMid(double mid) {
		this.mid = mid;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public double getAsk() {
		return ask;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}

}