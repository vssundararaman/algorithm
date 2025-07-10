package google.medium;

public class RainTrappingWater {
    public static void main(String[] args) {

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println( trap(height));
    }

    static int trap(int[] height) {
        int water = 0;

        if ( height == null || height.length == 0){
            return water;
        }

        int left = 0, right = height.length -1, level = 0;

        while (left < right) {

            int lowerBuilding = height[ height[left] < height[right] ? left++ : right--];

            level = Math.max(level, lowerBuilding);

            water += level - lowerBuilding;

        }

        return water;
    }
}
