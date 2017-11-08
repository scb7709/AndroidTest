package comm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Evn extends Properties {
	private static Evn evn;

	private Evn() {
		InputStream is = null;
		try {
			is = getClass().getResourceAsStream("/config.properties");
			this.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Evn getInstancEvn() {
		if (evn == null) {
			evn = new Evn();
		}
		return evn;
	}
}
