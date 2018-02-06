package cn.com.start.webBack.mapper;

import java.io.Serializable;

public interface BaseMapper<T extends Serializable> {

	// 新增
	int insert(T record);

	// 删除
	int delete(T record);

	// 修改
	int update(T record);

	// 查询
	T select(T record);
}