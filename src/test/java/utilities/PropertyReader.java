package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    
	public Properties loadPropertiesFile(String propertyFilePath){
	    InputStream iStream = null;
	    Properties properties = new Properties();
	      try {
	        // Loading properties file from the path (relative path given here)
	        iStream = new FileInputStream(propertyFilePath);   
	        properties.load(iStream);
	      } catch (IOException e) {
	       // TODO Auto-generated catch block
	       e.printStackTrace();
	      }finally {
	        try {
	          if(iStream != null){
	            iStream.close();
	          }
	        } catch (IOException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	        }
	      }
		return properties;
	    }	  
}
