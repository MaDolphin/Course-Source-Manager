package com.JavaEE.serviceimpl;

import com.JavaEE.dao.*;
import com.JavaEE.entity.*;
import com.JavaEE.service.AdminService;
import com.JavaEE.util.FileOperate;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xfcq on 2016/5/12.
 */
public class AdminServiceImpl implements AdminService {
    FileOperate fileOperate = new FileOperate();
    private AdminDao adminDao;
    private CourseDao courseDao;
    private TeacherDao teacherDao;
    private UserDao userDao;
    private CourseInfoDao courseInfoDao;
    private ProductDao productDao;
    private SourceDao sourceDao;
    private WorkInfoDao workInfoDao;
    private MessageDao messageDao;

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public void setCourseInfoDao(CourseInfoDao courseInfoDao) {
        this.courseInfoDao = courseInfoDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void setSourceDao(SourceDao sourceDao) {
        this.sourceDao = sourceDao;
    }

    public void setWorkInfoDao(WorkInfoDao workInfoDao) {
        this.workInfoDao = workInfoDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public boolean addCourse(Course course, String savePath,File uploadFile) {
        String filename = savePath+course.getCouId()+"_"+course.getCouName()+"_"+course.getStartTime().toString()+".jpg";
        String dstPath = ServletActionContext.getServletContext().getRealPath(filename);
        File dstFile = new File(dstPath);
        fileOperate.copy(uploadFile,dstFile,null);
        course.setCouImage(filename);
        if(courseDao.addCourse(course)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteCourse(String couid,Date startTime) {
        List<WorkInfo> homeworkList = workInfoDao.allWorkInfosByCourse(couid,startTime);
        for(int i=0;i<homeworkList.size();i++){
            fileOperate.delFile(homeworkList.get(i).getWorkUrl());
            workInfoDao.deleteWorkInfo(homeworkList.get(i));
        }
        List<Source> sourceList = sourceDao.allSourcesByCourse(couid,startTime);
        for(int i=0;i<sourceList.size();i++){
            fileOperate.delFile(sourceList.get(i).getSrcUrl());
            sourceDao.deleteSource(sourceList.get(i));
        }
        List<Product> productList = productDao.allProductsByCourse(couid);
        for(int i=0;i<productList.size();i++){
            fileOperate.delFile(productList.get(i).getProUrl());
            productDao.deleteProduct(productList.get(i));
        }
        List<CourseInfo> courseInfoList = courseInfoDao.allCourseInfosByCourseForDel(couid,startTime);
        for(int i=0;i<courseInfoList.size();i++){
            courseInfoDao.deleteCourseInfo(courseInfoList.get(i));
        }
        Course course=courseDao.queryCourseByID(couid,startTime);
        if(course != null){
            if(course.getCouImage().equals("/upload/images/course/default.jpg") == false){
                fileOperate.delFile(course.getCouImage());
            }
            courseDao.deleteCourse(course);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean loadCourseInfo(String uploadFileFileName) {
        //读取刚才上传文件，确保路径相同
        String targetDirectory = ServletActionContext.getServletContext().getRealPath(uploadFileFileName);
        File target = new File(targetDirectory);
//        1.HSSFWorkbook只能用来读取2003前（含）的版本， .xls  读取Excel2007时发生如下异常：
//          org.apache.poi.poifs.filesystem.OfficeXmlFileException: The supplied data appears to be in the Office 2007+ XML.
//                You are calling the part of POI that deals with OLE2 Office Documents.
//                You need to call a different part of POI to process this data (eg XSSF instead of HSSF)
//        2.XSSFWorkbook 只能读取2007版本 .xlsx  读取Excel2003以前（包括2003）的版本时却发生了如下新异常：
//          org.apache.poi.openxml4j.exceptions.InvalidOperationException: Can't open the specified file: '*.xls'

        //XSSF和HSSF虽然在不同的包里，但却引用了同一接口Workbook，可以用下面判断
        Workbook wb = null;
        try{
            FileInputStream fi = new FileInputStream(target);
            if (uploadFileFileName.toLowerCase().endsWith(".xls")) {
                wb = new HSSFWorkbook(fi);
            }else if(uploadFileFileName.toLowerCase().endsWith(".xlsx")) {
                wb = new XSSFWorkbook(fi);
            }

            Sheet sheet = wb.getSheetAt(0);

            int rowNum = sheet.getLastRowNum()+1;
            List courseList = new ArrayList<Course>();
            //i 从1开始表示第一行为标题 不包含在数据中
            for(int i=1;i<rowNum;i++){
                Course course = new Course();
                Row row = sheet.getRow(i);
                int cellNum = row.getLastCellNum();
                for(int j=0;j<cellNum;j++){
                    Cell cell = row.getCell(j);
                    String cellValue = null;
                    switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
                        case 0 : cellValue = String.valueOf((int)cell.getNumericCellValue()); break;
                        case 1 : cellValue = cell.getStringCellValue(); break;
                        case 2 : cellValue = String.valueOf(cell.getDateCellValue()); break;
                        case 3 : cellValue = ""; break;
                        case 4 : cellValue = String.valueOf(cell.getBooleanCellValue()); break;
                        case 5 : cellValue = String.valueOf(cell.getErrorCellValue()); break;
                    }

                    switch(j){//通过列数来判断对应插如的字段
                        //数据中不应该保护ID这样的主键记录
                        //case 0 : user.setId(Integer.valueOf(cellValue));break;
                        case 0 : course.setCouId(Integer.valueOf(cellValue));break;
                        case 1 : course.setCouName(cellValue);break;
                        case 2 : long time = (Long.parseLong(cellValue)-25569)*1000*60*60*24;
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            course.setStartTime(Date.valueOf(sdf.format(time)));break;
                        case 3 : course.setCouType(cellValue);break;
                        case 4 : course.setCouTea(Integer.valueOf(cellValue));break;
                        case 5 : course.setCouInfo(cellValue);break;
                    }
                    course.setCouImage("/upload/images/course/"+"default.jpg");
                    course.setCouStatus(0);
                }
                courseList.add(course);
            }
            courseIntoDB(courseList);
            fileOperate.delFile(uploadFileFileName);
            return true;
        }catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void courseIntoDB(List<Course> courseList) {
        int num = courseList.size();
        for(int i=0; i<num; i++){
            courseDao.addCourse(courseList.get(i));
        }
    }

    @Override
    public boolean batchImportCourse(String uploadFileFileName,String savePath,File uploadFile) {
        long longtime = System.currentTimeMillis();
        uploadFileFileName = savePath+"course_"+longtime+".xlsx";
        String dstPath = ServletActionContext.getServletContext().getRealPath(uploadFileFileName);
        File dstFile = new File(dstPath);
        fileOperate.copy(uploadFile,dstFile,null);
        return this.loadCourseInfo(uploadFileFileName);
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        if(teacherDao.addTeacher(teacher)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean batchImportTeacher(String uploadFileFileName, String savePath, File uploadFile) {
        long longtime = System.currentTimeMillis();
        uploadFileFileName = savePath+"teacher_"+longtime+".xlsx";
        String dstPath = ServletActionContext.getServletContext().getRealPath(uploadFileFileName);
        File dstFile = new File(dstPath);
        fileOperate.copy(uploadFile,dstFile,null);
        return loadTeacherInfo(uploadFileFileName);
    }

    @Override
    public boolean loadTeacherInfo(String uploadFileFileName) {
        //读取刚才上传文件，确保路径相同
        String targetDirectory = ServletActionContext.getServletContext().getRealPath(uploadFileFileName);
        File target = new File(targetDirectory);
//        1.HSSFWorkbook只能用来读取2003前（含）的版本， .xls  读取Excel2007时发生如下异常：
//          org.apache.poi.poifs.filesystem.OfficeXmlFileException: The supplied data appears to be in the Office 2007+ XML.
//                You are calling the part of POI that deals with OLE2 Office Documents.
//                You need to call a different part of POI to process this data (eg XSSF instead of HSSF)
//        2.XSSFWorkbook 只能读取2007版本 .xlsx  读取Excel2003以前（包括2003）的版本时却发生了如下新异常：
//          org.apache.poi.openxml4j.exceptions.InvalidOperationException: Can't open the specified file: '*.xls'

        //XSSF和HSSF虽然在不同的包里，但却引用了同一接口Workbook，可以用下面判断
        Workbook wb = null;
        try{
            FileInputStream fi = new FileInputStream(target);
            if (uploadFileFileName.toLowerCase().endsWith(".xls")) {
                wb = new HSSFWorkbook(fi);
            }else if(uploadFileFileName.toLowerCase().endsWith(".xlsx")) {
                wb = new XSSFWorkbook(fi);
            }

            Sheet sheet = wb.getSheetAt(0);

            int rowNum = sheet.getLastRowNum()+1;
            List teacherList = new ArrayList<Teacher>();
            //i 从1开始表示第一行为标题 不包含在数据中
            for(int i=1;i<rowNum;i++){
                Teacher teacher = new Teacher();
                Row row = sheet.getRow(i);
                int cellNum = row.getLastCellNum();
                for(int j=0;j<cellNum;j++){
                    Cell cell = row.getCell(j);
                    String cellValue = null;
                    switch(cell.getCellType()){ //判断excel单元格内容的格式，并对其进行转换，以便插入数据库
                        case 0 : cellValue = String.valueOf((int)cell.getNumericCellValue()); break;
                        case 1 : cellValue = cell.getStringCellValue(); break;
                        case 2 : cellValue = String.valueOf(cell.getDateCellValue()); break;
                        case 3 : cellValue = ""; break;
                        case 4 : cellValue = String.valueOf(cell.getBooleanCellValue()); break;
                        case 5 : cellValue = String.valueOf(cell.getErrorCellValue()); break;
                    }

                    switch(j){//通过列数来判断对应插如的字段
                        //数据中不应该保护ID这样的主键记录
                        //case 0 : user.setId(Integer.valueOf(cellValue));break;
                        case 0 : teacher.setTeaName(cellValue);break;
                        case 1 : teacher.setTeaEmail(cellValue);break;
                        case 2 : teacher.setTeaPwd(cellValue);break;
                    }

                }
                teacher.setTeaStatus(1);
                teacherList.add(teacher);
            }
            teacherIntoDB(teacherList);
            fileOperate.delFile(uploadFileFileName);
            return true;
        }catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void teacherIntoDB(List<Teacher> teacherList) {
        int num = teacherList.size();
        for(int i=0; i<num; i++){
            teacherDao.addTeacher(teacherList.get(i));
        }
    }

    @Override
    public boolean editCourse(Course course, String savePath, File uploadFile) {
        String filename = savePath+course.getCouId()+"_"+course.getCouName()+"_"+course.getStartTime().toString()+".jpg";
        String dstPath = ServletActionContext.getServletContext().getRealPath(filename);
        System.out.println(dstPath);
        File dstFile = new File(dstPath);
        fileOperate.copy(uploadFile,dstFile,filename);
        course.setCouImage(filename);
        if(courseDao.updateCourse(course)){
            return true;
        }else {
            return false;
        }
    }

    public boolean editCourse(Course course) {
        if(courseDao.updateCourse(course)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Course queryCourseByID(String couid,Date startTime) {
        return  courseDao.queryCourseByID(couid,startTime);
    }

    @Override
    public List<User> queryAllUser() {
        return userDao.allUsers();
    }

    @Override
    public List<Course> queryAllCourse() {
        return courseDao.allCourses();
    }

    @Override
    public List<Teacher> queryAllTeacher() {
        return teacherDao.allTeachers();
    }

    @Override
    public List<User> queryAllUserByAuthority() {
        return userDao.allUsersByAuthority();
    }

    @Override
    public boolean existAdmin(String id, String password) {
        return adminDao.existAdmin(id,password);
    }

    @Override
    public Admin queryAdminById(String aid) {
        return adminDao.queryAdminByID(aid);
    }

    @Override
    public boolean editAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    @Override
    public boolean passUser(String userid) {
        User user = userDao.queryUserByID(userid);
        user.setUserStatus(1);
        if(userDao.updateUser(user)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean cancelUser(String userid) {
        User user = userDao.queryUserByID(userid);
        user.setUserStatus(2);
        if(userDao.updateUser(user)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean resetPasswordUser(String userid) {
        User user = userDao.queryUserByID(userid);
        user.setUserPwd("123456");
        if(userDao.updateUser(user)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean resetPasswordTeacher(String teaid) {
        Teacher teacher = teacherDao.queryTeacherByID(teaid);
        teacher.setTeaPwd("123456");
        if(teacherDao.updateTeacher(teacher)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean passTeacher(String teaid) {
        Teacher teacher = teacherDao.queryTeacherByID(teaid);
        teacher.setTeaStatus(1);
        if(teacherDao.updateTeacher(teacher)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean cancelTeacher(String teaid) {
        Teacher teacher = teacherDao.queryTeacherByID(teaid);
        teacher.setTeaStatus(0);
        if(teacherDao.updateTeacher(teacher)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Course> queryAllCourseByTeacher(String teaid) {
        return courseDao.allCoursesByTeacher(teaid);
    }

    @Override
    public Teacher queryTeacherById(String teaid) {
        return teacherDao.queryTeacherByID(teaid);
    }

    @Override
    public boolean editTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }

    @Override
    public User queryUserById(String userid) {
        return userDao.queryUserByID(userid);
    }

    @Override
    public List<Course> queryAllCourseByUser(String userid) {
        return courseDao.allCourseByUser(userid);
    }
}
