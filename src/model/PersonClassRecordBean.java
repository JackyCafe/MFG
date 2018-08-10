package model;
// default package
// Generated 2018/8/10 �U�� 02:34:36 by Hibernate Tools 5.1.8.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PersonClassRecord generated by hbm2java
 */
@Entity
@Table(name = "person_class_record", catalog = "mfg_world")
public class PersonClassRecordBean implements java.io.Serializable {

	private Integer id;
	private PersonClassInfoBean personClassInfo;
	private Date classDate;
	private Date testDate;
	private Integer testScore;

	public PersonClassRecordBean() {
	}

	public PersonClassRecordBean(PersonClassInfoBean personClassInfo, Date classDate, Date testDate, Integer testScore) {
		this.personClassInfo = personClassInfo;
		this.classDate = classDate;
		this.testDate = testDate;
		this.testScore = testScore;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_class_id")
	public PersonClassInfoBean getPersonClassInfo() {
		return this.personClassInfo;
	}

	public void setPersonClassInfo(PersonClassInfoBean personClassInfo) {
		this.personClassInfo = personClassInfo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "class_date", length = 10)
	public Date getClassDate() {
		return this.classDate;
	}

	public void setClassDate(Date classDate) {
		this.classDate = classDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "test_date", length = 10)
	public Date getTestDate() {
		return this.testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	@Column(name = "test_score")
	public Integer getTestScore() {
		return this.testScore;
	}

	public void setTestScore(Integer testScore) {
		this.testScore = testScore;
	}

}
