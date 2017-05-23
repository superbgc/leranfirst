package cn.itcast.oa.serivce;

import java.util.List;

import cn.itcast.oa.domain.Book;

public interface IBookService {
	public void save(Book entity);
	public void delete(Long id);
	public void update(Book entity);
	//根据id查询一个实体类
	public Book getById(Long id);
	//查询所有
	public List<Book> findAll();
	//根据id数组查询多个对象实体
	public List<Book> getByIds(Long[]ids);
}
