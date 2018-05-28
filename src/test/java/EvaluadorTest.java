package test.java;


import org.junit.Test;

import main.dao.Matricula;
import main.java.EvaluadorPlaca;


public class EvaluadorTest {
	
	@Test
    public void testOk() {
        EvaluadorPlaca evaluador = new EvaluadorPlaca();
        Matricula matricula = new Matricula();
        matricula.setPlaca("xba5303");
        matricula.setHora("10:40");
        matricula.setFecha("29-05-2018");
        
        assert evaluador.evalua(matricula) == false;
    }
	
	@Test
    public void testBad() {
        EvaluadorPlaca evaluador = new EvaluadorPlaca();
        Matricula matricula = new Matricula();
        matricula.setPlaca("xba5303");
        matricula.setHora("07:40");
        matricula.setFecha("29-05-2018");
        
        assert evaluador.evalua(matricula) == false;
    }
	
	@Test
    public void testBadLicensePlateNumber() {
        EvaluadorPlaca evaluador = new EvaluadorPlaca();
        Matricula matricula = new Matricula();
        matricula.setPlaca("xba");
        matricula.setHora("07:40");
        matricula.setFecha("29-05-2018");
        
        assert evaluador.evalua(matricula) == false;
    }
	
	
}