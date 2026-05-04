# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        
        def nextNode(transfer: Boolean, l1: Optional[ListNode], l2: Optional[ListNode]):
            if l1 or l2: 
                nodeValue = (l1.val if l1 else 0) + (l2.val if l2 else 0) + (1 if transfer else 0)
                newTransfer = nodeValue > 9
                nodeValue = nodeValue - 10 if newTransfer else nodeValue
                return ListNode(nodeValue, nextNode(
                    newTransfer, 
                    l1.next if l1 else None, 
                    l2.next if l2 else None))
            
            return ListNode(1, None) if transfer else None 
               
            
        if l1 is None:
            return l2
        if l2 is None:
            return l1

        return nextNode(False, l1, l2)
  

if __name__ == "__main__":
    sol = Solution()
    print(sol.twoSum([2,5,5,11], 10))