package com.vam.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.model.AttachImageVO;
import com.vam.model.AuthorVO;
import com.vam.model.BookVO;

import lombok.extern.log4j.Log4j;


@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AuthorServiceTests {
	
	@Autowired
	private AdminService service;
    
    /*AuthoreService 의존성 주입*/
	/*
	 * @Autowired private AuthorService service;
	 */
    
    /* 상품 등록 & 상품 이미지 등록 테스트 */
	@Test
	public void bookEnrollTEsts() {

		BookVO book = new BookVO();
		// 상품 정보
		book.setBookName("service 테스트");
		book.setAuthorId(7);
		book.setPubleYear("2021-03-18");
		book.setPublisher("출판사");
		book.setCateCode("202001");
		book.setBookPrice(20000);
		book.setBookStock(300);
		book.setBookDiscount(0.23);
		book.setBookIntro("책 소개 ");
		book.setBookContents("책 목차 ");

		// 이미지 정보
		List<AttachImageVO> imageList = new ArrayList<AttachImageVO>(); 
		
		AttachImageVO image1 = new AttachImageVO();
		AttachImageVO image2 = new AttachImageVO();
		
		image1.setFileName("test Image 1");
		image1.setUploadPath("test image 1");
		image1.setUuid("test1111");
		
		image2.setFileName("test Image 2");
		image2.setUploadPath("test image 2");
		image2.setUuid("test2222");
		
		imageList.add(image1);
		imageList.add(image2);
		
		book.setImageList(imageList);        
		
		// bookEnroll() 메서드 호출
		service.bookEnroll(book);
		
		System.out.println("등록된 VO : " + book);
		
		
	}
    
	/*
	 * @Test public void authorEnrollTest() throws Exception {
	 * 
	 * AuthorVO author = new AuthorVO();
	 * 
	 * author.setNationId("01"); author.setAuthorName("테스트");
	 * author.setAuthorIntro("테스트 소개");
	 * 
	 * service.authorEnroll(author);
	 * 
	 * }
	 */
    
    /*작가 상세 페이지*/
	/*
	 * @Test public void authorGetDetailTest() throws Exception {
	 * 
	 * int authorId = 7;
	 * 
	 * log.info("author........." + service.authorGetDetail(authorId)); }
	 */
}