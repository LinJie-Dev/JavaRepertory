/**
 * 
 */
package com.hjpz.exception;

/**
 * <p>功能描述：自定义异常处理类---FastJsonUtilException</p >
 * @author Architecture
 * @version 1.0
 * @date 2017年11月24日
 */
public class FastJsonUtilException extends Exception  {

	private static final long serialVersionUID = -8846654841826352345L;
	
    public FastJsonUtilException(String msg) {
        super(msg);
    }

    public FastJsonUtilException() {
    	super("FastJson解析出错");
    }
    
}
