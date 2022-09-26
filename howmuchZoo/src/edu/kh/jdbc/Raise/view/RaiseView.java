package edu.kh.jdbc.Raise.view;

import java.util.Scanner;

import edu.kh.jdbc.main.model.service.ZooService;

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
				for (int r = 5; r > 0; r--) {
					for (int c = 5; c > 0; c--) {

						System.out.printf("\n < 얼마쥬 ( How much zoo ) - 육성 목록 - > \n	소지금 : %,d원\n남은 일수 : %d  남은 행동력 : %d\n", 
								zService.moneyInHand(), r, c );
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
							System.out.println("1. 격하게 놀아주기\n");
							System.out.println("2. 평범하게 놀아주기\n");
							System.out.println("3. 놀아주는 척 하기\n");
							System.out.println();
							
							System.out.print("\n메뉴 선택 : ");     
							subInput = sc.nextInt();
							sc.nextLine();
							
							switch (subInput) {
							case 1: point += 3; break;
							case 2: point += 3; break;
							case 3: break;
							default : System.out.println("잘못 입력하셨습니다. 다시 입력 바랍니다."); c++;
							}
							break;
						case 2: 
							System.out.println();
							System.out.println("1. 많이 주기\n");
							System.out.println("2. 적당히 주기\n");
							System.out.println("3. 조금 주기\n");
							System.out.println();
							
							System.out.print("\n메뉴 선택 : ");     
							subInput = sc.nextInt();
							sc.nextLine();
							
							switch (subInput) {
							case 1: point += 5; break;
							case 2: point += 4; break;
							case 3: point += 3; break;
							default : System.out.println("잘못 입력하셨습니다. 다시 입력 바랍니다."); c++;
							}
							break;
						case 3: 
							System.out.println();
							System.out.println("1. 깨끗하게 씻기기\n\n");
							System.out.println("2. 대충 씻기기\n\n");
							System.out.println();
							
							System.out.print("\n메뉴 선택 : ");     
							subInput = sc.nextInt();
							sc.nextLine();
							
							switch (subInput) {
							case 1: point += 2; break;
							case 2: point += 1; break;
							default : System.out.println("잘못 입력하셨습니다. 다시 입력 바랍니다."); c++;
							}
							break;
						case 4: point -= 10; break;
						case 0: System.out.println("\n안녕히가시오.\n");
						break;
						default : System.out.println("메뉴중에 고르시오");
						}
						if (input == 0) {
							break;
						}
						actionCount--;
					}
					if (input == 0) {
						break;
					}
					dayCount--;
				}
				
				if (point < 0) {
					System.out.println("동물이 도망갔습니다.");
					break;
				} else if (dayCount == 0 && actionCount == 0) {
					System.out.println("******동물이 잘 자랐습니다.******");
					input = 0;
				}
				
			} catch (Exception e) {
				System.out.println("입력이 잘못 되었습니다.");
				e.printStackTrace();
			}
			
		} while(input != 0);
		
		return point;
	}
}
