class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        memo = {}
        ans = 0
        if not nums:
            return ans
            
        for i in range(len(nums)):
            memo[nums[i]] = -1 #-1은 아직 참조되지 않았음을 의미 (value값은 그 수부터 오름차순으로 연속된 숫자들의수)

        for j in range(len(nums)):           
            #참조된적 없는 nums 원소들 체크하고, 이 수부터 오름차순으로 sequence 찾기 시작
            #최초 참조시 value를 0으로 변경
            if memo[nums[j]] == -1 :
                findSeq = nums[j]
                memo[nums[j]] = 0
                while findSeq+1 in memo :
                    if memo[findSeq + 1] == -1 :
                        memo[nums[j]] += 1
                        memo[findSeq+1] = 0 # 이미 참조가 되었다는 것은 이 수보다 작은 연속적인 수가 존재한다는 뜻. 따라서 참조가 된 수는 무시하면 된다.
                    else :
                        memo[nums[j]] += 1 + memo[findSeq + 1]
                        break
                    findSeq += 1
                if ans < memo[nums[j]]:
                    ans = memo[nums[j]]

            else :
                continue
        return ans + 1
