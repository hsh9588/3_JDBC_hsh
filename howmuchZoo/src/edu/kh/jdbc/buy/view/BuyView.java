package edu.kh.jdbc.buy.view;

import java.util.Scanner;

import edu.kh.jdbc.Raise.view.RaiseView;
import edu.kh.jdbc.buy.model.service.BuyService;
import edu.kh.jdbc.main.model.service.ZooService;
import edu.kh.jdbc.main.view.ZooView;

// 구매 메뉴 입/출력 서비스
public class BuyView {
	
	private Scanner sc = new Scanner(System.in);
	
	private BuyService bService = new BuyService();
	
	private ZooService zService = new ZooService();
	
	private RaiseView raiseView = new RaiseView();
	
	public void buyMenu() {
		
		int input = -1;
		
		do {
			
			try {
				System.out.printf("\n < 얼마쥬 ( How much zoo ) - 동물 목록 - > \n	소지금 : %,d원\n\n", 
						zService.moneyInHand() );
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
				case 1: case 2:  case 3: case 4: input = buy(input); break;
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

	/** 구매 후 소지금 차감과 키우기 화면 전환
	 * @param input
	 * @return 0 또는 -1;
	 */
	private int buy(int input) {
		
		ZooView.ChoiceANM = input; // 1
		
		try {
			
			bService.buy();
			
			if (ZooView.ChoiceANM != 0) {
				
				ZooView.RaisePoint = raiseView.RaiseMenu();
			}
			
		} catch (Exception e) {
			System.out.println("동물 구매중 예외 발생");
			e.printStackTrace();
		}
		
		if(ZooView.RaisePoint > 0 && ZooView.ChoiceANM != 0) {
			SaveAnimal(ZooView.ChoiceANM, ZooView.RaisePoint);
			return 0;
			
		} else {
			
			return -1;
			
		}
	}
	
	/** 동물 기록 서비스
	 * @param choiceANM
	 * @param raisePoint
	 */
	private void SaveAnimal(int choiceANM, int raisePoint) {
		
		try {
			
			if (choiceANM > 0 && raisePoint > 0) {
				zService.SaveAnimal(choiceANM, raisePoint);
			}
			
		} catch (Exception e) {
			System.out.println("동물 기록중 예외 발생");
			e.printStackTrace();
		}
	}

}
