package com.JavaEE.action;

import com.JavaEE.entity.*;
import com.JavaEE.service.TeacherService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by xfcq on 2016/5/19.
 */
public class TeacherCourseAction extends ActionSupport implements SessionAware {
    private TeacherService teacherService;
    private int teaId;
    private int couId;
    private Date startTime;
    private int srcId;
    private String srcName;
    private String srcType;
    private String srcInfo;
    private String srcFormat;
    private Integer srcNo;
    private String srcUrl;
    private Integer uploader;
    private Timestamp uploadTime;
    private Map session;
    private File upload;
    private String uploadFileName;
    private String uploadContextType;
    private String savePath;
    private String result_source_add;
    private String result_source_del;
    private String result_homework_add;
    private String result_homework_del;
    private String result_product_add;
    private String result_product_del;
    private int workId;
    private String workName;
    private String workText;
    private int proId;
    private String proName;
    private String proType;
    private String proFormat;
    private Integer proNo;
    private String proUrl;

    public void setSession(Map session) {
        this.session = session;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    public int getCouId() {
        return couId;
    }

    public void setCouId(int couId) {
        this.couId = couId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }

    public String getSrcType() {
        return srcType;
    }

    public void setSrcType(String srcType) {
        this.srcType = srcType;
    }

    public String getSrcInfo() {
        return srcInfo;
    }

    public void setSrcInfo(String srcInfo) {
        this.srcInfo = srcInfo;
    }

    public String getSrcFormat() {
        return srcFormat;
    }

    public void setSrcFormat(String srcFormat) {
        this.srcFormat = srcFormat;
    }

    public int getSrcId() {
        return srcId;
    }

    public void setSrcId(int srcId) {
        this.srcId = srcId;
    }

    public Integer getSrcNo() {
        return srcNo;
    }

    public void setSrcNo(Integer srcNo) {
        this.srcNo = srcNo;
    }

    public String getSrcUrl() {
        return srcUrl;
    }

    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl;
    }

    public Integer getUploader() {
        return uploader;
    }

    public void setUploader(Integer uploader) {
        this.uploader = uploader;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadContextType() {
        return uploadContextType;
    }

    public void setUploadContextType(String uploadContextType) {
        this.uploadContextType = uploadContextType;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getResult_source_add() {
        return result_source_add;
    }

    public void setResult_source_add(String result_source_add) {
        this.result_source_add = result_source_add;
    }

    public String getResult_source_del() {
        return result_source_del;
    }

    public void setResult_source_del(String result_source_del) {
        this.result_source_del = result_source_del;
    }

    public String getResult_homework_add() {
        return result_homework_add;
    }

    public void setResult_homework_add(String result_homework_add) {
        this.result_homework_add = result_homework_add;
    }

    public String getResult_homework_del() {
        return result_homework_del;
    }

    public void setResult_homework_del(String result_homework_del) {
        this.result_homework_del = result_homework_del;
    }

    public String getResult_product_del() {
        return result_product_del;
    }

    public void setResult_product_del(String result_product_del) {
        this.result_product_del = result_product_del;
    }

    public String getResult_product_add() {
        return result_product_add;
    }

    public void setResult_product_add(String result_product_add) {
        this.result_product_add = result_product_add;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getWorkText() {
        return workText;
    }

    public void setWorkText(String workText) {
        this.workText = workText;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public String getProFormat() {
        return proFormat;
    }

    public void setProFormat(String proFormat) {
        this.proFormat = proFormat;
    }

    public Integer getProNo() {
        return proNo;
    }

    public void setProNo(Integer proNo) {
        this.proNo = proNo;
    }

    public String getProUrl() {
        return proUrl;
    }

    public void setProUrl(String proUrl) {
        this.proUrl = proUrl;
    }

    public String executeAllCourseByTeacher(){
        List<Course> courseList = teacherService.queryAllCourseByTeacher(String.valueOf(teaId));
        this.session.put("teacherCourseList",courseList);
        return SUCCESS;
    }

    public String initTeacherShowClass(){
        Course course = teacherService.queryCourseById(String.valueOf(couId),startTime);
        this.session.put("teacherCourse",course);
        List<Source> sourceList = teacherService.queryAllSourceByCourse(String.valueOf(couId),startTime);
        this.session.put("teacherSourceList",sourceList);
        List userList = teacherService.queryAllCourseInfoByCourse(String.valueOf(couId),startTime);
        this.session.put("teacherCourseInfoList",userList);
        List<WorkInfo> workInfoList = teacherService.queryAllWorkInfoByCourse(String.valueOf(couId),startTime);
        this.session.put("teacherWorkInfoList",workInfoList);
        List<Product> productList = teacherService.queryAllProductByCourse(String.valueOf(couId));
        this.session.put("teacherProductList",productList);
        return SUCCESS;
    }

    public String executeAddSource(){
        Source source = new Source();
        source.setCouId(couId);
        source.setStartTime(startTime);
        source.setSrcName(srcName);
        source.setSrcType(srcType);
        source.setSrcInfo(srcInfo);
        source.setSrcNo(srcNo);
        Teacher teacher=(Teacher)this.session.get("teacher");
        source.setUploader(teacher.getTeaId());
        source.setSrcFormat(uploadFileName.substring(uploadFileName.lastIndexOf(".")+1));
        if(teacherService.addSource(source,this.getSavePath(),this.upload)){
            result_source_add = "true";
        }else {
            result_source_add = "false";
        }
        session.put("result_source_add",result_source_add);
        return SUCCESS;
    }

    public String executeDeleteSource(){
        if(teacherService.delSource(String.valueOf(srcId))){
            result_source_del = "true";
        }else {
            result_source_del = "false";
        }
        session.put("result_source_del",result_source_del);
        return SUCCESS;
    }

    public String executeOpenCourse(){
        teacherService.openCourse(String.valueOf(couId),startTime);
        return SUCCESS;
    }

    public String executeEndCourse(){
        teacherService.endCourse(String.valueOf(couId),startTime);
        return SUCCESS;
    }

    public String executeAddHomework() throws Exception {
        Timestamp date = new Timestamp(System.currentTimeMillis());
        long longtime = System.currentTimeMillis()/1000;
        WorkInfo workInfo = new WorkInfo();
        workInfo.setWorkId((int) longtime);
        workInfo.setCouId(couId);
        workInfo.setStartTime(startTime);
        workInfo.setWorkName(workName);
        workInfo.setWorkStatus(0);
        workInfo.setCreateTime(date);
        if(this.workText != null){
            if(teacherService.addHomework(workInfo,workText,savePath)){
                result_homework_add = "true";
            }else {
                result_homework_add = "false";
            }
            session.put("result_homework_add",result_homework_add);
        }else {
            result_homework_add = "false";
        }
        return SUCCESS;
    }

    public String executeDeleteHomework(){
        if(teacherService.delHomework(String.valueOf(workId))){
            result_homework_del = "true";
        }else {
            result_homework_del = "false";
        }
        session.put("result_homework_del",result_homework_del);
        return SUCCESS;
    }

    public String executeAddProduct(){
        Product product = new Product();
        product.setCouId(couId);
        product.setProName(proName);
        product.setProType(proType);
        product.setProNo(proNo);
        product.setProFormat(uploadFileName.substring(uploadFileName.lastIndexOf(".")+1));
        if(teacherService.addProduct(product,this.getSavePath(),this.upload)){
            result_product_add = "true";
        }else {
            result_product_add = "false";
        }
        session.put("result_product_add",result_product_add);
        return SUCCESS;
    }

    public String executeDeleteProduct(){
        if(teacherService.delProduct(String.valueOf(proId))){
            result_product_del = "true";
        }else {
            result_product_del = "false";
        }
        session.put("result_product_del",result_product_del);
        return SUCCESS;
    }



}
