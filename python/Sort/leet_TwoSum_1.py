class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        sort_nums = sorted(nums)
        start = 0
        end = len(nums) - 1
        while True :
            if sort_nums[start] + sort_nums[end] > target:
                end -= 1
            elif sort_nums[start] + sort_nums[end] < target:
                start += 1
            else :
                first = nums.index(sort_nums[start])
                second = nums.index(sort_nums[end])
                if first == second:
                    second = nums.index(sort_nums[end],second+1,len(nums))
                return list([first,second])