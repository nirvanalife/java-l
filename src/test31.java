public class test31 {
//    每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
//    HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
//    首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
//    每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....
//    直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
//    请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
//
//    如果没有小朋友，请返回-1
//    思路：循环链表，val为编号，计数器count每次到下一个人+1，count=m-
//    删除当下节点，重置count直到只有一个节点（temp.next=temp)
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
        this.val = val;
    }
    }
    public static void main(String []arg){
        System.out.println(LastRemaining_Solution(8,3));
    }

    public static int LastRemaining_Solution(int n, int m) {
        if(n<=0){
            return -1;
        }
        ListNode l=new ListNode(0);
        ListNode ll=l;
        for (int i=1;i<n;i++) {
            ListNode temp = new ListNode(i);
            l.next = temp;

            if(i==n-1){
                temp.next=ll;
            }else{
                l = temp;
            }
        }
        ListNode temp=ll;

        int count=0;
        while(temp.next!=temp){
            ListNode t = null;
            while(count!=m-1){
                t=temp;
                temp=temp.next;
                count=count+1;
            }
            t.next=temp.next;
            temp=t.next;
            count=0;

        }

        return temp.val;
    }
}
