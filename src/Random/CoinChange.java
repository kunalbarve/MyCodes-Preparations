package Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CoinChange {
	public static int coinChange(int[] coins, int amount) {
		if (amount < 1)
			return 0;
		int[] dp = new int[amount + 1];
		int sum = 0;
		
		HashMap<Integer, List<Integer>> map = new HashMap<>();

		while (++sum <= amount) {
			int min = -1;
			for (int coin : coins) {
				if (sum >= coin && dp[sum - coin] != -1) {
					int temp = dp[sum - coin] + 1;
					
					boolean isMinNegative = (min < 0); 
					boolean isTempSmall = (temp < min);
					
					min = isMinNegative ? temp : (isTempSmall ? temp : min);
					
//					List<Integer> list;
//					if(isMinNegative){
//						if(map.containsKey(sum-coin)){
//							list = map.get(sum-coin);
//							list.add(coin);
//							map.put(sum, list);
//						}else{
//							list = new ArrayList<>();
//							list.add(coin);
//							map.put(sum, list);
//						}
//					}else if(!isMinNegative && isTempSmall){
//						if(map.containsKey(sum-coin)){
//							list = map.get(sum-coin);
//							list.add(coin);
//							map.put(sum, list);
//						}else{
//							list = new ArrayList<>();
//							list.add(coin);
//							map.put(sum, list);
//						}
//					}else{
//						list = map.get(sum-coin);
//						map.put(sum, list);
//					}
					
					List<Integer> list;
					if(!isMinNegative && isTempSmall && temp>1){
						if(map.containsKey(sum-coin)){
							list = map.get(sum-coin);
							list.add(coin);
							map.put(sum, list);
						}else{
							list = new ArrayList<>();
							list.add(coin);
							map.put(sum, list);
						}
					}else if(!isMinNegative && !isTempSmall){
						list = map.get(sum-coin);
						map.put(sum, list);
					}else {
						list = new ArrayList<>();
						list.add(coin);
						map.put(sum, list);
					}
				}
			}
			dp[sum] = min;
			System.out.println(Arrays.toString(dp));
		}
		System.out.println(map);
		return dp[amount];
	}
	
	public static void main(String[] args){
		int[] coins = {9,6,5,1};
		System.out.println(coinChange(coins, 11));
	}
}