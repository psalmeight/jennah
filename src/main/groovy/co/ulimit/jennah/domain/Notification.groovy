package co.ulimit.jennah.domain

import io.leangen.graphql.annotations.GraphQLQuery
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import org.joda.time.LocalDateTime

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Transient
import java.time.Instant

@javax.persistence.Entity
@javax.persistence.Table(name = "notifications", schema = "public")
class Notification {
	
	@GraphQLQuery
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@Column(name = "id", columnDefinition = "uuid")
	@Type(type = "pg-uuid")
	UUID id
	
	@GraphQLQuery
	@Column(name = "\"from\"", columnDefinition = "uuid")
	UUID from
	
	@GraphQLQuery
	@Column(name = "\"to\"", columnDefinition = "uuid")
	UUID to
	
	@GraphQLQuery
	@Column(name = "department", columnDefinition = "uuid")
	UUID department
	
	@GraphQLQuery
	@Column(name = "message", columnDefinition = "varchar")
	String message
	
	@GraphQLQuery
	@Column(name = "title", columnDefinition = "varchar")
	String title
	
	@GraphQLQuery
	@Column(name = "date_notified", columnDefinition = "timestamp")
	Instant dateNotified
	
	@GraphQLQuery
	@Column(name = "date_seen", columnDefinition = "timestamp")
	Instant dateSeen
	
	@GraphQLQuery
	@Transient
	String dateNotifiedString() {
		if (dateNotified != null)
			return new LocalDateTime(dateNotified.toEpochMilli()).toString("MM/dd/yyyy hh:mma")
		else
			return null
	}
	
}
