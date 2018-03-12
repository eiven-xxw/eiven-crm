package com.eivencrm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.springframework.boot.web.support.SpringBootServletInitializer;

public class EivenCrmApplication2 extends SpringBootServletInitializer{
	
	
	public static void main(String[] args) {
		try {
			ZipFile zip = new ZipFile("E:\\spring\\spring.zip",Charset.forName("GBK"));
			int count = 0;
			for(Enumeration entries = zip.entries();entries.hasMoreElements();){ 
				count++;
				System.out.println(count);
				ZipEntry entry = (ZipEntry) entries.nextElement(); 
				String zipEntryName = entry.getName();  
				System.out.println(zipEntryName);
				InputStream is = zip.getInputStream(entry);  
				System.out.println(is);
				
				String fileNewName = "E:\\spring\\test\\"+new SimpleDateFormat("yyMMddhhmmssSSS").format(new Date())+count+"-"+ zipEntryName;
				BufferedOutputStream bos = null;
				BufferedInputStream bis = null;
				byte[] buf = new byte[1024];
				try {
					bos = new BufferedOutputStream(new FileOutputStream(fileNewName));
					bis = new BufferedInputStream(is);
					int len = bis.read(buf, 0, 1024); 
					while(-1 != len){
						bos.write(buf, 0, len);  
						len = bis.read(buf); 
					}
					bos.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	}
}
