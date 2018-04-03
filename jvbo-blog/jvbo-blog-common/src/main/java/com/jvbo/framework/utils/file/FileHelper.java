package com.jvbo.framework.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class FileHelper {
	public static final int BUFSIZE = 1024 * 8;  

	public FileHelper()
    {
    }
	
	public static void createFolder(String folder)
    {
        File file = new File(folder);
        if(!file.exists())
            file.mkdirs();
    }
	
	public static boolean deleteFile(String absolutePath)
    {
        File f = new File(absolutePath);
        if(f.exists() && f.isFile())
            return f.delete();
        else
            return false;
    }
	
	
	public static String getFileExtName(String fileName)
    {
        int extIndex = fileName.lastIndexOf(".");
        String fileExt = extIndex <= 0 ? "" : fileName.substring(extIndex + 1);
        return fileExt;
    }
	
	public static String getFileFolder(String file)
    {
        file = replace(file, "\\", "/");
        return file.substring(0, file.lastIndexOf("/"));
    }
	
	public static String replace(String inString, String oldPattern, String newPattern)
    {
        if(inString == null)
            return null;
        if(oldPattern == null || newPattern == null)
            return inString;
        StringBuffer sbuf = new StringBuffer();
        int pos = 0;
        int index = inString.indexOf(oldPattern);
        int patLen = oldPattern.length();
        for(; index >= 0; index = inString.indexOf(oldPattern, pos))
        {
            sbuf.append(inString.substring(pos, index));
            sbuf.append(newPattern);
            pos = index + patLen;
        }

        sbuf.append(inString.substring(pos));
        return sbuf.toString();
    }
	
	public static String generateFilePath(){
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		String formatDate = format.format(date);
		return formatDate.substring(0, 4)+"/"+formatDate.substring(4, 6)+"/"+formatDate.substring(6, formatDate.length())+"/";
	}
	
    
    @SuppressWarnings("resource")
	public static void mergeFiles(String outFile, String[] files) {  
        FileChannel outChannel = null;  
        System.out.println("Merge " + Arrays.toString(files) + " into " + outFile);  
        try {  
            outChannel = new FileOutputStream(outFile).getChannel();  
            for(String f : files){  
            	if(StringUtils.isBlank(f)){
            		continue;
            	}
                FileChannel fc = new FileInputStream(f).getChannel();   
                ByteBuffer bb = ByteBuffer.allocate(BUFSIZE);  
                while(fc.read(bb) != -1){  
                    bb.flip();  
                    outChannel.write(bb);  
                    bb.clear();  
                }  
                fc.close();  
            }  
            System.out.println("Merged!! ");  
        } catch (IOException ioe) {  
            ioe.printStackTrace();  
        } finally {  
            try {if (outChannel != null) {outChannel.close();}} catch (IOException ignore) {}  
        }  
    } 
    
    @SuppressWarnings("resource")
	public static void copy(File src,File dest) throws Exception{
		 if(null != dest && !dest.exists()){
			 dest.createNewFile();
		 }
		 FileChannel destChannel = new FileOutputStream(dest).getChannel();
		 MappedByteBuffer buffer=new FileInputStream(src).getChannel().map(FileChannel.MapMode.READ_ONLY,0,src.length());
	     buffer.load();
	     
	     destChannel.write(buffer);
	     buffer = null;
	     destChannel.close();
	}
	
	public static void main(String[] args) {
		System.out.println(generateFilePath());
	}
}
