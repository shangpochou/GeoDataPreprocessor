import java.util.ArrayList;

/*
 * Pre-process geo code data.
 * Parse code and make them seperately;
 * For example
 * 1000109028->10001 (city) + 09 (township) + 01 (village)
 * */
public class GeoDataPreprocessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBase myDB = DataBase.GetDataBase();
		
		ArrayList<Procedure> myProcAL = new ArrayList<Procedure>();
		
		ReadCSV myRCSV = new ReadCSV();
		myProcAL.add(myRCSV);
		
		WriteToCSV myWCST = new WriteToCSV();
		myProcAL.add(myWCST);
		
		for(int i = 0; i < myProcAL.size(); i++){
			myProcAL.get(i).GetData(myDB);
			myProcAL.get(i).Task();
		}
	}

}
