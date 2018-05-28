package main.java;

public class EvaluadorPlaca {

	private static final char LUNES = '1';
	private static final char MARTES = '2';
	private static final char MIERCOLES = '3';
	private static final char JUEVES = '4';
	private static final char VIERNES = '5';

	public boolean evalua(String fecha, String placa, String hora) {

		int ultimaPosicion = placa.length() - 1;
		char ultimoDigito = placa.charAt(ultimaPosicion);

		char diaObtenidoFecha = 2;
		boolean bandera = validarPlaca(ultimoDigito, diaObtenidoFecha);

		return bandera;
	}

	private boolean validarPlaca(char ultimoDigito, char diaObtenidoFecha) {
		if (ultimoDigito == diaObtenidoFecha) {
			return true;
		}
		return false;
	}

}
