package cn.com.start.webBack.service;

import java.io.Serializable;

public interface BaseService<T extends Serializable> {

	void setBaseMapper();

	// 新增
	int insert(T record);

	// 删除
	int delete(T record);

	// 修改
	int update(T record);

	// 查询
	T select(T record);
}
