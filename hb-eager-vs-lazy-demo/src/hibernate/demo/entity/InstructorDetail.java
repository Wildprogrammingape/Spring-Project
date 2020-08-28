package hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")      								// control+shift+O
public class InstructorDetail {
	
	// annotate the class as an entity and map to database table
	
	// define the fields
	
	// annotate the fields with database column names
	
	// create constructors
	
	// generate getter and setter methods
	
	// generate toString() method
	
	
	@Id    												// primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)   // auto-increment
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	// add new field for instructor(also add getter/setter)
	@OneToOne(mappedBy="instructorDetail", 											// refer to "instructorDetail" property in "Instructor" class
			cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, 
					  CascadeType.REFRESH}) 		
	private Instructor instructor;
	
	
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public InstructorDetail() {
		
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
	
	
	
	
	
}
