package behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author sunsingh
 */
public class IteratorApp2 {

    public static void main(String[] args) {
        SCollection collection = new SCollection();
        for (String item : collection) {
            System.out.println("ITEM : " + item);
        }
    }
}

class SCollection implements Iterable<String> {

    private final List<String> list = new ArrayList<>();

    SCollection() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
    }

    // comments goes here
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return (currentIndex < list.size() - 1);
            }

            @Override
            public String next() {
                currentIndex++;
                return list.get(currentIndex);
            }

            @Override
            public void remove() {
                list.remove(currentIndex);
            }
        };
    }

    assertFalse(allEven);
    assertTrue(oneEven);
    assertFalse(noneMultipleOfThree);
    
}

First version prints out:

1
2
3
4
5
0
5
4
3
2
1
0