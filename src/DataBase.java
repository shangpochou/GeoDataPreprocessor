import java.util.*;


public class DataBase {
	
	
	public ArrayList<GeoData> geoDataAL;
	
	public String geoCodePath;

	public String outputCSVPath;
	//singulaton 
	private static DataBase myDataBase;
	
	/*
	 * Constructor, and config here.
	 */
	public DataBase(){
		this.geoCodePath = new String("GeoCode103.csv");
		this.outputCSVPath = new String("GeoCode103New.csv");
		this.geoDataAL = new ArrayList<GeoData>();
	}
	
	public static DataBase GetDataBase(){
		if(myDataBase == null){
			myDataBase = new DataBase();
		}
		return myDataBase;
	}
	
}
