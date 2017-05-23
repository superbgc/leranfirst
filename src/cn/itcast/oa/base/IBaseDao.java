package cn.itcast.oa.base;

import java.util.List;

/*
 * 通用Dao接口
 */
public interface IBaseDao<T> {
	/*
	 * 添加功能
	 */
	public void save(T entity);
	public void delete(Long id);
	public void update(T entity);
	//根据id查询一个实体类
	public T getById(Long id);
	//查询所有
	public List<T> findAll();
	//根据id数组查询多个对象实体
	public List<T> getByIds(Long[]ids);
}
