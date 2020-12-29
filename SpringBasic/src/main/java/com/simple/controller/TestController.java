package com.simple.controller;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.simple.command.MultiUploadVO;
import com.simple.command.UploadVO;

@Controller
@RequestMapping("/fileupload")
public class TestController {

	// 경로에 어떤 파일이름으로 저장할 것인지 까지 설정해 놓을 것
	public static final String UPLOAD_PATH = "C:\\Users\\Win10\\Desktop\\Backup\\국비반자료\\upload";

	// 화면처리
	@RequestMapping("/upload")
	public String upload() {
		return "fileupload/upload";
	}

	// MultipartFile 타입으로 받는다
	@RequestMapping("/upload_ok")
	public String upload_ok(@RequestParam("file") MultipartFile file) {

		try {
			String fileRealName = file.getOriginalFilename();// 파일의 실제이름 가져오기
			long fileSize = file.getSize();// 파일크기 가져오기

			System.out.println("파일실제이름: " + fileRealName);
			System.out.println("파일크기: " + fileSize);

			// lastIndexOf: 뒤에서부터 자르기
			String fileExtention = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());
			System.out.println("확장자: " + fileExtention);

			// 저장경로 다음(\\)에 저장하도록 설정: 파일이 저장될 경로
			File savefile = new File(UPLOAD_PATH + "\\" + fileRealName);
			file.transferTo(savefile);// 파일저장메서드(fileWriter작업을 손쉽게 처리)

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "fileupload/upload_ok";
	}

	@RequestMapping("/upload_ok2")
	public String upload_ok2(MultipartHttpServletRequest files) {

		System.out.println(files.toString());

		List<MultipartFile> list = files.getFiles("files");// 리스트형태로 여러파일을 가져옴

		try {
			for (int i = 0; i < list.size(); i++) {
				String fileRealName = list.get(i).getOriginalFilename();// 파일의 실제이름 가져오기
				long fileSize = list.get(i).getSize();// 파일크기 가져오기

				System.out.println("파일실제이름: " + fileRealName);
				System.out.println("파일크기: " + fileSize);

				// lastIndexOf: 뒤에서부터 자르기
				String fileExtention = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());
				System.out.println("확장자: " + fileExtention);

				// 저장경로 다음(\\)에 저장하도록 설정: 파일이 저장될 경로
				File savefile = new File(UPLOAD_PATH + "\\" + fileRealName);
				list.get(i).transferTo(savefile);// 파일저장메서드(fileWriter작업을 손쉽게 처리)
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "fileupload/upload_ok2";
	}

	// 다중파일 처리2
	@RequestMapping("/upload_ok3")
	public String upload_ok3(@RequestParam("file") List<MultipartFile> list) {

		System.out.println(list.toString());
		try {
			for (int i = 0; i < list.size(); i++) {

				if (list.get(i).isEmpty()) {// 파일이 비어있지 않다면 실행

					String fileRealName = list.get(i).getOriginalFilename();// 파일의 실제이름 가져오기
					long fileSize = list.get(i).getSize();// 파일크기 가져오기
					// lastIndexOf: 뒤에서부터 자르기
					String fileExtention = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());

					System.out.println("파일실제이름: " + fileRealName);
					System.out.println("파일크기: " + fileSize);
					System.out.println("확장자: " + fileExtention);

					// 저장경로 다음(\\)에 저장하도록 설정: 파일이 저장될 경로
					File savefile = new File(UPLOAD_PATH + "\\" + fileRealName);
					list.get(i).transferTo(savefile);// 파일저장메서드(fileWriter작업을 손쉽게 처리)
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "fileupload/upload_ok3";
	}

	//
	@RequestMapping("/upload_ok4")
	public String upload_ok4(MultiUploadVO vo) {

//		System.out.println(vo.getList().toString());
		List<UploadVO> list = vo.getList();
		
		try {
			for (int i = 0; i < list.size(); i++) {

				String name = list.get(i).getName();
				String fileRealName = list.get(i).getFile().getOriginalFilename();// 파일의 실제이름 가져오기
				long fileSize = list.get(i).getFile().getSize();// 파일크기 가져오기
				// lastIndexOf: 뒤에서부터 자르기
				String fileExtention = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());

				System.out.println("텍스트: " + name);
				System.out.println("파일실제이름: " + fileRealName);
				System.out.println("파일크기: " + fileSize);
				System.out.println("확장자: " + fileExtention);

				// 저장경로 다음(\\)에 저장하도록 설정: 파일이 저장될 경로
				File savefile = new File(UPLOAD_PATH + "\\" + fileRealName);
				list.get(i).getFile().transferTo(savefile);// 파일저장메서드(fileWriter작업을 손쉽게 처리)

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return "fileupload/upload_ok4";
	}

}





































