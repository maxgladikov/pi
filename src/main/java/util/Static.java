package util;

import org.apache.logging.log4j.Logger;

import lombok.Getter;

public class Static {
	@Getter
	private static Logger log=LogBuilder.build(System.getProperty("user.dir"));
}
