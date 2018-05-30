package com.dlz.framework.exception;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.apache.commons.httpclient.HttpException;

/**
 * BaseException for SDK
 */
public class RemoteException extends BaseException {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -5345825923487658213L;
	private static int DEFUALT_ERROR_CODE = 7001;

	private RemoteException(int errorCode, String message, Throwable cause) {
		super(errorCode, message, cause);
	}

	private RemoteException(String message, Throwable cause) {
		super(DEFUALT_ERROR_CODE, message, cause);
	}

	private RemoteException(String message) {
		super(DEFUALT_ERROR_CODE, message, null);
	}
	
	public static RemoteException buildException(String message,Throwable cause){
		RemoteException e = null;
		if(cause!=null && cause instanceof UnknownHostException || cause instanceof HttpException || cause instanceof SocketException) {
			e = new RemoteException(7000,message, cause);
		}else if(cause!=null && cause instanceof IOException){
			e = new RemoteException(7002,message, cause);
		}else{
			e = new RemoteException(message, cause);
		}
		return e;
	}
}