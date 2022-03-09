package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
public class Trip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long TripId;

	
	String name;
	
	String destination ;
	Integer duration ;
	@Temporal(TemporalType.DATE)
	Date startDate ;
	
	@Temporal(TemporalType.DATE)
	Date endDate ;

	String purpose ;

	String longitude;
	String latitude;
	
	String image;
	
	@JsonIgnore
	@ManyToOne
	User user;
	
	boolean isMatched;
	
	//Anas
	@JsonIgnore
	@OneToOne
	private TripPlan tripPlan;
	
	
	@OneToOne(mappedBy="trip")
	Location location;
	
	
}
