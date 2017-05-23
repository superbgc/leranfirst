package cn.itcast.oa.serivce;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.dao.impl.IBookDao;
import cn.itcast.oa.domain.Book;
@Service
@Transactional
public class BookServiceImpl implements IBookService{
	@Resource
	private IBookDao bookdao;

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		bookdao.save(book);
	}
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		bookdao.delete(id);
	}

	@Override
	public void update(Book entity) {
		// TODO Auto-generated method stub
		bookdao.update(entity);
	}

	@Override
	public Book getById(Long id) {
		// TODO Auto-generated method stub
		return bookdao.getById(id);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookdao.findAll();
	}

	@Override
	public List<Book> getByIds(Long[] ids) {
		// TODO Auto-generated method stub
		return bookdao.getByIds(ids);
	}

}
