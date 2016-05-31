package com.mvn_pro.project.web.download.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mvn_pro.project.utils.PathUtils;
import com.mvn_pro.project.web.download.service.DownloadManager;

@Service
@Transactional
public class DownloadManagerImpl implements DownloadManager {
	
	public static final String FILE_DIRECT = PathUtils.getProjectRootPath();

	@Override
	public void download(String fileName, HttpServletResponse response) {
		// TODO Auto-generated method stub
		File file = new File(FILE_DIRECT +"/"+ fileName);
		if(!file.exists()){
			return;
		}
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new BufferedInputStream(new FileInputStream(file));
			byte [] buffer = new byte[is.available()];
			is.read(buffer);
			is.close();
			response.reset();
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            os = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            
            os.write(buffer);
            os.flush();
            os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
