class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = defaultdict(list)
        ans = []

        for string in strs:
            counts = [0] * 26
            for char in string:
                counts[ord(char) - ord('a')] += 1
            result[tuple(counts)].append(string)
        
        for value in result.values():
            ans.append(value)
            
        return ans