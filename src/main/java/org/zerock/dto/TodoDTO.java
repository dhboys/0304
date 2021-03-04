package org.zerock.dto;

import lombok.Data;

@Data
public class TodoDTO {
	// int는 기본이 0
	private Integer tno;
	private String title;
	// 기본이 false
	private boolean complete;
	
}
