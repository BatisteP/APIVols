package model;

import java.util.ArrayList;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/vols")
public class Vols {
	VolsBD lesvols = new VolsBD();
	@GET
	@Produces("text/json")
	public String getVols() {
		
		String jsonVols = "";
		jsonVols += "{";
		for (Vol vols : lesvols.getVols()) {
			jsonVols += "\n \"numVol\"" + "\""+vols.getNumVol() +"\"";
			jsonVols += "\n \"villedepart\"" + "\""+vols.getVilleDepart() +"\"";
			jsonVols += "\n \"villearrivee\"" + "\""+vols.getVilleArrivee() +"\"";
			jsonVols += "\n \"heurearrivee\"" + "\""+vols.getHeureDepart() +"\"";
			jsonVols += "\n";
			
		}
		jsonVols+="hello";
		jsonVols += "}";
		return jsonVols;
	}
	
	@GET
	@Path( "numVol-{id}" )
	@Produces("text/json")
	public String getVolById (
			@PathParam ("id") String id) {
		Vol v = lesvols.getVol(id);
		String jsonvol = "";
		jsonvol+="{";
		jsonvol += "\n \"numVol\"" + "\""+v.getNumVol() +"\"";
		jsonvol += "\n \"villedepart\"" + "\""+v.getVilleDepart() +"\"";
		jsonvol += "\n \"villearrivee\"" + "\""+v.getVilleArrivee() +"\"";
		jsonvol += "\n \"heurearrivee\"" + "\""+v.getHeureDepart() +"\"";
		jsonvol += "\n";
		jsonvol += "}";
		return jsonvol;
	 }
	@GET
	@Path( "test" )
	@Produces("text/json")
	public String getVolById2 () {
		return "{test}";
		
	 }
	
	@GET
	@Path("search")
	@Produces("text/json")
	public String getVolBySearch(
			@DefaultValue ("all") @QueryParam ( "departure" ) String departure,
			@DefaultValue ("all") @QueryParam ( "arrival" ) String arrival,
			@DefaultValue ("all") @QueryParam ( "departureTime" ) String departureTime
			) {
		ArrayList<Vol> vols = lesvols.searchVols(departure,arrival,departureTime);
		String jsonVols = "";
		for (Vol q : vols) {
			jsonVols += "\n \"numVol\"" + "\""+q.getNumVol() +"\"";
			jsonVols += "\n \"villedepart\"" + "\""+q.getVilleDepart() +"\"";
			jsonVols += "\n \"villearrivee\"" + "\""+q.getVilleArrivee() +"\"";
			jsonVols += "\n \"heurearrivee\"" + "\""+q.getHeureDepart() +"\"";
			jsonVols += "\n";
		}
		jsonVols += "}";
		return jsonVols;
		
		
	}
	@Path("search2")
	@Produces("text/json")
	public String getVolBySearch2(
			@QueryParam ( "departure" ) String departure
			
			) {
		
		return "{"+departure+"}";
		
		
	}

}
