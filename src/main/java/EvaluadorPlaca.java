package main.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import main.dao.Matricula;

import java.io.Serializable;

@Named
@SessionScoped
public class EvaluadorPlaca implements Serializable {
	private static final long serialVersionUID = -8071960448893262602L;

	private Matricula matricula;

	@PostConstruct
	public void init() {
		matricula = new Matricula();
	}

	public void probar(Matricula matricula) {

		boolean bandera = false;
		bandera = evalua(matricula);

		if (bandera) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Car can't be on the road"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Car can be on the road"));
		}
	}

	public boolean evalua(Matricula matricula) {

		String fecha = matricula.getFecha();
		String placa = matricula.getPlaca();
		String hora = matricula.getHora();
		boolean bandera = false;

		int ultimaPosicion = placa.length() - 1;
		char ultimoDigito = placa.charAt(ultimaPosicion);

		if (validarPlaca(ultimoDigito)) {
			if (validarhora(hora)) {
				char diaObtenidoFecha = obtenerDia(fecha);
				bandera = validarPlaca(ultimoDigito, diaObtenidoFecha);

			}
		} else {
			bandera = true;
		}

		return bandera;

	}

	private boolean validarPlaca(char ultimoDigito) {
		boolean resultado;
		String valor = Character.toString(ultimoDigito);

		try {
			Integer.parseInt(valor);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Invalid License plate number"));

		}

		return resultado;
	}

	private boolean validarhora(String hora) {
		String inicio = hora.substring(0, 2);
		String fin = hora.substring(3, 5);
		String cadena = inicio + fin;
		int horaValidar = Integer.parseInt(cadena);

		if (((horaValidar < 931) && (horaValidar > 659)) || ((horaValidar < 1930) && (horaValidar > 1600))) {
			return true;
		}

		return false;
	}

	@SuppressWarnings("deprecation")
	private char obtenerDia(String fecha) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		char dia = 0;

		Date date;
		try {
			date = formatter.parse(fecha);
			int capturarDia = date.getDay();
			dia = Character.forDigit(capturarDia, 10);
			return dia;
		} catch (ParseException e) {
			System.out.println("Error al convertir fecha" + e);
		}

		return dia;

	}

	private boolean validarPlaca(char ultimoDigito, char diaObtenidoFecha) {
		String day = "";
		String hours = "Pico y Placa between '07:00-9:30' and '16:00-19:30'";
		if ((ultimoDigito == '1' || ultimoDigito == '2') && diaObtenidoFecha == '1') {
			day = "Moday";
			return true;
		}
		if ((ultimoDigito == '3' || ultimoDigito == '4') && diaObtenidoFecha == '2') {
			day = "Tuesday";
			return true;

		}
		if ((ultimoDigito == '5' || ultimoDigito == '6') && diaObtenidoFecha == '3') {
			day = "Wednesday";
			return true;
		}
		if ((ultimoDigito == '7' || ultimoDigito == '8') && diaObtenidoFecha == '4') {
			day = "Thursday";
			return true;
		}
		if ((ultimoDigito == '0' || ultimoDigito == '9') && diaObtenidoFecha == '5') {
			day = "Friday";
			return true;
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", day + hours));
		return false;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

}
