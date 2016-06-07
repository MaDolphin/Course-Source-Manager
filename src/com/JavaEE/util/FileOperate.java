package com.JavaEE.util;

import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.util.Date;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

/**
 * Created by xfcq on 2016/5/12.
 */
public class FileOperate {
    private static final int BUFFER_SIZE = 16*1024*1024;

    public static void copy(File src, File dst,String filename){
        InputStream in = null;
        OutputStream out = null;
        try{
            if(filename != null){
                delFile(filename);
            }
            in = new BufferedInputStream(new FileInputStream(src),BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst),BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0){
                out.write(buffer,0,len);
            }
            in.close();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void delFile(String filename){
        String src = ServletActionContext.getServletContext().getRealPath(filename);
        File file= new File(src);
        if(file.isFile() && file.exists()){
            file.delete();
        }
    }

    public static boolean office2PDF(String sourceFile, String destFile) {
        Process pro = null;
        OpenOfficeConnection connection = null;
        try {
            if(sourceFile.endsWith(".txt")){
                String odtFile = getFilePrefix(sourceFile)+".odt";
                if(new File(odtFile).exists()){
                    System.out.println("odt文件已存在！");
                    sourceFile = odtFile;
                }else{
                    try {
                        copyFile(sourceFile,odtFile);
                        sourceFile = odtFile;
                    } catch (FileNotFoundException e) {
                        System.out.println("文档不存在！");
                        e.printStackTrace();
                    }
                }
            }

            File inputFile = new File(sourceFile);
            if (!inputFile.exists()) {
                return false;//文件不存在
            }

            //文件夹不存在创建目录
            File outputFile = new File(destFile);
            if (!outputFile.getParentFile().exists()) {
                outputFile.getParentFile().mkdirs();
            }

            String OpenOffice_HOME = "C:\\Program Files (x86)\\OpenOffice 4";
            if (OpenOffice_HOME.charAt(OpenOffice_HOME.length() - 1) != '\\') {
                OpenOffice_HOME += "\\";
            }

            // 启动OpenOffice的服务
            String command = OpenOffice_HOME + "program\\soffice.exe -headless -accept=\"socket,host=127.0.0.1,port=8100;urp;\" -nofirststartwizard";
            pro = Runtime.getRuntime().exec(command);

            // connect to an OpenOffice.org instance running on port 8100
            connection = new SocketOpenOfficeConnection("127.0.0.1", 8100);
            connection.connect();

            // convert
            DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
            converter.convert(inputFile, outputFile);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (ConnectException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(connection!=null){
                // close the connection
                connection.disconnect();
            }
            // 关闭OpenOffice服务的进程
            if(pro!=null){
                pro.destroy();
            }
        }
        return false;
    }

    public static String getFilePrefix(String fileName){
        int splitIndex = fileName.lastIndexOf(".");
        return fileName.substring(0, splitIndex);
    }

    public static String getFileSufix(String fileName){
        int splitIndex = fileName.lastIndexOf(".");
        return fileName.substring(splitIndex + 1);
    }

    public static void copyFile(String inputFile,String outputFile) throws FileNotFoundException{
        File sFile = new File(inputFile);
        File tFile = new File(outputFile);
        FileInputStream fis = new FileInputStream(sFile);
        FileOutputStream fos = new FileOutputStream(tFile);
        int temp = 0;
        try {
            while ((temp = fis.read()) != -1) {
                fos.write(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
