package Projects;
import java.util.*;
public class TextCompression {
	HashMap<Character, String> encoder=new HashMap<>();
    HashMap<String, Character> decoder=new HashMap<>();
    
    private class Node implements Comparable<Node> {
        Character data;
        int cost; 
        Node left;
        Node right;

        public Node(Character data, int cost) {
          this.data = data;
          this.cost = cost;
          this.left = null;
          this.right = null;
        }

        @Override
        public int compareTo(Node other) {
          return this.cost - other.cost;
        }
      }

      public TextCompression(String s) throws Exception {
        HashMap<Character, Integer> freqmap = new HashMap<>();

        for(int i=0; i < s.length(); i++) {
          char ch = s.charAt(i);
          if(freqmap.containsKey(ch)) {
            int count = freqmap.get(ch);
            count += 1;
            freqmap.put(ch, count);
          } else {
            freqmap.put(ch, 1);
          }
        }
        
        Heap<Node> minHeap = new Heap<>();
        Set<Map.Entry<Character, Integer>> entrySet = freqmap.entrySet();

        for(Map.Entry<Character, Integer> entry : entrySet) {
          Node node = new Node(entry.getKey(), entry.getValue());
          minHeap.insert(node);
        }

        while(minHeap.size() != 1) {
          Node first = minHeap.remove();
          Node second = minHeap.remove();

          Node newNode = new Node('\0', first.cost + second.cost);
          newNode.left = first;
          newNode.right = second;

          minHeap.insert(newNode);
        }

        Node r = minHeap.remove();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncoderDecoder(r, "");
      }

      private void initEncoderDecoder(Node node, String up) {
        if(node == null) {
          return;
        }
        if(node.left == null && node.right == null) {
          this.encoder.put(node.data, up);
          this.decoder.put(up, node.data);
        }
        initEncoderDecoder(node.left, up+"0");
        initEncoderDecoder(node.right, up+"1");
      }

      public String encode(String s) {
        String ans = "";

        for(int i=0; i<s.length(); i++) {
          ans = ans + encoder.get(s.charAt(i));
        }
        
        return ans;
      }

      public String decode(String s) {
        String key = "";
        String ans = "";
        for(int i=0; i<s.length(); i++) {
          key = key + s.charAt(i);
          if(decoder.containsKey(key)) {
            ans = ans + decoder.get(key);
            key = "";
          }
        }
        return ans;
      }

}
