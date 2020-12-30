package com.team404.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team404.command.SnsBoardVO;
import com.team404.command.UserVO;
import com.team404.snsboard.service.SnsBoardService;

@Controller
@RequestMapping("/snsBoard")
public class SnsController {
	
	@Autowired
	@Qualifier("snsBoardService")
	private SnsBoardService snsBoardService;
	
	
	@RequestMapping("/snsList")
	public String snsList() {
		return "snsBoard/snsList";
	}

	// 1. snsList에서 전송된 파일을 Param으로 받기, VO객체
	@RequestMapping("/upload")
	@ResponseBody // 다시 응답을 반환
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("content") String content,
			HttpSession session) {
		try {
			UserVO userVO = (UserVO) session.getAttribute("userVO");
			String writer = userVO.getUserId();//작성자 정보

			// 1. 날짜별로 폴더로 관리(많이 사용하지는 않음)
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String fileLoca = sdf.format(date);
			System.out.println(date);
			System.out.println(fileLoca);

			// 2. 저장할 폴더(디렉토리 생성)
			String uploadPath = "C:\\Users\\Win10\\Desktop\\Backup\\국비반자료\\upload\\" + fileLoca;
			File folder = new File(uploadPath);// 경로생성
			if (!folder.exists()) {
				folder.mkdir();// 폴더 생성됨
			}
			
			//3. 서버에 저장할 파일 이름
			String fileRealName = file.getOriginalFilename();//파일 정보(확장자를 포함한 파일 이름)
			long size = file.getSize();//파일의 크기
			String fileExtesnsion = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());
			
			//랜덤한 파일 이름 생성
			UUID uuid = UUID.randomUUID();//16진수의 랜덤한
			String uuids = uuid.toString().replace("-", "");
			
			String fileName = uuids + fileExtesnsion;//랜덤한 식별자 이름 생성 + 확장자
			
			System.out.println("==============================");
			System.out.println("저장할 폴더경로: " + uploadPath);
			System.out.println("파일실제이름: " + fileRealName);
			System.out.println("파일크기: " + size);
			System.out.println("파일확장자: " + fileExtesnsion);
			System.out.println("변경해서 저장할 파일명: " + fileName);
			System.out.println("저장된 날짜: " + fileLoca);
			
			//4.파일 업로드 실행
			File saveFile = new File(uploadPath + "\\" + fileName); 
			file.transferTo(saveFile);
			
			//5. DB에 insert작업 
			//01 VO생성
			SnsBoardVO vo = new SnsBoardVO(0, writer, content, uploadPath, fileName, fileRealName, fileLoca, null);
			Boolean result = snsBoardService.insertFile(vo);//성공: true, 실패: false 리턴
			if(result) {//결과
				return "success";
			} else {
				return "fail";
			}
			
		} catch (NullPointerException e) {
			System.out.println("세션정보가 존재하지 않음");
			return "fail";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		
	}// end
	
	@RequestMapping("/getList")
	@ResponseBody //반환해주는 용도
	public ArrayList<SnsBoardVO> getList(){
		ArrayList<SnsBoardVO> list =  snsBoardService.getList(); 
//		System.out.println(list.toString()); //조회완료
		System.out.println(list.toString());
		
		return list;
	}

	//이미지처리 메서드 방법 01
//	@RequestMapping("/display/{fileLoca}/{fileName:.+}")//fileName뒤에 특수문자를 받는 문법(:.+)
//	@ResponseBody//돌아가야하니
//	public byte[] display(@PathVariable("fileLoca") String fileLoca,
//						  @PathVariable("fileName") String fileName) {
//		System.out.println(fileLoca);
//		System.out.println(fileName);
//		
//		String uploadPath = "C:\\Users\\Win10\\Desktop\\Backup\\국비반자료\\upload\\" + fileLoca;
//		//참조할 경로
//		File file = new File(uploadPath + "\\" + fileName);
//		
//		byte[] result = null;//byte형배열에 이미지 데이터가 하나하나 담긴다(이미지 또한 바이트로 하나씩 찍혀있는데이터니까)
//		try {
			//스프링에서 파일데이터를 복사해서 바이트배열타입으로 리턴해주는 메서드
//			result = FileCopyUtils.copyToByteArray(file);
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
	//이미지 처리 메서드 방법 02
	@RequestMapping("/display/{fileLoca}/{fileName:.+}")//fileName뒤에 특수문자를 받는 문법(:.+)
	@ResponseBody 
	public ResponseEntity<byte[]> display(@PathVariable("fileLoca") String fileLoca,
			@PathVariable("fileName") String fileName) {
		System.out.println(fileLoca);
		System.out.println(fileName);
		
		String uploadPath = "C:\\Users\\Win10\\Desktop\\Backup\\국비반자료\\upload\\" + fileLoca;
		
		File file = new File(uploadPath + "\\" + fileName);//참조할 경로
		
		//여기 주목
		ResponseEntity<byte[]> result = null;
		try {
			//1. 헤더 정보
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()));//add(헤더이름, 헤더 값)
			
			//2. body에 담을 내용
			//스프링에서 파일데이터를 복사해서 바이트 배열타입으로 리턴해주는 메서드
			byte[] arr = FileCopyUtils.copyToByteArray(file);
			
			//(body(바디에 담을 데이터), header(헤더정보), status(상태코드))
			result = new ResponseEntity<byte[]>(arr, header, HttpStatus.OK);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//다운로드 경로 처리
	@RequestMapping("/download/{fileLoca}/{fileName:.+}")
	@ResponseBody
	public ResponseEntity<byte[]> download(@PathVariable("fileLoca") String fileLoca,
						   				   @PathVariable("fileName") String fileName) {
		
		String uploadPath = "C:\\Users\\Win10\\Desktop\\Backup\\국비반자료\\upload\\" + fileLoca;
		//참조할 경로
		File file = new File(uploadPath + "\\" + fileName);
		
		//파일 다운로드는 응답문서에 브라우저가 어떻게 처리해야되는지에 대한 내용을 담아서 보냅니다
		ResponseEntity<byte[]> result = null;
		try {
			//1. Content-Disposition이 attachment인 경우 파일 다운로드가 실행된다
			//브라우저 마다 Content-Disposition의 작성내용이 조금씩 다르다
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Disposition", "attachment; filename=" + fileName);//filename: 어떤 이름으로 내릴것인가
			
			//2. 바디에 담을 데이터
			byte[] arr = FileCopyUtils.copyToByteArray(file);
			
			result = new ResponseEntity<byte[]>(arr, header, HttpStatus.OK);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		byte[] result = null;//이진법 데이터로 넘겨주기위해 byte[]로 받음
//		try {
//			result = FileCopyUtils.copyToByteArray(file);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		return result;
	}//end download
	
	
}











































