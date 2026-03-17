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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int k = lists.size();
        
        ListNode dummy(0);
        ListNode* head = &dummy;

        while(true) {
            int idx = -1;
            for (int i = 0; i < k; i++) {
                if (lists[i] == NULL) continue;

                if (idx == -1 || lists[i]->val < lists[idx]->val) {
                    idx = i;
                }
            }

            if (idx == -1) break;
            head->next = lists[idx];
            head = head->next;
            lists[idx] = lists[idx]->next;
        }

        return dummy.next;
    }
};