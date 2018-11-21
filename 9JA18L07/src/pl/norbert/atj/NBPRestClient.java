package pl.norbert.atj;

import java.io.StringReader;
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class NBPRestClient {

	private Client client = ClientBuilder.newClient();

	private URI uri = URI.create("http://api.nbp.pl");
	private WebTarget webTarget = client.target(uri);

	public NBPRestClient() {
		webTarget = webTarget.path("api").path("exchangerates").path("rates");
	}

	public Rates getXMLData(String table, String code, String topCount) {
		webTarget = webTarget.path(table).path(code).path("last").path(topCount);
		String xml = webTarget.request().accept(MediaType.APPLICATION_XML).get(String.class);
		Rates rates = null;
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Rates.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			rates = (Rates) jaxbUnmarshaller.unmarshal(new StringReader(xml));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return rates;

	}
//	public String getJSONData(String table, String code, String topCount) {
//		webTarget = webTarget.path(table).path(code).path("last").path(topCount).path("?format=json");
//		String json = webTarget.request().accept(MediaType.APPLICATION_JSON).get(String.class);
//		return json;

}
