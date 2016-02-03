/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.persistence.converter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
@Converter(autoApply=true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {

	@Override
	public Date convertToDatabaseColumn(LocalDateTime localDtTime) {
		return (localDtTime == null ? null : Date.from(localDtTime.atZone(ZoneId.systemDefault()).toInstant()));
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Date dbData) {
		LocalDateTime res = null;
		if (null != dbData) {
			Instant instant = Instant.ofEpochMilli(dbData.getTime());
			res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		}
		return res;
	}

}
