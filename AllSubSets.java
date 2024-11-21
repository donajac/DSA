import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AllSubSets {
    public static ArrayList<ArrayList<Integer>> genAllSubSet(int[] nums){
        Map<Integer,ArrayList<ArrayList<Integer>>> map = new HashMap<>();
        return helper(nums, 0, map);
    }
    public static ArrayList<ArrayList<Integer>> helper(int[] nums, int index, Map<Integer, ArrayList<ArrayList<Integer>>> map){
        if(map.containsKey(index)) return map.get(index);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(index == nums.length) {
            ArrayList<ArrayList<Integer>> baseCase = new ArrayList<>();
            baseCase.add(new ArrayList<>());
            return baseCase;
        }
        //Exclude
        ArrayList<ArrayList<Integer>> subSetsCreatedOnExclude = helper(nums, index + 1, map);
        //Include the current index
        result.addAll(subSetsCreatedOnExclude);
        System.out.println("re:"+result);
        // append all the subsets with the current element
        for (ArrayList<Integer> subset : subSetsCreatedOnExclude) {
            ArrayList<Integer> includedSubset = new ArrayList<>(subset);
            includedSubset.add(nums[index]);
            result.add(includedSubset);
            System.out.println("res2:"+result);
        }
        map.put(index, result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(genAllSubSet(nums));
    }


}
