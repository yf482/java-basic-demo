package com.exception;

/*
 * �����������󣬲��ô���ʵ�֣�
	(1)��ӡ1-100֮��������������
	(2)ÿ�����5��������������֮���ÿո�ָ�
	(3)���һ������1����Ȼ�������ֻ�ܱ�1���䱾����������ͽ�����
	(4)�磺2 3 5 7 11 
		�ж�����ķ�������һ����ֱ�ȥ��2��num������֣�����ܱ���������������ֲ�������֮��������
	
 */
public class TestSuShu 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//��������ĺ�����з�װ��Ȼ������Ϊ��̬������Ϳ���ֱ�ӵ����ˡ�
		getPrime(100);
				
	}
	
	
	public static void getPrime(int num){
		int i,j;
		
		int count=0;			//countΪ�������
		
		for(i=1;i<=num;i++){   	//��1-num֮�������б���������б������������������ѭ�����������������
			
			for(j=2;j<i;j++){
				if(i%j==0)break;
			}		
			
				if(i==j){       //������ɺ�û�г���i%j==0�� count��1
					count++;
					System.out.print(i+"\t");
					//û����5��������л���
					if(count%5==0) System.out.println();
				}
		
			}

		}
	}


