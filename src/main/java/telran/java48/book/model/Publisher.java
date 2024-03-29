package telran.java48.book.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "publisherName")
@Entity

public class Publisher implements Serializable{
	
	private static final long serialVersionUID = 504401368457660385L;
	
	@Id
	String publisherName;
	
	@Override
	public String toString() {
		return publisherName;
	}

}
