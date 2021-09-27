package pokergame;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Poker extends JFrame{
	
	int money = 10000;
	int bmoney = 0;
	String mm = Integer.toString(money);
	String bmm = Integer.toString(bmoney);
	
	Container c = getContentPane();
	
	JButton start = new JButton("Get Start");
	JButton reset = new JButton("Next");
	JLabel 소지금 = new JLabel("소지금", JLabel.CENTER);
	JButton 기본베팅 = new JButton("기본금 베팅");
	JButton 레이즈 = new JButton("레이즈");
	JButton 폴드 = new JButton("폴드");
	JLabel 돈 = new JLabel(mm, JLabel.CENTER);
	JLabel 베팅금액 = new JLabel("베팅금", JLabel.CENTER);
	JLabel 베팅돈 = new JLabel(bmm, JLabel.CENTER);
	JButton 결과 = new JButton("결과");
	
	JLabel 승부 = new JLabel("유저가 승리했습니다", JLabel.LEFT);
	JLabel 딜러카드 = new JLabel("스트레이트 플러쉬", JLabel.LEFT);
	JLabel 유저카드 = new JLabel("유저카드", JLabel.LEFT);
	Player p = new Player();

	public Poker() {
		
		
		setTitle("Poker Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		c.setLayout(null);
		c.add(start);
		c.add(reset);
		c.add(소지금);
		소지금.setFont(new Font("고딕체", Font.BOLD, 30));
		c.add(돈);
		돈.setFont(new Font("고딕체", Font.BOLD, 25));
		c.add(베팅금액);
		베팅금액.setFont(new Font("고딕체", Font.BOLD, 30));
		c.add(베팅돈);
		베팅돈.setFont(new Font("고딕체", Font.BOLD, 25));
		c.add(기본베팅);
		c.add(레이즈);
		c.add(폴드);
		c.add(결과);
		start.setBounds(520, 30, 120, 25);
		reset.setBounds(640, 30, 120, 25);
		소지금.setBounds(980, 100, 120, 30);
		돈.setBounds(980, 150, 120, 30);
		베팅금액.setBounds(980, 230, 120, 30);
		베팅돈.setBounds(980, 280, 120, 30);
		기본베팅.setBounds(980, 400, 120, 50);
		레이즈.setBounds(920, 500, 120, 50);
		폴드.setBounds(1040, 500, 120, 50);
		결과.setBounds(980, 600, 120, 50);
		
		
		

		ActionListener eventHandler = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				p = new Player();
				
				ImageIcon backcardlo = new ImageIcon
						(Main.class.getResource("../images/back.png"));
				
				JLabel dealer[] = new JLabel[5];
				for(int i=0; i<5; i++) {
					dealer[i] = new JLabel(backcardlo);
				}
				
				JLabel player[] = new JLabel[5];
				for(int i=0; i<5; i++) {
					player[i] = new JLabel(backcardlo);
				}
				
				String numarr[] = {"A", "2", "3", "4", "5", "6", "7",
						"8", "9", "10", "J", "Q", "K"};
				
				ImageIcon clovlo[] = new  ImageIcon[13];
				ImageIcon heartlo[] = new  ImageIcon[13];
				ImageIcon dialo[] = new  ImageIcon[13];
				ImageIcon spadelo[] = new  ImageIcon[13];
				
				for(int i=0; i<numarr.length; i++) {
					String clovpath = "../images/clov_"+numarr[i]+".png";
					clovlo[i] = new ImageIcon(Main.class.getResource(clovpath));
					
					String heartpath = "../images/heart_"+numarr[i]+".png";
					heartlo[i] = new ImageIcon(Main.class.getResource(heartpath));
					
					String diapath = "../images/dia_"+numarr[i]+".png";
					dialo[i] = new ImageIcon(Main.class.getResource(diapath));
					
					String spadepath = "../images/spade_"+numarr[i]+".png";
					spadelo[i] = new ImageIcon(Main.class.getResource(spadepath));
				}
				
				
				int temp = p.dc[0].num;
				for(int i=0; i<13; i++) {
					if(temp == i) {
						if(p.dc[0].shape == "clov") {
							dealer[0] = new JLabel(clovlo[i]);
						}
						if(p.dc[0].shape == "heart") {
							dealer[0] = new JLabel(heartlo[i]);
						}
						if(p.dc[0].shape == "dia") {
							dealer[0] = new JLabel(dialo[i]);
						}
						if(p.dc[0].shape == "spade") {
							dealer[0] = new JLabel(spadelo[i]);
						}
					}
				}
//				for(int k=0; k<p.dc.length; k++) {
//					int temp2 = p.dc[k].num;
//					for(int i=0; i<13; i++) {
//						if(temp2 == i) {
//							if(p.dc[k].shape == "clov") {
//								dealer[k] = new JLabel(clovlo[i]);
//							}
//							if(p.dc[k].shape == "heart") {
//								dealer[k] = new JLabel(heartlo[i]);
//							}
//							if(p.dc[k].shape == "dia") {
//								dealer[k] = new JLabel(dialo[i]);
//							}
//							if(p.dc[k].shape == "spade") {
//								dealer[k] = new JLabel(spadelo[i]);
//							}
//						}
//					}
//				}
				
				for(int k=0; k<p.pc.length; k++) {
					int temp2 = p.pc[k].num;
					for(int i=0; i<13; i++) {
						if(temp2 == i) {
							if(p.pc[k].shape == "clov") {
								player[k] = new JLabel(clovlo[i]);
							}
							if(p.pc[k].shape == "heart") {
								player[k] = new JLabel(heartlo[i]);
							}
							if(p.pc[k].shape == "dia") {
								player[k] = new JLabel(dialo[i]);
							}
							if(p.pc[k].shape == "spade") {
								player[k] = new JLabel(spadelo[i]);
							}
						}
					}
				}

				c.add(dealer[0]);
				dealer[0].setBounds(0, 80, 180, 250);
				c.add(dealer[1]);
				dealer[1].setBounds(150, 80, 180, 250);
				c.add(dealer[2]);
				dealer[2].setBounds(300, 80, 180, 250);
				c.add(dealer[3]);
				dealer[3].setBounds(450, 80, 180, 250);
				c.add(dealer[4]);
				dealer[4].setBounds(600, 80, 180, 250);
				
				c.add(player[0]);
				player[0].setBounds(0, 400, 180, 250);
				c.add(player[1]);
				player[1].setBounds(150, 400, 180, 250);
				c.add(player[2]);
				player[2].setBounds(300, 400, 180, 250);
				c.add(player[3]);
				player[3].setBounds(450, 400, 180, 250);
				c.add(player[4]);
				player[4].setBounds(600, 400, 180, 250);
				
				switch(p.rank(p.dc)) {
				case 0 : 딜러카드 = new JLabel("기본", JLabel.LEFT); break;
				case 1 : 딜러카드 = new JLabel("원페어", JLabel.LEFT); break;
				case 2 : 딜러카드 = new JLabel("투페어", JLabel.LEFT); break;
				case 3 : 딜러카드 = new JLabel("쓰리 오브 카인드", JLabel.LEFT); break;
				case 4 : 딜러카드 = new JLabel("스트레이트", JLabel.LEFT); break;
				case 5 : 딜러카드 = new JLabel("플러쉬", JLabel.LEFT); break;
				case 6 : 딜러카드 = new JLabel("풀하우스", JLabel.LEFT); break;
				case 7 : 딜러카드 = new JLabel("포 오브 카인드", JLabel.LEFT); break;
				case 8 : 딜러카드 = new JLabel("스트레이트 플러쉬", JLabel.LEFT); break;
				}
				switch(p.rank(p.pc)) {
				case 0 : 유저카드 = new JLabel("기본", JLabel.LEFT); break;
				case 1 : 유저카드 = new JLabel("원페어", JLabel.LEFT); break;
				case 2 : 유저카드 = new JLabel("투페어", JLabel.LEFT); break;
				case 3 : 유저카드 = new JLabel("쓰리 오브 카인드", JLabel.LEFT); break;
				case 4 : 유저카드 = new JLabel("스트레이트", JLabel.LEFT); break;
				case 5 : 유저카드 = new JLabel("플러쉬", JLabel.LEFT); break;
				case 6 : 유저카드 = new JLabel("풀하우스", JLabel.LEFT); break;
				case 7 : 유저카드 = new JLabel("포 오브 카인드", JLabel.LEFT); break;
				case 8 : 유저카드 = new JLabel("스트레이트 플러쉬", JLabel.LEFT); break;
				}
			}
			
		};
		
		ActionListener eventHandler2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				c.removeAll();
				
				c.setLayout(null);
				c.add(start);
				c.add(reset);
				c.add(소지금);
				소지금.setFont(new Font("고딕체", Font.BOLD, 30));
				c.add(돈);
				돈.setFont(new Font("고딕체", Font.BOLD, 25));
				c.add(베팅금액);
				베팅금액.setFont(new Font("고딕체", Font.BOLD, 30));
				c.add(베팅돈);
				베팅돈.setFont(new Font("고딕체", Font.BOLD, 25));
				c.add(기본베팅);
				c.add(레이즈);
				c.add(폴드);
				c.add(결과);
				start.setBounds(520, 30, 120, 25);
				reset.setBounds(640, 30, 120, 25);
				소지금.setBounds(980, 100, 120, 30);
				돈.setBounds(980, 150, 120, 30);
				기본베팅.setBounds(980, 400, 120, 50);
				베팅금액.setBounds(980, 230, 120, 30);
				베팅돈.setBounds(980, 280, 120, 30);
				레이즈.setBounds(920, 500, 120, 50);
				폴드.setBounds(1040, 500, 120, 50);
				결과.setBounds(980, 600, 120, 50);
				repaint();
			}
			
		};
		
		start.addActionListener(eventHandler);
		reset.addActionListener(eventHandler2);
		기본베팅.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputmoney = 
						JOptionPane.showInputDialog("기본금 입력");
				int ba = Integer.parseInt(inputmoney);
				
				bmoney += ba;
				c.remove(베팅돈);
				bmm = Integer.toString(bmoney);
				베팅돈 = new JLabel(bmm, JLabel.CENTER);
				c.add(베팅돈);
				베팅돈.setFont(new Font("고딕체", Font.BOLD, 25));
				베팅돈.setBounds(980, 280, 120, 30);
				
				money -= ba;
				c.remove(돈);
				mm = Integer.toString(money);
				돈 = new JLabel(mm, JLabel.CENTER);
				c.add(돈);
				돈.setFont(new Font("고딕체", Font.BOLD, 25));
				돈.setBounds(980, 150, 120, 30);
			}
		});
		
		레이즈.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				money -= bmoney*2;
				c.remove(돈);
				mm = Integer.toString(money);
				돈 = new JLabel(mm, JLabel.CENTER);
				c.add(돈);
				돈.setFont(new Font("고딕체", Font.BOLD, 25));
				돈.setBounds(980, 150, 120, 30);
				
				bmoney += bmoney*2;
				c.remove(베팅돈);
				bmm = Integer.toString(bmoney);
				베팅돈 = new JLabel(bmm, JLabel.CENTER);
				c.add(베팅돈);
				베팅돈.setFont(new Font("고딕체", Font.BOLD, 25));
				베팅돈.setBounds(980, 280, 120, 30);
				
			}
		});
		
		폴드.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bmoney = 0;
				c.remove(베팅돈);
				bmm = Integer.toString(bmoney);
				베팅돈 = new JLabel(bmm, JLabel.CENTER);
				c.add(베팅돈);
				베팅돈.setFont(new Font("고딕체", Font.BOLD, 25));
				베팅돈.setBounds(980, 280, 120, 30);
			}
		});
		
		결과.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(p.rank(p.dc) > p.rank(p.pc)) {
					
					승부 = new JLabel("딜러가 이겼습니다!", JLabel.LEFT);
					bmoney = 0;
					
				} else if(p.rank(p.dc) < p.rank(p.pc)) {
					int tem = 0;
					switch(p.rank(p.pc)) {
					case 0 :  
						tem = bmoney * 1;
						money += tem; 
						break;
					case 1 :  
						tem = bmoney * 1;
						money += tem; 
						break;
					case 2 :  
						tem = bmoney * 2;
						money += tem; 
						break;
					case 3 :  
						tem = bmoney * 3;
						money += tem; 
						break;
					case 4 :  
						tem = bmoney * 4;
						money += tem; 
						break;
					case 5 :  
						tem = bmoney * 5;
						money += tem; 
						break;
					case 6 :  
						tem = bmoney * 7;
						money += tem; 
						break;
					case 7 :  
						tem = bmoney * 20;
						money += tem; 
						break;
					case 8 :  
						tem = bmoney * 50;
						money += tem; 
						break;
					}
					승부 = new JLabel("당신이 이겼습니다! "+tem+"원 획득!", JLabel.LEFT);
					
					bmoney = 0;
					
				} else {
					승부 = new JLabel("무승부", JLabel.LEFT);
				}
				
				
				
				
				
				
				c.add(승부);
				승부.setFont(new Font("고딕체", Font.BOLD, 30));
				c.add(딜러카드);
				딜러카드.setFont(new Font("고딕체", Font.BOLD, 20));
				c.add(유저카드);
				유저카드.setFont(new Font("고딕체", Font.BOLD, 20));
				
				승부.setBounds(250, 340, 500, 50);
				딜러카드.setBounds(780, 100, 200, 50);
				유저카드.setBounds(780, 400, 200, 50);
				
				c.remove(돈);
				mm = Integer.toString(money);
				돈 = new JLabel(mm, JLabel.CENTER);
				c.add(돈);
				돈.setFont(new Font("고딕체", Font.BOLD, 25));
				돈.setBounds(980, 150, 120, 30);
				
				c.remove(베팅돈);
				bmm = Integer.toString(bmoney);
				베팅돈 = new JLabel(bmm, JLabel.CENTER);
				c.add(베팅돈);
				베팅돈.setFont(new Font("고딕체", Font.BOLD, 25));
				베팅돈.setBounds(980, 280, 120, 30);
				
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

}
