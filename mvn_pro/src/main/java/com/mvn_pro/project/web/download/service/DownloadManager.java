package com.mvn_pro.project.web.download.service;

import javax.servlet.http.HttpServletResponse;

public interface DownloadManager {

	void download(String fileName, HttpServletResponse response);
}