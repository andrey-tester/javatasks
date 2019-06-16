public class matrix {
	public static void main(String[] args) {

		int a = (int)(Math.random()*8+2);
		int b = (int)(Math.random()*8+2);

		int[][] matRix = new int[a][b];
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				matRix[i][j] = (int)(Math.random()*89+10);
			}
		}

		System.out.println("Original matrix (size " + a + " x " + b + "):");
		for (int j = 0; j < b; j++) {
			for (int i = 0; i < a; i++) {
				System.out.print(Integer.toString(matRix[i][j]) + " ");
			}
			System.out.println("");
		}

		System.out.println("Transposed matrix (size " + b + " x " + a + "):");
		int[][] rixMat = new int[b][a];
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				rixMat[j][i] = matRix[i][j];
			}
		}	

		for (int j = 0; j < a; j++) {
			for (int i = 0; i < b; i++) {
				System.out.print(Integer.toString(rixMat[i][j]) + " ");
			}
			System.out.println("");
		}

	}

}