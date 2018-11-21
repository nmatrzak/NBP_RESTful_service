package pl.norbert.atj;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
// for ex. http://localhost:8080/9JA18L07/exchangerates/rates/a/chf/20
@Path("/rates")
public class NBPAverageService {

	@GET
	@Path("{table}/{code}/{topCount}")
	@Produces(MediaType.APPLICATION_XML)
	public Average getAverageXML(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") String topCount) {
		NBPRestClient cl = new NBPRestClient();
		Rates result = cl.getXMLData(table, code, topCount);
		Average avg = new Average();
		avg.setCurrency(code);
		if (table.equals("a") || (table).equals("b")) {
			if (result.getRates().size() <= 0) {
				avg.setAverage(0);
				return avg;
			} else if (result.getRates().size() == 1) {
				avg.setAverage(result.getRates().get(0).getMid());
				return avg;
			} else {
				double sum = 0;
				for (Rate r : result.getRates()) {
					sum += r.getMid();
				}
				avg.setAverage(sum / result.getRates().size());
				return avg;
			}
		} else if (table.equals("c")) {
			if (result.getRates().size() <= 0) {
				avg.setAverage(0);
				return avg;
			} else if (result.getRates().size() == 1) {
				avg.setAverage(result.getRates().get(0).getAsk());
				return avg;
			} else {
				double sum = 0;
				for (Rate r : result.getRates()) {
					sum += r.getAsk();
				}

				avg.setAverage(sum / result.getRates().size());
				return avg;
			}

		}
		return avg;
	}

	@GET
	@Path("{table}/{code}/{topCount}/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAverageJSON(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") String topCount) {
		NBPRestClient cl = new NBPRestClient();
		Rates result = cl.getXMLData(table, code, topCount);
		return result.getRates().toString();
		
	}
	@GET
	@Path("{table}/{code}/{topCount}/text")
	@Produces(MediaType.APPLICATION_XHTML_XML)
	public Average getAverageText(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") String topCount) {
		NBPRestClient cl = new NBPRestClient();
		Rates result = cl.getXMLData(table, code, topCount);
		Average avg = new Average();
		avg.setCurrency(code);
		if (table.equals("a") || (table).equals("b")) {
			if (result.getRates().size() <= 0) {
				avg.setAverage(0);
				return avg;
			} else if (result.getRates().size() == 1) {
				avg.setAverage(result.getRates().get(0).getMid());
				return avg;
			} else {
				double sum = 0;
				for (Rate r : result.getRates()) {
					sum += r.getMid();
				}
				avg.setAverage(sum / result.getRates().size());
				return avg;
			}
		} else if (table.equals("c")) {
			if (result.getRates().size() <= 0) {
				avg.setAverage(0);
				return avg;
			} else if (result.getRates().size() == 1) {
				avg.setAverage(result.getRates().get(0).getAsk());
				return avg;
			} else {
				double sum = 0;
				for (Rate r : result.getRates()) {
					sum += r.getAsk();
				}

				avg.setAverage(sum / result.getRates().size());
				return avg;
			}

		}
		return avg;
}
}
