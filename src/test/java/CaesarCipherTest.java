import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CaesarCipherTest {

    @Test
    public void test1() {
        String u = "I should have known that you would have a perfect answer for me!!!";
        List<String> v = Arrays.asList("J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!");
        int shift = 2;
        assertEquals(v, CaesarCipher.movingShift(u, shift));
        assertEquals(u, CaesarCipher.demovingShift(CaesarCipher.movingShift(u, shift), shift));
    }

    @Test
    public void test2() {
        String u = "uaoQop jx eh osr okaKv vzagzwpxagokBKriipmc U";
        List<String> v = Arrays.asList("wdsVuw sh", " qu dii h", "evGs uzbi", "caudhoxuM", "Wewxfdu O");
        assertEquals(v, CaesarCipher.movingShift(u, 2));
    }

}
