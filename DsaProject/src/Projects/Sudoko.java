package Projects;

public class Sudoko {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 char[][] board= {
                 {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                 {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                 {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                 {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                 {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                 {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                 {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                 {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                 {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                 };
		 sudoko(board);
		 for(int i=0;i<9;i++) {
			 for(int j=0;j<9;j++) {
				 System.out.print(board[i][j]+" ");
			 }
			 System.out.println();
		 }

	}
	static boolean sudoko(char board[][]) {
		int r,c;
		for(r=0;r<9;r++) {
			for(c=0;c<9;c++) {
				if(board[r][c]=='.') {
					for(char i='1';i<='9';i++) {
						if(isSafe(board,r,c,i)) {
							board[r][c]=i;
							
							if(sudoko(board)) {
								return true;
							}
							else {
								board[r][c]='.';
							}
						}					
					}
					return false;
				}
			}
		}
		return true;
	}
	static boolean isSafe(char b[][],int r,int c,char val) {
		for(int i=0;i<9;i++) {
			if(b[i][c]==val) {
				return false;
			}
			if(b[r][i]==val) {
				return false;
			}
			if(b[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3]==val) {
				return false;
			}
		}
		return true;
	}

}
