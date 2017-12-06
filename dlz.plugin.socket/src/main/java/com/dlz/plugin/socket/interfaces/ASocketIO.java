package com.dlz.plugin.socket.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.dlz.framework.logger.MyLogger;

/**
 * socket读写方式
 * @author dingkui
 *
 */
public abstract class ASocketIO {
	private static MyLogger logger = MyLogger.getLogger(ASocketIO.class);
	public static byte[] separator=System.getProperty("line.separator").getBytes();
	public static int separatorLen=separator.length;
	
	/**
	 * 补0成指定长度的字符串
	 * @param i
	 * @param length
	 * @return
	 */
	protected static String addZeroBefor(long i,int length){
		String s = String.valueOf(i);
		while(length>s.length()){
			s="0"+s;
		}
		return s;
	}
	
	public void write(OutputStream socketOut,byte[] out,int headerLength) throws IOException{
		String l = addZeroBefor(out.length + separatorLen, headerLength);
		socketOut.write(l.getBytes());
		socketOut.write(out);
		socketOut.write(separator);
	}
	
	protected byte[] readByte(InputStream socketIn,int headerLength) throws IOException {
		try{
			byte[] b=new byte[1];
			byte[] l = new byte[headerLength];
			for(int i=0;i<headerLength;i++){
				socketIn.read(b);
				l[i]=b[0];
			}
			int length = Integer.parseInt(new String(l));
			byte[] strBytes= new byte[length];
			for(int i=0;i<length;i++){
				socketIn.read(b);
				strBytes[i]=b[0];
			}
			return strBytes;
		}catch(IOException e){
			throw e;
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			return null;
		}
	}
	
	public abstract String read(InputStream socketIn) throws IOException;
	public abstract void write(OutputStream socketOut, String ret) throws IOException;
	

	public abstract String client(OutputStream socketOut, String input,InputStream socketIn) throws IOException;
	public abstract void server(OutputStream socketOut, String ret) throws IOException;
}