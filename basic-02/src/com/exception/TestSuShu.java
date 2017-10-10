package com.exception;

/*
 * 分析以下需求，并用代码实现：
	(1)打印1-100之间的所有素数及个数
	(2)每行输出5个满足条件的数，之间用空格分隔
	(3)如果一个大于1的自然数，这个数只能被1和其本身整除，这个数就叫素数。
	(4)如：2 3 5 7 11
		判断素数的方法，用一个数分别去除2到num这个数字，如果能被整除，则表明这个数字不是素数，反之则是素数

 */
public class TestSuShu
{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//将求素数的函数进行封装，然后设置为静态，这样就可以直接调用了。
		getPrime(100);

	}


	public static void getPrime(int num){
		int i,j;

		int count=0;			//count为素数个数

		for(i=1;i<=num;i++){   	//在1-num之间的数进行遍历，当这个数有被其他书整除情况下跳出循环，即这个数不是素数。

			for(j=2;j<i;j++){
				if(i%j==0)break;
			}

			if(i==j){       //遍历完成后没有出现i%j==0则 count加1
				count++;
				System.out.print(i+"\t");
				//没出现5个素数进行换行
				if(count%5==0) System.out.println();
			}

		}

	}
}


