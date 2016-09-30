package Kong;

import java.util.Scanner;

public class FifthDimension {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][][][][][][][][][][] test = new int [2][2][2][2][2][2] [2][2][2][2] [2];
		for(int i=0; i<test.length; i++){
			for(int j=0; j< test[0].length; j++){
				for(int k=0; k<test[0][0].length; k++){
					for(int l=0; l<test[0][0].length; l++){
						for(int m=0; m<test[0][0].length; m++){
							for (int n = 0; n < test [0] [0].length; n ++){

								for(int o=0; o< test[0].length; o++){
									for(int p=0; p<test[0][0].length; p++){
										for(int q=0; q<test[0][0].length; q++){
											for(int r=0; r<test[0][0].length; r++){
												for (int s = 0; s < test [0] [0].length; s ++){
													
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		for(int i=0; i<test.length; i++){
			for(int j=0; j< test[0].length; j++){
				for(int k=0; k<test[0][0].length; k++){
					for(int l=0; l<test[0][0].length; l++){
						for(int m=0; m<test[0][0].length; m++){
							for (int n = 0; n < test [0] [0].length; n ++){

								for(int o=0; o< test[0].length; o++){
									for(int p=0; p<test[0][0].length; p++){
										for(int q=0; q<test[0][0].length; q++){
											for(int r=0; r<test[0][0].length; r++){
												for (int s = 0; s < test [0] [0].length; s ++){
													System.out.print(test[i][j][k][l][m][n][o][p][q][r][s] + " ");
												}
												System.out.println();
											}
											System.out.println();
										}
										System.out.println();
									}
									System.out.println();
								}
								System.out.println();

							}
							System.out.println();
						}
						System.out.println();
					}
					System.out.println();
				}
				System.out.println();
			}
			System.out.println();
		}
		scan.close();
		//test[i][j][k][l][m][n][o][p][q][r][s] = scan.nextInt();
	}

}
