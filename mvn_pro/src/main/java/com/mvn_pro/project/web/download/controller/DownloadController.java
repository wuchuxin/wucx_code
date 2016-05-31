package com.mvn_pro.project.web.download.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvn_pro.project.base.impl.BaseController;
import com.mvn_pro.project.web.download.service.DownloadManager;

@Controller
@RequestMapping("/download")
public class DownloadController extends BaseController {

	@Autowired
	private DownloadManager downloadManager;
	
	@RequestMapping(value="/{param}")
	public void download(@PathVariable String param, HttpServletRequest request, HttpServletResponse response){
		downloadManager.download("note.txt", response);
	}
}
