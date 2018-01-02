package com.dlz.framework.logger;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.LoggingEvent;

public class MyLoggerLogback extends MyLogger{
	private static final String FQCN = MyLoggerLogback.class.getName();
	private Logger logger;
	
	private void Logging(Level level,  Object msg,  Throwable t,Object[] params) {
	    if (logger.getEffectiveLevel().levelInt > level.levelInt) {
	        return;
	    }
	    logger.callAppenders(new LoggingEvent(FQCN, logger, level, msg.toString(), t, params));
	}
	 
	MyLoggerLogback(String name) {
		this.logger=(Logger)LoggerFactory.getLogger(name);
	}
	public void debug(Object message, Throwable t,Object ... paras) {
		Logging(Level.DEBUG, message,t,paras);
	}
	public void error(Object message,Throwable t,Object ...paras) {
		Logging(Level.ERROR, message, t,paras);
	}
	public void warn(Object message, Throwable t,Object ...paras) {
		Logging(Level.WARN, message, t,paras);
	}
	public void info(Object message, Throwable t,Object ...paras) {
		Logging(Level.INFO, message, t,paras);
	}
	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}
	public boolean isWarnEnabled() {
		return logger.isEnabledFor(Level.WARN);
	}
	public boolean isErrorEnabled() {
		return logger.isEnabledFor(Level.ERROR);
	}
}