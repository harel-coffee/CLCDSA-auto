/*
 * ????????????????????? K ???????? D1,D2,...,DK???
 * 
 * ???????????????????? N??????????????? ?????????? N ????????????????????? 
 * ???????????????????????????????????????????? 10??????????????????????????????????????????
 * 
 * ?????????????????????
 */

import java.util.*;
	public class Main{
		public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            // ??
            int n = Integer.parseInt(sc.next());
            int nLen = String.valueOf(n).length();
            int k = Integer.parseInt(sc.next());
            int[] nums = new int[10];
            
            for(int i=0; i<10; i++){
            	nums[i] = i;
            }

            for(int i=0; i<k; i++){
            	int a = Integer.parseInt(sc.next());
            	nums[a] = a+1;
            }
            for(int i=8; i>=0; i--){
            	nums[i] = nums[nums[i]];
            }
            
            // ??
            System.out.println(minObsession(nums, n, nLen-1));

            sc.close();
		}
		
		public static int minObsession(int[] a, int n, int k){
			int kNum = (n/(int)(Math.pow(10, k)))%10;
			int ret = 0;
			int minnext = a[kNum];
			if(kNum == minnext){
				if(k==0){
					ret = n;
				}else{
					ret = minObsession(a, n, k-1);
				}
            }else if(minnext == 10){
            	ret = minObsession(a, (n/(int)(Math.pow(10, k)) + 1) * (int)(Math.pow(10, k)), k+1);
            }else{
            	ret = n - n%((int)(Math.pow(10, k+1))) + minnext * ((int)(Math.pow(10, k)));
            	int min = a[0];
            	for(int i = 0; i<k; i++){
            		ret += ((int)(Math.pow(10, i))) * min;
            	}
            }
            
			return ret;
        }
    }