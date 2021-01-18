package main.java.com.joe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
	static Node root;
	
	public static void add(int val)
	{
		if(root==null)
		{
			root=new Node(val);
		}
		System.out.println("Root is "+root.value);
		Node focus = root;
		while(focus.left!=null)
		{
			focus=focus.left;
		}
		//Node newN = 
		focus.left=new Node(val);
		System.out.println("New node "+focus.left.value);
		
	}
	
	public static Queue<Node> inOrder(Node n)
	{
		Queue<Node> qu = new LinkedList<>();
		if(n!=null)
		{
			inOrder(n.left);
			//System.out.println(n.value);
			qu.add(n);
			inOrder(n.right);
		}
		return qu;
	}
	
	public static String reverseParagraph(String paragraph)
	{
		String[] para= paragraph.split(" ");
		StringBuffer str = new StringBuffer("");
		for(int i=0;i<para.length;i++)
		{
			para[i]=new StringBuffer(para[i]).reverse().append(" ").toString();
			str.append(para[i]);
		}
		return str.toString();
	}
	
	public static boolean isPalindromePermutation(String s)
	{
		String lower = s.toLowerCase();
		HashMap<Character,Integer> map = new HashMap<>();
		int length = s.length();
		int oddCount=0;
		for(int i=0;i<length;i++)
		{
			map.put(lower.charAt(i), map.getOrDefault(lower.charAt(i), 0)+1);
			if(map.get(lower.charAt(i))%2==0)
			{
				if(oddCount>0)
				{
					oddCount--;
					continue;
				}
			}
				oddCount++;
		}
		System.out.println(map.toString());
		if(length%2==0)
		{
			if(oddCount>0)
			{
				
				return false;
			}
		}
		else
		{
			if(oddCount%2==0)
			{
				return false;
			}
			if(oddCount==length)
				return false;
		}
		return true;
	}
	
	public static boolean isUnique(String s)
	{
		char[] str = s.toCharArray();
		int difference=-27;
		Arrays.sort(str);
		for(char c:str)
		{
			if(difference==-27)
			{
				difference=c-'a';
			}
			else
			{
				if(difference-(c-'a')==0)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean checkPerm(String s1,String s2)
	{
		if(s1.length()!=s2.length())
			return false;
		int[] chr = new int[25];
		for(int i=0;i<s1.length();i++)
		{
			chr[s1.charAt(i)-'a']++;
			chr[s2.charAt(i)-'a']++;
		}
		for(int c: chr)
		{
			if(c%2!=0)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static String stringCompression(String s)
	{
		StringBuffer b = new StringBuffer();
		b.append(s.charAt(0));
		System.out.println("String builder "+b);
		int count =1;
		for(int i=1;i<s.length();i++)
		{
			if(s.charAt(i)==s.charAt(i-1))
			{
				count++;
			}
			else
			{
				b.append(count);
				count=1;
				b.append(s.charAt(i));
				if(b.length()>s.length())
				{
					return s;
				}
			}
			//b.append(s.charAt(i));
		}
		return b.append(count).length()>=s.length()?s:b.toString();
	}
	
	public static int[][] setMatrix(int[][] arr)
	{
		int totalCells = arr.length*arr[0].length;
		HashSet<List<Integer>> set = new HashSet<>();
		Queue<int[]>qu = new LinkedList<>();
		for(int i=0;i<arr.length;i++)
		{
			for(int j = 0;j<arr[0].length;j++)
			{
				if(arr[i][j]==0)
				{
					
					List<Integer> lst = new ArrayList<>();
					lst.add(i);
					lst.add(j);
					//if(!set.contains(lst))
					set.add(lst);
					qu.offer(new int[] {i,j});
					
				}
			}
		}
			
			while(!qu.isEmpty())
			{
				int[] elem = qu.poll();
				int row = elem[0];
				int col = elem[1];
				int runningCol = 0;
				while(runningCol<arr[0].length)
				{
					arr[row][runningCol]=0;
					
					if(set.size()==totalCells)
					{
						return arr;
					}
					else
					{
						List<Integer> lst = new ArrayList<>();
						lst.add(row);
						lst.add(runningCol);
						//if(!set.contains(lst))
						set.add(lst);
					}
					runningCol++;
				}
				int runningRow=0;
				while(runningRow<arr.length)
				{
					arr[runningRow][col]=0;
					if(set.size()==totalCells)
					{
						return arr;
					}
					else
					{
						List<Integer> lst = new ArrayList<>();
						lst.add(runningRow);
						lst.add(col);
						//if(!set.contains(lst))
						set.add(lst);
					}
					runningRow++;
				}
			}
			
		//}
		return arr;
	}
	
	public static boolean isPalindrome(Node head)
	{
		Node second=head,first=head;
		int count=0;
		while(second.child!=null)
		{
			if(second.child.child!=null)
			{
				second=second.child.child;
				first=first.child;
				count++;
			}
			
			  else {
				  second=second.child;
				  count++;
			  
			  }
			 
		}
		first=first.child;
		second=head;
		System.out.println("First is "+first.value);
		System.out.println("second is "+second.value);
		int[] firstArray = new int[count],secondArray = new int[count];
		for(int i=0;i<count;i++)
		{
			firstArray[i]=first.value;
			first=first.child;
			secondArray[i]=second.value;
			second=second.child;
		}
		for(int i=0,j=firstArray.length-1;i<firstArray.length;i++,j--)
			
		{
			System.out.println("Value of secondArray[i] at index "+i+" is"+secondArray[i]);
			System.out.println("Value of firstArray[j] at index "+j+" is"+firstArray[j]);
			if(firstArray[j]!=secondArray[i])
			{
				return false;
			}
		}
		return true;
	}
	
	
	
	public static String urlify(String url)
	{
		char[] c = url.toCharArray();
		int length=url.length();
		int lastNonSpaceIndex=-1;
		for(int i=length-1;i>=0;i--)
		{
			if(url.charAt(i)!=' ')
			{
				if(lastNonSpaceIndex==-1)
				{
					
					lastNonSpaceIndex=i;
					System.out.println("lastNonSpaceIndex "+lastNonSpaceIndex);
					i=length-1;
					c[i]=url.charAt(lastNonSpaceIndex);
					lastNonSpaceIndex--;
					//continue;
				}
				else
				{
					c[i]=url.charAt(lastNonSpaceIndex);
					lastNonSpaceIndex--;
					
					
				}
			}
			else
			{
				if(lastNonSpaceIndex==-1)
				{
					continue;
				}
				else
				{
					c[i]='0';i--;c[i]='2';i--;c[i]='%';
					lastNonSpaceIndex--;
				}
			}
			
		}
		return new String(c);
	}

	public static void main(String[] args) {
				Node head = new Node(2);
				Node first = new Node(1);
				head.child=first;
				Node second = new Node(5);
				first.child=second;
				Node third = new Node(1);
				second.child=third;
				Node fourth = new Node(2);
				third.child=fourth;
				//Node first = new Node(2);
				//Node first = new Node(2);
				//Node first = new Node(2);
				System.out.println(isPalindrome(head));

	}
	
	

}
class Node
{
	Node left;
	Node right;
	int value;
	Node(int val)
	{
		this.value=val;
	}
	Node child;
}

/**
Problem 1
—————


Insert a value val in BST which does not exist in it.

**************************************
                    val = 29
    				

      12
    /    \
 9       19
             \
	      			21

				||
				\/

      12
    /    \
 9       19
             \
	      			21
                 \
	           			29

******************************************

val = 5

 None  
  ||
  \ /

  5


**************************************
                    val = 7
    				

      12
    /    \
 9       19
             \
	      			21

			||
			\/

      12
    /    \
 9       19
/             \
7	      			21
      

******************************************
*/


    
    
	/*
	 * 1. If root not present then just create a node with the value and return 2)
	 * Assign this root to something called focusNode 3) While the focusNode is not
	 * null a. if(leftchild of focus is greater than value) prevNode=focusNode a1.
	 * we can basically chnage the focusnode to leftchild. b. else 1. focusNode to
	 * rightChild
	 * 
	 * 4) Outside while
	 */

Node insert(root, val){
    if(root==null)
      return new TreeNode(val);
    TreeNode focusNode = root;
    TreeNode prevNode = null;
    while(focusNode!=null)
    {
      prevNode=focusNode;
      if(focusNode.left!=null && focusNode.left.val>val)
      {
        
        focusNode=focusNode.left;
      }
      else
      {
        //prevNode=focusNode;
        focusNode=focusNode.right;
      }
    }
    TreeNode child = new TreeNode(val);
    if(prevNode.val>val)
    {
      
    	prevNode.left=child;
    }
    else
      prevNode.right=child;
    
    return root;
  }

class TreeNode{
	int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int value)
  {
    this.val=val;
  }

  }
	
