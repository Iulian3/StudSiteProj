package app.logging.formatters;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class AppLogFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		return "\n\nThread:" + record.getThreadID()+" :: "+record.getSourceClassName()+" :: "
                +record.getSourceMethodName()+" :: "
                +record.getMessage()+"\n";
	}

}
