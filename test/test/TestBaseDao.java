package test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.domain.Book;
import cn.itcast.oa.serivce.IBookService;

public class TestBaseDao {
	
	public IBookService testCase(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService=(IBookService)ctx.getBean("bookServiceImpl");
		return bookService;
	}
	//测试数据库通不通
	@Test
	public void test1(){
		Book book=new Book();
		book.setName("java");
		testCase().save(book);
		
	}
	//测试查询
	@Test
	public void test2(){
		testCase().getById(1l);
	}
	//测试修改
	@Test
	public void test3(){
		Book book=new Book();
		book.setName("superb");
		testCase().update(book);
	}
	//测试删除
	@Test
	public void test4(){
		testCase().delete(1L);
	}
}
