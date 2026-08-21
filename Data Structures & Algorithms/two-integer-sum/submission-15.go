func twoSum(nums []int, target int) []int {
    
    // make stands for new at java
    // map -> hashmap [int]int
    numsMap := make(map[int]int)
    
    for i, v := range nums {
        // i stands for index
        // v stands for value

        sum := target - v;
        if value, exists := numsMap[sum]; exists {
            return []int{value, i};
        }

        numsMap[v] = i;    
    }


    return []int{}
}
