package com.tp.utils;

public class ScreenPop {
	
	private String OpcionMenu;
	public String getOpcionMenu() {
		return OpcionMenu;
	}
	public void setOpcionMenu(String parameter) {
		OpcionMenu = parameter;
	}
	
	private String PacienteHospitalizado;
	public String getPacienteHospitalizado() {
		return PacienteHospitalizado;
	}
	public void setPacienteHospitalizado(String parameter) {
		PacienteHospitalizado = parameter;
	}
	
	private String VieneConSillaRuedasMuletasOtro;
	public String getVieneConSillaRuedasMuletasOtro() {
		return VieneConSillaRuedasMuletasOtro;
	}
	public void setVieneConSillaRuedasMuletasOtro(String parameter) {
		VieneConSillaRuedasMuletasOtro = parameter;
	}

	private String AsisteConEsquemaSeguridad;
	public String getAsisteConEsquemaSeguridad() {
		return AsisteConEsquemaSeguridad;
	}
	public void setAsisteConEsquemaSeguridad(String parameter) {
		AsisteConEsquemaSeguridad = parameter;
	}
	
	public ScreenPop()
	{
		OpcionMenu = "";
		PacienteHospitalizado = "";
		VieneConSillaRuedasMuletasOtro = "";
		AsisteConEsquemaSeguridad = "";
	}
}
