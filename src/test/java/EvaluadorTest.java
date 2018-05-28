package test.java;


import org.junit.Test;

import main.java.EvaluadorPlaca;


public class EvaluadorTest {
	
	@Test
    public void testTrue() {
        EvaluadorPlaca evaluador = new EvaluadorPlaca();
        assert evaluador.evalua("fecha","xba5303","hora") == true;
    }
}