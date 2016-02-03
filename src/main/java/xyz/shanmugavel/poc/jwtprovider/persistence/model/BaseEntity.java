/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.persistence.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="CREATE_DATE", nullable=false)
	LocalDateTime createDate;
	@Column(name="UDATE_DATE", nullable=true)
	LocalDateTime updateDate;
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
}
