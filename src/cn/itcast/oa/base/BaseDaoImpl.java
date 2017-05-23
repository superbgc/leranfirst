package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
/**
 * 通用DAO实现类
 * @author superb
 *
 * @param <T>
 */
public class BaseDaoImpl<T> implements IBaseDao<T>{
	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz;
	public BaseDaoImpl(){
		//获取实体对象
		//this.getclass()获取当前类  
		//getGenicsuperclass()获取父类dao实现
		ParameterizedType superClass=(ParameterizedType)this.getClass().getGenericSuperclass();
		//泛型是可以传入多个参数 这里获取泛型  所以得到的是一个数组
		Type[] types=superClass.getActualTypeArguments();
		//我们这里只有一个泛型参数 所以下标为0的就是我们需要的实体类
		clazz=(Class<T>)types[0];
	}
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		session().save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	T t=(T) sessionFactory.getCurrentSession().get(clazz,id );
	session().delete(t);
		
	}

	@Override
	public void update(T entity) {
		session().update(entity);
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getById(Long id) {
		
		return (T)session().get(clazz, id);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		String hql="from "+clazz.getSimpleName();
		return session().createQuery(hql).list();
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		String hql="from "+clazz.getSimpleName()+" where id in (:ids)";
		Query query=session().createQuery(hql);
		query.setParameterList("ids", ids);//一次赋值多个
		
		return query.list();
	}
	public Session session(){
		return sessionFactory.getCurrentSession();
	}

}
