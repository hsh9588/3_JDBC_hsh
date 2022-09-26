package edu.kh.jdbc.main.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.buy.view.BuyView;
import edu.kh.jdbc.main.model.service.ZooService;

// 메인 화면
public class ZooView {
	
	private Scanner sc = new Scanner(System.in);
	
	private ZooService zService = new ZooService();
	
	private BuyView buyView = new BuyView();
	
	public static int ChoiceANM = 0;
	public static int RaisePoint = 0;
	
	public void startMenu() {
		
		int input = -1;
		
		do {
			try {
				
				System.out.printf("\n < 얼마쥬 ( How much zoo ) > \n	소지금 : %,d원\n\n", 
						moneyInHand() );
				System.out.println("1. 동물 산다.");
				System.out.println("2. 동물 판다.");
				System.out.println("3. 기록 본다.");
				System.out.println("4. 대출 한다.");
				System.out.println("0. 종료 한다.");
				
				System.out.print("\n메뉴 선택 : ");
				
				input = sc.nextInt();
				sc.nextLine();
				
				System.out.println();
				
				switch (input) {
				case 1: buyMenu(); break;
				case 2: SellAnimal(ChoiceANM, RaisePoint); break;
				case 3: break;
				case 4: break;
				case 5: break;
				case 0: System.out.println("< 안녕히가세요. >"); break;
				default : System.out.println("< 메뉴에 작성된 번호를 입력해주세요. >");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("\n<< 입력 오류 >>\n");
			}
			
		} while (input != 0);
	}

	/** 현재 소지금 출력
	 * @return result
	 */
	private int moneyInHand() {
		
		int result = 0;
		
		try {
			
			 result = zService.moneyInHand();
			
		} catch (Exception e) {
			System.out.println("\n< 소지금 불러오는데 실패했습니다. >\n");
		}
		return result;
	}
	
	/**
	 * 동물 구매 메뉴 화면
	 */
	private void buyMenu() {
		
		if (ChoiceANM == 0) {
			buyView.buyMenu();
			
		} else {
			System.out.println("현재 동물을 가지고 있습니다.");
		}
	}
	
	/** 동물 판매 ( 소지금 추가 동물선택과 점수 초기화 )
	 * @param choiceANM
	 * @param raisePoint
	 */
	private void SellAnimal(int choiceANM, int raisePoint) {
		
		try {
			
			if (ZooView.RaisePoint > 0 && ZooView.ChoiceANM != 0) {
				
				zService.SellAnimal(ZooView.ChoiceANM, ZooView.RaisePoint);
				
			}
			
		} catch (Exception e) {
			System.out.println("동물 판매 중 예외 발생");
			e.printStackTrace();
		}
		
	}
	
}
