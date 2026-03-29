class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        parMap = { ")" : "(", "]" : "[", "}" : "{" }
        for char in s:
            if char in parMap:
                if stack and stack[-1] == parMap[char]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(char)    
        if not stack:
            return True
        else:
            return False