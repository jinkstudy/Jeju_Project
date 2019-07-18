package com.jeju.tour_method;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.jeju.vo.AdminSelVO;


public class VisitJeju_GyuBeom {

	public static void main(String[] args) {
		//테스트
		VisitJeju_GyuBeom selTest = new VisitJeju_GyuBeom();
		selTest.crawl();
	}


	//WebDriver
	private WebDriver driver;
	private List<WebElement> list;
	private WebElement like;
	private List<WebElement> tag;
	private WebElement last_page_count_text;
	private int last_page_count = 0;

	//Properties
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C:/selenium/chromedriver.exe";

	//크롤링 할 URL
	private String base_url;

	public VisitJeju_GyuBeom() {
		super();

		//System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Driver SetUp
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		driver = new ChromeDriver(options);
		base_url = "https://www.visitjeju.net/kr/detail/list?menuId=DOM_000001718001000000&cate1cd=cate0000000002#p1&region2cd&pageSize=15&sortListType=reviewcnt&viewType=thumb";


	}

	public List<AdminSelVO> crawl() {
		
		AdminSelVO vo = null;
		
		//ArrayList
		List<AdminSelVO> visitJejuArray = new ArrayList<AdminSelVO>();
		
		//Map
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {

			//get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
			driver.get(base_url);
			last_page_count_text = driver.findElement(By.cssSelector("#content > div > div.cont_wrap > div.recommend_area > div.theme_tit_area.clear > div > div > div.page_navi > p"));
			
			int idx = last_page_count_text.getText().toString().indexOf("/");
			String subst = last_page_count_text.getText().toString().substring(idx+1);
			last_page_count = Integer.parseInt(subst);
			//System.out.println(last_page_count);


			for (int j = 0, h=0; j<=last_page_count; j++) {
			//for (int j = 0, h=0; j<=0; j++) {

				list = driver.findElements(By.className("s_tit"));

				for(int i = 0; i < list.size(); i++) {
				
					h++;
					
					vo = new AdminSelVO();
					
					String s_tags = "";

					//1. 타이틀 스트링
					String s_title = list.get(i).getText();
					
					tag = driver.findElements(By.cssSelector("li:nth-child("+(i+1)+") p.item_tag.prev > a") );
					like = driver.findElement(By.cssSelector("#content > div > div.cont_wrap > div.recommend_area > ul > li:nth-child("+(i+1)+") > dl > dd > a:nth-child(2) > p > span.count"));   

					//2. 좋아요 숫자
					int like_number = Integer.parseInt(like.getText().toString().replace(",", ""));
					
					for (int k = 0; k < tag.size(); k++) {
						//3. 태그 스트링
						s_tags += tag.get(k).getText();

					}	
					
					vo.setAdmin_SEL_TITLE(s_title);
					vo.setAdmin_SEL_LIKE(like_number);
					vo.setAdmin_SEL_TAGS(s_tags);
					
					visitJejuArray.add(vo);
										
//					System.out.print(visitJejuArray.size());
//					System.out.print(" | " + visitJejuArray.get(h-1).getAdmin_SEL_TITLE());
//					System.out.print(" | ");
//					System.out.print(visitJejuArray.get(h-1).getAdmin_SEL_LIKE());
//					System.out.print(" | ");
//					System.out.print(visitJejuArray.get(h-1).getAdmin_SEL_TAGS());
//					System.out.println(" /   ");
					
				}
				
				//테스트
//				for(AdminSelVO v : visitJejuArray) {
//					System.out.print(visitJejuArray.size());
//					System.out.print(" | " + v.getADMIN_SEL_TITLE());
//					System.out.print(" | ");
//					System.out.print(v.getADMIN_SEL_LIKE());
//					System.out.print(" | ");
//					System.out.print(v.getADMIN_SEL_TAGS());
//					System.out.println(" /   ");
//				}
//				System.out.println();
								
				driver.findElement(By.className("page-next")).click();
				Thread.sleep(1000);
			}			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("끝");
			driver.close();
		}		

		return visitJejuArray;

	}

}
