import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV extends Procedure{

	
	public void Task(){
        BufferedReader reader;
        
        try {

            reader = new BufferedReader(new FileReader(myDB.geoCodePath));
         
            // Read the first line or not (comment means yes)
            reader.readLine();
      
            String line = null;
            
            while ((line = reader.readLine()) != null) {               
                String item[] = line.split(",");              
             
                if(item.length == 6){
                	GeoData tmpGData = new GeoData();
                	tmpGData.cityCode = this.ParseCSV(item[0]);
                	tmpGData.cityName = this.ParseCSV(item[1]);
                	tmpGData.townshipCode = this.ParseCSV(item[2]);
                	tmpGData.townshipName = this.ParseCSV(item[3]);
                	tmpGData.totalCode = this.ParseCSV(item[4]);
                	tmpGData.villageName = this.ParseCSV(item[5]);
                
                	//municipality, city code is two digits
                	if(tmpGData.cityCode.length() == 2){
                		tmpGData.townshipCode = tmpGData.totalCode.substring(2, 7);
                	}else{
                		tmpGData.townshipCode = tmpGData.totalCode.substring(5, 7);
                	}
                
                	tmpGData.villageCode = tmpGData.totalCode.substring(7, 10);
                	
                	myDB.geoDataAL.add(tmpGData);
            
                }else{
                	System.out.println(item);
                }
                /*
                for(int i = 0; i < item.length; i++)
                	System.out.println(item[i]);
				*/
            }
            reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
