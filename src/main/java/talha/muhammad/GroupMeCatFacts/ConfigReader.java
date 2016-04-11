package talha.muhammad.GroupMeCatFacts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader extends GroupmeBot {
		public String getBotID() throws IOException {
		Properties prop = new Properties();
		String botId;
		try {
			
			String propFileName = "config.properties";
			InputStream inputStream;

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} finally {
			botId = prop.getProperty("BotId");
		}
		return botId;
	}
}
