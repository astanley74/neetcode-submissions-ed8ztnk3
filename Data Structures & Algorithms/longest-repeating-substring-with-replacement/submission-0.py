class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        dic = {}
        left = max_freq = max_length = 0

        for right in range(len(s)):
            dic[s[right]] = dic.get(s[right], 0) + 1
            max_freq = max(max_freq, dic[s[right]])

            while max_freq + k < right - left + 1:
                dic[s[left]] -= 1
                left += 1
            max_length = max(max_length, right - left + 1)
        return max_length