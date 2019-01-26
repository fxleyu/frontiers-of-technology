package fx.leyu.notes.common.log;

import org.slf4j.Logger;
import java.util.function.Supplier;

public class LogUtils {

    public static void info(Logger logger, String format, Supplier supplier) {
        if (logger.isInfoEnabled()) {
            logger.info(format, supplier.get());
        }
    }

    public static void info(Logger logger, Supplier<String> supplier) {
        if (logger.isInfoEnabled()) {
            logger.info(supplier.get());
        }
    }

    public static void debug(Logger logger, String format, Supplier supplier) {
        if (logger.isDebugEnabled()) {
            logger.info(format, supplier.get());
        }
    }

    public static void debug(Logger logger, Supplier<String> supplier) {
        if (logger.isDebugEnabled()) {
            logger.debug(supplier.get());
        }
    }
}
