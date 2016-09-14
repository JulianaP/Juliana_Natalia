
package Test;

import br.calebe.ticketmachine.core.PapelMoeda;
import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 31210856
 */
public class TesteIT{
    PapelMoeda itTroco = new PapelMoeda();

    @Test
    public void test() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
        TicketMachine test = new TicketMachine(2);
        Assert.assertEquals(0, test.getSaldo());
        test.inserir(10);
        test.inserir(20);
        test.inserir(100);
        Assert.assertEquals(130, test.getSaldo());
        String aux = test.imprimir();
        Assert.assertEquals("\n --- R$ 128,00 \n --- ", aux);

        PapelMoeda pm;
        Iterator <PapelMoeda> itTroco;
        itTroco = test.getTroco();
        while (itTroco.hasNext()) {
            pm = itTroco.next();
            System.out.print(pm.getQuantidade() + " ");
            System.out.println(pm.getValor());
        }

    }
}
    
