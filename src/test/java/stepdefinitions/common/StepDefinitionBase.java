package stepdefinitions.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;



public class StepDefinitionBase {
	protected Map<String,String> cachedData=new HashMap<String, String>();

	
	public Map<String, String> getCachedData() {
		return cachedData;
	}

	public void putCachedData(String key,String value) {
		this.cachedData.put(key, value);
	}
	
	public void mapAssertion(Map<String,String> baseMap,Map<String,String> mapToCompare) {
		
		String newLine = System.getProperty("line.separator");
		String result="";
		boolean passed=true;
		for(Map.Entry<String,String> baseMapI : baseMap.entrySet()) {
			String key=baseMapI.getKey();
			String expectedValue=baseMapI.getValue();
			String actualValue=mapToCompare.get(key);
			
			if(actualValue.equalsIgnoreCase(expectedValue)) {
				result=result + " " + key + " Matching ," + newLine;
				passed=true&&passed;
			}else {
				result=result + " " + key + " Not Matching," + " Actual : "+ actualValue + " Expected : " + expectedValue +" ,"+newLine;
				passed=false;
			}
			
		}
		
		Assert.assertTrue(result,passed);
		
	}
	

	protected void attachScreenShot() {
		Hooks.attachScreenshot();
		
	}

	
	
	
	
	
}
