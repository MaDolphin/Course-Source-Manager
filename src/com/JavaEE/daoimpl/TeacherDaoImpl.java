package com.JavaEE.daoimpl;

import com.JavaEE.dao.TeacherDao;
import com.JavaEE.entity.Teacher;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by xfcq on 2016/4/26.
 */
public class TeacherDaoImpl extends HibernateDaoSupport implements TeacherDao {
    @Override
    public boolean addTeacher(Teacher tea) {
        try{
            this.getHibernateTemplate().clear();
            this.getHibernateTemplate().save(tea);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Teacher queryTeacherByID(String teaid) {
        Teacher tea = (Teacher) (getHibernateTemplate().get(Teacher.class,Integer.valueOf(teaid)));
        return tea;
    }

    @Override
    public List<Teacher> allTeachers() {
        List a=(List<Teacher>)this.getHibernateTemplate().find("from Teacher");
        return a;
    }

    @Override
    public boolean existTeacher(String id, String password) {
        List list = (List<Teacher>) this.getHibernateTemplate().find("from Teacher a where a.teaId=? and a.teaPwd=?",new Object[]{Integer.valueOf(id),password});
        if(list.size() == 0)
            return false;
        else return true;
    }

    @Override
    public boolean existTeacherInverify(String id, String password) {
        List list = (List<Teacher>) this.getHibernateTemplate().find("from Teacher a where a.teaId=? and a.teaPwd=? and a.teaStatus=1",new Object[]{Integer.valueOf(id),password});
        if(list.size() == 0)
            return false;
        else return true;
    }

    @Override
    public boolean existTeacherByName(String name) {
        List list = (List<Teacher>) this.getHibernateTemplate().find("from Teacher a where a.teaName=?",name);
        if(list.size() == 0)
            return false;
        else return true;
    }
    @Override
    public boolean existTeacherByEmail(String email) {
        List list = (List<Teacher>) this.getHibernateTemplate().find("from Teacher a where a.teaEmail=?",email);
        if(list.size() == 0)
            return false;
        else return true;
    }

    @Override
    public Teacher queryTeacherByEmail(String email) {
        List list = (List<Teacher>) this.getHibernateTemplate().find("from Teacher a where a.teaEmail=?",email);
        Teacher tea = (Teacher)list.get(0);
        return tea;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        try{
            this.getHibernateTemplate().saveOrUpdate(teacher);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
