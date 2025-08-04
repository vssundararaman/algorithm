public class BestTimeToSellStock {
    
   
   public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + maxProfit(prices));
        System.out.println("Max Profit: " + maxProfit2(prices));

   }

   static int maxProfit(int[] prices) {
        if(prices == null || prices.length==0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = 0;

       for(int i=0; i < prices.length; i++){
            
            if(prices[i] < min){
                min = prices[i];
            }else{
                max = Math.max(max, prices[i]-min);
            }
        }

        return max;
   }

   static int maxProfit2(int[] pricess) {
        if(pricess == null || pricess.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int price : pricess) {
            if(price < min) {
                min = price;
            } else {
                max = Math.max(max, price - min);
            }
        }

        return max;
    }

}