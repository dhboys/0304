package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;
import org.zerock.entity.Todo;

// interface는 빈에 추가 x , 객체만 빈에 추가 가능
public interface TodoMapper {
	@Insert("insert into tbl_todo (title , complete) values(#{title},#{complete})")
	public void insert(Todo todo);
	
}
