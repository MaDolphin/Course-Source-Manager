package com.JavaEE.action;

import com.JavaEE.dao.TeacherDao;
import com.JavaEE.entity.Teacher;
import com.JavaEE.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TeacherBatchImportAction extends ActionSupport implements SessionAware {
    private AdminService adminService;

    private String uploadFileFileName;
    private File upload;
    //    private String uploadContextType;
    private String savePath;
    private String result;
    private Map session;

    public void setSession(Map session) {
        this.session = session;
    }

    public String getUploadFileFileName() {
        return uploadFileFileName;
    }

    public void setUploadFileFileName(String uploadFileFileName) {
        this.uploadFileFileName = uploadFileFileName;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String executeBatchImportTeacher(){
        if(adminService.batchImportTeacher(this.uploadFileFileName,this.getSavePath(),this.upload)){
            result = "true";
        }else {
            result = "false";
        }
        session.put("result_teacher_batch",result);
        return SUCCESS;
    }
}
