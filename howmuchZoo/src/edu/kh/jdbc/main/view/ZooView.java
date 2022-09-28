package edu.kh.jdbc.main.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.buy.view.BuyView;
import edu.kh.jdbc.buy.vo.Animal;
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
				
				System.out.printf("\n < 얼마쥬 ( How much zoo ) > \n     소지금 : %,d원\n\n", 
						moneyInHand() );
				System.out.println("1. 동물 산다.");
				System.out.println("2. 동물 판다.");
				System.out.println("3. 기록 본다.");
				System.out.println("4. 도 움 말 ");
				System.out.println("0. 종료 한다.");
				
				System.out.print("\n메뉴 선택 : ");
				
				input = sc.nextInt();
				sc.nextLine();
				
				System.out.println();
				
				switch (input) {
				case 1: buyMenu(); break;
				case 2: SellAnimal(ChoiceANM, RaisePoint); break;
				case 3: CheckRecord(); break;
				case 4: HelpPrint(); break;
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
				
				ZooView.RaisePoint = 0;
				ZooView.ChoiceANM = 0;
				
			} else {
				
				System.out.println("현재 판매할 동물이 없습니다.");
			}
			
		} catch (Exception e) {
			System.out.println("동물 판매 중 예외 발생");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 기록 확인(총합 기록 포함)
	 */
	private void CheckRecord() {
		
		int input = -1;
		int AnimalType = 0;
		
		do {
			
			if (ZooView.RaisePoint > 0 && ZooView.ChoiceANM != 0) {
				
				System.out.println("동물을 판매한 후에 이용해주세요.");
				
				break;
				
			} else {
				
				try {
					
					System.out.printf("\n < 얼마쥬 ( How much zoo ) 기록 조회창 > \n     소지금 : %,d원\n\n", 
							moneyInHand() );
							
					System.out.println("1.   소   판매 기록");
					System.out.println("2.  돼지  판매 기록");
					System.out.println("3. 강아지 판매 기록");
					System.out.println("4. 고양이 판매 기록");
					System.out.println("5.  전체  판매 기록");
					System.out.println("0. 종료 한다.");
					
					System.out.print("\n메뉴 선택 : ");
					input = sc.nextInt();
					sc.nextLine();
					
					System.out.println();
					
					switch (input) {
					case 1: AnimalType = 1; break;
					case 2: AnimalType = 2; break;
					case 3: AnimalType = 3; break;
					case 4: AnimalType = 4; break;
					case 5: AnimalType = 5; break;
					case 0: System.out.println("메인메뉴로 돌아갑니다."); break;
					default : System.out.println("메뉴에 작성된 번호를 입력해주세요.");
					}
					
					if (input == 0) break;
						
					List<Animal> animalList = zService.CheckRecord(AnimalType);
					
					if (animalList.isEmpty()) {
						System.out.println("기록이 존재하지 않습니다.");
						
					} else {
						System.out.println("| 순위 | 종  류 | 점수 | 판매가격 |   기록  날짜   |");
						for (Animal a : animalList) {
							System.out.printf("|   %d  | %s |  %3d | %,6d원 | %s |\n", a.getRanking(), a.getAnimalType(), a.getPoint(),
									a.getPrice(), a.getSellDate());
						}
					}
					
				} catch (Exception e) {
					System.out.println("기록 확인 중 예외 발생");
					e.printStackTrace();
				}
			}
			
		} while (input != 0);
	}
	
	private void HelpPrint() {
		System.out.println("*******************************************************");
		System.out.println("안녕하세요. 얼마쥬의 도움말입니다.");
		System.out.println("이 게임은 5일동안 하루마다 5번의 행동 횟수로");
		System.out.println("선택한 동물을 키워서 높은 점수로 판매하는 게임입니다. ");
		System.out.println("그럼 충분히 즐겨주세요.");
		System.out.println("*******************************************************");
	}
}
