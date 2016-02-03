/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
@Entity
@Table(name="USERS")
@ToString
public class UserEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="FIRST_NAME", nullable=false,length=100)
	private String firstName;
	@Column(name="LAST_NAME", nullable=false,length=100)
	private String lastName;
	@Column(name="STATUS", nullable=false,length=25)
	private String status;

	public UserEntity() {
	}
	
	public UserEntity(String firstName, String lastName, String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = status;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
