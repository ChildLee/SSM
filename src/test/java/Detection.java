import cn.util.FtpUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class Detection {
    @Test
    public void ftpTest() {
        FtpUtil.closeConnect();
    }

    @Test
    public void log4j2Test() {
        Logger logger = LogManager.getLogger("log");
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("报错了");
        logger.fatal("毁灭性bug");
    }
}
