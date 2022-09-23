package edu.kh.jdbc.buy.view;

import java.util.Scanner;

import edu.kh.jdbc.buy.model.service.buyService;
import edu.kh.jdbc.main.model.service.zooService;
import edu.kh.jdbc.main.view.zooView;

// 구매 메뉴 입/출력 서비스
public class buyView {
	
	private Scanner sc = new Scanner(System.in);
	
	private buyService service = new buyService();
	
	private zooService zservice = new zooService();
	
	public void buyMenu() {
		
		int input = -1;
		
		do {
			
			try {
				System.out.printf("\n < 얼마쥬 ( How much zoo ) - 동물 목록 - > \n	소지금 : %,d원\n\n", 
						zservice.moneyInHand() );
				System.out.println("1.   소   가격 : 10,000원");
				System.out.println("2.  돼지  가격 : 6,000원");
				System.out.println("3. 강아지 가격 : 3,000원");
				System.out.println("4. 고양이 가격 : 3,000원");
				System.out.println("0. 나간다.");
				
				System.out.println();
				
				System.out.print("메뉴 선택 : ");     
				input = sc.nextInt();
				sc.nextLine();
				
				System.out.println();
				
				switch (input) {
				case 1: input = buy(1, -10000); break;
				case 2: break;
				case 3: break;
				case 4: break;
				case 0: break;
				default : System.out.println("< 메뉴 번호만 입력해주세요. >");
				}
				
				System.out.println();
			} catch (Exception e) {
				System.out.println("입력이 잘못 되었습니다.");
				e.printStackTrace();
			}
			
		} while (input != 0);
		
	}

	private int buy(int choice, int buy) {
		
		zooView.choiceANM = 1;
		
		return 0;
	}
}
