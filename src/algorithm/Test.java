package algorithm;

import java.util.*;

/**
 * author: lllddd
 * created on: 2021/9/4 13:24
 * description:
 */
public class Test {
    class MyStack {
        private Queue<Integer> queue1 = new LinkedList<>();
        private Queue<Integer> queue2 = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            queue1.add(x);
            queue2.clear();

            Integer[] array;
            array = queue1.toArray(new Integer[0]);

            for (int i = array.length - 1; i >= 0; i--) {
                queue2.add(array[i]);
            }
        }

        public int pop() {
            // TODO: 2021/10/30  
            return queue2.poll();
        }

        public int top() {
            // TODO: 2021/10/30  
            return queue2.peek();
        }

        public boolean empty() {
            return queue2.isEmpty();
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
//        System.out.println(isPowerOfTwo(1000));

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        

    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1 || n == 2) {
            return true;
        }

        if (n % 2 == 1) {
            return false;
        }

        return isPowerOfTwo(n / 2);
    }

    public static List<String> summaryRanges(int[] nums) {
        int start = 0;

        List<String> list = new ArrayList<>();

        for (int i = start; i < nums.length; ) {
            if (i + 1 < nums.length && nums[i] + 1 != nums[i + 1]) {
                if (start == i) {
                    list.add("" + nums[i]);
                } else {
                    list.add(nums[start] + "->" + nums[i]);
                }

                start = i + 1;
            } else if (start == nums.length - 1 && i == nums.length - 1) {
                list.add("" + nums[i]);
            } else if (i == nums.length - 1) {
                list.add(nums[start] + "->" + nums[i]);
            }
            i++;
        }

        return list;
    }

    public static boolean isSubsequence(String s, String t) {
        int anchor = 0;

        for (int i = 0; i < s.length(); i++) {
            String c = "" + s.charAt(i);

            String newT = t.substring(anchor, t.length());
            int index = newT.indexOf(c);
            if (index == -1) {
                return false;
            } else {
                anchor = index + 1 + (t.length() - newT.length());
            }
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(new ListNode(head.val));
            head = head.next;
        }

        ListNode newNode = new ListNode();
        ListNode currentNode = newNode;

        while (!stack.isEmpty()) {
            currentNode.next = stack.pop();
            currentNode = currentNode.next;
        }

        return newNode.next;
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode();
        ListNode currentNode = newHead;

        while (head != null) {
            if (head.val == val) {
                head = head.next;
            } else {
                currentNode.next = new ListNode(head.val);
                head = head.next;
                currentNode = currentNode.next;
            }
        }

        return newHead.next;
    }

    public static boolean isHappy(int n) {
        try {
            if (n == 1) {
                return true;
            }

            Set<Long> set = new HashSet<>();
            set.add((long) n);
            return __isHappy(n, set);
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean __isHappy(long n, Set<Long> set) {
        String s = String.valueOf(n);

        int len = s.length();
        long sum = 0;

        for (int i = 0; i < len; i++) {
            sum += Math.pow(Integer.parseInt("" + s.charAt(i)), 2);
        }

        if (set.contains(sum)) {
            return false;
        } else {
            set.add(sum);
        }

        if (sum == 1L) {
            return true;
        } else if (sum > Integer.MAX_VALUE) {
            return false;
        } else {
            return __isHappy(sum, set);
        }
    }
}
