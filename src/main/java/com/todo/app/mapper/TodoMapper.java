package com.todo.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.todo.app.entity.Todo;


//DB操作用のインターフェース
//ここからメソッドを呼ぶ-Controller
//実装はxml
@Mapper
public interface TodoMapper {
	
	public List<Todo> selectAll();
	
	//追加機能
	public void add(Todo todo);
	
	//更新機能
	public void update(Todo todo);
	
	//未完了表示
	public List<Todo> selectIncomplete();
	
	//完了表示
	public List<Todo> selectComplete();
	
	//削除機能
	public void delete();

}
