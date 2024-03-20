package Projects;
import java.util.*;
public class XOGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        char board[][]=new char[3][3];
        for(char ch[]:board) {
        	Arrays.fill(ch,' ');
        }
        char player='X';
        boolean GameOver=false;
        while(!GameOver) {
        	print(board);
        	System.out.print("Enter your position:");
        	int r=in.nextInt();
        	int c=in.nextInt();
        	if(board[r][c]==' ') {
        		board[r][c]=player;
        		GameOver=hasWon(board,player);
        		if(GameOver) {
        			print(board);
        			System.out.println("Player "+player+" has won.");
        		}
        		else {
        			player=(player=='X')? '0' :'X';
        		}
        	}
        	else {
        		System.out.println("Invalid move Try again.");
        	}
        }
	}
	static boolean hasWon(char b[][],char player) {
		for(int r=0;r<3;r++) {
			if(b[r][0]==player && b[r][1]==player && b[r][2]==player) {
				return true;
			}
		}
		for(int c=0;c<3;c++) {
			if(b[0][c]==player && b[1][c]==player && b[2][c]==player) {
				return true;
			}
		}
		if(b[0][0]==player && b[1][1]==player && b[2][2]==player) {
			return true;
		}
		if(b[0][2]==player && b[1][1]==player && b[2][0]==player) {
			return true;
		}
		return false;
	}
	static void print(char b[][]) {
		System.out.println("------");
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(b[i][j]+"|");
			}
			System.out.println();
			System.out.println("------");
		}
	}

}
