package com.todo.app.entity;

import lombok.Data;

//テーブルの値を保持
@Data
public class Todo {
	private long id;
	private String title;
	private int done_flg;
	private String time_limit;
	private String remarks;
}