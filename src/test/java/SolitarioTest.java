import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SolitarioTest {

    @Test
    public void testInicial() {

        Solitario solitario = new Solitario();

        int retorno = solitario.jugar();

        assertEquals(retorno, 1);
    }
}
