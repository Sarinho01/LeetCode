package hard;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalOfNums = nums1.length + nums2.length;
        int[] allNums = new int[totalOfNums];

        System.arraycopy(nums1, 0, allNums, 0, nums1.length);
        int vectorPosition = nums1.length;
        for (int k : nums2) {
            allNums[vectorPosition] = k;
            vectorPosition++;
        }

        for (int i = 0; i < totalOfNums; i++) {
            for (int j = totalOfNums - 1; j > i; j--) {
                if(allNums[j] < allNums[j-1]){
                    swap(j, j-1, allNums);
                }
            }
        }

        if(totalOfNums % 2 == 0){
            double value01 = allNums[(totalOfNums/2)-1];
            double value02 = allNums[(totalOfNums/2)];
            return (value01+value02)/2;
        }

        return allNums[totalOfNums/2];




    }

    public static void swap(int position01, int position02, int[] vector){
        int bakcupValor01 = vector[position01];
        vector[position01] = vector[position02];
        vector[position02] = bakcupValor01;
    }
}
