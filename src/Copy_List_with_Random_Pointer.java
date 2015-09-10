import java.util.HashMap;

/**
 *A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.
 */
//该题意思是copy当前的list，用hashmap分别存储旧、新该点，然后重新根据规则定义新点，返回value
public class Copy_List_with_Random_Pointer {
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
        public RandomListNode copyRandomList(RandomListNode head){
            HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
            RandomListNode node = head;
            while(node!=null){
                map.put(node,new RandomListNode(node.label));
                node = node.next;
            }
            for (RandomListNode cur: map.keySet()){
                //define next pointer
                RandomListNode nextNode = cur.next;
                map.get(cur).next = map.get(nextNode);
                //define random pointer
                RandomListNode randomNode = cur.random;
                if(randomNode!=null){
                    map.get(cur).random = map.get(randomNode);
                }

            }

            return map.get(head);
        }
}

class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
     }