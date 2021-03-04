package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	// select 안에 쿼리문만 넣으면 끝
	@Select("select now()")
	public String getTime();
	
	String getTime2();
	
}
