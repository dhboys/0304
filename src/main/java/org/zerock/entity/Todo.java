package org.zerock.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// entity 객체는 주로 읽기전용 , 생성자 사용
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

	private Integer tno;
	private String title;
	private boolean complete;
	private Date regdate;
}
