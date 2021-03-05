package org.zerock.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class TodoDTO {
	// int는 기본이 0
	private Integer tno;
	
	@NotEmpty
	@Length(min = 5 , max = 10)
	private String title;
	// 기본이 false
	private Boolean complete;
	
}
