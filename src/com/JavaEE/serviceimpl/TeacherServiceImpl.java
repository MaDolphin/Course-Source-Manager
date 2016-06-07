package com.JavaEE.serviceimpl;

import com.JavaEE.dao.*;
import com.JavaEE.entity.*;
import com.JavaEE.service.TeacherService;
import com.JavaEE.util.FileOperate;
import com.JavaEE.util.HtmlOperate;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by xfcq on 2016/5/12.
 */
public class TeacherServiceImpl implements TeacherService,SessionAware {
    FileOperate fileOperate = new FileOperate();
    HtmlOperate htmlOperate = new HtmlOperate();
    private TeacherDao teacherDao;
    private CourseDao courseDao;
    private SourceDao sourceDao;
    private CourseInfoDao courseInfoDao;
    private WorkInfoDao workInfoDao;
    private ProductDao productDao;
    private Map session;

    public void setSession(Map session) {
        this.session = session;
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public void setSourceDao(SourceDao sourceDao) {
        this.sourceDao = sourceDao;
    }

    public void setCourseInfoDao(CourseInfoDao courseInfoDao) {
        this.courseInfoDao = courseInfoDao;
    }

    public void setWorkInfoDao(WorkInfoDao workInfoDao) {
        this.workInfoDao = workInfoDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public boolean existTeacher(String id, String password) {
        return teacherDao.existTeacherInverify(id,password);
    }

    @Override
    public Teacher queryTeacherById(String teaid) {
        return teacherDao.queryTeacherByID(teaid);
    }

    @Override
    public List<Course> queryAllCourseByTeacher(String teaid) {
        return courseDao.allCoursesByTeacher(teaid);
    }

    @Override
    public List<Source> queryAllSourceByCourse(String couid, Date startTime) {
        return sourceDao.allSourcesByCourse(couid,startTime);
    }

    @Override
    public List queryAllCourseInfoByCourse(String couid, Date startTime) {
        return courseInfoDao.allCourseInfosByCourse(couid,startTime);
    }

    @Override
    public List<WorkInfo> queryAllWorkInfoByCourse(String couid, Date startTime) {
        return workInfoDao.allWorkInfosByCourse(couid,startTime);
    }

    @Override
    public List<Product> queryAllProductByCourse(String couid) {
        return productDao.allProductsByCourse(couid);
    }

    @Override
    public Course queryCourseById(String couid, Date startTime) {
        return courseDao.queryCourseByID(couid,startTime);
    }

    @Override
    public boolean addSource(Source source, String savePath, File uploadFile) {
        long longtime = System.currentTimeMillis();
        String filename = savePath+source.getCouId()+"_"+source.getStartTime()+"_"+source.getSrcName()+"_"+longtime+"."+source.getSrcFormat();
        String odtfilename = savePath+source.getCouId()+"_"+source.getStartTime()+"_"+source.getSrcName()+"_"+longtime+".odt";
        String dstPath = ServletActionContext.getServletContext().getRealPath(filename);
        File dstFile = new File(dstPath);
        fileOperate.copy(uploadFile,dstFile,null);
        String pdfFileName = savePath+source.getCouId()+"_"+source.getStartTime()+"_"+source.getSrcName()+"_"+longtime+".pdf";
        String pdfFile = ServletActionContext.getServletContext().getRealPath(pdfFileName);
        switch (source.getSrcFormat()){
            case "doc":
                if(fileOperate.office2PDF(dstPath,pdfFile) == false){
                    fileOperate.delFile(filename);
                    return false;
                }else {
                    fileOperate.delFile(filename);
                }
                break;
            case "docx":
                if(fileOperate.office2PDF(dstPath,pdfFile) == false){
                    fileOperate.delFile(filename);
                    return false;
                }else {
                    fileOperate.delFile(filename);
                }
                break;
            case "ppt":
                if(fileOperate.office2PDF(dstPath,pdfFile) == false){
                    fileOperate.delFile(filename);
                    return false;
                }else {
                    fileOperate.delFile(filename);
                }
                break;
            case "pptx":
                if(fileOperate.office2PDF(dstPath,pdfFile) == false){
                    fileOperate.delFile(filename);
                    return false;
                }else {
                    fileOperate.delFile(filename);
                }
                break;
            case "xls":
                if(fileOperate.office2PDF(dstPath,pdfFile) == false){
                    fileOperate.delFile(filename);
                    return false;
                }else {
                    fileOperate.delFile(filename);
                }
                break;
            case "xlsx":
                if(fileOperate.office2PDF(dstPath,pdfFile) == false){
                    fileOperate.delFile(filename);
                    return false;
                }else {
                    fileOperate.delFile(filename);
                }
                break;
            case "txt":
                if(fileOperate.office2PDF(dstPath,pdfFile) == false){
                    fileOperate.delFile(filename);
                    fileOperate.delFile(odtfilename);
                    return false;
                }else {
                    fileOperate.delFile(filename);
                    fileOperate.delFile(odtfilename);
                }
                break;
            case "pdf":break;
            default:return false;
        }
        source.setSrcUrl(pdfFileName);
        if(sourceDao.addSource(source)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delSource(String srcid) {
        Source source=sourceDao.querySourceByID(srcid);
        if(sourceDao.deleteSource(source)){
            fileOperate.delFile(source.getSrcUrl());
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean openCourse(String couid, Date startTime) {
        Course course=courseDao.queryCourseByID(couid,startTime);
        course.setCouStatus(1);
        if(courseDao.updateCourse(course)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean endCourse(String couid, Date startTime) {
        Course course=courseDao.queryCourseByID(couid,startTime);
        course.setCouStatus(2);
        if(courseDao.updateCourse(course)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean addHomework(WorkInfo workInfo, String workText,String savePath) throws Exception {
        String filename = savePath+workInfo.getCouId()+"_"+workInfo.getStartTime()+"_"+workInfo.getWorkName()+"_"+workInfo.getWorkId()+".pdf";
        String dstPath = ServletActionContext.getServletContext().getRealPath(filename);
        htmlOperate.htmlCode2pdf(workText,dstPath);
        List list = courseInfoDao.allCourseInfosByCourse(String.valueOf(workInfo.getCouId()),workInfo.getStartTime());
        Object[] tmp = null;
        for(int i=0;i<list.size();i++){
            WorkInfo work = new WorkInfo();
            work.setWorkId(workInfo.getWorkId());
            work.setWorkName(workInfo.getWorkName());
            work.setCouId(workInfo.getCouId());
            work.setStartTime(workInfo.getStartTime());
            work.setWorkStatus(workInfo.getWorkStatus());
            work.setCreateTime(workInfo.getCreateTime());
            tmp = (Object[])list.get(i);
            work.setUsrId(Integer.valueOf(tmp[0].toString()));
            work.setWorkUrl(filename);
            if(workInfoDao.addWorkInfo(work) == false){
                fileOperate.delFile(filename);
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean delHomework(String workId) {
        List<WorkInfo> list = workInfoDao.allWorkInfosById(workId);
        for(int i=0;i<list.size();i++){
            if(workInfoDao.deleteWorkInfo((WorkInfo) list.get(i)) == false){
                return false;
            }
        }
        fileOperate.delFile(list.get(0).getWorkUrl());
        return true;
    }

    @Override
    public boolean addProduct(Product product, String savePath, File uploadFile) {
        long longtime = System.currentTimeMillis();
        String filename = savePath+product.getCouId()+"_"+product.getProName()+"_"+longtime+"."+product.getProFormat();
        String odtfilename = savePath+product.getCouId()+"_"+product.getProName()+"_"+longtime+".odt";
        String dstPath = ServletActionContext.getServletContext().getRealPath(filename);
        File dstFile = new File(dstPath);
        fileOperate.copy(uploadFile,dstFile,null);
        String pdfFileName = savePath+product.getCouId()+"_"+product.getProName()+"_"+longtime+".pdf";
        String pdfFile = ServletActionContext.getServletContext().getRealPath(pdfFileName);
        switch (product.getProFormat()){
            case "doc":
                if(fileOperate.office2PDF(dstPath,pdfFile) == false){
                    fileOperate.delFile(filename);
                    return false;
                }else {
                    fileOperate.delFile(filename);
                }
                product.setProUrl(pdfFileName);
                break;
            case "docx":
                if(fileOperate.office2PDF(dstPath,pdfFile) == false){
                    fileOperate.delFile(filename);
                    return false;
                }else {
                    fileOperate.delFile(filename);
                }
                product.setProUrl(pdfFileName);
                break;
            case "ppt":
                if(fileOperate.office2PDF(dstPath,pdfFile) == false){
                    fileOperate.delFile(filename);
                    return false;
                }else {
                    fileOperate.delFile(filename);
                }
                product.setProUrl(pdfFileName);
                break;
            case "pptx":
                if(fileOperate.office2PDF(dstPath,pdfFile) == false){
                    fileOperate.delFile(filename);
                    return false;
                }else {
                    fileOperate.delFile(filename);
                }
                product.setProUrl(pdfFileName);
                break;
            case "xls":
                if(fileOperate.office2PDF(dstPath,pdfFile) == false){
                    fileOperate.delFile(filename);
                    return false;
                }else {
                    fileOperate.delFile(filename);
                }
                product.setProUrl(pdfFileName);
                break;
            case "xlsx":
                if(fileOperate.office2PDF(dstPath,pdfFile) == false){
                    fileOperate.delFile(filename);
                    return false;
                }else {
                    fileOperate.delFile(filename);
                }
                product.setProUrl(pdfFileName);
                break;
            case "txt":
                if(fileOperate.office2PDF(dstPath,pdfFile) == false){
                    fileOperate.delFile(filename);
                    fileOperate.delFile(odtfilename);
                    return false;
                }else {
                    fileOperate.delFile(filename);
                    fileOperate.delFile(odtfilename);
                }
                product.setProUrl(pdfFileName);
                break;
            case "pdf":product.setProUrl(pdfFileName);break;
            default:product.setProUrl(filename);break;
        }
        if(productDao.addProduct(product)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delProduct(String proId) {
        Product product=productDao.queryProductByID(proId);
        if(productDao.deleteProduct(product)){
            fileOperate.delFile(product.getProUrl());
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean editTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }
}
