package spelling;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class NearbyWordsTester {

    private String dictFile = "data/words.small.txt";
    String word = "i";

    @Before
    public void setUp() throws Exception {
        Dictionary dict = new DictionaryHashSet();

        DictionaryLoader.loadDictionary(dict, dictFile);

    }

    @Test
    public void testSubstitution() {

    }

    @Test
    public void testInsertions() {

    }

    @Test
    public void testDeletions() {

    }

    @Test
    public void testSuggestions() {

    }
 }
