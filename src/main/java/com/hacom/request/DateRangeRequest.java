package com.hacom.request;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateRangeRequest {
	
	@NotNull 
	private OffsetDateTime from; 
	
	@NotNull 
	private OffsetDateTime to;

}
