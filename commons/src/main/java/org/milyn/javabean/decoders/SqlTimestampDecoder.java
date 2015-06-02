package org.milyn.javabean.decoders;

import java.util.Date;

import org.milyn.javabean.DataDecodeException;
import org.milyn.javabean.DecodeType;

/**
* {@link java.sql.Timestamp} data decoder.
*
* Extends {@link org.milyn.javabean.decoders.DateDecoder} and returns
* a java.sql.Timestamp instance.
*
*
* @author <a href="mailto:maurice.zeijen@smies.com">maurice.zeijen@smies.com</a>
*/
@DecodeType(java.sql.Timestamp.class)
public class SqlTimestampDecoder extends DateDecoder
{
	@Override
	public Object decode(String data) throws DataDecodeException {
		Date date = (Date)super.decode(data);
	    return new java.sql.Timestamp(date.getTime());
	}
}

