package es.techedge.isban.authorization.persistence.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The primary key class for the USERS database table.
 * 
 */
@Embeddable
public class UsersPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;

	public UsersPK() {
	}
	
	public UsersPK(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean equals(Object other) {
		return EqualsBuilder.reflectionEquals(this, other);
	}

	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}