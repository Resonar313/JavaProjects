package pokergame;

class Card {
	
	int num;
	String shape;

	public Card() {
		
		int selectcard = (int)(Math.random()*4);
		int tem = (int)(Math.random()*13);
		
		switch(selectcard) {
		case 0 : this.shape = "clov"; break;
		case 1 : this.shape = "heart"; break;
		case 2 : this.shape = "dia"; break;
		case 3 : this.shape = "spade"; break;
		}
		
		this.num = tem;

	}
	
}


public class Player {
	

	public Card dc[] = new Card[5];
	public Card pc[] = new Card[5];

	
	public Player() {
		
		for(int i=0; i<5; i++) {
			
			if(i>0) {
				
				dc[i] = new Card();
				//	dc[i].num = (dc[i-1].num+1);
				//	dc[i].shape = dc[i-1].shape;
				// 스트레이트 플러쉬 판정용
				
				for(int j=0; j<i; j++) {
					if(dc[i].num == dc[j].num && dc[i].shape == dc[j].shape) {
						dc[i] = null;
						i--;
					}
				}
				
			} else {
				dc[i] = new Card();
			}
		}
		
		
		
		for(int i=0; i<5; i++) {
			
			boolean flag = false;
			
			if(i>0) {
				pc[i] = new Card();
				
				for(int j=0; j<i; j++) {
					if(pc[i].num == pc[j].num && pc[i].shape == pc[j].shape) {
						
						flag = true;
					}
				}
				
				for(int k=0; k<5; k++) {
					if (pc[i].num == dc[k].num && pc[i].shape == dc[k].shape) {
						
						flag = true;
					}
				}
				
				if(flag) {
					pc[i] = null;
					i--;
				}
				
				
			} else {
				pc[i] = new Card();
			}
		}
		
//		pc[0].num = 3;
//		pc[1].num = 3;
//		pc[2].num = 3;
//		pc[3].num = 5;
//		pc[4].num = 5;
//		풀하우스 판정용
	}
	
	public int rank(Card[] c) {
		int rank = 0;
		// 기본 0, 원페어 1, 투페어 2, 쓰오카 3, 
		// 스트레이트 4, 플러쉬 5, 풀하우스 6, 포카 7, 스트레이트플러쉬 8
		int shapecount = 0;
		int paircount = 0;
		int stcount = 0;
		String temp = "";

		for(int i=0; i<c.length; i++) {

			if(i>0) {
				if(c[i].shape == temp) {
					shapecount++;
				}
				
			} else {
				temp = c[i].shape;
			}
			
		}
		
		for(int i=0; i<c.length; i++) {
			
			for(int j=0; j<c.length; j++) {
				
				if(i!=j) {
					if(c[i].num == c[j].num) {
						paircount++;
					}
				}

			}
		}
		
		for(int i=0; i<c.length; i++) {
			
			if(i>0) {
				if(c[i].num == (c[i-1].num+1)) {
					stcount++;
				}
			}
		}
		
		if(paircount==2) {
			rank = 1; // 원페어
		} else if(paircount==4) {
			rank = 2; // 투페어
		} else if(paircount==6) {
			rank = 3; // 삼
		} else if(paircount==8) {
			rank = 6; // 풀하우스
		} else if(paircount==12) {
			rank = 7; // 포카
		}
		
		if(stcount==4 && rank<4) {
			rank = 4; // 스트레이트
		}
		
		if(shapecount==4 && rank<5) {
			
			rank = 5; // 플러쉬
			
			if(stcount==4) {
				rank = 8; // 스트레이트플러쉬
			}
		}
		return rank;
	}


}
