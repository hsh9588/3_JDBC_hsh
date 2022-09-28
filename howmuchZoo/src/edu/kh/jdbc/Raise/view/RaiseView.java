package edu.kh.jdbc.Raise.view;

import java.util.Scanner;

import edu.kh.jdbc.main.model.service.ZooService;
import edu.kh.jdbc.main.view.ZooView;

// 키우기 화면
public class RaiseView {
	
	private Scanner sc = new Scanner(System.in);
	
	private ZooService zService = new ZooService();

	public int RaiseMenu() {
		
		int input = -1;
		int subInput = 0;
		int dayCount = 5;
		int actionCount = 25;
		int point = 0;
		
		do {
			
			try {
				for (int r = 4; r >= 0; r--) {
					for (int c = 4; c >= 0; c--) {

						System.out.printf("\n < 얼마쥬 ( How much zoo ) - 육성 목록 - > \n     "
								+ "소지금 : %,d원  Point : %d\n     남은 일수 : %d  남은 행동력 : %d\n\n", 
								zService.moneyInHand(), point, r + 1, c + 1 );
						System.out.println("1. 놀아주기");
						System.out.println("2. 밥주기");
						System.out.println("3. 씻기기");
						System.out.println("4. 방치하기");
						System.out.println("0. 종료하기");
						
						System.out.println();
						
						System.out.print("메뉴 선택 : ");     
						input = sc.nextInt();
						sc.nextLine();
						
						switch (input) {
						case 1: 
							System.out.println();
							System.out.printf("<< %s 놀아주기 선택지 >>\n\n", RaiseAnimalName(ZooView.ChoiceANM));
							System.out.println("1. 격하게 놀아주기\n");
							System.out.println("2. 평범하게 놀아주기\n");
							System.out.println("3. 놀아주는 척 하기");
							System.out.println();
							
							System.out.print("\n메뉴 선택 : ");     
							subInput = sc.nextInt();
							sc.nextLine();
							
							switch (subInput) {
							case 1: point += 3; 
							System.out.printf("\n%s가 충분히 만족했습니다.\n", RaiseAnimalName(ZooView.ChoiceANM));
								break;
							case 2: point += 2; 
							System.out.printf("\n%s가 그럭저럭 만족했습니다.\n", RaiseAnimalName(ZooView.ChoiceANM));
								break;
							case 3: 
								System.out.printf("\n%s가 한심한 눈빛으로 보고있습니다.\n", RaiseAnimalName(ZooView.ChoiceANM));
								break;
							default : System.out.println("잘못 입력하셨습니다. 다시 입력 바랍니다."); 
							c++;
							}
							break;
						case 2: 
							System.out.println();
							System.out.printf("<< %s 밥주기 선택지 >>\n\n", RaiseAnimalName(ZooView.ChoiceANM));
							System.out.println("1. 많이 주기\n");
							System.out.println("2. 적당히 주기\n");
							System.out.println("3. 조금 주기");
							System.out.println();
							
							System.out.print("\n메뉴 선택 : ");     
							subInput = sc.nextInt();
							sc.nextLine();
							
							switch (subInput) {
							case 1: point += 5; 
							System.out.printf("\n%s가 배불러서 행복해합니다.\n", RaiseAnimalName(ZooView.ChoiceANM));
								break;
							case 2: point += 4; 
							System.out.printf("\n%s가 배가 적당히 찼습니다.\n", RaiseAnimalName(ZooView.ChoiceANM));
								break;
							case 3: point += 3; 
							System.out.printf("\n%s가 배가 조금 찼습니다.\n", RaiseAnimalName(ZooView.ChoiceANM));
								break;
							default : System.out.println("잘못 입력하셨습니다. 다시 입력 바랍니다."); 
							c++;
							}
							break;
						case 3: 
							System.out.println();
							System.out.printf("<< %s 씻기기 선택지 >>\n\n", RaiseAnimalName(ZooView.ChoiceANM));
							System.out.println("1. 깨끗하게 씻기기\n\n");
							System.out.println("2. 대충 씻기기\n");
							System.out.println();
							
							System.out.print("\n메뉴 선택 : ");     
							subInput = sc.nextInt();
							sc.nextLine();
							
							switch (subInput) {
							case 1: point += 2; 
							System.out.printf("\n%s가 깨끗해졌습니다.\n", RaiseAnimalName(ZooView.ChoiceANM));
								break;
							case 2: point += 1; 
							System.out.printf("\n%s가 조금 깨끗해졌습니다.\n", RaiseAnimalName(ZooView.ChoiceANM));
								break;
							default : System.out.println("잘못 입력하셨습니다. 다시 입력 바랍니다."); 
							c++;
							}
							break;
						case 4: point -= 10; 
						System.out.printf("\n%s가 울고 있습니다.\n", RaiseAnimalName(ZooView.ChoiceANM));
							break;
						case 0: System.out.println("\n안녕히가시오.");
						break;
						default : System.out.println("메뉴중에 고르시오");
						c++;
						}
						if (input == 0) {
							break;
						}
						actionCount = c;
					}
					if (input == 0) {
						break;
					}
					dayCount = r;
				}
				
				if (point < 0) {
					System.out.printf("%s가 도망갔습니다.\n", RaiseAnimalName(ZooView.ChoiceANM));
					ZooView.ChoiceANM = 0;
					ZooView.RaisePoint = 0;
					break;
				} else if (dayCount == 0 && actionCount == 0) {
					System.out.printf("\n****** %s가 잘 자랐습니다. ******\n", RaiseAnimalName(ZooView.ChoiceANM));
					System.out.printf("****** 총 %d점수를 얻었습니다. ******\n", point);
					input = 0;
				}
				
			} catch (Exception e) {
				System.out.println("입력이 잘못 되었습니다.");
				e.printStackTrace();
			}
			
		} while(input != 0);
		
		return point;
	}
	
	private String RaiseAnimalName(int choiceANM) {
		
		String AnimalName = "";
		
		switch (choiceANM) {
		case 1: AnimalName += "소"; break;
		case 2: AnimalName += "돼지"; break;
		case 3: AnimalName += "강아지"; break;
		case 4: AnimalName += "고양이"; break;
		default : System.out.println("오류");
		}
		
		return AnimalName;
	}

}
