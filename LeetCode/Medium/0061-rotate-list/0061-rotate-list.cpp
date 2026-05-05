/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if (!head || k == 0) return head;
        
        // Find the length of the list
        ListNode* a = head;
        int l = 1;
        while (a->next) {
            l++;
            a = a->next;
        }

        // Connect the tail to the head to make it a circular list
        a->next = head;

        // Adjust k to be within the bounds of the list length
        k = k % l;
        k = l - k;

        // Find the new head position
        ListNode* newTail = head;
        for (int i = 1; i < k; i++) {
            newTail = newTail->next;
        }

        // Set the new head and break the loop
        ListNode* newHead = newTail->next;
        newTail->next = nullptr;

        return newHead;
    }
};
