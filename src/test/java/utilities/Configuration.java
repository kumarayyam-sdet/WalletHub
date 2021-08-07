package utilities;

import java.util.Properties;

public class Configuration {

	private PropertyReader propertyReader =new PropertyReader();
	private Properties urlproperty;
	private Properties credentialproperty;
	private Properties testproperty;
	
	public Properties getUrlproperty() {
		return urlproperty;
	}

	

	public Properties getCredentialproperty() {
		return credentialproperty;
	}

	

	public Properties getTestproperty() {
		return testproperty;
	}

	

	public Configuration initializeConfigFiles() {
		credentialproperty=propertyReader.loadPropertiesFile("src/test/resources/properties/Credentials.properties");
		urlproperty=propertyReader.loadPropertiesFile("src/test/resources/properties/URL.properties");
		testproperty=propertyReader.loadPropertiesFile("src/test/resources/properties/Test.properties");
		return this;
	}	
}
