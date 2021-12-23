import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Node
{

    Integer val;
    List<Node> children;

    public Node(Integer val)
    {
        this.val = val;
        children = new ArrayList<>();
    }

}

class ConstructNTree
{

	/*
[1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
	*/

    public Node construct(List<String> list)
    {
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.valueOf(list.get(0)));
        queue.add(root);
        int i = 2;
        while( !queue.isEmpty())
        {
            int size = queue.size();
            int element = 0;
            Node current = null;
            List<Node> level = new ArrayList<>();
            while(element < size)
            {
                 current = queue.remove();

                while(i < list.size()  && !list.get(i).equals("null") )
                {
                    level.add(new Node(list.get(i) .equals("null") ? null : Integer.valueOf(list.get(i++))));
                }
               i++; // To Skip the Null
                element++;
            }
            current.children = level;
            queue.addAll(level);


        }
        return root;
    }

    public void bfs(Node root)
    {
        List<List<Integer>>   allLevels = new LinkedList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size  = queue.size(); // size : 4
            int i = 0;
            List<Integer> level = new LinkedList<>();
            while( i < size)
            {
                Node current = queue.remove();
                level.add(current.val);
                queue.addAll(current.children);
                i++;
            }
            allLevels.add(level);

        }

        System.out.println(allLevels);
    }
}

public class NTreeBFS
{
    public static void main(String[] args) {


        String input = "1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14";
        String[] data = input.split(",");
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < data.length ; i++)
        {

                list.add(data[i]);

        }
        ConstructNTree tree = new ConstructNTree();
        Node root = tree.construct(list);
        tree.bfs(root);

    }
}





