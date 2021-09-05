package com.hacom.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class TraceMsg {
	
	@Id 
	private ObjectId _id; 
	private String sessionId; 
	private String payload; 
	
	//private OffsetDateTime ts = OffsetDateTime.now();
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	/*public OffsetDateTime getTs() {
		return ts;
	}
	public void setTs(OffsetDateTime ts) {
		this.ts = ts;
	}*/

	
	
}
